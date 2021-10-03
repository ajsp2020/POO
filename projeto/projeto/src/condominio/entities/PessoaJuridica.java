package condominio.entities;

public abstract class PessoaJuridica {
	
	private String nome;
	private Endereco endereco;
	private String cnpj;
	
	public PessoaJuridica() {
		
	}

	public PessoaJuridica(String nome, Endereco endereco, String cnpj) {
		this.nome = nome;
		this.endereco = endereco;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome 
				+ "\nendereco: " + this.endereco 
				+ "\ncnpj=" + this.cnpj;
	}

	
}
