package condominio.program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

import condominio.entities.Empresa;
import condominio.entities.Endereco;
import condominio.entities.Servico;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));	
		//Date data = sdf.parse("25/08/2021");
		
		
		List<Servico> listaServicos;
		
		
		System.out.println("Menu: ");
		System.out.println("1 - Adicionar um serviço: ");
		int menu = sc.nextInt();
		
		
		switch (menu) {
		case 1: {
			// Continuar arrumando as classe de forma ser uma lista de servicos. 
			
			Servico servico = new Servico();
			Endereco endereco;
			Empresa empresa;
			
			System.out.println(servico);
			
			
			
			System.out.println("Nome:");
			sc.nextLine();
			String nome = sc.nextLine();
			
			
			System.out.println("Endereco:");
			
			System.out.println("Rua:");
			String rua = sc.nextLine();
			
			System.out.println("Numero");
			String numero = sc.nextLine();
			
			System.out.println("CEP:");
			String cep = sc.nextLine();
			
			System.out.println("Cidade:");
			String cidade = sc.nextLine();
			
			System.out.println("Estado:");
			String estado = sc.nextLine();
			
			System.out.println("Pais");
			String pais = sc.nextLine();
			
			System.out.println("Telefone:");
			String telefone = sc.nextLine();
			
			System.out.println("CNPJ");
			String cnpj = sc.nextLine();
			
			
			endereco = new Endereco(rua, numero, cep, cidade, estado, pais);
			empresa = new Empresa(nome, endereco, telefone, cnpj);
			
			System.out.println(empresa);
			
			break;	
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + menu);
		}
		
				
		sc.close();
	}

}
