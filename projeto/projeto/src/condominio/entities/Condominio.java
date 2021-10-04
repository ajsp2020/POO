package condominio.entities;

import java.util.ArrayList;
import java.util.List;

// Criando uma classe cliente e adicionando os métodos. 
public class Condominio extends PessoaJuridica{
	
	private List<Servico> servicos = new ArrayList<>();
	private String sindico;
	
	public Condominio() {
		super();
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void addService(Servico servico) {
		servicos.add(servico);
	}
	
	public void removeService(Servico servico) {
		servicos.remove(servico);
	}

	public String getSindico() {
		return sindico;
	}

	public void setSindico(String sindico) {
		this.sindico = sindico;
	}
	

	@Override 
	public String toString() {
		return "***************************************\n"
				+">>>       DADOS DO CONDOMINIO       <<<\n"
				+ "\nSINDICO: " + this.sindico 
				+ super.toString()
				+ "\n>>> SERVIÇOS <<< \n" 
				+ servicos 
				+ "\n***************************************";
	}
	
	public String toString(String string) {
		return "***************************************\n"
				+">>>       DADOS DO CONDOMINIO       <<<\n"
				+"NOME: " + super.getNome() + "\n"
				+"SINDICO: " + this.sindico + "\n"
				+"***************************************"; 

	}
	
}
