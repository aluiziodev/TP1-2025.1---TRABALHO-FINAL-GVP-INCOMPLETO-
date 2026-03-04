package br.ufc.dc.tpi.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import br.ufc.dc.tpi.itens.Roupas;
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
		JButton editar = new JButton("EDITAR");
		JButton visualizar = new JButton("VISUALIZAR");
		JButton usar = new JButton("USAR");
        
        excluir.setBounds(0, 500, 300, 30);
		editar.setBounds(300, 500, 300, 30);
		visualizar.setBounds(600, 500, 300, 30);
		usar.setBounds(900, 500, 300, 30);
		

        
        excluir.addActionListener( e -> {
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
		});


		editar.addActionListener( e-> {
			int linhaselecionada = -1;
			linhaselecionada = tabelalooks.getSelectedRow();
			if (linhaselecionada >= 0) {
				String nome = (String)tabelalooks.getValueAt(linhaselecionada, 0);
				try{
					Look l = bankLooks.get_look(nome);
					try{
						JanelaEditarLooks jEditarlooks = new JanelaEditarLooks(l);
					}catch (ParseException e2) {
					e2.printStackTrace();
				}
				}catch (NaoConstaLookException e1 ) {
					
					e1.printStackTrace();
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "NENHUMA LINHA SELECIONADA");
			}
		});
        

		visualizar.addActionListener(e -> {

			int linha = tabelalooks.getSelectedRow();

			if (linha < 0) {
				JOptionPane.showMessageDialog(this, "SELECIONE UM LOOK");
				return;
			}

			String nomeLook = (String) tabelalooks.getValueAt(linha, 0);

			Look lookSelecionado;
			try {
				lookSelecionado = bankLooks.get_look(nomeLook);
			} catch (NaoConstaLookException ex) {
				JOptionPane.showMessageDialog(this, "LOOK NÃO ENCONTRADO");
				return;
			}

			abrirAbaVisu(lookSelecionado);
		});

		usar.addActionListener( e -> {
			int linhaselecionada = -1;
			linhaselecionada = tabelalooks.getSelectedRow();
			if (linhaselecionada >= 0) {
				String nome = (String)tabelalooks.getValueAt(linhaselecionada, 0);
				try{
					Look l = bankLooks.get_look(nome);
					JSpinner spinner = new JSpinner( new SpinnerDateModel());
					JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
					spinner.setEditor(editor);
					JTextField tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
					((JFormattedTextField) tf).setFocusLostBehavior(JFormattedTextField.PERSIST);

					JTextField evento = new JTextField();
					JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
					panel.add(new JLabel("Data:"));
					panel.add(spinner);
					panel.add(new JLabel("Evento:"));
					panel.add(evento);
					int resultado = JOptionPane.showConfirmDialog(
						this,
						panel,
						"Registrar uso",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE
					);
					if (resultado == JOptionPane.OK_OPTION) {
						try {
							String textoEvent = evento.getText().trim();
							if(textoEvent.isEmpty()){
								throw new IllegalArgumentException(
									"O campo de evento não pode estar vazio!");
							}
							
							spinner.commitEdit();
							Date data = (Date) spinner.getValue();
							Date hoje = new Date();
							if(data.after(hoje)){
								throw new IllegalArgumentException(
									"A data do evento não pode ser futura!");
							}
							GregorianCalendar gc = new GregorianCalendar();
							gc.setTime(data);

							l.registrar_utilizaçao(textoEvent, gc);
							salvaLook(bankLooks.get_bancoLook());
							tabela.setValueAt(l.qtd_usos(), linhaselecionada, 1);
						

							JOptionPane.showMessageDialog(this, "Uso registrado com sucesso!");

						} catch (ParseException | IllegalArgumentException ex) {
							JOptionPane.showMessageDialog(
								this,
								ex.getMessage(),
								"Erro",
								JOptionPane.ERROR_MESSAGE
							);
						}
					}

				}catch (NaoConstaLookException e1 ) {
					
					e1.printStackTrace();
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "NENHUMA LINHA SELECIONADA");
			}
		});
			
        
        
        
     
        
        
        JScrollPane scroll = new JScrollPane(tabelalooks);
        mostrarlooks.add(scroll, BorderLayout.CENTER);
        
        mostrarlooks.setBounds(10, 10, 1150, 450);
      
        add(excluir);
		add(editar);
		add(visualizar);
		add(usar);
        add(mostrarlooks);
        setVisible(true);
        
        
	}

	private void abrirAbaVisu(Look l){
		JDialog dialog = new JDialog(this, "Itens do Look: " + l.get_nome(), true);
		dialog.setSize(600, 400);
		dialog.setLocationRelativeTo(this);
		dialog.setLayout(new BorderLayout());

		String[] colunas = {"Nome", "Tipo", "Cor", "Tamanho"};
		DefaultTableModel model = new DefaultTableModel(colunas, 0);

		HashMap<Class<? extends Itens>, Itens> itens_look = l.getItens();

		for(Entry<Class<? extends Itens>, Itens> chave : itens_look.entrySet()) {
			Class<? extends Itens> ch = chave.getKey();
			Itens i = chave.getValue();
			
			if(i!=null) {
				String tipo = i.getClass().getSimpleName();
				model.addRow(new Object[] {
				i.get_nome(),
				tipo,
				i.get_cor(),
				i.get_conservaçao(),
				i.get_origem()
				});
			}
			
		}


		JTable tabelaItens = new JTable(model);
		JScrollPane scroll = new JScrollPane(tabelaItens);

		JButton fechar = new JButton("FECHAR");
		fechar.addActionListener(e -> dialog.dispose());

		JPanel rodape = new JPanel();
		rodape.add(fechar);

		dialog.add(scroll, BorderLayout.CENTER);
		dialog.add(rodape, BorderLayout.SOUTH);

		dialog.setVisible(true);
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
