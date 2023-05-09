package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

import negocio.Forca;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Janela {

	private JFrame frame;
	private Forca forca = new Forca();
	private JTextField txtLetra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
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
	public Janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelCategoria = new JPanel();
		tabbedPane.addTab("Categoria", null, panelCategoria, null);
		panelCategoria.setLayout(null);
		
		JRadioButton btnFilmes = new JRadioButton("Filmes");
		btnFilmes.setActionCommand("Filmes");
		btnFilmes.setSelected(true);
		btnFilmes.setBounds(141, 19, 103, 21);
		panelCategoria.add(btnFilmes);
		
		JRadioButton btnNovelas = new JRadioButton("Novelas");
		btnNovelas.setActionCommand("Novelas");
		btnNovelas.setBounds(141, 73, 103, 21);
		panelCategoria.add(btnNovelas);
		
		JRadioButton btnCarros = new JRadioButton("Carros");
		btnCarros.setActionCommand("Carros");
		btnCarros.setBounds(141, 130, 103, 21);
		panelCategoria.add(btnCarros);
		
		final ButtonGroup categorias = new ButtonGroup();
		
		
		
		JPanel panelJogo = new JPanel();
		tabbedPane.addTab("Jogo", null, panelJogo, null);
		panelJogo.setLayout(null);
		
		JLabel lbImagem = new JLabel("INSIRA IMAGEM AQUI");
		lbImagem.setBounds(21, 25, 120, 50);
		panelJogo.add(lbImagem);
		
		JLabel lbLetra = new JLabel("Letra:");
		lbLetra.setBounds(205, 44, 45, 13);
		panelJogo.add(lbLetra);
		
		txtLetra = new JTextField();
		txtLetra.setEditable(false);
		txtLetra.setBounds(260, 41, 59, 19);
		panelJogo.add(txtLetra);
		txtLetra.setColumns(10);
		
		final JLabel lbTentativas = new JLabel("Tentativas:");
		lbTentativas.setBounds(205, 146, 196, 13);
		panelJogo.add(lbTentativas);
		
		final JLabel lbPalavra = new JLabel(" ");
		lbPalavra.setBounds(21, 158, 160, 13);
		panelJogo.add(lbPalavra);
		
		categorias.add(btnCarros);
		categorias.add(btnNovelas);
		categorias.add(btnFilmes);
		
		final JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forca.setCategoria(categorias.getSelection().getActionCommand());
				forca.setPalavra();
				forca.setErros(0);
				
				lbPalavra.setText(forca.gerarUnderline());
				lbTentativas.setText("");
				txtLetra.setEditable(true);
				JOptionPane.showMessageDialog(btnIniciar, "Jogo Iniciado");
			}
		});
		btnIniciar.setBounds(134, 186, 85, 21);
		panelCategoria.add(btnIniciar);
		
		final JButton btnTentativa = new JButton("Tentar");
		btnTentativa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String letra = txtLetra.getText().toUpperCase();
				if(!lbTentativas.getText().equalsIgnoreCase(" ")) {
					if(lbTentativas.getText().contains(letra)) {
						JOptionPane.showMessageDialog(btnTentativa, "Tentativa já realizada");
						return;
					}
				}
				lbTentativas.setText(forca.addTentativa(letra, lbTentativas.getText()));
				lbPalavra.setText(forca.alteraUnderline(lbPalavra.getText(), letra));
				
				if(!lbPalavra.getText().contains("_")) {
					JOptionPane.showMessageDialog(btnTentativa, "PARABÉNS VOCÊ VENCEU");
					txtLetra.setEditable(false);
				}
				
				if(forca.getErros() == 6) {
					txtLetra.setEditable(false);
					JOptionPane.showMessageDialog(btnTentativa, "VOCÊ PERDEU, INICIE O JOGO NOVAMENTE");
				}
			}
		});
		btnTentativa.setBounds(234, 87, 85, 21);
		panelJogo.add(btnTentativa);
	}
}
