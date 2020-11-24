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
import com.entidades.Usuario;
import com.servicios.ActividadesBeanRemote;
import com.servicios.UsuariosBeanRemote;

import usuario.VentanaEditarUsuario;

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
import java.util.List;

public class VentanaRegistroActividad extends JFrame {

	private JPanel contentPane;
	private JTable tableActividad;
	private JTextField txtBusquedaActividad;
	/**
	 * Create the frame.
	 */
	public VentanaRegistroActividad(Usuario usuario) {
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
		
		JComboBox combofiltro = new JComboBox();
		combofiltro.setModel(new DefaultComboBoxModel(new String[] {"Rago de fechas", "Estacion de muestreo", "Usuario Experto"}));
		combofiltro.setBounds(246, 70, 129, 22);
		panelActividad.add(combofiltro);
		
		JLabel lblFiltroActividad = new JLabel("Filtro:");
		lblFiltroActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltroActividad.setBounds(190, 74, 46, 14);
		panelActividad.add(lblFiltroActividad);
		
		tableActividad = new JTable();
		tableActividad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tableActividad.getSelectedRow();
				String metodoMuestreo = (String) tableActividad.getModel().getValueAt(row, 0);
				Actividad actividad = new Actividad();
				actividad.setMetodoMuestreo(metodoMuestreo);
				List<Actividad> actividades = new ArrayList<>();

				try {

					ActividadesBeanRemote actividadesBeanRemote = EJBLocator.getInstance().lookup(ActividadesBeanRemote.class);

					actividades = actividadesBeanRemote.obtenerPorMetodoMuestreo(metodoMuestreo);
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
		tableActividad.setBounds(89, 104, 492, 231);
		panelActividad.add(tableActividad);
		
		JButton btnBuscarActividad = new JButton("Buscar");
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
				} else if (combofiltro.getSelectedItem() == "Rago de fechas") {
					cargarActividadRangoFecha();
				}
			}
		});
		btnBuscarActividad.setBounds(385, 70, 72, 23);
		panelActividad.add(btnBuscarActividad);
		
		txtBusquedaActividad = new JTextField();
		txtBusquedaActividad.setColumns(10);
		txtBusquedaActividad.setBounds(467, 71, 103, 20);
		panelActividad.add(txtBusquedaActividad);
		
		JButton btnRefrescar = new JButton("R");
		btnRefrescar.setBounds(580, 70, 31, 23);
		panelActividad.add(btnRefrescar);
		
		JLabel lblTituloInicioActividad = new JLabel("Actividad de campo");
		lblTituloInicioActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloInicioActividad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloInicioActividad.setBounds(10, 11, 171, 39);
		panelActividad.add(lblTituloInicioActividad);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaActividad ventanaActividad = new VentanaActividad(usuario);
				ventanaActividad.setVisible(true);
				ventanaActividad.setLocation(400, 150);
				dispose();
			}
		});
		btnVolver.setBounds(0, 358, 89, 23);
		panelActividad.add(btnVolver);
		
		JLabel lblSeleccioneUnFormulario = new JLabel("Listado de actividades.");
		lblSeleccioneUnFormulario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeleccioneUnFormulario.setBounds(20, 60, 164, 39);
		panelActividad.add(lblSeleccioneUnFormulario);
			
		
	}
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

	
		
	}
	private void cargarActividadUsuario() {
		
	}
	private void cargarActividadRangoFecha() {
		
	}
}

