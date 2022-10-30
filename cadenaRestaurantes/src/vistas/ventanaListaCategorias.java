package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import controlador.coordinador;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import modelo.dao.categoriasDao;
import modelo.dao.productosDao;
import modelo.vo.categoriasVo;
import modelo.vo.productosVo;

public class ventanaListaCategorias extends JFrame implements ActionListener {

	private JPanel panel, panelCabecera;
	private JFrame frame;
	private JLabel labelTitulo, labelLogo, labelTituloCabecera, labelImagenSaul;
	private JButton botonLogout, botonVerCarrito, botonSeleccionar;
	private coordinador coordinador;
	public static JList listaCategorias;
	public static String categoriaString,detallesCategoria;
	public static int categoriaInt;
	public static JTextPane panelPropiedadesCategorias;


	public ventanaListaCategorias() {
		setSize(950, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Lista de categorías");
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

		panelCabecera = new JPanel();
		panelCabecera.setBackground(new Color(0, 0, 0));
		panelCabecera.setForeground(Color.BLACK);
		panelCabecera.setBounds(0, 0, 934, 42);
		panel.add(panelCabecera);

		botonLogout = new JButton("");
		botonLogout.setBounds(0, 0, 97, 42);
		botonLogout.setIcon(new ImageIcon(getClass().getResource("/Fotos/LogoutImagen.png")));
		botonLogout.setFocusPainted(false);
		botonLogout.setBorderPainted(false);
		botonLogout.setContentAreaFilled(false);
		botonLogout.addActionListener(this);
		panelCabecera.setLayout(null);
		panelCabecera.add(botonLogout);

		labelTituloCabecera = new JLabel("Los Pollos Hermanos");
		labelTituloCabecera.setBounds(98, 8, 739, 21);
		labelTituloCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloCabecera.setForeground(new Color(255, 255, 255));
		labelTituloCabecera.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTituloCabecera.setBackground(Color.BLACK);
		panelCabecera.add(labelTituloCabecera);

		botonVerCarrito = new JButton("");
		botonVerCarrito.setBounds(97, 0, 97, 42);
		panelCabecera.add(botonVerCarrito);
		botonVerCarrito.setForeground(new Color(255, 255, 255));
		botonVerCarrito.setIcon(new ImageIcon(getClass().getResource("/Fotos/CarritoImagen.png")));
		botonVerCarrito.setFocusPainted(false);
		botonVerCarrito.setBorderPainted(false);
		botonVerCarrito.setContentAreaFilled(false);
		botonVerCarrito.addActionListener(this);

		labelTitulo = new JLabel("Lista de categorías:");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelTitulo.setForeground(new Color(0, 0, 0));
		labelTitulo.setBounds(252, 100, 431, 100);
		panel.add(labelTitulo);



		listaCategorias = new JList();
		listaCategorias.setBounds(221, 192, 505, 160);
		panel.add(listaCategorias);

		botonSeleccionar = new JButton("Seleccionar");
		botonSeleccionar.addActionListener(this);
		botonSeleccionar.setBounds(806, 599, 119, 51);
		panel.add(botonSeleccionar);

		labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(getClass().getResource("/Fotos/PollosHermanosLogoGrande.png")));
		labelLogo.setBounds(0, 162, 205, 298);
		panel.add(labelLogo);

		labelImagenSaul = new JLabel("");
		labelImagenSaul.setIcon(new ImageIcon(getClass().getResource("/Fotos/saulPose.png")));
		labelImagenSaul.setBounds(623, 192, 396, 469);
		panel.add(labelImagenSaul);

		panelPropiedadesCategorias = new JTextPane();
		panelPropiedadesCategorias.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPropiedadesCategorias.setEditable(false);
		panelPropiedadesCategorias.setBounds(221, 428, 505, 160);
		panel.add(panelPropiedadesCategorias);
		panelPropiedadesCategorias.setVisible(false);
		listaCategorias.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				panelPropiedadesCategorias.setVisible(true);
				try {
					panelPropiedadesCategorias.setText(categoriasDao.stringCaracteristicasCategorias(listaCategorias.getSelectedValue().toString(),1));
				} catch (Exception e2) {

				}
			}
		});
	}

	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}

	public void mostrarCategoriaPorNombre() {
		ArrayList<categoriasVo> categorias=new ArrayList<categoriasVo>();
		categorias=categoriasDao.mostrarCategoriaPorNombre(categorias);
		categoriaInt=categorias.get(0).getCodCat();

	}

	public void mostrarTodosLosProductosCategoria() {
		ArrayList<productosVo> productos=new ArrayList<productosVo>();
		productos=productosDao.mostrarTodosLosProductosCategoria(productos);
		DefaultListModel<String> modelo = new DefaultListModel<String>();

		if (productos!=null) {
			for (int i=0; i<productos.size(); i++) {
				modelo.addElement(productos.get(i).getNombre());
			}
			ventanaProductosCategoria.listaProductosCategoria.setModel(modelo);
		}
		else {
			modelo.clear();
			ventanaProductosCategoria.listaProductosCategoria.setModel(modelo);
		}
	}



	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonLogout) {
			coordinador.mostrarVentanaCerrarSesion();
		}
		if (e.getSource()==botonVerCarrito) {
			ventanaCarrito.mostrarArrayAsociativo();
			coordinador.mostrarVentanaCarrito();
			this.setVisible(false);
		}
		if (e.getSource()==botonSeleccionar) {
			categoriaString=listaCategorias.getSelectedValue().toString();
			mostrarCategoriaPorNombre();
			mostrarTodosLosProductosCategoria();
			coordinador.mostrarVentanaProductosCategoria();
			ventanaProductosCategoria.setPanelCategoriasProductosInvisible();
			this.setVisible(false);
		}
	}

	public static int getIndexCat() {
		return listaCategorias.getSelectedIndex();
	}
}
