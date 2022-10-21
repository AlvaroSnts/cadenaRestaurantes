package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import controlador.coordinador;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ImageIcon;

import modelo.vo.categoriasVo;
import modelo.vo.productosVo;

public class ventanaListaCategorias extends JFrame implements ActionListener {

	private JPanel panel, panelCabecera;
	private JFrame frame;
	private JLabel labelTitulo, labelLogo, labelTituloCabecera;
	private JButton botonLogout, botonVerCarrito, botonSeleccionar;
	private coordinador coordinador;
	public static JList listaCategorias;
	public static String categoriaString;
	public static int categoriaInt;
	
	public ventanaListaCategorias() {
		setSize(950, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Lista de categorias");
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
		panel.setBackground(new Color(26, 146, 185));
		panel.setLayout(null);
		
		panelCabecera = new JPanel();
		panelCabecera.setBackground(new Color(0, 0, 0));
		panelCabecera.setForeground(Color.BLACK);
		panelCabecera.setBounds(0, 0, 934, 42);
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
		
		labelTituloCabecera = new JLabel("Los Pollos Hermanos");
		labelTituloCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloCabecera.setForeground(new Color(255, 255, 255));
		labelTituloCabecera.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTituloCabecera.setBackground(Color.BLACK);
		labelTituloCabecera.setBounds(195, 8, 739, 21);
		panelCabecera.add(labelTituloCabecera);
		
		labelTitulo = new JLabel("Lista de categorias:");
		labelTitulo.setBounds(0, 44, 934, 22);
		panel.add(labelTitulo);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setForeground(Color.WHITE);
		
		
		listaCategorias = new JList();
		listaCategorias.setBounds(204, 77, 548, 521);
		panel.add(listaCategorias);
		
		botonSeleccionar = new JButton("Seleccionar");
		botonSeleccionar.addActionListener(this);
		botonSeleccionar.setBounds(835, 627, 89, 23);
		panel.add(botonSeleccionar);
		
		labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon("C:\\Users\\javie\\eclipse-workspace\\ABP3\\fotos\\PollosHermanosLogoGrande.png"));
		labelLogo.setBounds(0, 162, 205, 298);
		panel.add(labelLogo);
		
	}
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	
	public void mostrarCategoriaPorNombre(ArrayList<categoriasVo> categorias) {
		categoriaInt=categorias.get(0).getCodCat();
	}
	
	public void mostrarTodosLosProductosCategoria(ArrayList<productosVo> productos) {
		String[] categoriasArray=new String[500];
		
		if (productos!=null) {
			for (int i=0; i<productos.size(); i++) {
				categoriasArray[i]=productos.get(i).getNombre();
			}
			ventanaProductosCategoria.listaProductosCategoria.setListData(categoriasArray);
		}
		else {
			categoriasArray[0]="Esta vacío";
			ventanaProductosCategoria.listaProductosCategoria.setListData(categoriasArray);
		}
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
			categoriaString=listaCategorias.getSelectedValue().toString();
			coordinador.getLogica().validarMostrarCategoriaPorNombre();
			coordinador.getLogica().validarMostrarTodosLosProductosCategoria();
			coordinador.mostrarVentanaProductosCategoria();
			this.setVisible(false);
		}
	}
}
