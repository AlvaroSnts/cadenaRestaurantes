package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import controlador.coordinador;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class ventanaProductosCategoria extends JFrame implements ActionListener {

	private JPanel panel;
	private JFrame frame;
	private JLabel labelTitulo;
	private coordinador coordinador;
	private JButton botonVolver,botonCarrito;
	public static JList listaProductosCategoria;
	private JPanel panelCabecera;
	private JButton botonLogout;
	private JButton botonVerCarrito;
	private JLabel labelTituloCabecera;
	public static ArrayList<String> listaCarrito = new ArrayList<>();

	public ventanaProductosCategoria() {
		setSize(950, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Productos de la categoria");
		construirPanel();
		setContentPane(panel);
		
		panelCabecera = new JPanel();
		panelCabecera.setLayout(null);
		panelCabecera.setForeground(Color.BLACK);
		panelCabecera.setBackground(Color.BLACK);
		panelCabecera.setBounds(0, 0, 934, 42);
		panel.add(panelCabecera);
		
		botonLogout = new JButton("Cerrar sesion");
		botonLogout.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonLogout.setBounds(0, 0, 97, 42);
		panelCabecera.add(botonLogout);
		botonLogout.addActionListener(this);
		botonVerCarrito = new JButton("Carrito");
		botonVerCarrito.setBounds(97, 0, 97, 42);
		botonCarrito.addActionListener(this);
		panelCabecera.add(botonVerCarrito);
		botonVerCarrito.addActionListener(this);
		labelTituloCabecera = new JLabel("Los Pollos Hermanos");
		labelTituloCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloCabecera.setForeground(Color.WHITE);
		labelTituloCabecera.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTituloCabecera.setBackground(Color.BLACK);
		labelTituloCabecera.setBounds(98, 8, 739, 21);
		panelCabecera.add(labelTituloCabecera);
		JButton botonAnadirProducto = new JButton("+");
		botonAnadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indexProducto=listaCarrito.indexOf(listaProductosCategoria.getSelectedValue().toString());
				if(listaCarrito.indexOf(listaProductosCategoria.getSelectedValue().toString())!=-1) {
					//Conectar con la base de datos y mirar cuantos productos hay de esa categoria, crear un array de ese tama�o
					//e introducir la cantidad de productos que se quieren a�adir al carrito
					String producto = listaProductosCategoria.getSelectedValue().toString() + " 2";
					listaCarrito.remove(indexProducto);
					listaCarrito.add(producto);
				}
				else {
					listaCarrito.add(listaProductosCategoria.getSelectedValue().toString());
				}
				
			}
		});
		botonAnadirProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botonAnadirProducto.setBounds(811, 189, 45, 42);
		panel.add(botonAnadirProducto);
		
		JButton botonQuitarProducto = new JButton("-");
		botonQuitarProducto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonQuitarProducto.setBounds(811, 254, 45, 42);
		panel.add(botonQuitarProducto);
		botonQuitarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<listaCarrito.size();i++) {
					if(listaCarrito.indexOf(listaProductosCategoria.getSelectedValue().toString())!=-1) {
						listaCarrito.remove(listaProductosCategoria.getSelectedValue().toString());
					}
				}
				
				
				
			}
		});
		setResizable(false);
	    setLocationRelativeTo(null);
	    setVisible(false);
	    
	}

	private void construirPanel() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(26, 146, 185));
		panel.setLayout(null);
		
		labelTitulo = new JLabel("Productos de la categoria:");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelTitulo.setForeground(new Color(0, 0, 0));
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
		listaProductosCategoria.setBounds(199, 192, 548, 399);
		panel.add(listaProductosCategoria);
	}
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonCarrito) {
			//coordinador.mostrarVentanaCarrito();
			ventanaCarrito V = new ventanaCarrito();
			ventanaCarrito.setlistaCarrito(listaCarrito);
			V.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==botonVolver) {
			coordinador.mostrarVentanaListaCategorias();
			this.setVisible(false);
		}
		if(e.getSource()==botonVerCarrito) {
			coordinador.mostrarVentanaCarrito();
			this.setVisible(false);
		}
		if(e.getSource()==botonLogout) {
			coordinador.mostrarVentanaCerrarSesion();
			this.setVisible(false);
		}
		
	}
}

