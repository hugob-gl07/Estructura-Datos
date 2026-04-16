package Arboles.ArbolBusquedaBinaria;
import LSE.Iterador;
import LSE.ListaSimplementeEnlazada;
/**
 * Subclase de ArbolBusquedaBinaria especializada para trabajar con números enteros.
 * Añade la operación de calcular la suma de todos los elementos insertados.
 */
public class ArbolBusquedaBinariaEnteros extends ArbolBusquedaBinaria<Integer> {
    /**
     * Calcula la suma de todos los elementos almacenados en el árbol.
     * Recorre los elementos en orden central y los acumula.
     * @return suma de todos los enteros del árbol, 0 si el árbol está vacío
     */
    public int getSuma() {
        ListaSimplementeEnlazada<Integer> lista = getListaOrdenadaCentral();
        Iterador<Integer> iterador = lista.getIterador();
        int suma = 0;
        while (iterador.hasNext()) {
            suma += iterador.next();
        }
        return suma;
    }
}
