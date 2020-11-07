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

public class VentanaActividad extends JFrame {

	private JPanel contentPane;
	private JTable tableActividad;
	private JTextField txtBusquedaActividad;
	/**
	 * Create the frame.
	 */
	public VentanaActividad(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaInicio ventanaInicio = new VentanaInicio(usuario);
				ventanaInicio.setLocation(400, 150);
				ventanaInicio.setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton = new JButton("Ayuda");
		btnNewButton.setBounds(616, 16, 88, 23);
		panelUsuario.add(btnNewButton);
		
		JLabel lblNombreSistema = new JLabel("Nombre App");
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(10, 16, 152, 34);
		panelUsuario.add(lblNombreSistema);
		
		JPanel panelActividad = new JPanel();
		panelActividad.setLayout(null);
		panelActividad.setBackground(Color.WHITE);
		panelActividad.setBounds(0, 90, 784, 471);
		contentPane.add(panelActividad);
		
		tableActividad = new JTable();
		tableActividad.setBackground(SystemColor.controlHighlight);
		tableActividad.setBounds(144, 104, 601, 356);
		panelActividad.add(tableActividad);
		
		JButton btnBuscarActividad = new JButton("Buscar");
		btnBuscarActividad.setBounds(514, 72, 72, 23);
		panelActividad.add(btnBuscarActividad);
		
		txtBusquedaActividad = new JTextField();
		txtBusquedaActividad.setColumns(10);
		txtBusquedaActividad.setBounds(596, 73, 103, 20);
		panelActividad.add(txtBusquedaActividad);
		
		JButton btnRefrescar = new JButton("R");
		btnRefrescar.setBounds(709, 72, 31, 23);
		panelActividad.add(btnRefrescar);
		
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
	}
}
