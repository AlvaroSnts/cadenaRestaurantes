package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.SwingConstants;
import controlador.coordinador;
import modelo.conexion.conexion;
import modelo.dao.categoriasDao;
import modelo.vo.categoriasVo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Image;

public class ventanaLogin extends JFrame implements ActionListener {

	private JPanel panel;
	private JFrame frame;
	private JLabel labelTitulo, labelUsuario, labelPassword, labelImagen;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	private JButton botonEntrar;
	private coordinador coordinador;
	public static String[] categoriasString;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	public ventanaLogin() {
		setSize(450, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Login");
		construirPanel();
		setContentPane(panel);
		
		labelTitulo = new JLabel("Los Pollos Hermanos");
		labelTitulo.setBounds(0, 35, 434, 21);
		panel.add(labelTitulo);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTitulo.setForeground(new Color(0, 0, 0));
		labelTitulo.setBackground(Color.BLACK);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Users\\dam211\\eclipse-workspace\\ABP3\\fotos\\SusFring.png"));
		lblNewLabel_1.setBounds(223, 130, 383, 361);
		panel.add(lblNewLabel_1);
	    setLocationRelativeTo(null);
		setVisible(true);
	}

	
	private void construirPanel() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(26, 146, 185));
		panel.setLayout(null);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(157, 87, 115, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		labelUsuario = new JLabel("Usuario:");
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setBounds(0, 62, 434, 14);
		panel.add(labelUsuario);
		
		labelPassword = new JLabel("Password:");
		labelPassword.setHorizontalAlignment(SwingConstants.CENTER);
		labelPassword.setBounds(0, 124, 434, 14);
		panel.add(labelPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 149, 115, 20);
		panel.add(passwordField);
		
		botonEntrar = new JButton("Entrar");
		botonEntrar.setBounds(171, 227, 89, 23);
		botonEntrar.addActionListener(this);
		panel.add(botonEntrar);
		
		labelImagen=new JLabel("");
		labelImagen.setIcon(new ImageIcon("D:\\Users\\dam211\\eclipse-workspace\\ABP3\\fotos\\PollosHermanosLogoPequeno.png"));
		labelImagen.setBounds(69, 0, 65, 88);
		panel.add(labelImagen);
	}
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	public void mostrarTodasLasCategorias(ArrayList<categoriasVo> categorias) {
		String[] categoriasArray=new String[500];
		
		if (categorias!=null) {
			for (int i=0; i<categorias.size(); i++) {
				categoriasArray[i]=categorias.get(i).getNombre();
			}
			ventanaListaCategorias.listaCategorias.setListData(categoriasArray);
		}
		else {
			categoriasArray[0]="Esta vacío";
			ventanaListaCategorias.listaCategorias.setListData(categoriasArray);
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonEntrar) {
			conexion.setLogin(textFieldUsuario.getText());
			conexion.setPassword(String.valueOf(passwordField.getPassword()));
			conexion conexion=new conexion();
			
			if (textFieldUsuario.getText().equals("WalterWhite")&&(String.valueOf(passwordField.getPassword()).equals("heisenberg"))) {
				try {
					Desktop.getDesktop().browse(new URI("http://www.savewalterwhite.com/"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
			else {
				if (textFieldUsuario.getText().equals("GusFring")&&(String.valueOf(passwordField.getPassword()).equals("sus"))) {
					try {
						Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=B9RgougnhiE"));
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
				else {
					if (conexion.conectarBD()==null) {
						JOptionPane.showMessageDialog(null, "Error en la introduccion de datos. Intentelo de nuevo","Error",JOptionPane.ERROR_MESSAGE);
						textFieldUsuario.setText("");
						passwordField.setText("");
					}
					else {
						coordinador.mostrarVentanaListaCategorias();
						coordinador.getLogica().validarMostrarTodasLasCategorias();
						this.setVisible(false);
						textFieldUsuario.setText("");
						passwordField.setText("");
					}
				}
			}
		}
	}
}
