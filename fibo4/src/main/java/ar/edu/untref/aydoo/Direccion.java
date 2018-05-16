package ar.edu.untref.aydoo;

import java.util.List;

public abstract class Direccion {
	protected String direccion;
	protected List<Integer> listaNumeros;
		
	public Direccion(List<Integer> listaNumerosIngresada, String direccionIngresada) {
		this.direccion = direccionIngresada;
		this.listaNumeros = listaNumerosIngresada;
	}
		
	public abstract List<Integer> aplicarDireccion();

}
