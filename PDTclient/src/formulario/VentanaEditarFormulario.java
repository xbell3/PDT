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

public class VentanaEditarFormulario extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField txtNombreFormulario;
	private JTextField txtResumen;
	/**
	 * Create the frame.
	 */
	public VentanaEditarFormulario(Usuario usuario, Formulario formulario) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"),		UIManager.getColor("Button.shadow"), null, null));
		panelUsuario.setBackground(SystemColor.activeCaption);
		panelUsuario.setBounds(0, 0, 784, 90);
		contentPane.add(panelUsuario);
		
		JLabel lblTipoUser = new JLabel("TipoUser");
		lblTipoUser.setBounds(541, 45, 46, 14);
		panelUsuario.add(lblTipoUser);
		
		JLabel lblNewLabel = new JLabel("(Nombre del usuario)");
		lblNewLabel.setBounds(488, 20, 118, 14);
		panelUsuario.add(lblNewLabel);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(714, 16, 60, 23);
		panelUsuario.add(btnSalir);
		
		JButton btnNewButton = new JButton("Ayuda");
		btnNewButton.setBounds(616, 16, 88, 23);
		panelUsuario.add(btnNewButton);
		
		JLabel lblNombreSistema = new JLabel("Nombre App");
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(10, 16, 152, 34);
		panelUsuario.add(lblNombreSistema);
		
		JPanel panelFormulario = new JPanel();
		panelFormulario.setLayout(null);
		panelFormulario.setBackground(Color.WHITE);
		panelFormulario.setBounds(0, 90, 784, 471);
		contentPane.add(panelFormulario);
		
		JLabel lblModificar = new JLabel("Modificar Formlario");
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblModificar.setBounds(65, 35, 226, 42);
		panelFormulario.add(lblModificar);
		
		txtNombreFormulario = new JTextField();
		txtNombreFormulario.setText("Nombre de Formulario");
		txtNombreFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreFormulario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNombreFormulario.setColumns(10);
		txtNombreFormulario.setBounds(65, 171, 168, 42);
		panelFormulario.add(txtNombreFormulario);
		
		txtResumen = new JTextField();
		txtResumen.setText("Resumen");
		txtResumen.setHorizontalAlignment(SwingConstants.CENTER);
		txtResumen.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		btnVolver.setBounds(476, 355, 89, 23);
		panelFormulario.add(btnVolver);

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
