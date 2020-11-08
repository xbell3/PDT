package formulario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.EJBLocator;
import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.entidades.Formulario;
import com.entidades.Usuario;
import com.servicios.FormulariosBeanRemote;
import com.servicios.UsuariosBeanRemote;

import usuario.VentanaEditarUsuario;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaFormulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusquedaFormulario;
	private JTable tableFormulario;

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
				VentanaRegistrarFormulario ventanaRegistrarFormulario = new VentanaRegistrarFormulario(usuario);
				ventanaRegistrarFormulario.setVisible(true);
				ventanaRegistrarFormulario.setLocation(400, 150);
				dispose();	
			}
		});
		btnCrearFormulario.setBounds(44, 66, 123, 34);
		panelFormulario.add(btnCrearFormulario);
		
		JButton btnListarFormulario = new JButton("Listar");
		btnListarFormulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarFormularios();
			}
		});
		btnListarFormulario.setBounds(514, 72, 72, 23);
		panelFormulario.add(btnListarFormulario);
		
		txtBusquedaFormulario = new JTextField();
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
		
		tableFormulario = new JTable();
		tableFormulario.setModel(new DefaultTableModel());
		tableFormulario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tableFormulario.getSelectedRow();
				String nombreFormulario = (String) tableFormulario.getModel().getValueAt(row, 0);
				Formulario formulario = new Formulario();
				formulario.setNombreFormulario(nombreFormulario);
				List<Formulario> formularios = new ArrayList<>();

				try {

					FormulariosBeanRemote formulariosBeanRemote = EJBLocator.getInstance().lookup(FormulariosBeanRemote.class);

					formularios = formulariosBeanRemote.obtenerPorNombreFormulario(nombreFormulario);
					formulario = formularios.get(0);

				} catch (NamingException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}

				VentanaEditarFormulario ventanaEditarFormulario = new VentanaEditarFormulario();
				ventanaEditarFormulario.setUndecorated(false);
				ventanaEditarFormulario.setVisible(true);
				dispose();

			
			}
		});
		tableFormulario.setBackground(SystemColor.controlHighlight);
		tableFormulario.setBounds(123, 111, 601, 356);
		panelFormulario.add(tableFormulario);
		
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
	
	private void cargarFormularios() {

		try {
			FormulariosBeanRemote formulariosBeanRemote = EJBLocator.getInstance().lookup(FormulariosBeanRemote.class);
			List<Formulario> formularios = new ArrayList<>();
			
			formularios = formulariosBeanRemote.obtenerTodos();

			String[] columnNames = {  "nombreFormulario", "resumen" };
			DefaultTableModel model = new DefaultTableModel();
			tableFormulario.setModel(model);

			model.setColumnIdentifiers(columnNames);
			for (Formulario formulario : formularios) {
				Object[] fila = new Object[2];
				fila[0] = formulario.getNombreFormulario();
				fila[1] = formulario.getResumen();
				model.addRow(fila);

			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
}
