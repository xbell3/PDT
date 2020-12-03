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
import com.cliente.VentanaInicio;
import com.entidades.Formulario;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.FormulariosBeanRemote;
import com.servicios.UsuariosBeanRemote;

import actividad.VentanaActividad;
import usuario.VentanaEditarUsuario;
import usuario.VentanaUsuario;

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
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class VentanaRegistrarFormulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreFormulario;
	private JTextField txtResumen;
	public JFrame frame;
	private JTextField txtNombreDeFormulario;
	private JTextField txtDescripcinDeFormulario;
	public static JLabel lblNombreUsuario;
	private JLabel lblIconUser;
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
		
		lblNombreUsuario = new JLabel();
		lblNombreUsuario.setBounds(32, 0, 211, 28);
		contentPane.add(lblNombreUsuario);
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreUsuario.setForeground(Color.WHITE);
		
		VentanaRegistrarFormulario.lblNombreUsuario.setText(VentanaInicio.txtNombreUsuario.getText());

		JLabel lblIconUser;
		lblIconUser = new JLabel("");
		lblIconUser.setIcon(new ImageIcon(VentanaGeneral.class.getResource("/Imagenes/Usuario_gris.png")));
		lblIconUser.setBounds(10, 0, 37, 28);
		contentPane.add(lblIconUser);
		
	
		
		txtNombreFormulario = new JTextField();
		txtNombreFormulario.setToolTipText("Ingrese nombre de formulario");
		txtNombreFormulario.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombreFormulario.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtNombreFormulario.setColumns(10);
		txtNombreFormulario.setBounds(43, 68, 196, 29);
		panelFormulario.add(txtNombreFormulario);
		
		txtResumen = new JTextField();
		txtResumen.setToolTipText("Ingrese una descripic\u00F3n del formulario a crear");
		txtResumen.setHorizontalAlignment(SwingConstants.LEFT);
		txtResumen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtResumen.setColumns(10);
		txtResumen.setBounds(43, 160, 462, 140);
		panelFormulario.add(txtResumen);
		
		JButton btnCrearFormulario = new JButton("Crear formulario");
		btnCrearFormulario.setBackground(new Color(0, 102, 0));
		btnCrearFormulario.setForeground(new Color(255, 255, 255));
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
		btnCrearFormulario.setBounds(43, 346, 159, 29);
		panelFormulario.add(btnCrearFormulario);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 102, 0));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				dispose();
			}
		});
		btnVolver.setBounds(513, 351, 89, 23);
		panelFormulario.add(btnVolver);
		
		txtNombreDeFormulario = new JTextField();
		txtNombreDeFormulario.setText("Nombre de formulario");
		txtNombreDeFormulario.setForeground(Color.WHITE);
		txtNombreDeFormulario.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNombreDeFormulario.setEditable(false);
		txtNombreDeFormulario.setColumns(10);
		txtNombreDeFormulario.setBackground(new Color(0, 102, 0));
		txtNombreDeFormulario.setBounds(43, 55, 196, 14);
		panelFormulario.add(txtNombreDeFormulario);
		
		txtDescripcinDeFormulario = new JTextField();
		txtDescripcinDeFormulario.setText("Descripci\u00F3n de formulario");
		txtDescripcinDeFormulario.setForeground(Color.WHITE);
		txtDescripcinDeFormulario.setFont(new Font("Arial", Font.PLAIN, 11));
		txtDescripcinDeFormulario.setEditable(false);
		txtDescripcinDeFormulario.setColumns(10);
		txtDescripcinDeFormulario.setBackground(new Color(0, 102, 0));
		txtDescripcinDeFormulario.setBounds(43, 147, 462, 14);
		panelFormulario.add(txtDescripcinDeFormulario);
		
		JLabel lblNuevoFormulario = new JLabel("Nuevo Formulario");
		lblNuevoFormulario.setBounds(0, 11, 624, 23);
		panelFormulario.add(lblNuevoFormulario);
		lblNuevoFormulario.setOpaque(true);
		lblNuevoFormulario.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNuevoFormulario.setBackground(new Color(60, 179, 113));
		lblNuevoFormulario.setForeground(Color.WHITE);
		lblNuevoFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoFormulario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"),
						UIManager.getColor("Button.shadow"), null, null));
		panelUsuario.setBackground(new Color(0, 102, 0));
		panelUsuario.setBounds(0, 0, 624, 90);
		contentPane.add(panelUsuario);
		
		JLabel lblNombreSistema = new JLabel("");
		lblNombreSistema.setIcon(new ImageIcon(VentanaActividad.class.getResource("/Imagenes/iconoApp3.png")));
		lblNombreSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreSistema.setForeground(Color.WHITE);
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(259, 4, 98, 86);
		panelUsuario.add(lblNombreSistema);
		

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
		panelUsuario.add(btnSalir);

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
		panelUsuario.add(btnAyuda);
		
		JLabel lblPortada = new JLabel("");
		lblPortada.setIcon(new ImageIcon(VentanaRegistrarFormulario.class.getResource("/Imagenes/klipartz.com.png")));
		lblPortada.setBounds(-112, 0, 736, 90);
		panelUsuario.add(lblPortada);
	}
}
