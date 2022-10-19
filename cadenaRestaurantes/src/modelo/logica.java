package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.coordinador;
import modelo.dao.categoriasDao;
import modelo.vo.categoriasVo;

public class logica {
	
	private coordinador coordinador;
	
	public void setCoordinador(coordinador coordinador) {
		this.coordinador=coordinador;
	}
	
	public void validarMostrarTodasLasCategorias(){
		categoriasDao categoria=new categoriasDao();
		ArrayList<categoriasVo> categorias=new ArrayList<categoriasVo>();
		
		categorias=categoria.mostrarTodasLasCategorias(categorias);
		
		if (categorias == null) {
			JOptionPane.showMessageDialog(null,"No hay clientes","Advertencia",JOptionPane.WARNING_MESSAGE);
		}else {
			coordinador.mostrarTodasLasCategorias(categorias);
		}

	}
}
