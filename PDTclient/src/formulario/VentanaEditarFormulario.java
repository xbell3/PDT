package formulario;

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
import com.entidades.Formulario;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.FormulariosBeanRemote;
import com.servicios.RolBeanRemote;
import com.servicios.UsuariosBeanRemote;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Toolkit;

public class VentanaEditarFormulario extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField txtNombreFormulario;
	private JTextField txtResumen;
	/**
	 * Create the frame.
	 */
	public VentanaEditarFormulario(Usuario usuario, Formulario formulario) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaEditarFormulario.class.getResource("/Imagenes/iAGRO_V04.png")));
		setTitle("Modificar Formulario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"),		UIManager.getColor("Button.shadow"), null, null));
		panelUsuario.setBackground(new Color(0, 102, 0));
		panelUsuario.setBounds(0, 0, 784, 90);
		contentPane.add(panelUsuario);
		
		JLabel lblTipoUser = new JLabel("TipoUser");
		lblTipoUser.setBounds(368, 36, 46, 14);
		panelUsuario.add(lblTipoUser);
		
		JLabel lblNewLabel = new JLabel("(Nombre del usuario)");
		lblNewLabel.setBounds(315, 11, 118, 14);
		panelUsuario.add(lblNewLabel);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(541, 7, 60, 23);
		panelUsuario.add(btnSalir);
		
		JButton btnNewButton = new JButton("Ayuda");
		btnNewButton.setBounds(443, 7, 88, 23);
		panelUsuario.add(btnNewButton);
		
		JLabel lblNombreSistema = new JLabel("Nombre App");
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(10, 16, 152, 34);
		panelUsuario.add(lblNombreSistema);
		
		JPanel panelFormulario = new JPanel();
		panelFormulario.setLayout(null);
		panelFormulario.setBackground(new Color(204, 255, 204));
		panelFormulario.setBounds(0, 90, 624, 392);
		contentPane.add(panelFormulario);
		
		JLabel lblModificar = new JLabel("Modificar Formlario");
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblModificar.setBounds(65, 35, 226, 42);
		panelFormulario.add(lblModificar);
		
		txtNombreFormulario = new JTextField();
		txtNombreFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreFormulario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNombreFormulario.setText(formulario.getNombreFormulario());
		txtNombreFormulario.setColumns(10);
		txtNombreFormulario.setBounds(65, 171, 168, 42);
		panelFormulario.add(txtNombreFormulario);
		
		txtResumen = new JTextField();
		txtResumen.setHorizontalAlignment(SwingConstants.CENTER);
		txtResumen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtResumen.setText(formulario.getResumen());
		txtResumen.setColumns(10);
		txtResumen.setBounds(281, 171, 168, 42);
		panelFormulario.add(txtResumen);
		
		JButton btnModificarFormulario = new JButton("Modificar Formulario");
		btnModificarFormulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarFormulario(formulario);
			}
		});
		btnModificarFormulario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModificarFormulario.setBounds(245, 343, 174, 42);
		panelFormulario.add(btnModificarFormulario);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {							
					dispose();
				}
		});
		btnVolver.setBounds(429, 355, 89, 23);
		panelFormulario.add(btnVolver);
		
		JButton btnAgregarCasilla = new JButton("Agregar Casilla");
		btnAgregarCasilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaRegistrarCasilla ventanaRegistrarCasilla = new VentanaRegistrarCasilla(usuario, formulario);
				ventanaRegistrarCasilla.setLocation(400, 150);
				ventanaRegistrarCasilla.setVisible(true);
			}
		});
		btnAgregarCasilla.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAgregarCasilla.setBounds(245, 290, 174, 42);
		panelFormulario.add(btnAgregarCasilla);

	}
	/*El metodo modificarFormulRio, llama al EJBLocator para localizar los Beans y 
	 * consigo cada metodo de persistencia que vamos requerir a traves de su 
	 * interfaz remota FormulariosBeanRemote, de donde sacaremos las funciones para
	 * dar de alta un usuario en este caso la funcion se llama "crear" y le 
	 * pasamos por parametro el objeto Formulario, al que le vamos a insertar todos los
	 * campos descritos a continuacion. */
	private void modificarFormulario(Formulario formulario) {

		FormulariosBeanRemote formulariosBeanRemote;
		formulario.setNombreFormulario(txtNombreFormulario.getText());
		formulario.setResumen(txtResumen.getText());
		
		try {

			formulariosBeanRemote = EJBLocator.getInstance().lookup(FormulariosBeanRemote.class);

			if (txtNombreFormulario.getText().isEmpty() || txtResumen.getText().isEmpty()
					) {
				JOptionPane.showMessageDialog(frame, "Debe completar todos los campos", "Campos Incompletos!",
						JOptionPane.INFORMATION_MESSAGE);

				return;

			}else {
				formulariosBeanRemote.actualizar(formulario);

				JOptionPane.showMessageDialog(frame, "El Formulario ha sido registrado con éxito.",
						"Formulario Registrado!", JOptionPane.INFORMATION_MESSAGE);
			}

		
		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (ServiciosException e1) {
			e1.printStackTrace();
		}
	
	}
}
