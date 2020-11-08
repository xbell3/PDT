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

import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.cliente.EJBLocator;
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
	private JTextField txtProfesion;
	private JTextField txtInstituto;
	private Rol rol = new Rol();
	public VentanaRegistrarUsuario(Usuario usuario) {
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
		comboRol.setBounds(373, 95, 136, 22);
		contentPane.add(comboRol);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setBounds(195, 11, 174, 42);
		contentPane.add(lblRegistro);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setText("Nombre");
		txtNombre.setBounds(100, 83, 168, 42);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setText("Apellido");
		txtApellido.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtApellido.setColumns(10);
		txtApellido.setBounds(100, 147, 168, 42);
		contentPane.add(txtApellido);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setText("Nombre de Usuario");
		txtNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBounds(100, 208, 168, 42);
		contentPane.add(txtNombreUsuario);

		txtCorreo = new JTextField();
		txtCorreo.setText("Correo");
		txtCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(100, 278, 168, 42);
		contentPane.add(txtCorreo);

		txtContrasena = new JPasswordField();
		txtContrasena.setText("Contrase\u00F1a");
		txtContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(100, 350, 168, 42);
		contentPane.add(txtContrasena);

		JButton btnRegistrarme = new JButton("Registrarme");
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
		btnRegistrarme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrarme.setBounds(348, 400, 174, 42);
		contentPane.add(btnRegistrarme);

		btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaInicio ventanaInicio = new VentanaInicio(usuario);
				ventanaInicio.setLocation(400, 150);
				ventanaInicio.setVisible(true);
				dispose();

			}
		});
		btnNewButton.setBounds(579, 412, 89, 23);
		contentPane.add(btnNewButton);

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

	}
}
