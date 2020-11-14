package com.cliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.entidades.Usuario;

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

/*Esta ventana tiene como objetivo ordenar las funciones 
 * en un menu global de botones, donde el usuario (segun su rol) podra 
 * desplazarse sobre las ventanas que contienen las funciones
 * ofrecidas por la aplicacion.*/
public class VentanaGeneral extends JFrame {

	// Declaramos todos parametros y componentes que vamos a usar...
	public JPanel panelUsuario;
	public JPanel contentPane;
	public JLabel lblNombreUsuario;

	public VentanaGeneral(Usuario usuario) {
		/*
		 * A continuacion definimos todas las caracteristicas y valores de cada objeto o
		 * parametro declarado.
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelUsuario = new JPanel();
		panelUsuario.setBackground(SystemColor.activeCaption);
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"),
				UIManager.getColor("Button.shadow"), null, null));
		panelUsuario.setBounds(0, 0, 784, 90);
		contentPane.add(panelUsuario);
		panelUsuario.setLayout(null);

		JLabel lblTipoUser = new JLabel();
		lblTipoUser.setBounds(541, 45, 46, 14);
		panelUsuario.add(lblTipoUser);
		lblTipoUser.setText("Tipo Usuario");
		/*
		 * El boton btnSalir, nos sirve para volver al punto de inicio de la aplicacion
		 * sin tener que cerrarla por completo. De esta manera se mantiene el flujo de
		 * la aplicacion.
		 */
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(714, 16, 60, 23);
		panelUsuario.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * VentanaInicio crea una nueva instancia de si misma para volver a la pestaña
				 * de inicio, y utiliza el objeto usuario, de esta manera a futuro podremos
				 * implementar un registro del flujo de cada usuario sobre la aplicacion, si se
				 * desea.
				 */
				VentanaInicio ventanaInicio = new VentanaInicio(usuario);
				ventanaInicio.setLocation(400, 150);
				ventanaInicio.setVisible(true);
				dispose();
			}
		});

		JButton btnNewButton = new JButton("Ayuda");
		btnNewButton.setBounds(616, 16, 88, 23);
		panelUsuario.add(btnNewButton);

		JLabel lblNombreSistema = new JLabel("Nombre App");
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(10, 16, 152, 34);
		panelUsuario.add(lblNombreSistema);

		lblNombreUsuario = new JLabel();
		lblNombreUsuario.setBounds(541, 20, 46, 14);
		panelUsuario.add(lblNombreUsuario);
		lblNombreUsuario.setText("(Nombre del usuario)");

		/*
		 * Dividimos el panel, para tener una parte movil y otra estatica de esta
		 * manera, por ejemplo el usuario va a poder visualiar parte de su informacion
		 * de usuario, sin perderla de vista al cambiar de pestaña o ventana, al
		 * recorrer la aplicacion.
		 */
		JPanel panel = new JPanel();
		panel.setBounds(0, 87, 784, 474);
		contentPane.add(panel);
		panel.setLayout(null);

		/*
		 * El boton btnAdministracion nos lleva a la seccion de la aplicacion donde se
		 * manejara el alta/baja/modificacion del usuario.
		 */
		JButton btnAdministracion = new JButton("Administracion");
		btnAdministracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaUsuario ventanaUsuario = new VentanaUsuario(usuario);
				ventanaUsuario.setLocation(400, 150);
				ventanaUsuario.setVisible(true);
				dispose();
			}
		});
		btnAdministracion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdministracion.setBounds(10, 293, 300, 120);
		panel.add(btnAdministracion);

		/*
		 * El boton btnActividad nos lleva a la seccion de la aplicacion donde se
		 * manejara la actividad de campo, y los registros del usuario al usar la
		 * aplicacion en su area de estudio. Aqui podremos realizar listar y modificar
		 * las actividades de campo segun el rol de usuario.
		 */
		JButton btnActividad = new JButton("Actividad");
		btnActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaGeneral ventanaGeneral = new VentanaGeneral(usuario);
				ventanaGeneral.setVisible(true);
				ventanaGeneral.setLocation(400, 150);
				dispose();
			}
		});
		btnActividad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnActividad.setBounds(474, 49, 300, 120);
		panel.add(btnActividad);

		/*
		 * El boton btnFormulario nos lleva a la seccion de la aplicacion donde se
		 * manejaran los formularios y las casillas, aqui se realizaran
		 * alta/baja/modificacion de los formularios y las casillas ademas se podran
		 * asignar casillas a los formularios creados, y listarlos.
		 */
		JButton btnFormulario = new JButton("Formularios");
		btnFormulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaFormulario ventanaFormulario = new VentanaFormulario(usuario);
				ventanaFormulario.setLocation(450, 150);
				ventanaFormulario.setVisible(true);
				dispose();
			}
		});
		btnFormulario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFormulario.setBounds(10, 49, 300, 120);
		panel.add(btnFormulario);

	}
}
