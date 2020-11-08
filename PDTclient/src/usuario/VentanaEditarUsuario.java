package usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NamingException;
import javax.swing.JButton;
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
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.UsuariosBeanRemote;

public class VentanaEditarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNombreUsuario;
	private JTextField txtCorreo;
	private JTextField txtContrasena;
	private JFrame frame;

	public VentanaEditarUsuario(Usuario usuario) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*
		 * JComboBox<String> comboBoxRol = new JComboBox<>();
		 * comboBoxRol.setForeground(new Color(65, 105, 225)); comboBoxRol.setFont(new
		 * Font("Trebuchet MS", Font.BOLD, 14)); comboBoxRol.setModel(new
		 * DefaultComboBoxModel<String>(new String[] {"Administrador", "Experto",
		 * "Comun"})); comboBoxRol.setBounds(327, 94, 174, 42);
		 * contentPane.add(comboBoxRol);
		 * comboBoxRol.setToolTipText(usuario.getRol().toString());
		 */

		JLabel lblModificar = new JLabel("Modificar Usuario");
		lblModificar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblModificar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModificar.setBounds(195, 11, 174, 42);
		contentPane.add(lblModificar);

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
				
				UsuariosBeanRemote usuariosBeanRemote;
				usuario.setNombreUsuario(txtNombreUsuario.getText());
				usuario.setContrasena(txtContrasena.getText());
				usuario.setApellido(txtApellido.getText());
				usuario.setCorreo(txtCorreo.getText());
				usuario.setNombre(txtNombre.getText());			
				
				try {
					usuariosBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);

					if (txtNombreUsuario.getText().isEmpty() || txtCorreo.getText().isEmpty()
							|| txtApellido.getText().isEmpty() || txtContrasena.getText().isEmpty()
							|| txtNombre.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Debe completar todos los campos", "Campos Incompletos!",
								JOptionPane.INFORMATION_MESSAGE);

						return;


					} else {
						usuariosBeanRemote.actualizar(usuario);

						JOptionPane.showMessageDialog(frame, "El Usuario ha sido modificado con éxito.",
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
		btnModificar.setBounds(394, 418, 134, 42);
		contentPane.add(btnModificar);

	}
}


