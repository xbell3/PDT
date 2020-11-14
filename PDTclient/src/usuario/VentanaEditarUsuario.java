package usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.cliente.EJBLocator;
import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.entidades.Rol;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.RolBeanRemote;
import com.servicios.UsuariosBeanRemote;

public class VentanaEditarUsuario extends JFrame {
	// Declaramos todos parametros y componentes que vamos a usar...
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
		/*
		 * A continuacion definimos todas las caracteristicas y valores de cada objeto o
		 * parametro declarado.
		 */
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboRol = new JComboBox();
		comboRol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * A continuacion llamamos al metodo evaluarComboBox al activar el comboBox al
				 * escuchar con el ActionListener
				 */
				evaluarComboBox();
			}
		});
		comboRol.setModel(new DefaultComboBoxModel(new String[] { "Administrador", "Experto", "Comun" }));
		comboRol.setBounds(373, 95, 136, 22);
		contentPane.add(comboRol);

		JLabel lblModificar = new JLabel("Modificar Usuario");
		lblModificar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblModificar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModificar.setBounds(195, 11, 174, 42);
		contentPane.add(lblModificar);

		txtCedula = new JTextField();
		txtCedula.setVisible(false);
		txtCedula.setEnabled(false);
		txtCedula.setText("Cedula");
		txtCedula.setHorizontalAlignment(SwingConstants.CENTER);
		txtCedula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCedula.setColumns(10);
		txtCedula.setBounds(354, 147, 168, 42);
		contentPane.add(txtCedula);

		txtProfesion = new JTextField();
		txtProfesion.setEnabled(false);
		txtProfesion.setVisible(false);
		txtProfesion.setText("Profesion");
		txtProfesion.setHorizontalAlignment(SwingConstants.CENTER);
		txtProfesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtProfesion.setColumns(10);
		txtProfesion.setBounds(354, 221, 168, 42);
		contentPane.add(txtProfesion);

		txtInstituto = new JTextField();
		txtInstituto.setVisible(false);
		txtInstituto.setEnabled(false);
		txtInstituto.setText("Instituto");
		txtInstituto.setHorizontalAlignment(SwingConstants.CENTER);
		txtInstituto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtInstituto.setColumns(10);
		txtInstituto.setBounds(354, 221, 168, 42);
		contentPane.add(txtInstituto);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setText(usuario.getNombre());
		txtNombre.setBounds(100, 83, 168, 42);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setText(usuario.getApellido());
		txtApellido.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtApellido.setColumns(10);
		txtApellido.setBounds(100, 147, 168, 42);
		contentPane.add(txtApellido);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setText(usuario.getNombreUsuario());
		txtNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBounds(100, 208, 168, 42);
		contentPane.add(txtNombreUsuario);

		txtCorreo = new JTextField();
		txtCorreo.setText(usuario.getCorreo());
		txtCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(100, 278, 168, 42);
		contentPane.add(txtCorreo);

		txtContrasena = new JPasswordField();
		txtContrasena.setText(usuario.getContrasena());
		txtContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(100, 350, 168, 42);
		contentPane.add(txtContrasena);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarUsuario();
			}
		});

		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(394, 418, 134, 42);
		contentPane.add(btnModificar);

	}

	private void modificarUsuario() {
		Usuario usuario = new Usuario();
		UsuariosBeanRemote usuariosBeanRemote;
		RolBeanRemote rolBeanRemote;
		usuario.setContrasena(txtContrasena.getText());
		usuario.setApellido(txtApellido.getText());
		usuario.setCorreo(txtCorreo.getText());
		usuario.setNombre(txtNombre.getText());
		usuario.setRol(rol);
		/*
		 * La siguiente condicion establece el nombreRol segun el itemSeleccionado, e
		 * instancia un Usuario con su Rol relacionado. (Administrador, Experto o Comun)
		 */

		if (txtCedula.isEnabled() || txtInstituto.isEnabled()) {
			rol.setNombreRol("Administrador");
		}

		if (txtCedula.isEnabled() || txtProfesion.isEnabled()) {
			rol.setNombreRol("Experto");
		}
		if (txtCedula.isEnabled() == false)
			rol.setNombreRol("Comun");
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
						JOptionPane.INFORMATION_MESSAGE);

				return;
				/*
				 * Por ultimo ya teniendo todos los parametros de la entidad Usuario enlazados
				 * la condicion termina en un else, aqui es cuando el usuario pasa todas las
				 * "pruebas", es decir condiciones requeridas, y finalmente se da la
				 * modificacion del usuario, mas un dialogo indicando que se modificacion tuvo
				 * exito. Redireccionamos a la ventana VentanaUsuario, donde se contemplaran los
				 * cambios.
				 */
			} else {
				usuariosBeanRemote.actualizar(usuario);

				JOptionPane.showMessageDialog(frame, "El Usuario ha sido Modificado con éxito.", "Usuario Modificado!",
						JOptionPane.INFORMATION_MESSAGE);
				VentanaUsuario ventanaUsuario = new VentanaUsuario(usuario);
				ventanaUsuario.setVisible(true);
				ventanaUsuario.setLocation(400, 150);
				dispose();
			}

		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (ServiciosException e1) {
			e1.printStackTrace();
		}

	}

	/*
	 * El siguiente metodo evaluarComboBox evalua el item seleccionado en el
	 * comboBox y establece que se vean y habiliten los parametros segun el item
	 * seleccionado.
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
}
