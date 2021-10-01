package condominio.entities.enums;

import java.util.HashMap;
import java.util.Map;

public enum TiposDeServico {
	MANUTENCAO("1"),
	PINTURA("2"),
	LIMPEZA("3"),
	TROCA("4");

	
	private String valor;
	
	private static final Map<String, TiposDeServico> ServicosPorValor = new HashMap<>();
	
	static {
		for (TiposDeServico servicos : TiposDeServico.values()) {
			ServicosPorValor.put(servicos.getValor(), servicos);
		}
	}
	
	TiposDeServico(String valor){
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
	
	public static TiposDeServico pegaServicos(String valor) {
		return ServicosPorValor.get(valor);
	}

}
 
