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


public class UI {
	
	
	public static void clearScreen() { 
		 //System.out.print("\033[H\033[2J"); 
		 System.out.flush(); 
		} 
	
	public static Cliente criaCondominio(Cliente cliente, Scanner sc) {

		Dados dados = adicionaDados(cliente, sc);
		cliente = (Cliente) dados;
		
		System.out.print("Sindico: ");
		cliente.setSindico(sc.nextLine());
		
		return cliente;
	};
	
	public static Servico criaServico(Scanner sc) throws ParseException {
		
		
		Servico servico = new Servico();
		
		System.out.print("É um serviço periódico? (s/n): "); // Mudar a pergunta??
		char ch = sc.next().toLowerCase().charAt(0);
		if (ch == 's') {
			servico = new ServicoPeriodico();
		}
		
		// Tipo do serviço
		servico = addTipos(servico, sc);
		
		// Dados da empresa
		
		servico.setEmpresa(addEmpresa(sc)); 
			
		// Datas do servico
		System.out.println();
		System.out.print("Data Inicial (DD/MM/YYYY): ");
		servico.setData(addData(sc));
		
		if(servico instanceof ServicoPeriodico) {
			System.out.print("Proxima Data Inicial (DD/MM/YYYY): ");
			((ServicoPeriodico)servico).setNextDate(addData(sc));
			
		}
		
		// Preço
		Double preco;
		do {
			
			preco = Preco(sc);
			servico.setPreco(preco);
			
		}while (servico.testaPreco(preco));
		// Status 
		
		servico = addStatus(servico, sc);
		
		//VER MÉTODO TO STRING
		return servico;
	};

	public static Dados adicionaDados(Dados dados, Scanner sc) {
		
		Endereco endereco = new Endereco();
		
		System.out.print("Nome: ");
		sc.nextLine();
		dados.setNome(sc.nextLine());
		
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
		
		System.out.print("CNPJ: ");
		dados.setCnpj(sc.nextLine());
		
		dados.setEndereco(endereco);
	
		return dados;
		
	};
	
	
	public static Telefone adicionaTelefone(Scanner sc) {
		
		Telefone telefone = new Telefone();
		
		System.out.println(">>Telefone<< ");
		
		System.out.print("Tipo: ");
		sc.nextLine();
		telefone.setTipo(sc.nextLine());
		
		System.out.print("DDD: ");
		telefone.setDdd(sc.nextLine());
		
		System.out.print("Numero: ");
		telefone.setNumero(sc.nextLine());
		
		return telefone;
		
	};
	
	public static Servico addTipos(Servico servico, Scanner sc) {
		
		String[] tipos = {"1 - Manutenção", 
						"2 - Pintura",
						"3 - Limpeza",
						"4 - Troca"};
		
		System.out.println(">>Tipo de serviço<<");
		
		for(String lista : tipos) {
			System.out.println(lista);
		}
	
		
		System.out.print("Tipo: ");
		servico.setTipo(TiposDeServico.pegaServicos(sc.next()));
		
		return servico;
	}
	
	public static Empresa addEmpresa(Scanner sc) {
		Empresa empresa = new Empresa();
		
		System.out.println(">>Empresa<<");
		Dados dados = adicionaDados(empresa, sc);
		empresa = (Empresa) dados; 
		
		
		System.out.println("Deseja adicionar um numero? (S/N)");
		char ch = sc.next().toLowerCase().charAt(0);
		
		if (ch == 's') {
			
			Telefone telefone = adicionaTelefone(sc); 
			empresa.addNumber(telefone);
		}
		// Adicionar um método para adicionar mais um numero.
		
		
		return empresa;
	};
	
	public static Date addData(Scanner sc ) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data;
	
		data = sdf.parse(sc.next());
		
		return data;
	};
	
	public static Double Preco(Scanner sc) {
		
		System.out.print("Preço do serviço R$: ");
		Double preco = sc.nextDouble();
		
		return preco;
			
	};
	
	public static Servico addStatus(Servico servico, Scanner sc) {
		
		System.out.print("Status (NAO_INICIADO/INICIADO/COMPLETADO): ");
		servico.setStatus(Status.valueOf(sc.next()));
	
		return servico;
	};
	

}
