package condominio.entities;

public class Empresa {
	
	private String nome;
	private Endereco endereco;
	private String telefone;
	private String cnpj;
	
	
	public Empresa(String nome, Endereco endereco, String telefone, String cnpj) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	@Override
	public String toString() {
		return "Empresa [nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", cnpj=" + cnpj + "]";
	}

	
	
}
