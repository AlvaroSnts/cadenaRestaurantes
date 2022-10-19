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
import javax.swing.JList;

public class ventanaCarrito extends JFrame implements ActionListener {

	private JPanel panel;
	private JFrame frame;
	private JLabel labelTitulo;
	private coordinador coordinador;
	private JButton btnConfirmaPedido;
	private JList list;

	
	public ventanaCarrito() {
		setSize(950, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Carrito");
		construirPanel();
		setContentPane(panel);
		setResizable(false);
		btnConfirmaPedido = new JButton("Confirma pedido");
		btnConfirmaPedido.setBounds(805, 599, 119, 51);
		panel.add(btnConfirmaPedido);
		
		list = new JList();
		list.setBounds(173, 212, 618, 329);
		panel.add(list);
	    setLocationRelativeTo(null);
		setVisible(false);
	}

	private void construirPanel() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setVisible(false);
		panel.setBackground(new Color(0, 0, 0));
		panel.setLayout(null);
		
		labelTitulo = new JLabel("Carrito:");
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setBackground(new Color(255, 255, 255));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 50));
		labelTitulo.setBounds(196, 52, 574, 157);
		panel.add(labelTitulo);
	}
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
