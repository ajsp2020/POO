package condominio.entities;

import java.util.Date;

import condominio.entities.enums.Status;
import condominio.entities.enums.TiposDeServico;

public class ServicoPeriodico extends Servico{

	private Date nextDate;
	
	public ServicoPeriodico() {
		super();
	}

	public ServicoPeriodico(TiposDeServico tipo, Empresa empresa, Date initialData, Double preco, Status status,
			Date nextDate) {
		super(tipo, empresa, initialData, preco, status);
		this.nextDate = nextDate;
	}

	public Date getNextDate() {
		return nextDate;
	}

	public void setNextDate(Date nextDate) {
		this.nextDate = nextDate;
	}

	@Override
	public String toString() {
		return " [nextDate=" + nextDate + "]";
	}
	
	
}
