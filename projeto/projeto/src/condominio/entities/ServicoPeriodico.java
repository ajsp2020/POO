package condominio.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ServicoPeriodico extends Servico {

	private Date nextDate;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


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
		return super.toString() 
				+ "\nPROXIMA DATA: " + this.sdf.format(nextDate);			
	}

}
