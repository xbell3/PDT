package formulario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.entidades.Usuario;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class VentanaFormulario extends JFrame {

	private JPanel contentPane;
	private JTable tableFormulario;
	private JTextField txtBusquedaFormulario;

	public VentanaFormulario(Usuario usuario) {
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
		
		JButton btnCrearFormulario = new JButton("Nuevo Formulario");
		btnCrearFormulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCrearFormulario.setBounds(44, 66, 123, 34);
		panelFormulario.add(btnCrearFormulario);
		
		tableFormulario = new JTable();
		tableFormulario.setBackground(UIManager.getColor("Button.light"));
		tableFormulario.setBounds(144, 104, 601, 356);
		panelFormulario.add(tableFormulario);
		
		JButton btnBuscarFormulario = new JButton("Buscar");
		btnBuscarFormulario.setBounds(514, 72, 72, 23);
		panelFormulario.add(btnBuscarFormulario);
		
		txtBusquedaFormulario = new JTextField();
		txtBusquedaFormulario.setText("...");
		txtBusquedaFormulario.setBounds(596, 73, 103, 20);
		panelFormulario.add(txtBusquedaFormulario);
		txtBusquedaFormulario.setColumns(10);
		
		
		JButton btnRefrescar = new JButton("");
		btnRefrescar.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\rsz_1refreshicon.png"));
		btnRefrescar.setBounds(709, 72, 20, 23);
		panelFormulario.add(btnRefrescar);
		
		JLabel lblTituloFormulario = new JLabel("Formularios");
		lblTituloFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloFormulario.setBounds(10, 11, 157, 39);
		panelFormulario.add(lblTituloFormulario);
		lblTituloFormulario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaGeneral ventanaGeneral = new VentanaGeneral(usuario);
				ventanaGeneral.setVisible(true);
				ventanaGeneral.setLocation(400, 150);
				dispose();
			}
		});
		btnVolver.setBounds(24, 425, 89, 23);
		panelFormulario.add(btnVolver);
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"), UIManager.getColor("Button.shadow"), null, null));
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
