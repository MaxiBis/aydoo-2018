package ar.edu.untref.aydoo;

import java.util.List;

public abstract class Orientacion {
	private Orientacion orientacionSiguiente;
	protected String orientacion;
	protected List<Integer> listaNumeros;
	protected String cadenaSalida;
	
	public Orientacion(List<Integer> listaNumerosIngresada, String orientacionIngresada, String formatoSalida, int numeroSucesiones) {
		this.orientacion = orientacionIngresada;
		this.listaNumeros = listaNumerosIngresada;
		this.cadenaSalida = this.seleccionarCadenaSalida(formatoSalida, listaNumerosIngresada, numeroSucesiones);
	}
	
	public abstract String aplicarOrientacion();
	
	protected void setSiguienteOrientacion(Orientacion orientacionIngresado) {
		this.orientacionSiguiente = orientacionIngresado;
	}
	
	protected Orientacion getSiguienteOrientacion() {
		return this.orientacionSiguiente;
	}
	
	private String seleccionarCadenaSalida(String funconamientoSeleccionado, List<Integer> listaNumeros, int numeroSucesiones) {
		String cadena;
		if(funconamientoSeleccionado.contains("s")) {
			cadena = "fibo<" + numeroSucesiones + ">s: ";
		} else {
			cadena = "fibo<" + numeroSucesiones + ">: ";
		}
		return cadena;
	}
}
