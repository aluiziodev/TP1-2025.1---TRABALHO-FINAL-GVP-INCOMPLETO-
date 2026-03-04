package br.ufc.dc.tpi.GUI.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import br.ufc.dc.tpi.GUI.JanelaLook;

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
