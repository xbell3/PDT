package actividad;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.EJBLocator;
import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.entidades.Actividad;
import com.entidades.Formulario;
import com.entidades.Rol;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.ActividadesBeanRemote;
import com.servicios.UsuariosBeanRemote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import com.toedter.calendar.JDateChooser;

import formulario.VentanaRegistrarFormulario;
import usuario.VentanaUsuario;

public class VentanaEditarActividad extends JFrame {

	//Declaramos los componentes o parametros.
	private JPanel contentPane;
	private JTextField txtDepartamento;
	private JTextField txtEstacionMuestreo;
	private JTextField txtMetodoMuestreo;
	private JTextField txtFormulario;
	private JTextField txtUsuario;
	private JTextField txtRol;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtEstacinDeMuestreo;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel lblNuevaCasilla;
	private JDateChooser dateChooserInicio = new JDateChooser();
	private JDateChooser dateChooserFin = new JDateChooser();
	/*el parametro lblNombreUsuario se declara static de esta manera 
	 * no tendremos que instanciar un objeto de la clase para invocarlo*/
	private static JLabel lblNombreUsuario;

	/**
	 * Create the frame.
	 */
	public VentanaEditarActividad(Usuario usuario, Actividad actividad) {

		setTitle("Editar actividad");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaActividad.class.getResource("/Imagenes/iAGRO_V04.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/*El siguiente label lblNombreUsuario obtiene el nombre de usuario
		 * del usuario logeado.
		 * */
		lblNombreUsuario = new JLabel();
		lblNombreUsuario.setBounds(32, 0, 211, 28);
		contentPane.add(lblNombreUsuario);
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreUsuario.setForeground(Color.WHITE);
		VentanaEditarActividad.lblNombreUsuario.setText(VentanaInicio.txtNombreUsuario.getText());

		JLabel lblIconUser;
		lblIconUser = new JLabel("");
		lblIconUser.setIcon(new ImageIcon(VentanaGeneral.class.getResource("/Imagenes/Usuario_gris.png")));
		lblIconUser.setBounds(10, 0, 37, 28);
		contentPane.add(lblIconUser);

		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"),

				UIManager.getColor("Button.shadow"), null, null));
		panelUsuario.setBackground(new Color(0, 102, 0));
		panelUsuario.setBounds(0, 0, 624, 90);
		contentPane.add(panelUsuario);

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


		JLabel lblNombreSistema = new JLabel("");
		lblNombreSistema.setIcon(new ImageIcon(VentanaActividad.class.getResource("/Imagenes/iconoApp3.png")));
		lblNombreSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreSistema.setForeground(Color.WHITE);
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(259, 4, 98, 86);
		panelUsuario.add(lblNombreSistema);

		JLabel lblPortada = new JLabel("");
		lblPortada.setIcon(new ImageIcon(VentanaRegistrarFormulario.class.getResource("/Imagenes/klipartz.com.png")));
		lblPortada.setBounds(-112, 0, 736, 90);
		panelUsuario.add(lblPortada);

		JPanel panelActividad = new JPanel();
		panelActividad.setBackground(new Color(204, 255, 204));
		panelActividad.setBounds(0, 89, 624, 472);
		contentPane.add(panelActividad);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 346, 89, 23);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaRegistroActividad ventanaRegistroActividad = new VentanaRegistroActividad(usuario);
				ventanaRegistroActividad.setVisible(true);
				ventanaRegistroActividad.setLocation(400, 150);
				dispose();
			}
		});
		panelActividad.setLayout(null);
		
		JLabel lblBienvenido_1 = new JLabel(" Para iniciar complete los campos de texto");
		lblBienvenido_1.setForeground(new Color(0, 0, 0));
		lblBienvenido_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBienvenido_1.setBackground(new Color(0, 102, 0));
		lblBienvenido_1.setBounds(192, 110, 242, 31);
		panelActividad.add(lblBienvenido_1);
		
		JLabel lblBienvenido = new JLabel("Bienvenido al centro de actividad de campo");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setOpaque(true);
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBienvenido.setBackground(new Color(0, 102, 0));
		lblBienvenido.setBounds(123, 72, 387, 39);
		panelActividad.add(lblBienvenido);
		panelActividad.add(btnVolver);

		JButton btnInicio = new JButton("Modificar");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarActividad(actividad);

			}
		});
		btnInicio.setBounds(417, 363, 157, 38);
		panelActividad.add(btnInicio);

		txtDepartamento = new JTextField();
		txtDepartamento.setText(actividad.getDepartamento());
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(182, 299, 129, 20);
		panelActividad.add(txtDepartamento);

		txtEstacionMuestreo = new JTextField();
		txtEstacionMuestreo.setText(actividad.getEstacionMuestreo());
		txtEstacionMuestreo.setColumns(10);
		txtEstacionMuestreo.setBounds(344, 244, 130, 20);
		panelActividad.add(txtEstacionMuestreo);

		txtMetodoMuestreo = new JTextField();
		txtMetodoMuestreo.setText(actividad.getMetodoMuestreo());
		txtMetodoMuestreo.setColumns(10);
		txtMetodoMuestreo.setBounds(20, 299, 130, 20);
		panelActividad.add(txtMetodoMuestreo);

		txtFormulario = new JTextField();
		txtFormulario.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFormulario.setText(actividad.getNombreFormulario());
		txtFormulario.setEditable(false);
		txtFormulario.setColumns(10);
		txtFormulario.setBounds(20, 173, 130, 20);
		panelActividad.add(txtFormulario);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtUsuario.setText(actividad.getNombreUsuario());
		txtUsuario.setEditable(false);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(182, 173, 130, 20);
		panelActividad.add(txtUsuario);

		txtRol = new JTextField();
		txtRol.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtRol.setText(actividad.getRol().getNombreRol());
		txtRol.setEditable(false);
		txtRol.setColumns(10);
		txtRol.setBounds(344, 173, 130, 20);
		panelActividad.add(txtRol);
		
		textField_1 = new JTextField();
		textField_1.setText("Formulario");
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(0, 102, 0));
		textField_1.setBounds(20, 160, 130, 14);
		panelActividad.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("Usuario");
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(0, 102, 0));
		textField_2.setBounds(182, 160, 130, 14);
		panelActividad.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("Rol");
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(0, 102, 0));
		textField_3.setBounds(344, 160, 130, 14);
		panelActividad.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("Fecha de inicio");
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(0, 153, 0));
		textField_4.setBounds(20, 231, 130, 14);
		panelActividad.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("Fecha de fin");
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(0, 153, 0));
		textField_5.setBounds(181, 231, 130, 14);
		panelActividad.add(textField_5);
		
		txtEstacinDeMuestreo = new JTextField();
		txtEstacinDeMuestreo.setToolTipText("Ingrese fecha de muestreo");
		txtEstacinDeMuestreo.setText("Estaci\u00F3n de muestreo");
		txtEstacinDeMuestreo.setForeground(Color.WHITE);
		txtEstacinDeMuestreo.setFont(new Font("Arial", Font.PLAIN, 11));
		txtEstacinDeMuestreo.setEditable(false);
		txtEstacinDeMuestreo.setColumns(10);
		txtEstacinDeMuestreo.setBackground(new Color(0, 153, 0));
		txtEstacinDeMuestreo.setBounds(344, 232, 130, 14);
		panelActividad.add(txtEstacinDeMuestreo);
		
		textField_7 = new JTextField();
		textField_7.setText("M\u00E9todo de muestreo");
		textField_7.setForeground(Color.WHITE);
		textField_7.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBackground(new Color(0, 153, 0));
		textField_7.setBounds(20, 287, 130, 14);
		panelActividad.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("Departamento");
		textField_8.setForeground(Color.WHITE);
		textField_8.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBackground(new Color(0, 153, 0));
		textField_8.setBounds(181, 287, 130, 14);
		panelActividad.add(textField_8);
		
		lblNuevaCasilla = new JLabel("Actividad de campo");
		lblNuevaCasilla.setOpaque(true);
		lblNuevaCasilla.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNuevaCasilla.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaCasilla.setForeground(Color.WHITE);
		lblNuevaCasilla.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNuevaCasilla.setBackground(new Color(60, 179, 113));
		lblNuevaCasilla.setBounds(0, 11, 624, 23);
		panelActividad.add(lblNuevaCasilla);
		
		//Calendario Inicio
		dateChooserInicio.setBounds(20, 244, 130, 20);
		panelActividad.add(dateChooserInicio);
		
		//Calendario Fin
		dateChooserFin.setBounds(182, 244, 130, 20);
		panelActividad.add(dateChooserFin);

	}

	private void modificarActividad(Actividad actividad)  {

		/*
		 * Se enlazan los parametros escritos en cada campo de texto con cada parametro
		 * de la entidad Usuario i.e: txtUsuario obtiene el texto del campo
		 * (getText();) y lo "setea" al campo nombreUsuario de la entidad Usuario
		 */
		ActividadesBeanRemote actividadesBeanRemote;
		Rol rol = new Rol();
		actividad.setFechaInicio(dateChooserInicio.getDate());
		actividad.setFechaFin(dateChooserFin.getDate());
		actividad.setMetodoMuestreo(txtMetodoMuestreo.getText());
		actividad.setEstacionMuestreo(txtEstacionMuestreo.getText());
		actividad.setNombreFormulario(txtFormulario.getText());
		actividad.setNombreUsuario(txtUsuario.getText());
		actividad.setDepartamento(txtDepartamento.getText());
		actividad.setRol(rol);
		rol.setNombreRol(txtRol.getText());
		try {
			actividadesBeanRemote = EJBLocator.getInstance().lookup(ActividadesBeanRemote.class);
			actividadesBeanRemote.actualizar(actividad);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiciosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
