package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import exceptions.ProfessorNaoTemSubordinadoException;
import negocio.Coordenador;
import negocio.Pesquisador;
import javax.swing.DefaultComboBoxModel;

public class Janela {

	private JFrame frmTeste;
	private JTextField txtNomePesquisador;
	private Pesquisador mara = new Coordenador("Mara Andrade", null);
	private JTextField txtQtdSubordinados;
	private JTextField txtValorPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
					window.frmTeste.setVisible(true);
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
		frmTeste = new JFrame();
		frmTeste.setTitle("Teste");
		frmTeste.setBounds(100, 100, 536, 525);
		frmTeste.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmTeste.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelCadastro = new JPanel();
		tabbedPane.addTab("Cadastro", null, panelCadastro, null);
		panelCadastro.setLayout(null);
		
		JLabel lbNomePesquisador = new JLabel("Nome do Pesquisador:");
		lbNomePesquisador.setBounds(31, 59, 141, 13);
		panelCadastro.add(lbNomePesquisador);
		
		txtNomePesquisador = new JTextField();
		txtNomePesquisador.setBounds(182, 56, 185, 19);
		panelCadastro.add(txtNomePesquisador);
		txtNomePesquisador.setColumns(10);
		
		JLabel lbTipo = new JLabel("Tipo:");
		lbTipo.setBounds(31, 114, 45, 13);
		panelCadastro.add(lbTipo);
		
		JRadioButton btnCoordenador = new JRadioButton("Coordenador");
		btnCoordenador.setSelected(true);
		btnCoordenador.setBounds(85, 110, 103, 21);
		btnCoordenador.setActionCommand("Coordenador");
		panelCadastro.add(btnCoordenador);
		
		JRadioButton btnProfessor = new JRadioButton("Professor");
		btnProfessor.setBounds(217, 110, 103, 21);
		btnProfessor.setActionCommand("Professor");
		panelCadastro.add(btnProfessor);
		
		JPanel panelConsulta = new JPanel();
		tabbedPane.addTab("Consulta", null, panelConsulta, null);
		panelConsulta.setLayout(null);
		
		JLabel lbNomePesquisadorConsulta = new JLabel("Nome Pesquisador:");
		lbNomePesquisadorConsulta.setBounds(34, 43, 104, 13);
		panelConsulta.add(lbNomePesquisadorConsulta);
		
		final JComboBox cbPesquisadores = new JComboBox();
		cbPesquisadores.setBounds(148, 39, 133, 21);
		panelConsulta.add(cbPesquisadores);
		
		final ButtonGroup tipo = new ButtonGroup();
		tipo.add(btnProfessor);
		tipo.add(btnCoordenador);
		
		JLabel lbCoordenador = new JLabel("Coordenador:");
		lbCoordenador.setBounds(31, 177, 97, 13);
		panelCadastro.add(lbCoordenador);
		
		final JComboBox cbCoordenadores = new JComboBox();
		cbCoordenadores.setBounds(138, 173, 141, 21);
		panelCadastro.add(cbCoordenadores);
		cbCoordenadores.addItem(mara.getNome());
		cbPesquisadores.addItem(mara.getNome());
		
		JLabel lbQtdPesquisadores = new JLabel("Quantidade de Subordinados:");
		lbQtdPesquisadores.setBounds(34, 193, 151, 13);
		panelConsulta.add(lbQtdPesquisadores);
		
		txtQtdSubordinados = new JTextField();
		txtQtdSubordinados.setEditable(false);
		txtQtdSubordinados.setBounds(195, 190, 75, 19);
		panelConsulta.add(txtQtdSubordinados);
		txtQtdSubordinados.setColumns(10);
		
		JLabel lbValorPago = new JLabel("Valor Pago:");
		lbValorPago.setBounds(34, 239, 75, 13);
		panelConsulta.add(lbValorPago);
		
		txtValorPago = new JTextField();
		txtValorPago.setEditable(false);
		txtValorPago.setBounds(119, 236, 75, 19);
		panelConsulta.add(txtValorPago);
		txtValorPago.setColumns(10);
		
		final JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNomePesquisador.getText();
				String tipoPesquisador = tipo.getSelection().getActionCommand();
				Pesquisador superior = mara.encontrarPesquisador(cbCoordenadores.getSelectedItem().toString());
				
				if(nome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nome Não Pode Ser Vazio", "ERRO", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					superior.addPesquisador(nome, tipoPesquisador);
					if(tipoPesquisador.equalsIgnoreCase("Coordenador")){
						cbCoordenadores.addItem(nome);
					}
					cbPesquisadores.addItem(nome);
					JOptionPane.showMessageDialog(btnCadastrar, tipoPesquisador + " Adicionado", "SUCESSO", JOptionPane.PLAIN_MESSAGE);
				} catch (ProfessorNaoTemSubordinadoException e1) {
					JOptionPane.showMessageDialog(btnCadastrar, "Professor Não Pode Ter Subordinado", "ERRO", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnCadastrar.setBounds(182, 360, 131, 21);
		panelCadastro.add(btnCadastrar);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pesquisador pesquisador = mara.encontrarPesquisador(cbPesquisadores.getSelectedItem().toString());
				txtValorPago.setText(""+pesquisador.getValorPago());
				txtQtdSubordinados.setText(""+ pesquisador.qtdSubordinados());
			}
		});
		btnConsulta.setBounds(34, 108, 85, 21);
		panelConsulta.add(btnConsulta);
	}
}
