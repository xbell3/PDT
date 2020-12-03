package usuario;

import java.awt.Color;
import java.awt.Font;

import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.EJBLocator;
import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.entidades.Rol;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.RolBeanRemote;
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

public class VentanaEditarUsuario extends JFrame {
	
	
//Declaramos todos parametros y componentes que vamos a usar...
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JFrame frame;
	private JButton btnNewButton;
	private JTextField txtCedula;
	private JTextField txtInstituto;
	private JTextField txtProfesion;
	private JTextField txtApellido_1;
	private JTextField txtNombre_1;
	private JTextField txtCedula2;
	private JTextField txtCorreoElectrnico;
	private JTextField txtInstituto1;
	private JTextField txtProfesion1;
	private JTextField txtRol;
	private Rol rol = new Rol();
	private JLabel lblNewLabel;
	private JComboBox comboRol;
	private JLabel lblModificacinDeUsuario;
	public static JLabel lblNombreUsuario;
	
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
		
		JLabel lblNombreSistema = new JLabel("");
		lblNombreSistema.setIcon(new ImageIcon(VentanaActividad.class.getResource("/Imagenes/iconoApp3.png")));
		lblNombreSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreSistema.setForeground(Color.WHITE);
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(259, 4, 98, 86);
		contentPane.add(lblNombreSistema);
		
		lblNombreUsuario = new JLabel();
		lblNombreUsuario.setBounds(32, 0, 211, 28);
		contentPane.add(lblNombreUsuario);
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreUsuario.setForeground(Color.WHITE);
		
		VentanaEditarUsuario.lblNombreUsuario.setText(VentanaInicio.txtNombreUsuario.getText());

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaGeneral.class.getResource("/Imagenes/Usuario_gris.png")));
		lblNewLabel_1.setBounds(10, 0, 37, 28);
		contentPane.add(lblNewLabel_1);
		
		
		

		comboRol = new JComboBox();
		comboRol.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboRol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/*A continuacion llamamos al metodo evaluarComboBox 
			 * al activar el comboBox al escuchar con el ActionListener*/
				evaluarComboBox();
				

			}
		});
		comboRol.setModel(new DefaultComboBoxModel(new String[] { "Administrador", "Experto", "Comun" }));
		comboRol.setBounds(336, 161, 196, 23);
		contentPane.add(comboRol);

		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 102, 0));
		txtNombre.setToolTipText("Ingrese nombre");
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setText(usuario.getNombre());
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setBounds(38, 205, 196, 23);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setForeground(new Color(0, 102, 0));
		txtApellido.setToolTipText("Ingrese apellido");
		txtApellido.setText(usuario.getApellido());
		txtApellido.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellido.setColumns(10);
		txtApellido.setBounds(38, 269, 196, 23);
		contentPane.add(txtApellido);

		txtCorreo = new JTextField();
		txtCorreo.setForeground(new Color(0, 102, 0));
		txtCorreo.setToolTipText("Ingrese correo electr\u00F3nico");
		txtCorreo.setText(usuario.getCorreo());
		txtCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(336, 223, 196, 23);
		contentPane.add(txtCorreo);


		JButton btnModificar = new JButton("Modificar");
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setBackground(new Color(0, 102, 0));
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				modificarUsuario(usuario);
				
			}
		});
				
				
			
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(38, 437, 134, 23);
		contentPane.add(btnModificar);
		
		
		/*El boton "Cancelar" es para regresar a la pestaña de VentanaUsuario
		 * si bien la ventana registro se accede desde el inicio, esto solo
		 * sucede para facilitar el desarrollo de la app, pero a futuro no 
		 * habra un boton Registro en la sesion del usuario.*/
		
		btnNewButton = new JButton("Cancelar");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(new Color(0, 102, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}
		});
		btnNewButton.setBounds(446, 437, 134, 23);
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
		txtInstituto.setBounds(336, 287, 196, 23);
		contentPane.add(txtInstituto);
		txtInstituto.setColumns(10);

		txtProfesion = new JTextField();
		txtProfesion.setForeground(new Color(0, 102, 0));
		txtProfesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProfesion.setText(usuario.getProfesion());
		txtProfesion.setHorizontalAlignment(SwingConstants.CENTER);
		txtProfesion.setToolTipText("Ingrese profesi\u00F3n");
		txtProfesion.setBounds(336, 355, 196, 26);
		contentPane.add(txtProfesion);
		txtProfesion.setColumns(10);


		txtApellido_1 = new JTextField();
		txtApellido_1.setText("Apellido");
		txtApellido_1.setForeground(Color.WHITE);
		txtApellido_1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtApellido_1.setEditable(false);
		txtApellido_1.setColumns(10);
		txtApellido_1.setBackground(new Color(0, 102, 0));
		txtApellido_1.setBounds(38, 257, 196, 14);
		contentPane.add(txtApellido_1);

		txtNombre_1 = new JTextField();
		txtNombre_1.setText("Nombre");
		txtNombre_1.setForeground(Color.WHITE);
		txtNombre_1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNombre_1.setEditable(false);
		txtNombre_1.setColumns(10);
		txtNombre_1.setBackground(new Color(0, 102, 0));
		txtNombre_1.setBounds(38, 192, 196, 14);
		contentPane.add(txtNombre_1);;

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
		txtCorreoElectrnico.setBounds(336, 210, 196, 14);
		contentPane.add(txtCorreoElectrnico);

		txtInstituto1 = new JTextField();
		txtInstituto1.setText("Instituto");
		txtInstituto1.setForeground(Color.WHITE);
		txtInstituto1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtInstituto1.setEditable(false);
		txtInstituto1.setColumns(10);
		txtInstituto1.setBackground(new Color(0, 102, 0));
		txtInstituto1.setBounds(336, 275, 196, 14);
		contentPane.add(txtInstituto1);

		txtProfesion1 = new JTextField();
		txtProfesion1.setText("Profesi\u00F3n");
		txtProfesion1.setForeground(Color.WHITE);
		txtProfesion1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtProfesion1.setEditable(false);
		txtProfesion1.setColumns(10);
		txtProfesion1.setBackground(new Color(0, 102, 0));
		txtProfesion1.setBounds(336, 342, 196, 14);
		contentPane.add(txtProfesion1);

		txtRol = new JTextField();
		txtRol.setText("Rol");
		txtRol.setForeground(Color.WHITE);
		txtRol.setFont(new Font("Arial", Font.PLAIN, 11));
		txtRol.setEditable(false);
		txtRol.setColumns(10);
		txtRol.setBackground(new Color(0, 102, 0));
		txtRol.setBounds(336, 146, 196, 14);
		contentPane.add(txtRol);
		

		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/cambioUser.png")));
		btnSalir.setToolTipText("Cambiar usuario");
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setForeground(new Color(0, 102, 0));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaInicio ventanaInicio = new VentanaInicio(usuario);
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
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBorrar.setBackground(new Color(0, 102, 0));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					borrarUsuario(usuario.getId());
				} catch (ServiciosException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBorrar.setBounds(243, 437, 134, 23);
		contentPane.add(btnBorrar);
		
		lblModificacinDeUsuario = new JLabel("Modificaci\u00F3n de usuario");
		lblModificacinDeUsuario.setOpaque(true);
		lblModificacinDeUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		lblModificacinDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificacinDeUsuario.setForeground(Color.WHITE);
		lblModificacinDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModificacinDeUsuario.setBackground(new Color(60, 179, 113));
		lblModificacinDeUsuario.setBounds(0, 109, 624, 23);
		contentPane.add(lblModificacinDeUsuario);
		
		JLabel lblPortada = new JLabel("");
		lblPortada.setIcon(new ImageIcon(VentanaRegistrarFormulario.class.getResource("/Imagenes/klipartz.com.png")));
		lblPortada.setBounds(-112, 0, 736, 90);
		contentPane.add(lblPortada);
				
						JPanel panel = new JPanel();
						panel.setBackground(new Color(0, 102, 0));
						panel.setBounds(0, 0, 624, 90);
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
	
	/*El metodo modificarUsuario, llama al EJBLocator para localizar los Beans y 
	 * consigo cada metodo de persistencia que vamos requerir a traves de su 
	 * interfaz remota UsuariosBeanRemote, de donde sacaremos las funciones para
	 * dar de alta un usuario en este caso la funcion se llama "crear" y le 
	 * pasamos por parametro el objeto Usuario, al que le vamos a insertar todos los
	 * campos descritos a continuacion. */
	private void borrarUsuario(Long id) throws ServiciosException {
		UsuariosBeanRemote usuariosBeanRemote;
		try {
			usuariosBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);
			usuariosBeanRemote.borrar(id);
			
			JOptionPane.showMessageDialog(frame, "El Usuario ha sido borrado.",
					"Usuario borrado!", JOptionPane.INFORMATION_MESSAGE);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void modificarUsuario(Usuario usuario) {
		/*Se enlazan los parametros escritos en cada campo de texto 
		 * con cada parametro de la entidad Usuario
		 * i.e: txtNombreUsuario obtiene el texto del campo (getText();)
		 * y lo "setea" al campo nombreUsuario de la entidad Usuario*/
		UsuariosBeanRemote usuariosBeanRemote;
		RolBeanRemote rolBeanRemote;
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

		if (txtCedula.isEnabled() && txtInstituto.isEnabled()) {
			rol.setNombreRol("Administrador");
		}
	 
		if (txtCedula.isEnabled() && txtProfesion.isEnabled()) {
			rol.setNombreRol("Experto");
		}
		if(!txtCedula.isEnabled())
			rol.setNombreRol("Comun");
		try {
			usuariosBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);
			/*La siguiente condicion if, evalua que los campos de textos no se encuentren
			 * vacios al momento de iniciar sesion, en caso de que se hallen vacios envia un mensaje de informacion
			 * indicando que debe completar los campos*/
			if ( txtCorreo.getText().isEmpty()	|| txtApellido.getText().isEmpty() ||
					txtNombre.getText().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Debe completar todos los campos", "Campos Incompletos!",
						JOptionPane.INFORMATION_MESSAGE);

				return;
				/*El siguiente else if, llama al metodo "registro", el cual evalua que el usuario
				 * no se encuentre en la base de datos ya registrado, de esta manera evitaremos
				 * que los usuarios no accedan a cuentas agenas.*/
			} else {
				usuariosBeanRemote.actualizar(usuario);

				JOptionPane.showMessageDialog(frame, "El Usuario ha sido modificado con éxito.",
						"Usuario modificado!", JOptionPane.INFORMATION_MESSAGE);
				
				dispose();
			}

		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (ServiciosException e1) {
			e1.printStackTrace();
		}

	
	}
}
