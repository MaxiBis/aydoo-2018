package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CompraTest {
    @Test
    public void obtenerValorCompra(){

        Cliente miCliente = new Cliente();

        Libro principito = new Libro(10);

        Compra compra = miCliente.comprar(principito);

        Assert.assertEquals(10, compra.valorCompra());
    }

    @Test
    public void compraTieneUnaFecha(){

        Cliente miCliente = new Cliente();
        Libro principito = new Libro(10);
        Compra compra = miCliente.comprar(principito);

        compra.setFecha(19,11,1990);


        Assert.assertEquals(19,compra.getDia());
        Assert.assertEquals(11,compra.getMes());
        Assert.assertEquals(1990,compra.getAnio());
    }

    @Test
    public void hagoUnaCompraCon2Productos(){

        //Cliente miCliente = new Cliente();
        Libro principito = new Libro(10);
        Libro hobbit = new Libro(15);

        Compra compra = new Compra(principito,19,10,1990);
        compra.agregarProducto(hobbit);

        Assert.assertEquals(25,compra.valorCompra());
    }

}
