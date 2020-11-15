package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;

import com.cliente.EJBLocator;
import com.cliente.VentanaGeneral;
import com.entidades.Formulario;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.FormulariosBeanRemote;
import com.servicios.UsuariosBeanRemote;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.naming.NamingException;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class VentanaRegistrarFormulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreFormulario;
	private JTextField txtResumen;
	public JFrame frame;
	/**
	 * Create the frame.
	 */
	public VentanaRegistrarFormulario(Usuario usuario) {
		setTitle("Nuevo Formulario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegistrarFormulario.class.getResource("/Imagenes/iAGRO_V04.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelFormulario = new JPanel();
		panelFormulario.setBackground(new Color(204, 255, 204));
		panelFormulario.setBounds(0, 90, 624, 392);
		contentPane.add(panelFormulario);
		panelFormulario.setLayout(null);
		
		txtNombreFormulario = new JTextField();
		txtNombreFormulario.setText("Nombre de Formulario");
		txtNombreFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreFormulario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNombreFormulario.setColumns(10);
		txtNombreFormulario.setBounds(123, 164, 168, 42);
		panelFormulario.add(txtNombreFormulario);
		
		txtResumen = new JTextField();
		txtResumen.setText("Resumen");
		txtResumen.setHorizontalAlignment(SwingConstants.CENTER);
		txtResumen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtResumen.setColumns(10);
		txtResumen.setBounds(339, 164, 168, 42);
		panelFormulario.add(txtResumen);
		
		JButton btnCrearFormulario = new JButton("Crear formulario");
		btnCrearFormulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormulariosBeanRemote formulariosBeanRemote;
				Formulario formulario = new Formulario ();
				formulario.setNombreFormulario(txtNombreFormulario.getText());
				formulario.setResumen(txtResumen.getText());
				
				try {

					formulariosBeanRemote = EJBLocator.getInstance().lookup(FormulariosBeanRemote.class);

					if (txtNombreFormulario.getText().isEmpty() || txtResumen.getText().isEmpty()
							) {
						JOptionPane.showMessageDialog(frame, "Debe completar todos los campos", "Campos Incompletos!",
								JOptionPane.INFORMATION_MESSAGE);

						return;

					} else if (formulariosBeanRemote.registro(txtNombreFormulario.getText())) {
						JOptionPane.showMessageDialog(frame,
								"El nombre del formulario ya se encuentra en uso. Intente Nuevamente",
								"Nombre de formulario en uso!", JOptionPane.ERROR_MESSAGE);

					} else {
						formulariosBeanRemote.crear(formulario);

						JOptionPane.showMessageDialog(frame, "El Formulario ha sido registrado con éxito.",
								"Formulario Registrado!", JOptionPane.INFORMATION_MESSAGE);
						VentanaFormulario ventanaFormulario = new VentanaFormulario(usuario);
						ventanaFormulario.setVisible(true);
						ventanaFormulario.setLocation(400, 150);
						dispose();
					}

				
				} catch (NamingException e1) {
					e1.printStackTrace();
				} catch (ServiciosException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCrearFormulario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCrearFormulario.setBounds(219, 339, 174, 42);
		panelFormulario.add(btnCrearFormulario);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				VentanaFormulario ventanaFormulario = new VentanaFormulario(usuario);
				ventanaFormulario.setVisible(true);
				ventanaFormulario.setLocation(400, 150);
				dispose();
			}
		});
		btnVolver.setBounds(450, 351, 89, 23);
		panelFormulario.add(btnVolver);
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"),
						UIManager.getColor("Button.shadow"), null, null));
		panelUsuario.setBackground(new Color(0, 102, 0));
		panelUsuario.setBounds(0, 0, 624, 90);
		contentPane.add(panelUsuario);
		
		JLabel lblTipoUser = new JLabel("TipoUser");
		lblTipoUser.setBounds(340, 41, 46, 14);
		panelUsuario.add(lblTipoUser);
		
		JLabel lblNewLabel = new JLabel("(Nombre del usuario)");
		lblNewLabel.setBounds(287, 16, 118, 14);
		panelUsuario.add(lblNewLabel);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(542, 26, 60, 23);
		panelUsuario.add(btnSalir);
		
		JButton btnNewButton = new JButton("Ayuda");
		btnNewButton.setBounds(444, 26, 88, 23);
		panelUsuario.add(btnNewButton);
		
		JLabel lblNuevoFormulario = new JLabel("Nuevo Formulario");
		lblNuevoFormulario.setForeground(new Color(255, 255, 255));
		lblNuevoFormulario.setBounds(10, 41, 174, 42);
		panelUsuario.add(lblNuevoFormulario);
		lblNuevoFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoFormulario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaRegistrarFormulario.class.getResource("/Imagenes/klipartz.com.png")));
		lblNewLabel_1.setBounds(-112, 0, 736, 90);
		panelUsuario.add(lblNewLabel_1);
	}
}
