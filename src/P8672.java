package src;

import java.io.*;

/**
 * Autor: Yaneli Sanchez Cardenas
 * Problema 8672: Sumando con pilas
 * Logica:
 *  - AGREGA v : push(v).
 *  - CONSUME  : se sacan los dos de arriba, se suman y se mete la suma.
 *  - IMPRIME  : se imprime el de arriba (peek) sin sacarlo.
 * Uso long porque las sumas pueden crecer mucho.
 */
public class P8672 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linea = br.readLine();
        int n = 0;
        if (linea != null) {
            n = Integer.parseInt(linea.trim());
        }

        IPila<Long> pila = new PilaArreglo<>();
        StringBuilder salida = new StringBuilder();

        int leidas = 0;
        while (leidas < n) {
            linea = br.readLine();
            if (linea == null) {
                break;
            }
            linea = linea.trim();
            if (linea.isEmpty()) {
                continue;
            }
            leidas++;

            String[] partes = linea.split("\\s+");
            String operacion = partes[0];

            if (operacion.equals("AGREGA")) {
                pila.push(Long.parseLong(partes[1]));
            } else if (operacion.equals("CONSUME")) {
                long a = pila.pop();
                long b = pila.pop();
                pila.push(a + b);
            } else if (operacion.equals("IMPRIME")) {
                salida.append(pila.peek()).append("\n");
            }
        }
        System.out.print(salida);
    }
}
