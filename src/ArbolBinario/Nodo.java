package ArbolBinario;
public class Nodo<T extends Comparable<T>> {
    private T dato;          // Dato almacenado en el nodo
    private Nodo<T> izquierdo; // Hijo izquierdo
    private Nodo<T> derecho;   // Hijo derecho

    public Nodo(T dato) {
        this.dato = dato;          // Almacenamos el dato}
        this.izquierdo = null;     // El nodo no tiene hijo izquierdo
        this.derecho = null;       // El nodo no tiene hijo derecho
    }
    public void setIzquierdo(Nodo<T> izquierdo) {
        this.izquierdo = izquierdo;
    }
    public void setDerecho(Nodo<T> derecho) {
        this.derecho = derecho;
    }
    public Nodo<T> getIzquierdo() {
        return izquierdo;
    }
    public Nodo<T> getDerecho() {
        return derecho;
    }
    public T getDato() {
        return dato;
    }
    public void setDato(T dato) {
        this.dato = dato;
    }
}

