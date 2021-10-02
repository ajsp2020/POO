package condominio.entities;

import condominio.entities.enums.TiposDeTelefone;
import condominio.exceptions.ProgramException;

public class Telefone {

	private TiposDeTelefone tipo;
	private String ddd;
	private String numero;

	public Telefone() {

	}

	public Telefone(TiposDeTelefone tipo, String ddd, String numero) {
		this.tipo = tipo;
		this.ddd = ddd;
		this.numero = numero;
	}

	public TiposDeTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TiposDeTelefone tipo) {
		this.tipo = tipo;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		validaDdd(ddd);
		this.ddd = ddd;

	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		validaNumero(numero);
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "" + tipo + ":" + "(" + ddd + ")" + "numero" + numero;
	}

	private void validaDdd(String ddd) {
		if (ddd.length() != 2) {
			throw new ProgramException("O ddd precisa possuir dois valores");
		}
	}
	
	private void validaNumero(String numero) {
		if (ddd.length() != 9) {
			throw new ProgramException("Adicione um número válido");
		}
	}

}
