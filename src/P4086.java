package src;

import java.io.*;

/**
 * Autor: Yaneli Sanchez Cardenas
 * Problema 4086: Conjunto
 * Logica: la cadena solo puede tener a, b, c, d, ( y ). Si hay otro caracter
 * la respuesta es 0. Cada "(" se mete a la pila y cada ")" saca uno; si
 * un ")" llega con la pila vacia, o al final sobra algun "(", la respuesta es 0.
 * Si todo sale bien, la respuesta es 1.
 */
public class P4086 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cadena = br.readLine();
        if (cadena == null) {
            cadena = "";
        }
        cadena = cadena.trim();

        IPila<Character> pila = new PilaArreglo<>();
        boolean pertenece = true;

        for (int i = 0; i < cadena.length() && pertenece; i++) {
            char c = cadena.charAt(i);
            if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                if (pila.isEmpty()) {           // cierre sin apertura
                    pertenece = false;
                } else {
                    pila.pop();
                }
            } else if (c < 'a' || c > 'd') {    // caracter que no es a,b,c,d
                pertenece = false;
            }
        }

        if (!pila.isEmpty()) {                  // sobraron aperturas
            pertenece = false;
        }

        if (pertenece) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
