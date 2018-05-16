package ar.edu.untref.aydoo;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Assert;

import org.junit.Test;

public class TestIntegracion {

	@Test
	public void resultadoDeberiaSer0_1_1_2_3Para5() throws Exception{
		String[] cadena = {"5"};
		SucesionFibo sucesion = new SucesionFibo(cadena);
		String valorEsperado = "fibo<5>: 0 1 1 2 3 ";
		
		sucesion.generarRespuesta();
		String valorObtenido = sucesion.getRespuesta();
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void resultadoDeberiaSer0_1_1_2_3_5_8_13Para8() throws Exception{
		String[] cadena = {"8"};
		SucesionFibo sucesion = new SucesionFibo(cadena);	
		String valorEsperado = "fibo<8>: 0 1 1 2 3 5 8 13 ";
		
		sucesion.generarRespuesta();
		String valorObtenido = sucesion.getRespuesta();
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void resultadoDeberiaSerEnVerticalyDirectoCandoSeIngresaVD() throws Exception {
		String[] cadena = {"-o=vd", "5"};
		SucesionFibo sucesion = new SucesionFibo(cadena);	
		String valorEsperado = "fibo<5>: " + "\r\n"
										+ "0" + "\r\n"
										+ "1" + "\r\n"
										+ "1" + "\r\n"
										+ "2" + "\r\n"
										+ "3" ;

		sucesion.generarRespuesta();
		String valorObtenido = sucesion.getRespuesta();
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void resultadoDeberiaSerEnVerticalyIndirectoCuandoSeIngresaVI() throws Exception {
		String[] cadena = {"-o=vi", "5"};
		SucesionFibo sucesion = new SucesionFibo(cadena);	
		String valorEsperado = "fibo<5>: " + "\r\n"
										+ "3" + "\r\n"
										+ "2" + "\r\n"
										+ "1" + "\r\n"
										+ "1" + "\r\n"
										+ "0" ;

		sucesion.generarRespuesta();
		String valorObtenido = sucesion.getRespuesta();

		Assert.assertEquals(valorEsperado, valorObtenido);
	}	

	@Test
	public void resultadoDeberiaSerEnHorizontalyIndirectoCuandoSeIngresaHI() throws Exception {
		String[] cadena = {"-o=hi", "5"};
		SucesionFibo sucesion = new SucesionFibo(cadena);	
		String valorEsperado = "fibo<5>: 3 2 1 1 0 ";

		sucesion.generarRespuesta();
		String valorObtenido = sucesion.getRespuesta();		

		Assert.assertEquals(valorEsperado, valorObtenido);
	}	

	@Test
	public void deberiaDevolverOpcionesNoValidasCuandoSeIngresa_K_ComoDireccion() throws Exception {
		String[] cadena = {"-o=hk", "5"};
		SucesionFibo sucesion = new SucesionFibo(cadena);	
		String valorEsperado = "Opciones no validas";

		sucesion.generarRespuesta();
		String valorObtenido = sucesion.getRespuesta();
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void deberiaDevolverOpcionesNovalidasCuandoSeIngresa_U_ComoOrientacion() throws Exception {
		String[] cadena = {"-o=ud", "5"};
		SucesionFibo sucesion = new SucesionFibo(cadena);	
		String valorEsperado = "Opciones no validas";

		sucesion.generarRespuesta();
		String valorObtenido = sucesion.getRespuesta();
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void resultadoDeberiaSerEnHorizontalyIndirectoEnUnArchivoCuandoSeIngresaHI_Y_F() throws Exception {
		String[] cadena = {"-o=hi", "-f=target/test1.txt", "5"};
		SucesionFibo sucesion = new SucesionFibo(cadena);	
		String valorEsperado = "fibo<5>: 3 2 1 1 0 ";

		sucesion.generarRespuesta();
		FileReader f = new FileReader("target/test1.txt");
	    BufferedReader b = new BufferedReader(f);
	    String valorObtenido = b.readLine();
	    
	    b.close();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void resultadoDeberiaSerSumatoriaDe5CuandoSeIngresaFuncionamiento_s() throws Exception {
		String[] cadena = {"-o=hi", "-m=s", "5"};
		SucesionFibo sucesion = new SucesionFibo(cadena);	
		String valorEsperado = "fibo<5>s: 7 ";

		sucesion.generarRespuesta();
		String valorObtenido = sucesion.getRespuesta();		

		Assert.assertEquals(valorEsperado, valorObtenido);
	}	
	
	@Test
	public void resultadoDeberiaSerSumatoriaDe5CuandoSeIngresaFuncionamientoS_Y_SalidaF() throws Exception {
		String[] cadena = {"-o=hi", "-f=target/test1.txt", "-m=s", "5"};
		SucesionFibo sucesion = new SucesionFibo(cadena);	
		String valorEsperado = "fibo<5>s: 7 ";

		sucesion.generarRespuesta();
		FileReader f = new FileReader("target/test1.txt");
	    BufferedReader b = new BufferedReader(f);
	    String valorObtenido = b.readLine();
	    
	    b.close();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void resultadoDeberiaSerEnHorizontal_Indirecto_Lista_FormatoHI_yFuncionalidadL() throws Exception {
		String[] cadena = {"-o=hi", "-m=l","5"};
		SucesionFibo sucesion = new SucesionFibo(cadena);	
		String valorEsperado = "fibo<5>: 3 2 1 1 0 ";

		sucesion.generarRespuesta();
		String valorObtenido = sucesion.getRespuesta();		

		Assert.assertEquals(valorEsperado, valorObtenido);
	}
}
