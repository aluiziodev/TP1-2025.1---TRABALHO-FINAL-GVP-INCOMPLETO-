package br.ufc.dc.tpi.vestuario;


import java.util.List;

import br.ufc.dc.tpi.exception.NaoConstaLookException;
import br.ufc.dc.tpi.look.Look;

import java.util.ArrayList;

public class BancoLooks {
	
	protected List<Look> bank_look;
	protected static BancoLooks instancia;
	
	
	
	public BancoLooks() {
		this.bank_look = new ArrayList<>();
	}
	
	public static BancoLooks get_instancia() {
		if(instancia == null) {
			instancia = new BancoLooks();
		}
		return instancia;
	}
	
	public List<Look> get_bancoLook(){
		return bank_look;
	}
	
	public void insereBankLook(List<Look> looks) {
		bank_look = looks;
	}
	
	public Look get_look(String nome) throws NaoConstaLookException{
		for(Look l : bank_look) {
			if(l.get_nome()==nome) {
				return l;
			}
		}
		throw new NaoConstaLookException(nome);
		
	}
	
	public boolean salvarLook(Look l) {
		if(!bank_look.contains(l)) {
			bank_look.add(l);
			return true;
		}
		else {
			System.out.println("Look ja existe");
			return false;
		}
	}
	
	public boolean deletarLook(Look l) {
		if(bank_look.contains(l)) {
			bank_look.remove(l);
			return true;
		}
		else {
			System.out.println("Look nao existe");
			return false;
		}
	}
	
	
	
}
