

/*
 * Interface Pila Genérica
 * @Yaneli Sanchez Cardenas 
 */

package src;

public interface IPila<T> {
    public T pop();
    public void push(T dato);
    public T peek();
    public boolean isEmpty();
}