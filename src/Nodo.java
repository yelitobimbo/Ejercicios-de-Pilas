package src;

public class Nodo<T> {

    private T dato;
    private Nodo<T> next;

    public Nodo(T nuevoDato) {
        this.dato = nuevoDato;
    }

    public Nodo<T> getNodo() {
        return this.next;
    }

    public void setNodo(Nodo<T> nuevo) {
        this.next = nuevo;
    }

    public T getDato() {
        return this.dato;
    }
}