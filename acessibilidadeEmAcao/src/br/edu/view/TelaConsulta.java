package br.edu.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.dao.ReclamarDAO;
import br.edu.model.Reclamacao;

import java.awt.TextArea;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class TelaConsulta extends JFrame {

	private JPanel contentPane;
	private JButton btnPesquisar;
	private JTextField textNomeEscola;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsulta frame = new TelaConsulta();
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
	public TelaConsulta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaConsulta.class.getResource("/br/edu/view/img/home.png")));
		setTitle("Tela Consulta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome da escola:");
		lblNewLabel.setBounds(29, 48, 124, 76);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(592, 10, 123, 42);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAcesso telaAcesso = new TelaAcesso();
				telaAcesso.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnVoltar);
		TextArea textListar = new TextArea();
		textListar.setEditable(false);
		textListar.setBounds(30, 142, 674, 314);
		contentPane.add(textListar);
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setBounds(30, 475, 674, 29);
		lblMensagem.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.GRAY, Color.GRAY));
		contentPane.add(lblMensagem);
		
		
		btnPesquisar = new JButton("Listar todos");
		btnPesquisar.setBounds(592, 65, 123, 42);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Reclamacao> lista = new ArrayList<Reclamacao>();
					ReclamarDAO dao = new ReclamarDAO();
					lista = dao.listarTodos();
				
					for(Reclamacao reclamacao : lista)
					{
						textListar.append("Nome da escola: " + reclamacao.getNomeEscola() + "\n");
						textListar.append("CEP: " + reclamacao.getCep() + "\n");
						textListar.append("Endereco: " + reclamacao.getEndereco() + "\n");
						textListar.append("Cidade: " + reclamacao.getCidade() + "\n");
						textListar.append("Bairro: " + reclamacao.getBairro() + "\n");
						textListar.append("UF: " + reclamacao.getUf() + "\n");
						textListar.append("Nota: " + reclamacao.getNota() + "\n");
						textListar.append("Reclamacao: " + reclamacao.getReclamacao() + "\n");
						textListar.append("------------------------" + "\n");
					}
				}
				catch(Exception erro) {
					lblMensagem.setText("Erro ao listar: " + erro);
				}
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnPesquisar);
		
		textNomeEscola = new JTextField();
		textNomeEscola.setBounds(163, 70, 238, 37);
		contentPane.add(textNomeEscola);
		textNomeEscola.setColumns(10);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(406, 66, 105, 40);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Reclamacao reclamar = new Reclamacao();
					String nomeEscola = textNomeEscola.getText();
					ReclamarDAO dao = new ReclamarDAO();
					reclamar = dao.consultar(nomeEscola);
					
					textListar.append("Nome da escola: " + reclamar.getNomeEscola() + "\n");
					textListar.append("Nota: " + reclamar.getNota() + "\n");
					textListar.append("Reclamacao: " + reclamar.getReclamacao() + "\n");
					textListar.append("------------------------" + "\n");
				}
				catch(Exception erro) {
					lblMensagem.setText("Erro ao consultar: " + erro);
				}
			}
			
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnNewButton);
		

	
	}
}
