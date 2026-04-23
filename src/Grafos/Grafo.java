package Grafos;
import LSE.ListaSimplementeEnlazada;

public class Grafo {

    // Lista de adyacencia que almacena todos los nodos del grafo y sus aristas
    private ListaSimplementeEnlazada<EntradaAdyacencia> entradas;
    // Contador para asignar un id único a cada nuevo nodo que añadamos
    private int contador;

    // Constructor: crea un grafo vacío con el contador iniciado en el valor que le pasamos
    public Grafo(int contador) {
        this.entradas = new ListaSimplementeEnlazada<>(); // La lista de nodos empieza vacía
        this.contador = contador;
    }

    // Busca en la lista de adyacencia el nodo con el nombre que le pasamos
    // Si lo encuentra devuelve su entrada, si no existe devuelve null
    public EntradaAdyacencia buscarEntrada(String nombre) {
        for (int i = 0; i < entradas.getSize(); i++) {
            if (entradas.getAt(i).getNodo().compareTo(new Nodo(0, nombre)) == 0) {
                return entradas.getAt(i); // Devolvemos la entrada cuando encontramos el nodo
            }
        }
        return null; // Si terminamos el bucle sin encontrarlo devolvemos null
    }

    // Añade un nuevo nodo con el nombre que le pasamos
    // Si ya existe un nodo con ese nombre no hace nada para no tener duplicados
    public void agregarNodo(String nombre) {
        if (buscarEntrada(nombre) == null) {
            Nodo nuevoNodo = new Nodo(contador, nombre);                       // Creamos el nodo con el id actual del contador
            EntradaAdyacencia nuevaEntrada = new EntradaAdyacencia(nuevoNodo); // Creamos su entrada en la lista de adyacencia
            entradas.add(nuevaEntrada); // Añadimos la entrada al grafo
            contador++;                 // Incrementamos el contador para que el siguiente nodo tenga un id diferente
        }
    }

    // Añade una arista dirigida desde el nodo origen hasta el nodo destino con la etiqueta que le pasamos
    // Si alguno de los dos nodos no existe en el grafo lo crea antes de añadir la arista
    // Al ser un grafo dirigido la arista solo aparece en la lista del nodo origen
    public void agregarArista(String origen, String destino, String etiqueta) {
        agregarNodo(origen);  // Creamos el nodo origen si no existe todavía
        agregarNodo(destino); // Creamos el nodo destino si no existe todavía
        EntradaAdyacencia entradaOrigen  = buscarEntrada(origen);  // Buscamos la entrada del nodo origen
        EntradaAdyacencia entradaDestino = buscarEntrada(destino); // Buscamos la entrada del nodo destino
        Arista arista = new Arista(entradaOrigen.getNodo(), etiqueta, entradaDestino.getNodo()); // Creamos la arista entre los dos nodos
        entradaOrigen.getAristas().add(arista); // Añadimos la arista a la lista del nodo origen
    }
}
