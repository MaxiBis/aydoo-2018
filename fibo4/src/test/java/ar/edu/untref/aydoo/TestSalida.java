package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class TestSalida {
	
	@Test
	public void salidaPorConsolaDeberiaDevolverElStringFinal() throws IOException {
		String cadena = "fibo<8>: 0 1 1 2 3 5 8 13 ";
		String salidaSolicitada = "";
		Salida salida = new SalidaArchivo(cadena, salidaSolicitada);
		String valorEsperado = "fibo<8>: 0 1 1 2 3 5 8 13 ";
		
		salida.aplicarSalida();
		String valorObtenido = salida.getCadenaSalida();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void salidaArchivoDeberiaCrearArchivoEInsertarContenidoDeCadena() throws IOException {
		String cadena = "fibo<8>: 0 1 1 2 3 5 8 13 ";
		String salidaSolicitada = "-f=target/salida3.txt";
		Salida salida = new SalidaArchivo(cadena, salidaSolicitada);
		String valorEsperado = "fibo<8>: 0 1 1 2 3 5 8 13 ";
		
		salida.aplicarSalida();
		FileReader f = new FileReader("target/salida3.txt");
	    BufferedReader b = new BufferedReader(f);
	    String valorActual = b.readLine();
	    
	    b.close();
		
		assertEquals(valorEsperado, valorActual);
	}

}
