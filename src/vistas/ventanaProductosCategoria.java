package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controlador.coordinador;

public class ventanaProductosCategoria extends JFrame implements ActionListener {

	private JPanel panel;
	private JFrame frame;
	private JLabel labelTitulo;
	private JButton botonVolver;
	private coordinador coordinador;


	public ventanaProductosCategoria() {
		setSize(450, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Categoria");
		construirPanel();
		setContentPane(panel);
	    setLocationRelativeTo(null);
		setVisible(false);
	}

	private void construirPanel() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		labelTitulo = new JLabel("Productos de la categoria:");
		labelTitulo.setBounds(152, 11, 172, 14);
		panel.add(labelTitulo);
		
		botonVolver = new JButton("Volver");
		botonVolver.setBounds(346, 227, 78, 23);
		panel.add(botonVolver);
	}
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
