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

public class VentanaRegistrarUsuario extends JFrame {

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

	public VentanaRegistrarUsuario(Usuario usuario) {
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

		JComboBox comboRol = new JComboBox();
		comboRol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * La siguiente condicion evalua el item seleccionado en el comboBox y establece
				 * que se vean los parametros segun el item seleccionado.
				 */

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
		});
		comboRol.setModel(new DefaultComboBoxModel(new String[] { "Administrador", "Experto", "Comun" }));
		comboRol.setBounds(336, 124, 196, 23);
		contentPane.add(comboRol);

		JLabel lblRegistro = new JLabel("Registro de usuario");
		lblRegistro.setForeground(new Color(255, 255, 255));
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setBounds(0, 56, 183, 42);
		contentPane.add(lblRegistro);

		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 102, 0));
		txtNombre.setToolTipText("Ingrese nombre");
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setBounds(38, 186, 196, 23);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setForeground(new Color(0, 102, 0));
		txtApellido.setToolTipText("Ingrese apellido");
		txtApellido.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellido.setColumns(10);
		txtApellido.setBounds(38, 250, 196, 23);
		contentPane.add(txtApellido);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setForeground(new Color(0, 102, 0));
		txtNombreUsuario.setToolTipText("Ingrese nombre de usuario");
		txtNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBounds(38, 121, 196, 25);
		contentPane.add(txtNombreUsuario);

		txtCorreo = new JTextField();
		txtCorreo.setForeground(new Color(0, 102, 0));
		txtCorreo.setToolTipText("Ingrese correo electr\u00F3nico");
		txtCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(336, 186, 196, 23);
		contentPane.add(txtCorreo);

		txtContrasena = new JPasswordField();
		txtContrasena.setForeground(new Color(0, 102, 0));
		txtContrasena.setToolTipText("Ingrese una contrase\u00F1a");
		txtContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(38, 318, 196, 26);
		contentPane.add(txtContrasena);

		JButton btnRegistrarme = new JButton("Registrarme");
		btnRegistrarme.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarme.setForeground(new Color(0, 102, 0));
		btnRegistrarme.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				UsuariosBeanRemote usuariosBeanRemote;
				RolBeanRemote rolBeanRemote;
				usuario.setNombreUsuario(txtNombreUsuario.getText());
				usuario.setContrasena(txtContrasena.getText());
				usuario.setApellido(txtApellido.getText());
				usuario.setCorreo(txtCorreo.getText());
				usuario.setNombre(txtNombre.getText());

				// usuario.setCedula(txtCedula.getText());
				// usuario.setInstituto(txtInstituto.getText());
				// usuario.setProfesion(txtProfesion.getText());
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
		});
		btnRegistrarme.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarme.setBounds(92, 437, 143, 23);
		contentPane.add(btnRegistrarme);

		btnNewButton = new JButton("Volver");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(new Color(0, 102, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaInicio ventanaInicio = new VentanaInicio(usuario);
				ventanaInicio.setLocation(400, 150);
				ventanaInicio.setVisible(true);
				dispose();

			}
		});
		btnNewButton.setBounds(360, 437, 143, 23);
		contentPane.add(btnNewButton);

		txtCedula = new JTextField();
		txtCedula.setHorizontalAlignment(SwingConstants.CENTER);
		txtCedula.setForeground(new Color(0, 102, 0));
		txtCedula.setToolTipText("Ingrese c\u00E9dula de identidad");
		txtCedula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCedula.setBounds(38, 380, 196, 24);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);

		txtInstituto = new JTextField();
		txtInstituto.setForeground(new Color(0, 102, 0));
		txtInstituto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInstituto.setHorizontalAlignment(SwingConstants.CENTER);
		txtInstituto.setToolTipText("Ingrese instituto");
		txtInstituto.setBounds(336, 250, 196, 23);
		contentPane.add(txtInstituto);
		txtInstituto.setColumns(10);

		txtProfesion = new JTextField();
		txtProfesion.setForeground(new Color(0, 102, 0));
		txtProfesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		lblNewLabel.setIcon(new ImageIcon(VentanaRegistrarUsuario.class.getResource("/Imagenes/klipartz.com.png")));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 0));
		panel.setBounds(0, 0, 624, 98);
		contentPane.add(panel);

	}
}
