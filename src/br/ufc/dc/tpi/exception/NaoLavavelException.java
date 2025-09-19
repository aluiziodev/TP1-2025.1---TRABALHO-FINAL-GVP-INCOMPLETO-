package br.ufc.dc.tpi.exception;

public class NaoLavavelException extends Exception {
		
		private static final long serialVersionUID = 1L;

		public NaoLavavelException(String nome) {
			super("O Item " + nome + " não é lavável");
		}
		

}
