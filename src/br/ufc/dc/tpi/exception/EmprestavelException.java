package br.ufc.dc.tpi.exception;

public class EmprestavelException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EmprestavelException(String nome) {
		super("O item " + nome + " nao pode ser emprestado");
		
	}
}
