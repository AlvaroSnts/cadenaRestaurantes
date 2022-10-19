package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import controlador.coordinador;
import modelo.vo.categoriasVo;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTable;

public class ventanaListaCategorias extends JFrame implements ActionListener {

	private JPanel panel, panelCabecera;
	private JFrame frame;
	private JLabel labelTitulo;
	private JButton botonLogout, botonVerCarrito, botonSeleccionar;
	private coordinador coordinador;
	public static JList listaCategorias;
	private JScrollBar scrollBar;
	private String[] categoriass={"Hola", "Que", "Tal"};

	
	public ventanaListaCategorias() {
		setSize(450, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Lista de categorias");
		construirPanel();
		setContentPane(panel);
		
		botonSeleccionar = new JButton("Seleccionar");
		botonSeleccionar.addActionListener(this);
		botonSeleccionar.setBounds(318, 327, 89, 23);
		panel.add(botonSeleccionar);
		
		
	}

	
	private void construirPanel() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(417, 0, 17, 361);
		panel.add(scrollBar);
		
		panelCabecera = new JPanel();
		panelCabecera.setBackground(Color.BLACK);
		panelCabecera.setForeground(Color.BLACK);
		panelCabecera.setBounds(0, 0, 424, 42);
		panel.add(panelCabecera);
		panelCabecera.setLayout(null);
		
		botonLogout = new JButton("Cerrar sesion");
		botonLogout.setBounds(0, 0, 97, 42);
		botonLogout.addActionListener(this);
		panelCabecera.add(botonLogout);
		
		botonVerCarrito = new JButton("Carrito");
		botonVerCarrito.setBounds(97, 0, 97, 42);
		botonVerCarrito.addActionListener(this);
		panelCabecera.add(botonVerCarrito);
		
		labelTitulo = new JLabel("Lista de categorias:");
		labelTitulo.setBounds(90, 44, 316, 22);
		panel.add(labelTitulo);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setForeground(Color.WHITE);
		listaCategorias = new JList();
		listaCategorias.setBounds(21, 89, 386, 227);
		panel.add(listaCategorias);
	}
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonLogout) {
			coordinador.mostrarVentanaCerrarSesion();
		}
		if (e.getSource()==botonVerCarrito) {
			coordinador.mostrarVentanaCarrito();
			this.setVisible(false);
		}
		if (e.getSource()==botonSeleccionar) {
			coordinador.mostrarVentanaProductosCategoria();
			this.setVisible(false);
		}
	}
}
