package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto{

    public ArticuloDeLibreria(int precio){
        super(precio);
    }

    public int getPrecio(){
       return precioConIva();
    }

    public int precioConIva(){
        return (int)(this.precio*1.21);
    }

}
