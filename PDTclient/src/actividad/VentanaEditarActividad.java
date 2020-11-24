package actividad;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.EJBLocator;
import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.entidades.Actividad;
import com.entidades.Formulario;
import com.entidades.Rol;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.ActividadesBeanRemote;
import com.servicios.UsuariosBeanRemote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class VentanaEditarActividad extends JFrame {

	private JPanel contentPane;
	private JTextField txtDepartamento;
	private JTextField txtEstacionMuestreo;
	private JTextField txtMetodoMuestreo;
	private JTextField txtFechaFin;
	private JTextField txtFechaInicio;
	private JTextField txtFormulario;
	private JTextField txtUsuario;
	private JTextField txtRol;

	/**
	 * Create the frame.
	 */
	public VentanaEditarActividad(Usuario usuario, Actividad actividad) {

		setTitle("Actividad");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaActividad.class.getResource("/Imagenes/iAGRO_V04.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 600);
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
		btnNewButton.setBounds(528, 16, 88, 23);
		panelUsuario.add(btnNewButton);

		JLabel lblNombreSistema = new JLabel("Nombre App");
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(10, 16, 152, 34);
		panelUsuario.add(lblNombreSistema);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaActividad.class.getResource("/Imagenes/klipartz.com.png")));
		lblNewLabel_1.setBounds(-94, 0, 718, 90);
		panelUsuario.add(lblNewLabel_1);

		JPanel panelActividad = new JPanel();
		panelActividad.setBackground(new Color(204, 255, 204));
		panelActividad.setBounds(0, 89, 624, 472);
		contentPane.add(panelActividad);

		JLabel lblTituloFormulario = new JLabel("Actividad de campo");
		lblTituloFormulario.setBounds(10, 11, 171, 39);
		lblTituloFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloFormulario.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 346, 89, 23);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaRegistroActividad ventanaRegistroActividad = new VentanaRegistroActividad(usuario);
				ventanaRegistroActividad.setVisible(true);
				ventanaRegistroActividad.setLocation(400, 150);
				dispose();
			}
		});

		JLabel lblBienvenido = new JLabel(
				"Bienvenido al centro de actividad de campo. Para iniciar complete los campos de texto");
		lblBienvenido.setBounds(20, 57, 503, 39);
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelActividad.setLayout(null);
		panelActividad.add(lblTituloFormulario);
		panelActividad.add(lblBienvenido);
		panelActividad.add(btnVolver);

		JButton btnInicio = new JButton("Modificar");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarActividad(actividad);

			}
		});
		btnInicio.setBounds(417, 363, 157, 38);
		panelActividad.add(btnInicio);

		txtDepartamento = new JTextField();
	//	txtDepartamento.setText(actividad.getDepartamento());
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(488, 286, 86, 20);
		panelActividad.add(txtDepartamento);

		txtEstacionMuestreo = new JTextField();
	//	txtEstacionMuestreo.setText(actividad.getEstacionMuestreo());
		txtEstacionMuestreo.setColumns(10);
		txtEstacionMuestreo.setBounds(488, 255, 86, 20);
		panelActividad.add(txtEstacionMuestreo);

		txtMetodoMuestreo = new JTextField();
	//	txtMetodoMuestreo.setText(actividad.getMetodoMuestreo());
		txtMetodoMuestreo.setColumns(10);
		txtMetodoMuestreo.setBounds(488, 224, 86, 20);
		panelActividad.add(txtMetodoMuestreo);

		JLabel lblMetodoMuestreo = new JLabel("Metodo Muestreo");
		lblMetodoMuestreo.setBounds(386, 227, 84, 14);
		panelActividad.add(lblMetodoMuestreo);

		JLabel lblEstacionDeMuestreo = new JLabel("Estacion de muestreo");
		lblEstacionDeMuestreo.setBounds(367, 258, 103, 14);
		panelActividad.add(lblEstacionDeMuestreo);

		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(401, 289, 69, 14);
		panelActividad.add(lblDepartamento);

		txtFechaFin = new JTextField();
		txtFechaFin.setColumns(10);
		txtFechaFin.setBounds(421, 169, 86, 20);
		panelActividad.add(txtFechaFin);

		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		txtFechaInicio.setBounds(421, 131, 86, 20);
		panelActividad.add(txtFechaInicio);

		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		lblFechaInicio.setBounds(348, 134, 55, 14);
		panelActividad.add(lblFechaInicio);

		JLabel lblFechaFin = new JLabel("Fecha fin");
		lblFechaFin.setBounds(348, 172, 55, 14);
		panelActividad.add(lblFechaFin);

		txtFormulario = new JTextField();
		txtFormulario.setText(actividad.getNombreFormulario());
		txtFormulario.setEditable(false);
		txtFormulario.setColumns(10);
		txtFormulario.setBounds(177, 131, 86, 20);
		panelActividad.add(txtFormulario);

		txtUsuario = new JTextField();
		txtUsuario.setText(actividad.getNombreUsuario());
		txtUsuario.setEditable(false);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(177, 169, 86, 20);
		panelActividad.add(txtUsuario);

		txtRol = new JTextField();
		txtRol.setText(actividad.getRol());
		txtRol.setEditable(false);
		txtRol.setColumns(10);
		txtRol.setBounds(177, 207, 86, 20);
		panelActividad.add(txtRol);

		JLabel lblRol = new JLabel("Rol");
		lblRol.setBounds(123, 210, 36, 14);
		panelActividad.add(lblRol);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(123, 172, 36, 14);
		panelActividad.add(lblUsuario);

		JLabel lblNombreFormulario = new JLabel("Formulario");
		lblNombreFormulario.setBounds(109, 134, 50, 14);
		panelActividad.add(lblNombreFormulario);

	}

	private void modificarActividad(Actividad actividad)  {

		/*
		 * Se enlazan los parametros escritos en cada campo de texto con cada parametro
		 * de la entidad Usuario i.e: txtUsuario obtiene el texto del campo
		 * (getText();) y lo "setea" al campo nombreUsuario de la entidad Usuario
		 */
		ActividadesBeanRemote actividadesBeanRemote;
		actividad.setFechaInicio(txtFechaInicio.getText());
		actividad.setFechaFin(txtFechaFin.getText());
		actividad.setMetodoMuestreo(txtMetodoMuestreo.getText());
		actividad.setEstacionMuestreo(txtEstacionMuestreo.getText());
		actividad.setNombreFormulario(txtFormulario.getText());
		actividad.setNombreUsuario(txtUsuario.getText());
		actividad.setDepartamento(txtDepartamento.getText());
		actividad.setRol(txtRol.getText());
		try {
			actividadesBeanRemote = EJBLocator.getInstance().lookup(ActividadesBeanRemote.class);
			actividadesBeanRemote.actualizar(actividad);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiciosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
