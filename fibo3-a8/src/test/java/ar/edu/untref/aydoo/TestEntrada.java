package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TestEntrada {
	
	@Test
	public void getNumeroDeberiaDevolverNumero8() throws Exception {
		String[] cadena = {"8"};
		Entrada entrada = new Entrada(cadena);
		entrada.procesarParametros();
		
		int valorObtenido = entrada.getNumero();
		int valorEsperado = 8;
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void getNumeroDeberiaDevoverExcepcionCuandoEnLaCadenaNoHayNumeros() throws Exception {
		String[] cadena = {"a"};
		Entrada entrada = new Entrada(cadena);
		
		try {
			 entrada.getNumero();
	    }catch (Exception e){

	    }
	}
	
	@Test
	public void getOrientacionDeberiaDevolverHCuandoSeIngresaHD() throws Exception {
		String[] cadena = {"-o=hd" , "5"};
		Entrada entrada = new Entrada(cadena);
		String valorEsperado = "h";
		entrada.procesarParametros();
		
		String valorObtenido = entrada.getOrientacion();
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void getDirecionDeberiaDevolverDCuandoSeIngresaHD() throws Exception {
		String[] cadena = {"-o=hd" , "34"};
		Entrada entrada = new Entrada(cadena);
		String valorEsperado = "d";
		entrada.procesarParametros();
		
		String valorObtenido = entrada.getDireccion();
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void getOrientacionYDireccionDeberiaDevolverHDCuandoNoSeIngresaFormato() throws Exception {
		String[] cadena = {"44"};
		Entrada entrada = new Entrada(cadena);
		String valorEsperadoD = "d";
		String valorEsperadoO = "h";
		entrada.procesarParametros();
		
		String valorObtenidoD = entrada.getDireccion();
		String valorObtenidoO = entrada.getOrientacion();
		
		Assert.assertEquals(valorEsperadoD, valorObtenidoD);
		Assert.assertEquals(valorEsperadoO, valorObtenidoO);
	}
	
	@Test
	public void getDirecionDeberiaDevolverDCuandoNoSeIngresaFormato() throws Exception {
		String[] cadena = {"34"};
		Entrada entrada = new Entrada(cadena);
		String valorEsperado = "d";
		entrada.procesarParametros();
		
		String valorObtenido = entrada.getDireccion();
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
}
