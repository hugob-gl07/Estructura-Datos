package ListaCircular.Basado_en_LDE;
/** Interfaz que define el comportamiento del iterador para recorrer los TAD.*/
public interface MiIterador<T> {
    /** Comprueba si quedan elementos por recorrer.*/
    boolean hasNext();
    /** Devuelve el siguiente elemento y avanza el puntero.*/
    T next();
}