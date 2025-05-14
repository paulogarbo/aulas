package TelasJFrame;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Pesquisa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pesquisa frame = new Pesquisa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pesquisa() {
		setTitle("Pesquisa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		
		int width = 800;
		int height = 500;
		
		setBounds(center.x - width / 2, center.y - height / 2, 800, 500);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon(Pesquisa.class.getResource("/Imagens/novo.png")));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastro abreTela = new Cadastro();
				
				abreTela.setVisible(true);
				
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNovo.setBounds(58, 222, 223, 93);
		contentPane.add(btnNovo);
	}
}
