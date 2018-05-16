package ar.edu.untref.aydoo;

import java.util.List;

public class SucesionFibo {
	private Entrada entrada;
	private Orientacion orientacion;
	private Direccion direccion;
	private Salida salida;
	private Funcionamiento funcionamiento;
	private Paridad paridad;
	private String respuesta;
	
	public SucesionFibo(String[] arg){
		this.entrada = new Entrada(arg);
	}

	public void generarRespuesta() throws Exception{
		this.respuesta = "Opciones no validas";
		this.entrada.procesarParametros();
		if(!this.entrada.getDireccion().equals("Opciones no validas")){
			//Integer cantidadSucesiones = this.entrada.getNumero();
			//String funcionamientoIngresado = this.entrada.getFuncionamiento();
			this.funcionamiento = entrada.instanciarFuncionamiento();
			List<Integer> listaNumeros = this.funcionamiento.getListaNumeros();
			this.paridad = entrada.instanciarParidad(listaNumeros);
			listaNumeros = paridad.mostrarFiltrados();
			listaNumeros = this.funcionamiento.aplicarFuncionamiento(listaNumeros);
			this.direccion = entrada.instanciarDireccion(listaNumeros);
			this.direccion.aplicarDireccion();
			this.orientacion = entrada.instanciarOrientacion(listaNumeros);
			this.respuesta = this.orientacion.aplicarOrientacion();
			this.salida = new SalidaArchivo(respuesta, entrada.getFormatoSalida());
			this.salida.aplicarSalida();
		}else{
			System.out.println("Opciones no validas");
		}
	}
	
	public String getRespuesta() {
		return this.respuesta;
	}
}
