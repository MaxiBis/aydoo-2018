package excepciones;

public class ExcepcionFuncionamientoInvalido extends RuntimeException{
    private final static String mensajeFuncionamientoInvalido = "El funcionamiento ingresado es incorrecto";
    
    public ExcepcionFuncionamientoInvalido() {
       super(mensajeFuncionamientoInvalido);
    }
}
