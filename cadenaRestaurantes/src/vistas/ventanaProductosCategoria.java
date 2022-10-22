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
	public static String[] listaCarrito;


	public ventanaProductosCategoria() {
		setSize(950, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Categoria");
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
		
		botonVerCarrito = new JButton("Carrito");
		botonVerCarrito.setBounds(97, 0, 97, 42);
		panelCabecera.add(botonVerCarrito);
		
		labelTituloCabecera = new JLabel("Los Pollos Hermanos");
		labelTituloCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloCabecera.setForeground(Color.WHITE);
		labelTituloCabecera.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTituloCabecera.setBackground(Color.BLACK);
		labelTituloCabecera.setBounds(98, 8, 739, 21);
		panelCabecera.add(labelTituloCabecera);
		listaCarrito = new String [10];
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaCarrito[0]=listaProductosCategoria.getSelectedValue().toString();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(811, 189, 45, 42);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBounds(811, 254, 45, 42);
		panel.add(btnNewButton_1);
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
			coordinador.mostrarVentanaCarrito();
			ventanaCarrito.setlistaCarrito(listaCarrito);
			this.setVisible(false);
		}
		if(e.getSource()==botonVolver) {
			coordinador.mostrarVentanaListaCategorias();
			this.setVisible(false);
		}
		
	}
}

