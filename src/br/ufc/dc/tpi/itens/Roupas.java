package br.ufc.dc.tpi.itens;

import java.util.GregorianCalendar;
import java.util.Vector;

import br.ufc.dc.tpi.enums.*;

public class Roupas  extends Itens implements  ILavavel{
	protected Vector<GregorianCalendar> lavagens;
	protected GregorianCalendar ult_lav;
	
	public Roupas(String nome, String cor, Conservaçao conservaçao, String origem) {
		super(nome, cor, conservaçao, origem);
		this.lavagens = new Vector<>();
		ult_lav = null;
	}
	

	public void lavar() {
		GregorianCalendar g = new GregorianCalendar();
		ult_lav = g;
		lavagens.add(g);
		
	}
	
	public void registrar_lavagem(GregorianCalendar data) {
		lavagens.add(data);
		ult_lav = data;
	}
	public int qtd_lavagens() {
		return lavagens.size();
	}
	
	public GregorianCalendar get_ultima_lavagem() {
		return ult_lav;
	}
	
	
	
}
