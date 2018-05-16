package ar.edu.untref.aydoo;

import java.util.List;

public class OrientacionHorizontal extends Orientacion{
	private Orientacion orientacionSiguiente;
	
	public OrientacionHorizontal(List<Integer> listaNumerosIngresada, String orientacionIngresada, String formatoSalida, int numeroSucesiones) {
		super(listaNumerosIngresada, orientacionIngresada, formatoSalida, numeroSucesiones);
		this.orientacionSiguiente = new OrientacionVertical(listaNumerosIngresada, orientacionIngresada, formatoSalida, numeroSucesiones);
	}

	@Override
	public String aplicarOrientacion() {
		this.setSiguienteOrientacion(this.orientacionSiguiente);
		if(this.orientacion.equals("") || this.orientacion.equals("h")) {
			this.cadenaSalida = this.cadenaSalida + this.aplicarOrientacionHorizontal(this.listaNumeros);
			return this.cadenaSalida;
		} else {
			return this.getSiguienteOrientacion().aplicarOrientacion();
		}
	}
	
	private String aplicarOrientacionHorizontal(List<Integer> listaNumeros) {
		String respuestaGenerada = "";
		for(int i = 0; i < listaNumeros.size(); i++){
			respuestaGenerada = respuestaGenerada + listaNumeros.get(i).toString() + " ";
		}
		return respuestaGenerada;
	}
}
