package ar.edu.untref.aydoo;

public class Fibonacci {

    private int[] fibo;

    public Fibonacci(int cantidadDeNumeros) {
        fibo  = this.calcularFiboConLongitud(cantidadDeNumeros);
    }

    private int[] calcularFiboConLongitud(int longitud) {
        int[] salida = new int[longitud];
        int primerNumero, segundoNumero, tercerNumero;
        primerNumero = 0;
        segundoNumero = 1;

        if (longitud > 0) {
            salida[0] = 0;
        }
        if (longitud > 1) {
            salida[1] = 1;
        }

        for (int i = 2; i < longitud; i++) {
            tercerNumero = primerNumero + segundoNumero;
            primerNumero = segundoNumero;
            segundoNumero = tercerNumero;
            salida[i] = tercerNumero;
        }
        return salida;
    }

    public void invertir() {
        int[] fiboNuevo = new int[this.fibo.length];
        int contadorFiboNuevo = 0;
        for (int i = this.fibo.length; i > 0; i--) {
            fiboNuevo[contadorFiboNuevo] = fibo[i - 1];
            contadorFiboNuevo++;
        }

        fibo = fiboNuevo;
    }

    public String mostrarFiboVertical() {
        String cadenaAMostrar = "\r\n";
        for (int i = 0; i < this.fibo.length; i++) {
            cadenaAMostrar += (String.valueOf(this.fibo[i]) + "\r\n");
        }
        return cadenaAMostrar;
    }

    public String mostrarFiboHorizontal() {
        String cadenaAMostrar = "";
        for (int i = 0; i < this.fibo.length; i++) {
            cadenaAMostrar += (" " + this.fibo[i]);
        }
        return cadenaAMostrar;
    }

    public int sumatoria() {
        int total = 0;
        for (int i = 0; i < this.fibo.length; i++) {
            total += this.fibo[i];
        }
        return total;
    }

}
