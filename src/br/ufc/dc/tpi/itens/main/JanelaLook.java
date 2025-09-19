package br.ufc.dc.tpi.itens.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import br.ufc.dc.tpi.exception.NaoConstaLookException;
import br.ufc.dc.tpi.itens.AcsBraço;
import br.ufc.dc.tpi.itens.AcsCabeça;
import br.ufc.dc.tpi.itens.AcsPescoço;
import br.ufc.dc.tpi.itens.Calçados;
import br.ufc.dc.tpi.itens.Itens;
import br.ufc.dc.tpi.itens.ParteInferiorCintura;
import br.ufc.dc.tpi.itens.ParteSuperiorExt;
import br.ufc.dc.tpi.itens.ParteSuperiorInt;
import br.ufc.dc.tpi.itens.RoupasIntimas;
import br.ufc.dc.tpi.look.Look;
import br.ufc.dc.tpi.vestuario.BancoItens;
import br.ufc.dc.tpi.vestuario.BancoLooks;

public class JanelaLook extends JFrame{

	private static final long serialVersionUID = 1L;
	private final File arqvlooks = new File("looks.dat");
	private final File arqvitens = new File("itens.dat");
	
	
	
	
	public JanelaLook() {
		super("Looks");
		BancoItens itens = BancoItens.get_instancia();
		Map<String, Itens> itensarqv = carregaItens();
		itens.insereBancoItens(itensarqv);
		
		List<Look> looks = carregaLooks();
		BancoLooks bankLooks = BancoLooks.get_instancia();
		bankLooks.insereBankLook(looks);
		
		
		
		
		setLayout(null);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#5c4f79"));
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            
            public void windowClosing(WindowEvent e) {
                JanelaInicial Principal = new JanelaInicial();
            }
        });
        
        String[] colunas = {"NOME", "QUANTIDADE USOS"};    
        DefaultTableModel tabela = new DefaultTableModel(colunas, 0);
   
        for(Look l : looks) {
        	tabela.addRow(new Object[] {l.get_nome(), l.qtd_usos()});
        }
        
        JPanel mostrarlooks= new JPanel();
        mostrarlooks.setLayout(new BoxLayout(mostrarlooks, BoxLayout.Y_AXIS));
        
        JTable tabelalooks = new JTable(tabela);
       
        tabelalooks.setRowHeight(20);
        tabelalooks.getColumnModel().getColumn(0).setPreferredWidth(200); 
        tabelalooks.getColumnModel().getColumn(1).setPreferredWidth(80); 
        
        
        JButton excluir = new JButton("EXCLUIR");
        
        excluir.setBounds(10, 500, 300, 30);

        
        excluir.addActionListener(new ActionListener() {
			
			 public void actionPerformed(ActionEvent e) {
					int linhaselecionada = -1;
					linhaselecionada = tabelalooks.getSelectedRow();
					if (linhaselecionada >= 0) {
						String nome = (String)tabelalooks.getValueAt(linhaselecionada, 0);
						try {
							looks.remove(bankLooks.get_look(nome));
						} catch (NaoConstaLookException e1) {
							
							e1.printStackTrace();
						}
						salvaLook(looks);
						tabela.removeRow(linhaselecionada);
						
					} else {
						JOptionPane.showMessageDialog(null, "NENHUMA LINHA SELECIONADA");
					}
				}
		});
        
     
        
        
        
     
        
        
        JScrollPane scroll = new JScrollPane(tabelalooks);
        mostrarlooks.add(scroll, BorderLayout.CENTER);
        
        mostrarlooks.setBounds(10, 10, 1150, 450);
      
        add(excluir);
        add(mostrarlooks);
        setVisible(true);
        
        
	}
	
	
	public void salvaLook(List<Look> looks) {
		 try(FileOutputStream fos = new FileOutputStream(arqvlooks);
				  ObjectOutputStream oos = new ObjectOutputStream(fos)){
			  oos.writeObject(looks);
			  oos.close();
		  }catch(Exception e) {
			  JOptionPane.showMessageDialog(this, "ERRO AO SALVAR: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		  }
	}
	
	public List<Look> carregaLooks(){
		List<Look> looksArqv = new ArrayList<>();
        if (!arqvlooks.exists()) return looksArqv;
        
        try (FileInputStream arqv = new FileInputStream(arqvlooks);
             ObjectInputStream obj = new ObjectInputStream(arqv)) {
            looksArqv = (List<Look>) obj.readObject();
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(this, "ERRO AO CARREGAR: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
       

        return looksArqv;
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
