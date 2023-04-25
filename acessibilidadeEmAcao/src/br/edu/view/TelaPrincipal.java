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

import br.edu.dao.PessoaDAO;
import br.edu.model.Pessoa;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JSlider;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/br/edu/view/img/home.png")));
		setTitle("Bem vindo!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem vindo ao acessibilidade em ação!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(190, 24, 428, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(126, 166, 81, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(136, 230, 74, 31);
		contentPane.add(lblNewLabel_1_1);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(236, 166, 211, 31);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Não tem cadastro?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(116, 406, 176, 22);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro telaCadastro = new TelaCadastro();
				telaCadastro.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(273, 394, 136, 46);
		contentPane.add(btnNewButton);
		JLabel lblMessage = new JLabel("");
		lblMessage.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.GRAY, Color.GRAY));
		lblMessage.setBounds(107, 287, 584, 55);
		contentPane.add(lblMessage);
		JButton botaoEntrar = new JButton("Entrar");
		botaoEntrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)  {
		        
		    	String usuario = textUsuario.getText();
		        char[] senhaChar = textSenha.getPassword();
		        String senha = new String(senhaChar);
		        
		        PessoaDAO dao;
		        try {
					dao = new PessoaDAO();
			        Pessoa usuarioEncontrado = dao.consultar(usuario);
			        
			        if (usuarioEncontrado != null && usuarioEncontrado.getSenha().equals(senha)) {
			            // usuário encontrado e senha correta, faça o login e abra a segunda tela
			            TelaAcesso telaAcesso = new TelaAcesso();
			            telaAcesso.setVisible(true);
			            lblMessage.setText("entrando");
			        } else {
			            // usuário não encontrado ou senha incorreta, exiba uma mensagem de erro
			            lblMessage.setText("Usuário ou senha incorretos");
			        }

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

		        
		    }});




		botaoEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoEntrar.setBounds(490, 192, 159, 46);
		contentPane.add(botaoEntrar);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(236, 230, 211, 31);
		contentPane.add(textSenha);
		
		
	}
}
