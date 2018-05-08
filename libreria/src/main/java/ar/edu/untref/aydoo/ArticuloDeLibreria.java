package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto{

    public ArticuloDeLibreria(int precio){
        super(precio);
    }

    public double getPrecio(){
       return precioConIva();
    }

    public double precioConIva(){
        return (this.precio*1.21);
    }

}
