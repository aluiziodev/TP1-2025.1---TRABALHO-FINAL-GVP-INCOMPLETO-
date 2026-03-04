package br.ufc.dc.tpi.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ufc.dc.tpi.itens.Itens;
import br.ufc.dc.tpi.itens.Roupas;

public class JanelaEstatisticaItens extends JFrame{
    private static final long serialVersionUID = 1L;
	private final File arqvitens = new File("itens.dat");
	
    public JanelaEstatisticaItens(){
        super("Estatistica Itens");
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

        String[] colunas = {"NOME", "QTD DE USOS", "QTD DE LAVAGENS", "ULTIMA LAVAGEM"};    
        DefaultTableModel tabela = new DefaultTableModel(colunas, 0);

        for(Itens i : itens.values()) {
            if(i instanceof Roupas){
                Roupas r = (Roupas) i;
                tabela.addRow(new Object[] {r.get_nome(), r.get_usos(), r.qtd_lavagens(), r.get_ultima_lavagem()});
            }
            else{
                tabela.addRow(new Object[] {i.get_nome(), i.get_usos(), "N/A", "N/A"});
            }
        	
        }

        JPanel mostraritens = new JPanel();
        mostraritens.setLayout(new BoxLayout(mostraritens, BoxLayout.Y_AXIS));
        
        JTable tabelaitens = new JTable(tabela);
       
        tabelaitens.setRowHeight(20);
        tabelaitens.getColumnModel().getColumn(0).setPreferredWidth(200); 
        tabelaitens.getColumnModel().getColumn(1).setPreferredWidth(80); 
        tabelaitens.getColumnModel().getColumn(2).setPreferredWidth(90); 
        tabelaitens.getColumnModel().getColumn(3).setPreferredWidth(150); 

        JScrollPane scroll = new JScrollPane(tabelaitens);
        mostraritens.add(scroll, BorderLayout.CENTER);
        
        mostraritens.setBounds(10, 10, 1150, 450);
        
        add(mostraritens);
        
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
