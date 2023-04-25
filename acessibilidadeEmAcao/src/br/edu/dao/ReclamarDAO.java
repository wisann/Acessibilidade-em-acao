package br.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import br.edu.model.Reclamacao;
import br.edu.util.ConnectionFactory;
import br.edu.view.TelaReclamacao;

public class ReclamarDAO {
	private Reclamacao reclamacao;
	private Connection conn; // conecta com o banco de dados
	private PreparedStatement ps; // permite executar querys
	private ResultSet rs;

	public ReclamarDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();

		} catch (Exception erro) {
			throw new Exception("Erro " + erro.getMessage());
		}
	}

	public void salvar(Reclamacao reclamacao) throws Exception {
		try {
			String sql = "INSERT INTO reclamar(nomeEscola, cep, endereco, bairro, uf, cidade, reclamacao, nota)"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, reclamacao.getNomeEscola());
			ps.setString(2, reclamacao.getCep());
			ps.setString(3, reclamacao.getEndereco());
			ps.setString(4, reclamacao.getBairro());
			ps.setString(5, reclamacao.getUf());
			ps.setString(6, reclamacao.getCidade());
			ps.setString(7, reclamacao.getReclamacao());
			ps.setInt(8, reclamacao.getNota());
	
			ps.executeUpdate();
		} catch (Exception erro) {
			throw new Exception("Erro " + erro.getMessage());
		}
	}

	public List<Reclamacao> listarTodos() throws Exception {

		try {

			List<Reclamacao> lista = new ArrayList<Reclamacao>();

			ps = conn.prepareStatement("SELECT * FROM reclamar");
			rs = ps.executeQuery();

			while (rs.next()) {
				String nomeEscola = rs.getString("nomeEscola");
				String cep = rs.getString("cep");
				String endereco = rs.getString("endereco");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String uf = rs.getString("uf");
				int nota = rs.getInt("nota");
				String reclamacao = rs.getString("reclamacao");
				

				Reclamacao reclamar = new Reclamacao(nomeEscola, cep, endereco, cidade, bairro, uf, nota, reclamacao);

				lista.add(reclamar);
			}
			return lista;
		} catch (Exception erro) {
			throw new Exception("Erro " + erro.getMessage());
		}
	}
	public Reclamacao consultar(String nomeEscola) throws Exception {
	    try {
	        ps = conn.prepareStatement("SELECT * FROM reclamar WHERE nomeEscola=?");

	        ps.setString(1, nomeEscola);
	        
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            String cep = rs.getString("cep");
	            String endereco = rs.getString("endereco");
	            String cidade = rs.getString("cidade");
	            String bairro = rs.getString("bairro");
	            String uf = rs.getString("uf");
	            int nota = rs.getInt("nota");
	            String reclamacao = rs.getString("reclamacao");
	           

	            Reclamacao reclamar = new Reclamacao(nomeEscola, cep, endereco, cidade, bairro, uf, nota, reclamacao);

	            return reclamar;
	        } else {
	            throw new Exception("Reclamação não encontrada.");
	        }
	    } catch (Exception erro) {
	        throw new Exception("Erro " + erro.getMessage());
	    }
	}
	
	}



