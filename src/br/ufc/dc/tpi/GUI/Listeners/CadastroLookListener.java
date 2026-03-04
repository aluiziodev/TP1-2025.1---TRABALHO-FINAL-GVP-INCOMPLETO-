package br.ufc.dc.tpi.GUI.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import br.ufc.dc.tpi.GUI.JanelaCadastroLooks;

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
