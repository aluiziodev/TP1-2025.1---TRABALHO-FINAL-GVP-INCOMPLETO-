package br.ufc.dc.tpi.look;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utilizaçao {
	protected GregorianCalendar data;
	protected String situaçao;
	
	
	public Utilizaçao( GregorianCalendar data, String u) {
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
