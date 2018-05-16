package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class ParidadPar extends Paridad {
    public ParidadPar(List<Integer> listaNumeros) {
        super(listaNumeros);
    }

    @Override
    public List<Integer> mostrarFiltrados() {
        List<Integer> listaSalida = new LinkedList<Integer>();
        for(Integer elementoLista: listaFibonacci){
            if (elementoLista%2 == 0 && elementoLista !=0 ){
                listaSalida.add(elementoLista);
            }
        }
        return listaSalida;
    }
}
