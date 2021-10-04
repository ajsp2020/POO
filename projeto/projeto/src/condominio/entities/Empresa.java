package condominio.entities;

import java.util.List;
import java.util.ArrayList;

public class Empresa extends PessoaJuridica{
	
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	public Empresa () {
		super();
		
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void addNumber(Telefone telefone) {
		this.telefones.add(telefone);
	}
	
	public void removeNumber(Telefone telefone) {
		this.telefones.remove(telefone);
	}

	@Override
	public String toString() {
		return "\nNOME DA EMPRESA: " + this.getNome() 
				+ "\nENDEREÇO: " + this.getEndereco()
				+ "\nCNPJ: " + this.getCnpj()
				+ "\nTELEFONE: \n" + telefones ;
	}
	
}
