package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controlador.coordinador;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ventanaProductosCategoria extends JFrame implements ActionListener {

	private JPanel panel;
	private JFrame frame;
	private JLabel labelTitulo;
	private JButton botonVolver;
	private coordinador coordinador;
	private JButton Carrito;


	public ventanaProductosCategoria() {
		setSize(750, 520);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Categoria");
		construirPanel();
		setContentPane(panel);
		
		Carrito = new JButton("Carrito");
		Carrito.setBounds(605, 419, 119, 51);
		panel.add(Carrito);
	    setLocationRelativeTo(null);
		setVisible(false);
	}

	private void construirPanel() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setLayout(null);
		
		labelTitulo = new JLabel("Productos de la categoria:");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setBounds(152, 11, 431, 100);
		panel.add(labelTitulo);
		
		botonVolver = new JButton("Volver");
		botonVolver.setBounds(10, 447, 78, 23);
		panel.add(botonVolver);
	}
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
