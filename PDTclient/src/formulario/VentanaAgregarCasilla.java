package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.cliente.EJBLocator;
import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.entidades.Casilla;
import com.entidades.Formulario;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.CasillasBeanRemote;
import com.servicios.FormulariosBeanRemote;
import com.servicios.UsuariosBeanRemote;

import usuario.VentanaEditarUsuario;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaAgregarCasilla extends JFrame {

	private JPanel contentPane;
	private JTable tableCasilla;
	private JTextField txtBusqueda;

	public VentanaAgregarCasilla(Usuario usuario, Formulario formulario) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		btnSalir.setBounds(714, 16, 60, 23);
		panelUsuario.add(btnSalir);
		
		JButton btnNewButton = new JButton("Ayuda");
		btnNewButton.setBounds(616, 16, 88, 23);
		panelUsuario.add(btnNewButton);
		
		JLabel lblNombreSistema = new JLabel("Nombre App");
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(10, 16, 152, 34);
		panelUsuario.add(lblNombreSistema);
		
		JPanel panelCasilla = new JPanel();
		panelCasilla.setLayout(null);
		panelCasilla.setBackground(Color.WHITE);
		panelCasilla.setBounds(0, 90, 784, 471);
		contentPane.add(panelCasilla);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaFormulario ventanaFormulario = new VentanaFormulario(usuario);
				ventanaFormulario.setVisible(true);
				ventanaFormulario.setLocation(400, 150);
				dispose();
			}
		});
		btnVolver.setBounds(627, 437, 89, 23);
		panelCasilla.add(btnVolver);
		
		tableCasilla = new JTable();
		tableCasilla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tableCasilla.getSelectedRow();
				String parametro = (String) tableCasilla.getModel().getValueAt(row, 0);
				Casilla casilla = new Casilla();
				casilla.setParametro(parametro);
				
				try {

					FormulariosBeanRemote formulariosBeanRemote = EJBLocator.getInstance().lookup(FormulariosBeanRemote.class);

					formulariosBeanRemote.asignarCasilla(formulario.getNombreFormulario(), parametro);

				} catch (NamingException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		tableCasilla.setBackground(SystemColor.controlHighlight);
		tableCasilla.setBounds(55, 70, 601, 356);
		panelCasilla.add(tableCasilla);
		
		JButton btnListarCasilla = new JButton("Listar");
		btnListarCasilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarCasillas();
			}
		});
		btnListarCasilla.setBounds(466, 37, 72, 23);
		panelCasilla.add(btnListarCasilla);
		
		JLabel lblCasillas = new JLabel("Casillas");
		lblCasillas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCasillas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCasillas.setBounds(95, 18, 226, 42);
		panelCasilla.add(lblCasillas);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setColumns(10);
		txtBusqueda.setBounds(566, 38, 103, 20);
		panelCasilla.add(txtBusqueda);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {}
		});
		btnAgregar.setBounds(499, 437, 89, 23);
		panelCasilla.add(btnAgregar);
		
		
	}
	private void agregarCasilla(String nombreFormulario, Long idCasilla) throws ServiciosException {
		try {
			FormulariosBeanRemote formulariosBeanRemote = EJBLocator.getInstance().lookup(FormulariosBeanRemote.class);
			CasillasBeanRemote casillasBeanRemote = EJBLocator.getInstance().lookup(CasillasBeanRemote.class);			
//			formulariosBeanRemote.asignarCasilla(nombreFormulario, idCasilla);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void cargarCasillas() {
		try {
			CasillasBeanRemote casillasBeanRemote = EJBLocator.getInstance().lookup(CasillasBeanRemote.class);
			List<Casilla> casillas = new ArrayList<>();
	
			casillas = casillasBeanRemote.obtenerTodos(txtBusqueda.getText() + "%");

			String[] columnNames = { "parametro", "descripcion", "unidadMedida", "tipoUnidad" };
			DefaultTableModel model = new DefaultTableModel();
			tableCasilla.setModel(model);

			model.setColumnIdentifiers(columnNames);
			for (Casilla casilla : casillas) {
				Object[] fila = new Object[4];
				fila[0] = casilla.getParametro();
				fila[1] = casilla.getDescripcion();
				fila[2] = casilla.getUnidadMedida();
				fila[3] = casilla.getTipoUnidad();
				model.addRow(fila);
			}		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}