package br.ufc.dc.tpi.itens;

import br.ufc.dc.tpi.enums.Conservaçao;
import br.ufc.dc.tpi.enums.Tamanho;
import br.ufc.dc.tpi.enums.Tipos;

public class ParteSuperiorExt extends ParteSuperiorCintura{
	
	public ParteSuperiorExt(String nome, String cor, Conservaçao conservaçao, String origem, Tamanho size) {
		super(nome, cor, conservaçao, origem, size);
		this.tipo = Tipos.ParteSuperiorExt;

	}
	
}
