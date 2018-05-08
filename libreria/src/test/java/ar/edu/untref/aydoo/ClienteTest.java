package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by nicopaez on 11/04/2018.
 */
public class ClienteTest {

    @Test

    public void calcularMontoDelMesSinNingunaCompra() {

        Cliente miCliente = new Cliente();
        Assert.assertEquals(0,miCliente.calcularComprasDelMes(),0.01);

    }

    @Test
    public void clienteCompraUnProductoDeValor10(){

        Cliente miCliente = new Cliente();
        Libro principito = new Libro(10);

        miCliente.comprar(principito);

        Assert.assertEquals(10, miCliente.calcularComprasDelMes(),0.01);
    }
    @Test
    public void clienteRealizaCompraSeRegistraCompra(){
        Cliente unCliente = new Cliente();
        Libro principito = new Libro(10);

        Compra unaCompra = unCliente.comprar(principito);

        Assert.assertEquals(unaCompra,unCliente.getListaDeCompras().get(0));
    }

    @Test
    public void clienteCompraDosProductos(){
        Cliente miCliente = new Cliente();
        Libro principito = new Libro(10);
        Libro hobbit = new Libro(10);

        miCliente.comprar(principito);
        miCliente.comprar(hobbit);

        Assert.assertEquals(20, miCliente.calcularComprasDelMes(),0.01);
    }
    @Test
    public void comproEnDosMesesDistintosYcalculoMes(){
        Cliente miCliente = new Cliente();
        Libro principito = new Libro(10);
        Libro hobbit = new Libro(15);

        miCliente.comprar(principito);
        Compra segundaCompraQueLeCambioLaFecha = miCliente.comprar(hobbit);

        segundaCompraQueLeCambioLaFecha.setFecha(19,11,1990);

        Assert.assertEquals(15, miCliente.calcularComprasDelMes(11,1990),0.01);
    }
    @Test
    public void comproEntresMesesDistintosYcalculoAnio(){
        Cliente miCliente = new Cliente();
        Libro principito = new Libro(10);
        Libro hobbit = new Libro(15);
        Libro songOfIceAndFire = new Libro(20);

        Compra primeraCompra = miCliente.comprar(principito);
        primeraCompra.setFecha(19,01,2018);
        Compra segundaCompra = miCliente.comprar(hobbit);
        segundaCompra.setFecha(19,02,2018);
        Compra terceraCompra = miCliente.comprar(songOfIceAndFire);
        terceraCompra.setFecha(19,07,2018);

        Assert.assertEquals(45, miCliente.calcularComprasDelAnio(),0.01);
    }
    @Test
    public void comproEnMesesyAniosDistintosYcalculoAnio(){
        Cliente miCliente = new Cliente();

        Libro principito = new Libro(10);
        Compra primeraCompra = miCliente.comprar(principito);
        primeraCompra.setFecha(19,01,2017);
        Libro hobbit = new Libro(15);
        Compra segundaCompra = miCliente.comprar(hobbit);
        segundaCompra.setFecha(19,02,2017);
        Libro songOfIceAndFire = new Libro(20);
        Compra terceraCompra = miCliente.comprar(songOfIceAndFire);
        terceraCompra.setFecha(19,07,2018);
        Libro angelGris = new Libro(16);
        Compra cuartaCompra = miCliente.comprar(angelGris);
        cuartaCompra.setFecha(19,07,2016);



        Assert.assertEquals(25, miCliente.calcularComprasDelAnio(2017),0.01);
    }

    @Test
    public void comproEnMesesyAniosDistintosYcalculoAnioVacio(){
        Cliente miCliente = new Cliente();

        Libro principito = new Libro(10);
        Compra primeraCompra = miCliente.comprar(principito);
        primeraCompra.setFecha(19,01,2017);
        Libro hobbit = new Libro(15);
        Compra segundaCompra = miCliente.comprar(hobbit);
        segundaCompra.setFecha(19,02,2017);
        Libro songOfIceAndFire = new Libro(20);
        Compra terceraCompra = miCliente.comprar(songOfIceAndFire);
        terceraCompra.setFecha(19,07,2018);
        Libro angelGris = new Libro(16);
        Compra cuartaCompra = miCliente.comprar(angelGris);
        cuartaCompra.setFecha(19,07,2016);



        Assert.assertEquals(0, miCliente.calcularComprasDelAnio(2013),0.01);
    }
    @Test
    public void noComproYCalculoAnio(){
        Cliente miCliente = new Cliente();

        Assert.assertEquals(0, miCliente.calcularComprasDelAnio(2013),0.01);
    }

    @Test
    public void comproRevista(){
        Cliente miCliente = new Cliente();
        PublicacionRegular rollingStone = new PublicacionRegular(50.0,4);
        miCliente.comprar(rollingStone);

        Assert.assertEquals(50.0,miCliente.calcularComprasDelMes(),0.01);
    }
    @Test
    public void meSuscriboaRevista(){
        Cliente miCliente = new Cliente();
        PublicacionRegular rollingStone = new PublicacionRegular(50,4);
        miCliente.suscribirme(rollingStone,60);

        Assert.assertEquals(400,miCliente.calcularComprasDelMes(),0.01);
    }
    @Test
    public void meSuscriboaRevistaAnualConDescuento(){
        Cliente miCliente = new Cliente();
        PublicacionRegular rollingStone = new PublicacionRegular(100,1);
        miCliente.suscribirme(rollingStone,365);

        Assert.assertEquals(960,miCliente.calcularComprasDelMes(),0.01);
    }

    @Test
    public void elClienteTieneUnaDireccion(){
        Cliente miCliente = new Cliente();
        miCliente.setDireccion("Victor Hugo 2700");

        Assert.assertEquals("Victor Hugo 2700",miCliente.getDireccion());
    }
    @Test
    public void elClienteNoTieneUnaDireccion(){
        Cliente miCliente = new Cliente();

        Assert.assertEquals("",miCliente.getDireccion());
    }
    @Test
    public void estaRegistrado(){
        Cliente miCliente = new Cliente();
        miCliente.setRegistrado(true);

        Assert.assertTrue(miCliente.estaRegistrado());
    }
    @Test
    public void noEstaRegistrado(){
        Cliente miCliente = new Cliente();

        Assert.assertFalse(miCliente.estaRegistrado());
    }

    @Test
    public void calculoComprasDelMesParaClienteRegistrado(){
        Cliente miCliente = new Cliente();
        miCliente.setRegistrado(true);
        Libro principito = new Libro(16.0);
        miCliente.comprar(principito);
        Libro hobbit = new Libro(16.0);
        miCliente.comprar(hobbit);

        Assert.assertEquals(30.4,miCliente.calcularComprasDelMes(),0.01);
    }

    @Test
    public void meSuscriboaRevistaAnualConDescuentoDeUnClienteRegistrado(){
        Cliente miCliente = new Cliente();
        miCliente.setRegistrado(true);
        PublicacionRegular rollingStone = new PublicacionRegular(100,1);
        miCliente.suscribirme(rollingStone,365);

        Assert.assertEquals(960,miCliente.calcularComprasDelMes(),0.01);
    }

}
