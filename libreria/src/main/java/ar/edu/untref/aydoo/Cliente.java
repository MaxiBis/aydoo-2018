package ar.edu.untref.aydoo;

import java.text.SimpleDateFormat;
import java.util.*;


public class Cliente {
    private List<Compra> misCompras;
    private String direccion;
    private boolean registrado;

    public Cliente(){
        misCompras = new ArrayList<Compra>();
        registrado = false;
        direccion = "";
    }
    public Compra comprar(Producto producto) {
        Producto prodAgregado = producto;
        if (registrado){
            double precioNuevo =producto.getPrecio() * 0.95;
            prodAgregado.setPrecio(precioNuevo);
        }
        Compra compraNueva = new Compra (prodAgregado);
        this.misCompras.add(compraNueva);
        return compraNueva;
    }

    public List<Compra> getListaDeCompras() {
        List<Compra> compraDevueltas = misCompras;
        return compraDevueltas;
    }

    public double calcularComprasDelMes(int mes, int anio) {
        if(misCompras == null){
            return 0.0;
        }else{
            Compra compraIterada;
            double total = 0.0;
            for(ListIterator<Compra> it = misCompras.listIterator(); it.hasNext(); ){
                compraIterada = it.next();
                if(mes == compraIterada.getMes() && anio == compraIterada.getAnio()){
                    total += compraIterada.valorCompra();
                }
            }
            return total;
        }
    }
    public double calcularComprasDelMes() {
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.format(fechaActual);

        return this.calcularComprasDelMes(sdf.getCalendar().get(Calendar.MONTH),sdf.getCalendar().get(Calendar.YEAR));
    }

    public double calcularComprasDelAnio() {
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.format(fechaActual);

        return calcularComprasDelAnio(sdf.getCalendar().get(Calendar.YEAR));

    }

    public double calcularComprasDelAnio(int anioACalcular) {
        double total = 0.0;
        for (int i = 0; i<12; i++){
            total += calcularComprasDelMes(i,anioACalcular);
        }
        return total;
    }

    public void suscribirme(PublicacionRegular publicacion, int diasSuscripto) {
        int saleCada = 30 / publicacion.getPeriodicidad();
        PublicacionRegular publicacionACargar;

        if(diasSuscripto > 364){
            publicacionACargar = new PublicacionRegular(publicacion.getPrecio()* 0.8, publicacion.getPeriodicidad());
        }else{
            publicacionACargar = publicacion;
        }

        for(int i = saleCada; i<diasSuscripto; i+= saleCada){
            this.misCompras.add(new Compra (publicacionACargar));
        }

    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }

    public boolean estaRegistrado() {
        return registrado;
    }
}
