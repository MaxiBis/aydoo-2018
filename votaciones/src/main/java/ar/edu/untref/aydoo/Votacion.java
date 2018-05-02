package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Votacion {
    private List<Candidato> candidatos;
    private List<Integer> votosEmitidos;

    public Votacion(){
        candidatos = new ArrayList<>();
        votosEmitidos = new ArrayList<>();
    }

    public void agregarCandidato(Candidato candidatoAgregado) {
        candidatos.add(candidatoAgregado);
    }

    public Candidato getCandidato() {
        return candidatos.get(0);
    }

    public void votar(Candidato candidatoVotado, Integer DNI) {
        if(!votosEmitidos.contains(DNI)){
            for (Candidato candidatoIterado:candidatos) {
                if(candidatoIterado == candidatoVotado){
                    candidatoIterado.sumarVoto();
                    votosEmitidos.add(DNI);
                }
            }
        }
    }

    public Candidato ganadorDe(Provincia provincia) {
        List<Candidato> candidatosDeLaProvincia = this.getCandidatosDe(provincia);
        Candidato masVotado = new Candidato("f", Partido.FOO, Provincia.SANLUIS);
        for (Candidato candidatoIterado:candidatosDeLaProvincia) {
            if (candidatoIterado.getVotos() > masVotado.getVotos()) {
                masVotado = candidatoIterado;
            }
        }
        return masVotado;
    }

    public List<Candidato> getCandidatosDe(Provincia provincia) {
        List<Candidato> salida = new ArrayList<>();
        for (Candidato candidatoIterado:candidatos) {
            if (candidatoIterado.getProvincia() == provincia) {
                salida.add(candidatoIterado);
            }
        }
        return salida;
    }

    public int votosDePArtidoEnProvincia(Partido partido, Provincia provincia) {
        List<Candidato> candidatosDeLaProvincia = this.getCandidatosDe(provincia);
        int contadorVotosDelPArtido = 0;
        for (Candidato candidatoIterado:candidatosDeLaProvincia) {
            if (candidatoIterado.getPartido() == partido) {
                contadorVotosDelPArtido += candidatoIterado.getVotos();
            }
        }
        return contadorVotosDelPArtido;
    }

    public Partido partidoGanadorNacional() {
        Partido ganador = Partido.FOO;
        int mayorCantidadDeVotos = -1;
        int votosDelPartido = 0;

        for (Partido partidoIterado: Partido.values()) {
            votosDelPartido = 0;
            for (Provincia prov : Provincia.values()) {
                votosDelPartido += this.votosDePArtidoEnProvincia(partidoIterado, prov);
            }
            if (votosDelPartido > mayorCantidadDeVotos) {
                mayorCantidadDeVotos = votosDelPartido;
                ganador = partidoIterado;
            }
        }
        return ganador;
    }
}

