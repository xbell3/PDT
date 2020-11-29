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
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class VentanaAgregarCasilla extends JFrame {

	private JPanel contentPane;
	private JTable tableCasilla;
	private JTextField txtBusqueda;

	public VentanaAgregarCasilla(Usuario usuario, Formulario formulario) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAgregarCasilla.class.getResource("/Imagenes/iAGRO_V04.png")));
		setTitle("Agregar Casillas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		lblTipoUser.setBounds(391, 36, 46, 14);
		panelUsuario.add(lblTipoUser);
		
		JLabel lblNewLabel = new JLabel("(Nombre del usuario)");
		lblNewLabel.setBounds(338, 11, 118, 14);
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
		btnSalir.setBounds(548, 11, 60, 23);
		panelUsuario.add(btnSalir);
		
		JButton btnNewButton = new JButton("Ayuda");
		btnNewButton.setBounds(450, 11, 88, 23);
		panelUsuario.add(btnNewButton);
		
		JLabel lblNombreSistema = new JLabel("ARCD");
		lblNombreSistema.setForeground(Color.WHITE);
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(10, 16, 152, 34);
		panelUsuario.add(lblNombreSistema);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaAgregarCasilla.class.getResource("/Imagenes/klipartz.com.png")));
		lblNewLabel_1.setBounds(-116, 0, 740, 90);
		panelUsuario.add(lblNewLabel_1);
		
		JPanel panelCasilla = new JPanel();
		panelCasilla.setLayout(null);
		panelCasilla.setBackground(new Color(204, 255, 204));
		panelCasilla.setBounds(0, 90, 624, 471);
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
		btnVolver.setBounds(566, 437, 89, 23);
		panelCasilla.add(btnVolver);
		
		tableCasilla = new JTable();
		tableCasilla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tableCasilla.getSelectedRow();
				Long idCasilla = (Long) tableCasilla.getModel().getValueAt(row, 0);
				Casilla casilla = new Casilla();
				casilla.setIdCasilla(idCasilla);
			//	List<Casilla> casillas = formulario.getCasillas();
				try {

					FormulariosBeanRemote formulariosBeanRemote = EJBLocator.getInstance().lookup(FormulariosBeanRemote.class);

				} catch (NamingException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			
			}
		});
		tableCasilla.setBackground(SystemColor.controlHighlight);
		tableCasilla.setBounds(10, 90, 604, 253);
		panelCasilla.add(tableCasilla);
		
		JButton btnListarCasilla = new JButton("Listar");
		btnListarCasilla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListarCasilla.setForeground(new Color(0, 102, 0));
		btnListarCasilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarCasillas();
			}
		});
		btnListarCasilla.setBounds(394, 56, 72, 23);
		panelCasilla.add(btnListarCasilla);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setColumns(10);
		txtBusqueda.setBounds(494, 57, 103, 20);
		panelCasilla.add(txtBusqueda);
		
		JButton btnAgregar = new JButton("Agregar casilla");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setBackground(new Color(0, 102, 0));
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnAgregar.setBounds(10, 354, 120, 32);
		panelCasilla.add(btnAgregar);
		
		JButton btnVolver_1 = new JButton("Volver");
		btnVolver_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGeneral ventanaGeneral = new VentanaGeneral(usuario);
				ventanaGeneral.setVisible(true);
				ventanaGeneral.setLocation(400, 150);
				dispose();
			}
		});
		btnVolver_1.setForeground(new Color(0, 102, 0));
		btnVolver_1.setBounds(514, 359, 89, 23);
		panelCasilla.add(btnVolver_1);
		
		JLabel lblNuevaCasilla_1 = new JLabel("Agregar casillas");
		lblNuevaCasilla_1.setOpaque(true);
		lblNuevaCasilla_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNuevaCasilla_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaCasilla_1.setForeground(Color.WHITE);
		lblNuevaCasilla_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNuevaCasilla_1.setBackground(new Color(60, 179, 113));
		lblNuevaCasilla_1.setBounds(0, 11, 624, 23);
		panelCasilla.add(lblNuevaCasilla_1);
		
		
	}
	private void agregarCasilla(Long idFormulario, List<Casilla> casillas) throws ServiciosException {
		try {
			FormulariosBeanRemote formulariosBeanRemote = EJBLocator.getInstance().lookup(FormulariosBeanRemote.class);
	//		CasillasBeanRemote casillasBeanRemote = EJBLocator.getInstance().lookup(CasillasBeanRemote.class);			
			
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
