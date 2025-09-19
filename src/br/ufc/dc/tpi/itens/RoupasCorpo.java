package br.ufc.dc.tpi.itens;

import br.ufc.dc.tpi.enums.Conservaçao;
import br.ufc.dc.tpi.enums.Tamanho;

public class RoupasCorpo extends RoupasEmprestaveis{
	protected Tamanho size;
	
	public RoupasCorpo(String nome, String cor, Conservaçao conservaçao, String origem, Tamanho size) {
		super(nome, cor, conservaçao, origem);
		this.size = size;
	}
	
	public void modificar_size(Tamanho s) {
		size = s;
	}
	
	public Tamanho get_size() {
		return size;
	}

}
