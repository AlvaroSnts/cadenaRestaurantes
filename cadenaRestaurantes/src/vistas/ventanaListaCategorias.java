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

public class ventanaListaCategorias extends JFrame implements ActionListener {

	private JPanel panel, panelCabecera;
	private JFrame frame;
	private JLabel labelTitulo;
	private JButton botonLogout, botonVerCarrito;
	private coordinador coordinador;
	private JList listaCategorias;
	private JScrollBar scrollBar;

	
	public ventanaListaCategorias() {
		setSize(450, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Lista de categorias");
		construirPanel();
		setContentPane(panel);
		
		
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
		
		botonLogout = new JButton("Cerrar sesión");
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
		listaCategorias.setBounds(23, 91, 177, 167);
		panel.add(listaCategorias);
	}
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	
	public void mostrarCategorias(ArrayList<categoriasVo> categorias) {
		DefaultListModel lista = new DefaultListModel();
		for (categoriasVo aux:categorias) {
			lista.addElement(aux.getNombre());
		}
		listaCategorias.setModel(lista);

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonLogout) {
			coordinador.mostrarVentanaCerrarSesion();
		}
		if (e.getSource()==botonVerCarrito) {
			coordinador.mostrarVentanaCarrito();
			this.setVisible(false);
		}
	}
}
