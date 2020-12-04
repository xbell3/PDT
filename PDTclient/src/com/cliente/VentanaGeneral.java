package com.cliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.entidades.Rol;
import com.entidades.Usuario;
import com.servicios.RolBeanRemote;

import actividad.VentanaActividad;
import formulario.VentanaFormulario;
import formulario.VentanaRegistrarFormulario;
import usuario.VentanaUsuario;

import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

import java.awt.SystemColor;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.EventQueue;

/*Esta ventana tiene como objetivo ordenar las funciones 
 * en un menu global de botones, donde el usuario (segun su rol) podra 
 * desplazarse sobre las ventanas que contienen las funciones
 * ofrecidas por la aplicacion.*/

public class VentanaGeneral extends JFrame {

	// Declaramos todos parametros y componentes que vamos a usar...

	public JPanel panelUsuario;
	private JPanel contentPane;
	public static JLabel lblNombreUsuario;
	public static JLabel lblTipoUser;

	public VentanaGeneral(Usuario usuarioLogeado) {


		/*
		 * A continuacion definimos todas las caracteristicas y valores de cada objeto o
		 * parametro declarado.
		 */

		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaGeneral.class.getResource("/Imagenes/iAGRO_V04.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelUsuario = new JPanel();
		panelUsuario.setForeground(new Color(255, 255, 255));
		panelUsuario.setBackground(new Color(0, 100, 0));
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"),
				UIManager.getColor("Button.shadow"), null, null));
		panelUsuario.setBounds(0, 0, 624, 91);
		contentPane.add(panelUsuario);
		panelUsuario.setLayout(null);
		
		JLabel lblNombreSistema = new JLabel("");
		lblNombreSistema.setIcon(new ImageIcon(VentanaActividad.class.getResource("/Imagenes/iconoApp3.png")));
		lblNombreSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreSistema.setForeground(Color.WHITE);
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(259, 4, 98, 86);
		panelUsuario.add(lblNombreSistema);
		
		
		lblNombreUsuario = new JLabel();
		lblNombreUsuario.setBounds(32, 0, 211, 28);
		panelUsuario.add(lblNombreUsuario);
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreUsuario.setForeground(Color.WHITE);
		
		VentanaGeneral.lblNombreUsuario.setText(VentanaInicio.txtNombreUsuario.getText());

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaGeneral.class.getResource("/Imagenes/Usuario_gris.png")));
		lblNewLabel_1.setBounds(10, 0, 37, 28);
		panelUsuario.add(lblNewLabel_1);
		
		
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/cambioUser.png")));
		btnSalir.setToolTipText("Cambiar usuario");
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setForeground(new Color(0, 102, 0));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaInicio ventanaInicio = new VentanaInicio();
				ventanaInicio.setLocation(400, 150);
				ventanaInicio.setVisible(true);
				dispose();
			}

		});
		btnSalir.setBounds(556, 11, 55, 31);
		panelUsuario.add(btnSalir);
		
		
		JButton btnAyuda = new JButton("");
		btnAyuda.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/Ayuda.png")));
		btnAyuda.setToolTipText("Ayuda");
		btnAyuda.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
			
		btnAyuda.setForeground(new Color(0, 102, 0));
		btnAyuda.setBounds(574, 52, 37, 25);
		panelUsuario.add(btnAyuda);

		JLabel lblPortada = new JLabel("");
		lblPortada.setIcon(new ImageIcon(VentanaRegistrarFormulario.class.getResource("/Imagenes/klipartz.com.png")));
		lblPortada.setBounds(-112, 0, 736, 90);
		panelUsuario.add(lblPortada);
		/*
		 * Dividimos el panel, para tener una parte movil y otra estatica de esta
		 * manera, por ejemplo el usuario va a poder visualiar parte de su informacion
		 * de usuario, sin perderla de vista al cambiar de pestaña o ventana, al
		 * recorrer la aplicacion.
		 */

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(0, 90, 624, 392);
		contentPane.add(panel);
		panel.setLayout(null);

		/*
		 * El boton btnAdministracion nos lleva a la seccion de la aplicacion donde se
		 * manejara el alta/baja/modificacion del usuario.
		 */
			JButton btnAdministracion = new JButton("Administraci\u00F3n");
			btnAdministracion.setIcon(new ImageIcon(VentanaGeneral.class.getResource("/Imagenes/Admin_BD.png")));
			btnAdministracion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAdministracion.setBackground(new Color(0, 102, 0));
			btnAdministracion.setForeground(new Color(255, 255, 255));
			btnAdministracion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VentanaUsuario ventanaUsuario = new VentanaUsuario(usuarioLogeado);
					ventanaUsuario.setLocation(400, 150);
					ventanaUsuario.setVisible(true);
					dispose();
				}
			});

			btnAdministracion.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnAdministracion.setBounds(10, 207, 300, 120);
			panel.add(btnAdministracion);

		

		/*
		 * El boton btnActividad nos lleva a la seccion de la aplicacion donde se
		 * manejara la actividad de campo, y los registros del usuario al usar la
		 * aplicacion en su area de estudio. Aqui podremos realizar listar y modificar
		 * las actividades de campo segun el rol de usuario.
		 */

		JButton btnActividad = new JButton("Actividad de campo");
		btnActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaActividad ventanaActividad = new VentanaActividad(usuarioLogeado);
				ventanaActividad.setVisible(true);
				ventanaActividad.setLocation(400, 150);
				dispose();
			}
		});
		btnActividad.setIcon(new ImageIcon(VentanaGeneral.class.getResource("/Imagenes/Actividades_v04.png")));
		btnActividad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnActividad.setBackground(new Color(0, 102, 0));
		btnActividad.setForeground(new Color(255, 255, 255));
		btnActividad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnActividad.setBounds(316, 76, 300, 120);
		panel.add(btnActividad);

		/*
		 * El boton btnFormulario nos lleva a la seccion de la aplicacion donde se
		 * manejaran los formularios y las casillas, aqui se realizaran
		 * alta/baja/modificacion de los formularios y las casillas ademas se podran
		 * asignar casillas a los formularios creados, y listarlos.
		 */

		

			JButton btnFormulario = new JButton("  Formularios");
			btnFormulario.setIcon(new ImageIcon(VentanaGeneral.class.getResource("/Imagenes/formulario_v3.png")));
			btnFormulario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnFormulario.setBackground(new Color(0, 102, 0));
			btnFormulario.setForeground(new Color(255, 255, 255));
			btnFormulario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VentanaFormulario ventanaFormulario = new VentanaFormulario(usuarioLogeado);
					ventanaFormulario.setLocation(450, 150);
					ventanaFormulario.setVisible(true);
					dispose();
				}
			});
			btnFormulario.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnFormulario.setBounds(10, 76, 300, 120);
			panel.add(btnFormulario);
			
			if (usuarioLogeado.getRol().getNombreRol().equals("Común")) {
				btnFormulario.setVisible(false);
				btnAdministracion.setVisible(false);
			}else if (usuarioLogeado.getRol().getNombreRol().equals("Experto")) {
				btnAdministracion.setVisible(false);
				btnFormulario.setVisible(true);
				
			}
		/*
		 * El boton btnSalir, nos sirve para volver al punto de inicio de la aplicacion
		 * sin tener que cerrarla por completo. De esta manera se mantiene el flujo de
		 * la aplicacion.
		 */
		
	}
}
