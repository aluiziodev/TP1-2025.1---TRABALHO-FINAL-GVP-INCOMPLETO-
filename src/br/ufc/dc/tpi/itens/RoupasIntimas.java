package br.ufc.dc.tpi.itens;

import br.ufc.dc.tpi.enums.*;

public class RoupasIntimas extends Roupas {
	protected Tamanho size;
	
	public RoupasIntimas(String nome, String cor, Conservaçao conservaçao, String origem, Tamanho size) {
		super(nome, cor, conservaçao, origem);
		this.size = size;
		this.tipo = Tipos.Intimas;
	}
	
	public void modificar_size(Tamanho s) {
		size = s;
	}
	
	public Tamanho get_size() {
		return size;
	}
	
}
