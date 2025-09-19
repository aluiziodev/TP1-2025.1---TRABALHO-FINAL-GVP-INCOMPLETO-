package br.ufc.dc.tpi.itens.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CadastroLookListener implements ActionListener{
	protected JFrame janela;
	
	  public CadastroLookListener(JFrame janela) {
	        this.janela = janela;
	    }
		
		public void actionPerformed(ActionEvent e) {
			Object evento = e.getSource();
			
			JanelaCadastroLooks Cadastro = new JanelaCadastroLooks();
			
			this.janela.dispose();
			
		}
}
