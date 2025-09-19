package br.ufc.dc.tpi.itens.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ufc.dc.tpi.itens.Itens;

public class JanelaItens extends JFrame {

	private static final long serialVersionUID = 1L;
	private final File arqvitens = new File("itens.dat");
	
	
	public JanelaItens(){
		super("Itens");
		
		
		
		Map<String, Itens> itens = carregaItens();
		
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
        
        
         
        
        String[] colunas = {"NOME", "COR", "CONSERVAÇAO", "ORIGEM", "TIPO"};    
        DefaultTableModel tabela = new DefaultTableModel(colunas, 0);
   
        for(Itens i : itens.values()) {
        	tabela.addRow(new Object[] {i.get_nome(), i.get_cor(), i.get_conservaçao(), i.get_origem(), i.getClass().toString()});
        }
        
        JPanel mostraritens = new JPanel();
        mostraritens.setLayout(new BoxLayout(mostraritens, BoxLayout.Y_AXIS));
        
        JTable tabelaitens = new JTable(tabela);
       
        tabelaitens.setRowHeight(20);
        tabelaitens.getColumnModel().getColumn(0).setPreferredWidth(200); 
        tabelaitens.getColumnModel().getColumn(1).setPreferredWidth(80); 
        tabelaitens.getColumnModel().getColumn(2).setPreferredWidth(90); 
        tabelaitens.getColumnModel().getColumn(3).setPreferredWidth(150); 
        tabelaitens.getColumnModel().getColumn(4).setPreferredWidth(120);
        
        
        
        JButton excluir= new JButton("EXCLUIR");
		JButton editar = new JButton("EDITAR");
		 
		 excluir.addActionListener(new ActionListener() {
			
			 public void actionPerformed(ActionEvent e) {
					int linhaselecionada = -1;
					linhaselecionada = tabelaitens.getSelectedRow();
					if (linhaselecionada >= 0) {
						String nome = (String)tabelaitens.getValueAt(linhaselecionada, 0);
						itens.remove(nome);
						salvaItens(itens);
						tabela.removeRow(linhaselecionada);
					} else {
						JOptionPane.showMessageDialog(null, "NENHUMA LINHA SELECIONADA");
					}
				}
		});
		 
		 editar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 int linhaselecionada = -1;
					linhaselecionada = tabelaitens.getSelectedRow();
					if (linhaselecionada >= 0) {
						String nome = (String)tabelaitens.getValueAt(linhaselecionada, 0);
						Itens i = itens.get(nome);
						try {
							JanelaEditar janela = new JanelaEditar(i);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "NENHUMA LINHA SELECIONADA");
					}
				}
		 });
		 
		 
		 
        
        
        
        
        
        JScrollPane scroll = new JScrollPane(tabelaitens);
        mostraritens.add(scroll, BorderLayout.CENTER);
        
        mostraritens.setBounds(10, 10, 1150, 450);
        excluir.setBounds(10, 500, 300, 30);
        editar.setBounds(310, 500, 300, 30);
        
        add(editar);
        add(mostraritens);
        add(excluir);
        
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
