package condominio.entities;

import java.util.ArrayList;
import java.util.List;

// Criando uma classe cliente e adicionando os métodos. 
public class Cliente extends Dados{
	
	private List<Servico> servicos = new ArrayList<>();
	private String sindico;
	
	public Cliente() {
		super();
	}

	public Cliente(String nome, Endereco endereco, String cnpj, String sindico) {
		super(nome, endereco, cnpj);
		this.sindico = sindico;
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
		return ">> Dados do Cliente <<"
				+ "\nsindico: " + sindico 
				+ "\nDados do condomínio:\n"
				+ super.toString()
				+ "\nservicos: " 
				+ servicos 
				+ 
						 "";
	}
	
	
}
