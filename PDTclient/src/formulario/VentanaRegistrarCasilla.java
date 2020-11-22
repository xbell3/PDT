package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import com.cliente.EJBLocator;
import com.entidades.Casilla;
import com.entidades.Formulario;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.CasillasBeanRemote;
import com.servicios.FormulariosBeanRemote;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Color;
import javax.swing.ImageIcon;

public class VentanaRegistrarCasilla extends JFrame {

	private JPanel contentPane;
	private JTextField txtParametro;
	private JTextField txtUnidadMedida;
	public JFrame frame;
	private JTextField txtDescripcion;
	private JTextField txtTipoDeValor;
	private JTextField txtNombreFormulario;
	/**
	 * Create the frame.
	 */
	public VentanaRegistrarCasilla(Usuario usuario, Formulario formulario) {
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
		
		JLabel lblNuevaCasilla = new JLabel("Nueva Casilla");
		lblNuevaCasilla.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaCasilla.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNuevaCasilla.setBounds(200, 33, 174, 42);
		panelFormulario.add(lblNuevaCasilla);
		
		txtParametro = new JTextField();
		txtParametro.setText("Parametro");
		txtParametro.setHorizontalAlignment(SwingConstants.CENTER);
		txtParametro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtParametro.setColumns(10);
		txtParametro.setBounds(123, 164, 168, 42);
		panelFormulario.add(txtParametro);
		
		txtUnidadMedida = new JTextField();
		txtUnidadMedida.setText("Unidad de Medida");
		txtUnidadMedida.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnidadMedida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUnidadMedida.setColumns(10);
		txtUnidadMedida.setBounds(339, 164, 168, 42);
		panelFormulario.add(txtUnidadMedida);
		
		JButton btnCrearCasilla = new JButton("Crear Casilla");
		btnCrearCasilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearCasilla(formulario);
				
			}
		});
		btnCrearCasilla.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCrearCasilla.setBounds(257, 333, 174, 42);
		panelFormulario.add(btnCrearCasilla);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				dispose();
			}
		});
		btnVolver.setBounds(488, 345, 89, 23);
		panelFormulario.add(btnVolver);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setText("Descripcion");
		txtDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(123, 226, 168, 42);
		panelFormulario.add(txtDescripcion);
		
		txtTipoDeValor = new JTextField();
		txtTipoDeValor.setText("Tipo de Valor");
		txtTipoDeValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtTipoDeValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTipoDeValor.setColumns(10);
		txtTipoDeValor.setBounds(455, 236, 168, 42);
		panelFormulario.add(txtTipoDeValor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Numero entero", "Numero decimal", "Texto", "Boolean"}));
		comboBox.setBounds(339, 238, 113, 22);
		panelFormulario.add(comboBox);
		
		txtNombreFormulario = new JTextField();
		txtNombreFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreFormulario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNombreFormulario.setText(formulario.getNombreFormulario());
		txtNombreFormulario.setColumns(10);
		txtNombreFormulario.setEditable(false);
		txtNombreFormulario.setBounds(123, 279, 168, 42);
		panelFormulario.add(txtNombreFormulario);
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"),

						UIManager.getColor("Button.shadow"), null, null));
		panelUsuario.setBackground(new Color(0, 102, 0));
		panelUsuario.setBounds(0, 0, 624, 90);
		contentPane.add(panelUsuario);
		
		JLabel lblTipoUser = new JLabel("TipoUser");
		lblTipoUser.setBounds(382, 51, 46, 14);
		panelUsuario.add(lblTipoUser);
		
		JLabel lblNewLabel = new JLabel("(Nombre del usuario)");
		lblNewLabel.setBounds(329, 26, 118, 14);
		panelUsuario.add(lblNewLabel);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(555, 22, 60, 23);
		panelUsuario.add(btnSalir);
		
		JButton btnNewButton = new JButton("Ayuda");
		btnNewButton.setBounds(457, 22, 88, 23);
		panelUsuario.add(btnNewButton);
		
		JLabel lblNombreSistema = new JLabel("Nombre App");
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(10, 16, 152, 34);
		panelUsuario.add(lblNombreSistema);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaRegistrarCasilla.class.getResource("/Imagenes/klipartz.com.png")));
		lblNewLabel_1.setBounds(-102, 0, 726, 90);
		panelUsuario.add(lblNewLabel_1);
	}
	private void crearCasilla(Formulario formulario) {

		CasillasBeanRemote casillasBeanRemote;
		Casilla casilla = new Casilla ();
		
		casilla.setParametro(txtParametro.getText());
		casilla.setDescripcion(txtDescripcion.getText());
		casilla.setTipoUnidad(txtTipoDeValor.getText());
		casilla.setUnidadMedida(txtUnidadMedida.getText());
		try {

			casillasBeanRemote = EJBLocator.getInstance().lookup(CasillasBeanRemote.class);

			if (txtParametro.getText().isEmpty() || txtUnidadMedida.getText().isEmpty()
					) {
				JOptionPane.showMessageDialog(frame, "Debe completar todos los campos", "Campos Incompletos!",
						JOptionPane.INFORMATION_MESSAGE);

				return;

			}else {
				casillasBeanRemote.crear(casilla, txtNombreFormulario.getText());

				JOptionPane.showMessageDialog(frame, "La casilla ha sido creada con éxito.",
						"Casilla Registrado!", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}

		
		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (ServiciosException e1) {
			e1.printStackTrace();
		}
	
	}
}
