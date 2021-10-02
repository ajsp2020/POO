package condominio.entities.enums;

import java.util.HashMap;
import java.util.Map;

public enum TiposDeTelefone {
	
	FIXO("1"),
	CELULAR("2");
	
	private String valor;
	
	private static final Map<String, TiposDeTelefone> TelefonePorValor = new HashMap<>();
	
	static {
		for (TiposDeTelefone servicos : TiposDeTelefone.values()) {
			TelefonePorValor.put(servicos.getValor(), servicos);
		}
	}
	
	TiposDeTelefone(String valor){
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
	
	public static TiposDeTelefone pegaTelefones(String valor) {
		return TelefonePorValor.get(valor);
	}
	
}
