package br.ufc.dc.tpi.exception;

public class NaoEmprestadoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NaoEmprestadoException(String nome) {
		super("O item " + nome + " nao esta emprestado");
		
	}
}
