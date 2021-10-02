package condominio.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import condominio.entities.Cliente;
import condominio.entities.Dados;
import condominio.entities.Empresa;
import condominio.entities.Endereco;
import condominio.entities.Servico;
import condominio.entities.ServicoPeriodico;
import condominio.entities.Telefone;
import condominio.entities.enums.Status;
import condominio.entities.enums.TiposDeServico;
import condominio.entities.enums.TiposDeTelefone;
import condominio.exceptions.ProgramException;
public class UI {
	
	protected static boolean clienteExiste(Cliente cliente) {
		if(cliente != null) {
			return true;
		}
		return false;
	}
	
	private static boolean aceita (Scanner sc) {
		char ch = sc.next().toLowerCase().charAt(0);	
		
		if (ch == 's') {
			return true;
		}
		return false;
	}

	protected static void checaCliente(Cliente cliente) {
		if (cliente == null) {
			throw new ProgramException("Adicione um cliente");

		}
	}

	protected static Cliente addDadosCondominio(Cliente cliente, Scanner sc) {

		Dados dados = criaDados(cliente, sc);
		cliente = (Cliente) dados;

		System.out.print("Sindico: ");
		cliente.setSindico(sc.nextLine());

		return cliente;
	};

	protected static Servico criaServico(Scanner sc) {

		Servico servico = new Servico();

		System.out.print("É um serviço periódico? (s/n): "); // Mudar a pergunta??
		System.out.print(">>> ");

		if (aceita(sc)) {
			servico = new ServicoPeriodico();
		}

		addDadosServico(servico, sc);

		return servico;
	}

	private static void addDadosServico(Servico servico, Scanner sc) {

		servico.setTipo(TiposDeServico.pegaServicos(addTipos(sc)));

		servico.setEmpresa(criaEmpresa(sc));

		System.out.println("Deseja adicionar uma data específica? (S/N)");
		System.out.print(">>> ");

		if (aceita(sc)) {// alterar
			System.out.print("Data Inicial (DD/MM/YYYY): ");
			servico.setData(criaData(sc));

			if (servico instanceof ServicoPeriodico) {
				System.out.print("Proxima Data Inicial (DD/MM/YYYY): ");
				((ServicoPeriodico) servico).setNextDate(criaData(sc));
			}
		}

		addPreco(servico, sc);

		servico.setStatus(Status.pegaServicos(addStatus(sc)));

	};

	private static Dados criaDados(Dados dados, Scanner sc) {

		sc.nextLine();
		System.out.print("Nome: ");
		dados.setNome(sc.nextLine());

		dados.setEndereco(criaEndereco(sc));

		sc.nextLine();
		System.out.print("CNPJ: ");
		dados.setCnpj(sc.nextLine());

		return dados;
	}

	private static Endereco criaEndereco(Scanner sc) {

		Endereco endereco = new Endereco();
		
		System.out.println("Deseja adicionar o endereço?");
		System.out.print(">>> ");

		if (aceita(sc)) {
			addDadosEndereco(endereco, sc);
		}
		
		
		return endereco;

	};

	private static void addDadosEndereco(Endereco endereco, Scanner sc) {

		try { // Validar os endereco!!
			sc.nextLine();
			
			System.out.print("Rua: ");
			endereco.setRua(sc.nextLine());

			System.out.print("Numero: ");
			endereco.setNumero(sc.nextLine());

			System.out.print("CEP: ");
			endereco.setCep(sc.nextLine());

			System.out.print("Cidade: ");
			endereco.setCidade(sc.nextLine());

			System.out.print("Estado: ");
			endereco.setEstado(sc.nextLine());

			System.out.print("Pais: ");
			endereco.setPais(sc.nextLine());

		} catch (ProgramException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
			addDadosEndereco(endereco, sc);
		}

	}

	private static Telefone criaNoTelefone(Scanner sc) {

		Telefone telefone = new Telefone();

		sc.nextLine();
		addDadosTelefone(telefone, sc);

		return telefone;

	};

	private static void addDadosTelefone(Telefone telefone, Scanner sc) {

		try {
			System.out.println("Tipo: \n1 - FIXO \n2 - CELULAR ");
			System.out.print(">>> ");
			telefone.setTipo(TiposDeTelefone.pegaTelefones(sc.nextLine()));

			System.out.print("DDD: ");
			telefone.setDdd(sc.nextLine());

			System.out.print("Numero: ");
			telefone.setNumero(sc.nextLine());
		} catch (ProgramException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
			addDadosTelefone(telefone, sc);
		}

	}

	private static String addTipos(Scanner sc) {

		String[] tipos = { "1 - MANUTENÇÃO", "2 - PINTURA", "3 - LIMPEZA", "4 - SUBSTITUIÇÃO" };

		for (String lista : tipos) {
			System.out.println(lista);
		}

		System.out.print("Tipo: ");
		String valor = sc.next();

		return valor;
	}

	private static Empresa criaEmpresa(Scanner sc) {

		Empresa empresa = new Empresa();

		addDadosEmpresa(empresa, sc);

		return empresa;
	};

	private static void addDadosEmpresa(Empresa empresa, Scanner sc) {

		Dados dados = criaDados(empresa, sc);
		empresa = (Empresa) dados;

		System.out.println("Deseja adicionar um numero? (S/N)");
		char ch = sc.next().toLowerCase().charAt(0);

		if (ch == 's') {

			Telefone telefone = criaNoTelefone(sc);
			empresa.addNumber(telefone);
		}

	}

	protected static Date criaData(Scanner sc) {

		Date data = new Date();

		modificaData(data, sc);

		return data;
	}

	private static void modificaData(Date data, Scanner sc) {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			data = sdf.parse(sc.next());
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		}

	};

	private static void addPreco(Servico servico, Scanner sc) {

		try {
			System.out.print("Preço do serviço R$: ");
			servico.setPreco(sc.nextDouble());
		} catch (ProgramException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
			addPreco(servico, sc);
		}
		sc.nextLine();
	};

	private static String addStatus(Scanner sc) {

		System.out.println("Status: \n1 - NAO_INICIADO \n2 - INICIADO \n3 - COMPLETADO \n4 - OUTROS: ");
		System.out.print(">>> ");
		String valor = sc.nextLine();

		return valor;
	};

}
