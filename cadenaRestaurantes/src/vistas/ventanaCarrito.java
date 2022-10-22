package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controlador.coordinador;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class ventanaCarrito extends JFrame implements ActionListener {

	private JPanel panel;
	private JFrame frame;
	private JLabel labelTitulo;
	private coordinador coordinador;
	private JButton btnConfirmaPedido;
	private JButton btnVolver;
	private JButton botonVerCarrito;
	private JButton botonLogout;
	private JList <String> carrito;
	private static DefaultListModel<String> modelo;
	public static String listaCarrito[] = new String[10];;
	public ventanaCarrito() {
		setSize(950, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Carrito");
		construirPanel();
		setContentPane(panel);
		btnConfirmaPedido = new JButton("Confirma pedido");
		btnConfirmaPedido.setBounds(805, 599, 119, 51);
		panel.add(btnConfirmaPedido);
		btnConfirmaPedido.addActionListener(this);
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 599, 119, 51);
		panel.add(btnVolver);
		btnVolver.addActionListener(this);
		carrito = new JList<String>();
		carrito.setBounds(154, 226, 636, 356);
		panel.add(carrito);
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		carrito.setModel(modelo);
		modelo.add(0, listaCarrito[0]);
		System.out.println(listaCarrito [0]);
		JPanel panelCabecera = new JPanel();
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
		panelCabecera.add(botonVerCarrito);
		botonVerCarrito.addActionListener(this);
		JLabel labelTituloCabecera = new JLabel("Los Pollos Hermanos");
		labelTituloCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloCabecera.setForeground(Color.WHITE);
		labelTituloCabecera.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTituloCabecera.setBackground(Color.BLACK);
		labelTituloCabecera.setBounds(98, 8, 739, 21);
		panelCabecera.add(labelTituloCabecera);
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
		
		labelTitulo = new JLabel("Carrito:");
		labelTitulo.setForeground(new Color(0, 0, 0));
		labelTitulo.setBackground(new Color(255, 255, 255));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelTitulo.setBounds(290, 119, 345, 81);
		panel.add(labelTitulo);
	}
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnConfirmaPedido) {
			
		}
		if(e.getSource()==btnVolver) {
			coordinador.mostrarVentanaProductosCategoria();
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
	public static void setlistaCarrito(String [] listaCarritoVentanaProdCat) {
		
		listaCarrito=listaCarritoVentanaProdCat;
	}
}
