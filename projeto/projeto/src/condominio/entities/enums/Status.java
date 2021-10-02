package condominio.entities.enums;

import java.util.HashMap;
import java.util.Map;

public enum Status {
	
	NAO_INICIADO("1"),
	INICIADO("2"),
	COMPLETADO("3"),
	OUTROS("4");
	
private String valor;
	
	private static final Map<String, Status> StatusPorValor = new HashMap<>();
	
	static {
		for (Status servicos : Status.values()) {
			StatusPorValor.put(servicos.getValor(), servicos);
		}
	}
	
	Status(String valor){
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
	
	public static Status pegaServicos(String valor) {
		return StatusPorValor.get(valor);
	}


}
