package br.ufc.dc.tpi.itens;

import br.ufc.dc.tpi.enums.*;

public class AcsBraço extends Acessorios {
	
	public AcsBraço (String nome, String cor, Conservaçao conservaçao, String origem) {
		super(nome,cor,conservaçao,origem);
		this.tipo = Tipos.AcsBraço;
	}
}
