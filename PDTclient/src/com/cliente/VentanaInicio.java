package com.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import com.entidades.Usuario;
import com.servicios.UsuariosBeanRemote;

import usuario.VentanaRegistrarUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.naming.NamingException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreUsuario;
	private JTextField txtContrasena;
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio(new Usuario());
					frame.setLocation(400, 150);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public VentanaInicio(Usuario usuario) {
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicio.class.getResource("/Imagenes/iAGRO_V04.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(VentanaInicio.class.getResource("/Imagenes/klipartz.com.png")));
		lblNewLabel_3.setBounds(0, 0, 639, 248);
		contentPane.add(lblNewLabel_3);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombreUsuario.setToolTipText("Ingresar nombre de usuario");
		txtNombreUsuario.setForeground(new Color(0, 102, 0));
		txtNombreUsuario.setBounds(206, 306, 214, 30);
		contentPane.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		txtContrasena = new JPasswordField();
		txtContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContrasena.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtContrasena.setToolTipText("Ingresar contrase\u00F1a");
		txtContrasena.setForeground(new Color(0, 102, 0));
		txtContrasena.setBounds(206, 359, 214, 30);
		contentPane.add(txtContrasena);
		txtContrasena.setColumns(10);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(new Color(0, 102, 0));
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UsuariosBeanRemote usuariosBeanRemote;
				try {
					// Llama a la interfaz remota del Bean con EJBLocator
					usuariosBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);

					if (usuariosBeanRemote.login(txtNombreUsuario.getText(), txtContrasena.getText())) {
						VentanaGeneral ventanaGeneral = new VentanaGeneral(usuario);
						ventanaGeneral.lblNombreUsuario.setText(usuario.getNombreUsuario());
						ventanaGeneral.setVisible(true);
						ventanaGeneral.setLocation(450, 150);
						dispose();
					}

					else if (txtNombreUsuario.getText().isEmpty() || txtContrasena.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Debe completar todos los campos", "Campos Incompletos!",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame, "Credenciales incorrectas. Vuelva a intentarlo",
								"Campos Incompletos!", JOptionPane.ERROR_MESSAGE);
						return;
					}

				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnIngresar.setBounds(239, 403, 150, 23);
		contentPane.add(btnIngresar);

		JButton btnRegistrarme = new JButton("Registrarme");
		btnRegistrarme.setForeground(new Color(0, 102, 0));
		btnRegistrarme.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaRegistrarUsuario ventanaRegistrarUsuario = new VentanaRegistrarUsuario(usuario);
				ventanaRegistrarUsuario.setLocation(400, 150);
				ventanaRegistrarUsuario.setVisible(true);
				dispose();
			}
		});
		btnRegistrarme.setBounds(239, 447, 150, 23);
		contentPane.add(btnRegistrarme);
		
		textField = new JTextField();
		textField.setText("Iniciar Sesi\u00F3n");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Calibri", Font.PLAIN, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(0, 128, 0));
		textField.setBounds(23, 243, 584, 45);
		contentPane.add(textField);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(VentanaInicio.class.getResource("/Imagenes/USycon_v03.png")));
		lblNewLabel.setBounds(168, 299, 32, 92);
		contentPane.add(lblNewLabel);
	}
}
