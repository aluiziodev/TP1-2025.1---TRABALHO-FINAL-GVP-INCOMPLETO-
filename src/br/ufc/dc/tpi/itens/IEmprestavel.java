package br.ufc.dc.tpi.itens;

import java.util.GregorianCalendar;

import br.ufc.dc.tpi.exception.EmprestadoException;
import br.ufc.dc.tpi.exception.NaoEmprestadoException;

public interface IEmprestavel {
	public void registrar_emprestimo() throws EmprestadoException;
	public long qtd_dias_emprestados() throws NaoEmprestadoException;
	public void registrar_devoluçao() throws NaoEmprestadoException;
	public GregorianCalendar get_ultimo_emprestimo();
	
}
