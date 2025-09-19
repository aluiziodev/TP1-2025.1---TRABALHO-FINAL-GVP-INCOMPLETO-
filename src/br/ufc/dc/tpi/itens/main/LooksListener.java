package br.ufc.dc.tpi.itens.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class LooksListener implements ActionListener{
	private JFrame janela;


    public LooksListener(JFrame Janela) {
        this.janela = Janela;
    }
	
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		
		JanelaLook look = new JanelaLook();
		
		this.janela.dispose();
		
		
	}
}
