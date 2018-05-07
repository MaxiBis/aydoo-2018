package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class Bote extends Barco {

    public Bote() {
        super();
        this.tamanio = 1;
    }


    public void agregarPosicion(Posicion posicion) {
        if(posiciones.isEmpty()) {
            this.posiciones.add(posicion);
        }
    }
}
