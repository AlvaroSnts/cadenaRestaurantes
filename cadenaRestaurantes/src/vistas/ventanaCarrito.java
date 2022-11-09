package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import controlador.coordinador;
import modelo.conexion.conexion;
import modelo.dao.carritoDao;
import modelo.dao.productosDao;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ventanaCarrito extends JFrame implements ActionListener {

	private JPanel panel, panelCabecera;
	private JFrame frame;
	private JLabel labelTitulo, labelTituloCabecera, labelLogo, labelWalter;
	private coordinador coordinador;
	private JButton botonQuitarProducto,botonAnadirProducto,botonLogout,btnVolver,btnConfirmaPedido,botonEliminar;
	public static JList <String> carrito;
	private static DefaultListModel<String> modelo;
	public static Map<String, Integer> arrayAsociativo = new HashMap<>();
	public static List<Map.Entry<String ,Integer>> list;

	public ventanaCarrito() {
		setSize(950, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Carrito");
		Image icon = new ImageIcon(getClass().getResource("/fotos/finger.png")).getImage();
        setIconImage(icon);
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

		labelTitulo = new JLabel("Carrito:");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelTitulo.setForeground(new Color(0, 0, 0));
		labelTitulo.setBounds(273, 71, 431, 100);
		panel.add(labelTitulo);

		btnConfirmaPedido = new JButton("Confirma pedido");
		btnConfirmaPedido.setBounds(789, 610, 135, 40);
		panel.add(btnConfirmaPedido);
		btnConfirmaPedido.addActionListener(this);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 610, 119, 40);
		panel.add(btnVolver);
		btnVolver.addActionListener(this);

		carrito = new JList<String>();
		carrito.setBounds(215, 160, 548, 232);
		panel.add(carrito);

		panelCabecera = new JPanel();
		panelCabecera.setLayout(null);
		panelCabecera.setForeground(Color.BLACK);
		panelCabecera.setBackground(Color.BLACK);
		panelCabecera.setBounds(0, 0, 934, 42);
		panel.add(panelCabecera);

		labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(getClass().getResource("/Fotos/PollosHermanosLogoGrande.png")));
		labelLogo.setBounds(0, 162, 205, 298);
		panel.add(labelLogo);

		botonLogout = new JButton("");
		botonLogout.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonLogout.setBounds(0, 0, 97, 42);
		botonLogout.setIcon(new ImageIcon(getClass().getResource("/Fotos/LogoutImagen.png")));
		botonLogout.setFocusPainted(false);
		botonLogout.setBorderPainted(false);
		botonLogout.setContentAreaFilled(false);
		panelCabecera.add(botonLogout);
		botonLogout.addActionListener(this);

		botonAnadirProducto = new JButton("+");
		botonAnadirProducto.addActionListener(this);
		botonAnadirProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botonAnadirProducto.setBounds(353, 452, 45, 42);
		panel.add(botonAnadirProducto);

		botonQuitarProducto = new JButton("-");
		botonQuitarProducto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonQuitarProducto.setBounds(441, 452, 45, 42);
		panel.add(botonQuitarProducto);
		botonQuitarProducto.addActionListener(this);

		labelTituloCabecera = new JLabel("Los Pollos Hermanos");
		labelTituloCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloCabecera.setForeground(Color.WHITE);
		labelTituloCabecera.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTituloCabecera.setBackground(Color.BLACK);
		labelTituloCabecera.setBounds(98, 8, 739, 21);
		panelCabecera.add(labelTituloCabecera);
		
		botonEliminar= new JButton("Eliminar");
		botonEliminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonEliminar.setBounds(526, 452, 119, 42);
		panel.add(botonEliminar);
		botonEliminar.addActionListener(this);
		
		labelWalter = new JLabel("");
		labelWalter.setIcon(new ImageIcon(getClass().getResource("/Fotos/waltersiu.png")));
		labelWalter.setBounds(714, 162, 244, 521);
		panel.add(labelWalter);
	}
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnConfirmaPedido) {
			carritoDao.eliminarStockCarrito(list);
			String fecha=carritoDao.procesarPedido(list);
			carritoDao.insertarPedidosProductos(fecha,list);
			modelo.clear();
			arrayAsociativo.clear();
		}
		if(e.getSource()==btnVolver) {
			coordinador.mostrarVentanaProductosCategoria();
			this.setVisible(false);
		}
		if(e.getSource()==botonEliminar) {
			int posicionMarcada=carrito.getSelectedIndex();
			String nombreProducto=list.get(carrito.getSelectedIndex()).getKey();
			arrayAsociativo.remove(nombreProducto);
			list.remove(carrito.getSelectedIndex());
			modelo.clear();
			for(int i=0;i<arrayAsociativo.size();i++) {
				modelo.add(i, list.get(i).getKey()+" Cantidad: "+list.get(i).getValue());
			}
			carrito.setSelectedIndex(posicionMarcada);
		}
		if(e.getSource()==botonLogout) {
			coordinador.mostrarVentanaCerrarSesion();
		}
		if(e.getSource()==botonAnadirProducto) {
			int posicionMarcada=carrito.getSelectedIndex();
			if(posicionMarcada>-1) {
				String nombreProducto=list.get(posicionMarcada).getKey();
				int valorProducto =list.get(posicionMarcada).getValue();
				if(arrayAsociativo.containsKey(nombreProducto)) {
					if(productosDao.comprobarStock(nombreProducto)>valorProducto) {
						arrayAsociativo.put(nombreProducto, valorProducto+1);
					}
					else
						JOptionPane.showMessageDialog(null, "No hay esa cantidad en stock para el producto seleccionado","Error",JOptionPane.ERROR_MESSAGE);
				}
				modelo.clear();
				for(int i=0;i<arrayAsociativo.size();i++) {
					modelo.add(i, list.get(i).getKey()+" Cantidad: "+list.get(i).getValue());
				}
				carrito.setSelectedIndex(posicionMarcada);
			}

		}
		if(e.getSource()==botonQuitarProducto) {
			int posicionMarcada=carrito.getSelectedIndex();
			if(posicionMarcada>-1) {
				String nombreProducto=list.get(carrito.getSelectedIndex()).getKey();
				int valorProducto =list.get(carrito.getSelectedIndex()).getValue();
				if(arrayAsociativo.containsKey(nombreProducto)) {
					if(valorProducto>0 && valorProducto!=1) {
						arrayAsociativo.put(nombreProducto,valorProducto-1);
					}
					if(valorProducto==1) {
						arrayAsociativo.remove(nombreProducto);
						list.remove(carrito.getSelectedIndex());
					}
				}
				modelo.clear();
				for(int i=0;i<arrayAsociativo.size();i++) {
					modelo.add(i, list.get(i).getKey()+" Cantidad: "+list.get(i).getValue());
				}
				carrito.setSelectedIndex(posicionMarcada);
			}
		}
	}
	public static void setlistaCarrito(Map<String, Integer> arrayAsoc) {
		arrayAsociativo=arrayAsoc;
	}
	public static void mostrarArrayAsociativo() {
		modelo = new DefaultListModel<String>();
		carrito.setModel(modelo);
		Set<Map.Entry<String ,Integer> > set = arrayAsociativo.entrySet();
		list=new ArrayList<>(set);
		for(int i=0;i<arrayAsociativo.size();i++) {
			modelo.add(i, list.get(i).getKey()+" Cantidad: "+list.get(i).getValue());
		}
	}
}