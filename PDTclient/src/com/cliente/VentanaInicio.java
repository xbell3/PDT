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
	// Declaramos todos parametros y componentes que vamos a usar...

	private JPanel contentPane;
	private JTextField txtNombreUsuario;
	private JTextField txtContrasena;
	private JFrame frame;
	private JTextField textField;

	/**
	 * El siguiente es un metodo main, que nos permite "arrancar" 
	 * la aplicacion. Aqui es donde inicia el flujo de la aplicaicon.
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
	/*Al iniciar la ventana ya le pasamos por parametro el usuario.*/
	public VentanaInicio(Usuario usuario) {
		/*
		 * A continuacion definimos todas las caracteristicas y valores de cada objeto o
		 * parametro declarado.
		 */
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
		
		
		/*El boton btnIngresar nos da pie a que el usuario inicie sesion
		 * utilizando una contraseña y un nombre de usuario, previamente 
		 * registrado.*/
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(new Color(0, 102, 0));
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 ingresar();
			}
		});

		btnIngresar.setBounds(239, 403, 150, 23);
		contentPane.add(btnIngresar);

		
		/*Con el boton btnRegistrarme, inmediatamente accedemos a la ventana
		 * de registro de usuario, en donde el usuario podra registrarse 
		 * en la aplicacion ingresando cada uno de sus datos y el rol qeu va 
		 * a ocupar en ella.*/
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
	private void ingresar() {

		UsuariosBeanRemote usuariosBeanRemote;
		try {
			Usuario usuario = new Usuario();
			// Llama a la interfaz remota del Bean con EJBLocator
			usuariosBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);
			/*La siguiente condicion if, evalua que las credenciales que esta indicando
			 * ya existen en la base de datos, de esta manera el sistema sabra si 
			 * el usuario tiene permisos de ingresar a la aplicacion*/
			if (usuariosBeanRemote.login(txtNombreUsuario.getText(), txtContrasena.getText())) {
				usuario = usuariosBeanRemote.obtenerPorNombreUsuario(txtNombreUsuario.getText()).get(0);
				VentanaGeneral ventanaGeneral = new VentanaGeneral(usuario);
				//ventanaGeneral.lblNombreUsuario.setText(usuario.getNombreUsuario());
				ventanaGeneral.setVisible(true);
				ventanaGeneral.setLocation(450, 150);
				dispose();
			}
			/*La siguiente condicion if, evalua que los campos de textos no se encuentren
			 * vacios al momento de iniciar sesion, en caso de que se hallen vacios envia un mensaje de informacion
			 * indicando que debe completar los campos*/
			else if (txtNombreUsuario.getText().isEmpty() || txtContrasena.getText().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Debe completar todos los campos", "Campos Incompletos!",
						JOptionPane.ERROR_MESSAGE);
			/*Aqui regresamos al punto inicial con un return, indicando con un mensaje de error
			 * que las credenciales del usuario fueron evaluadas, y determinadas incorrectas.*/
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
}
