package actividad;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.entidades.Usuario;

import formulario.VentanaRegistrarFormulario;
import usuario.VentanaUsuario;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Cursor;

public class VentanaActividad extends JFrame {

	//Declaramos los componentes o parametros.
	private JPanel contentPane;

	/*
	 * el parametro lblNombreUsuario se declara static de esta manera no tendremos
	 * que instanciar un objeto de la clase para invocarlo
	 */
	public static JLabel lblNombreUsuario;

	/*
	 * VentanaActividad es la ventana inicial del area Actividad de campo. En esta
	 * ventana se visualizaran 2 botones los cuales cada uno de ellos nos redirijen:
	 * - btnIniciar nos redirije al apartado donde el usuario elije un formulario y
	 * continua con el analisis de campo. - btnRegistro nos redirije al apartado de
	 * registros donde listaremos las actividades de campo segun los filtros que
	 * elijamos.
	 */
	public VentanaActividad(Usuario usuario) {

		setTitle("Actividad");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaActividad.class.getResource("/Imagenes/iAGRO_V04.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*El siguiente label lblNombreUsuario obtiene el nombre de usuario
		 * del usuario logeado.
		 * */
		lblNombreUsuario = new JLabel();
		lblNombreUsuario.setBounds(32, 0, 211, 28);
		contentPane.add(lblNombreUsuario);
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreUsuario.setForeground(Color.WHITE);
		VentanaActividad.lblNombreUsuario.setText(VentanaInicio.txtNombreUsuario.getText());

		JLabel lblIconUser;
		lblIconUser = new JLabel("");
		lblIconUser.setIcon(new ImageIcon(VentanaGeneral.class.getResource("/Imagenes/Usuario_gris.png")));
		lblIconUser.setBounds(10, 0, 37, 28);
		contentPane.add(lblIconUser);

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

		JPanel panelActividad = new JPanel();
		panelActividad.setLayout(null);
		panelActividad.setBackground(new Color(204, 255, 204));
		panelActividad.setBounds(0, 90, 624, 392);
		contentPane.add(panelActividad);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 102, 0));
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaGeneral ventanaGeneral = new VentanaGeneral(usuario);
				ventanaGeneral.setVisible(true);
				ventanaGeneral.setLocation(400, 150);
				dispose();
			}
		});

		JLabel lblBienvenido_1 = new JLabel("Bienvenido al centro de actividad de campo");
		lblBienvenido_1.setOpaque(true);
		lblBienvenido_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido_1.setForeground(Color.WHITE);
		lblBienvenido_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBienvenido_1.setBackground(new Color(0, 102, 0));
		lblBienvenido_1.setBounds(123, 75, 387, 39);
		panelActividad.add(lblBienvenido_1);
		btnVolver.setBounds(531, 358, 89, 23);
		panelActividad.add(btnVolver);

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaIniciarActividad ventanaIniciarActividad = new VentanaIniciarActividad(usuario);
				ventanaIniciarActividad.setVisible(true);
				ventanaIniciarActividad.setLocation(400, 150);
				dispose();
			}
		});
		btnIniciar.setForeground(Color.WHITE);
		btnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnIniciar.setBackground(new Color(0, 102, 0));
		btnIniciar.setBounds(10, 173, 300, 120);
		panelActividad.add(btnIniciar);

		JButton btnRegistro = new JButton("Analisis de muestreos");
		btnRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaRegistroActividad ventanaRegistroActividad = new VentanaRegistroActividad(usuario);
				ventanaRegistroActividad.setVisible(true);
				ventanaRegistroActividad.setLocation(400, 150);
				dispose();
			}
		});
		btnRegistro.setForeground(Color.WHITE);
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegistro.setBackground(new Color(0, 102, 0));
		btnRegistro.setBounds(320, 173, 300, 120);
		panelActividad.add(btnRegistro);

		JLabel lblActividadDeCampo = new JLabel("Actividad de campo");
		lblActividadDeCampo.setOpaque(true);
		lblActividadDeCampo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblActividadDeCampo.setHorizontalAlignment(SwingConstants.CENTER);
		lblActividadDeCampo.setForeground(Color.WHITE);
		lblActividadDeCampo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblActividadDeCampo.setBackground(new Color(60, 179, 113));
		lblActividadDeCampo.setBounds(0, 11, 624, 23);
		panelActividad.add(lblActividadDeCampo);

	}
}
