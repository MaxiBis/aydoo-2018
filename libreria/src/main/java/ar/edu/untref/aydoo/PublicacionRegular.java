package ar.edu.untref.aydoo;

public class PublicacionRegular extends Producto{

    private int periodicidadMensual;

    public PublicacionRegular(double precio, int periodicidadPorMes){
        super(precio);
        this.periodicidadMensual = periodicidadPorMes;
    }

    public int getPeriodicidad() {
        return periodicidadMensual;
    }


}
