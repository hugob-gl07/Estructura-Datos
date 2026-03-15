package ListaCircular.Basado_en_LDE;
/** Interfaz que define el comportamiento de una lista para todos los TAD.*/
public interface Lista<T extends Comparable<T>> {
    /** Inserta un elemento en la lista.*/
    void add(T dato);
    /** Busca y devuelve un elemento por valor.*/
    T get(T dato);
    /** Busca y elimina un elemento por valor.*/
    T del(T dato);
    /** Comprueba si la lista está vacía.*/
    boolean isEmpty();
    /** Devuelve el número de elementos de la lista.*/
    int getSize();
    /** Devuelve un iterador para recorrer la lista.*/
    MiIterador<T> getIterador();
    /** Vacía la lista eliminando todos sus elementos.*/
    void vaciar();
    /** Comprueba si un elemento existe en la lista.*/
    boolean existe(T dato);
    /** Devuelve el elemento en la posición indicada.*/
    T obtenerPorPosicion(int puesto);
    /** Reemplaza el dato en la posición indicada por un nuevo dato.*/
    void cambiarEnPosicion(int puesto, T nuevoDato);
    /** Devuelve una representación en texto de la lista.*/
    String mostrarLista();
}