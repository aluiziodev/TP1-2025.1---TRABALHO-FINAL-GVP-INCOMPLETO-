package br.ufc.dc.tpi.itens;

import br.ufc.dc.tpi.enums.*;

public class ParteInferiorCintura extends RoupasCorpo{
	public ParteInferiorCintura(String nome, String cor, Conservaçao conservaçao, String origem, Tamanho size) {
		super(nome, cor, conservaçao, origem, size);
		this.tipo = Tipos.ParteInferiorCintura;

	}
}
