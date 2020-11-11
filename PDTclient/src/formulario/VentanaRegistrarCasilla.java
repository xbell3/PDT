package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import com.cliente.EJBLocator;
import com.entidades.Formulario;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.FormulariosBeanRemote;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButtonMenuItem;

public class VentanaRegistrarCasilla extends JFrame {

	private JPanel contentPane;
	private JTextField txtParametro;
	private JTextField txtUnidadMedida;
	public JFrame frame;
	private JTextField txtDescripcion;
	private JTextField txtTipoDeValor;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaRegistrarCasilla(Usuario usuario) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelFormulario = new JPanel();
		panelFormulario.setBackground(UIManager.getColor("Button.disabledShadow"));
		panelFormulario.setBounds(0, 90, 784, 471);
		contentPane.add(panelFormulario);
		panelFormulario.setLayout(null);
		
		JLabel lblNuevaCasilla = new JLabel("Nueva Casilla");
		lblNuevaCasilla.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaCasilla.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNuevaCasilla.setBounds(200, 33, 174, 42);
		panelFormulario.add(lblNuevaCasilla);
		
		txtParametro = new JTextField();
		txtParametro.setText("Parametro");
		txtParametro.setHorizontalAlignment(SwingConstants.CENTER);
		txtParametro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtParametro.setColumns(10);
		txtParametro.setBounds(123, 164, 168, 42);
		panelFormulario.add(txtParametro);
		
		txtUnidadMedida = new JTextField();
		txtUnidadMedida.setText("Unidad de Medida");
		txtUnidadMedida.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnidadMedida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUnidadMedida.setColumns(10);
		txtUnidadMedida.setBounds(339, 164, 168, 42);
		panelFormulario.add(txtUnidadMedida);
		
		JButton btnCrearCasilla = new JButton("Crear Casilla");
		btnCrearCasilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormulariosBeanRemote formulariosBeanRemote;
				Formulario formulario = new Formulario ();
				formulario.setNombreFormulario(txtParametro.getText());
				formulario.setResumen(txtUnidadMedida.getText());
				
				try {

					formulariosBeanRemote = EJBLocator.getInstance().lookup(FormulariosBeanRemote.class);

					if (txtParametro.getText().isEmpty() || txtUnidadMedida.getText().isEmpty()
							) {
						JOptionPane.showMessageDialog(frame, "Debe completar todos los campos", "Campos Incompletos!",
								JOptionPane.INFORMATION_MESSAGE);

						return;

					} else if (formulariosBeanRemote.registro(txtParametro.getText())) {
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
		btnCrearCasilla.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCrearCasilla.setBounds(349, 336, 174, 42);
		panelFormulario.add(btnCrearCasilla);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				VentanaFormulario ventanaFormulario = new VentanaFormulario(usuario);
				ventanaFormulario.setVisible(true);
				ventanaFormulario.setLocation(400, 150);
				dispose();
			}
		});
		btnVolver.setBounds(580, 348, 89, 23);
		panelFormulario.add(btnVolver);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setText("Descripcion");
		txtDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(123, 226, 168, 42);
		panelFormulario.add(txtDescripcion);
		
		txtTipoDeValor = new JTextField();
		txtTipoDeValor.setText("Tipo de Valor");
		txtTipoDeValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtTipoDeValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTipoDeValor.setColumns(10);
		txtTipoDeValor.setBounds(455, 236, 168, 42);
		panelFormulario.add(txtTipoDeValor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Numero entero", "Numero decimal", "Texto", "Boolean"}));
		comboBox.setBounds(339, 238, 113, 22);
		panelFormulario.add(comboBox);
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"),

						UIManager.getColor("Button.shadow"), null, null));
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
	}
}
