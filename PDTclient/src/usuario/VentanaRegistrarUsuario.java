package usuario;

import java.awt.Color;
import java.awt.Font;

import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.cliente.EJBLocator;
import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.entidades.Rol;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.UsuariosBeanRemote;

import actividad.VentanaActividad;
import formulario.VentanaRegistrarFormulario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Toolkit;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VentanaRegistrarUsuario extends JFrame {

//Declaramos todos parametros y componentes que vamos a usar...
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNombreUsuario;
	private JTextField txtCorreo;
	private JTextField txtContrasena;
	private JFrame frame;
	private JButton btnNewButton;
	private JFormattedTextField txtCedula;
	private JTextField txtInstituto;
	private JTextField txtProfesion;
	private JTextField txtContrasea;
	private JTextField txtApellido_1;
	private JTextField txtNombre_1;
	private JTextField txtNombreDeUsuario;
	private JTextField txtCedula2;
	private JTextField txtCorreoElectrnico;
	private JTextField txtInstituto1;
	private JTextField txtProfesion1;
	private JTextField txtRol;
	private Rol rol = new Rol();
	private JLabel lblNewLabel;
	private JComboBox comboRol;
	private JLabel lblRegistroDeUsuario;
	public static JLabel lblNombreUsuario;


	public VentanaRegistrarUsuario(Usuario usuario) {
		/*
		 * A continuacion definimos todas las caracteristicas y valores de cada objeto o
		 * parametro declarado.
		 */
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaRegistrarUsuario.class.getResource("/Imagenes/iAGRO_V04.png")));
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(200, 250, 200));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreSistema = new JLabel("");
		lblNombreSistema.setIcon(new ImageIcon(VentanaActividad.class.getResource("/Imagenes/iconoApp3.png")));
		lblNombreSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreSistema.setForeground(Color.WHITE);
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(259, 4, 98, 86);
		contentPane.add(lblNombreSistema);

		comboRol = new JComboBox();
		comboRol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * A continuacion llamamos al metodo evaluarComboBox al activar el comboBox al
				 * escuchar con el ActionListener
				 */
				evaluarComboBox();
			}
		});
		comboRol.setModel(new DefaultComboBoxModel(new String[] { "Administrador", "Experto", "Común" }));
		comboRol.setBounds(331, 180, 196, 23);
		contentPane.add(comboRol);

		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 102, 0));
		txtNombre.setToolTipText("Ingrese nombre");
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setBounds(33, 234, 196, 23);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setForeground(new Color(0, 102, 0));
		txtApellido.setToolTipText("Ingrese apellido");
		txtApellido.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellido.setColumns(10);
		txtApellido.setBounds(33, 294, 196, 23);
		contentPane.add(txtApellido);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setForeground(new Color(0, 102, 0));
		txtNombreUsuario.setToolTipText("Ingrese nombre de usuario");
		txtNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBounds(33, 177, 196, 25);
		contentPane.add(txtNombreUsuario);

		txtCorreo = new JTextField();
		txtCorreo.setForeground(new Color(0, 102, 0));
		txtCorreo.setToolTipText("Ingrese correo electr\u00F3nico");
		txtCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(331, 234, 196, 23);
		contentPane.add(txtCorreo);

		txtContrasena = new JPasswordField();
		txtContrasena.setForeground(new Color(0, 102, 0));
		txtContrasena.setToolTipText("Ingrese una contrase\u00F1a");
		txtContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(33, 352, 196, 26);
		contentPane.add(txtContrasena);
		
		lblNombreUsuario = new JLabel();
		lblNombreUsuario.setBounds(32, 0, 211, 28);
		contentPane.add(lblNombreUsuario);
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreUsuario.setForeground(Color.WHITE);
		
		VentanaRegistrarUsuario.lblNombreUsuario.setText(VentanaInicio.txtNombreUsuario.getText());

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaGeneral.class.getResource("/Imagenes/Usuario_gris.png")));
		lblNewLabel_1.setBounds(10, 0, 37, 28);
		contentPane.add(lblNewLabel_1);
		

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
		contentPane.add(btnSalir);

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
		contentPane.add(btnAyuda);

		JButton btnRegistrarme = new JButton("Registrar");
		btnRegistrarme.setBackground(new Color(34, 139, 34));
		btnRegistrarme.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarme.setForeground(new Color(255, 255, 255));
		btnRegistrarme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Nuevamente llamamos a un metodo, en este caso crearUsuario, al activar el
				 * boton "Registrarme"
				 */
				crearUsuario();
			}
		});
		btnRegistrarme.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarme.setBounds(93, 448, 143, 23);
		contentPane.add(btnRegistrarme);

		/*
		 * El boton "Volver" es para regresar a la pestaña de VentanaUsuario si bien la
		 * ventana registro se accede desde el inicio, esto solo sucede para facilitar
		 * el desarrollo de la app, pero a futuro no habra un boton Registro en la
		 * sesion del usuario.
		 */

		btnNewButton = new JButton("Volver");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(new Color(0, 102, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}
		});
		btnNewButton.setBounds(420, 448, 143, 23);
		contentPane.add(btnNewButton);

		txtCedula = new JFormattedTextField();
		txtCedula.addKeyListener(new KeyAdapter() {
			/*
			 * El siguiente keyTyped valida las teclas presionadas y solo escribe las teclas
			 * numericas, para el campo txtCedula correspondiente a la Cedula del usuario
			 */
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();

				// Verificar si la tecla pulsada no es un digito
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
					e.consume(); // ignorar el evento de teclado
				}
			}
		});
		txtCedula.setHorizontalAlignment(SwingConstants.CENTER);
		txtCedula.setForeground(new Color(0, 102, 0));
		txtCedula.setToolTipText("Ingrese c\u00E9dula de identidad");
		txtCedula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCedula.setBounds(33, 402, 196, 24);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);

		txtInstituto = new JTextField();
		txtInstituto.setForeground(new Color(0, 102, 0));
		txtInstituto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInstituto.setHorizontalAlignment(SwingConstants.CENTER);
		txtInstituto.setToolTipText("Ingrese instituto");
		txtInstituto.setBounds(331, 294, 196, 23);
		contentPane.add(txtInstituto);
		txtInstituto.setColumns(10);

		txtProfesion = new JTextField();
		txtProfesion.setForeground(new Color(0, 102, 0));
		txtProfesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProfesion.setHorizontalAlignment(SwingConstants.CENTER);
		txtProfesion.setToolTipText("Ingrese profesi\u00F3n");
		txtProfesion.setBounds(331, 352, 196, 26);
		txtProfesion.setVisible(false);
		txtProfesion.setEnabled(false);
		txtProfesion.setVisible(false);
		txtProfesion.setEnabled(false);
		contentPane.add(txtProfesion);
		txtProfesion.setColumns(10);

		txtContrasea = new JTextField();
		txtContrasea.setFont(new Font("Arial", Font.PLAIN, 11));
		txtContrasea.setForeground(new Color(255, 255, 255));
		txtContrasea.setText("Contrase\u00F1a");
		txtContrasea.setEditable(false);
		txtContrasea.setBackground(new Color(0, 102, 0));
		txtContrasea.setBounds(33, 339, 196, 14);
		contentPane.add(txtContrasea);
		txtContrasea.setColumns(10);

		txtApellido_1 = new JTextField();
		txtApellido_1.setText("Apellido");
		txtApellido_1.setForeground(Color.WHITE);
		txtApellido_1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtApellido_1.setEditable(false);
		txtApellido_1.setColumns(10);
		txtApellido_1.setBackground(new Color(0, 102, 0));
		txtApellido_1.setBounds(33, 282, 196, 14);
		contentPane.add(txtApellido_1);

		txtNombre_1 = new JTextField();
		txtNombre_1.setText("Nombre");
		txtNombre_1.setForeground(Color.WHITE);
		txtNombre_1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNombre_1.setEditable(false);
		txtNombre_1.setColumns(10);
		txtNombre_1.setBackground(new Color(0, 102, 0));
		txtNombre_1.setBounds(33, 221, 196, 14);
		contentPane.add(txtNombre_1);

		txtNombreDeUsuario = new JTextField();
		txtNombreDeUsuario.setText("Nombre de usuario");
		txtNombreDeUsuario.setForeground(Color.WHITE);
		txtNombreDeUsuario.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNombreDeUsuario.setEditable(false);
		txtNombreDeUsuario.setColumns(10);
		txtNombreDeUsuario.setBackground(new Color(0, 102, 0));
		txtNombreDeUsuario.setBounds(33, 165, 196, 14);
		contentPane.add(txtNombreDeUsuario);

		txtCedula2 = new JTextField();
		txtCedula2.setText("C\u00E9duda de identidad");
		txtCedula2.setForeground(Color.WHITE);
		txtCedula2.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCedula2.setEditable(false);
		txtCedula2.setColumns(10);
		txtCedula2.setBackground(new Color(0, 102, 0));
		txtCedula2.setBounds(33, 389, 196, 14);
		contentPane.add(txtCedula2);

		txtCorreoElectrnico = new JTextField();
		txtCorreoElectrnico.setText("Correo electr\u00F3nico");
		txtCorreoElectrnico.setForeground(Color.WHITE);
		txtCorreoElectrnico.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCorreoElectrnico.setEditable(false);
		txtCorreoElectrnico.setColumns(10);
		txtCorreoElectrnico.setBackground(new Color(0, 102, 0));
		txtCorreoElectrnico.setBounds(331, 221, 196, 14);
		contentPane.add(txtCorreoElectrnico);

		txtInstituto1 = new JTextField();
		txtInstituto1.setText("Instituto");
		txtInstituto1.setForeground(Color.WHITE);
		txtInstituto1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtInstituto1.setEditable(false);
		txtInstituto1.setColumns(10);
		txtInstituto1.setBackground(new Color(0, 102, 0));
		txtInstituto1.setBounds(331, 282, 196, 14);
		contentPane.add(txtInstituto1);

		txtProfesion1 = new JTextField();
		txtProfesion1.setText("Profesi\u00F3n");
		txtProfesion1.setForeground(Color.WHITE);
		txtProfesion1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtProfesion1.setEditable(false);
		txtProfesion1.setColumns(10);
		txtProfesion1.setBackground(new Color(0, 102, 0));
		txtProfesion1.setBounds(331, 339, 196, 14);
		txtProfesion1.setVisible(false);
		txtProfesion1.setEnabled(false);
		contentPane.add(txtProfesion1);

		txtRol = new JTextField();
		txtRol.setText("Rol");
		txtRol.setForeground(Color.WHITE);
		txtRol.setFont(new Font("Arial", Font.PLAIN, 11));
		txtRol.setEditable(false);
		txtRol.setColumns(10);
		txtRol.setBackground(new Color(0, 102, 0));
		txtRol.setBounds(331, 165, 196, 14);
		contentPane.add(txtRol);

		JLabel lblPortada = new JLabel("");
		lblPortada.setIcon(new ImageIcon(VentanaRegistrarFormulario.class.getResource("/Imagenes/klipartz.com.png")));
		lblPortada.setBounds(-112, 0, 736, 90);
		contentPane.add(lblPortada);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 0));
		panel.setBounds(0, 0, 624, 90);
		contentPane.add(panel);
		
		lblRegistroDeUsuario = new JLabel("Registro de usuario");
		lblRegistroDeUsuario.setOpaque(true);
		lblRegistroDeUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRegistroDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeUsuario.setForeground(Color.WHITE);
		lblRegistroDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRegistroDeUsuario.setBackground(new Color(60, 179, 113));
		lblRegistroDeUsuario.setBounds(0, 109, 624, 23);
		contentPane.add(lblRegistroDeUsuario);

	}

	/*
	 * El siguiente metodo evaluarComboBox evalua el item seleccionado en el
	 * comboBox y establece que se vean y habiliten los parametros segun el item
	 * seleccionado.
	 */
	private void evaluarComboBox() {

		if (comboRol.getSelectedItem() == "Común") {
			txtCedula2.setVisible(false);
			txtCedula2.setEnabled(false);
			txtInstituto1.setVisible(false);
			txtInstituto1.setEnabled(false);
			txtProfesion1.setVisible(false);
			txtProfesion1.setEnabled(false);
			txtCedula.setVisible(false);
			txtCedula.setEnabled(false);
			txtInstituto.setVisible(false);
			txtInstituto.setEnabled(false);
			txtProfesion.setVisible(false);
			txtProfesion.setEnabled(false);

		} else if (comboRol.getSelectedItem() == "Experto") {
			txtCedula2.setVisible(true);
			txtCedula2.setEnabled(true);
			txtProfesion1.setVisible(true);
			txtProfesion1.setEnabled(true);
			txtInstituto1.setVisible(false);
			txtInstituto1.setEnabled(false);
			txtInstituto.setVisible(false);
			txtInstituto.setEnabled(false);
			txtCedula.setVisible(true);
			txtCedula.setEnabled(true);
			txtProfesion.setVisible(true);
			txtProfesion.setEnabled(true);

		} else {
			txtCedula2.setVisible(true);
			txtCedula2.setEnabled(true);
			txtCedula.setVisible(true);
			txtCedula.setEnabled(true);
			txtInstituto1.setVisible(true);
			txtInstituto1.setEnabled(true);
			txtInstituto.setVisible(true);
			txtInstituto.setEnabled(true);
			txtProfesion1.setVisible(false);
			txtProfesion1.setEnabled(false);
			txtProfesion.setVisible(false);
			txtProfesion.setEnabled(false);

		}

	}

	/*
	 * El metodo crearUsuario, llama al EJBLocator para localizar los Beans y
	 * consigo cada metodo de persistencia que vamos requerir a traves de su
	 * interfaz remota UsuariosBeanRemote, de donde sacaremos las funciones para dar
	 * de alta un usuario en este caso la funcion se llama "crear" y le pasamos por
	 * parametro el objeto Usuario, al que le vamos a insertar todos los campos
	 * descritos a continuacion.
	 */
	private void crearUsuario() {

		/*
		 * Se enlazan los parametros escritos en cada campo de texto con cada parametro
		 * de la entidad Usuario i.e: txtNombreUsuario obtiene el texto del campo
		 * (getText();) y lo "setea" al campo nombreUsuario de la entidad Usuario
		 */
		UsuariosBeanRemote usuariosBeanRemote;
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario(txtNombreUsuario.getText());
		usuario.setContrasena(txtContrasena.getText());
		usuario.setApellido(txtApellido.getText());
		usuario.setCorreo(txtCorreo.getText());
		usuario.setNombre(txtNombre.getText());
		usuario.setCedula(txtCedula.getText());
		usuario.setInstituto(txtInstituto.getText());
		usuario.setProfesion(txtProfesion.getText());
		usuario.setRol(rol);
		/*
		 * La siguiente condicion establece el nombreRol segun el itemSeleccionado, e
		 * instancia un Usuario con su Rol relacionado. (Administrador, Experto o Comun)
		 */

		if (txtInstituto.isEnabled()) {
			rol.setNombreRol("Administrador");
		}

		if (txtProfesion.isEnabled()) {
			rol.setNombreRol("Experto");
		}
		if (txtCedula.isEnabled() == false)
			rol.setNombreRol("Común");
		try {
			usuariosBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);
			/*
			 * La siguiente condicion if, evalua que los campos de textos no se encuentren
			 * vacios al momento de iniciar sesion, en caso de que se hallen vacios envia un
			 * mensaje de informacion indicando que debe completar los campos
			 */
			if (txtNombreUsuario.getText().isEmpty() || txtCorreo.getText().isEmpty() || txtApellido.getText().isEmpty()
					|| txtContrasena.getText().isEmpty() || txtNombre.getText().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Debe completar todos los campos", "Campos Incompletos!",
						JOptionPane.ERROR_MESSAGE);

				return;
				/*
				 * El siguiente else if, llama al metodo "registro", el cual evalua que el
				 * usuario no se encuentre en la base de datos ya registrado, de esta manera
				 * evitaremos que los usuarios no accedan a cuentas agenas.
				 */
				
			} else if (usuariosBeanRemote.registro(txtNombreUsuario.getText())) {
				JOptionPane.showMessageDialog(frame, "El nombre de usuario ya se encuentra en uso. Intente Nuevamente",
						"Nombre de usuario en uso!", JOptionPane.ERROR_MESSAGE);
				/*
				 * Por ultimo ya teniendo todos los parametros de la entidad Usuario enlazados
				 * la condicion termina en un else, aqui es cuando el usuario pasa todas las
				 * "pruebas", es decir condiciones requeridas, y finalmente se da el alta del
				 * usuario, mas un dialogo indicando que se registro con exito. Redireccionamos
				 * a la ventana VentanaGeneral donde hallaremos la aplicacion y el resto de sus
				 * funciones.
				 */
				return;
				
			} 
			
			
			else if (contieneNumeros(txtNombreUsuario.getText()) || txtNombreUsuario.getText().length() < 8) {
				
				JOptionPane.showMessageDialog(frame, "El nombre de usuario debe contener al menos 8 caracteres no numéricos",
						"Nombre de usuario incorrecto!", JOptionPane.ERROR_MESSAGE);
				return;
				
				
			} else if (txtCedula.isEnabled() == true && txtCedula.getText().length() != 8) {
				/*
				 * Aqui validamos que la cedula sea de 8 caracteres, de otra forma se enviara un
				 * mensaje de error indicando el formato de cedula.
				 */
				JOptionPane.showMessageDialog(frame, "Cedula identidad incorrecta. Debe contener 8 caracteres.",
						"Cedula incorrecta!", JOptionPane.ERROR_MESSAGE);
				return;
				
			} else if (usuariosBeanRemote.registroCedula(txtCedula.getText())) {
				JOptionPane.showMessageDialog(frame, "La cédula de identidad ya se encuentra en uso. Intente Nuevamente",
						"Cédula de identidad en uso!", JOptionPane.ERROR_MESSAGE);
				
				return;
				
			} else if (contieneNumeros(txtNombre.getText()) || contieneNumeros(txtApellido.getText())) {
				
				/*Aquí llamamos a la función contieneNumeros, para comprobar que el nombre y apellido no los contengan
				 */
				JOptionPane.showMessageDialog(frame, "El nombre y apellido no deben contener caracteres numéricos",
						"Nombre/Apellido incorrecto!", JOptionPane.ERROR_MESSAGE);
				return;
				
			} else if (verificarMail(txtCorreo.getText()) == false) {
				
				/*Aquí llamamos a la función verificarCorreo, para comprobar que el mail contiene @ y .com
				 */
				JOptionPane.showMessageDialog(frame, "El correo formato ingresado de correo electrónico es incorrecto",
						"Correo incorrecto!", JOptionPane.ERROR_MESSAGE);
				return;
				
			} else if (contieneNumeros(txtContrasena.getText()) == false || contieneLetras(txtContrasena.getText()) == false 
					|| txtContrasena.getText().length() < 8) {
				
				
				JOptionPane.showMessageDialog(frame, "La contraseña debe contener números, letras y tener al menos 8 caracteres",
						"Contraseña incorrecta!", JOptionPane.ERROR_MESSAGE);
				return;
				
			} 

			else {
				usuariosBeanRemote.crear(usuario);

				JOptionPane.showMessageDialog(frame, "El Usuario ha sido registrado con éxito.", "Usuario Registrado!",
						JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}

		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (ServiciosException e1) {
			e1.printStackTrace();
		}

	} // cierre crearUsuario
	
	
	
	// Esta función busca que que la cadena de texto que se pase contenga números. Para esto utilizamos una expresión
	//regular que busca números, y se devuelve true en caso de que se los encuentre, y false en caso contrario
	private boolean contieneNumeros(String texto) {
		
		//Una expresión regular es una secuencia de caracteres que conforma un patrón de búsqueda. Para que funcione se necesita
		// un pattern y un matcher. El pattern contiene lo que se desea buscar, en este caso los números del 0 al 9, y el matcher
		// lo que se desea comparar con éste.
		
		Pattern pat = Pattern.compile("[0-9]");
		Matcher mat = pat.matcher(texto);
		
		if (mat.find()) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	//Esta función verifica que el mail contenga @ y .com
	private boolean verificarMail(String texto) {
		
		Pattern pat1 = Pattern.compile("[@]");
		Pattern pat2 = Pattern.compile(".com");
		Matcher mat1 = pat1.matcher(texto);
		Matcher mat2 = pat2.matcher(texto);
		
		if (mat1.find() && mat2.find()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean contieneLetras(String texto) {
		
		Pattern pat = Pattern.compile("[a-zA-Z]");
		Matcher mat = pat.matcher(texto);
		
		if (mat.find()) {
			return true;
		}
		
		else {
			return false;
		}
	}

}
