package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.coordinador;
import modelo.dao.categoriasDao;
import modelo.dao.productosDao;
import modelo.vo.categoriasVo;
import modelo.vo.productosVo;

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
	
	public void validarMostrarTodosLosProductosCategoria(){
		productosDao producto=new productosDao();
		ArrayList<productosVo> productos=new ArrayList<productosVo>();
		
		productos=producto.mostrarTodosLosProductosCategoria(productos);
		
		if (productos == null) {
			JOptionPane.showMessageDialog(null,"No hay clientes","Advertencia",JOptionPane.WARNING_MESSAGE);
		}else {
			coordinador.mostrarTodosLosProductosCategoria(productos);
		}
	}
	
	
	public void validarMostrarCategoriaPorNombre(){
		categoriasDao categoria=new categoriasDao();
		ArrayList<categoriasVo> categorias=new ArrayList<categoriasVo>();
		
		categorias=categoria.mostrarCategoriaPorNombre(categorias);
		
		if (categorias == null) {
			JOptionPane.showMessageDialog(null,"No hay clientes","Advertencia",JOptionPane.WARNING_MESSAGE);
		}else {
			coordinador.mostrarCategoriaPorNombre(categorias);
		}
	}
}
