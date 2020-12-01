package actividad;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.EJBLocator;
import com.cliente.VentanaInicio;
import com.entidades.Actividad;
import com.entidades.Formulario;
import com.entidades.Rol;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.ActividadesBeanRemote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Cursor;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class VentanaMuestreo extends JFrame {

	private JPanel contentPane;
	private JTextField txtDepartamento;
	private JTextField txtEstacionMuestreo;
	private JTextField txtMetodoMuestreo;
	private JTextField txtFechaFin;
	private JTextField txtFormulario;
	private JTextField txtUsuario;
	private JTextField txtRol;
	private JTextField txtFormulario_1;
	private JTextField txtUsuario_1;
	private JTextField txtRol_1;
	private JTextField txtFechaDeInicio;
	private JTextField txtFechaDeFin;
	private JTextField txtMtodoDeMuestreo;
	private JTextField txtFechadeMuestreo;
	private JTextField txtDepartamento_1;
	private JLabel lblNuevaCasilla;
	private JDateChooser dateChooserInicio = new JDateChooser();
	private JDateChooser dateChooserFin = new JDateChooser();


	/**
	 * Create the frame.
	 */
	public VentanaMuestreo(Usuario usuario, Formulario formulario) {

		setTitle("Actividad de campo");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaActividad.class.getResource("/Imagenes/iAGRO_V04.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds (100, 100, 640, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"),

				UIManager.getColor("Button.shadow"), null, null));
		panelUsuario.setBackground(new Color(0, 102, 0));
		panelUsuario.setBounds(0, 0, 624, 90);
		contentPane.add(panelUsuario);

		JLabel lblTipoUser = new JLabel("TipoUser");
		lblTipoUser.setBounds(453, 45, 46, 14);
		panelUsuario.add(lblTipoUser);

		JLabel lblNewLabel = new JLabel("(Nombre del usuario)");
		lblNewLabel.setBounds(400, 20, 118, 14);
		panelUsuario.add(lblNewLabel);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaInicio ventanaInicio = new VentanaInicio(usuario);
				ventanaInicio.setLocation(400, 150);
				ventanaInicio.setVisible(true);
				dispose();
			}
		});

		JButton btnNewButton = new JButton("Ayuda");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(new Color(0, 102, 0));
		btnNewButton.setBounds(528, 16, 88, 23);
		panelUsuario.add(btnNewButton);

		JLabel lblNombreSistema = new JLabel("ARCD");
		lblNombreSistema.setForeground(Color.WHITE);
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(10, 16, 152, 34);
		panelUsuario.add(lblNombreSistema);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaActividad.class.getResource("/Imagenes/klipartz.com.png")));
		lblNewLabel_1.setBounds(-94, 0, 718, 90);
		panelUsuario.add(lblNewLabel_1);

		JPanel panelActividad = new JPanel();
		panelActividad.setToolTipText("Ingrese departamento");
		panelActividad.setBackground(new Color(204, 255, 204));
		panelActividad.setBounds(0, 89, 624, 472);
		contentPane.add(panelActividad);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.setForeground(new Color(0, 102, 0));
		btnVolver.setBounds(510, 362, 89, 23);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaIniciarActividad ventanaIniciarActividad = new VentanaIniciarActividad(usuario);
				ventanaIniciarActividad.setVisible(true);
				ventanaIniciarActividad.setLocation(400, 150);
				dispose();
			}
		});
		panelActividad.setLayout(null);
				
				JLabel lblBienvenido_1 = new JLabel(" Para iniciar complete los campos de texto");
				lblBienvenido_1.setForeground(new Color(0, 0, 0));
				lblBienvenido_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblBienvenido_1.setBackground(new Color(0, 102, 0));
				lblBienvenido_1.setBounds(171, 101, 242, 31);
				panelActividad.add(lblBienvenido_1);
		
				JLabel lblBienvenido = new JLabel(
						"Bienvenido al centro de actividad de campo");
				lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
				lblBienvenido.setOpaque(true);
				lblBienvenido.setForeground(new Color(255, 255, 255));
				lblBienvenido.setBackground(new Color(0, 102, 0));
				lblBienvenido.setBounds(124, 62, 358, 39);
				lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 18));
				panelActividad.add(lblBienvenido);
		panelActividad.add(btnVolver);

		JButton btnInicio = new JButton("Iniciar");
		btnInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInicio.setBackground(new Color(0, 102, 0));
		btnInicio.setForeground(new Color(255, 255, 255));
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					crearActividad(usuario, formulario);
				} catch (ServiciosException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnInicio.setBounds(24, 347, 157, 38);
		panelActividad.add(btnInicio);

		txtDepartamento = new JTextField();
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(195, 233, 130, 20);
		panelActividad.add(txtDepartamento);

		txtEstacionMuestreo = new JTextField();
		txtEstacionMuestreo.setColumns(10);
		txtEstacionMuestreo.setBounds(358, 233, 130, 20);
		panelActividad.add(txtEstacionMuestreo);

		txtMetodoMuestreo = new JTextField();
		txtMetodoMuestreo.setToolTipText("Ingrese m\u00E9todo de muestreo");
		txtMetodoMuestreo.setColumns(10);
		txtMetodoMuestreo.setBounds(24, 232, 130, 20);
		panelActividad.add(txtMetodoMuestreo);

		txtFechaFin = new JTextField();
		txtFechaFin.setToolTipText("Ingrese fecha de fin");
		txtFechaFin.setColumns(10);
		txtFechaFin.setBounds(24, 278, 130, 20);
		panelActividad.add(txtFechaFin);

		txtFormulario = new JTextField();
		txtFormulario.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFormulario.setText(formulario.getNombreFormulario());
		txtFormulario.setEditable(false);
		txtFormulario.setColumns(10);
		txtFormulario.setBounds(20, 156, 134, 20);
		panelActividad.add(txtFormulario);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtUsuario.setText(usuario.getNombreUsuario());
		txtUsuario.setEditable(false);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(195, 156, 130, 20);
		panelActividad.add(txtUsuario);

		txtRol = new JTextField();
		txtRol.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtRol.setText(usuario.getRol().getNombreRol());
		txtRol.setEditable(false);
		txtRol.setColumns(10);
		txtRol.setBounds(358, 156, 130, 20);
		panelActividad.add(txtRol);
		
		txtFormulario_1 = new JTextField();
		txtFormulario_1.setText("Formulario");
		txtFormulario_1.setForeground(Color.WHITE);
		txtFormulario_1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtFormulario_1.setEditable(false);
		txtFormulario_1.setColumns(10);
		txtFormulario_1.setBackground(new Color(0, 102, 0));
		txtFormulario_1.setBounds(20, 143, 134, 14);
		panelActividad.add(txtFormulario_1);
		
		txtUsuario_1 = new JTextField();
		txtUsuario_1.setText("Usuario");
		txtUsuario_1.setForeground(Color.WHITE);
		txtUsuario_1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtUsuario_1.setEditable(false);
		txtUsuario_1.setColumns(10);
		txtUsuario_1.setBackground(new Color(0, 102, 0));
		txtUsuario_1.setBounds(195, 143, 130, 14);
		panelActividad.add(txtUsuario_1);
		
		txtRol_1 = new JTextField();
		txtRol_1.setText("Rol");
		txtRol_1.setForeground(Color.WHITE);
		txtRol_1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtRol_1.setEditable(false);
		txtRol_1.setColumns(10);
		txtRol_1.setBackground(new Color(0, 102, 0));
		txtRol_1.setBounds(358, 142, 130, 14);
		panelActividad.add(txtRol_1);
		
		txtFechaDeInicio = new JTextField();
		txtFechaDeInicio.setText("Fecha de inicio");
		txtFechaDeInicio.setForeground(Color.WHITE);
		txtFechaDeInicio.setFont(new Font("Arial", Font.PLAIN, 11));
		txtFechaDeInicio.setEditable(false);
		txtFechaDeInicio.setColumns(10);
		txtFechaDeInicio.setBackground(new Color(0, 153, 0));
		txtFechaDeInicio.setBounds(195, 265, 130, 14);
		panelActividad.add(txtFechaDeInicio);
		
		txtFechaDeFin = new JTextField();
		txtFechaDeFin.setText("Fecha de fin");
		txtFechaDeFin.setForeground(Color.WHITE);
		txtFechaDeFin.setFont(new Font("Arial", Font.PLAIN, 11));
		txtFechaDeFin.setEditable(false);
		txtFechaDeFin.setColumns(10);
		txtFechaDeFin.setBackground(new Color(0, 153, 0));
		txtFechaDeFin.setBounds(24, 264, 130, 14);
		panelActividad.add(txtFechaDeFin);
		
		txtMtodoDeMuestreo = new JTextField();
		txtMtodoDeMuestreo.setText("M\u00E9todo de muestreo");
		txtMtodoDeMuestreo.setForeground(Color.WHITE);
		txtMtodoDeMuestreo.setFont(new Font("Arial", Font.PLAIN, 11));
		txtMtodoDeMuestreo.setEditable(false);
		txtMtodoDeMuestreo.setColumns(10);
		txtMtodoDeMuestreo.setBackground(new Color(0, 153, 0));
		txtMtodoDeMuestreo.setBounds(24, 219, 130, 14);
		panelActividad.add(txtMtodoDeMuestreo);
		
		txtFechadeMuestreo = new JTextField();
		txtFechadeMuestreo.setToolTipText("Ingrese fecha de muestreo");
		txtFechadeMuestreo.setText("Estaci\u00F3n de muestreo");
		txtFechadeMuestreo.setForeground(Color.WHITE);
		txtFechadeMuestreo.setFont(new Font("Arial", Font.PLAIN, 11));
		txtFechadeMuestreo.setEditable(false);
		txtFechadeMuestreo.setColumns(10);
		txtFechadeMuestreo.setBackground(new Color(0, 153, 0));
		txtFechadeMuestreo.setBounds(358, 220, 130, 14);
		panelActividad.add(txtFechadeMuestreo);
		
		txtDepartamento_1 = new JTextField();
		txtDepartamento_1.setText("Departamento");
		txtDepartamento_1.setForeground(Color.WHITE);
		txtDepartamento_1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtDepartamento_1.setEditable(false);
		txtDepartamento_1.setColumns(10);
		txtDepartamento_1.setBackground(new Color(0, 153, 0));
		txtDepartamento_1.setBounds(195, 219, 130, 14);
		panelActividad.add(txtDepartamento_1);
		
		lblNuevaCasilla = new JLabel("Actividad de campo");
		lblNuevaCasilla.setOpaque(true);
		lblNuevaCasilla.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNuevaCasilla.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaCasilla.setForeground(Color.WHITE);
		lblNuevaCasilla.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNuevaCasilla.setBackground(new Color(60, 179, 113));
		lblNuevaCasilla.setBounds(0, 11, 624, 23);
		panelActividad.add(lblNuevaCasilla);
		
		dateChooserInicio.setBounds(195, 291, 72, 20);
		panelActividad.add(dateChooserInicio);
		
		dateChooserFin.setBounds(357, 291, 72, 20);
		panelActividad.add(dateChooserFin);

	}

	private void crearActividad(Usuario usuario, Formulario formulario) throws ServiciosException {

		/*
		 * Se enlazan los parametros escritos en cada campo de texto con cada parametro
		 * de la entidad Usuario i.e: txtUsuario obtiene el texto del campo
		 * (getText();) y lo "setea" al campo nombreUsuario de la entidad Usuario
		 */
		ActividadesBeanRemote actividadesBeanRemote;
		Actividad actividad = new Actividad();
		Rol rol = new Rol();
		actividad.setFechaInicio((GregorianCalendar)dateChooserInicio.getCalendar());
		actividad.setFechaFin((GregorianCalendar) dateChooserFin.getCalendar());
		actividad.setMetodoMuestreo(txtMetodoMuestreo.getText());
		actividad.setEstacionMuestreo(txtEstacionMuestreo.getText());
		actividad.setNombreFormulario(txtFormulario.getText());
		actividad.setNombreUsuario(txtUsuario.getText());
		actividad.setRol(rol);
		rol.setNombreRol(txtRol.getText());
		actividad.setDepartamento(txtDepartamento.getText());
		try {
			actividadesBeanRemote = EJBLocator.getInstance().lookup(ActividadesBeanRemote.class);
			actividadesBeanRemote.crear(actividad);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
