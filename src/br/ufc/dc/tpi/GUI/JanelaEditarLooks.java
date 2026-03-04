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
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ufc.dc.tpi.exception.CadastroInvalidoException;
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

public class JanelaEditarLooks extends JFrame {
    private static final long serialVersionUID = 1L;
	private final File arqvitens = new File("itens.dat");
	private final File arqvlooks = new File("looks.dat");

    public JanelaEditarLooks(Look l) throws ParseException{
        super("EDITAR LOOKS");
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
                looks.salvarLook(l);
                salvaLook(looks.get_bancoLook());
                JanelaLook Jlook = new JanelaLook();
            }
        });

        HashMap<Class<? extends Itens>, Itens> itensLook = l.getItens();
        Vector<Itens> inicio = new Vector<>();
        JPanel painel = new JPanel();
        painel.setBounds(50, 30, 1100,620);
        painel.setBackground(Color.decode("#96b5ad"));
        painel.setLayout(null);
        
        
        JLabel labelAcessorioCabeça= new JLabel("ACESSORIO CABEÇA:");
        labelAcessorioCabeça.setForeground(Color.WHITE);
        labelAcessorioCabeça.setBounds(100, 30, 200, 20);
        JComboBox<Itens> AcsCabeça = new JComboBox<Itens>();
        AcsCabeça.addItem(null);
        for(AcsCabeça ac : itens.get_acessorioCabeça().toArray(new AcsCabeça[0])){
            AcsCabeça.addItem(ac);
            if(itensLook.get(AcsCabeça.class) != null && itensLook.get(AcsCabeça.class).get_nome().equals(ac.get_nome())){
                AcsCabeça.setSelectedItem(ac);
                inicio.add(ac);
            }
            
        }
        AcsCabeça.setBounds(100, 50, 300, 30);
        
        JLabel labelAcessorioBraço= new JLabel("ACESSORIO BRAÇO:");
        labelAcessorioBraço.setForeground(Color.WHITE);
        labelAcessorioBraço.setBounds(100, 80, 200, 20);
        JComboBox<Itens> AcsBraço = new JComboBox<Itens>();
        AcsBraço.addItem(null);
        for(AcsBraço ab : itens.get_acessorioBraço().toArray(new AcsBraço[0])){
            AcsBraço.addItem(ab);
            if(itensLook.get(AcsBraço.class) != null && itensLook.get(AcsBraço.class).get_nome().equals(ab.get_nome())){
                AcsBraço.setSelectedItem(ab);
                inicio.add(ab);
            } 
        }
        AcsBraço.setBounds(100, 100, 300, 30);
        
        JLabel labelAcessorioPescoço= new JLabel("ACESSORIO PESCOÇO:");
        labelAcessorioPescoço.setForeground(Color.WHITE);
        labelAcessorioPescoço.setBounds(100, 130, 200, 20);
        JComboBox<Itens> AcsPescoço = new JComboBox<Itens>();
        AcsPescoço.addItem(null);
        for(AcsPescoço ap : itens.get_acessorioPescoço().toArray(new AcsPescoço[0])){
            AcsPescoço.addItem(ap);
            if(itensLook.get(AcsPescoço.class) != null && itensLook.get(AcsPescoço.class).get_nome().equals(ap.get_nome())){
                AcsPescoço.setSelectedItem(ap);
                inicio.add(ap);
            }
        }
        AcsPescoço.setBounds(100, 150, 300, 30);
        
        JLabel labelSupInterno= new JLabel("SUPERIOR INTERNO:");
        labelSupInterno.setForeground(Color.WHITE);
        labelSupInterno.setBounds(100, 180, 200, 20);
        JComboBox<Itens> SupInterno = new JComboBox<Itens>();
        for(ParteSuperiorInt supInt : itens.get_supInterno().toArray(new ParteSuperiorInt[0])){
            SupInterno.addItem(supInt);
            if(itensLook.get(ParteSuperiorInt.class) != null && itensLook.get(ParteSuperiorInt.class).get_nome().equals(supInt.get_nome())){
                SupInterno.setSelectedItem(supInt);
                inicio.add(supInt);
            }
        }
        SupInterno.setBounds(100, 200, 300, 30);
        
        JLabel labelSupExterno= new JLabel("SUPERIOR EXTERNO:");
        labelSupExterno.setForeground(Color.WHITE);
        labelSupExterno.setBounds(640, 30, 200, 20);
        JComboBox<Itens> SupExterno = new JComboBox<Itens>();
        SupExterno.addItem(null);
        for(ParteSuperiorExt supExt : itens.get_supExterno().toArray(new ParteSuperiorExt[0])){
            SupExterno.addItem(supExt);
            if(itensLook.get(ParteSuperiorExt.class) != null && itensLook.get(ParteSuperiorExt.class).get_nome().equals(supExt.get_nome())){
                SupExterno.setSelectedItem(supExt);
                inicio.add(supExt);
            }
        }
        SupExterno.setBounds(640, 50, 300, 30);
        
        JLabel labelinferior= new JLabel("INFERIOR:");
        labelinferior.setForeground(Color.WHITE);
        labelinferior.setBounds(640, 80, 200, 20);
        JComboBox<Itens> inferior = new JComboBox<Itens>();
        for(ParteInferiorCintura inf : itens.get_inferiores().toArray(new ParteInferiorCintura[0])){
            inferior.addItem(inf);
            if(itensLook.get(ParteInferiorCintura.class) != null && itensLook.get(ParteInferiorCintura.class).get_nome().equals(inf.get_nome())){
                inferior.setSelectedItem(inf);
                inicio.add(inf);
            }
        }
        inferior.setBounds(640, 100, 300, 30);
        
        JLabel labelcalçado= new JLabel("CALÇADO:");
        labelcalçado.setForeground(Color.WHITE);
        labelcalçado.setBounds(640, 130, 200, 20);
        JComboBox<Itens> calçados = new JComboBox<Itens>();
        calçados.addItem(null);
        for(Calçados calc : itens.get_calçados().toArray(new Calçados[0])){
            calçados.addItem(calc);
            if(itensLook.get(Calçados.class) != null && itensLook.get(Calçados.class).get_nome().equals(calc.get_nome())){
                calçados.setSelectedItem(calc);
                inicio.add(calc);
            }
        }
        calçados.setBounds(640, 150, 300, 30);
        
        JLabel labelintimo= new JLabel("INTIMO:");
        labelintimo.setForeground(Color.WHITE);
        labelintimo.setBounds(640, 180, 200, 20);
        JComboBox<Itens> intimo = new JComboBox<Itens>();
        for(RoupasIntimas intm : itens.get_intimos().toArray(new RoupasIntimas[0])){
            intimo.addItem(intm);
            if(itensLook.get(RoupasIntimas.class) != null && itensLook.get(RoupasIntimas.class).get_nome().equals(intm.get_nome())){
                intimo.setSelectedItem(intm);
                inicio.add(intm);
            }
        }
        intimo.setBounds(640, 200, 300, 30);

        JButton salvar = new JButton("SALVAR");
        salvar.setBounds(100, 580, 100, 30);
        salvar.addActionListener(e -> {
            try {
                Vector<Itens> selecionados = new Vector<>();
                AcsBraço acsbraço = (AcsBraço) AcsBraço.getSelectedItem();
                boolean selAcsBraço = acsbraço != null;
                AcsCabeça acscabeça = (AcsCabeça) AcsCabeça.getSelectedItem();
                boolean selAcsCabeça = acscabeça != null;
                AcsPescoço acspescoço = (AcsPescoço) AcsPescoço.getSelectedItem();
                boolean selAcsPescoço = acspescoço != null;
                ParteSuperiorInt supint = (ParteSuperiorInt) SupInterno.getSelectedItem();
                boolean selSupInt = supint != null;
                ParteSuperiorExt supext = (ParteSuperiorExt) SupExterno.getSelectedItem();
                boolean selSupExt = supext != null;
                ParteInferiorCintura inf = (ParteInferiorCintura) inferior.getSelectedItem();
                boolean selInf = inf != null;
                Calçados calç = (Calçados) calçados.getSelectedItem();
                boolean selCalç = calç != null;
                RoupasIntimas intimos = (RoupasIntimas) intimo.getSelectedItem();
                boolean selIntimos = intimos != null;

                
                if(selAcsBraço) {
                    l.modifica_look(acsbraço);
                    selecionados.add(acsbraço);
                }
                else{
                    if(itensLook.get(AcsCabeça.class) != null){
                        l.remover(itensLook.get(AcsCabeça.class));
                    }
                }
                if(selAcsCabeça) {
                    l.modifica_look(acscabeça);
                    selecionados.add(acscabeça);
                }
                else{
                    if(itensLook.get(AcsCabeça.class) != null){
                        l.remover(itensLook.get(AcsCabeça.class));
                    }
                }
                if(selAcsPescoço) {
                    l.modifica_look(acspescoço);
                    selecionados.add(acspescoço);
                }
                else{
                    if(itensLook.get(AcsPescoço.class) != null){
                        l.remover(itensLook.get(AcsPescoço.class));
                    }
                }
                if(selSupInt) {
                    l.modifica_look(supint);
                    selecionados.add(supint);
                }
                if(selSupExt) {
                    l.modifica_look(supext);
                    selecionados.add(supext);
                }
                else{
                    if(itensLook.get(ParteSuperiorExt.class) != null){
                        l.remover(itensLook.get(ParteSuperiorExt.class));
                    }
                }
                if(selInf) {
                    l.modifica_look(inf);
                    selecionados.add(inf);
                }
                if(selIntimos) {
                    l.modifica_look(intimos);
                    selecionados.add(intimos);
                }
                if(selCalç) {
                    l.modifica_look(calç);
                    selecionados.add(calç);
                }
                else{
                    if(itensLook.get(Calçados.class) != null){
                        l.remover(itensLook.get(Calçados.class));
                    }
                }

                if(selecionados.size() == 0 || selecionados.equals(inicio)){
                    int opt = JOptionPane.showConfirmDialog(this,
                        "Nenhum campo foi alterado.\nDeseja sair sem modificar o look?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                    );
                    if(opt == JOptionPane.NO_OPTION){
                        return;
                    }
                    looks.salvarLook(l);
                    salvaLook(looks.get_bancoLook());
                    dispose();
                    new JanelaLook();
                    return;
                }
                
                looks.salvarLook(l);
                
                salvaLook(looks.get_bancoLook());

                JOptionPane.showMessageDialog(this, "Look Editado com sucesso!");
                
            }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Cadastro Invalido", 
                JOptionPane.ERROR_MESSAGE);
            }
            dispose();
		});

        JButton cancelar = new JButton("CANCELAR");
        cancelar.setBounds(200, 580, 120, 30);
        cancelar.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent evento) {
                looks.salvarLook(l);
                salvaLook(looks.get_bancoLook());
        		dispose();
        		new JanelaLook();
        	}
        });


        painel.add(cancelar);
        painel.add(salvar);
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

