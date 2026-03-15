package ListaCircular.Basado_en_LSE;
/**
 * Representa una lista circular simplemente enlazada genérica y ordenable.
 * El último elemento apunta al primero formando un círculo.
 */
public class ListaCircularSE<T extends Comparable<T>> implements Lista<T> {
    protected ElementoSE<T> primero;
    protected ElementoSE<T> ultimo; // Mantener el último nos ahorra mucho trabajo
    protected int tamaño;
    /** Constructor por defecto. Inicializa la lista vacía con primero y último a null y tamaño a 0.*/
    public ListaCircularSE() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }
    /** Inserta un elemento al final de la lista manteniendo la estructura circular.*/
    @Override
    public void add(T dato) {
        ElementoSE<T> nuevo = new ElementoSE<>(dato); // Creamos un nuevo elemento con el dato
        if (isEmpty()) {
            primero = nuevo;
            ultimo = nuevo;
            ultimo.siguiente = primero; // El único elemento apunta a sí mismo cerrando el círculo
        } else {
            ultimo.siguiente = nuevo;   // El último apunta al nuevo elemento
            nuevo.siguiente = primero;  // El nuevo apunta al primero para cerrar el círculo
            ultimo = nuevo;             // El nuevo elemento pasa a ser el último
        }
        tamaño++; // Incrementamos el tamaño
    }
    /** Busca y devuelve un elemento por valor recorriendo una vuelta completa.*/
    @Override
    public T get(T dato) {
        if (isEmpty()) return null; // Si la lista está vacía devolvemos null
        ElementoSE<T> aux = primero; // Empezamos desde el primer elemento
        for (int i = 0; i < tamaño; i++) { // Recorremos usando el tamaño como límite
            if (aux.dato.equals(dato)) return aux.dato; // Si el dato coincide lo devolvemos
            aux = aux.siguiente; // Avanzamos al siguiente elemento
        }
        return null; // Si no encontramos el dato devolvemos null
    }
    /** Busca y elimina un elemento por valor manteniendo la estructura circular.*/
    @Override
    public T del(T dato) {
        if (isEmpty()) return null; // Si la lista está vacía devolvemos null
        ElementoSE<T> actual = primero;
        ElementoSE<T> anterior = ultimo; // En una circular el anterior al primero es el último
        for (int i = 0; i < tamaño; i++) {
            if (actual.dato.equals(dato)) {
                if (tamaño == 1) {
                    primero = null; // Si solo hay un elemento vaciamos la lista
                    ultimo = null;
                } else {
                    anterior.siguiente = actual.siguiente; // El anterior apunta al siguiente del eliminado
                    if (actual == primero) primero = actual.siguiente; // Si era el primero actualizamos el puntero primero
                    if (actual == ultimo) ultimo = anterior;           // Si era el último actualizamos el puntero ultimo
                }
                tamaño--; // Decrementamos el tamaño
                return actual.dato; // Devolvemos el dato eliminado
            }
            anterior = actual;           // Avanzamos el puntero anterior
            actual = actual.siguiente;   // Avanzamos al siguiente elemento
        }
        return null; // Si no encontramos el dato devolvemos null
    }
    /** Devuelve true si la lista está vacía, false si no.*/
    @Override
    public boolean isEmpty() {
        return primero == null; // Si el primero es null la lista está vacía
    }
    /** Devuelve el número de elementos de la lista.*/
    @Override
    public int getSize() {
        return tamaño; // Devolvemos el contador de elementos
    }
    /** Devuelve un iterador circular que recorre la lista exactamente una vuelta.*/
    @Override
    public MiIterador<T> getIterador() {
        return new IteradorCircularSE<>(primero, tamaño); // Creamos un iterador comenzando desde el primero
    }
    /** Vacía la lista eliminando todos sus elementos.*/
    @Override
    public void vaciar() {
        this.primero = null; // El primer elemento ya no apunta a nada
        this.ultimo = null;  // El último elemento ya no apunta a nada
        this.tamaño = 0;     // Reiniciamos el contador
        System.out.println("ListaCircular.Basado_en_LDE.Lista circular vaciada.");
    }
    /** Comprueba si un elemento existe en la lista recorriendo una vuelta completa.*/
    @Override
    public boolean existe(T dato) {
        if (isEmpty()) return false; // Si la lista está vacía devolvemos false
        ElementoSE<T> aux = primero; // Empezamos desde el primer elemento
        for (int i = 0; i < tamaño; i++) { // Recorremos usando el tamaño como límite
            if (aux.dato.equals(dato)) {
                return true; // Si encontramos el dato devolvemos true
            }
            aux = aux.siguiente; // Avanzamos al siguiente elemento
        }
        return false; // Si no encontramos el dato devolvemos false
    }
    /** Devuelve el elemento en la posición indicada recorriendo desde el primero.*/
    @Override
    public T obtenerPorPosicion(int puesto) {
        if (puesto < 0 || puesto >= tamaño) {
            System.out.println("Error: Posición inválida"); // La posición está fuera del rango válido
            return null;
        }
        ElementoSE<T> aux = primero; // Empezamos desde el primer elemento
        for (int i = 0; i < puesto; i++) {
            aux = aux.siguiente; // Avanzamos hasta la posición indicada
        }
        return aux.dato; // Devolvemos el dato en esa posición
    }
    /** Reemplaza el dato en la posición indicada por un nuevo dato sin crear un nuevo nodo.*/
    @Override
    public void cambiarEnPosicion(int puesto, T nuevoDato) {
        if (puesto < 0 || puesto >= tamaño) {
            System.out.println("Error: No se puede cambiar"); // La posición está fuera del rango válido
            return;
        }
        ElementoSE<T> aux = primero; // Empezamos desde el primer elemento
        for (int i = 0; i < puesto; i++) {
            aux = aux.siguiente; // Avanzamos hasta la posición indicada
        }
        aux.dato = nuevoDato; // Reemplazamos el dato sin crear un nuevo nodo
    }
    /** Devuelve una representación en texto de la lista con formato circular.*/
    @Override
    public String mostrarLista() {
        if (isEmpty()) return "ListaCircular.Basado_en_LDE.Lista circular vacía"; // Si la lista está vacía devolvemos mensaje
        String resultado = "(Inicio) "; // Indicamos el inicio circular
        ElementoSE<T> aux = primero;    // Empezamos desde el primer elemento
        for (int i = 0; i < tamaño; i++) {
            resultado = resultado + "[" + aux.dato + "]"; // Añadimos el dato al resultado
            resultado = resultado + " -> ";               // Conectamos cada elemento con flecha
            aux = aux.siguiente;                          // Avanzamos al siguiente elemento
        }
        resultado = resultado + "(vuelve al Inicio)"; // Indicamos que el último apunta al primero
        return resultado;
    }
}