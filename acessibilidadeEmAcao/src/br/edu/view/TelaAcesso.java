package br.edu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import br.edu.dao.CadastroDAO;
import br.edu.model.Cadastro;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class TelaAcesso extends JFrame {

	private JPanel contentPane;
	private JLabel lblMessage;
	private JTextField textNomeUser;
	private JButton btnNewButton;
	private JLabel lblVisualizarReclamaes;
	private JButton btnConsultar;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAcesso frame = new TelaAcesso();
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
	public TelaAcesso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAcesso.class.getResource("/br/edu/view/img/home.png")));
		setTitle("Tela acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Deseja fazer uma reclamação?");
		lblNewLabel.setBounds(71, 30, 225, 48);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		
		lblMessage = new JLabel("");
		lblMessage.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.GRAY, Color.GRAY));
		lblMessage.setBounds(99, 438, 584, 55);
		contentPane.add(lblMessage);
		
	
		
		btnNewButton = new JButton("Reclamar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaReclamacao telaReclamacao = new TelaReclamacao();
				telaReclamacao.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(306, 33, 207, 42);
		contentPane.add(btnNewButton);
		
		lblVisualizarReclamaes = new JLabel("Visualizar reclamações");
		lblVisualizarReclamaes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVisualizarReclamaes.setBounds(71, 133, 225, 48);
		contentPane.add(lblVisualizarReclamaes);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsulta telaConsulta = new TelaConsulta();
				telaConsulta.setVisible(true);
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsultar.setBounds(306, 133, 207, 42);
		contentPane.add(btnConsultar);
		
		btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
				dispose();

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(681, 24, 98, 36);
		contentPane.add(btnNewButton_1);
	}
}
