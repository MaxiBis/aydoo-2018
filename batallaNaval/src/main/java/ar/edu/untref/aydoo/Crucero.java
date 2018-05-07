package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class Crucero extends Barco {


    public Crucero() {
        super();
        this.tamanio = 2;
    }

    public void agregarPosicion(Posicion posicion) {
        if (posiciones.size() < 2) {
            this.posiciones.add(posicion);
        }
    }
}
