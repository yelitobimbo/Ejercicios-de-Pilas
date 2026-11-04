package src;

import java.io.*;

/**
 * Autor: Yaneli Sanchez Cardenas
 * Problema 3878: Parentesis Regulares
 * Logica: la pila guarda POSICIONES (indices). Al inicio se mete -1 como base.
 *  - "(" : se mete su posicion i.
 *  - ")" : se saca el de arriba.
 *      Si la pila queda vacia, este ")" no tiene pareja: se mete i como nueva base.
 *      Si no queda vacia, la subcadena regular termina en i y empieza despues
 *      de la posicion que quedo arriba, entonces su longitud es i - peek().
 * Se guarda la longitud maxima y cuantas veces aparece.
 * Si no hay ninguna subcadena regular se imprime "0 1".
 */
public class P3878 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cadena = br.readLine();
        if (cadena == null) {
            cadena = "";
        }
        cadena = cadena.trim();

        IPila<Integer> pila = new PilaArreglo<>(cadena.length() + 2);
        pila.push(-1);                            // base

        int maxLong = 0;
        int cuantas = 1;

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c == '(') {
                pila.push(i);
            } else if (c == ')') {
                pila.pop();
                if (pila.isEmpty()) {
                    pila.push(i);                 // nueva base
                } else {
                    int largo = i - pila.peek();
                    if (largo > maxLong) {
                        maxLong = largo;
                        cuantas = 1;
                    } else if (largo == maxLong) {
                        cuantas++;
                    }
                }
            }
        }

        if (maxLong == 0) {
            System.out.println("0 1");
        } else {
            System.out.println(maxLong + " " + cuantas);
        }
    }
}
