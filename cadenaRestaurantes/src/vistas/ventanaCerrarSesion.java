package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import controlador.coordinador;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public class ventanaCerrarSesion extends JFrame implements ActionListener {

	private JPanel panel;
	private JFrame frame;
	private JLabel labelTexto;
	private JButton botonSi, botonNo;
	private coordinador coordinador;

	
	public ventanaCerrarSesion() {
		setSize(450, 400);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Cerrar sesion");
		construirPanel();
		setContentPane(panel);
	    setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
	}

	
	private void construirPanel() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(26, 146, 185));
	    panel.setLayout(null);
	    
	    labelTexto = new JLabel("¿Está seguro de que desea cerrar sesión?");
	    labelTexto.setHorizontalAlignment(SwingConstants.CENTER);
	    labelTexto.setBounds(0, 89, 434, 14);
	    panel.add(labelTexto);
	    
	    botonSi = new JButton("Sí");
	    botonSi.setBounds(103, 124, 89, 23);
	    botonSi.addActionListener(this);
	    panel.add(botonSi);
	    
	    botonNo = new JButton("No");
	    botonNo.setBounds(242, 124, 89, 23);
	    botonNo.addActionListener(this);
	    panel.add(botonNo);
	}
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonSi) {
			coordinador.mostrarVentanaLogin();
			coordinador.ocultarVentanaCarrito();
			coordinador.ocultarVentanaListaCategorias();
			coordinador.ocultarVentanaProductosCategoria();
			this.setVisible(false);
		}
		if (e.getSource()==botonNo) {
			this.setVisible(false);
		}
	}
}
