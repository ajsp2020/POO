package condominio.entities;

import java.util.Date;

public class ServicoPeriodico extends Servico {

	private Date nextDate;

	public ServicoPeriodico() {
		super();
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
