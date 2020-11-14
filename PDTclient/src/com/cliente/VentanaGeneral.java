package com.cliente;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.entidades.Rol;
import com.entidades.Usuario;
import com.servicios.RolBeanRemote;

import formulario.VentanaFormulario;
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
	public JLabel lblNombreUsuario;


	
	
	
	public VentanaGeneral(Usuario usuario) {
		
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
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"), UIManager.getColor("Button.shadow"), null, null));
		panelUsuario.setBounds(0, 0, 624, 115);
		contentPane.add(panelUsuario);
		panelUsuario.setLayout(null);
		
				

		lblNombreUsuario = new JLabel();
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreUsuario.setForeground(Color.WHITE);
		lblNombreUsuario.setText("(Nombre de usuario)");
		lblNombreUsuario.setBounds(31, 90, 119, 14);
		panelUsuario.add(lblNombreUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaGeneral.class.getResource("/Imagenes/Usuario_gris.png")));
		lblNewLabel_1.setBounds(10, 74, 24, 39);
		panelUsuario.add(lblNewLabel_1);
		
	
		JLabel lblTipoUser = new JLabel();
		lblTipoUser.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblTipoUser.setForeground(new Color(255, 255, 255));
		lblTipoUser.setBounds(10, 65, 100, 14);
		panelUsuario.add(lblTipoUser);	
		lblTipoUser.setText("Rol");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-67, 0, 784, 113);
		panelUsuario.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(VentanaGeneral.class.getResource("/Imagenes/klipartz.com.png")));
		/*
		 * Dividimos el panel, para tener una parte movil y otra estatica de esta
		 * manera, por ejemplo el usuario va a poder visualiar parte de su informacion
		 * de usuario, sin perderla de vista al cambiar de pestaña o ventana, al
		 * recorrer la aplicacion.
		 */
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(0, 111, 624, 371);
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
				VentanaUsuario ventanaUsuario = new VentanaUsuario (usuario);
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
		
		JButton btnActividad = new JButton("Analisis de actividad");
		btnActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				VentanaFormulario ventanaFormulario = new VentanaFormulario(usuario);
				ventanaFormulario.setLocation(450, 150);
				ventanaFormulario.setVisible(true);
				dispose();
			}
		});
		btnFormulario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFormulario.setBounds(10, 76, 300, 120);
		panel.add(btnFormulario);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setForeground(new Color(0, 102, 0));
		btnAyuda.setBounds(458, 340, 70, 20);
		panel.add(btnAyuda);
		btnAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		
		/*
		 * El boton btnSalir, nos sirve para volver al punto de inicio de la aplicacion
		 * sin tener que cerrarla por completo. De esta manera se mantiene el flujo de
		 * la aplicacion.
		 */	
		
		
		JButton btnSalir = new JButton("Salir");
			btnSalir.setForeground(new Color(0, 102, 0));
			btnSalir.setBounds(546, 340, 70, 20);
			panel.add(btnSalir);
			btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VentanaInicio ventanaInicio = new VentanaInicio(usuario);
					ventanaInicio.setLocation(400, 150);
					ventanaInicio.setVisible(true);
					dispose();
				}
			});
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
