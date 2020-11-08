package com.cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.cliente.EJBLocator;
import com.entidades.Rol;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreUsuario;
	private JTextField txtContrasena;
	private JFrame frame;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Iniciar Sesion");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 11, 150, 44);
		contentPane.add(lblNewLabel);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setToolTipText("Escribe tu nombre de usuario");
		txtNombreUsuario.setBounds(134, 156, 150, 30);
		contentPane.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(134, 218, 150, 30);
		contentPane.add(txtContrasena);
		txtContrasena.setColumns(10);

		JButton btnIngresar = new JButton("Ingresar");
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

		btnIngresar.setBounds(134, 292, 150, 23);
		contentPane.add(btnIngresar);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setLabelFor(txtNombreUsuario);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(63, 164, 61, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Constrase\u00F1a");
		lblNewLabel_2.setLabelFor(txtContrasena);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(63, 226, 61, 14);
		contentPane.add(lblNewLabel_2);

		JButton btnRegistrarme = new JButton("Registrarme");
		btnRegistrarme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaRegistrarUsuario ventanaRegistrarUsuario = new VentanaRegistrarUsuario(usuario);
				ventanaRegistrarUsuario.setLocation(400, 150);
				ventanaRegistrarUsuario.setVisible(true);
				dispose();
			}
		});
		btnRegistrarme.setBounds(134, 337, 150, 23);
		contentPane.add(btnRegistrarme);
	}

}
