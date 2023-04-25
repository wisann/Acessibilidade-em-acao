package br.edu.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import br.edu.dao.ReclamarDAO;
import br.edu.model.Reclamacao;

public class TelaReclamacao extends JFrame {

	private JPanel contentPane;
	private JTextField textCep;
	private JTextField textEndereco;
	private JTextField textBairro;
	private JTextField textCidade;
	private JComboBox cmbUf;
	private JLabel lblStatus;
	private JTextField textEscola;
	private JTextField textNota;
	private JTextField textReclamacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaReclamacao frame = new TelaReclamacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaReclamacao() {

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaReclamacao.class.getResource("/br/edu/view/img/home.png")));
		setTitle("Tela Reclamação");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1047, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CEP:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(49, 121, 56, 29);
		contentPane.add(lblNewLabel);

		textCep = new JTextField();
		textCep.setBounds(115, 121, 170, 29);
		contentPane.add(textCep);
		textCep.setColumns(10);

		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEndereo.setBounds(483, 121, 92, 29);
		contentPane.add(lblEndereo);

		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(573, 123, 428, 29);
		contentPane.add(textEndereco);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBairro.setBounds(41, 176, 92, 29);
		contentPane.add(lblBairro);

		textBairro = new JTextField();
		textBairro.setColumns(10);
		textBairro.setBounds(115, 178, 276, 29);
		contentPane.add(textBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCidade.setBounds(573, 176, 92, 29);
		contentPane.add(lblCidade);

		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(645, 178, 367, 29);
		contentPane.add(textCidade);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUf.setBounds(420, 176, 42, 29);
		contentPane.add(lblUf);

		cmbUf = new JComboBox();
		cmbUf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cmbUf.setModel(new DefaultComboBoxModel(
				new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
						"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cmbUf.setBounds(472, 176, 72, 29);
		contentPane.add(cmbUf);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(735, 598, 122, 41);
		contentPane.add(btnLimpar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textCep.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP");
					textCep.requestFocus();
				} else {
					buscarCep();
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(321, 121, 130, 29);
		contentPane.add(btnBuscar);

		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setIcon(new ImageIcon(TelaReclamacao.class.getResource("/br/edu/view/img/about.png")));
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBorder(null);
		btnSobre.setBackground(SystemColor.control);
		btnSobre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSobre.setBounds(975, 10, 48, 48);
		contentPane.add(btnSobre);
		/* uso da biblioteca Atxy2K para validação do campo cep */
		RestrictedTextField validar = new RestrictedTextField(textCep);

		lblStatus = new JLabel("");
		lblStatus.setBounds(273, 25, 48, 48);
		contentPane.add(lblStatus);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaAcesso telaAcesso =  new TelaAcesso();
				telaAcesso.setVisible(true);
			}
		});
		btnVoltar.setBounds(815, 17, 122, 41);
		contentPane.add(btnVoltar);

		JLabel lblNewLabel_1 = new JLabel("Nome completo da escola:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(41, 69, 195, 26);
		contentPane.add(lblNewLabel_1);
			
		
		

		textEscola = new JTextField();
		textEscola.setColumns(10);
		textEscola.setBounds(252, 70, 510, 29);
		contentPane.add(textEscola);

		JLabel lblNota = new JLabel("Nota (de 0 a 5): ");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNota.setBounds(120, 492, 122, 29);
		contentPane.add(lblNota);

		JLabel label = new JLabel("New label");
		label.setBounds(417, 78, 45, 13);
		contentPane.add(label);
		JLabel lblMessage = new JLabel("");
		lblMessage.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.GRAY, Color.GRAY));
		lblMessage.setBounds(20, 614, 584, 29);
		contentPane.add(lblMessage);
		textNota = new JTextField();

		RestrictedTextField restrictedTextField = new RestrictedTextField(textNota);
		restrictedTextField.setOnlyNums(true);
		restrictedTextField.setLimit(1);
		textNota.setToolTipText("(de 0 a 5)");

		validar.setOnlyNums(true);
		textNota.setColumns(10);
		textNota.setBounds(252, 494, 85, 29);
		contentPane.add(textNota);
		
       

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Reclamacao reclamacao = new Reclamacao();
					reclamacao.setNomeEscola(textEscola.getText());
					reclamacao.setCep((textCep.getText()));
					reclamacao.setEndereco(textEndereco.getText());
					reclamacao.setBairro(textBairro.getText());
					reclamacao.setCidade(textCidade.getText());
					reclamacao.setReclamacao(textReclamacao.getText());
					reclamacao.setNota(Integer.parseInt(textNota.getText()));
					reclamacao.setUf((String) cmbUf.getSelectedItem());
					ReclamarDAO dao = new ReclamarDAO();
					String notaStr = textNota.getText();
					if (!notaStr.isEmpty()) {
						int nota = Integer.parseInt(notaStr);
						if (nota < 0 || nota > 5) {
							JOptionPane.showMessageDialog(null, "Favor inserir uma nota entre 0 e 5");
							return; // não faz nada se a nota estiver inválida
						}

					}
					dao.salvar(reclamacao);
					lblMessage.setText("Salvo com sucesso");

				} catch (Exception erro) {
					System.out.println(erro);
				}
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSalvar.setBounds(901, 598, 122, 41);
		contentPane.add(btnSalvar);

		JLabel lblNewLabel_2 = new JLabel("Sua reclamação:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(61, 237, 130, 29);
		contentPane.add(lblNewLabel_2);

		textReclamacao = new JTextField();
		textReclamacao.setBounds(201, 237, 800, 223);
		contentPane.add(textReclamacao);
		textReclamacao.setColumns(10);
		
		
		
		
		
		

		validar.setOnlyNums(true);
		validar.setLimit(8);

	}

	private void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = textCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					textCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					textBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					cmbUf.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
					} else {
						JOptionPane.showMessageDialog(null, "Cep nao encontrado");
					}
				}

			}

			// setar campo endereco
			textEndereco.setText(tipoLogradouro + " " + logradouro);
		} catch (

		Exception e) {
			System.out.println(e);
		}
	}

	private void limpar() {
		textCep.setText(null);
		textEndereco.setText(null);
		textBairro.setText(null);
		textBairro.setText(null);
		textCidade.setText(null);
		cmbUf.setSelectedItem(null);
		textCep.requestFocus();
		lblStatus.setIcon(null);
	}
}