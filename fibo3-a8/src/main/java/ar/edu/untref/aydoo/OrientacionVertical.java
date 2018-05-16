package ar.edu.untref.aydoo;

import java.util.List;

public class OrientacionVertical extends Orientacion {

	public OrientacionVertical(List<Integer> listaNumeros, String orientacion, String formatoSalida, int numeroSucesiones) {
		super(listaNumeros, orientacion, formatoSalida, numeroSucesiones);
	}

	@Override
	public String aplicarOrientacion() {
		if(this.orientacion.equals("v")) {
			this.cadenaSalida = this.cadenaSalida + this.aplicarOrientacionVertical(this.listaNumeros);
			return this.cadenaSalida;
		} else {
			return "Opciones no validas";
		}
	}

	private String aplicarOrientacionVertical(List<Integer> listaNumeros) {
		String respuestaGenerada = "";
		for(int i = 0; i < listaNumeros.size(); i++){
			respuestaGenerada = respuestaGenerada + "\r\n" +  listaNumeros.get(i).toString();
		}	
		return respuestaGenerada;
	}
}
