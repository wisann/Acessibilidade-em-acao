package br.edu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import java.awt.Toolkit;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textUsuario;
	private JPasswordField textSenha;
	private JLabel lblMessage;
	private JButton btnNewButton;

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
	public TelaCadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastro.class.getResource("/br/edu/view/img/home.png")));
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(87, 51, 61, 48);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		
		textNome = new JTextField();
		textNome.setBounds(158, 65, 154, 26);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsurio.setBounds(87, 120, 61, 48);
		contentPane.add(lblUsurio);
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(158, 134, 154, 26);
		contentPane.add(textUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(87, 196, 61, 48);
		contentPane.add(lblSenha);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(158, 210, 154, 26);
		contentPane.add(textSenha);
		
		JButton bntCriar = new JButton("Criar");
		bntCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Cadastro cadastro = new Cadastro();
				cadastro.setUsuario(textUsuario.getText());
				cadastro.setNome(textNome.getText());
				cadastro.setSenha(textSenha.getText());
				CadastroDAO dao = new CadastroDAO();
				dao.inserir(cadastro);
				
				lblMessage.setText("Salvo com sucesso");
			}
			catch(Exception erro) {
				lblMessage.setText("erro " + erro.getMessage());
			}			
			}	
		});
		bntCriar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bntCriar.setBounds(431, 96, 165, 39);
		contentPane.add(bntCriar);
		
		lblMessage = new JLabel("");
		lblMessage.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.GRAY, Color.GRAY));
		lblMessage.setBounds(101, 283, 584, 55);
		contentPane.add(lblMessage);
		
		btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(431, 172, 165, 39);
		contentPane.add(btnNewButton);
	}
}
