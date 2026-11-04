package src;

import java.io.*;

/**
 * Autor: Yaneli Sanchez Cardenas
 * Problema 6818: Los Ultimos Seran Los Primeros
 * Logica: se leen los nombres y se meten a la pila hasta llegar a "#".
 * Como el ultimo en entrar es el primero en salir, al sacar todos los
 * nombres salen en el orden pedido (el que llego al ultimo va primero).
 */
public class P6818 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        IPila<String> pila = new PilaArreglo<>();

        String nombre = br.readLine();
        while (nombre != null && !nombre.trim().equals("#")) {
            nombre = nombre.trim();
            if (!nombre.isEmpty()) {
                pila.push(nombre);
            }
            nombre = br.readLine();
        }

        StringBuilder salida = new StringBuilder();
        while (!pila.isEmpty()) {
            salida.append(pila.pop()).append("\n");
        }
        System.out.print(salida);
    }
}
