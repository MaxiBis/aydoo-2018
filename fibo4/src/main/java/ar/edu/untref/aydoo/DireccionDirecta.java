package ar.edu.untref.aydoo;

import java.util.List;

public class DireccionDirecta extends Direccion{
	
	public DireccionDirecta(List<Integer> listaNumerosIngresada, String direccionIngresada) {
		super(listaNumerosIngresada, direccionIngresada);
	}

	@Override
	public List<Integer> aplicarDireccion() {
		return this.listaNumeros;
	}
	
}
