package usuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.EJBLocator;
import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import usuario.VentanaRegistrarUsuario;
import com.cliente.VentanaInicio;
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

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	private JTable tableUsuario;
	private JTextField txtBusqueda;
	public JComboBox combofiltro;
	public String seleccionar = "";
	private JFrame frame;

	public VentanaUsuario(Usuario usuario) {
		setTitle("Usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaUsuario.class.getResource("/Imagenes/iAGRO_V04.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(441, 130, 138, 20);
		contentPane.add(txtBusqueda);
		txtBusqueda.setColumns(10);

		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"),
				UIManager.getColor("Button.shadow"), null, null));
		panelUsuario.setBackground(new Color(0, 102, 0));
		panelUsuario.setBounds(0, 0, 784, 92);
		contentPane.add(panelUsuario);

		JComboBox combofiltro = new JComboBox();
		combofiltro.setModel(new DefaultComboBoxModel(new String[] { "Nombre", "Apellido", "Usuario", "Rol" }));
		combofiltro.setBounds(353, 130, 81, 22);
		contentPane.add(combofiltro);

		JLabel lblTipoUser = new JLabel("TipoUser");
		lblTipoUser.setForeground(new Color(255, 255, 255));
		lblTipoUser.setBounds(10, 52, 46, 14);
		panelUsuario.add(lblTipoUser);

		JLabel lblNewLabel = new JLabel("(Nombre del usuario)");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(37, 27, 118, 14);
		panelUsuario.add(lblNewLabel);

		JButton btnSalir = new JButton("Salir");
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
		btnSalir.setBounds(539, 16, 68, 17);
		panelUsuario.add(btnSalir);

		JButton btnNewButton = new JButton("Ayuda");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
			
		btnNewButton.setForeground(new Color(0, 102, 0));
		btnNewButton.setBounds(461, 16, 68, 17);
		panelUsuario.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 11, 55, 45);
		panelUsuario.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/Usuario_gris.png")));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/klipartz.com.png")));
		lblNewLabel_2.setBounds(-52, 0, 698, 90);
		panelUsuario.add(lblNewLabel_2);

		JLabel lblTituloUsuario = new JLabel("Usuarios");
		lblTituloUsuario.setForeground(new Color(0, 102, 0));
		lblTituloUsuario.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/Imagenes/usuarios_v02.png")));
		lblTituloUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloUsuario.setBounds(30, 103, 157, 70);
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

			}
		});
		tableUsuario.setBackground(SystemColor.controlHighlight);
		tableUsuario.setBounds(127, 161, 493, 316);
		contentPane.add(tableUsuario);

		JButton btnListar = new JButton("Listar");
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

		JButton btnRegistrar = new JButton("Registrar usuario");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaRegistrarUsuario ventanaRegistrarUsuario = new VentanaRegistrarUsuario(usuario);
				ventanaRegistrarUsuario.setLocation(400, 150);
				ventanaRegistrarUsuario.setVisible(true);
				
			}
		});
		btnRegistrar.setBounds(1, 246, 121, 23);
		contentPane.add(btnRegistrar);
			
				JButton btnRefrescar = new JButton("");
				btnRefrescar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						refrescarTabla();
					}
				});
				btnRefrescar.setBounds(596, 130, 21, 23);
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
		btnVolver.setBounds(20, 448, 89, 23);
		contentPane.add(btnVolver);
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
}
