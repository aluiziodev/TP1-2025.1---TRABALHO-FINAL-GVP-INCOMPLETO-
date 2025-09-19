package br.ufc.dc.tpi.itens;

import java.util.GregorianCalendar;

public interface ILavavel {

	public void registrar_lavagem(GregorianCalendar data);
	public int qtd_lavagens();
	public GregorianCalendar get_ultima_lavagem();
	
}
