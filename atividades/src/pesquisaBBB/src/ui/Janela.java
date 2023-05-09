package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Participante;

public class Janela {

	private JFrame frmPesquisaBigBrother;
	private JTextField txtParticipante;
	private JTextField txtPerdedor;
	private JTextField txtPercentualJuliana;
	private JTextField txtPercentualDohmini;
	private Participante juliana = new Participante("Juliana", "001");
	private Participante dohmini = new Participante("Dohmini", "002");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
					window.frmPesquisaBigBrother.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPesquisaBigBrother = new JFrame();
		frmPesquisaBigBrother.setTitle("Pesquisa Big Brother");
		frmPesquisaBigBrother.setBounds(100, 100, 450, 300);
		frmPesquisaBigBrother.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPesquisaBigBrother.getContentPane().setLayout(null);
		
		JLabel lbTitulo = new JLabel("Vote pelo nome do participante ou por seu código");
		lbTitulo.setBounds(67, 10, 307, 21);
		frmPesquisaBigBrother.getContentPane().add(lbTitulo);
		
		JLabel lbParticipante = new JLabel("Participante:");
		lbParticipante.setBounds(23, 54, 80, 13);
		frmPesquisaBigBrother.getContentPane().add(lbParticipante);
		
		txtParticipante = new JTextField();
		txtParticipante.setBounds(102, 51, 124, 19);
		frmPesquisaBigBrother.getContentPane().add(txtParticipante);
		txtParticipante.setColumns(10);
		
		final JComboBox cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Nome", "Codigo"}));
		cbTipo.setBounds(236, 50, 93, 21);
		frmPesquisaBigBrother.getContentPane().add(cbTipo);
		
		final JButton btnVotar = new JButton("Votar");
		btnVotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entrada = txtParticipante.getText();
				String tipo = cbTipo.getSelectedItem().toString();
				
				switch(tipo) {
					case "Nome": if(entrada.equalsIgnoreCase(juliana.getNome())) {
							juliana.addVoto();
						}
						else if (entrada.equalsIgnoreCase(dohmini.getNome())) {
							dohmini.addVoto();
						}
						else {
							JOptionPane.showMessageDialog(btnVotar, "Participante não existe");
							return;
						} break;
					case "Codigo": if(entrada.equalsIgnoreCase(juliana.getCodigo())) {
						juliana.addVoto();
					}
					else if (entrada.equalsIgnoreCase(dohmini.getCodigo())) {
						dohmini.addVoto();
					}
					else {
						JOptionPane.showMessageDialog(btnVotar, "Participante não existe");
						return;
					} break;
				}
				
				JOptionPane.showMessageDialog(btnVotar, "Voto Computado");
			}
		});
		btnVotar.setBounds(102, 92, 85, 21);
		frmPesquisaBigBrother.getContentPane().add(btnVotar);
		
		JLabel lbPerdedor = new JLabel("Perdedor:");
		lbPerdedor.setBounds(23, 142, 62, 13);
		frmPesquisaBigBrother.getContentPane().add(lbPerdedor);
		
		txtPerdedor = new JTextField();
		txtPerdedor.setEditable(false);
		txtPerdedor.setBounds(102, 139, 124, 19);
		frmPesquisaBigBrother.getContentPane().add(txtPerdedor);
		txtPerdedor.setColumns(10);
		
		JLabel lbPercentualJuliana = new JLabel("Percentual Juliana(001):");
		lbPercentualJuliana.setBounds(23, 191, 141, 13);
		frmPesquisaBigBrother.getContentPane().add(lbPercentualJuliana);
		
		txtPercentualJuliana = new JTextField();
		txtPercentualJuliana.setEditable(false);
		txtPercentualJuliana.setColumns(10);
		txtPercentualJuliana.setBounds(184, 188, 124, 19);
		frmPesquisaBigBrother.getContentPane().add(txtPercentualJuliana);
		
		txtPercentualDohmini = new JTextField();
		txtPercentualDohmini.setEditable(false);
		txtPercentualDohmini.setColumns(10);
		txtPercentualDohmini.setBounds(184, 222, 124, 19);
		frmPesquisaBigBrother.getContentPane().add(txtPercentualDohmini);
		
		JLabel lbPercentualDohmini = new JLabel("Percentual Dohmini(002):");
		lbPercentualDohmini.setBounds(23, 225, 164, 13);
		frmPesquisaBigBrother.getContentPane().add(lbPercentualDohmini);
		
		final JButton btnResultado = new JButton("Resultado");
		btnResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double votosJuliana = juliana.getVotos();
				double votosDohmini = dohmini.getVotos();
				double total = votosJuliana + votosDohmini;
				
				
				double percentJuliana = votosJuliana != 0 ? (votosJuliana / total) * 100 : 0;
				double percentDohmini = votosDohmini!=0 ? (votosDohmini / total) * 100: 0;
				System.out.println("" + percentJuliana + " " + percentDohmini); 
				
				txtPercentualJuliana.setText("" + percentJuliana + "%");
				txtPercentualDohmini.setText("" + percentDohmini + "%");
				txtPerdedor.setText(percentJuliana == percentDohmini ? juliana.getNome(): percentJuliana > percentDohmini ? dohmini.getNome() : juliana.getNome());
				JOptionPane.showMessageDialog(btnResultado, "Resultado Calculado com Sucesso");
			}
		});
		btnResultado.setBounds(213, 92, 116, 21);
		frmPesquisaBigBrother.getContentPane().add(btnResultado);
	}
}
