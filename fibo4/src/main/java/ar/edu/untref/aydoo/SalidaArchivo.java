package ar.edu.untref.aydoo;

import java.io.FileWriter;
import java.io.IOException;

public class SalidaArchivo extends Salida{
	
	String directorio;

	public SalidaArchivo(String cadenaSalida, String salidaSolicitadaIngresada) {
		super(cadenaSalida, salidaSolicitadaIngresada);
		this.salidaSiguiente = new SalidaConsola(cadenaSalida, salidaSolicitadaIngresada);
	}

	@Override
	public void aplicarSalida() throws IOException {
		this.setSiguienteSalida(this.salidaSiguiente);
		String formatoSalida = this.getFormatoSalida();
		if(formatoSalida.contains("-f=")) {
			this.directorio  = this.getDirectorio(this.getFormatoSalida());
			this.imprimirCadenaPorConsola(this.getCadenaSalida(), this.directorio);
			this.escribirArchivo(directorio, this.getCadenaSalida());
		} else {
			this.getSiguienteSalida().aplicarSalida();
		}
	}
	
	private void escribirArchivo(String directorio, String texto) throws IOException {
		FileWriter fichero = null;
        fichero = new FileWriter(directorio);
        fichero.write(texto);
	    fichero.close();
	}
	
	private String getDirectorio(String cadena) {
		return cadena.substring(3, cadena.length());
	}
	
	private String imprimirCadenaPorConsola(String cadenaSalida, String directorio) {
		String cadena = cadenaSalida.substring(0, 7) + " guardado en " + directorio;
		System.out.println(cadena);
		return cadena;
	}

}
