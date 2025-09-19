package br.ufc.dc.tpi.itens.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ItensListener implements ActionListener{
	private JFrame janela;


    public ItensListener(JFrame Janela) {
        this.janela = Janela;
    }
	
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		
		JanelaItens Cadastro = new JanelaItens();
		
		this.janela.dispose();
		
		
	}
}
