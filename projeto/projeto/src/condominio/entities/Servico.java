package condominio.entities;

import java.util.Date;

import condominio.entities.enums.Status;

public class Servico {
	
	private Integer tipo;
	private Empresa empresa;
	private Date initialData;
	private String preco;
	private Status status;
	
	
	public Servico() {
		
	}


	public Servico(Integer tipo, Empresa empresa, Date initialData, String preco, Status status) {
		this.tipo = tipo;
		this.empresa = empresa;
		this.initialData = initialData;
		this.preco = preco;
		this.status = status;
	}


	public Integer getTipo() {	
		return tipo;
	}

	
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public Date getData() {
		return initialData;
	}


	public void setData(Date data) {
		this.initialData = data;
	}


	public String getPreco() {
		return preco;
	}


	public void setPreco(String preco) {
		this.preco = preco;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}

	
}
