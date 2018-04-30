package ar.edu.untref.aydoo;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Program {

    public static void main(final String[] arg) {

        String textoDeSalida = "";
        char horizontalVertical = 'h';
        char directaInversa = 'd';
        char listaSumatoria = 'l';
        int numerosaMostrar = Integer.parseInt(arg[arg.length - 1]);
        String archivoSalida = "";

        String principioDelComando = "";
        for (String comandoActual : arg) {
            if (comandoActual.length() > 3) {
                principioDelComando = comandoActual.substring(0, 3);
                switch (principioDelComando) {
                    case "-o=":
                        horizontalVertical = comandoActual.charAt(3);
                        directaInversa = comandoActual.charAt(4);
                        break;
                    case "-m=":
                        listaSumatoria = comandoActual.charAt(3);
                        break;
                    case "-f=":
                        archivoSalida = comandoActual.substring(3);
                        break;
                }
            }
        }

        Fibonacci fibo = new Fibonacci(numerosaMostrar);
        if (directaInversa == 'i') {
            fibo.invertir();
        }

        if ((horizontalVertical == 'h' || horizontalVertical == 'v') && (directaInversa == 'i' || directaInversa == 'd')) {
            switch (listaSumatoria) {
                case 'l':
                    textoDeSalida = "fibo<" + numerosaMostrar + ">:";
                    switch (horizontalVertical) {
                        case 'h':
                            textoDeSalida += fibo.mostrarFiboHorizontal();
                            break;
                        case 'v':
                            textoDeSalida += fibo.mostrarFiboVertical();
                            break;
                    }
                    break;
                case 's':
                    textoDeSalida = "fibo<" + numerosaMostrar + ">s:";
                    if (horizontalVertical == 'h') textoDeSalida += " ";
                    if (horizontalVertical == 'v') textoDeSalida += "\r\n";
                    textoDeSalida += fibo.sumatoria();
                    break;
            }
        } else textoDeSalida = "Opciones no validas";


        if (archivoSalida != "") {
            System.out.println("fibo<" + numerosaMostrar + "> guardado en " + archivoSalida);
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(archivoSalida, "UTF-8");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            writer.print(textoDeSalida);
            writer.close();
        } else {
            System.out.println(textoDeSalida);
        }
    }
}







