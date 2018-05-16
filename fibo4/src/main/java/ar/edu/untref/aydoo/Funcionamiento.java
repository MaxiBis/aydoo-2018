package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public abstract class Funcionamiento {
	protected Funcionamiento siguienteFuncionamiento;
	protected String funcionamiento;
	protected List<Integer> listaNumeros;
	protected int numeroSucesiones;
		
	public Funcionamiento(int numeroSucesionesIngresado, String funcionamientoIngresado) {
		this.funcionamiento = funcionamientoIngresado;
		this.numeroSucesiones = numeroSucesionesIngresado;
		this.listaNumeros = this.calcularSucesion(numeroSucesionesIngresado);
	}
		
	public abstract List<Integer> aplicarFuncionamiento(List<Integer> listaNumeros);
		
	protected void setSiguienteFuncionamiento(Funcionamiento funcionamientoIngresado) {
		this.siguienteFuncionamiento = funcionamientoIngresado;
	}
		
	protected Funcionamiento getSiguienteFuncionamiento() {
		return this.siguienteFuncionamiento;
	}
	
	public List<Integer> getListaNumeros() {
		return this.listaNumeros;
	}
	
	protected void setListaNumeros(List<Integer> listaNumerosIngresada){
		this.listaNumeros = listaNumerosIngresada;
	}
	
	private List<Integer> calcularSucesion(int numeroSuceciones){
		int numero1 = 0;
		int numero2 = 1;
		int total = 0;	
		List<Integer> listaDeNumeros = new LinkedList<Integer>();
		listaDeNumeros.add(numero1);
 		if(numeroSuceciones >= 1){
 			numeroSuceciones = numeroSuceciones -1;
 			listaDeNumeros.add(numero2);
 			for(int i = 1; i < numeroSuceciones; i++ ){
				total = numero1 + numero2;
				numero1 = numero2;
				numero2 = total;
				listaDeNumeros.add(total);
			}
		}
 		return listaDeNumeros;
	}
	
}