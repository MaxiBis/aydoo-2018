package ar.edu.untref.aydoo;

import java.util.List;

public class OrientacionProgresiva extends Orientacion {

    public OrientacionProgresiva(List<Integer> listaNumeros, String orientacion, String formatoSalida, int numeroSucesiones) {
        super(listaNumeros, orientacion, formatoSalida, numeroSucesiones);
    }

    @Override
    public String aplicarOrientacion() {
        if(this.orientacion.equals("p")) {
            this.cadenaSalida = this.cadenaSalida + this.aplicarOrientacionProgresiva(this.listaNumeros);
            return this.cadenaSalida;
        } else {
            return "Opciones no validas";
        }
    }

    private String aplicarOrientacionProgresiva(List<Integer> listaNumeros) {
        String respuestaGenerada = "\r\n";
        String respuestaLinea = "";
        for(int nroIterado : listaNumeros){
            respuestaLinea += nroIterado + " ";
            respuestaGenerada +=  respuestaLinea + "\r\n";
        }
        return respuestaGenerada;
    }
}
