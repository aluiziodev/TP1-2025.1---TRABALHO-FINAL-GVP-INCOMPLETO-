package br.ufc.dc.tpi.GUI.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import br.ufc.dc.tpi.GUI.JanelaCadastroLooks;
import br.ufc.dc.tpi.GUI.JanelaEstatisticaItens;

public class EstatisticaItensListener implements ActionListener{
    protected JFrame janela;
	
	  public  EstatisticaItensListener(JFrame janela) {
	        this.janela = janela;
	    }
		
		public void actionPerformed(ActionEvent e) {
			Object evento = e.getSource();
			
			JanelaEstatisticaItens Cadastro = new JanelaEstatisticaItens();
			
			this.janela.dispose();
			
		}
}
