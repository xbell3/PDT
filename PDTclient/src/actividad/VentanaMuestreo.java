package actividad;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.entidades.Formulario;
import com.entidades.Usuario;

public class VentanaMuestreo extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VentanaMuestreo(Usuario usuario, Formulario formulario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
