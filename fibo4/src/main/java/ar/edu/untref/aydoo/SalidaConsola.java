package ar.edu.untref.aydoo;

import java.io.IOException;

public class SalidaConsola extends Salida{	

	public SalidaConsola(String cadena, String salidaSolcitadaIngersada) {
		super(cadena, salidaSolcitadaIngersada);
	}

	@Override
	public void aplicarSalida() throws IOException {
		this.imprimirEnConsola();
	}

	private String imprimirEnConsola() {
		System.out.println(getCadenaSalida());
		return this.getCadenaSalida();
	}
}
