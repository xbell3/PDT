package usuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.cliente.EJBLocator;
import com.entidades.Rol;
import com.entidades.Usuario;
import com.servicios.UsuariosBeanRemote;

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

import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	private JTable tableUsuario;
	private JTextField txtBusqueda;
	private JFrame frame;
	public JComboBox combofiltro;
//HOLA RECIBISTE EL NUEVO COMMIT?
//	public JComboBox comboBuscarRol;
	public VentanaUsuario(Usuario usuario) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox combofiltro = new JComboBox();
		combofiltro.setModel(new DefaultComboBoxModel(new String[] { "Nombre", "Apellido", "Usuario", "Rol" }));
		combofiltro.setBounds(424, 161, 81, 22);
		contentPane.add(combofiltro);

		/*
		 * JComboBox comboBuscarRol = new JComboBox(); comboBuscarRol.setVisible(false);
		 * comboBuscarRol.setEnabled(false); comboBuscarRol.setModel(new
		 * DefaultComboBoxModel(new String[] {"Administrador", "Experto", "Comun"}));
		 * comboBuscarRol.setBounds(616, 161, 84, 22); contentPane.add(comboBuscarRol);
		 * 
		 * combofiltro.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent arg0) { //Bloque if, que evalua si se eligio el
		 * filtro Rol if(combofiltro.getSelectedItem() == "Rol"){
		 * txtBusqueda.setVisible(false); txtBusqueda.setEnabled(false);
		 * comboBuscarRol.setEnabled(true); comboBuscarRol.setVisible(true);
		 * 
		 * }else { txtBusqueda.setVisible(true); txtBusqueda.setEnabled(true);
		 * comboBuscarRol.setVisible(false); comboBuscarRol.setEnabled(false); } } });
		 * 
		 * 
		 * 
		 * comboBuscarRol.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent arg0) { if(comboBuscarRol.getSelectedItem() ==
		 * "Administrador") { refrescarTabla(); }else
		 * if(comboBuscarRol.getSelectedItem() == "Experto") { cargarUsuarioPorRol(); }
		 * 
		 * }});
		 */
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

		JLabel lblTituloUsuario = new JLabel("Usuarios");
		lblTituloUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloUsuario.setBounds(10, 101, 157, 39);
		contentPane.add(lblTituloUsuario);

		tableUsuario = new JTable();
		tableUsuario.setModel(new DefaultTableModel());
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
				dispose();

			}
		});

		tableUsuario.setBackground(SystemColor.controlHighlight);
		tableUsuario.setBounds(145, 194, 601, 356);
		contentPane.add(tableUsuario);
		tableUsuario.setBackground(SystemColor.controlHighlight);
		tableUsuario.setBounds(145, 194, 601, 356);
		contentPane.add(tableUsuario);

		JButton btnListar = new JButton("Listar");
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
		btnListar.setBounds(515, 162, 72, 23);
		contentPane.add(btnListar);

		JButton btnRefrescar = new JButton("");
		btnRefrescar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refrescarTabla();
			}
		});
		btnRefrescar.setBounds(710, 162, 20, 23);
		contentPane.add(btnRefrescar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaGeneral ventanaGeneral = new VentanaGeneral(usuario);
				ventanaGeneral.setVisible(true);
				ventanaGeneral.setLocation(400, 150);
				dispose();

			}
		});
		btnVolver.setBounds(23, 514, 89, 23);
		contentPane.add(btnVolver);

		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(600, 163, 86, 20);
		contentPane.add(txtBusqueda);
		txtBusqueda.setColumns(10);

		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltrarPor.setBounds(342, 165, 72, 14);
		contentPane.add(lblFiltrarPor);
		
		JButton btnRegistrar = new JButton("Registrar usuario");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaRegistrarUsuario ventanaRegistrarUsuario = new VentanaRegistrarUsuario(usuario);
				ventanaRegistrarUsuario.setLocation(400, 150);
				ventanaRegistrarUsuario.setVisible(true);
				
			}
		});
		btnRegistrar.setBounds(16, 228, 119, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnBorrar = new JButton("Borrar Usuario");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnBorrar.setBounds(16, 262, 119, 23);
		contentPane.add(btnBorrar);

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
	private void borrarUsuario() {
		
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

	private void cargarUsuarioPorRol() {
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
}
