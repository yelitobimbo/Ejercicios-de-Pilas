package src;

/**
 * Autor: Yaneli Sanchez Cardenas
 * Fecha: 03/noviembre/2026
 * Descripcion: Pila generica hecha con un arreglo.
 * Si el arreglo se llena, se hace uno mas grande y se copian los datos.
 */
public class PilaArreglo<T> implements IPila<T> {

    /** Arreglo donde se guardan los datos. */
    private T[] datos;

    /** Posicion del dato de arriba (-1 si la pila esta vacia). */
    private int tope;

    /** Crea una pila vacia con la capacidad indicada. */
    @SuppressWarnings("unchecked")
    public PilaArreglo(int capacidad) {
        if (capacidad < 1) {
            capacidad = 1;
        }
        datos = (T[]) new Object[capacidad];
        tope = -1;
    }

    /** Crea una pila vacia con capacidad 10. */
    public PilaArreglo() {
        this(10);
    }

    /** Regresa true si la pila no tiene datos. */
    public boolean isEmpty() {
        return tope == -1;
    }

    /** Mete un dato arriba de la pila. */
    @SuppressWarnings("unchecked")
    public void push(T dato) {
        if (tope == datos.length - 1) {          // arreglo lleno
            T[] nuevo = (T[]) new Object[datos.length * 2];
            for (int i = 0; i <= tope; i++) {
                nuevo[i] = datos[i];
            }
            datos = nuevo;
        }
        tope++;
        datos[tope] = dato;
    }

    /** Saca y regresa el dato de arriba (null si esta vacia). */
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T dato = datos[tope];
        datos[tope] = null;
        tope--;
        return dato;
    }

    /** Regresa el dato de arriba sin sacarlo (null si esta vacia). */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return datos[tope];
    }
}
