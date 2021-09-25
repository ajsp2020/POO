package condominio.program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

import condominio.entities.Cliente;
import condominio.entities.Dados;
import condominio.entities.Empresa;
import condominio.entities.Endereco;
import condominio.entities.Servico;
import condominio.entities.Telefone;


public class Program {
	
	public static Dados adicionaDados(String tipo) {
		
		Dados dados = new Dados();
		Scanner sc = new Scanner(System.in);
		if (tipo == "1") dados = new Empresa();
		else if (tipo == "0") dados = new Cliente();
		
		Endereco endereco = new Endereco();
		
		System.out.print("Nome:");
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
	
	
	public static Telefone adicionaTelefone() {
		
		Scanner sc = new Scanner(System.in);
		Telefone telefone = new Telefone();
		
		System.out.println("Telefone: ");
		
		System.out.print("Tipo: ");
		telefone.setTipo(sc.nextLine());
		
		System.out.print("DDD: ");
		telefone.setDdd(sc.nextLine());
		
		System.out.print("Numero: ");
		telefone.setNumero(sc.nextLine());
		
		return telefone;
		
	};

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int menu;
		Cliente cliente = new Cliente();
		Empresa empresa;
		
		do {
			
			System.out.println("Menu:");
			System.out.println("0 - Sair.");
			System.out.println("1 - Adicionar Condomínnio.");
			System.out.println("2 - Adicionar Serviço");
			System.out.println("3 - Mostrar Dados");
			menu = sc.nextInt();

		
			switch (menu) {
			
			case 0: {
				
				break;
			}
			
			case 1: {
				
				// Pega os dados do condomínio:
				Endereco endereco = new Endereco();
				System.out.println("Nome do condomínio: ");

				sc.nextLine();
				
				System.out.println("Endereço do Condomínio");
				Dados dados = adicionaDados("0");
				cliente = (Cliente) dados;
				
				System.out.print("Sindico: ");
				String sindico = sc.nextLine();
				
				cliente.setSindico(sindico);
					
				break;
			}
			
			case 2: {
				
				Servico servico = new Servico();
				Endereco endereco = new Endereco();
				
				// Tipo do serviço
				String[] tipos = {"1 - Manutenção", 
								"2 - Pintura",
								"3 - Limpeza",
								"4 - Troca"};
				
				System.out.println("Tipo de serviço: ");
				
				for(String lista : tipos) {
					System.out.println(lista);
				};
				
				System.out.print("Tipo: ");
				int tipo = sc.nextInt();
				
				// Dados da empresa
				System.out.println("Empresa");
				Dados dados = adicionaDados("1");
				empresa = (Empresa) dados; 
				
				Telefone telefone = adicionaTelefone();
				empresa.addNumber(telefone);
				
				System.out.print(empresa);
				
				
				// Data inicial
				
				
				// Preço
				
				
				// Status 
				
				
				System.out.println(empresa.getTelefones());
				
				break;
			}
			
			case 3: {
				
				System.out.println(cliente);
				
				break;
			}
				
			default:
				break;
			}
			
		}while(menu != 0);
		
		
		sc.close();
		
	}

}
