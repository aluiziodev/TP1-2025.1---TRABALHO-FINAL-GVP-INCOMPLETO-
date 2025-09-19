package br.ufc.dc.tpi.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;

public class CadastroItensListener implements ActionListener{
	protected JFrame janela;
	
	  public CadastroItensListener(JFrame janela) {
	        this.janela = janela;
	    }
		
		public void actionPerformed(ActionEvent e) {
			Object evento = e.getSource();
			
			try {
				JanelaCadastroItem Cadastro = new JanelaCadastroItem();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			this.janela.dispose();
			
			
		}
}
