package condominio.entities;

import java.text.SimpleDateFormat;
import java.util.Date;



import condominio.entities.enums.Status;

public class Servico {
	
	private Integer tipo;
	private Empresa empresa;
	private Date initialData;
	private Double preco;
	private Status status;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Servico() {
		
	}


	public Servico(Integer tipo, Empresa empresa, Date initialData, Double preco, Status status) {
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


	public Double getPreco() {
		return preco;
	}
	


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public static boolean testaPreco(double preco) {
		
		if (preco < 0) {
			System.out.println("O preço precisa ser um valor POSITIVO: ");
			return true;
		}
		else {
			
			return false;
		}
		
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "\ntipo: " + tipo 
				+ "\nEmpresa: " + empresa 
				+ "\nData Inicial: " + sdf.format(initialData) 
				+ "\nPreco: R$ " + String.format("%.2f", preco)
				+ "\ntatus: " + status;
	}

	
}
