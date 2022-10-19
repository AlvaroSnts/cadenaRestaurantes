package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controlador.coordinador;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ventanaProductosCategoria extends JFrame implements ActionListener {

	private JPanel panel;
	private JFrame frame;
	private JLabel labelTitulo;
	private coordinador coordinador;
	private JButton Carrito;


	public ventanaProductosCategoria() {
		setSize(950, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Categoria");
		construirPanel();
		setContentPane(panel);
		setResizable(false);
		Carrito = new JButton("Volver");
		Carrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Carrito.setBounds(10, 599, 119, 51);
		panel.add(Carrito);
		
		JButton Carrito_1 = new JButton("Carrito");
		Carrito_1.setBounds(805, 599, 119, 51);
		panel.add(Carrito_1);
	    setLocationRelativeTo(null);
		setVisible(false);
	}

	private void construirPanel() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setLayout(null);
		
		labelTitulo = new JLabel("Productos de la categoria:");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setBounds(252, 100, 431, 100);
		panel.add(labelTitulo);
	}
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
