package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PublicacionRegularTest {

    @Test
    public void periodicoTienePrecio(){
        Producto pagina12 = new PublicacionRegular(10,30);

        Assert.assertEquals(10, pagina12.getPrecio());
    }
    @Test
    public void periodicoTienePeriodicidad(){
        PublicacionRegular pagina12 = new PublicacionRegular(10,30);

        Assert.assertEquals(30, pagina12.getPeriodicidad());
    }
}
