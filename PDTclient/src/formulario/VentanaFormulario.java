package formulario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.EJBLocator;
import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.entidades.Casilla;
import com.entidades.Formulario;
import com.entidades.Usuario;
import com.servicios.CasillasBeanRemote;
import com.servicios.FormulariosBeanRemote;
import com.servicios.UsuariosBeanRemote;

import actividad.VentanaActividad;
import usuario.VentanaEditarUsuario;
import usuario.VentanaUsuario;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.JTextPane;

public class VentanaFormulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusqueda;
	private JTable tableFormulario;
	public static JLabel lblNombreUsuario;

	public VentanaFormulario(Usuario usuario) {
		setTitle("Crear Formulario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaFormulario.class.getResource("/Imagenes/iAGRO_V04.png")));
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
		
		VentanaFormulario.lblNombreUsuario.setText(VentanaInicio.txtNombreUsuario.getText());

		JLabel lblIconUser;
		lblIconUser = new JLabel("");
		lblIconUser.setIcon(new ImageIcon(VentanaGeneral.class.getResource("/Imagenes/Usuario_gris.png")));
		lblIconUser.setBounds(10, 0, 37, 28);
		contentPane.add(lblIconUser);
		
		JButton btnordenarAsc_ = new JButton("");
		btnordenarAsc_.setBounds(10, 86, 21, 14);
		panelFormulario.add(btnordenarAsc_);
		btnordenarAsc_.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/Asc2.png")));
		btnordenarAsc_.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnordenarAsc_.setForeground(new Color(0, 128, 0));
		btnordenarAsc_.setToolTipText("");
		
		btnordenarAsc_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cargarFormulariosAsc();
			}
		});
		
		
		
		JButton btnordenarDesc = new JButton("");
		btnordenarDesc.setBounds(30, 86, 21, 14);
		panelFormulario.add(btnordenarDesc);
		btnordenarDesc.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/Desc2.png")));
		btnordenarDesc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnordenarDesc.setForeground(new Color(0, 128, 0));
		btnordenarDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cargarFormulariosDes();
			}
		});
		
		JButton btnCrearFormulario = new JButton("Crear formulario");
		btnCrearFormulario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearFormulario.setBackground(new Color(0, 102, 0));
		btnCrearFormulario.setForeground(new Color(255, 255, 255));
		btnCrearFormulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaRegistrarFormulario ventanaRegistrarFormulario = new VentanaRegistrarFormulario(usuario);
				ventanaRegistrarFormulario.setVisible(true);
				ventanaRegistrarFormulario.setLocation(400, 150);
			}
		});
		btnCrearFormulario.setBounds(20, 363, 149, 23);
		panelFormulario.add(btnCrearFormulario);
		
		JButton btnListarFormulario = new JButton("Listar");
		btnListarFormulario.setForeground(new Color(0, 102, 0));
		btnListarFormulario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListarFormulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				/*
				 * Filtros del comboBox, evalua el item elegido, y elije la funcion de listar
				 * segun se desee.
				 */
				cargarFormularios();
//				if (comboFiltro.getSelectedItem() == "Formularios") {
//					cargarFormularios();
//				} else if (comboFiltro.getSelectedItem() == "Casillas") {
//					cargarCasillas();
//			
//			}
			
			}
		});
		btnListarFormulario.setBounds(396, 65, 72, 23);
		panelFormulario.add(btnListarFormulario);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(478, 66, 103, 20);
		panelFormulario.add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
		
		JButton btnRefrescar = new JButton("");
		btnRefrescar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefrescar.setIcon(new ImageIcon(VentanaFormulario.class.getResource("/Imagenes/refrescar4.png")));
		btnRefrescar.setBounds(591, 65, 20, 23);
		panelFormulario.add(btnRefrescar);
		
		JLabel lblTituloFormulario = new JLabel("    Formularios");
		lblTituloFormulario.setIcon(new ImageIcon(VentanaFormulario.class.getResource("/Imagenes/formulario_v2.png")));
		lblTituloFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloFormulario.setBounds(10, 11, 198, 77);
		panelFormulario.add(lblTituloFormulario);
		lblTituloFormulario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.setForeground(new Color(0, 102, 0));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaGeneral ventanaGeneral = new VentanaGeneral(usuario);
				ventanaGeneral.setVisible(true);
				ventanaGeneral.setLocation(400, 150);
				dispose();
			}
		});
		btnVolver.setBounds(522, 363, 89, 23);
		panelFormulario.add(btnVolver);
		
		tableFormulario = new JTable();
		tableFormulario.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 0), null, null, null));
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
					ex.printStackTrace();
				}
					VentanaEditarFormulario ventanaEditarFormulario = new VentanaEditarFormulario(usuario, formulario);
					ventanaEditarFormulario.setUndecorated(false);
					ventanaEditarFormulario.setVisible(true);
				
				
			}
		});	
		tableFormulario.setBackground(SystemColor.controlHighlight);
		tableFormulario.setBounds(10, 123, 604, 229);
		
		
		panelFormulario.add(tableFormulario);
		
		JTextPane txtpnNombreDeFormulario = new JTextPane();
		txtpnNombreDeFormulario.setText("Nombre de formulario        \t\t\t   | Descripci\u00F3n");
		txtpnNombreDeFormulario.setForeground(Color.WHITE);
		txtpnNombreDeFormulario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnNombreDeFormulario.setEditable(false);
		txtpnNombreDeFormulario.setBackground(new Color(34, 139, 34));
		txtpnNombreDeFormulario.setBounds(10, 101, 604, 22);
		panelFormulario.add(txtpnNombreDeFormulario);
		
//		JButton btnCrearCasilla = new JButton("Crear Casilla");
//		btnCrearCasilla.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//				VentanaRegistrarCasilla ventanaRegistrarCasilla = new VentanaRegistrarCasilla(usuario, formulario);
//				ventanaRegistrarCasilla.setUndecorated(false);
//				ventanaRegistrarCasilla.setVisible(true);
//			}
//		});
//		btnCrearCasilla.setToolTipText("Debe seleccionar un formulario para asignar Casilla.");
//		btnCrearCasilla.setBounds(143, 59, 132, 34);
//		panelFormulario.add(btnCrearCasilla);
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"), UIManager.getColor("Button.shadow"), null, null));
		panelUsuario.setBackground(new Color(0, 102, 0));
		panelUsuario.setBounds(0, 0, 624, 89);
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
	private void cargarCasillas() {
		try {
			CasillasBeanRemote casillasBeanRemote = EJBLocator.getInstance().lookup(CasillasBeanRemote.class);
			List<Casilla> casillas = new ArrayList<>();
			DefaultTableModel model = new DefaultTableModel();
	
			casillas = casillasBeanRemote.obtenerTodos(txtBusqueda.getText() + "%");

			String[] columnNames = {  "parametro", "descripcion", "unidadMedida", "tipoUnidad" };
					
			
			tableFormulario.setModel(model);
			
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
	
	private void cargarFormularios() {
		try {
			FormulariosBeanRemote formulariosBeanRemote = EJBLocator.getInstance().lookup(FormulariosBeanRemote.class);
			List<Formulario> formularios = new ArrayList<>();
	
			formularios = formulariosBeanRemote.obtenerTodos(txtBusqueda.getText() + "%");

			String[] columnNames = {"nombreFormulario","resumen"};
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
	
	private void cargarFormulariosDes() {
		try {
			FormulariosBeanRemote formulariosBeanRemote = EJBLocator.getInstance().lookup(FormulariosBeanRemote.class);
			List<Formulario> formularios = new ArrayList<>();
	
			formularios = formulariosBeanRemote.obtenerTodosDesc();

			String[] columnNames = {"nombreFormulario","resumen"};
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
	
	private void cargarFormulariosAsc() {
		try {
			FormulariosBeanRemote formulariosBeanRemote = EJBLocator.getInstance().lookup(FormulariosBeanRemote.class);
			List<Formulario> formularios = new ArrayList<>();
	
			formularios = formulariosBeanRemote.obtenerTodosAsc();

			String[] columnNames = {"nombreFormulario","resumen"};
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
