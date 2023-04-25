package br.edu.dao;

import java.awt.Panel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;

import br.edu.model.Pessoa;
import br.edu.model.Reclamacao;
import br.edu.util.ConnectionFactory;
import br.edu.view.TelaPrincipal;

public class PessoaDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public PessoaDAO() throws Exception {
        conn = ConnectionFactory.getCadastroUsuarioConnection();
    }

    public Pessoa consultar(String usuario) throws Exception {
        try {
            ps = conn.prepareStatement("SELECT * FROM cadastro_usuario WHERE usuario=?");
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                String senha = rs.getString("senha");
                Pessoa pessoa = new Pessoa(usuario, senha);
                return pessoa;
            } 
                if (rs.next()) {
                    String senha = rs.getString("senha");
                    Pessoa pessoa = new Pessoa(usuario, senha);
                    return pessoa;
                } else {
                    return null;
                }
            

            
        } catch (Exception erro) {
            throw new Exception("Erro " + erro.getMessage());
        } 
        }
    
    	
  
    
}