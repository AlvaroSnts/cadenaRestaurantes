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


public class ventanaLogin extends JFrame implements ActionListener {

	private JPanel panel;
	private JFrame frame;
	private JLabel labelTitulo, labelUsuario, labelPassword, labelImagen, labelSusFring, labelMike;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	private JButton botonEntrar;
	private coordinador coordinador;
	public static String[] categoriasString;
	
	public ventanaLogin() {
		setSize(450, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Iniciar sesión");
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
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(157, 87, 115, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		labelUsuario = new JLabel("Usuario:");
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setBounds(0, 62, 434, 14);
		panel.add(labelUsuario);
		
		labelPassword = new JLabel("Contraseña:");
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
		
		labelMike = new JLabel("");
		labelMike.setIcon(new ImageIcon(getClass().getResource("/fotos/waltermeme.jpg")));
		labelMike.setBounds(0, 263, 161, 108);
		panel.add(labelMike);
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
						mostrarTodasLasCategorias();
						coordinador.mostrarVentanaListaCategorias();
						this.setVisible(false);
						textFieldUsuario.setText("");
						passwordField.setText("");
					}
				}
			}
		}
	}
}
