package ar.edu.untref.aydoo;

public class Producto {
    protected double precio;


    public Producto (double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precioNuevo) {
        this.precio = precioNuevo;
    }

}
