package br.ufc.dc.tpi.itens;

import br.ufc.dc.tpi.enums.*;

public class Calçados extends RoupasEmprestaveis{
	protected String size;
	
	public Calçados(String nome, String cor, Conservaçao conservaçao, String origem, String size) {
		super(nome, cor, conservaçao, origem);
		this.size = size;
		this.tipo = Tipos.Calçados;
	}
	
	public String get_size() {
		return size;
	}
	
	public void modificar_size(String i) {
		size = i;
	}
}
