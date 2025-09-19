package br.ufc.dc.tpi.vestuario;


import java.util.List;

import br.ufc.dc.tpi.exception.EmprestadoException;
import br.ufc.dc.tpi.exception.EmprestavelException;
import br.ufc.dc.tpi.exception.NaoEmprestadoException;
import br.ufc.dc.tpi.itens.IEmprestavel;
import br.ufc.dc.tpi.itens.Itens;

import java.util.ArrayList;

public class BancoEmprestimo {
	protected List<IEmprestavel> bank_emprest;
	
	public BancoEmprestimo() {
		this.bank_emprest = new ArrayList<>();
	}
	
	public boolean adicionar_item(Itens i) throws EmprestadoException, EmprestavelException {
		if(i.isEmprestavel()) {
			IEmprestavel e = (IEmprestavel) i;
			e.registrar_emprestimo();
			bank_emprest.add(e);
			return true;
		}
		else {
			throw new EmprestavelException(i.get_nome());
		}
	}
	
	public boolean remover_item(Itens i) throws NaoEmprestadoException, EmprestavelException {
		if(i.isEmprestavel()) {
			IEmprestavel e = (IEmprestavel) i;
			e.registrar_devoluçao();
			bank_emprest.remove(e);
			return true;
		}
		else {
			throw new EmprestavelException(i.get_nome());
		}
	}
	
	public void listar_itens() throws NaoEmprestadoException {
		if(!bank_emprest.isEmpty()) {
			for(IEmprestavel e : bank_emprest) {
				Itens i = (Itens) e;
				System.out.println("O item " + i.get_nome() + " Esta emprestado no dia " + e.get_ultimo_emprestimo().getTime() + " a " + e.qtd_dias_emprestados() + " dias");
			}
		}	
		else {
			System.out.println("Nao possui emprestimos");
		}
	}
	
}
