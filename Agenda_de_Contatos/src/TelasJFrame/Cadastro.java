package TelasJFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Classes.DadosAgenda;
import Classes.OperacoesNoBancoDeDados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	
	public static MaskFormatter txtTelefone;
	public static MaskFormatter txtNascimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setTitle("Cadastrar Dados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		
		int width = 800;
		int height = 500;
		
		setBounds(center.x - width / 2, center.y - height / 2, 563, 339);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 147, 40);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtId.setBounds(10, 47, 82, 31);
		txtId.setEnabled(false);
		txtId.setEditable(false);
		
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(102, 11, 147, 40);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNome.setColumns(10);
		txtNome.setBounds(102, 47, 434, 31);
		contentPane.add(txtNome);
		
		JLabel lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefone.setBounds(10, 89, 147, 40);
		contentPane.add(lblTelefone);
		
		JFormattedTextField txtTelefone = new JFormattedTextField(arrumaMascaraTelefone());
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTelefone.setBounds(10, 128, 208, 31);
		contentPane.add(txtTelefone);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(249, 89, 147, 40);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(249, 129, 271, 31);
		contentPane.add(txtEmail);
		
		JLabel lblEndereo = new JLabel("ENDEREÇO:");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEndereo.setBounds(10, 156, 147, 40);
		contentPane.add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(10, 196, 208, 31);
		contentPane.add(txtEndereco);
		
		JLabel lblNascimento = new JLabel("NASCIMENTO:");
		lblNascimento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNascimento.setBounds(249, 156, 147, 40);
		contentPane.add(lblNascimento);
		
		JFormattedTextField txtNascimento = new JFormattedTextField(arrumaMascaraNascimento());
		txtNascimento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNascimento.setBounds(249, 196, 147, 29);
		contentPane.add(txtNascimento);
		
		JLabel lblNewLabel_1 = new JLabel("FILHOS:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(412, 164, 82, 25);
		contentPane.add(lblNewLabel_1);
		
		JComboBox<String> comboBox_Filhos = new JComboBox<>();
		comboBox_Filhos.setModel(new DefaultComboBoxModel<String>(new String[] {"- ", "SIM ", "NÃO"}));
		comboBox_Filhos.setBounds(417, 196, 53, 30);
		contentPane.add(comboBox_Filhos);
		
		JButton btnNewButton = new JButton("SALVAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DadosAgenda objeto = new DadosAgenda();
					objeto.setNome(txtNome.getText());
					objeto.setTelefone(txtTelefone.getText());
					objeto.setEmail(txtEmail.getText());
					objeto.setEndereco(txtEndereco.getText());
					objeto.setNascimento(txtNascimento.getText());
					objeto.setFilhos(comboBox_Filhos.getSelectedItem().toString());
					
					//estamos instanciando a classe OperacoesNoBancoDeDados para usar
					//os metodos dela
					OperacoesNoBancoDeDados salvarDados = new OperacoesNoBancoDeDados();
					salvarDados.Cadastrar(objeto);
					
					//  fechar o formulário após salvar os dados
					dispose();
					
				}catch (Exception trata) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar dados no banco");
				}
				//trata - é o nome dado a exceção capturada que pode ser usada para obter
				//informações sobre o erro 
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(Cadastro.class.getResource("/Imagens/salvar.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(20, 248, 159, 39);
		contentPane.add(btnNewButton);
	}
	
	public static MaskFormatter arrumaMascaraTelefone() {
		
		try {
			txtTelefone = new MaskFormatter("(##) #####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtTelefone.setPlaceholderCharacter('_');
		return txtTelefone;
	}
	
	public static MaskFormatter arrumaMascaraNascimento() {
		
		try {
			txtNascimento = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtNascimento.setPlaceholderCharacter('_');
		return txtNascimento;
	}
}
