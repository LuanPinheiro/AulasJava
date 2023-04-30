package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextPane;

import arvoregenealogica.*;
import exceptions.NatimortoNaoTemFilhoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class janela {

	private JFrame frame;
	private JTextField txtDescendentes;
	private Pessoa joao = new Filho(null, "Joao");
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janela window = new janela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbFamiliares = new JLabel("Familiares:");
		lbFamiliares.setBounds(10, 26, 68, 14);
		frame.getContentPane().add(lbFamiliares);
		
		JLabel lbDescendente = new JLabel("Descendente:");
		lbDescendente.setBounds(242, 26, 90, 14);
		frame.getContentPane().add(lbDescendente);
		
		txtDescendentes = new JTextField();
		txtDescendentes.setBounds(321, 23, 172, 20);
		frame.getContentPane().add(txtDescendentes);
		txtDescendentes.setColumns(10);
		
		JCheckBox chckbxMasculino = new JCheckBox("Masculino");
		chckbxMasculino.setBounds(242, 100, 97, 23);
		chckbxMasculino.setActionCommand("Masculino");
		frame.getContentPane().add(chckbxMasculino);
		
		JCheckBox chckbxFeminino = new JCheckBox("Feminino");
		chckbxFeminino.setBounds(396, 100, 97, 23);
		chckbxFeminino.setActionCommand("Feminino");
		frame.getContentPane().add(chckbxFeminino);
		
		final ButtonGroup checkbox = new ButtonGroup();
		checkbox.add(chckbxFeminino);
		checkbox.add(chckbxMasculino);
		
		
		final JTextPane txtAscendentes = new JTextPane();
		txtAscendentes.setEditable(false);
		txtAscendentes.setBounds(10, 328, 513, 174);
		txtAscendentes.setText(joao.getNome());
		frame.getContentPane().add(txtAscendentes);
		
		final JComboBox cbFamiliares = new JComboBox();
		cbFamiliares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa pessoa = joao.encontrarPessoa((String) cbFamiliares.getSelectedItem());
				txtAscendentes.setText(pessoa.listarAscendentes());
			}
		});
		cbFamiliares.setModel(new DefaultComboBoxModel(joao.listarDescendentes().toArray()));
		cbFamiliares.setBounds(74, 22, 147, 22);
		frame.getContentPane().add(cbFamiliares);
		
		JButton btnGerarDescendente = new JButton("Gerar Descendente");
		btnGerarDescendente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa ascendente = joao.encontrarPessoa((String) cbFamiliares.getSelectedItem());
				
				if(txtDescendentes.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio", "ERRO", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {
					System.out.println("OUTRO");
				}
				
				try {
					String escolha = checkbox.getSelection().getActionCommand();
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione o Sexo", "ERRO", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try {
					String escolha = checkbox.getSelection().getActionCommand();
					ascendente.addDescendentes(txtDescendentes.getText(), escolha);
					cbFamiliares.setModel(new DefaultComboBoxModel(joao.listarDescendentes().toArray()));
					JOptionPane.showMessageDialog(null, "Novo Descendente Adicionado", "Adicionado", JOptionPane.PLAIN_MESSAGE);
				} catch (NatimortoNaoTemFilhoException e1) {
					JOptionPane.showMessageDialog(null, "Natimorto Não Tem Descendente", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGerarDescendente.setBounds(178, 262, 147, 23);
		frame.getContentPane().add(btnGerarDescendente);
	}
}
