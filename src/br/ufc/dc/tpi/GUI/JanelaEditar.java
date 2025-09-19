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
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import br.ufc.dc.tpi.enums.Conservaçao;
import br.ufc.dc.tpi.enums.Tamanho;
import br.ufc.dc.tpi.itens.AcsBraço;
import br.ufc.dc.tpi.itens.AcsCabeça;
import br.ufc.dc.tpi.itens.AcsPescoço;
import br.ufc.dc.tpi.itens.Calçados;
import br.ufc.dc.tpi.itens.Itens;
import br.ufc.dc.tpi.itens.ParteInferiorCintura;
import br.ufc.dc.tpi.itens.ParteSuperiorExt;
import br.ufc.dc.tpi.itens.ParteSuperiorInt;
import br.ufc.dc.tpi.itens.Roupas;
import br.ufc.dc.tpi.itens.RoupasCorpo;
import br.ufc.dc.tpi.itens.RoupasIntimas;
import br.ufc.dc.tpi.vestuario.BancoItens;

public class JanelaEditar extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private final File arqvitens = new File("itens.dat");
	
	public JanelaEditar(Itens i) throws ParseException {
	super("EDITAR");
	BancoItens itens = BancoItens.get_instancia();
	itens.insereBancoItens(carregaItens());
	itens.remover_item(i);
	setLayout(null);
    setSize(1200, 700);
    setLocationRelativeTo(null);
    getContentPane().setBackground(Color.decode("#5c4f79"));
    
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    addWindowListener(new WindowAdapter() {

        public void windowClosing(WindowEvent e) {
        	itens.registrar_item(i);
			salvaItens(itens.getBancoItens());
            JanelaItens cadastro = new JanelaItens();
        }
    });
    
    JPanel painel = new JPanel();
    painel.setBounds(50, 30, 1100,620);
    painel.setBackground(Color.decode("#96b5ad"));
    painel.setLayout(null);
    
    
    JTextField nome = new JTextField();
    nome.setBounds(10, 70, 190, 30);
    JLabel labelnome = new JLabel("NOME: ");
    labelnome.setForeground(Color.WHITE);
    labelnome.setBounds(10, 50, 190, 20);
    
    
    
    JTextField cor = new JTextField();
    cor.setBounds(240,140, 60, 30);
    JLabel labelCor= new JLabel("COR: ");
    labelCor.setForeground(Color.WHITE);
    labelCor.setBounds(240, 120, 190, 20);
    
    JTextField origem = new JTextField();
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
   
    
    if(i instanceof Calçados) {
    	tamanho.setVisible(false);
    	tam_calçado.setVisible(true);
    }
    if(i instanceof AcsCabeça || i instanceof AcsBraço || i instanceof AcsPescoço) {
    	tamanho.setVisible(false);
    }
    
    JButton salvar = new JButton("SALVAR");
    salvar.setBounds(10, 570, 100, 30);
    salvar.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			try {
			String inome = nome.getText();
			String icor = cor.getText();         
	        String iorigem = origem.getText();       
	        Tamanho itamanho=  (Tamanho) tamanho.getSelectedItem(); 
	        String iconservaçao = conservaçao.getSelection().getActionCommand();
	        String itam_calç = tam_calçado.getSelectedText();
	        
	        if(!inome.isBlank()) {
	        	i.modificar_nome(inome);
	        	itens.registrar_item(i);  
	        	
	        }
	        if(!icor.isBlank()) {
	        	i.modificar_cor(icor);
	        	itens.registrar_item(i);  
	        }
	        if(!iorigem.isBlank()) {
	        	i.modificar_origem(iorigem);
	        	itens.registrar_item(i);  
	        }
	        if(!iconservaçao.isBlank()) {
	        	i.modificar_conservaçao(Conservaçao.valueOf(iconservaçao));
	        	itens.registrar_item(i);  
	        }
		    
	        if(i instanceof Calçados && itam_calç.isBlank()) {
	        	Calçados calç = (Calçados) i;
	        	calç.modificar_size(itam_calç);
	        	itens.registrar_item(calç);
	        }
	        else if(!(i instanceof AcsBraço) && !(i instanceof AcsPescoço) && !(i instanceof AcsCabeça)){
	        	RoupasCorpo roupa = (RoupasCorpo) i;
	        	roupa.modificar_size(itamanho);
	        	itens.registrar_item(roupa);
	 
	        }
	        
	        
		   
		    salvaItens(itens.getBancoItens());
	        nome.setText("");
            cor.setText("");
            origem.setText("");
            conservaçao.clearSelection();
            tam_calçado.setText("");
            
            
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Ediçao incompleta", JOptionPane.ERROR_MESSAGE);
			}
			dispose();
		}
	});
    
    JButton cancelar = new JButton("CANCELAR");
    cancelar.setBounds(110, 570, 130, 30);
    cancelar.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			itens.registrar_item(i);
			salvaItens(itens.getBancoItens());
			dispose();
			
			new JanelaItens();
			
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
