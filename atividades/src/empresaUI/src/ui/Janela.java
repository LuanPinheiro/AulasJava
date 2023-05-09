package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import exceptions.EmpregadoNaoTemSubordinadoException;
import negocio.Chefe;
import negocio.Pessoa;
import javax.swing.JScrollBar;

public class Janela {

	private JFrame Empresa;
	private JTextField txtNomePessoa;
	private Chefe antonio = new Chefe("Antônio", null);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
					window.Empresa.setVisible(true);
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
		Empresa = new JFrame();
		Empresa.setTitle("Hamburgão S.A");
		Empresa.setBounds(100, 100, 450, 300);
		Empresa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		Empresa.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelCadastro = new JPanel();
		tabbedPane.addTab("Cadastro", null, panelCadastro, null);
		panelCadastro.setLayout(null);
		
		JLabel lbNomePessoa = new JLabel("Nome:");
		lbNomePessoa.setBounds(21, 29, 45, 13);
		panelCadastro.add(lbNomePessoa);
		
		txtNomePessoa = new JTextField();
		txtNomePessoa.setBounds(76, 26, 162, 19);
		panelCadastro.add(txtNomePessoa);
		txtNomePessoa.setColumns(10);
		
		JLabel lbSuperior = new JLabel("Superior:");
		lbSuperior.setBounds(21, 79, 57, 13);
		panelCadastro.add(lbSuperior);
		
		final JComboBox cbSuperiores = new JComboBox();
		cbSuperiores.setBounds(76, 75, 162, 21);
		cbSuperiores.addItem(antonio.getNome());
		panelCadastro.add(cbSuperiores);
		
		JLabel lbTipo = new JLabel("Tipo:");
		lbTipo.setBounds(21, 136, 45, 13);
		panelCadastro.add(lbTipo);
		
		JRadioButton btnEmpregado = new JRadioButton("Empregado");
		btnEmpregado.setSelected(true);
		btnEmpregado.setActionCommand("Empregado");
		btnEmpregado.setBounds(76, 132, 103, 21);
		panelCadastro.add(btnEmpregado);
		
		JRadioButton btnChefe = new JRadioButton("Chefe");
		btnChefe.setBounds(181, 132, 103, 21);
		btnChefe.setActionCommand("Chefe");
		panelCadastro.add(btnChefe);
		
		JPanel panelConsulta = new JPanel();
		tabbedPane.addTab("Consulta", null, panelConsulta, null);
		panelConsulta.setLayout(null);
		
		JLabel lbNomeColaborador = new JLabel("Nome do Colaborador:");
		lbNomeColaborador.setBounds(21, 10, 119, 13);
		panelConsulta.add(lbNomeColaborador);
		
		final JComboBox cbColaboradores = new JComboBox();
		cbColaboradores.setBounds(150, 6, 138, 21);
		cbColaboradores.addItem(antonio.getNome());
		panelConsulta.add(cbColaboradores);
		
		JLabel lbTipoConsulta = new JLabel("Tipo de Consulta:");
		lbTipoConsulta.setBounds(21, 67, 93, 13);
		panelConsulta.add(lbTipoConsulta);
		
		final JComboBox cbTipoConsulta = new JComboBox();
		cbTipoConsulta.setModel(new DefaultComboBoxModel(new String[] {"Superiores", "Colaboradores"}));
		cbTipoConsulta.setBounds(150, 63, 138, 21);
		panelConsulta.add(cbTipoConsulta);
		
		final JTextPane txtLista = new JTextPane();
		txtLista.setEditable(false);
		txtLista.setBounds(21, 138, 381, 88);
		panelConsulta.add(txtLista);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = cbColaboradores.getSelectedItem().toString();
				Pessoa colaborador = antonio.encontrarColaborador(nome);
				String tipoConsulta = cbTipoConsulta.getSelectedItem().toString();
				
				if(tipoConsulta.equalsIgnoreCase("Superiores")) {
					txtLista.setText(colaborador.getListaSuperiores());
				}
				else {
					txtLista.setText(colaborador.getListaColaboradores());
				}
			}
		});
		btnConsulta.setBounds(167, 107, 108, 21);
		panelConsulta.add(btnConsulta);
		
		
		final ButtonGroup tipo = new ButtonGroup();
		tipo.add(btnChefe);
		tipo.add(btnEmpregado);
		
		final JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNomePessoa.getText();
				Pessoa superior = antonio.encontrarColaborador(cbSuperiores.getSelectedItem().toString());
				String tipoColaborador = tipo.getSelection().getActionCommand().toString();
				
				try {
					superior.addColaborador(nome, tipoColaborador);
					if(tipoColaborador.equalsIgnoreCase("Chefe")) {
						cbSuperiores.addItem(nome);
					}
					cbColaboradores.addItem(nome);
					JOptionPane.showMessageDialog(btnCadastrar, tipoColaborador + " Adicionado", "SUCESSO", JOptionPane.PLAIN_MESSAGE);
				} catch (EmpregadoNaoTemSubordinadoException e1) {
					JOptionPane.showMessageDialog(btnCadastrar, "Empregado Não Pode Ter Subordinado", "SUCESSO", JOptionPane.ERROR);
				}
			}
		});
		btnCadastrar.setBounds(168, 186, 116, 21);
		panelCadastro.add(btnCadastrar);
	}
}
