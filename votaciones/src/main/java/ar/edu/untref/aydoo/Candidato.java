package ar.edu.untref.aydoo;

public class Candidato {
    private final String nombre;
    private final Provincia provincia;
    private final Partido partido;
    private int votos;

    public Candidato(String nombre, Partido partido, Provincia prov) {
        this.nombre = nombre;
        this.partido = partido;
        this.provincia = prov;
        votos = 0;
    }

    public void sumarVoto() {
        votos++;
    }

    public int getVotos() {
        return votos;
    }

    public String getNombre() {
        return nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public Partido getPartido() {
        return partido;
    }
}
