package br.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.edu.model.Cadastro;
import br.edu.util.ConnectionFactory;

public class CadastroDAO {
	private Cadastro cadastro;
	private Connection conn; 		//conecta com o banco de dados
	private PreparedStatement ps; 	//permite executar querys
	private ResultSet rs;			//tabela
	
	public void inserir(Cadastro cadastro) throws Exception {
 
		try {
			conn = ConnectionFactory.getConnection();
			
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, "deu errado");
			throw new Exception("Erro " + erro.getMessage());
		}
	
		 try {
		        String sql = "INSERT INTO cadastro_usuario(usuario, nome, senha) values (?, ?, ?)";
		        ps = conn.prepareStatement(sql);
		        ps.setString(1, cadastro.getUsuario());
		        ps.setString(2, cadastro.getNome());
		        ps.setString(3, cadastro.getSenha());
		        ps.executeUpdate();
		        

	}catch(Exception erro) {
		throw new Exception("Erro " + erro.getMessage());
	}
}
	

}
