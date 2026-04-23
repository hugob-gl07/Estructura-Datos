package Grafos;
import LSE.ListaSimplementeEnlazada;

public class EntradaAdyacencia implements Comparable<EntradaAdyacencia>{

    // Nodo al que pertenece esta entrada
    private Nodo nodo;
    // Lista de aristas que salen del nodo
    private ListaSimplementeEnlazada<Arista> aristas;

    // Constructor: crea una entrada para el nodo que le pasamos con la lista de aristas vacía
    public EntradaAdyacencia(Nodo nodo){
        this.nodo = nodo;
        this.aristas = new ListaSimplementeEnlazada<>(); // La lista de aristas empieza vacía
    }

    // Devuelve el nodo de esta entrada
    public Nodo getNodo(){
        return this.nodo;
    }

    // Cambia el nodo de esta entrada por el que le pasamos
    public void setNodo(Nodo nodo){
        this.nodo = nodo;
    }

    // Devuelve la lista de aristas que salen del nodo
    public ListaSimplementeEnlazada<Arista> getAristas(){
        return this.aristas;
    }

    // Cambia la lista de aristas de esta entrada por la que le pasamos
    public void setAristas(ListaSimplementeEnlazada aristas){
        this.aristas = aristas;
    }

    // Compara esta entrada con otra usando el nombre del nodo en orden alfabético
    // Devuelve 0 si son iguales, un número negativo si esta va antes y positivo si va después
    @Override
    public int compareTo(EntradaAdyacencia o) {
        return this.nodo.compareTo(o.nodo); // Delega la comparación en el compareTo del nodo
    }
}
