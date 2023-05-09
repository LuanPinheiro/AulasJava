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
		btnFilmes.setBounds(151, 7, 109, 23);
		panelCategoria.add(btnFilmes);
		
		JRadioButton btnNovelas = new JRadioButton("Novelas");
		btnNovelas.setActionCommand("Novelas");
		btnNovelas.setBounds(151, 61, 109, 23);
		panelCategoria.add(btnNovelas);
		
		JRadioButton btnCarros = new JRadioButton("Carros");
		btnCarros.setActionCommand("Carros");
		btnCarros.setBounds(151, 116, 109, 23);
		panelCategoria.add(btnCarros);
		
		final ButtonGroup categorias = new ButtonGroup();
		
		final JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forca.setCategoria(categorias.getSelection().getActionCommand());
				forca.setPalavra();
				// Reiniciar o panel do jogo
				JOptionPane.showMessageDialog(btnIniciar, "Novo jogo iniciado", "INÍCIO", 1);
			}
		});
		btnIniciar.setBounds(159, 184, 89, 23);
		panelCategoria.add(btnIniciar);
		
		JPanel panelJogo = new JPanel();
		tabbedPane.addTab("Jogo", null, panelJogo, null);
		panelJogo.setLayout(null);
		
		JLabel lbImagem = new JLabel("INSIRA IMAGEM AQUI");
		lbImagem.setBounds(28, 30, 131, 14);
		panelJogo.add(lbImagem);
		
		JLabel lbLetra = new JLabel("Letra:");
		lbLetra.setBounds(227, 30, 46, 14);
		panelJogo.add(lbLetra);
		
		txtLetra = new JTextField();
		txtLetra.setBounds(283, 27, 46, 20);
		panelJogo.add(txtLetra);
		txtLetra.setColumns(10);
		
		final JButton btnTentativa = new JButton("Tentativa");
		btnTentativa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String letra = txtLetra.getText();
				
				if(forca.letraEmPalavra(letra) == -1) {
					JOptionPane.showMessageDialog(btnTentativa, "Letra já tentada anteriormente", null, 0);
					return;
				}
				forca.addTentativa(letra);
			}
		});
		btnTentativa.setBounds(240, 78, 89, 23);
		panelJogo.add(btnTentativa);
		
		JLabel lbTentativas = new JLabel("");
		lbTentativas.setBounds(227, 124, 157, 58);
		panelJogo.add(lbTentativas);
		
		JLabel lbPalavra = new JLabel("");
		lbPalavra.setBounds(10, 134, 46, 14);
		panelJogo.add(lbPalavra);
		
		
		categorias.add(btnCarros);
		categorias.add(btnFilmes);
		categorias.add(btnNovelas);
	}
}
