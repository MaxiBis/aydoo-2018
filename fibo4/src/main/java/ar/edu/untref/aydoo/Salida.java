package ar.edu.untref.aydoo;

import java.io.IOException;

public abstract class Salida {
	private String cadenaSalida;
	private String formatoSalida;
	protected Salida salidaSiguiente;

	public Salida(String cadena, String formatoSalidaIngresado) {
		this.cadenaSalida = cadena;
		this.formatoSalida = formatoSalidaIngresado;
	}

	public abstract void aplicarSalida() throws IOException;
	
	protected String getCadenaSalida() {
		return this.cadenaSalida;
	}
	
	protected String getFormatoSalida() {
		return this.formatoSalida;
	}
	
	public void setSiguienteSalida(Salida salida) {
		this.salidaSiguiente = salida;
	}
	
	public Salida getSiguienteSalida() {
		return this.salidaSiguiente;
	}
}
