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
import modelo.vo.productosVo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Component;
import javax.swing.JScrollPane;

public class ventanaProductosCategoria extends JFrame implements ActionListener  {

	private JPanel panel;
	private JFrame frame;
	private JLabel labelTitulo, labelLogo, labelSusFringRecortado, labelTituloCabecera;
	private coordinador coordinador;
	private JButton botonVolver,botonCarrito,botonVerCarrito, botonQuitarProducto,botonAnadirProducto,botonLogout;
	public static JList listaProductosCategoria;
	private JPanel panelCabecera;
	public static JTextPane panelPropiedadesProducto,panelCantidad;
	public static Map<String, Integer> arrayAsociativo = new HashMap<String, Integer>();
	private JScrollPane scrollPane;

	public ventanaProductosCategoria() {
		setSize(950, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Productos de la categoría");
		Image icon = new ImageIcon(getClass().getResource("/fotos/finger.png")).getImage();
        setIconImage(icon);
		construirPanel();
		setContentPane(panel);
	}

	private void construirPanel() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(26, 146, 185));
		panel.setLayout(null);
		
		labelTitulo = new JLabel("Productos de la categoría:");
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(221, 189, 505, 160);
		panel.add(scrollPane);
		
		listaProductosCategoria = new JList();
		scrollPane.setViewportView(listaProductosCategoria);
		listaProductosCategoria.setValueIsAdjusting(true);
		
		listaProductosCategoria.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try {
					if(arrayAsociativo.get(listaProductosCategoria.getSelectedValue().toString())!=null) {
						panelCantidad.setText(""+arrayAsociativo.get(listaProductosCategoria.getSelectedValue().toString()));
					}
					else {
						panelCantidad.setText(""+0);
					}
				} catch (Exception e2) {
				
				}
				panelPropiedadesProducto.setVisible(true);
				try {
					panelPropiedadesProducto.setText(productosDao.stringCaracteristicasProducto(listaProductosCategoria.getSelectedValue().toString(),1)+"\r\n"+
							productosDao.stringCaracteristicasProducto(listaProductosCategoria.getSelectedValue().toString(),2)+"\r\n"+
							productosDao.stringCaracteristicasProducto(listaProductosCategoria.getSelectedValue().toString(),3));
				} catch (Exception e2) {
					
				}
			}
		});
		
		panelCabecera = new JPanel();
		panelCabecera.setLayout(null);
		panelCabecera.setForeground(Color.BLACK);
		panelCabecera.setBackground(Color.BLACK);
		panelCabecera.setBounds(0, 0, 934, 42);
		panel.add(panelCabecera);
		setResizable(false);
	    setLocationRelativeTo(null);
	    setVisible(false);
		
	    panelCantidad = new JTextPane();
	    panelCantidad.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panelCantidad.setEditable(false);
		panelCantidad.setBounds(753, 189, 79, 69);
		panel.add(panelCantidad);
	    
		botonLogout = new JButton("");
		botonLogout.setFont(new Font("Tahoma", Font.PLAIN, 10));
		botonLogout.setBounds(0, 0, 97, 42);
		botonLogout.setIcon(new ImageIcon(getClass().getResource("/Fotos/LogoutImagen.png")));
		botonLogout.setFocusPainted(false);
		botonLogout.setBorderPainted(false);
		botonLogout.setContentAreaFilled(false);
		botonLogout.addActionListener(this);
		panelCabecera.add(botonLogout);
		botonLogout.addActionListener(this);
		
		botonVerCarrito = new JButton("");
		botonVerCarrito.setBounds(97, 0, 97, 42);
		botonVerCarrito.setIcon(new ImageIcon(getClass().getResource("/Fotos/CarritoImagen.png")));
		botonVerCarrito.setFocusPainted(false);
		botonVerCarrito.setBorderPainted(false);
		botonVerCarrito.setContentAreaFilled(false);
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
		botonAnadirProducto.setBounds(858, 189, 45, 42);
		panel.add(botonAnadirProducto);
		
		botonQuitarProducto = new JButton("-");
		botonQuitarProducto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonQuitarProducto.setBounds(858, 255, 45, 42);
		panel.add(botonQuitarProducto);
		botonQuitarProducto.addActionListener(this);
		
		labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(getClass().getResource("/Fotos/PollosHermanosLogoGrande.png")));
		labelLogo.setBounds(0, 162, 205, 298);
		panel.add(labelLogo);
		
		panelPropiedadesProducto = new JTextPane();
		panelPropiedadesProducto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPropiedadesProducto.setEditable(false);
		panelPropiedadesProducto.setBounds(221, 428, 505, 160);
		panel.add(panelPropiedadesProducto);
		panelPropiedadesProducto.setVisible(false) ;
		
		labelSusFringRecortado = new JLabel("");
		labelSusFringRecortado.setIcon(new ImageIcon(getClass().getResource("/Fotos/gusFringRecortado.png")));
		labelSusFringRecortado.setBounds(622, 115, 393, 546);
		panel.add(labelSusFringRecortado);
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
			panelCantidad.setText("");
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
		}
		if(e.getSource()==botonAnadirProducto) {
			String nombreProducto=listaProductosCategoria.getSelectedValue().toString();
			int valorProducto=0;
			if(productosDao.comprobarStock(nombreProducto)==0) {
				JOptionPane.showMessageDialog(null, "No hay esa cantidad en stock para el producto seleccionado","Error",JOptionPane.ERROR_MESSAGE);
			}
			//Busca el producto en el arrayDelCarrito y si lo tiene le suma uno a su Value
			else if(arrayAsociativo.containsKey(nombreProducto)) {
				valorProducto=arrayAsociativo.get(nombreProducto);
				if(productosDao.comprobarStock(nombreProducto)>=valorProducto+1) {
					arrayAsociativo.put(nombreProducto,valorProducto+1);
					valorProducto++;
				}
				else {
					JOptionPane.showMessageDialog(null, "No hay esa cantidad en stock para el producto seleccionado","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			//Busca el producto en el arrayDelCarrito y si no lo encuentra añade el producto con value 1
			if(!arrayAsociativo.containsKey(nombreProducto)) {
				if(productosDao.comprobarStock(nombreProducto)>0) {
					arrayAsociativo.put(nombreProducto,1);
					valorProducto++;
				}
			}
			panelCantidad.setText(""+valorProducto);
		}
		if(e.getSource()==botonQuitarProducto) {
			int valorProducto=0;
			String nombreProducto=listaProductosCategoria.getSelectedValue().toString();
			//Busca si lo tiene
			if(arrayAsociativo.containsKey(nombreProducto)) {
				valorProducto=arrayAsociativo.get(nombreProducto);
				//Si lo tiene y la cantidad es mayor que 0
				if(arrayAsociativo.get(nombreProducto)>0) {
					//Si encuentra el producto quita una unidad
					arrayAsociativo.put(nombreProducto,valorProducto-1);
					valorProducto--;
					//Si la cantidad es igual a 0 elimina el producto del array
					if(arrayAsociativo.get(nombreProducto)==0) {
						arrayAsociativo.remove(nombreProducto);
					}
				}
			}
			panelCantidad.setText(""+valorProducto);
		}
	}
	public static void setPanelCategoriasProductosInvisible() {
		panelPropiedadesProducto.setVisible(false);
	}
}
