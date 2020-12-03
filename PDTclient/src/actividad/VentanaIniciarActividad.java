package actividad;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.EJBLocator;
import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.entidades.Formulario;
import com.entidades.Usuario;
import com.servicios.FormulariosBeanRemote;

import formulario.VentanaEditarFormulario;
import formulario.VentanaRegistrarFormulario;
import usuario.VentanaUsuario;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Cursor;
import javax.swing.JTextPane;

public class VentanaIniciarActividad extends JFrame {
	
	//Declaramos los componentes o parametros.
	private JPanel contentPane;
	private JTable tableActividad;
	private JTextField txtBusquedaActividad;
	public static JLabel lblNombreUsuario;
	/**
	 * VentanaIniciarActividad es la que nos brinda la funcion de
	 * realizar una actividad de campo segun el formulario que elijamos.
	 */
	public VentanaIniciarActividad(Usuario usuario) {
		setTitle("Actividad de campo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaActividad.class.getResource("/Imagenes/iAGRO_V04.png")));
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
		VentanaIniciarActividad.lblNombreUsuario.setText(VentanaInicio.txtNombreUsuario.getText());

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
		/*tableActividad es la tabla donde los formularios seran cargados 
		 * con el metodo cargarFormulario() */
		tableActividad = new JTable();
		tableActividad.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 0), null, null, null));
		tableActividad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tableActividad.getSelectedRow();
				String nombreFormulario = (String) tableActividad.getModel().getValueAt(row, 0);
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
					VentanaMuestreo ventanaMuestreo = new VentanaMuestreo(usuario, formulario);
					ventanaMuestreo.setUndecorated(false);
					ventanaMuestreo.setVisible(true);
					dispose();
				
			
			}
		});
		tableActividad.setBackground(SystemColor.controlHighlight);
		tableActividad.setBounds(10, 119, 604, 233);
		panelActividad.add(tableActividad);
		
		JButton btnBuscarActividad = new JButton("Buscar");
		btnBuscarActividad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarActividad.setForeground(new Color(0, 102, 0));
		btnBuscarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarFormularios();
			}
		});
		btnBuscarActividad.setBounds(373, 70, 84, 23);
		panelActividad.add(btnBuscarActividad);
		
		/*txtBusquedaActividad es el campo de texto 
		 * en donde escribiremos el nombre de formulario, es un pequeño
		 * filtro que añadimos para encontrar mas facilmente el formulario 
		 * que el usuario va a elegir.*/
		txtBusquedaActividad = new JTextField();
		txtBusquedaActividad.setColumns(10);
		txtBusquedaActividad.setBounds(467, 71, 103, 20);
		panelActividad.add(txtBusquedaActividad);
		
		JButton btnRefrescar = new JButton("");
		btnRefrescar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefrescar.setIcon(new ImageIcon(VentanaIniciarActividad.class.getResource("/Imagenes/refrescar4.png")));
		btnRefrescar.setBounds(580, 70, 31, 23);
		panelActividad.add(btnRefrescar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.setForeground(new Color(0, 102, 0));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaActividad ventanaActividad = new VentanaActividad(usuario);
				ventanaActividad.setVisible(true);
				ventanaActividad.setLocation(400, 150);
				dispose();
			}
		});
		btnVolver.setBounds(525, 363, 89, 23);
		panelActividad.add(btnVolver);
		
		JLabel lblSeleccioneUnFormulario = new JLabel("Seleccione un formulario para iniciar");
		lblSeleccioneUnFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneUnFormulario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeleccioneUnFormulario.setBounds(20, 54, 274, 39);
		panelActividad.add(lblSeleccioneUnFormulario);
		
		JLabel lblNuevaCasilla = new JLabel("Actividad de campo");
		lblNuevaCasilla.setOpaque(true);
		lblNuevaCasilla.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNuevaCasilla.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaCasilla.setForeground(Color.WHITE);
		lblNuevaCasilla.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNuevaCasilla.setBackground(new Color(60, 179, 113));
		lblNuevaCasilla.setBounds(0, 11, 624, 23);
		panelActividad.add(lblNuevaCasilla);
		
		JTextPane txtpnNombreDeFormulario = new JTextPane();
		txtpnNombreDeFormulario.setText("Nombre de formulario        \t\t\t   | Descripci\u00F3n");
		txtpnNombreDeFormulario.setForeground(Color.WHITE);
		txtpnNombreDeFormulario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnNombreDeFormulario.setEditable(false);
		txtpnNombreDeFormulario.setBackground(new Color(34, 139, 34));
		txtpnNombreDeFormulario.setBounds(10, 102, 604, 22);
		panelActividad.add(txtpnNombreDeFormulario);
		
	}
	/*
		El metodo cargarFormularios() nos sirve para cargar todos los formularios 
		en la tabla "tableActividad", una ves cargados el usuario podra 
		elegir el formulario que utilizara para realizar la actividad de 
		campo.
		
	 * */
	private void cargarFormularios() {

		try {
			FormulariosBeanRemote formulariosBeanRemote = EJBLocator.getInstance().lookup(FormulariosBeanRemote.class);
			List<Formulario> formularios = new ArrayList<>();
	
			formularios = formulariosBeanRemote.obtenerTodos(txtBusquedaActividad.getText() + "%");

			String[] columnNames = {"nombreFormulario","resumen"};
			DefaultTableModel model = new DefaultTableModel();
			tableActividad.setModel(model);

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
