package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class BoteTest {

    @Test
    public void ponerBoteDondeHayOtro() {

        Bote unBote = new Bote();
        Bote otroBote = new Bote();
        Tablero unTablero = new Tablero(10);
        Posicion posicion = new Posicion(1, 1);

        unTablero.ponerBarcoHorizontal(unBote, posicion);
        unTablero.ponerBarcoHorizontal(otroBote, posicion);

        Assert.assertEquals(unBote,unTablero.getBarcoEn(posicion));
    }
}
