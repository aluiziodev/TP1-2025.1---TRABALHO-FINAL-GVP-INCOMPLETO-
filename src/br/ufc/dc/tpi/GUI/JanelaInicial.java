package br.ufc.dc.tpi.GUI;

import java.awt.*;

import javax.swing.*;

import br.ufc.dc.tpi.GUI.Listeners.CadastroListener;
import br.ufc.dc.tpi.GUI.Listeners.EstatisticaItensListener;
import br.ufc.dc.tpi.GUI.Listeners.ItensListener;
import br.ufc.dc.tpi.GUI.Listeners.LooksListener;
import br.ufc.dc.tpi.GUI.Listeners.MouseListener;

public class JanelaInicial extends JFrame {
	private static final long serialVersionUID = 1L;

	public JanelaInicial(){
		super("Vestuario Pessoal");
		
		setLayout(null);
		setSize(1200, 700);
		setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#471754"));
        
        JPanel painel = new JPanel();
        JButton cadastro = new JButton("CADASTRAR ITENS OU LOOKS");
        JButton estatisticaItens = new JButton("ESTATISTICA ITENS");
        JButton itens = new JButton("ITENS");
        JButton looks = new JButton("LOOKS");
        JButton emprestados = new JButton("ITENS EMPREESTADOS");
        JButton estatisticaLooks = new JButton("ESTATISTICA LOOKS");
        
        cadastro.addMouseListener(new MouseListener());
        estatisticaItens.addMouseListener(new MouseListener());
        itens.addMouseListener(new MouseListener());
        looks.addMouseListener(new MouseListener());
        emprestados.addMouseListener(new MouseListener());
        estatisticaLooks.addMouseListener(new MouseListener());

        cadastro.addActionListener(new CadastroListener(this));
        itens.addActionListener(new ItensListener(this));
        looks.addActionListener(new LooksListener(this));
        estatisticaItens.addActionListener(new EstatisticaItensListener(this));
        
        painel.setLayout(null);
        
        cadastro.setBounds(30, 40, 300, 150);
        cadastro.setBackground(Color.decode("#536c8d"));  
        cadastro.setForeground(Color.WHITE);              
        cadastro.setFocusPainted(false);                 
        cadastro.setBorderPainted(false);              
        cadastro.setContentAreaFilled(true);
        cadastro.setFont(new Font("𝖲𝖺𝗇𝗌-𝖲𝖾𝗋𝗂𝖿", Font.BOLD, 14));
        
        estatisticaItens.setBounds(30, 210, 300, 150);
        estatisticaItens.setBackground(Color.decode("#536c8d")); 
        estatisticaItens.setForeground(Color.WHITE);              
        estatisticaItens.setFocusPainted(false);                 
        estatisticaItens.setBorderPainted(false);                 
        estatisticaItens.setContentAreaFilled(true);
        estatisticaItens.setFont(new Font("𝖲𝖺𝗇𝗌-𝖲𝖾𝗋𝗂𝖿", Font.BOLD, 18));
        
        itens.setBounds(370, 40, 300, 150);
        itens.setBackground(Color.decode("#536c8d"));  
        itens.setForeground(Color.WHITE);              
        itens.setFocusPainted(false);                 
        itens.setBorderPainted(false);               
        itens.setContentAreaFilled(true);
        itens.setFont(new Font("𝖲𝖺𝗇𝗌-𝖲𝖾𝗋𝗂𝖿", Font.BOLD, 18));
        
        looks.setBounds(710, 40, 300, 150);
        looks.setBackground(Color.decode("#536c8d"));  
        looks.setForeground(Color.WHITE);              
        looks.setFocusPainted(false);                 
        looks.setBorderPainted(false);               
        looks.setContentAreaFilled(true);
        looks.setFont(new Font("𝖲𝖺𝗇𝗌-𝖲𝖾𝗋𝗂𝖿", Font.BOLD, 18));
        
        emprestados.setBounds(710, 210, 300, 150);
        emprestados.setBackground(Color.decode("#536c8d"));  
        emprestados.setForeground(Color.WHITE);              
        emprestados.setFocusPainted(false);                  
        emprestados.setBorderPainted(false);                
        emprestados.setContentAreaFilled(true);
        emprestados.setFont(new Font("𝖲𝖺𝗇𝗌-𝖲𝖾𝗋𝗂𝖿", Font.BOLD, 18));

        estatisticaLooks.setBounds(370, 210, 300, 150);
        estatisticaLooks.setBackground(Color.decode("#536c8d")); 
        estatisticaLooks.setForeground(Color.WHITE);              
        estatisticaLooks.setFocusPainted(false);                 
        estatisticaLooks.setBorderPainted(false);                 
        estatisticaLooks.setContentAreaFilled(true);
        estatisticaLooks.setFont(new Font("𝖲𝖺𝗇𝗌-𝖲𝖾𝗋𝗂𝖿", Font.BOLD, 18));
        
        painel.setBounds(30, 140, 800, 480);
        painel.setBackground(Color.decode("#5c4f79"));
        painel.add(cadastro);
        painel.add(estatisticaItens);
        painel.add(itens);
        painel.add(looks);
        painel.add(emprestados);
        painel.add(estatisticaLooks);
        
        setLayout(new BorderLayout());

        add(painel, BorderLayout.CENTER);
        setVisible(true);
	}
}
