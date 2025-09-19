package br.ufc.dc.tpi.enums;

public enum Conservaçao {
	PESSIMO("PESSIMO"), 
	RUIM("RUIM"), 
	MODERADO("MODERADO"), 
	BOA("BOA"),
	EXCELENTE("EXCELENTE");
	
	protected String nome;
	
	Conservaçao(String nome){
		this.nome = nome;
	}
	
	public String get_string() {
		return nome;
	}
}
