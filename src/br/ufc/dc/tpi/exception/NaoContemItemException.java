package br.ufc.dc.tpi.exception;

public class NaoContemItemException extends Exception{
private static final long serialVersionUID = 1L;
	
	public NaoContemItemException(String nome) {
		super("O item " + nome + " nao existe");
		
	}
}
