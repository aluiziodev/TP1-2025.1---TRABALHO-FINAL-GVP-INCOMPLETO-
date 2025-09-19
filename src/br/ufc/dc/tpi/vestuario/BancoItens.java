package br.ufc.dc.tpi.vestuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufc.dc.tpi.itens.Itens;
import br.ufc.dc.tpi.exception.NaoContemItemException;
import br.ufc.dc.tpi.itens.*;

public class BancoItens {
	protected Map<String,Itens > bank_itens;
	protected static BancoItens instancia;
	
	
	public BancoItens() {
		this.bank_itens = new HashMap<>();
	}
	
	public void insereBancoItens(Map<String, Itens> itens) {
		this.bank_itens = itens;
	}
	
	public static BancoItens get_instancia() {
		if(instancia==null) {
			instancia = new BancoItens();
		}
		return instancia;
	}
	
	public Itens get_item(String s) throws NaoContemItemException{
		if(bank_itens.containsKey(s)) {
			return bank_itens.get(s);
		}
		else {
			throw new NaoContemItemException(s);
		}
	}
	
	public boolean registrar_item(Itens i) {
		if(!bank_itens.containsValue(i)) {
			bank_itens.put(i.get_nome(), i);
			return true;
		}
		else {
			System.out.print("Item ja esta no vestuario");
			return false;
		}
	}
	
	public boolean remover_item(Itens i) {
		if(bank_itens.containsKey(i.get_nome())) {
			bank_itens.remove(i.get_nome());
			return true;
		}
		else {
			System.out.print("Item nao esta no vestuario");
			return false;
		}
	}
	
	public boolean remover_item(String chave) {
		if(bank_itens.containsKey(chave)) {
			bank_itens.remove(chave);
			return true;
		}
		else {
			System.out.print("Item nao esta no vestuario");
			return false;
		}
	}
	
	public Map<String, Itens> getBancoItens(){
		return bank_itens;
	}
	
	public void listarItens() {
		System.out.println("\nLista de Itens:");
		for(Itens i : bank_itens.values()) {
			System.out.println("ID:\"" + i.get_nome() +"\"/ Conservação: "+ i.get_conservaçao() +" /Loja: " + i.get_origem()+" /Cor: " + i.get_cor());
		}
		System.out.println();
	}
	
	public List<Itens> get_supInterno(){
		 List<Itens> supint = new ArrayList<>();
		    for (Itens i : this.bank_itens.values()) {
		        if (i instanceof ParteSuperiorInt) supint.add(i);
		    }
		    return supint;
	}
	
	public List<Itens> get_supExterno(){
		 List<Itens> supext = new ArrayList<>();
		    for (Itens i : this.bank_itens.values()) {
		        if (i instanceof ParteSuperiorExt) supext.add(i);
		    }
		    return supext;
	}
	
	public List<Itens> get_inferiores(){
		 List<Itens> inf = new ArrayList<>();
		    for (Itens i : this.bank_itens.values()) {
		        if (i instanceof ParteInferiorCintura) inf.add(i);
		    }
		    return inf;
	}
	
	public List<Itens> get_calçados(){
		 List<Itens> calç = new ArrayList<>();
		    for (Itens i : this.bank_itens.values()) {
		        if (i instanceof Calçados) calç.add(i);
		    }
		    return calç;
	}
	
	public List<Itens> get_intimos(){
		 List<Itens> intm = new ArrayList<>();
		    for (Itens i : this.bank_itens.values()) {
		        if (i instanceof RoupasIntimas) intm.add(i);
		    }
		    return intm;
	}
	
	public List<Itens> get_acessorioCabeça(){
		 List<Itens> AcsCb = new ArrayList<>();
		    for (Itens i : this.bank_itens.values()) {
		        if (i instanceof AcsCabeça) AcsCb.add(i);
		    }
		    return AcsCb;
	}
	
	public List<Itens> get_acessorioBraço(){
		 List<Itens> AcsB = new ArrayList<>();
		    for (Itens i : this.bank_itens.values()) {
		        if (i instanceof AcsBraço) AcsB.add(i);
		    }
		    return AcsB;
	}
	
	public List<Itens> get_acessorioPescoço(){
		 List<Itens> AcsP = new ArrayList<>();
		    for (Itens i : this.bank_itens.values()) {
		        if (i instanceof AcsPescoço) AcsP.add(i);
		    }
		    return AcsP;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
