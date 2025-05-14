package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class OperacoesNoBancoDeDados {
	
	//vamos criar um atributo
	private Connection conexao;
	
	//o nosso atributo conexao vai receber uma nova conexao com o banco de dados. 
	public OperacoesNoBancoDeDados() {
		this.conexao = new ConectarAoBancoDeDados().getConnection();
	}
	
	public void Cadastrar(DadosAgenda objeto) {
		//vamos criar uma nova classe com o que queremos cadastrar
		try {
			String informacoesSQL = "insert into tabela_cadastro(nome, telefone, email, endereco, nascimento, filhos)" 
				+ "values(?,?,?,?,?,?)";
		//insert na tabela cadastro, nessas colunas(nome, tele... etc)
		//cada interrogacao corresponde a um valor. 
		
		
			PreparedStatement gravarInformacao = conexao.prepareStatement(informacoesSQL);
			gravarInformacao.setString(1, objeto.getNome());
			gravarInformacao.setString(2, objeto.getTelefone());
			gravarInformacao.setString(3, objeto.getEmail());
			gravarInformacao.setString(4, objeto.getEndereco());
			gravarInformacao.setString(5, objeto.getNascimento());
			gravarInformacao.setString(6, objeto.getFilhos());
			
			//Executa os comandos sql
			gravarInformacao.execute();
			//fecha
			gravarInformacao.close();
			
			JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso");
			
		} catch (SQLException e) {
		
			JOptionPane.showMessageDialog(null, "Erro ao salvar os dados!");
		}
		
	}
}
