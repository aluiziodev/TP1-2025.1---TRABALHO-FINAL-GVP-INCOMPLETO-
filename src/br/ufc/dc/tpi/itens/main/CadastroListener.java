package br.ufc.dc.tpi.itens.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CadastroListener implements ActionListener{
	private JFrame janelainicio;


    public CadastroListener(JFrame JanelaInicial) {
        this.janelainicio = JanelaInicial;
    }
	
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		
		JanelaCadastrar Cadastro = new JanelaCadastrar();
		
		this.janelainicio.dispose();
		
		
	}
	
}
