package br.ufc.dc.tpi.exception;

public class NaoConstaLookException extends Exception {
	
	public NaoConstaLookException(String nome) {
		super("O look " + nome + "Nao consta");
	}
}
