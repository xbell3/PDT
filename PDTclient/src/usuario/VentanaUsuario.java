package usuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.EJBLocator;
import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
//import com.cliente.VentanaRegistrarUsuario;
//import com.cliente.VentanaInicio;
import com.entidades.Usuario;
import com.servicios.UsuariosBeanRemote;

import actividad.VentanaActividad;
import formulario.VentanaRegistrarFormulario;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.DebugGraphics;

public class VentanaUsuario extends JFrame {

	public JPanel panelUsuario;
	private JPanel contentPane;
	private JTable tableUsuario;
	private JTextField txtBusqueda;
	public JComboBox combofiltro;
	public String seleccionar = "";
	private JFrame frame;
	public static JLabel lblNombreUsuario;

	public VentanaUsuario(Usuario usuario) {

		/*
		 * A continuacion definimos todas las caracteristicas y valores de cada objeto o
		 * parametro declarado.
		 */

		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaGeneral.class.getResource("/Imagenes/iAGRO_V04.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelUsuario = new JPanel();
		panelUsuario.setForeground(new Color(255, 255, 255));
		panelUsuario.setBackground(new Color(0, 100, 0));
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"),
				UIManager.getColor("Button.shadow"), null, null));
		panelUsuario.setBounds(0, 0, 624, 91);
		contentPane.add(panelUsuario);
		panelUsuario.setLayout(null);

		JLabel lblNombreSistema = new JLabel("");
		lblNombreSistema.setIcon(new ImageIcon(VentanaActividad.class.getResource("/Imagenes/iconoApp3.png")));
		lblNombreSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreSistema.setForeground(Color.WHITE);
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(259, 4, 98, 86);
		panelUsuario.add(lblNombreSistema);

		lblNombreUsuario = new JLabel();
		lblNombreUsuario.setBounds(32, 0, 211, 28);
		panelUsuario.add(lblNombreUsuario);
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreUsuario.setForeground(Color.WHITE);

		VentanaUsuario.lblNombreUsuario.setText(VentanaInicio.txtNombreUsuario.getText());

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaGeneral.class.getResource("/Imagenes/Usuario_gris.png")));
		lblNewLabel_1.setBounds(10, 0, 37, 28);
		panelUsuario.add(lblNewLabel_1);

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

		VentanaGeneral.lblNombreUsuario.setText(VentanaInicio.txtNombreUsuario.getText());

		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(441, 130, 138, 20);
		contentPane.add(txtBusqueda);
		txtBusqueda.setColumns(10);

		JComboBox combofiltro = new JComboBox();
		combofiltro.setForeground(new Color(0, 102, 0));
		combofiltro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		combofiltro.setModel(new DefaultComboBoxModel(new String[] { "Nombre", "Apellido", "Usuario", "Rol" }));
		combofiltro.setBounds(353, 130, 81, 22);
		contentPane.add(combofiltro);

		VentanaGeneral.lblNombreUsuario.setText(VentanaInicio.txtNombreUsuario.getText());

		JLabel lblTituloUsuario = new JLabel("Usuarios");
		lblTituloUsuario.setForeground(new Color(0, 102, 0));
		lblTituloUsuario.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/usuarios_v02.png")));
		lblTituloUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloUsuario.setBounds(30, 103, 157, 70);
		contentPane.add(lblTituloUsuario);

		tableUsuario = new JTable();
		tableUsuario.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 0), null, null, null));
		tableUsuario.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column" }));

		tableUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tableUsuario.getSelectedRow();
				String nombreUsuario = (String) tableUsuario.getModel().getValueAt(row, 0);
				Usuario usuario = new Usuario();
				usuario.setNombreUsuario(nombreUsuario);
				List<Usuario> usuarios = new ArrayList<>();

				try {

					UsuariosBeanRemote usuariosBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);

					usuarios = usuariosBeanRemote.obtenerPorNombreUsuario(nombreUsuario);
					usuario = usuarios.get(0);

				} catch (NamingException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}

				VentanaEditarUsuario ventanaEditarUsuario = new VentanaEditarUsuario(usuario);
				ventanaEditarUsuario.setUndecorated(false);
				ventanaEditarUsuario.setVisible(true);

			}
		});
		tableUsuario.setBackground(SystemColor.controlHighlight);
		tableUsuario.setBounds(10, 208, 604, 229);
		contentPane.add(tableUsuario);

		JButton btnListar = new JButton("Listar");
		btnListar.setForeground(new Color(0, 102, 0));
		btnListar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * Filtros del comboBox, evalua el item elegido, y elije la funcion de listar
				 * segun se desee.
				 */
				if (combofiltro.getSelectedItem() == "Nombre") {
					cargarUsuarioNombre();
				} else if (combofiltro.getSelectedItem() == "Apellido") {
					cargarUsuarioApellido();
				} else if (combofiltro.getSelectedItem() == "Usuario") {
					cargarUsuarioNombreUsuario();
				} else if (combofiltro.getSelectedItem() == "Rol") {
					cargarUsuarioPorRol();
				}
			}
		});
		btnListar.setBounds(246, 130, 72, 23);
		contentPane.add(btnListar);
		/*
		 * Con el boton btnRegistrar, inmediatamente accedemos a la ventana de registro
		 * de usuario, en donde se podra registrar un usuario en la aplicacion
		 * ingresando cada uno de sus datos y el rol que va a ocupar en ella.
		 */
		JButton btnRegistrar = new JButton("Registrar usuario");
		btnRegistrar.setBackground(new Color(0, 102, 0));
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaRegistrarUsuario ventanaRegistrarUsuario = new VentanaRegistrarUsuario(usuario);
				ventanaRegistrarUsuario.setLocation(400, 150);
				ventanaRegistrarUsuario.setVisible(true);

			}
		});
		btnRegistrar.setBounds(10, 448, 135, 25);
		contentPane.add(btnRegistrar);

		JButton btnRefrescar = new JButton("");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRefrescar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefrescar.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/refrescar4.png")));
		btnRefrescar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refrescarTabla();
			}
		});
		btnRefrescar.setBounds(589, 130, 28, 23);
		contentPane.add(btnRefrescar);

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
		btnVolver.setBounds(492, 449, 122, 23);
		contentPane.add(btnVolver);

		JTextPane txtpnNombreDeUsuario = new JTextPane();
		txtpnNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnNombreDeUsuario.setEditable(false);
		txtpnNombreDeUsuario.setForeground(new Color(255, 255, 255));
		txtpnNombreDeUsuario.setBackground(new Color(34, 139, 34));
		txtpnNombreDeUsuario.setText(
				"Nombre de Usuario         | Nombre                         | Apellido                          | Correo                           | Rol");
		txtpnNombreDeUsuario.setBounds(10, 186, 604, 22);
		contentPane.add(txtpnNombreDeUsuario);

		JPanel panel = new JPanel();
		panel.setBounds(0, 90, 624, 392);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(204, 255, 204));

		JButton btnordenarAsc_ = new JButton("");
		btnordenarAsc_.setBounds(10, 82, 21, 14);
		panel.add(btnordenarAsc_);
		btnordenarAsc_.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/Asc2.png")));
		btnordenarAsc_.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnordenarAsc_.setForeground(new Color(0, 128, 0));
		btnordenarAsc_.setToolTipText("");

		btnordenarAsc_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				orednarTablaDesc();
			}
		});

		JButton btnordenarDesc = new JButton("");
		btnordenarDesc.setBounds(30, 82, 21, 14);
		panel.add(btnordenarDesc);
		btnordenarDesc.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/Desc2.png")));
		btnordenarDesc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnordenarDesc.setForeground(new Color(0, 128, 0));
		btnordenarDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				orednarTablaAsc();
			}
		});

	}

	private void cargarUsuarioPorRol() {
		try {
			UsuariosBeanRemote usuariosBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);
			List<Usuario> usuarios = new ArrayList<>();
			usuarios = usuariosBeanRemote.obtenerPorRol(txtBusqueda.getText() + "%");

			String[] columnNames = { "nombreUsuario", "Nombre", "Apellido", "Correo", "Rol" };
			DefaultTableModel model = new DefaultTableModel();
			tableUsuario.setModel(model);

			model.setColumnIdentifiers(columnNames);
			for (Usuario usuario : usuarios) {
				Object[] fila = new Object[6];
				fila[0] = usuario.getNombreUsuario();
				fila[1] = usuario.getNombre();
				fila[2] = usuario.getApellido();
				fila[3] = usuario.getCorreo();
				fila[4] = usuario.getRol().getNombreRol();
				model.addRow(fila);
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void cargarUsuarioApellido() {
		try {
			UsuariosBeanRemote usuariosBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);
			List<Usuario> usuarios = new ArrayList<>();

			usuarios = usuariosBeanRemote.obtenerPorApellido(txtBusqueda.getText() + "%");

			String[] columnNames = { "nombreUsuario", "Nombre", "Apellido", "Correo", "Rol" };
			DefaultTableModel model = new DefaultTableModel();
			tableUsuario.setModel(model);

			model.setColumnIdentifiers(columnNames);
			for (Usuario usuario : usuarios) {
				Object[] fila = new Object[6];
				fila[0] = usuario.getNombreUsuario();
				fila[1] = usuario.getNombre();
				fila[2] = usuario.getApellido();
				fila[3] = usuario.getCorreo();
				fila[4] = usuario.getRol().getNombreRol();
				model.addRow(fila);
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void cargarUsuarioNombre() {
		try {
			UsuariosBeanRemote usuariosBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);
			List<Usuario> usuarios = new ArrayList<>();

			usuarios = usuariosBeanRemote.obtenerPorNombre(txtBusqueda.getText() + "%");

			String[] columnNames = { "nombreUsuario", "Nombre", "Apellido", "Correo", "Rol" };
			DefaultTableModel model = new DefaultTableModel();
			tableUsuario.setModel(model);

			model.setColumnIdentifiers(columnNames);
			for (Usuario usuario : usuarios) {
				Object[] fila = new Object[6];
				fila[0] = usuario.getNombreUsuario();
				fila[1] = usuario.getNombre();
				fila[2] = usuario.getApellido();
				fila[3] = usuario.getCorreo();
				fila[4] = usuario.getRol().getNombreRol();
				model.addRow(fila);
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void cargarUsuarioNombreUsuario() {
		try {
			UsuariosBeanRemote usuariosBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);
			List<Usuario> usuarios = new ArrayList<>();

			usuarios = usuariosBeanRemote.obtenerPorNombreUsuario(txtBusqueda.getText() + "%");

			String[] columnNames = { "nombreUsuario", "Nombre", "Apellido", "Correo", "Rol" };
			DefaultTableModel model = new DefaultTableModel();
			tableUsuario.setModel(model);

			model.setColumnIdentifiers(columnNames);
			for (Usuario usuario : usuarios) {
				Object[] fila = new Object[6];
				fila[0] = usuario.getNombreUsuario();
				fila[1] = usuario.getNombre();
				fila[2] = usuario.getApellido();
				fila[3] = usuario.getCorreo();
				fila[4] = usuario.getRol().getNombreRol();
				model.addRow(fila);
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void refrescarTabla() {
		try {
			UsuariosBeanRemote usuariosBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);
			List<Usuario> usuarios = new ArrayList<>();

			usuarios = usuariosBeanRemote.obtenerTodos();

			String[] columnNames = { "nombreUsuario", "Nombre", "Apellido", "Correo", "Rol" };
			DefaultTableModel model = new DefaultTableModel();
			tableUsuario.setModel(model);

			model.setColumnIdentifiers(columnNames);
			for (Usuario usuario : usuarios) {
				Object[] fila = new Object[6];
				fila[0] = usuario.getNombreUsuario();
				fila[1] = usuario.getNombre();
				fila[2] = usuario.getApellido();
				fila[3] = usuario.getCorreo();
				fila[4] = usuario.getRol().getNombreRol();
				model.addRow(fila);
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void orednarTablaDesc() {
		try {
			UsuariosBeanRemote usuariosBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);
			List<Usuario> usuarios = new ArrayList<>();

			usuarios = usuariosBeanRemote.obtenerTodosAsc();

			String[] columnNames = { "nombreUsuario", "Nombre", "Apellido", "Correo", "Rol" };
			DefaultTableModel model = new DefaultTableModel();
			tableUsuario.setModel(model);

			model.setColumnIdentifiers(columnNames);
			for (Usuario usuario : usuarios) {
				Object[] fila = new Object[6];
				fila[0] = usuario.getNombreUsuario();
				fila[1] = usuario.getNombre();
				fila[2] = usuario.getApellido();
				fila[3] = usuario.getCorreo();
				fila[4] = usuario.getRol().getNombreRol();
				model.addRow(fila);
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void orednarTablaAsc() {
		try {
			UsuariosBeanRemote usuariosBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);
			List<Usuario> usuarios = new ArrayList<>();

			usuarios = usuariosBeanRemote.obtenerTodosDesc();

			String[] columnNames = { "nombreUsuario", "Nombre", "Apellido", "Correo", "Rol" };
			DefaultTableModel model = new DefaultTableModel();
			tableUsuario.setModel(model);

			model.setColumnIdentifiers(columnNames);
			for (Usuario usuario : usuarios) {
				Object[] fila = new Object[6];
				fila[0] = usuario.getNombreUsuario();
				fila[1] = usuario.getNombre();
				fila[2] = usuario.getApellido();
				fila[3] = usuario.getCorreo();
				fila[4] = usuario.getRol().getNombreRol();
				model.addRow(fila);
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
