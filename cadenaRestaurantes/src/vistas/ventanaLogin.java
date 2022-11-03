package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;
import controlador.coordinador;
import modelo.conexion.conexion;
import modelo.dao.categoriasDao;
import modelo.dao.restaurantesDao;
import modelo.vo.categoriasVo;
import modelo.vo.restaurantesVo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Image;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class ventanaLogin extends JFrame implements ActionListener {

	private JPanel panel;
	private JFrame frame;
	private JLabel labelTitulo, labelPassword, labelImagen, labelSusFring, labelCodRes;
	private JPasswordField passwordField;
	private JButton botonEntrar;
	private coordinador coordinador;
	public static String[] categoriasString;
	private JTextField textFieldCodRes;
	public static int codigoRestaurante=0;
	
	public ventanaLogin() {
		setSize(450, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Iniciar sesión");
		Image icon = new ImageIcon(getClass().getResource("/fotos/finger.png")).getImage();
        setIconImage(icon);
		construirPanel();
		setContentPane(panel);
	    setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

	}

	
	private void construirPanel() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(26, 146, 185));
		panel.setLayout(null);
		
		labelPassword = new JLabel("Contraseña:");
		labelPassword.setHorizontalAlignment(SwingConstants.CENTER);
		labelPassword.setBounds(0, 137, 434, 14);
		panel.add(labelPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 162, 115, 20);
		panel.add(passwordField);
		
		botonEntrar = new JButton("Entrar");
		botonEntrar.setBounds(171, 205, 89, 23);
		botonEntrar.addActionListener(this);
		panel.add(botonEntrar);
		
		labelImagen=new JLabel("");
		labelImagen.setIcon(new ImageIcon(getClass().getResource("/fotos/PollosHermanosLogoPequeno.png")));
		labelImagen.setBounds(69, 0, 65, 88);
		panel.add(labelImagen);
		
		labelTitulo = new JLabel("Los Pollos Hermanos");
		labelTitulo.setBounds(0, 35, 434, 21);
		panel.add(labelTitulo);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTitulo.setForeground(new Color(0, 0, 0));
		labelTitulo.setBackground(Color.BLACK);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		labelSusFring = new JLabel("");
		labelSusFring.setIcon(new ImageIcon(getClass().getResource("/fotos/SusFring.png")));
		labelSusFring.setBounds(223, 130, 383, 361);
		panel.add(labelSusFring);
		
		textFieldCodRes = new JTextField();
		textFieldCodRes.setColumns(10);
		textFieldCodRes.setBounds(157, 106, 115, 20);
		panel.add(textFieldCodRes);
		
		labelCodRes = new JLabel("Código de restaurante:");
		labelCodRes.setHorizontalAlignment(SwingConstants.CENTER);
		labelCodRes.setBounds(0, 81, 434, 14);
		panel.add(labelCodRes);
	}
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	//Conecta con categoriasDao para mostrar todas las categorias
	public void mostrarTodasLasCategorias() {
		ArrayList<categoriasVo> categorias=new ArrayList<categoriasVo>();
		DefaultListModel modelo = new DefaultListModel();
		categorias=categoriasDao.mostrarTodasLasCategorias(categorias);
;		
		//Tras guardar las categorias en un ArrayList, las añadimos una a una en un modelo, 
		//para despues asignarlo al JList. 
		if (categorias!=null) {
			for (int i=0; i<categorias.size(); i++) {
				modelo.addElement(categorias.get(i).getNombre());
			}
			ventanaListaCategorias.listaCategorias.setModel(modelo);
		}
		//Si no hay categorias en la BD el JList aparecera vacio.
		else {
			modelo.clear();
			ventanaListaCategorias.listaCategorias.setModel(modelo);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		boolean entradaDatos=false;
		boolean codNumerico=false;
		int codRestaurante=-1;
		ArrayList<restaurantesVo> restaurantes=new ArrayList<restaurantesVo>();
		if (e.getSource()==botonEntrar) {
			
			conexion conexion=new conexion();
			String codRes=textFieldCodRes.getText();
			String password=String.valueOf(passwordField.getPassword());
			String contraseñaCifrada=getMD5(password);
			
			if (comprobarCodRes(codRes)==false) {
				JOptionPane.showMessageDialog(null, "Introduzca un código numérico en la casilla de código de restaurante.","Error",JOptionPane.ERROR_MESSAGE);
				textFieldCodRes.setText("");
				passwordField.setText("");
				codNumerico=false;
			}
			else {
				codRestaurante=Integer.parseInt(codRes);
				codNumerico=true;
			}
			
		

			restaurantes=restaurantesDao.verTodosLosCodRestaurante(restaurantes);	
				
			for (int i=0; i<restaurantes.size(); i++) {
				if(codRestaurante==restaurantes.get(i).getCodRes()) {
					if (contraseñaCifrada.equals(restaurantes.get(i).getClave())) {
						entradaDatos=true;
					}	
				}
				
			}
				
			if ((entradaDatos==true)&&(codNumerico==true)) {
				mostrarTodasLasCategorias();
				coordinador.mostrarVentanaListaCategorias();
				this.setVisible(false);
				codigoRestaurante=codRestaurante;
				textFieldCodRes.setText("");
				passwordField.setText("");
			}
			if ((entradaDatos==false)&&(codNumerico==true)) {
				JOptionPane.showMessageDialog(null, "Datos mal introducidos.","Error",JOptionPane.ERROR_MESSAGE);
				textFieldCodRes.setText("");
				passwordField.setText("");
			}
		}			
	}
	
	public boolean comprobarCodRes(String cod) {
		for (int i=0; i<cod.length(); i++) {
			if (((int)cod.charAt(i)<48)||((int)cod.charAt(i)>57)) {
				return false;
			}
		}
		return true;
	}
	
	private static String getMD5(String input) {
		 try {
			 MessageDigest md = MessageDigest.getInstance("MD5");
			 byte[] messageDigest = md.digest(input.getBytes());
			 BigInteger number = new BigInteger(1, messageDigest);
			 String hashtext = number.toString(16);

		 while (hashtext.length() < 32) {
			 hashtext = "0" + hashtext;
		 }
		 
		 return hashtext;
		 }
		 catch (NoSuchAlgorithmException e) {
			 
			 throw new RuntimeException(e);
		 }
	}
}
