package excepciones;

public class ExcepcionNumeroInvalido extends RuntimeException {
    private final static String mensajeNumeroInvalido = "Se debe ingresar un numero natural";
    
    public ExcepcionNumeroInvalido() {
        super(mensajeNumeroInvalido);
    }
}