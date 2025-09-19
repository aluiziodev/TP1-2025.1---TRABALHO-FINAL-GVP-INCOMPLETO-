package br.ufc.dc.tpi.exception;

public class EmprestadoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EmprestadoException(String nome) {
		super("O item " + nome + " Ja esta emprestado");
		
	}
}
