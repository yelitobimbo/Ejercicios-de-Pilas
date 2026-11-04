package src;

import java.io.*;

/**
 * Autor: Yaneli Sanchez Cardenas
 * Problema 5308: ()[]{}<>
 * Logica: las aperturas se meten a la pila. Cada cierre saca la apertura de
 * arriba; si no son pareja, cuenta 1 reemplazo (cambiando uno de los dos).
 * Es "imposible" si un cierre llega con la pila vacia o si sobran aperturas.
 */
public class P5308 {

    /** Regresa true si el caracter abre. */
    static boolean abre(char c) {
        return c == '<' || c == '(' || c == '{' || c == '[';
    }

    /** Regresa true si a (apertura) y b (cierre) son pareja. */
    static boolean pareja(char a, char b) {
        return (a == '<' && b == '>') || (a == '(' && b == ')')
            || (a == '{' && b == '}') || (a == '[' && b == ']');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cadena = br.readLine();
        if (cadena == null) {
            cadena = "";
        }
        cadena = cadena.trim();

        IPila<Character> pila = new PilaArreglo<>();
        int cambios = 0;
        boolean imposible = false;

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (abre(c)) {
                pila.push(c);
            } else {
                if (pila.isEmpty()) {           // cierre sin apertura
                    imposible = true;
                    break;
                }
                char tope = pila.pop();
                if (!pareja(tope, c)) {
                    cambios++;
                }
            }
        }

        if (!pila.isEmpty()) {                  // sobraron aperturas
            imposible = true;
        }

        if (imposible) {
            System.out.println("imposible");
        } else {
            System.out.println(cambios);
        }
    }
}
