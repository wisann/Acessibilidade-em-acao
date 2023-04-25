package br.edu.view;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sobre extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setModal(true);
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/br/edu/view/img/home.png")));
		setBounds(150, 150, 450, 400);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Buscar CEP Ver 1.0");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(30, 36, 150, 32);
		getContentPane().add(lblNewLabel);

		JLabel lblauthorWisan = new JLabel("@Author Wisan");
		lblauthorWisan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblauthorWisan.setBounds(30, 96, 150, 32);
		getContentPane().add(lblauthorWisan);

		JLabel lblWebService1 = new JLabel("WEB Service:");
		lblWebService1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWebService1.setBounds(30, 162, 150, 32);
		getContentPane().add(lblWebService1);

		JLabel lblWebService = new JLabel("www.republicavirtual.com.br");
		lblWebService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://republicavirtual.com.br/");
			}
		});
		lblWebService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblWebService.setForeground(SystemColor.textHighlight);
		lblWebService.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWebService.setBounds(140, 162, 190, 32);
		getContentPane().add(lblWebService);

		JButton btnInstagram = new JButton("");
		btnInstagram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://www.instagram.com/acessibilidadeemacao2023/");
			}
		});
		btnInstagram.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInstagram.setToolTipText("Instagram");
		btnInstagram.setIcon(new ImageIcon(Sobre.class.getResource("/br/edu/view/img/instagram.png")));
		btnInstagram.setBorder(null);
		btnInstagram.setBackground(SystemColor.control);
		btnInstagram.setBounds(365, 233, 48, 48);
		getContentPane().add(btnInstagram);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(30, 249, 84, 32);
		getContentPane().add(btnVoltar);

	}

	private void link(String site) {
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI(site);
			desktop.browse(uri);
		} catch (Exception e) {
			System.out.println(e);

		}
	}

}
