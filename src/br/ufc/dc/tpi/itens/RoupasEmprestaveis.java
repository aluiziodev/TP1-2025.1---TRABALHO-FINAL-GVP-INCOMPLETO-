package br.ufc.dc.tpi.itens;

import java.util.*;

import br.ufc.dc.tpi.enums.*;
import br.ufc.dc.tpi.exception.EmprestadoException;
import br.ufc.dc.tpi.exception.NaoEmprestadoException;


public class RoupasEmprestaveis extends Roupas implements IEmprestavel {
	protected boolean emprestado;
	protected GregorianCalendar ultimoemprestimo;
	protected Set<GregorianCalendar> emprestimos;
	protected Set<GregorianCalendar> devoluçoes;
	
	public RoupasEmprestaveis(String nome, String cor, Conservaçao conservaçao, String origem) {
		super(nome, cor, conservaçao, origem);
		this.emprestado = false;
		this.emprestimos = new LinkedHashSet<>();
		this.devoluçoes = new LinkedHashSet<>();
	}
	
	public void registrar_emprestimo() throws EmprestadoException {
		GregorianCalendar data = new GregorianCalendar();
		if(!emprestado) {
			emprestado = true;
			emprestimos.add(data);
			ultimoemprestimo = data;
		}
		else {
			throw new EmprestadoException(this.nome);
		}
	}
	public void registrar_emprestimo(GregorianCalendar data) throws EmprestadoException {
		if(!emprestado) {
			emprestado = true;
			emprestimos.add(data);
			ultimoemprestimo = data;
			
		}
		else {
			throw new EmprestadoException(this.nome);
		}
	}

	public void registrar_devoluçao() throws NaoEmprestadoException {
		GregorianCalendar data = new GregorianCalendar();
		if(emprestado) {
			emprestado = false;
			devoluçoes.add(data);
		}
		else {
			throw new NaoEmprestadoException(this.nome);
		}
	}
	
	public void registrar_devoluçao(GregorianCalendar data) throws NaoEmprestadoException{
		if(emprestado) {
			emprestado = false;
			devoluçoes.add(data);
		}
		else {
			throw new NaoEmprestadoException(this.nome);
		}
	}
	
	
	public long qtd_dias_emprestados() throws  NaoEmprestadoException{
		if(emprestado) {
			GregorianCalendar datatual = new GregorianCalendar();
			long mili1 = datatual.getTimeInMillis();
			long mili2 = ultimoemprestimo.getTimeInMillis();
			long dias = (mili1 - mili2) / (1000 * 60 * 60 * 24);
			return dias;
			
		}
		else {
			throw new NaoEmprestadoException(this.nome);
		}
	}
	
	public GregorianCalendar get_ultimo_emprestimo() {
		return ultimoemprestimo;
	}
	
}


