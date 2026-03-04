package br.ufc.dc.tpi.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import br.ufc.dc.tpi.GUI.Listeners.CadastroItensListener;
import br.ufc.dc.tpi.GUI.Listeners.CadastroLookListener;
import br.ufc.dc.tpi.GUI.Listeners.MouseListener;

public class JanelaCadastrar extends JFrame{
	private static final long serialVersionUID = 1L;

	public JanelaCadastrar() {
		super("Cadastro");
		setLayout(null);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#471754"));
        
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
  
            public void windowClosing(WindowEvent e) {
                JanelaInicial inicio = new JanelaInicial();
            }
        });
        
        JPanel painel = new JPanel();
        JButton cadastroItem = new JButton("CADASTRAR ITEM");
        JButton cadastroLook= new JButton("CADASTRAR LOOK");
        
        cadastroItem.addMouseListener(new MouseListener());
        cadastroLook.addMouseListener(new MouseListener());
        
        cadastroItem.addActionListener(new CadastroItensListener(this));
        cadastroLook.addActionListener(new CadastroLookListener(this));
        
        painel.setLayout(null);
        
        cadastroItem.setBounds(30, 40, 300, 150);
        cadastroItem.setBackground(Color.decode("#536c8d"));  
        cadastroItem.setForeground(Color.WHITE);              
        cadastroItem.setFocusPainted(false);                 
        cadastroItem.setBorderPainted(false);              
        cadastroItem.setContentAreaFilled(true);
        cadastroItem.setFont(new Font("𝖲𝖺𝗇𝗌-𝖲𝖾𝗋𝗂𝖿", Font.BOLD, 18));
        
        cadastroLook.setBounds(370, 40, 300, 150);
        cadastroLook.setBackground(Color.decode("#536c8d"));  
        cadastroLook.setForeground(Color.WHITE);              
        cadastroLook.setFocusPainted(false);                 
        cadastroLook.setBorderPainted(false);               
        cadastroLook.setContentAreaFilled(true);
        cadastroLook.setFont(new Font("𝖲𝖺𝗇𝗌-𝖲𝖾𝗋𝗂𝖿", Font.BOLD, 18));
        
        painel.setBounds(30, 140, 800, 480);
        painel.setBackground(Color.decode("#5c4f79"));
        painel.add(cadastroItem);
        painel.add(cadastroLook);
        
        
        setLayout(new BorderLayout());

        add(painel, BorderLayout.CENTER);
        setVisible(true);
        
        
	}
}
