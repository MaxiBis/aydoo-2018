package ar.edu.untref.aydoo;

public class Posicion {

    private int posicionVertical;
    private int posicionHorizontal;
    private Barco barcoEn;
    private EstadoDeUnaPosicion estado;


    public Posicion(int posicionHorizontal, int posicionVertical) {
        this.posicionHorizontal = posicionHorizontal;
        this.posicionVertical = posicionVertical;
        this.estado = EstadoDeUnaPosicion.AGUA;
    }

    public int getPosicionVertical() {
        return posicionVertical;
    }

    public int getPosicionHorizontal() {
        return posicionHorizontal;
    }

    public void setPosicion(int j, int i) {
        this.setPosicionHorizontal(j);
        this.setPosicionVertical(i);
    }

    public void setPosicionHorizontal(int posicionHorizontal) {
        this.posicionHorizontal = posicionHorizontal;
    }

    public void setPosicionVertical(int posicionVertical) {
        this.posicionVertical = posicionVertical;
    }

    public boolean equals(Posicion posicionAComparar) {
        return this.getPosicionVertical() == posicionAComparar.getPosicionVertical() && this.getPosicionHorizontal() == posicionAComparar.getPosicionHorizontal();
    }

    public void ponerBarco(Barco barquito) {
        this.barcoEn = barquito;
    }

    public void setEstado(EstadoDeUnaPosicion estado) {
        this.estado = estado;
    }

    public Barco getBarco() {
        return barcoEn;
    }

    public EstadoDeUnaPosicion getEstado() {
        return estado;
    }

    public void tocado() {
        this.estado = EstadoDeUnaPosicion.TOCADO;
    }
}
