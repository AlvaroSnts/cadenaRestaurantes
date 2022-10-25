package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import controlador.coordinador;
import modelo.dao.productosDao;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class ventanaProductosCategoria extends JFrame implements ActionListener {

	private JPanel panel;
	private JFrame frame;
	private JLabel labelTitulo, labelLogo;
	private coordinador coordinador;
	private JButton botonVolver,botonCarrito,botonVerCarrito, botonQuitarProducto,botonAnadirProducto,botonLogout;
	public static JList listaProductosCategoria;
	private JPanel panelCabecera;
	private JLabel labelTituloCabecera;
	public static Map<String, Integer> arrayAsociativo = new HashMap<String, Integer>();

	public ventanaProductosCategoria() {
		setSize(950, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Productos de la categoria");
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
		
		botonAnadirProducto = new JButton("+");
		botonAnadirProducto.addActionListener(this);
		botonAnadirProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botonAnadirProducto.setBounds(811, 189, 45, 42);
		panel.add(botonAnadirProducto);
		
		botonQuitarProducto = new JButton("-");
		botonQuitarProducto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonQuitarProducto.setBounds(811, 254, 45, 42);
		panel.add(botonQuitarProducto);
		botonQuitarProducto.addActionListener(this);
		
		labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(getClass().getResource("/Fotos/PollosHermanosLogoGrande.png")));
		labelLogo.setBounds(0, 162, 205, 298);
		panel.add(labelLogo);
	}
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonCarrito) {
			ventanaCarrito.setlistaCarrito(arrayAsociativo);
			ventanaCarrito.mostrarArrayAsociativo();
			coordinador.mostrarVentanaCarrito();
			this.setVisible(false);
		}
		if(e.getSource()==botonVolver) {
			coordinador.mostrarVentanaListaCategorias();
			this.setVisible(false);
		}
		if(e.getSource()==botonVerCarrito) {
			ventanaCarrito.setlistaCarrito(arrayAsociativo);
			ventanaCarrito.mostrarArrayAsociativo();
			coordinador.mostrarVentanaCarrito();
			this.setVisible(false);
		}
		if(e.getSource()==botonLogout) {
			coordinador.mostrarVentanaCerrarSesion();
			this.setVisible(false);
		}
		if(e.getSource()==botonAnadirProducto) {
			//Busca el producto en el arrayDelCarrito y si lo tiene le suma uno a su Value
			if(arrayAsociativo.containsKey(listaProductosCategoria.getSelectedValue().toString())) {
				arrayAsociativo.put(listaProductosCategoria.getSelectedValue().toString(),arrayAsociativo.get(listaProductosCategoria.getSelectedValue().toString())+1);
			}
			//Busca el producto en el arrayDelCarrito y si no lo encuentra añade el producto con value 1
			if(!arrayAsociativo.containsKey(listaProductosCategoria.getSelectedValue().toString())) {
				if(productosDao.comprobarStock(listaProductosCategoria.getSelectedValue().toString())>0) {
					arrayAsociativo.put(listaProductosCategoria.getSelectedValue().toString(),1);
				}
			}
		}
		if(e.getSource()==botonQuitarProducto) {
			//Busca si lo tiene
			if(arrayAsociativo.containsKey(listaProductosCategoria.getSelectedValue().toString())) {
				//Si lo tiene y la cantidad es mayor que 0
				if(arrayAsociativo.get(listaProductosCategoria.getSelectedValue().toString())>0) {
					//Si encuentra el producto quita una unidad
					arrayAsociativo.put(listaProductosCategoria.getSelectedValue().toString(),arrayAsociativo.get(listaProductosCategoria.getSelectedValue().toString())-1);
					//Si la cantidad es igual a 0 elimina el producto del array
					if(arrayAsociativo.get(listaProductosCategoria.getSelectedValue().toString())==0) {
						arrayAsociativo.remove(listaProductosCategoria.getSelectedValue().toString());
					}
				}
			}
		}
	}
}

