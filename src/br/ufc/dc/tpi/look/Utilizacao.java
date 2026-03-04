package br.ufc.dc.tpi.look;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utilizacao implements Serializable{ 
	private static final long serialVersionUID = 1L;
	protected GregorianCalendar data;
	protected String situaçao;
	
	
	public Utilizacao( GregorianCalendar data, String u) {
		this.data = data;
		this.situaçao = u;
	}
	
	
	public GregorianCalendar get_data() {
		return data;
	}
	
	public void print_data() {
		System.out.println(data.get(Calendar.YEAR) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.DAY_OF_MONTH));
	}
	
	public String get_situaçao() {
		return situaçao;
	}
}
