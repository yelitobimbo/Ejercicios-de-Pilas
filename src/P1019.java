package src;

import java.io.*;

/**
 * Autor: Yaneli Sanchez Cardenas
 * Problema 1019: Operaciones con una pila
 * Logica: para cada numero a, si la pila tiene menos de a elementos se mete a;
 * si no, se sacan a elementos. Para saber cuantos elementos hay llevo un
 * contador (tam). Al final se imprime tam y se sacan todos los elementos
 * (el orden en que saldrian).
 */
public class P1019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // leo toda la entrada y la separo por espacios
        StringBuilder todo = new StringBuilder();
        String linea = br.readLine();
        while (linea != null) {
            todo.append(linea).append(" ");
            linea = br.readLine();
        }
        String[] numeros = todo.toString().trim().split("\\s+");

        int n = Integer.parseInt(numeros[0]);
        IPila<Integer> pila = new PilaArreglo<>();
        int tam = 0;                              // cuantos elementos hay

        for (int i = 1; i <= n; i++) {
            int a = Integer.parseInt(numeros[i]);
            if (tam < a) {
                pila.push(a);                     // mete(a)
                tam++;
            } else {
                for (int j = 0; j < a; j++) {     // saca(a)
                    pila.pop();
                }
                tam = tam - a;
            }
        }

        StringBuilder salida = new StringBuilder();
        salida.append(tam).append("\n");
        boolean primero = true;
        while (!pila.isEmpty()) {
            if (!primero) {
                salida.append(" ");
            }
            salida.append(pila.pop());
            primero = false;
        }
        System.out.println(salida);
    }
}
