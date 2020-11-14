package usuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
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
import com.servicios.RolBeanRemote;
import com.servicios.UsuariosBeanRemote;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.Box;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.DropMode;

public class VentanaEditarUsuario extends JFrame {
	
	
//Declaramos todos parametros y componentes que vamos a usar...
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNombreUsuario;
	private JTextField txtCorreo;
	private JTextField txtContrasena;
	private JFrame frame;
	private JButton btnNewButton;
	private JTextField txtCedula;
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
	public VentanaEditarUsuario(Usuario usuario) {
		
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaEditarUsuario.class.getResource("/Imagenes/iAGRO_V04.png")));
		setTitle("Modificaci\u00F3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(200, 250, 200));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboRol = new JComboBox();
		comboRol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/*A continuacion llamamos al metodo evaluarComboBox 
			 * al activar el comboBox al escuchar con el ActionListener*/
				evaluarComboBox();
				/*
				 * La siguiente condicion evalua el item seleccionado en el comboBox y establece
				 * que se vean los parametros segun el item seleccionado.
				 */
				
				if (comboRol.getSelectedItem() == "Administrador") {
					txtCedula.setVisible(true);
					txtCedula.setEnabled(true);
					txtInstituto.setVisible(true);
					txtInstituto.setEnabled(true);
					txtProfesion.setVisible(false);
					txtProfesion.setEnabled(false);
					
				}else if (comboRol.getSelectedItem() == "Experto") {
					txtCedula.setVisible(true);
					txtCedula.setEnabled(true);
					txtProfesion.setVisible(true);
					txtProfesion.setEnabled(true);
					txtInstituto.setVisible(false);
					txtInstituto.setEnabled(false);

				} else {
					txtCedula.setVisible(false);
					txtCedula.setEnabled(false);
					txtInstituto.setVisible(false);
					txtInstituto.setEnabled(false);
					txtProfesion.setVisible(false);
					txtProfesion.setEnabled(false);
				}

			}
		});
		comboRol.setModel(new DefaultComboBoxModel(new String[] { "Administrador", "Experto", "Comun" }));
		comboRol.setBounds(336, 124, 196, 23);
		contentPane.add(comboRol);

		JLabel lblRegistro = new JLabel("Modificaci\u00F3n de usuario");
		lblRegistro.setForeground(new Color(255, 255, 255));
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setBounds(0, 56, 217, 42);
		contentPane.add(lblRegistro);

		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 102, 0));
		txtNombre.setToolTipText("Ingrese nombre");
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setText(usuario.getNombre());
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setBounds(38, 186, 196, 23);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setForeground(new Color(0, 102, 0));
		txtApellido.setToolTipText("Ingrese apellido");
		txtApellido.setText(usuario.getApellido());
		txtApellido.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellido.setColumns(10);
		txtApellido.setBounds(38, 250, 196, 23);
		contentPane.add(txtApellido);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setForeground(new Color(0, 102, 0));
		txtNombreUsuario.setToolTipText("Ingrese nombre de usuario");
		txtNombreUsuario.setText(usuario.getNombreUsuario());
		txtNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBounds(38, 121, 196, 25);
		contentPane.add(txtNombreUsuario);

		txtCorreo = new JTextField();
		txtCorreo.setForeground(new Color(0, 102, 0));
		txtCorreo.setToolTipText("Ingrese correo electr\u00F3nico");
		txtCorreo.setText(usuario.getCorreo());
		txtCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(336, 186, 196, 23);
		contentPane.add(txtCorreo);

		txtContrasena = new JPasswordField();
		txtContrasena.setForeground(new Color(0, 102, 0));
		txtContrasena.setToolTipText("Ingrese una contrase\u00F1a");
		txtContrasena.setText(usuario.getContrasena());
		txtContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(38, 318, 196, 26);
		contentPane.add(txtContrasena);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(0, 128, 0));
		btnModificar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				UsuariosBeanRemote usuariosBeanRemote;
				RolBeanRemote rolBeanRemote;
				usuario.setNombreUsuario(txtNombreUsuario.getText());
				usuario.setContrasena(txtContrasena.getText());
				usuario.setApellido(txtApellido.getText());
				usuario.setCorreo(txtCorreo.getText());
				usuario.setNombre(txtNombre.getText());
				usuario.setRol(rol);
					/*
					 * Lo que resta de la condicion establece los parametros segun el
					 * itemSeleccionado, e instancia un Usuario con su Rol relacionado.
					 */
					if (txtCedula.isEnabled() || txtInstituto.isEnabled()) {
						rol.setNombreRol("Administrador");
					}
				 
					if (txtCedula.isEnabled() || txtProfesion.isEnabled()) {
						rol.setNombreRol("Experto");
					}
					if(txtCedula.isEnabled() == false)
						rol.setNombreRol("Comun");
				try {
					usuariosBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);

					if (txtNombreUsuario.getText().isEmpty() || txtCorreo.getText().isEmpty()
							|| txtApellido.getText().isEmpty() || txtContrasena.getText().isEmpty()
							|| txtNombre.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Debe completar todos los campos", "Campos Incompletos!",
								JOptionPane.INFORMATION_MESSAGE);

						return;

					} else if (usuariosBeanRemote.registro(txtNombreUsuario.getText())) {
						JOptionPane.showMessageDialog(frame,
								"El nombre de usuario ya se encuentra en uso. Intente Nuevamente",
								"Nombre de usuario en uso!", JOptionPane.ERROR_MESSAGE);

					} else {
						usuariosBeanRemote.actualizar(usuario);

						JOptionPane.showMessageDialog(frame, "El Usuario ha sido Modificado con éxito.",
								"Usuario Modificado!", JOptionPane.INFORMATION_MESSAGE);
						VentanaGeneral ventanaGeneral = new VentanaGeneral(usuario);
						ventanaGeneral.setVisible(true);
						ventanaGeneral.setLocation(400, 150);
						dispose();
					}

				} catch (NamingException e1) {
					e1.printStackTrace();
				} catch (ServiciosException e1) {
					e1.printStackTrace();
				}

			}
		});
				
				
			
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(154, 437, 134, 23);
		contentPane.add(btnModificar);
		
		
		/*El boton "Volver" es para regresar a la pestaña de VentanaUsuario
		 * si bien la ventana registro se accede desde el inicio, esto solo
		 * sucede para facilitar el desarrollo de la app, pero a futuro no 
		 * habra un boton Registro en la sesion del usuario.*/
		
		btnNewButton = new JButton("Cancelar");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(new Color(0, 102, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaUsuario ventanaUsuario = new VentanaUsuario(usuario);
				ventanaUsuario.setLocation(400, 150);
				ventanaUsuario.setVisible(true);
				dispose();

			}
		});
		btnNewButton.setBounds(322, 437, 143, 23);
		contentPane.add(btnNewButton);

		txtCedula = new JTextField();
		txtCedula.setForeground(new Color(0, 102, 0));
		txtCedula.setToolTipText("Ingrese c\u00E9dula de identidad");
		txtCedula.setText(usuario.getCedula());
		txtCedula.setHorizontalAlignment(SwingConstants.CENTER);
		txtCedula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCedula.setBounds(38, 380, 196, 24);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);

		txtInstituto = new JTextField();
		txtInstituto.setForeground(new Color(0, 102, 0));
		txtInstituto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInstituto.setText(usuario.getInstituto());
		txtInstituto.setHorizontalAlignment(SwingConstants.CENTER);
		txtInstituto.setToolTipText("Ingrese instituto");
		txtInstituto.setBounds(336, 250, 196, 23);
		contentPane.add(txtInstituto);
		txtInstituto.setColumns(10);

		txtProfesion = new JTextField();
		txtProfesion.setForeground(new Color(0, 102, 0));
		txtProfesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProfesion.setText(usuario.getProfesion());
		txtProfesion.setHorizontalAlignment(SwingConstants.CENTER);
		txtProfesion.setToolTipText("Ingrese profesi\u00F3n");
		txtProfesion.setBounds(336, 318, 196, 26);
		contentPane.add(txtProfesion);
		txtProfesion.setColumns(10);

		txtContrasea = new JTextField();
		txtContrasea.setFont(new Font("Arial", Font.PLAIN, 11));
		txtContrasea.setForeground(new Color(255, 255, 255));
		txtContrasea.setText("Contrase\u00F1a");
		txtContrasea.setEditable(false);
		txtContrasea.setBackground(new Color(0, 102, 0));
		txtContrasea.setBounds(38, 305, 196, 14);
		contentPane.add(txtContrasea);
		txtContrasea.setColumns(10);

		txtApellido_1 = new JTextField();
		txtApellido_1.setText("Apellido");
		txtApellido_1.setForeground(Color.WHITE);
		txtApellido_1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtApellido_1.setEditable(false);
		txtApellido_1.setColumns(10);
		txtApellido_1.setBackground(new Color(0, 102, 0));
		txtApellido_1.setBounds(38, 238, 196, 14);
		contentPane.add(txtApellido_1);

		txtNombre_1 = new JTextField();
		txtNombre_1.setText("Nombre");
		txtNombre_1.setForeground(Color.WHITE);
		txtNombre_1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNombre_1.setEditable(false);
		txtNombre_1.setColumns(10);
		txtNombre_1.setBackground(new Color(0, 102, 0));
		txtNombre_1.setBounds(38, 173, 196, 14);
		contentPane.add(txtNombre_1);

		txtNombreDeUsuario = new JTextField();
		txtNombreDeUsuario.setText("Nombre de usuario");
		txtNombreDeUsuario.setForeground(Color.WHITE);
		txtNombreDeUsuario.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNombreDeUsuario.setEditable(false);
		txtNombreDeUsuario.setColumns(10);
		txtNombreDeUsuario.setBackground(new Color(0, 102, 0));
		txtNombreDeUsuario.setBounds(38, 109, 196, 14);
		contentPane.add(txtNombreDeUsuario);

		txtCedula2 = new JTextField();
		txtCedula2.setText("C\u00E9duda de identidad");
		txtCedula2.setForeground(Color.WHITE);
		txtCedula2.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCedula2.setEditable(false);
		txtCedula2.setColumns(10);
		txtCedula2.setBackground(new Color(0, 102, 0));
		txtCedula2.setBounds(38, 367, 196, 14);
		contentPane.add(txtCedula2);

		txtCorreoElectrnico = new JTextField();
		txtCorreoElectrnico.setText("Correo electr\u00F3nico");
		txtCorreoElectrnico.setForeground(Color.WHITE);
		txtCorreoElectrnico.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCorreoElectrnico.setEditable(false);
		txtCorreoElectrnico.setColumns(10);
		txtCorreoElectrnico.setBackground(new Color(0, 102, 0));
		txtCorreoElectrnico.setBounds(336, 173, 196, 14);
		contentPane.add(txtCorreoElectrnico);

		txtInstituto1 = new JTextField();
		txtInstituto1.setText("Instituto");
		txtInstituto1.setForeground(Color.WHITE);
		txtInstituto1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtInstituto1.setEditable(false);
		txtInstituto1.setColumns(10);
		txtInstituto1.setBackground(new Color(0, 102, 0));
		txtInstituto1.setBounds(336, 238, 196, 14);
		contentPane.add(txtInstituto1);

		txtProfesion1 = new JTextField();
		txtProfesion1.setText("Profesi\u00F3n");
		txtProfesion1.setForeground(Color.WHITE);
		txtProfesion1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtProfesion1.setEditable(false);
		txtProfesion1.setColumns(10);
		txtProfesion1.setBackground(new Color(0, 102, 0));
		txtProfesion1.setBounds(336, 305, 196, 14);
		contentPane.add(txtProfesion1);

		txtRol = new JTextField();
		txtRol.setText("Rol");
		txtRol.setForeground(Color.WHITE);
		txtRol.setFont(new Font("Arial", Font.PLAIN, 11));
		txtRol.setEditable(false);
		txtRol.setColumns(10);
		txtRol.setBackground(new Color(0, 102, 0));
		txtRol.setBounds(336, 109, 196, 14);
		contentPane.add(txtRol);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-130, -70, 950, 168);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(0, 102, 0));
		lblNewLabel.setIcon(new ImageIcon(VentanaEditarUsuario.class.getResource("/Imagenes/klipartz.com.png")));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 0));
		panel.setBounds(0, 0, 624, 98);
		contentPane.add(panel);

	}
	/* El siguiente metodo evaluarComboBox evalua el item seleccionado en el comboBox y establece
	 * que se vean y habiliten los parametros segun el item seleccionado.
	 */
	private void evaluarComboBox() {
		

		if (comboRol.getSelectedItem() == "Administrador") {
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
		}

	
	}
	/*El metodo crearUsuario, llama al EJBLocator para localizar los Beans y 
	 * consigo cada metodo de persistencia que vamos requerir a traves de su 
	 * interfaz remota UsuariosBeanRemote, de donde sacaremos las funciones para
	 * dar de alta un usuario en este caso la funcion se llama "crear" y le 
	 * pasamos por parametro el objeto Usuario, al que le vamos a insertar todos los
	 * campos descritos a continuacion. */
	private void crearUsuario() {
		/*Se enlazan los parametros escritos en cada campo de texto 
		 * con cada parametro de la entidad Usuario
		 * i.e: txtNombreUsuario obtiene el texto del campo (getText();)
		 * y lo "setea" al campo nombreUsuario de la entidad Usuario*/
		UsuariosBeanRemote usuariosBeanRemote;
		RolBeanRemote rolBeanRemote;
		Usuario usuario =  new Usuario();
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
		 * La siguiente condicion establece el nombreRol segun el
		 * itemSeleccionado, e instancia un Usuario con su Rol relacionado.
		 *(Administrador, Experto o Comun)  */

		if (txtCedula.isEnabled() || txtInstituto.isEnabled()) {
			rol.setNombreRol("Administrador");
		}
	 
		if (txtCedula.isEnabled() || txtProfesion.isEnabled()) {
			rol.setNombreRol("Experto");
		}
		if(txtCedula.isEnabled() == false)
			rol.setNombreRol("Comun");
		try {
			usuariosBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);
			/*La siguiente condicion if, evalua que los campos de textos no se encuentren
			 * vacios al momento de iniciar sesion, en caso de que se hallen vacios envia un mensaje de informacion
			 * indicando que debe completar los campos*/
			if (txtNombreUsuario.getText().isEmpty() || txtCorreo.getText().isEmpty()
					|| txtApellido.getText().isEmpty() || txtContrasena.getText().isEmpty()
					|| txtNombre.getText().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Debe completar todos los campos", "Campos Incompletos!",
						JOptionPane.INFORMATION_MESSAGE);

				return;
				/*El siguiente else if, llama al metodo "registro", el cual evalua que el usuario
				 * no se encuentre en la base de datos ya registrado, de esta manera evitaremos
				 * que los usuarios no accedan a cuentas agenas.*/
			} else if (usuariosBeanRemote.registro(txtNombreUsuario.getText())) {
				JOptionPane.showMessageDialog(frame,
						"El nombre de usuario ya se encuentra en uso. Intente Nuevamente",
						"Nombre de usuario en uso!", JOptionPane.ERROR_MESSAGE);
				/*Por ultimo ya teniendo todos los parametros de la entidad Usuario enlazados
				 * la condicion termina en un else, aqui es cuando el usuario pasa
				 * todas las "pruebas", es decir condiciones requeridas, y finalmente se da
				 * el alta del usuario, mas un dialogo indicando que se registro con exito. Redireccionamos a la ventana VentanaGeneral donde 
				 * hallaremos la aplicacion y el resto de sus funciones.*/
			} else {
				usuariosBeanRemote.crear(usuario);

				JOptionPane.showMessageDialog(frame, "El Usuario ha sido registrado con éxito.",
						"Usuario Registrado!", JOptionPane.INFORMATION_MESSAGE);
				VentanaGeneral ventanaGeneral = new VentanaGeneral(usuario);
				ventanaGeneral.setVisible(true);
				ventanaGeneral.setLocation(400, 150);
				dispose();
			}

		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (ServiciosException e1) {
			e1.printStackTrace();
		}

	
	}
}
