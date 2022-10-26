package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import controlador.coordinador;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;

public class ventanaCarrito extends JFrame implements ActionListener {

	private JPanel panel, panelCabecera;
	private JFrame frame;
	private JLabel labelTitulo, labelTituloCabecera, labelLogo, labelHusseinberg;
	private coordinador coordinador;
	private JButton btnConfirmaPedido;
	private JButton btnVolver;
	private JButton botonLogout;
	public static JList <String> carrito;
	private static DefaultListModel<String> modelo;
	public static Map<String, Integer> arrayAsociativo = new HashMap<>();

	public ventanaCarrito() {
		setSize(950, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Carrito");
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
		labelTitulo.setBounds(252, 100, 431, 100);
		panel.add(labelTitulo);
		
		btnConfirmaPedido = new JButton("Confirma pedido");
		btnConfirmaPedido.setBounds(789, 599, 135, 51);
		panel.add(btnConfirmaPedido);
		btnConfirmaPedido.addActionListener(this);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 599, 119, 51);
		panel.add(btnVolver);
		btnVolver.addActionListener(this);
		
		carrito = new JList<String>();
		carrito.setBounds(199, 192, 548, 399);
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
		
		labelTituloCabecera = new JLabel("Los Pollos Hermanos");
		labelTituloCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloCabecera.setForeground(Color.WHITE);
		labelTituloCabecera.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTituloCabecera.setBackground(Color.BLACK);
		labelTituloCabecera.setBounds(98, 8, 739, 21);
		panelCabecera.add(labelTituloCabecera);
		
		labelHusseinberg = new JLabel("");
		labelHusseinberg.setIcon(new ImageIcon(getClass().getResource("/Fotos/husseinberg.gif")));
		labelHusseinberg.setBounds(645, 192, 371, 399);
		panel.add(labelHusseinberg);
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
		if(e.getSource()==botonLogout) {
			coordinador.mostrarVentanaCerrarSesion();
		}
	}
	public static void setlistaCarrito(Map<String, Integer> arrayAsoc) {
		arrayAsociativo=arrayAsoc;
	}
	public static void mostrarArrayAsociativo() {
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		carrito.setModel(modelo);
		Set<Map.Entry<String ,Integer> > set = arrayAsociativo.entrySet();
		List<Map.Entry<String ,Integer>> list=new ArrayList<>(set);
		for(int i=0;i<arrayAsociativo.size();i++) {
			modelo.add(i, list.get(i).getKey()+" Cantidad: "+list.get(i).getValue());
		}
	}
}