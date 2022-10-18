package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;
import controlador.coordinador;
import modelo.conexion.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class ventanaLogin extends JFrame implements ActionListener {

	private JPanel panel;
	private JFrame frame;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	private JButton botonEntrar;
	private coordinador coordinador;

	
	public ventanaLogin() {
		setSize(450, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Login");
		construirPanel();
		setContentPane(panel);
	    setLocationRelativeTo(null);
		setVisible(true);
	}

	
	private void construirPanel() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(157, 87, 115, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel labelUsuario = new JLabel("Usuario:");
		labelUsuario.setBounds(193, 62, 48, 14);
		panel.add(labelUsuario);
		
		JLabel labelPassword = new JLabel("Password:");
		labelPassword.setBounds(183, 129, 69, 14);
		panel.add(labelPassword);
		
		JLabel labelTitulo = new JLabel("Restaurante Vitisma");
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setBackground(Color.BLACK);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(0, 0, 434, 33);
		panel.add(labelTitulo);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 164, 115, 20);
		panel.add(passwordField);
		
		botonEntrar = new JButton("Entrar");
		botonEntrar.setBounds(171, 227, 89, 23);
		botonEntrar.addActionListener(this);
		panel.add(botonEntrar);
	}
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonEntrar) {
			conexion.setLogin(textFieldUsuario.getText());
			conexion.setPassword(String.valueOf(passwordField.getPassword()));
			conexion conexion=new conexion();
			
			if (conexion.conectarBD()==null) {
				JOptionPane.showMessageDialog(null, "Error en la introduccion de datos. Intentelo de nuevo","Error",JOptionPane.ERROR_MESSAGE);
				textFieldUsuario.setText("");
				passwordField.setText("");
			}
			else {
				coordinador.mostrarVentanaListaCategorias();
				this.setVisible(false);
				textFieldUsuario.setText("");
				passwordField.setText("");
			}
		
		}
	}
}
