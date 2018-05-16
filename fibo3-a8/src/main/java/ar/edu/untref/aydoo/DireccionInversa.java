package ar.edu.untref.aydoo;

import java.util.Collections;
import java.util.List;

public class DireccionInversa extends Direccion {

	public DireccionInversa(List<Integer> listaNumerosIngresada, String direccionIngresada) {
		super(listaNumerosIngresada, direccionIngresada);
	}

	@Override
	public List<Integer> aplicarDireccion() {
		if(this.direccion.equals("i")) {
			Collections.reverse(listaNumeros);
		}
		return this.listaNumeros;
	}
	
}
