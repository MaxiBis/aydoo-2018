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
    public Compra comprar(Producto productoComprado) {
        Compra compraNueva = new Compra (productoComprado,19,12,1990);
        this.misCompras.add(compraNueva);
        return compraNueva;
    }

    public Compra getCompra() {
        return misCompras.get(0);
    }

    public int calcularComprasDelMes(int mes, int anio) {
        if(misCompras == null){
            return getCompra().valorCompra();
        }else{
            Compra compraIterada;
            int total = 0;
            for(ListIterator<Compra> it = misCompras.listIterator(); it.hasNext(); ){
                compraIterada = it.next();
                if(mes == compraIterada.getMes() && anio == compraIterada.getAnio()){
                    total += compraIterada.valorCompra();
                }
            }

            if (this.estaRegistrado()){
                return (int)(total * 0.95);
            }else{
                return total;
            }

        }
    }
    public int calcularComprasDelMes() {
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.format(fechaActual);

        return this.calcularComprasDelMes(sdf.getCalendar().get(Calendar.MONTH),sdf.getCalendar().get(Calendar.YEAR));
    }

    public int calcularComprasDelAnio() {
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.format(fechaActual);

        return calcularComprasDelAnio(sdf.getCalendar().get(Calendar.YEAR));

    }

    public int calcularComprasDelAnio(int anioACalcular) {
        int total = 0;
        for (int i = 0; i<12; i++){
            total += calcularComprasDelMes(i,anioACalcular);
        }
        return total;
    }

    public void suscribirme(PublicacionRegular publicacion, int diasSuscripto) {
        int saleCada = 30 / publicacion.getPeriodicidad();
        System.out.println("saleCada: " + saleCada);
        PublicacionRegular publicacionACargar;

        if(diasSuscripto > 364){
            publicacionACargar = new PublicacionRegular((int)(publicacion.getPrecio()* 0.8), publicacion.getPeriodicidad());
        }else{
            publicacionACargar = publicacion;
        }

        for(int i = saleCada; i<diasSuscripto; i+= saleCada){
            this.comprar(publicacionACargar);
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
