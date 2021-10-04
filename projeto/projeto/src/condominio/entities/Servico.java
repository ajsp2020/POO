package condominio.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import condominio.entities.enums.Status;
import condominio.entities.enums.TiposDeServico;
import condominio.exceptions.ProgramException;

public class Servico {
	
	private TiposDeServico tipo;
	private Empresa empresa;
	private Date initialData;
	private Double preco;
	private Status status;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	
	public Servico() {
		
	}

	public TiposDeServico getTipo() {	
		return tipo;
	}

	
	public void setTipo(TiposDeServico tipo) {
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


	public Double getPreco() {
		return preco;
	}
	

	public void setPreco(Double preco) {
		validaPreco(preco);
		this.preco = preco;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}
	
	private void validaPreco(Double preco) {
		if(preco < 0) {
			throw new ProgramException("O preço precisa ser um valor maior que zero.");
		}
	}
	
	


	@Override
	public String toString() {
		return "\nTIPO: " + this.tipo 
				+ "\nNOME DA EMPRESA: " + empresa.getNome() 
				+ "\nDATA: " + this.sdf.format(initialData) 
				+ "\nPREÇO: R$ " + String.format("%.2f", this.preco)
				+ "\nSTATUS: " + this.status;
	}

	
}
