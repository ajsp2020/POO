package condominio.application;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import condominio.entities.Cliente;
import condominio.entities.Servico;

public class Program {

	public static void main(String[] args) {

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
			System.out.println("4 - Mostrar Serviços");
			System.out.println("5 - Mostrar Empresas");

			System.out.print(">>> ");
			int opt = sc.nextInt();
			

			switch (opt) {

			case 0: {

				sair = true;

				break;
			}

			case 1: {

				if (!UI.clienteExiste(cliente)) { // Checando se o cliente existe
					cliente = UI.addDadosCondominio(new Cliente(), sc);
				} else {

					System.out.println("Deseja trocar o cliente? (S/N)");
					char ch = sc.next().toLowerCase().charAt(0);

					if (ch == 's') {

						cliente = UI.addDadosCondominio(cliente, sc);

					} else {

						break;
					}
				}

				break;
			}

			case 2: {

				if (!UI.clienteExiste(cliente)) { // Checando se o cliente existe
					System.out.println("Adicione um cliente.");
					sc.nextLine();
					sc.nextLine(); // Tem dois pq o p1rograma não esta parando com um só

				} else {

					cliente.addService(UI.criaServico(sc));
				}

				break;
			}

			case 3: {
				if (UI.clienteExiste(cliente)) {
					
					System.out.println(cliente);
				}

				break;
			}

			case 4: {
				if (UI.clienteExiste(cliente)) {
					System.out.println("1 - Serviços posteriores a data de hoje:");
					System.out.println("2 - Serviços por data específica:");
					System.out.println("3 - Todos os serviços");
	
					System.out.print(">>>");
					opt = sc.nextInt();
	
						switch (opt) {
		
						case 1: {
							Date agora = new Date();
		
							for (Servico servico : cliente.getServicos()) {
								if (servico.getData().after(agora)) {
									System.out.println(servico);
								}
							}
							break;
						}
						case 2: {
							System.out.println("A partir de qual data?");
							Date data = UI.criaData(sc);
		
							for (Servico servico : cliente.getServicos()) {
								if (servico.getData().after(data)) {
									System.out.println(servico);
								}
							}
		
							break;
						}
						case 3: {
							System.out.println(cliente.getServicos());
		
							break;
						}
						default: {
							break;
						}
	
					}
	
				}
				break;
			}
			case 5 :{
				if (UI.clienteExiste(cliente)) {
					for (Servico servico : cliente.getServicos()) {
						System.out.println(servico.getEmpresa());
					}
				}
			
				break;
			}

			default:

				break;
			}

		}

		sc.close();

	}

}
