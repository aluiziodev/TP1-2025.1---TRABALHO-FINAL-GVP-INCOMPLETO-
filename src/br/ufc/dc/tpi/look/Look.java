package br.ufc.dc.tpi.look;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

import br.ufc.dc.tpi.itens.*;


public class Look implements Serializable {
	protected String nome;
	protected HashMap<Class<? extends Itens>, Itens> look;
	protected Vector<Utilizaçao> utilizaçoes;

	
	public Look(String nome) {
		this.nome = nome;
		this.look = new HashMap<>(); 
		this.utilizaçoes = new Vector<>();
	}
	
	public String get_nome() {
		return nome;
	}
	
	public void montar_look(Itens ... i) {
		for(Itens x : i) {
			look.put(x.getClass(), x);
		}
	}
	
	public void modifica_look(Itens...i) {
		for(Itens x : i)
			look.put(x.getClass(), x);
	}
	
	public void print_look() {
		for(Entry<Class<? extends Itens>, Itens> chave : look.entrySet()) {
			Class<? extends Itens> ch = chave.getKey();
			Itens i = chave.getValue();
			
			if(i!=null) {
				System.out.println(ch.getSimpleName() + " : " + i.get_nome());
			}
			else {
				System.out.println(ch.getSimpleName() + " : NULL");
			}
		}
	}
	
	public void registrar_utilizaçao(String event) {
		Utilizaçao u = new Utilizaçao(new GregorianCalendar(), event);
		utilizaçoes.add(u);
		
		for(Itens i : look.values()) {
			i.registrar_uso();
		}
	}
	
	public void registrar_utilizaçao(String event, GregorianCalendar gc) {
		Utilizaçao u = new Utilizaçao(gc, event);
		utilizaçoes.add(u);
		
		for(Itens i : look.values()) {
			i.registrar_uso();
		}
	}
	
	public int qtd_usos() {
		return utilizaçoes.size();
	}
	
	public boolean verifica_utilizaçao(Utilizaçao u) {
		GregorianCalendar gc = u.get_data();
		if(utilizaçoes.contains(u)) {
			System.out.println("Esse look foi utilizado no dia " + gc.getTime() + " na ocasiao " + u.get_situaçao());
			return true;
		}
		System.out.println("Esse look nao foi utilizado no dia " +  
		gc.getTime() + " na ocasiao " + u.get_situaçao());
		return false;
		
		
	}
	
	
	public void lista_utilizaçoes() {
		for(Utilizaçao u : utilizaçoes) {
			System.out.println(u.get_situaçao() + " : " + u.get_data().getTime());
		}
	}
	
	public Vector<Utilizaçao> getutilizaçoes(){
		return utilizaçoes;
	}
	
	public int qtd_utilizaçoes() {
		return utilizaçoes.size();
	}
	
	public boolean remover(Itens i) {	
		if(look.containsValue(i)) {
			look.put(i.getClass(), null);
			return true;
		}
		else {
			return false;
		}
	}
	

	
}
