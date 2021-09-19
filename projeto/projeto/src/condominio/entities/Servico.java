package condominio.entities;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Servico {
	
	private String tipo;
	private Empresa empresa;
	private Date data;
	private String preco;
	
	
	public Servico() {
	}


	public Servico(String tipo, Empresa empresa, Date data, String preco) {
		this.tipo = tipo;
		this.empresa = empresa;
		this.data = data;
		this.preco = preco;
	}


	public String getTipo() {	
		return tipo;
	}

	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public String getPreco() {
		return preco;
	}


	public void setPreco(String preco) {
		this.preco = preco;
	}


	@Override
	public String toString() {
		return "Servico [tipo=" + tipo + ", empresa=" + empresa + ", data=" + data + ", preco=" + preco
				+ "]";
	}
	
	
}
