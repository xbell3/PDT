package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.cliente.EJBLocator;
import com.cliente.VentanaGeneral;
import com.cliente.VentanaInicio;
import com.entidades.Casilla;
import com.entidades.Formulario;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.CasillasBeanRemote;
import com.servicios.FormulariosBeanRemote;
import com.servicios.RolBeanRemote;
import com.servicios.UsuariosBeanRemote;

import actividad.VentanaActividad;
import usuario.VentanaUsuario;

import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class VentanaEditarFormulario extends JFrame {

	//Declaramos los componentes o parametros.
	private JPanel contentPane;
	private JFrame frame;
	private JTextField txtNombreFormulario;
	private JTextField txtResumen;
	private JTextField txtNombreDeFormulario;
	private JTextField txtDescripcinDeFormulario;
	/*
	 * el parametro lblNombreUsuario se declara static de esta manera no tendremos
	 * que instanciar un objeto de la clase para invocarlo
	 */
	public static JLabel lblNombreUsuario;
	private JTable tableCasilla;

	/**
	 * VentanaEditarFormulario nos brindara las funciones necesarias para
	 * modificar el formulario elegido de la tableFormulario de la ventana 
	 * VentanaFormularios. Este mismo tiene usuario y formulario pasado por 
	 * parametros para hacer registro de los cambios ya que estos se inicializan
	 * desde la ventana anterior. 
	 */
	public VentanaEditarFormulario(Usuario usuario, Formulario formulario) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaEditarFormulario.class.getResource("/Imagenes/iAGRO_V04.png")));
		setTitle("Editar Formulario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		VentanaEditarFormulario.lblNombreUsuario.setText(VentanaInicio.txtNombreUsuario.getText());

		JLabel lblIconUser;
		lblIconUser = new JLabel("");
		lblIconUser.setIcon(new ImageIcon(VentanaGeneral.class.getResource("/Imagenes/Usuario_gris.png")));
		lblIconUser.setBounds(10, 0, 37, 28);
		contentPane.add(lblIconUser);
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"),		UIManager.getColor("Button.shadow"), null, null));
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaEditarFormulario.class.getResource("/Imagenes/klipartz.com.png")));
		lblNewLabel_1.setBounds(-76, 0, 700, 90);
		panelUsuario.add(lblNewLabel_1);
		
		JPanel panelFormulario = new JPanel();
		panelFormulario.setLayout(null);
		panelFormulario.setBackground(new Color(204, 255, 204));
		panelFormulario.setBounds(0, 90, 624, 392);
		contentPane.add(panelFormulario);
		
		txtNombreFormulario = new JTextField();
		txtNombreFormulario.setToolTipText("Modificar nombre de formulario");
		txtNombreFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreFormulario.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNombreFormulario.setText(formulario.getNombreFormulario());
		txtNombreFormulario.setColumns(10);
		txtNombreFormulario.setBounds(218, 58, 196, 23);
		panelFormulario.add(txtNombreFormulario);
		
		txtResumen = new JTextField();
		txtResumen.setToolTipText("Modificar descripci\u00F3n de formulario");
		txtResumen.setHorizontalAlignment(SwingConstants.CENTER);
		txtResumen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtResumen.setText(formulario.getResumen());
		txtResumen.setColumns(10);
		txtResumen.setBounds(31, 277, 553, 53);
		panelFormulario.add(txtResumen);
		
		JButton btnModificarFormulario = new JButton("Modificar Formulario");
		btnModificarFormulario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarFormulario.setForeground(new Color(255, 255, 255));
		btnModificarFormulario.setBackground(new Color(0, 102, 0));
		btnModificarFormulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarFormulario(formulario);
			}
		});
		btnModificarFormulario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarFormulario.setBounds(21, 353, 155, 32);
		panelFormulario.add(btnModificarFormulario);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.setForeground(new Color(0, 102, 0));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {							
					dispose();
				}
		});
		btnVolver.setBounds(525, 355, 89, 23);
		panelFormulario.add(btnVolver);
		
		JButton btnAgregarCasilla = new JButton("Agregar Casilla");
		btnAgregarCasilla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarCasilla.setBackground(new Color(0, 102, 0));
		btnAgregarCasilla.setForeground(new Color(255, 255, 255));
		btnAgregarCasilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaRegistrarCasilla ventanaRegistrarCasilla = new VentanaRegistrarCasilla(formulario);
				ventanaRegistrarCasilla.setLocation(400, 150);
				ventanaRegistrarCasilla.setVisible(true);
			}
		});
		btnAgregarCasilla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgregarCasilla.setBounds(210, 353, 167, 32);
		panelFormulario.add(btnAgregarCasilla);
		
		txtNombreDeFormulario = new JTextField();
		txtNombreDeFormulario.setText("Nombre de Formulario");
		txtNombreDeFormulario.setForeground(Color.WHITE);
		txtNombreDeFormulario.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNombreDeFormulario.setEditable(false);
		txtNombreDeFormulario.setColumns(10);
		txtNombreDeFormulario.setBackground(new Color(0, 102, 0));
		txtNombreDeFormulario.setBounds(218, 45, 196, 14);
		panelFormulario.add(txtNombreDeFormulario);
		
		txtDescripcinDeFormulario = new JTextField();
		txtDescripcinDeFormulario.setText("Descripci\u00F3n de formulario");
		txtDescripcinDeFormulario.setForeground(Color.WHITE);
		txtDescripcinDeFormulario.setFont(new Font("Arial", Font.PLAIN, 11));
		txtDescripcinDeFormulario.setEditable(false);
		txtDescripcinDeFormulario.setColumns(10);
		txtDescripcinDeFormulario.setBackground(new Color(0, 102, 0));
		txtDescripcinDeFormulario.setBounds(31, 264, 553, 14);
		panelFormulario.add(txtDescripcinDeFormulario);
		
		JLabel lblNuevaCasilla_1 = new JLabel("Modificar Formlario");
		lblNuevaCasilla_1.setOpaque(true);
		lblNuevaCasilla_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNuevaCasilla_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaCasilla_1.setForeground(Color.WHITE);
		lblNuevaCasilla_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNuevaCasilla_1.setBackground(new Color(60, 179, 113));
		lblNuevaCasilla_1.setBounds(0, 11, 624, 23);
		panelFormulario.add(lblNuevaCasilla_1);
		
		/*tableCasilla es una peque�a tabla que nos permite visualizar 
		 * las casillas que le hemos ido a�adiendo a nuestro formulario.*/
		tableCasilla = new JTable();
		tableCasilla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tableCasilla.getSelectedRow();
				String parametro = (String) tableCasilla.getModel().getValueAt(row, 0);
				Casilla casilla = new Casilla();
				casilla.setParametro(parametro);
				List<Casilla> casillas = new ArrayList<>();

				try {

					CasillasBeanRemote casillasBeanRemote = EJBLocator.getInstance().lookup(CasillasBeanRemote.class);

					casillas = casillasBeanRemote.obtenerTodos(parametro);
					casilla = casillas.get(0);

				} catch (NamingException ex) {
					ex.printStackTrace();
				}
				VentanaEditarCasilla ventanaEditarCasilla = new VentanaEditarCasilla(formulario, casilla);
				ventanaEditarCasilla.setUndecorated(false);
				ventanaEditarCasilla.setVisible(true);
				
				
			}
		});	
		tableCasilla.setBounds(31, 117, 553, 136);
		panelFormulario.add(tableCasilla);
		
		JLabel lblCasillas = new JLabel("Casillas");
		lblCasillas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCasillas.setOpaque(true);
		lblCasillas.setForeground(new Color(255, 255, 255));
		lblCasillas.setBackground(new Color(0, 102, 0));
		lblCasillas.setBounds(31, 77, 65, 23);
		panelFormulario.add(lblCasillas);
		
		/*btnRefrescarTabla nos permite refrescar la tabla de casillas 
		 * para asi el usuario puede ir contemplando las casillas que va 
		 * a�adiendo */
		JButton btnRefrescarTabla = new JButton("");
		btnRefrescarTabla.setIcon(new ImageIcon(VentanaEditarFormulario.class.getResource("/Imagenes/refrescar4.png")));
		btnRefrescarTabla.setSelectedIcon(new ImageIcon(VentanaEditarFormulario.class.getResource("/Imagenes/refrescar4.png")));
		btnRefrescarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*llamamos al metodo listarCasillasAsignadas y le pasamos
				 * por parametro el formulario en cuestion, de esta manera
				 * el metodo lista las casillas relacionadas con este formulario*/
				listarCasillasAsignadas(formulario);
			}
		});
		btnRefrescarTabla.setBounds(106, 77, 23, 23);
		panelFormulario.add(btnRefrescarTabla);
		
		JLabel lblParmetroDescripcin = new JLabel("Par\u00E1metro                         | Descripci\u00F3n                     | Unidad de medida \t           | Tipo de valor");
		lblParmetroDescripcin.setOpaque(true);
		lblParmetroDescripcin.setForeground(Color.WHITE);
		lblParmetroDescripcin.setBackground(new Color(0, 102, 0));
		lblParmetroDescripcin.setBounds(31, 103, 553, 14);
		panelFormulario.add(lblParmetroDescripcin);

	}
	/*El metodo modificarFormulRio, llama al EJBLocator para localizar los Beans y 
	 * consigo cada metodo de persistencia que vamos requerir a traves de su 
	 * interfaz remota FormulariosBeanRemote, de donde sacaremos las funciones para
	 * dar de alta un usuario en este caso la funcion se llama "crear" y le 
	 * pasamos por parametro el objeto Formulario, al que le vamos a insertar todos los
	 * campos descritos a continuacion. */
	private void modificarFormulario(Formulario formulario) {

		FormulariosBeanRemote formulariosBeanRemote;
		formulario.setNombreFormulario(txtNombreFormulario.getText());
		formulario.setResumen(txtResumen.getText());
		
		try {

			formulariosBeanRemote = EJBLocator.getInstance().lookup(FormulariosBeanRemote.class);

			if (txtNombreFormulario.getText().isEmpty() || txtResumen.getText().isEmpty()
					) {
				JOptionPane.showMessageDialog(frame, "Debe completar todos los campos", "Campos Incompletos!",
						JOptionPane.INFORMATION_MESSAGE);

				return;

			}else {
				formulariosBeanRemote.actualizar(formulario);

				JOptionPane.showMessageDialog(frame, "El Formulario ha sido registrado con �xito.",
						"Formulario Registrado!", JOptionPane.INFORMATION_MESSAGE);
			}

		
		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (ServiciosException e1) {
			e1.printStackTrace();
		}
	
	}
	/*listarCasillasAsignadas es el metodo que usaremos para 
	 * listar las casillas que hemos ido relacionando al formulario pasado por 
	 * parametro. */
	private void listarCasillasAsignadas(Formulario formulario) {
		try {
			CasillasBeanRemote casillasBeanRemote = EJBLocator.getInstance().lookup(CasillasBeanRemote.class);
			List<Casilla> casillas = new ArrayList<>();
			DefaultTableModel model = new DefaultTableModel();
	
			casillas = casillasBeanRemote.obtenerTodosPorFormulario(formulario.getNombreFormulario().toString());

			String[] columnNames = {  "parametro", "descripcion", "unidadMedida", "tipoUnidad" };
					
			
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
