package ar.edu.untref.aydoo;

import java.util.List;

public class Entrada {
	
	private String[] cadena;
	private String orientacion;
	private String direccion;
	private int numero;
	private String formatoSalida;
	private String funcionamiento;

	public Entrada(String cadenaEntrada[]) {
		this.cadena = cadenaEntrada;
		this.orientacion = "h";
		this.direccion = "d";
		this.formatoSalida = "";
		this.funcionamiento = "l";
	}
	
	public void procesarParametros() throws Exception {
		this.setNumero();
		this.setFormato();
		this.setFormatoSalida();
		this.setFuncionamiento();
	}
	
	private void setNumero() throws Exception {
		String argumento;
		argumento = this.cadena[this.cadena.length-1];
		try {
			this.numero = Integer.parseInt(argumento);
		} catch (Exception e) {
	       	throw new Exception("Debe introducir el numero de suceciones");
		}
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	private void setFormato() throws Exception {
		String formato;
		for(int i = 0; i< this.cadena.length; i++) {
			formato = this.cadena[i];
			if(formato.contains("-o=")) {
				this.orientacion = formato.substring(3,4);
				this.direccion = formato.substring(4,5);
				if(!this.direccion.equals("d") && !this.direccion.equals("i")) {
					this.direccion = "Opciones no validas";
				}
			}
		}
	}
	
	public String getOrientacion() {
		return this.orientacion;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	private void setFormatoSalida() throws Exception {
		String salida;
		for(int i = 0; i< this.cadena.length; i++) {
			salida = this.cadena[i];
			if(salida.contains("-f=")) {
				this.formatoSalida = salida;
			}
		}
	}
	
	public String getFormatoSalida() {
		return this.formatoSalida;
	}
	
	public void setFuncionamiento() {
		String funcionamientoIngresado;
		for(int i = 0; i< this.cadena.length; i++) {
			funcionamientoIngresado = this.cadena[i];
			if(funcionamientoIngresado.contains("-m=")) {
				this.funcionamiento = funcionamientoIngresado.substring(3);
			}
		}
	}
	
	public String getFuncionamiento() {
		return this.funcionamiento;
	}

	public Funcionamiento instanciarFuncionamiento() {
		switch (funcionamiento) {
			case "l":
				return new FuncionamientoLista(numero,funcionamiento);
			case "s":
				return new FuncionamientoLista(numero,funcionamiento);
			default:
				System.out.println("no deberia pasar");
				return new FuncionamientoLista(numero,funcionamiento);
		}
	}

	public Orientacion instanciarOrientacion(List<Integer> listaNumeros) {
		switch (funcionamiento) {
			case "h":
				return new OrientacionHorizontal(listaNumeros, orientacion, funcionamiento, numero);
			case "p":
				return new OrientacionHorizontal(listaNumeros, orientacion, funcionamiento, numero);
			case "v":
				return new OrientacionHorizontal(listaNumeros, orientacion, funcionamiento, numero);
			default:
				System.out.println("no deberia pasar");
				return new OrientacionHorizontal(listaNumeros, orientacion, funcionamiento, numero);
		}
	}

	public Direccion instanciarDireccion(List<Integer> listaNumeros) {
		switch (direccion) {
			case "d":
				return new DireccionDirecta(listaNumeros, direccion);
			case "i":
				return new DireccionDirecta(listaNumeros, direccion);
			default:
				System.out.println("no deberia pasar");
				return new DireccionDirecta(listaNumeros, direccion);
		}
	}
}
