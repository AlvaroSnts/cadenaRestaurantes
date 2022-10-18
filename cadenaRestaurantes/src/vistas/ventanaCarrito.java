package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controlador.coordinador;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ventanaCarrito extends JFrame implements ActionListener {

	private JPanel panel;
	private JFrame frame;
	private JLabel labelTitulo;
	private coordinador coordinador;
	private JButton btnConfirmaPedido;

	
	public ventanaCarrito() {
		setSize(720, 520);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Carrito");
		construirPanel();
		setContentPane(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 151, 408, 233);
		panel.add(scrollPane);
		
		btnConfirmaPedido = new JButton("Confirma pedido");
		btnConfirmaPedido.setBounds(605, 419, 119, 51);
		panel.add(btnConfirmaPedido);
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
		
		labelTitulo = new JLabel("Carrito:");
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setBackground(new Color(255, 255, 255));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelTitulo.setBounds(193, 38, 345, 81);
		panel.add(labelTitulo);
	}
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
