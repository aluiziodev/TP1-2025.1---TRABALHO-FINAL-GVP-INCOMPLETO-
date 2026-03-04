package br.ufc.dc.tpi.GUI;


import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import br.ufc.dc.tpi.itens.*;
import br.ufc.dc.tpi.vestuario.BancoItens;
import br.ufc.dc.tpi.GUI.Listeners.TextFilter;
import br.ufc.dc.tpi.enums.Conservaçao;
import br.ufc.dc.tpi.enums.Tamanho;
import br.ufc.dc.tpi.exception.CadastroInvalidoException;

public class JanelaCadastroItem extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private final File arqvitens = new File("itens.dat");
	

	public JanelaCadastroItem() throws ParseException {
		super("cadastro item");
		
		BancoItens itens = BancoItens.get_instancia();
		setLayout(null);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#5c4f79"));
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
  
            public void windowClosing(WindowEvent e) {
                JanelaCadastrar cadastro = new JanelaCadastrar();
            }
        });
        
        addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent e) {
        		salvaItens(itens.getBancoItens());
        	}
        });
        
        JPanel painel = new JPanel();
        painel.setBounds(50, 30, 1100,620);
        painel.setBackground(Color.decode("#96b5ad"));
        painel.setLayout(null);
        
    	String[] tipos_roupas = {"AcessorioCabeça", "AcessorioBraço", "AcessorioPescoço", "Calçados", "Inferior", "SuperiorExterno", "SuperiorInterno", "Intimas"};
        JComboBox<String> roupas = new JComboBox<>(tipos_roupas);
        roupas.setBounds(10, 20, 140, 30);
        roupas.setFont(new Font("𝖲𝖺𝗇𝗌-𝖲𝖾𝗋𝗂𝖿", Font.BOLD, 12));
        JLabel labelTipo = new JLabel("TIPO: ");
        labelTipo.setForeground(Color.WHITE);
        labelTipo.setBounds(10, 0, 190, 20);
        
        JTextField nome = new JTextField();
        ((AbstractDocument) nome.getDocument()).setDocumentFilter(new TextFilter());
        nome.setBounds(10, 70, 190, 30);
        JLabel labelnome = new JLabel("NOME: ");
        labelnome.setForeground(Color.WHITE);
        labelnome.setBounds(10, 50, 190, 20);
        
        
        
        JTextField cor = new JTextField();
        ((AbstractDocument) cor.getDocument()).setDocumentFilter(new TextFilter());
        cor.setBounds(240,140, 60, 30);
        JLabel labelCor= new JLabel("COR: ");
        labelCor.setForeground(Color.WHITE);
        labelCor.setBounds(240, 120, 190, 20);
        
        JTextField origem = new JTextField();
        ((AbstractDocument) origem.getDocument()).setDocumentFilter(new TextFilter());
        origem.setBounds(10, 140, 190, 30);
        JLabel labelOrigem= new JLabel("ORIGEM: ");
        labelOrigem.setForeground(Color.WHITE);
        labelOrigem.setBounds(10, 120, 190, 20);
        
        JComboBox<Tamanho> tamanho = new JComboBox<>(Tamanho.values());
        tamanho.setBounds(12, 210, 50, 30);
        tamanho.setFont(new Font("𝖲𝖺𝗇𝗌-𝖲𝖾𝗋𝗂𝖿", Font.BOLD, 12));
        JLabel labelTamanho= new JLabel("TAMANHO: ");
        labelTamanho.setForeground(Color.WHITE);
        labelTamanho.setBounds(10, 190, 190, 20);
   
        MaskFormatter formato = new MaskFormatter("##");
        JFormattedTextField tam_calçado = new JFormattedTextField(formato);
        tam_calçado.setBounds(12, 210, 50, 30);
        tam_calçado.setFont(new Font("𝖲𝖺𝗇𝗌-𝖲𝖾𝗋𝗂𝖿", Font.BOLD, 12));
        tam_calçado.setVisible(false);
        
        ButtonGroup conservaçao = new ButtonGroup();
        
        JLabel labelConservacao= new JLabel("CONSERVAÇAO: ");
        labelConservacao.setForeground(Color.WHITE);
        labelConservacao.setBounds(10, 270, 200, 20);
        
        JRadioButton radiopessimo = new JRadioButton(Conservaçao.PESSIMO.get_string());
        radiopessimo.setActionCommand(Conservaçao.PESSIMO.name());
        radiopessimo.setBounds(10, 300, 90, 20);
        radiopessimo.setForeground(Color.WHITE);
        radiopessimo.setBackground(Color.decode("#96b5ad")); 
        
        JRadioButton radioruim = new JRadioButton(Conservaçao.RUIM.get_string());
        radioruim.setActionCommand(Conservaçao.RUIM.name());
        radioruim.setBounds(105, 300, 60, 20);
        radioruim.setForeground(Color.WHITE);
        radioruim.setBackground(Color.decode("#96b5ad")); 
        
        JRadioButton radiomoderado = new JRadioButton(Conservaçao.MODERADO.get_string());
        radiomoderado.setActionCommand(Conservaçao.MODERADO.name());
        radiomoderado.setBounds(170, 300, 110, 20);
        radiomoderado.setForeground(Color.WHITE);
        radiomoderado.setBackground(Color.decode("#96b5ad")); 
        
        JRadioButton radioboa= new JRadioButton(Conservaçao.BOA.get_string());
        radioboa.setActionCommand(Conservaçao.BOA.name());
        radioboa.setBounds(285, 300, 60, 20);
        radioboa.setForeground(Color.WHITE);
        radioboa.setBackground(Color.decode("#96b5ad")); 
        
        JRadioButton radioexcelente= new JRadioButton(Conservaçao.EXCELENTE.get_string());
        radioexcelente.setActionCommand(Conservaçao.EXCELENTE.name());
        radioexcelente.setBounds(350, 300, 130, 20);
        radioexcelente.setForeground(Color.WHITE);
        radioexcelente.setBackground(Color.decode("#96b5ad")); 
        
        roupas.addActionListener(e -> {
            String escolhido = (String) roupas.getSelectedItem();
            if (escolhido.equals("AcessorioCabeça") || escolhido.equals("AcessorioPescoço") || escolhido.equals("AcessorioBraço")) {
                tamanho.setVisible(false);
                labelTamanho.setVisible(false);
       
            }else {
            	tamanho.setVisible(true);
                labelTamanho.setVisible(true);
               
            }
            
          
            
            
            
        });
        
        roupas.addActionListener(e -> {
        	String escolhido = (String) roupas.getSelectedItem();
        	if(escolhido.equals("Calçados")) {
        		tamanho.setVisible(false);
        		tam_calçado.setVisible(true);
        	}
        	else {
        		tamanho.setVisible(true);
        		tam_calçado.setVisible(false);
        	}
        });

        
        JButton salvar = new JButton("SALVAR");
        salvar.setBounds(10, 570, 100, 30);
        salvar.addActionListener(e -> {
        try {
            String inome = nome.getText();
            String icor = cor.getText();
            String iorigem = origem.getText();
            Tamanho itamanho = (Tamanho) tamanho.getSelectedItem();
            String selecionado = (String) roupas.getSelectedItem();

            ButtonModel sel = conservaçao.getSelection();
            String iconservaçao = (sel != null) ? sel.getActionCommand() : null;

            String itam_calç = tam_calçado.getText();

            validarCadastro(inome, icor, iorigem, conservaçao);

            Itens item = null;

            switch (selecionado) {
                case "SuperiorInterno" ->
                    item = new ParteSuperiorInt(inome, icor, Conservaçao.valueOf(iconservaçao), iorigem, itamanho);
                case "Intimas" ->
                    item = new RoupasIntimas(inome, icor, Conservaçao.valueOf(iconservaçao), iorigem, itamanho);
                case "SuperiorExterno" ->
                    item = new ParteSuperiorExt(inome, icor, Conservaçao.valueOf(iconservaçao), iorigem, itamanho);
                case "Inferior" ->
                    item = new ParteInferiorCintura(inome, icor, Conservaçao.valueOf(iconservaçao), iorigem, itamanho);
                case "Calçados" ->
                    item = new Calçados(inome, icor, Conservaçao.valueOf(iconservaçao), iorigem, itam_calç);
                case "AcessorioCabeça" ->
                    item = new AcsCabeça(inome, icor, Conservaçao.valueOf(iconservaçao), iorigem);
                case "AcessorioBraço" ->
                    item = new AcsBraço(inome, icor, Conservaçao.valueOf(iconservaçao), iorigem);
                case "AcessorioPescoço" ->
                    item = new AcsPescoço(inome, icor, Conservaçao.valueOf(iconservaçao), iorigem);
            }

            itens.registrar_item(item);
            salvaItens(itens.getBancoItens());

            JOptionPane.showMessageDialog(this, "Item cadastrado com sucesso!");

            limparCampos(nome, cor, origem, tam_calçado, tamanho, roupas, conservaçao);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Cadastro Inválido", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JButton cancelar = new JButton("CANCELAR");
        cancelar.setBounds(110, 570, 130, 30);
        cancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				new JanelaCadastrar();
				
			}
		});
        
        
        
        painel.add(tam_calçado);
        conservaçao.add(radiopessimo);
        conservaçao.add(radioruim);
        conservaçao.add(radiomoderado);
        conservaçao.add(radioboa);
        conservaçao.add(radioexcelente);
        painel.add(cancelar);
        painel.add(radiopessimo);
        painel.add(radioruim);
        painel.add(radiomoderado);
        painel.add(radioexcelente);
        painel.add(radioboa);
        painel.add(salvar);
        painel.add(labelConservacao);
        painel.add(labelTipo);
        painel.add(roupas);
        painel.add(labelnome);
        painel.add(nome);
        painel.add(labelOrigem);
        painel.add(origem);
        painel.add(labelCor);
        painel.add(cor);
        painel.add(labelTamanho);
        painel.add(tamanho);
        
        add(painel);
        setVisible(true);
        
        
	}
	
    public void validarCadastro(String nome, String cor, String origem, ButtonGroup conservaçao) throws CadastroInvalidoException {
    if(nome.isBlank()) 
        throw new CadastroInvalidoException("NOME");
    
    if(cor.isBlank()) 
        throw new CadastroInvalidoException("COR");
    
    if(origem.isBlank())
        throw new CadastroInvalidoException("ORIGEM");
    
    if(conservaçao.getSelection() == null)
        throw new CadastroInvalidoException("CONSERVAÇAO");
    }

    public void limparCampos(JTextField nome,
                        JTextField cor,
                        JTextField origem,
                        JFormattedTextField tam_calçado,
                        JComboBox<Tamanho> tamanho,
                        JComboBox<String> roupas,
                        ButtonGroup conservacao){
        
        nome.setText("");
	    cor.setText("");
	    origem.setText("");
	    conservacao.clearSelection();
	    tam_calçado.setText("");
        tamanho.setSelectedIndex(0);
        roupas.setSelectedIndex(0);
    }
    
    public void salvaItens(Map<String, Itens> itens) {
        try(FileOutputStream fos = new FileOutputStream(arqvitens);
                ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(itens);
            oos.close();
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this, "ERRO AO SALVAR: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Map<String, Itens> carregaItens(){
        Map<String, Itens> itensArqv = new HashMap<>();
        if (!arqvitens.exists()) return itensArqv;
        
        try (FileInputStream arqv = new FileInputStream(arqvitens);
                ObjectInputStream obj = new ObjectInputStream(arqv)) {
            itensArqv = (Map<String, Itens>) obj.readObject();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERRO AO CARREGAR: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        

        return itensArqv;
    }
}
