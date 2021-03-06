package actividad;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.EJBLocator;
import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.entidades.Actividad;
import com.entidades.Rol;
import com.entidades.Usuario;
import com.servicios.ActividadesBeanRemote;
import com.servicios.UsuariosBeanRemote;

import usuario.VentanaEditarUsuario;
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
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.Cursor;
import javax.swing.JTextPane;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import formulario.VentanaRegistrarFormulario;

public class VentanaRegistroActividad extends JFrame {
	
	//Declaramos los componentes o parametros.

	private JPanel contentPane;
	private JTable tableActividad;
	private JTextField txtBusquedaActividad;
	private JDateChooser dateChooserFin = new JDateChooser();
	private JDateChooser dateChooserInicio = new JDateChooser();
	public static JLabel lblNombreUsuario;

	/**
	 * VentanaRegistroActividad nos brindara las herramientas para 
	 * listar las actividades realizadas por el usuario segun el filtro 
	 * que se indique.
	 */
	public VentanaRegistroActividad(Usuario usuario) {
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
		VentanaRegistroActividad.lblNombreUsuario.setText(VentanaInicio.txtNombreUsuario.getText());

	
		
		
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
		
		JLabel lblPortada = new JLabel("");
		lblPortada.setIcon(new ImageIcon(VentanaRegistrarFormulario.class.getResource("/Imagenes/klipartz.com.png")));
		lblPortada.setBounds(-112, 0, 736, 90);
		panelUsuario.add(lblPortada);
		
		JPanel panelActividad = new JPanel();
		panelActividad.setLayout(null);
		panelActividad.setBackground(new Color(204, 255, 204));
		panelActividad.setBounds(0, 90, 624, 392);
		contentPane.add(panelActividad);
		
		JComboBox combofiltro = new JComboBox();
		combofiltro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		combofiltro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		combofiltro.setForeground(new Color(0, 102, 0));
		combofiltro.setModel(new DefaultComboBoxModel(new String[] {"Rango de fechas", "Estacion de muestreo", "Usuario Experto"}));
		combofiltro.setBounds(246, 70, 129, 22);
		panelActividad.add(combofiltro);
		
		JLabel lblFiltroActividad = new JLabel("Filtro:");
		lblFiltroActividad.setForeground(new Color(0, 102, 0));
		lblFiltroActividad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFiltroActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltroActividad.setBounds(203, 74, 39, 14);
		panelActividad.add(lblFiltroActividad);
		
		/*tableActividad es la tabla donde las actividades seran cargados 
		 * con el metodo correspondientes a cada filtro indicado */
		tableActividad = new JTable();
		tableActividad.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 0), null, null, null));
		tableActividad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tableActividad.getSelectedRow();
				String nombreRol = (String) tableActividad.getModel().getValueAt(row, 0);
				Actividad actividad = new Actividad();
				Rol rol = new Rol();
				actividad.setRol(rol);
				rol.setNombreRol(nombreRol);
				List<Actividad> actividades = new ArrayList<>();

				try {

					ActividadesBeanRemote actividadesBeanRemote = EJBLocator.getInstance().lookup(ActividadesBeanRemote.class);

					actividades = actividadesBeanRemote.obtenerPorUsuarioExperto(nombreRol);
					actividad = actividades.get(0);

				} catch (NamingException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}

				VentanaEditarActividad ventanaEditarActividad = new VentanaEditarActividad(usuario,actividad);
				ventanaEditarActividad.setUndecorated(false);
				ventanaEditarActividad.setVisible(true);
				dispose();

			}
		});
		tableActividad.setBackground(SystemColor.controlHighlight);
		tableActividad.setBounds (10, 186, 604, 161);
		panelActividad.add(tableActividad);
		
		JButton btnBuscarActividad = new JButton("Buscar");
		btnBuscarActividad.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnBuscarActividad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarActividad.setForeground(new Color(0, 102, 0));
		btnBuscarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * Filtros del comboBox, evalua el item elegido, y elije la funcion de listar
				 * segun se desee.
				 */
				if (combofiltro.getSelectedItem() == "Estacion de muestreo") {
					cargarActividadEstacion();
				} else if (combofiltro.getSelectedItem() == "Usuario Experto") {
					cargarActividadUsuario();
				} else if (combofiltro.getSelectedItem() == "Rango de fechas") {
					cargarActividadRangoFecha();
				}
			}
		});
		btnBuscarActividad.setBounds(385, 70, 72, 23);
		panelActividad.add(btnBuscarActividad);
		
		/*txtBusquedaActividad es el campo de texto que utilizaremos 
		 * para algunos de los filtros*/
		txtBusquedaActividad = new JTextField();
		txtBusquedaActividad.setColumns(10);
		txtBusquedaActividad.setBounds(467, 71, 103, 20);
		panelActividad.add(txtBusquedaActividad);
		
		/*El boton refrescar esta en desuso por el momento, pero
		 * el objetivo de este era el de listar todas las actividades*/
		JButton btnRefrescar = new JButton("");
		btnRefrescar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefrescar.setIcon(new ImageIcon(VentanaRegistroActividad.class.getResource("/Imagenes/refrescar4.png")));
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
		btnVolver.setBounds(513, 358, 89, 23);
		panelActividad.add(btnVolver);
		
		JLabel lblSeleccioneUnFormulario = new JLabel("Listado de actividades");
		lblSeleccioneUnFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneUnFormulario.setOpaque(true);
		lblSeleccioneUnFormulario.setBackground(new Color(0, 102, 0));
		lblSeleccioneUnFormulario.setForeground(new Color(255, 255, 255));
		lblSeleccioneUnFormulario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccioneUnFormulario.setBounds(12, 61, 181, 38);
		panelActividad.add(lblSeleccioneUnFormulario);
		
		JLabel lblNuevaCasilla_1 = new JLabel("Actividad de campo");
		lblNuevaCasilla_1.setOpaque(true);
		lblNuevaCasilla_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNuevaCasilla_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaCasilla_1.setForeground(Color.WHITE);
		lblNuevaCasilla_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNuevaCasilla_1.setBackground(new Color(60, 179, 113));
		lblNuevaCasilla_1.setBounds(0, 11, 624, 23);
		panelActividad.add(lblNuevaCasilla_1);
		
		JTextPane txtpnNombreDeFormulario = new JTextPane();
		txtpnNombreDeFormulario.setText("Estaci\u00F3n de muestreo              | M\u00E9todo de muestreo               | Creado por\t                              | Departamento");
		txtpnNombreDeFormulario.setForeground(Color.WHITE);
		txtpnNombreDeFormulario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnNombreDeFormulario.setEditable(false);
		txtpnNombreDeFormulario.setBackground(new Color(34, 139, 34));
		txtpnNombreDeFormulario.setBounds(10, 165, 604, 22);
		panelActividad.add(txtpnNombreDeFormulario);
		
		dateChooserInicio.setBounds(246, 103, 129, 20);
		panelActividad.add(dateChooserInicio);
		
		dateChooserFin.setBounds(246, 134, 129, 20);
		panelActividad.add(dateChooserFin);
		

		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setForeground(new Color(0, 128, 0));
		lblFechaInicio.setHorizontalTextPosition(SwingConstants.LEADING);
		lblFechaInicio.setBounds(170, 106, 72, 14);
		panelActividad.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setForeground(new Color(0, 128, 0));
		lblFechaFin.setBounds(180, 140, 62, 14);
		panelActividad.add(lblFechaFin);
			
		
	}
	/*cargarActividadEstacion() es el metodo que usamos para listar 
	 * las actividades segun estacion de muestreo. La estacion de muestreo 
	 * sera indicada en el campo de texto.*/
	private void cargarActividadEstacion() {
		try {
			ActividadesBeanRemote actividadesBeanRemote = EJBLocator.getInstance().lookup(ActividadesBeanRemote.class);
			List<Actividad> actividades = new ArrayList<>();

			actividades = actividadesBeanRemote.obtenerPorEstacionMuestreo(txtBusquedaActividad.getText() + "%");

			String[] columnNames = { "Estacion de Muestreo", "Metodo de muestreo", "Nombre de usuario", "Departamento" };
			DefaultTableModel model = new DefaultTableModel();
			tableActividad.setModel(model);

			model.setColumnIdentifiers(columnNames);
			for (Actividad actividad : actividades) {
				Object[] fila = new Object[4];
				fila[0] = actividad.getEstacionMuestreo();
				fila[1] = actividad.getMetodoMuestreo();
				fila[2] = actividad.getNombreUsuario();
				fila[3] = actividad.getDepartamento();
				model.addRow(fila);
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
	}/*cargarActividadUsuario() es el metodo que usamos para listar 
	 * las actividades segun el usuario experto que la realizo.El usuario
	 * sera indicado en el campo de texto.*/
	private void cargarActividadUsuario() {
		try {
			ActividadesBeanRemote actividadesBeanRemote = EJBLocator.getInstance().lookup(ActividadesBeanRemote.class);
			List<Actividad> actividades = new ArrayList<>();
			
			actividades = actividadesBeanRemote.obtenerPorUsuarioExperto(txtBusquedaActividad.getText() + "%");

			String[] columnNames = { "Estacion de Muestreo", "Metodo de muestreo", "Nombre de usuario", "Departamento" };
			DefaultTableModel model = new DefaultTableModel();
			tableActividad.setModel(model);

			model.setColumnIdentifiers(columnNames);
			for (Actividad actividad : actividades) {
				Object[] fila = new Object[4];
				fila[0] = actividad.getEstacionMuestreo();
				fila[1] = actividad.getMetodoMuestreo();
				fila[2] = actividad.getNombreUsuario();
				fila[3] = actividad.getDepartamento();
				model.addRow(fila);
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
	}
	/*cargarActividadRangoFecha() es el metodo que usamos para listar 
	 * las actividades segun un rango de fecha elegido. El rango de fechas
	 * sera indicado en los calendarios fechainicio y fechafin.*/
	private void cargarActividadRangoFecha() {
		try {
			ActividadesBeanRemote actividadesBeanRemote = EJBLocator.getInstance().lookup(ActividadesBeanRemote.class);
			List<Actividad> actividades = new ArrayList<>();
			
			actividades = actividadesBeanRemote.obtenerRangoFechas(dateChooserInicio.getDate(), dateChooserFin.getDate());

			String[] columnNames = { "Estacion de Muestreo", "Metodo de muestreo", "Nombre de usuario", "Departamento","Fecha Inicio", "Fecha fin" };
			DefaultTableModel model = new DefaultTableModel();
			tableActividad.setModel(model);

			model.setColumnIdentifiers(columnNames);
			for (Actividad actividad : actividades) {
				Object[] fila = new Object[6];
				fila[0] = actividad.getEstacionMuestreo();
				fila[1] = actividad.getMetodoMuestreo();
				fila[2] = actividad.getNombreUsuario();
				fila[3] = actividad.getDepartamento();
				fila[4] = actividad.getFechaInicio();
				fila[5] = actividad.getFechaFin();
				model.addRow(fila);
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
	
		
	}
}

