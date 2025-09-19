package br.ufc.dc.tpi.itens;

import br.ufc.dc.tpi.enums.Conservaçao;
import br.ufc.dc.tpi.enums.Tipos;

public class AcsPescoço extends Acessorios {
	
	public AcsPescoço(String nome, String cor, Conservaçao conservaçao, String origem) {
		super(nome,cor,conservaçao,origem);
		this.tipo = Tipos.AcsPescoço;
	}
}
