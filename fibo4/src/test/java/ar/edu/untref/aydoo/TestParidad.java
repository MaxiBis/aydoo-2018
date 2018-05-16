package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestParidad {

    @Test
    public void muestroPares() {
        List<Integer> esperado = new LinkedList<Integer>();
        esperado.addAll(Arrays.asList(2, 8, 34, 144, 610));
        Funcionamiento calculador = new FuncionamientoLista(16, "s");
        Paridad pares = new ParidadPar(calculador.getListaNumeros());

        Assert.assertEquals(esperado, pares.mostrarFiltrados());
    }
}
