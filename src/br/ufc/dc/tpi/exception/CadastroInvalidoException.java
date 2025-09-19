package br.ufc.dc.tpi.exception;

public class CadastroInvalidoException extends Exception{
	private static final long serialVersionUID = 1L;
	protected String nome;
	
	public CadastroInvalidoException(String s) {
		super("o campo " + s + " deve ser preenchido");
		this.nome = s;
	}
}
