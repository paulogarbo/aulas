package TelaPrincipal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Classes.ConectarAoBancoDeDados;
import TelasJFrame.Pesquisa;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Principal {

	private JFrame frmAgendaDeContatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmAgendaDeContatos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgendaDeContatos = new JFrame();
		frmAgendaDeContatos.setTitle("Agenda de Contatos");
		frmAgendaDeContatos.setBounds(100, 100, 450, 300);
		
		// Maximizar a tela
		frmAgendaDeContatos.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JButton btnTestarConexaoBD = new JButton("Testar conexão com BD");
		btnTestarConexaoBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conexao = new ConectarAoBancoDeDados().getConnection();
				
				if(conexao != null) {
					JOptionPane.showMessageDialog(null, "Banco de dados conectado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnTestarConexaoBD.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTestarConexaoBD.setBounds(90, 11, 267, 56);
		frmAgendaDeContatos.getContentPane().add(btnTestarConexaoBD);
		
		JMenuBar menuBar = new JMenuBar();
		frmAgendaDeContatos.setJMenuBar(menuBar);
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setIcon(new ImageIcon(Principal.class.getResource("/Imagens/arquivo.png")));
		menuBar.add(menuArquivo);
		
		JMenuItem subMenuContatos = new JMenuItem("Contatos");
		subMenuContatos.setIcon(new ImageIcon(Principal.class.getResource("/Imagens/contatos.png")));
		subMenuContatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pesquisa telaPesquisa = new Pesquisa();
				telaPesquisa.setVisible(true);
			}
		});
		subMenuContatos.setHorizontalAlignment(SwingConstants.CENTER);
		menuArquivo.add(subMenuContatos);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		menuAjuda.setIcon(new ImageIcon(Principal.class.getResource("/Imagens/ajuda.png")));
		menuBar.add(menuAjuda);
		
		JMenuItem subMenuSair = new JMenuItem("Sair");
		subMenuSair.setIcon(new ImageIcon(Principal.class.getResource("/Imagens/sair.png")));
		subMenuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Fechamos o programa
				frmAgendaDeContatos.dispose();
				
				
			}
		});
		menuAjuda.add(subMenuSair);
	}
}
