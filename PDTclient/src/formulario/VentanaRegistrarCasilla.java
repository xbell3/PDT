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
import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.entidades.Casilla;
import com.entidades.Formulario;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.CasillasBeanRemote;
import com.servicios.FormulariosBeanRemote;

import actividad.VentanaActividad;
import usuario.VentanaUsuario;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Cursor;

public class VentanaRegistrarCasilla extends JFrame {

	private JPanel contentPane;
	private JTextField txtParametro;
	private JTextField txtUnidadMedida;
	public JFrame frame;
	private JTextField txtDescripcion;
	private JTextField txtTipoDeValor;
	private JTextField txtNombreFormulario;
	private JTextField txtParmetro;
	private JTextField txtUnidadDeMedida;
	private JTextField txtDescripcinDeCasilla;
	private JTextField txtTipoDeValor_1;
	public static JLabel lblNombreUsuario;
	/**
	 * Create the frame.
	 */
	public VentanaRegistrarCasilla(Usuario usuario, Formulario formulario) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegistrarCasilla.class.getResource("/Imagenes/iAGRO_V04.png")));
		setTitle("Nueva casilla");
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
		
		VentanaRegistrarCasilla.lblNombreUsuario.setText(VentanaInicio.txtNombreUsuario.getText());

		JLabel lblIconUser;
		lblIconUser = new JLabel("");
		lblIconUser.setIcon(new ImageIcon(VentanaGeneral.class.getResource("/Imagenes/Usuario_gris.png")));
		lblIconUser.setBounds(10, 0, 37, 28);
		contentPane.add(lblIconUser);
		
		txtParametro = new JTextField();
		txtParametro.setToolTipText("Ingrese par\u00E1metro");
		txtParametro.setHorizontalAlignment(SwingConstants.CENTER);
		txtParametro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtParametro.setColumns(10);
		txtParametro.setBounds(10, 85, 196, 26);
		panelFormulario.add(txtParametro);
		
		txtUnidadMedida = new JTextField();
		txtUnidadMedida.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnidadMedida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUnidadMedida.setColumns(10);
		txtUnidadMedida.setBounds(257, 85, 196, 26);
		panelFormulario.add(txtUnidadMedida);
		
		JButton btnCrearCasilla = new JButton("Crear Casilla");
		btnCrearCasilla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearCasilla.setBackground(new Color(0, 102, 0));
		btnCrearCasilla.setForeground(new Color(255, 255, 255));
		btnCrearCasilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearCasilla(formulario);
				
			}
		});
		btnCrearCasilla.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCrearCasilla.setBounds(20, 341, 174, 40);
		panelFormulario.add(btnCrearCasilla);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.setForeground(new Color(51, 102, 0));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				dispose();
			}
		});
		btnVolver.setBounds(488, 352, 89, 23);
		panelFormulario.add(btnVolver);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(10, 218, 377, 42);
		panelFormulario.add(txtDescripcion);
		
		txtTipoDeValor = new JTextField();
		txtTipoDeValor.setText("Tipo de Valor");
		txtTipoDeValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtTipoDeValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTipoDeValor.setColumns(10);
		txtTipoDeValor.setBounds(227, 283, 168, 42);
		panelFormulario.add(txtTipoDeValor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 102, 0));
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Numero entero", "Numero decimal", "Texto", "Boolean"}));
		comboBox.setBounds(10, 154, 196, 22);
		panelFormulario.add(comboBox);
		
		txtNombreFormulario = new JTextField();
		txtNombreFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreFormulario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNombreFormulario.setText(formulario.getNombreFormulario());
		txtNombreFormulario.setColumns(10);
		txtNombreFormulario.setEditable(false);
		txtNombreFormulario.setBounds(10, 283, 196, 42);
		panelFormulario.add(txtNombreFormulario);
		
		txtParmetro = new JTextField();
		txtParmetro.setText("Par\u00E1metro");
		txtParmetro.setForeground(Color.WHITE);
		txtParmetro.setFont(new Font("Arial", Font.PLAIN, 11));
		txtParmetro.setEditable(false);
		txtParmetro.setColumns(10);
		txtParmetro.setBackground(new Color(0, 102, 0));
		txtParmetro.setBounds(10, 73, 196, 14);
		panelFormulario.add(txtParmetro);
		
		txtUnidadDeMedida = new JTextField();
		txtUnidadDeMedida.setText("Unidad de medida");
		txtUnidadDeMedida.setForeground(Color.WHITE);
		txtUnidadDeMedida.setFont(new Font("Arial", Font.PLAIN, 11));
		txtUnidadDeMedida.setEditable(false);
		txtUnidadDeMedida.setColumns(10);
		txtUnidadDeMedida.setBackground(new Color(0, 102, 0));
		txtUnidadDeMedida.setBounds(257, 73, 196, 14);
		panelFormulario.add(txtUnidadDeMedida);
		
		txtDescripcinDeCasilla = new JTextField();
		txtDescripcinDeCasilla.setText("Descripci\u00F3n de casilla");
		txtDescripcinDeCasilla.setForeground(Color.WHITE);
		txtDescripcinDeCasilla.setFont(new Font("Arial", Font.PLAIN, 11));
		txtDescripcinDeCasilla.setEditable(false);
		txtDescripcinDeCasilla.setColumns(10);
		txtDescripcinDeCasilla.setBackground(new Color(0, 102, 0));
		txtDescripcinDeCasilla.setBounds(10, 205, 377, 14);
		panelFormulario.add(txtDescripcinDeCasilla);
		
		txtTipoDeValor_1 = new JTextField();
		txtTipoDeValor_1.setText("Tipo de valor");
		txtTipoDeValor_1.setForeground(Color.WHITE);
		txtTipoDeValor_1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtTipoDeValor_1.setEditable(false);
		txtTipoDeValor_1.setColumns(10);
		txtTipoDeValor_1.setBackground(new Color(0, 102, 0));
		txtTipoDeValor_1.setBounds(10, 140, 196, 14);
		panelFormulario.add(txtTipoDeValor_1);
		
		JLabel lblNuevaCasilla_1 = new JLabel("Nueva Casilla");
		lblNuevaCasilla_1.setOpaque(true);
		lblNuevaCasilla_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNuevaCasilla_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaCasilla_1.setForeground(Color.WHITE);
		lblNuevaCasilla_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNuevaCasilla_1.setBackground(new Color(60, 179, 113));
		lblNuevaCasilla_1.setBounds(0, 11, 624, 23);
		panelFormulario.add(lblNuevaCasilla_1);
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"),

						UIManager.getColor("Button.shadow"), null, null));
		panelUsuario.setBackground(new Color(0, 102, 0));
		panelUsuario.setBounds(0, 0, 624, 90);
		contentPane.add(panelUsuario);
		
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
		
		JLabel lblNombreSistema = new JLabel("");
		lblNombreSistema.setIcon(new ImageIcon(VentanaActividad.class.getResource("/Imagenes/iconoApp3.png")));
		lblNombreSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreSistema.setForeground(Color.WHITE);
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(259, 4, 98, 86);
		panelUsuario.add(lblNombreSistema);
		
		JLabel lblPortada = new JLabel("");
		lblPortada.setIcon(new ImageIcon(VentanaRegistrarFormulario.class.getResource("/Imagenes/klipartz.com.png")));
		lblPortada.setBounds(-112, 0, 736, 90);
		panelUsuario.add(lblPortada);
	}
	private void crearCasilla(Formulario formulario) {

		CasillasBeanRemote casillasBeanRemote;
		Casilla casilla = new Casilla ();
		
		casilla.setParametro(txtParametro.getText());
		casilla.setDescripcion(txtDescripcion.getText());
		casilla.setTipoUnidad(txtTipoDeValor.getText());
		casilla.setUnidadMedida(txtUnidadMedida.getText());
		try {

			casillasBeanRemote = EJBLocator.getInstance().lookup(CasillasBeanRemote.class);

			if (txtParametro.getText().isEmpty() || txtUnidadMedida.getText().isEmpty()
					) {
				JOptionPane.showMessageDialog(frame, "Debe completar todos los campos", "Campos Incompletos!",
						JOptionPane.INFORMATION_MESSAGE);

				return;

			}else {
				casillasBeanRemote.crear(casilla, txtNombreFormulario.getText());

				JOptionPane.showMessageDialog(frame, "La casilla ha sido creada con éxito.",
						"Casilla Registrado!", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}

		
		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (ServiciosException e1) {
			e1.printStackTrace();
		}
	
	}
}
