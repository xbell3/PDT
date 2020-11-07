package com.cliente;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.entidades.Usuario;

import formulario.VentanaFormulario;
import usuario.VentanaUsuario;

import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

import java.awt.SystemColor;

import java.awt.Font;



public class VentanaGeneral extends JFrame {
	public JPanel panelUsuario;
	public JPanel contentPane;
	public JLabel lblNombreUsuario;
	public VentanaGeneral(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelUsuario = new JPanel();
		panelUsuario.setBackground(SystemColor.activeCaption);
		panelUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.light"), UIManager.getColor("Button.shadow"), null, null));
		panelUsuario.setBounds(0, 0, 784, 90);
		contentPane.add(panelUsuario);
		panelUsuario.setLayout(null);
		
		JLabel lblTipoUser = new JLabel();
		lblTipoUser.setBounds(541, 45, 46, 14);
		panelUsuario.add(lblTipoUser);		
		lblTipoUser.setText("Tipo Usuario");
	
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(714, 16, 60, 23);
		panelUsuario.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaInicio ventanaInicio = new VentanaInicio(usuario);
				ventanaInicio.setLocation(400, 150);
				ventanaInicio.setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton = new JButton("Ayuda");
		btnNewButton.setBounds(616, 16, 88, 23);
		panelUsuario.add(btnNewButton);
		
		JLabel lblNombreSistema = new JLabel("Nombre App");
		lblNombreSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreSistema.setBounds(10, 16, 152, 34);
		panelUsuario.add(lblNombreSistema);
		
		lblNombreUsuario = new JLabel();
		lblNombreUsuario.setBounds(541, 20, 46, 14);
		panelUsuario.add(lblNombreUsuario);
		lblNombreUsuario.setText("(Nombre del usuario)");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 87, 784, 474);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAdministracion = new JButton("Administracion");
		btnAdministracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaUsuario ventanaUsuario = new VentanaUsuario (usuario);
				ventanaUsuario.setLocation(400, 150);
				ventanaUsuario.setVisible(true);
				dispose();
			}
		});
		btnAdministracion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdministracion.setBounds(10, 293, 300, 120);
		panel.add(btnAdministracion);
		
		JButton btnActividad = new JButton("Actividad");
		btnActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaGeneral ventanaGeneral = new VentanaGeneral(usuario);
				ventanaGeneral.setVisible(true);
				ventanaGeneral.setLocation(400, 150);
				dispose();
			}
		});
		btnActividad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnActividad.setBounds(474, 49, 300, 120);
		panel.add(btnActividad);
		
		JButton btnFormulario = new JButton("Formularios");
		btnFormulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaFormulario ventanaFormulario = new VentanaFormulario(usuario);
				ventanaFormulario.setLocation(450, 150);
				ventanaFormulario.setVisible(true);
				dispose();
			}
		});
		btnFormulario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFormulario.setBounds(10, 49, 300, 120);
		panel.add(btnFormulario);
		
	}
}
