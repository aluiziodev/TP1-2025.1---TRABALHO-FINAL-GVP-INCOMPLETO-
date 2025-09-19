package br.ufc.dc.tpi.GUI;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ufc.dc.tpi.GUI.*;
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

public class JanelaCadastroLooks extends JFrame{
	private static final long serialVersionUID = 1L;
	private final File arqvitens = new File("itens.dat");
	private final File arqvlooks = new File("looks.dat");
	
	public JanelaCadastroLooks(){
		super("Cadastro look");
		BancoItens itens = BancoItens.get_instancia();
		Map<String, Itens> itensarqv = carregaItens();
		itens.insereBancoItens(itensarqv);
		BancoLooks looks = BancoLooks.get_instancia();
		setLayout(null);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#5c4f79"));
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
  
            public void windowClosing(WindowEvent e) {
            	salvaLook(looks.get_bancoLook());
                JanelaCadastrar cadastro = new JanelaCadastrar();
            }
        });
        
        JPanel painel = new JPanel();
        painel.setBounds(50, 30, 1100,620);
        painel.setBackground(Color.decode("#96b5ad"));
        painel.setLayout(null);
        
        JLabel labelnome = new JLabel("NOME DO LOOK:");
        labelnome.setBounds(100, 280, 200, 20);
        labelnome.setForeground(Color.WHITE);
        JTextField nome = new JTextField();
        nome.setBounds(100, 300, 300, 30);
        
        JLabel labelAcessorioCabeça= new JLabel("ACESSORIO CABEÇA:");
        labelAcessorioCabeça.setForeground(Color.WHITE);
        labelAcessorioCabeça.setBounds(100, 30, 200, 20);
        JComboBox<Itens> AcsCabeça = new JComboBox<Itens>(itens.get_acessorioCabeça().toArray(new AcsCabeça[0]));
        AcsCabeça.setBounds(100, 50, 300, 30);
        
        JLabel labelAcessorioBraço= new JLabel("ACESSORIO BRAÇO:");
        labelAcessorioBraço.setForeground(Color.WHITE);
        labelAcessorioBraço.setBounds(100, 80, 200, 20);
        JComboBox<Itens> AcsBraço = new JComboBox<Itens>(itens.get_acessorioBraço().toArray(new AcsBraço[0]));
        AcsBraço.setBounds(100, 100, 300, 30);
        
        JLabel labelAcessorioPescoço= new JLabel("ACESSORIO PESCOÇO:");
        labelAcessorioPescoço.setForeground(Color.WHITE);
        labelAcessorioPescoço.setBounds(100, 130, 200, 20);
        JComboBox<Itens> AcsPescoço = new JComboBox<Itens>(itens.get_acessorioPescoço().toArray(new AcsPescoço[0]));
        AcsPescoço.setBounds(100, 150, 300, 30);
        
        JLabel labelSupInterno= new JLabel("SUPERIOR INTERNO:");
        labelSupInterno.setForeground(Color.WHITE);
        labelSupInterno.setBounds(100, 180, 200, 20);
        JComboBox<Itens> SupInterno = new JComboBox<Itens>(itens.get_supInterno().toArray(new ParteSuperiorInt[0]));
        SupInterno.setBounds(100, 200, 300, 30);
        
        JLabel labelSupExterno= new JLabel("SUPERIOR EXTERNO:");
        labelSupExterno.setForeground(Color.WHITE);
        labelSupExterno.setBounds(640, 30, 200, 20);
        JComboBox<Itens> SupExterno = new JComboBox<Itens>(itens.get_supExterno().toArray(new ParteSuperiorExt[0]));
        SupExterno.setBounds(640, 50, 300, 30);
        
        JLabel labelinferior= new JLabel("INFERIOR:");
        labelinferior.setForeground(Color.WHITE);
        labelinferior.setBounds(640, 80, 200, 20);
        JComboBox<Itens> inferior = new JComboBox<Itens>(itens.get_inferiores().toArray(new ParteInferiorCintura[0]));
        inferior.setBounds(640, 100, 300, 30);
        
        JLabel labelcalçado= new JLabel("CALÇADO:");
        labelcalçado.setForeground(Color.WHITE);
        labelcalçado.setBounds(640, 130, 200, 20);
        JComboBox<Itens> calçados = new JComboBox<Itens>(itens.get_calçados().toArray(new Calçados[0]));
        calçados.setBounds(640, 150, 300, 30);
        
        JLabel labelintimo= new JLabel("INTIMO:");
        labelintimo.setForeground(Color.WHITE);
        labelintimo.setBounds(640, 180, 200, 20);
        JComboBox<Itens> intimo = new JComboBox<Itens>(itens.get_intimos().toArray(new RoupasIntimas[0]));
        intimo.setBounds(640, 200, 300, 30);
        
        JButton salvar = new JButton("SALVAR");
        salvar.setBounds(100, 580, 100, 30);
        salvar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				try {
					AcsBraço acsbraço = (AcsBraço) AcsBraço.getSelectedItem();
					AcsCabeça acscabeça = (AcsCabeça) AcsCabeça.getSelectedItem();
					AcsPescoço acspescoço = (AcsPescoço) AcsPescoço.getSelectedItem();
					ParteSuperiorInt supint = (ParteSuperiorInt) SupInterno.getSelectedItem();
					ParteSuperiorExt supext = (ParteSuperiorExt) SupExterno.getSelectedItem();
					ParteInferiorCintura inf = (ParteInferiorCintura) inferior.getSelectedItem();
					Calçados calç = (Calçados) calçados.getSelectedItem();
					RoupasIntimas intimos = (RoupasIntimas) intimo.getSelectedItem();
					String name = nome.getText();
					 
					Look look = new Look(name);
					
					if(acsbraço != null) {
						look.montar_look(acsbraço);
					}
					if(acscabeça != null) {
						look.montar_look(acscabeça);
					}
					if(acspescoço != null) {
						look.montar_look(acspescoço);
					}
					if(supint != null) {
						look.montar_look(supint);
					}
					if(supext != null) {
						look.montar_look(supext);
					}
					if(inf != null) {
						look.montar_look(inf);
					}
					if(intimos != null) {
						look.montar_look(intimos);
					}
					if(calç != null) {
						look.montar_look(calç);
					}
					
					looks.salvarLook(look);
					
					salvaLook(looks.get_bancoLook());
					
					nome.setText("");
					
					
 				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Cadastro Invalido", JOptionPane.ERROR_MESSAGE);
				}
        	}
		});
        
        JButton cancelar = new JButton("CANCELAR");
        cancelar.setBounds(200, 580, 120, 30);
        cancelar.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent evento) {
        		dispose();
        		new JanelaCadastrar();
        	}
        });
        
        
        
        painel.add(cancelar);
        painel.add(salvar);
		painel.add(nome);
		painel.add(labelnome);
        painel.add(intimo);
        painel.add(labelintimo);
        painel.add(calçados);
        painel.add(labelcalçado);
        painel.add(inferior);
        painel.add(labelinferior);
        painel.add(SupExterno);
        painel.add(labelSupExterno);
        painel.add(SupInterno);
        painel.add(labelSupInterno);
        painel.add(AcsPescoço);
        painel.add(labelAcessorioPescoço);
        painel.add(AcsBraço);
        painel.add(labelAcessorioBraço);
        painel.add(AcsCabeça);
        painel.add(labelAcessorioCabeça);
        add(painel);
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
