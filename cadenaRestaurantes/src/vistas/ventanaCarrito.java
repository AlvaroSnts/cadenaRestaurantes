package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controlador.coordinador;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class ventanaCarrito extends JFrame implements ActionListener {

	private JPanel panel;
	private JFrame frame;
	private JLabel labelTitulo;
	private coordinador coordinador;
	private JButton btnConfirmaPedido;
	private JButton btnVolver;
	private JList <String> list;
	public ventanaCarrito() {
		setSize(950, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Carrito");
		construirPanel();
		setContentPane(panel);
		btnConfirmaPedido = new JButton("Confirma pedido");
		btnConfirmaPedido.setBounds(805, 599, 119, 51);
		panel.add(btnConfirmaPedido);
		btnConfirmaPedido.addActionListener(this);
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 599, 119, 51);
		panel.add(btnVolver);
		btnVolver.addActionListener(this);
		list = new JList<String>();
		list.setBounds(153, 213, 636, 356);
		panel.add(list);
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		list.setModel(modelo);
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
		labelTitulo.setBounds(289, 84, 345, 81);
		panel.add(labelTitulo);
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
	}
}
