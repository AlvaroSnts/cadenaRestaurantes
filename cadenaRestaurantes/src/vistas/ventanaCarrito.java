package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controlador.coordinador;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class ventanaCarrito extends JFrame implements ActionListener {

	private JPanel panel;
	private JFrame frame;
	private JLabel labelTitulo;
	private coordinador coordinador;

	
	public ventanaCarrito() {
		setSize(450, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Carrito");
		construirPanel();
		setContentPane(panel);
	    setLocationRelativeTo(null);
		setVisible(false);
	}

	private void construirPanel() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		labelTitulo = new JLabel("Carrito:");
		labelTitulo.setBounds(178, 21, 66, 28);
		panel.add(labelTitulo);
	}
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
