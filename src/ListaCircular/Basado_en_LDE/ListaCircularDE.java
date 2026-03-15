package ListaCircular.Basado_en_LDE;
/**
 * Representa una lista circular doblemente enlazada genérica y ordenable.
 * El último elemento apunta al primero y el primero apunta al último, formando un círculo infinito.
*/
public class ListaCircularDE<T extends Comparable<T>> {
    protected ElementoDE<T> primero;
    protected ElementoDE<T> ultimo;
    protected int tamaño;
    /** Constructor por defecto. Inicializa la lista vacía con primero y ultimo a null y tamaño a 0.*/
    public ListaCircularDE() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }
    /** Inserta un elemento al final de la lista manteniendo la estructura circular.*/
    public void add(T dato) {
        ElementoDE<T> nuevo = new ElementoDE<>(dato); // Creamos un nuevo elemento con el dato
        if (isEmpty()) {
            primero = nuevo;
            ultimo = nuevo;
            primero.siguiente = primero; // El único elemento se apunta a sí mismo hacia adelante
            primero.anterior = primero;  // El único elemento se apunta a sí mismo hacia atrás
        } else {
            nuevo.anterior = ultimo;   // El nuevo apunta hacia atrás al último
            nuevo.siguiente = primero; // El nuevo apunta hacia adelante al primero
            ultimo.siguiente = nuevo;  // El último apunta al nuevo elemento
            primero.anterior = nuevo;  // El primero apunta hacia atrás al nuevo elemento
            ultimo = nuevo;            // El nuevo elemento pasa a ser el último
        }
        tamaño++; // Incrementamos el tamaño
    }
    /** Busca y devuelve un elemento por valor recorriendo una vuelta completa.*/
    public T get(T dato) {
        if (isEmpty()) return null; // Si la lista está vacía devolvemos null
        ElementoDE<T> aux = primero; // Empezamos desde el primer elemento
        int cont = 0;
        while (cont < tamaño) { // Recorremos solo una vuelta usando el tamaño como límite
            if (aux.dato.equals(dato)) return aux.dato; // Si el dato coincide lo devolvemos
            aux = aux.siguiente; // Avanzamos al siguiente elemento
            cont++; // Incrementamos el contador
        }
        return null; // Si no encontramos el dato devolvemos null
    }
    /** Busca y elimina un elemento por valor manteniendo la estructura circular.*/
    public T del(T dato) {
        if (isEmpty()) return null; // Si la lista está vacía devolvemos null
        ElementoDE<T> aux = primero; // Empezamos desde el primer elemento
        for (int i = 0; i < tamaño; i++) {
            if (aux.dato.equals(dato)) {
                if (tamaño == 1) {
                    primero = ultimo = null; // Si solo hay un elemento vaciamos la lista
                } else {
                    aux.anterior.siguiente = aux.siguiente; // El anterior apunta al siguiente del eliminado
                    aux.siguiente.anterior = aux.anterior;  // El siguiente apunta hacia atrás al anterior del eliminado
                    if (aux == primero) primero = aux.siguiente; // Si era el primero actualizamos el puntero primero
                    if (aux == ultimo) ultimo = aux.anterior;    // Si era el último actualizamos el puntero ultimo
                }
                tamaño--; // Decrementamos el tamaño
                return aux.dato; // Devolvemos el dato eliminado
            }
            aux = aux.siguiente; // Avanzamos al siguiente elemento
        }
        return null; // Si no encontramos el dato devolvemos null
    }
    /** Devuelve true si la lista está vacía, false si no.*/
    public boolean isEmpty() {
        return primero == null; // Si el primero es null la lista está vacía
    }
    /** Devuelve el número de elementos de la lista.*/
    public int getSize() {
        return tamaño; // Devolvemos el contador de elementos
    }
    /** Devuelve un iterador circular que recorre la lista exactamente una vuelta.*/
    public MiIterador<T> getIterador() {
        return new IteradorCircular<>(primero, tamaño); // Creamos un iterador comenzando desde el primero
    }
    /** Vacía la lista eliminando todos sus elementos.*/
    public void vaciar() {
        this.primero = null; // El primer elemento ya no apunta a nada
        this.ultimo = null;  // El último elemento ya no apunta a nada
        this.tamaño = 0;     // Reiniciamos el contador
        System.out.println("ListaCircular.Basado_en_LDE.Lista circular doble vaciada.");
    }
    /** Comprueba si un elemento existe en la lista recorriendo una vuelta completa.*/
    public boolean existe(T dato) {
        if (isEmpty()) return false; // Si la lista está vacía devolvemos false
        ElementoDE<T> aux = primero; // Empezamos desde el primer elemento
        for (int i = 0; i < tamaño; i++) { // Recorremos usando el tamaño como límite
            if (aux.dato.equals(dato)) {
                return true; // Si encontramos el dato devolvemos true
            }
            aux = aux.siguiente; // Avanzamos al siguiente elemento
        }
        return false; // Si no encontramos el dato devolvemos false
    }
    /** Devuelve el elemento en la posición indicada recorriendo desde el primero.*/
    public T obtenerPorPosicion(int puesto) {
        if (puesto < 0 || puesto >= tamaño) {
            System.out.println("Error: No existe esa posición."); // La posición está fuera del rango válido
            return null;
        }
        ElementoDE<T> aux = primero; // Empezamos desde el primer elemento
        for (int i = 0; i < puesto; i++) {
            aux = aux.siguiente; // Avanzamos hasta la posición indicada
        }
        return aux.dato; // Devolvemos el dato en esa posición
    }
    /** Reemplaza el dato en la posición indicada por un nuevo dato sin crear un nuevo nodo.*/
    public void cambiarEnPosicion(int puesto, T nuevoDato) {
        if (puesto < 0 || puesto >= tamaño) {
            System.out.println("Error: Índice fuera de rango."); // La posición está fuera del rango válido
            return;
        }
        ElementoDE<T> aux = primero; // Empezamos desde el primer elemento
        for (int i = 0; i < puesto; i++) {
            aux = aux.siguiente; // Avanzamos hasta la posición indicada
        }
        aux.dato = nuevoDato; // Reemplazamos el dato sin crear un nuevo nodo
    }

    /** Devuelve una representación en texto de la lista con estilo circular doble.*/
    public String mostrarLista() {
        if (isEmpty()) return "ListaCircular.Basado_en_LDE.Lista circular doble vacía"; // Si la lista está vacía devolvemos mensaje
        String resultado = "(Infinito) <-> "; // Indicamos el inicio circular
        ElementoDE<T> aux = primero; // Empezamos desde el primer elemento
        for (int i = 0; i < tamaño; i++) {
            resultado = resultado + "[" + aux.dato + "]"; // Añadimos el dato al resultado
            resultado = resultado + " <=> ";              // Conectamos cada elemento con flecha doble
            aux = aux.siguiente;                          // Avanzamos al siguiente elemento
        }
        resultado = resultado + "(Infinito)"; // Indicamos el fin circular
        return resultado; // Devuelve resultado
    }
}