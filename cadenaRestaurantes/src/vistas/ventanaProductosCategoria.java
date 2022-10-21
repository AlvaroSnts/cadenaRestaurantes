package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controlador.coordinador;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class ventanaProductosCategoria<Jlist> extends JFrame implements ActionListener {

	private JPanel panel;
	private JFrame frame;
	private JLabel labelTitulo;
	private coordinador coordinador;
	private JButton botonVolver,botonCarrito;
	public static JList listaProductosCategoria;


	public ventanaProductosCategoria() {
		setSize(950, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Categoria");
		construirPanel();
		setContentPane(panel);
		setResizable(false);
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
		labelTitulo.setBounds(252, 100, 431, 100);
		panel.add(labelTitulo);
		
		botonVolver = new JButton("Volver");
		botonVolver.setBounds(10, 599, 119, 51);
		panel.add(botonVolver);
		botonVolver.addActionListener(this);
		
		botonCarrito = new JButton("Carrito");
		botonCarrito.setBounds(805, 599, 119, 51);
		panel.add(botonCarrito);
		botonCarrito.addActionListener(this); 
		
		listaProductosCategoria = new JList();
		listaProductosCategoria.setBounds(204, 77, 548, 521);
		panel.add(listaProductosCategoria);
	}
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonCarrito) {
			coordinador.mostrarVentanaCarrito();
			this.setVisible(false);
		}
		if(e.getSource()==botonVolver) {
			//coordinador.mostrarCategorias(null);
			this.setVisible(false);
		}
		
	}
}

