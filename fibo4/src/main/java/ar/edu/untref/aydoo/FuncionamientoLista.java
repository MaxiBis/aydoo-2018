package ar.edu.untref.aydoo;

import java.util.List;

public class FuncionamientoLista extends Funcionamiento{
	
	public FuncionamientoLista(int numeroSucesiones, String funcionamientoIngresado) {
		super(numeroSucesiones, funcionamientoIngresado);
		this.siguienteFuncionamiento = new FuncionamientoSumatoria(numeroSucesiones, funcionamientoIngresado);
	}

	@Override
	public List<Integer> aplicarFuncionamiento(List<Integer> listaNumeros) {
		return listaNumeros;
	}	
	
}
