package ar.edu.untref.aydoo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by nicopaez on 11/04/2018.
 */
public class Compra {
    private List<Producto> productosDeLaCompra;
    private Calendar fecha;
    private double valor;

    public Compra(Producto compra) {
        productosDeLaCompra = new ArrayList<Producto>();
        this.productosDeLaCompra.add(compra);
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.format(fechaActual);
        fecha = sdf.getCalendar();

    }
    public Compra(Producto compra,int dia,int mes, int anio) {
        productosDeLaCompra = new ArrayList<Producto>();
        this.productosDeLaCompra.add(compra);
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.format(fechaActual);
        fecha = sdf.getCalendar();
        this.fecha.set(anio, mes, dia);
    }


    public double valorCompra() {
        double valorTotal = 0;
        for(Producto productoIt : productosDeLaCompra){
            valorTotal += productoIt.getPrecio();
        }
        return valorTotal;
    }


    public void setFecha(int dia,int mes, int anio) {
        this.fecha.set(anio, mes, dia);
    }

    public int getDia() {
        return this.fecha.get(Calendar.DAY_OF_MONTH);
    }

    public int getMes() {
        return this.fecha.get(Calendar.MONTH);
    }

    public int getAnio() {
        return this.fecha.get(Calendar.YEAR);
    }

    public void agregarProducto(Producto prod) {
        productosDeLaCompra.add(prod);
    }
}
