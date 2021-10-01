package condominio.application;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import condominio.entities.Cliente;


public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Cliente cliente = null;
		
		boolean sair = false;
		
		while (!sair) {
			
			System.out.println("Menu:");
			System.out.println("0 - Sair.");
			System.out.println("1 - Adicionar Condomínnio.");
			System.out.println("2 - Adicionar Serviço");
			System.out.println("3 - Mostrar Dados");
			int opt = sc.nextInt();
			
		
			switch (opt) {
			
			case 0: {
				
				sair = true;
				
				break;
			}
			
			case 1: {
				
				if (cliente == null) { // Checando se o cliente existe
					cliente = UI.criaCondominio(new Cliente(), sc);
				}
				else {
					
					System.out.println("Deseja trocar o cliente? (S/N)");
					char ch = sc.next().toLowerCase().charAt(0);
					
					if (ch == 's') {
						
						cliente = UI.criaCondominio(cliente, sc);

					}
					else {
						
						break;
					}
				}
				
				break;
			}
			
			case 2: {
				
				if (cliente == null) { // Checando se o cliente existe
					System.out.println("É necessário adicionar um cliente:");
					sc.nextLine();
					sc.nextLine(); // Tem dois pq o programa não esta parando com um só

				}
				else {
					cliente.addService(UI.criaServico(sc));
				}
					
			
				break;
			}
			
			case 3: {
	
				System.out.println(cliente);
				
				break;
			}
				
			default:
				
				break;
			}
			
		}
		
		
		sc.close();
	


	}
	
	

}
