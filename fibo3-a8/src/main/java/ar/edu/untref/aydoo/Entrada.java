package ar.edu.untref.aydoo;

import java.util.List;

public class Entrada {
	
	private String[] cadena;
	private String orientacion;
	private String direccion;
	private int numero;
	private String formatoSalida;
	private String funcionamiento;
	private String paridad;

	public Entrada(String cadenaEntrada[]) {
		this.cadena = cadenaEntrada;
		this.orientacion = "h";
		this.direccion = "d";
		this.formatoSalida = "";
		this.funcionamiento = "l";
		this.paridad = "t";
	}
	
	public void procesarParametros() throws Exception {
		this.setNumero();
		this.setFormato();
		this.setFormatoSalida();
		this.setFuncionamiento();
		this.setParidad();
	}

	private void setParidad() {
		for(String comandoActual:cadena) {
			if(comandoActual.contains("-n=") ) {
				if(comandoActual.charAt(3) == 'p'){
					System.out.println("entro en paridad");
					this.paridad = "p";
				}else{
					this.paridad = "Opciones no validas";
				}
			}
		}
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
					System.out.println("este2");
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
			case "s":
				return new FuncionamientoSumatoria(numero,funcionamiento);
			case "l":
				return new FuncionamientoLista(numero,funcionamiento);
			default:
				System.out.println("no deberia pasar");
				return new FuncionamientoLista(numero,funcionamiento);
		}
	}

	public Orientacion instanciarOrientacion(List<Integer> listaNumeros) {
		System.out.println("funcionamiento " + orientacion);
		switch (orientacion) {
			case "p":
				return new OrientacionProgresiva(listaNumeros, orientacion, funcionamiento, numero);
			case "v":
				return new OrientacionVertical(listaNumeros, orientacion, funcionamiento, numero);
			case "h":
				return new OrientacionHorizontal(listaNumeros, orientacion, funcionamiento, numero);
			default:
				System.out.println("no deberia pasar orientacion");
				return new OrientacionHorizontal(listaNumeros, orientacion, funcionamiento, numero);
		}
	}

	public Direccion instanciarDireccion(List<Integer> listaNumeros) {
		switch (direccion) {
			case "i":
				return new DireccionInversa(listaNumeros, direccion);
			case "d":
				return new DireccionDirecta(listaNumeros, direccion);
			default:
				System.out.println("no deberia pasar");
				return new DireccionDirecta(listaNumeros, direccion);
		}
	}

	public Paridad instanciarParidad(List<Integer> listaNumeros) {
		Paridad devuelto = new Paridad(listaNumeros);
		switch (paridad) {
			case "p":
				devuelto = new ParidadPar(listaNumeros);
				break;
			case "t":
				devuelto = new Paridad(listaNumeros);
				break;
			default:
				System.out.println("no deberia pasar paridad");
		}
		return  devuelto;
	}


}
