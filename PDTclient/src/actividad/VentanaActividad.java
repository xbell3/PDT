package actividad;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.entidades.Usuario;
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

public class VentanaActividad extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public VentanaActividad(Usuario usuario) {
		
		setTitle("Actividad");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaActividad.class.getResource("/Imagenes/iAGRO_V04.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 520);
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
		panelActividad.setLayout(null);
		panelActividad.setBackground(new Color(204, 255, 204));
		panelActividad.setBounds(0, 90, 624, 392);
		contentPane.add(panelActividad);
		
		JLabel lblTituloFormulario = new JLabel("Actividad de campo");
		lblTituloFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloFormulario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloFormulario.setBounds(10, 11, 171, 39);
		panelActividad.add(lblTituloFormulario);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaGeneral ventanaGeneral = new VentanaGeneral(usuario);
				ventanaGeneral.setVisible(true);
				ventanaGeneral.setLocation(400, 150);
				dispose();
			}
		});
		btnVolver.setBounds(0, 358, 89, 23);
		panelActividad.add(btnVolver);
		
		JButton btnIniciar = new JButton("Iniciar");
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
		
		JLabel lblBienvenido = new JLabel("Bienvenido al centro de actividad de campo.");
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBienvenido.setBounds(20, 49, 391, 39);
		panelActividad.add(lblBienvenido);
		
	}
}
