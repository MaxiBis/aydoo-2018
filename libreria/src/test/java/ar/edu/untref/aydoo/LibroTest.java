package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibroTest {

    @Test
    public void libroTienePrecio(){

        Libro principito = new Libro(10);



        Assert.assertEquals(10, principito.getPrecio(),0.01);
    }
}
