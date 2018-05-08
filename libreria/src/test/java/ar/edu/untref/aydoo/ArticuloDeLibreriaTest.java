package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ArticuloDeLibreriaTest {

    @Test
    public void articuloLeSumoEliva(){
        ArticuloDeLibreria cuaderno = new ArticuloDeLibreria(100);

        Assert.assertEquals(121, cuaderno.getPrecio(),0.01);
    }
}
