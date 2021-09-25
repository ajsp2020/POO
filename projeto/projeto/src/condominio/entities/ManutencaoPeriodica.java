package condominio.entities;

import java.util.Date;

import condominio.entities.enums.Status;

public class ManutencaoPeriodica extends Servico{

	private Date nextDate;
	
	public ManutencaoPeriodica() {
		super();
	}

	public ManutencaoPeriodica(Integer tipo, Empresa empresa, Date initialData, String preco, Status status,
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
	
	
}
