package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public abstract class Barco {
    protected List<Posicion> posiciones;
    protected int tamanio;

    public Barco(){
        this.posiciones = new ArrayList<>();
        tamanio = 0;
    }

    public List<Posicion> getListaDePosiciones() {
        List<Posicion> posicionesEntregadas = posiciones;
        return posicionesEntregadas;
    }

    public boolean estaEn(Posicion posicionComparada) {
        boolean salida = false;
        for(Posicion posicionIterada: posiciones){
            if (posicionIterada.equals(posicionComparada)) {
                salida = true;
            }
        }
        return salida;
    }

    public boolean estaHundido() {
        List<Posicion> posiciones = this.getListaDePosiciones();
        Posicion posicionRecorrida;
        int contadorDeTocados = 0;
        for (ListIterator<Posicion> iterador = posiciones.listIterator(); iterador.hasNext(); ) {
            posicionRecorrida = iterador.next();

            if (posicionRecorrida.getEstado() == EstadoDeUnaPosicion.TOCADO) {
                contadorDeTocados++;

            }
        }
        if (contadorDeTocados == posiciones.size())
            return true;
        else
            return false;
    }

    public void tocadoEn(Posicion posicionDeDisparo) {
        List<Posicion> posiciones = this.getListaDePosiciones();
        Posicion posicionRecorrida;
        for (ListIterator<Posicion> iterador = posiciones.listIterator(); iterador.hasNext(); ) {
            posicionRecorrida = iterador.next();

            if (posicionRecorrida.equals(posicionDeDisparo)) {
                posicionRecorrida.tocado();
            }
        }
    }

    public int getTamanio() {
        return tamanio;
    }

    public abstract void agregarPosicion(Posicion posicion);

}
