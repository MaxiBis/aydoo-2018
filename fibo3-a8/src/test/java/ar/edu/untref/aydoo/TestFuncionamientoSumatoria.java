package ar.edu.untref.aydoo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import excepciones.ExcepcionFuncionamientoInvalido;

public class TestFuncionamientoSumatoria {
	
	@Test
	public void calcularLaSumatoriaDeLaListaNumerosDeberiaDevolver7() {
		List<Integer> listaNumeros = new LinkedList<Integer>();
		listaNumeros.addAll(Arrays.asList(0, 1, 1, 2, 3));
		Funcionamiento calculador = new FuncionamientoSumatoria(5, "s");
		List <Integer> valorEsperado = new LinkedList<Integer>();
		valorEsperado.add(7);
		
		calculador.aplicarFuncionamiento(listaNumeros);
		List<Integer> valorObtenido = calculador.getListaNumeros();
		
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	/*
	@Test
	public void siSeIntroduceComoParametroDeFuncionamiento_z_DeberiaDevolverExcepcion() {
		Funcionamiento calculador = new FuncionamientoSumatoria(5, "s");

		try {
			calculador.aplicarFuncionamiento(listaNumeros);
	    }catch (ExcepcionFuncionamientoInvalido e){

	    }	
	}*/

}
