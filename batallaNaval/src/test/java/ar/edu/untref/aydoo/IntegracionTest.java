package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionTest {

    @Test
    public void ponerBoteEnTablero() {

        Bote unBote = new Bote();
        Tablero unTablero = new Tablero(10);
        Posicion posicion = new Posicion(1, 1);

        unTablero.ponerBote(unBote, posicion);

        Assert.assertFalse(unTablero.estaDisponible(posicion));
    }

    @Test
    public void tableroVacioPosicionLibre() {

        Tablero unTablero = new Tablero(10);
        Posicion posicion = new Posicion(1, 1);

        Assert.assertTrue(unTablero.estaDisponible(posicion));

    }

    @Test
    public void tableroVacioLlenoDeAgua() {
        int tamanioTablero = 5;
        Tablero unTablero = new Tablero(tamanioTablero);
        Posicion posicion = new Posicion(1, 1);

        for (int i = 1; i < tamanioTablero; i++) {
            for (int j = 1; j < tamanioTablero; j++) {
                posicion.setPosicion(j, i);
                Assert.assertTrue(unTablero.estaDisponible(posicion));
            }
        }
    }

    @Test
    public void ponerCruceroVerticalmenteEnTablero() {

        Crucero unCrucero = new Crucero();
        Tablero unTablero = new Tablero(10);
        Posicion posicionArriba = new Posicion(1, 1);
        Posicion posicionAbajo = new Posicion(2, 1);

        unTablero.ponerCruceroVertical(unCrucero, posicionArriba);
        //System.out.println(posicion.esAgua());

        Assert.assertFalse(unTablero.estaDisponible(posicionArriba));
        Assert.assertFalse(unTablero.estaDisponible(posicionAbajo));
    }

    @Test
    public void ponerCruceroHorizontalEnTablero() {

        Crucero unCrucero = new Crucero();
        Tablero unTablero = new Tablero(10);
        Posicion posicionIzquierda = new Posicion(1, 1);
        Posicion posicionDerecha = new Posicion(1, 2);

        unTablero.ponerCruceroHorizontal(unCrucero, posicionIzquierda);
        //System.out.println(posicion.esAgua());

        Assert.assertFalse(unTablero.estaDisponible(posicionIzquierda));
        Assert.assertFalse(unTablero.estaDisponible(posicionDerecha));
    }

    @Test
    public void dondeEstaBoteOtraPosicion() {

        Bote unBote = new Bote();
        Tablero unTablero = new Tablero(10);
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionParaComparar = new Posicion(2, 1);

        unTablero.ponerBote(unBote, posicion);

        Assert.assertNotEquals(unBote.getPosicion(), posicionParaComparar);
    }

    @Test
    public void dondeEstaBoteDevuelveBien() {

        Bote unBote = new Bote();
        Tablero unTablero = new Tablero(10);
        Posicion posicion = new Posicion(1, 1);

        unTablero.ponerBote(unBote, posicion);

        Assert.assertEquals(unBote.getPosicion(), posicion);
    }

    @Test
    public void dondeEstaCruceroDevuelveBienConCruceroHorizontal() {

        Crucero unCrucero = new Crucero();
        Tablero unTablero = new Tablero(10);
        Posicion posicionIzquierda = new Posicion(1, 1);
        Posicion posicionDerecha = new Posicion(1, 2);

        unTablero.ponerCruceroHorizontal(unCrucero, posicionIzquierda);

        Assert.assertTrue(unCrucero.estaEn(posicionIzquierda));
        Assert.assertTrue(unCrucero.estaEn(posicionDerecha));
    }

    @Test
    public void dondeEstaCruceroDevuelveBienConCruceroVertical() {

        Crucero unCrucero = new Crucero();
        Tablero unTablero = new Tablero(10);
        Posicion posicionArriba = new Posicion(1, 1);
        Posicion posicionAbajo = new Posicion(2, 1);

        unTablero.ponerCruceroVertical(unCrucero, posicionArriba);

        Assert.assertTrue(unCrucero.estaEn(posicionArriba));
        Assert.assertTrue(unCrucero.estaEn(posicionAbajo));
    }

    @Test
    public void disparoYEncuentroAgua() {

        Tablero unTablero = new Tablero(10);
        Posicion posicionDeDisparo = new Posicion(1, 1);
        EstadoDeUnaPosicion disparo;

        disparo = unTablero.disparar(posicionDeDisparo);

        Assert.assertEquals(disparo, EstadoDeUnaPosicion.AGUA);
    }

    @Test
    public void disparoYEncuentroBote() {

        Tablero unTablero = new Tablero(10);
        Bote unBote = new Bote();
        Posicion posicion = new Posicion(1, 1);
        unTablero.ponerBote(unBote, posicion);
        EstadoDeUnaPosicion disparo;

        disparo = unTablero.disparar(posicion);

        Assert.assertEquals(EstadoDeUnaPosicion.HUNDIDO, disparo);
    }

    @Test
    public void disparoYEncuentroCrucero() {

        Tablero unTablero = new Tablero(10);
        Crucero unCrucero = new Crucero();
        Posicion posicion = new Posicion(1, 1);
        unTablero.ponerCruceroHorizontal(unCrucero, posicion);
        EstadoDeUnaPosicion disparo;

        disparo = unTablero.disparar(posicion);

        Assert.assertEquals(EstadoDeUnaPosicion.TOCADO, disparo);
    }

    @Test
    public void disparoYHundoCrucero() {

        Tablero unTablero = new Tablero(10);
        Crucero unCrucero = new Crucero();
        Posicion posicion1 = new Posicion(1, 1);
        Posicion posicion2 = new Posicion(1, 2);
        unTablero.ponerCruceroHorizontal(unCrucero, posicion1);
        EstadoDeUnaPosicion disparo;

        unTablero.disparar(posicion1);
        disparo = unTablero.disparar(posicion2);

        Assert.assertEquals(EstadoDeUnaPosicion.HUNDIDO, disparo);
    }

    @Test
    public void ponerBoteEnPosicionOcupada() {

        Bote unBote = new Bote();
        Bote otroBote = new Bote();
        Tablero unTablero = new Tablero(10);
        Posicion posicion = new Posicion(1, 1);

        unTablero.ponerBote(unBote, posicion);
        unTablero.ponerBote(otroBote, posicion);

        Assert.assertNotEquals(unTablero.getBarcoEn(posicion), otroBote);
    }

    @Test
    public void ponerCruceroEnPosicionOcupada() {

        Crucero unBote = new Crucero();
        Crucero otroBote = new Crucero();
        Tablero unTablero = new Tablero(10);
        Posicion posicion = new Posicion(1, 1);

        unTablero.ponerCruceroHorizontal(unBote, posicion);
        unTablero.ponerCruceroHorizontal(otroBote, posicion);

        Assert.assertNotEquals(unTablero.getBarcoEn(posicion), otroBote);
    }

    @Test
    public void ponerBoteFueraDelTablero() {

        Bote unBote = new Bote();
        Tablero unTablero = new Tablero(10);
        Posicion posicion = new Posicion(11, 1);

        unTablero.ponerBote(unBote, posicion);

        Assert.assertTrue(unBote.getListaDePosiciones().isEmpty());
    }

    @Test
    public void ponerCruceroAlBordeDelTableroYSePasa() {

        Crucero unCurcero = new Crucero();
        Tablero unTablero = new Tablero(10);
        Posicion posicion = new Posicion(1, 10);

        unTablero.ponerCruceroHorizontal(unCurcero, posicion);

        Assert.assertTrue(unCurcero.getListaDePosiciones().isEmpty());
    }

}