package ColaPrioridad;
import LDE.LDEOrdenada;
/**
 * Representa una cola de prioridad máxima genérica.
 * Los elementos se ordenan internamente usando una LDEOrdenada, de forma que el elemento con mayor prioridad siempre está al final.
 */
public class ColaPrioridadMax<T extends Comparable<T>> {
    private LDEOrdenada<T> lista=new LDEOrdenada<>(); // Lista ordenada interna que gestiona la prioridad
    /** Inserta un dato en la cola manteniendo el orden por prioridad.*/
    public void enqueue(T dato){
        lista.add(dato); // Delegamos en la LDEOrdenada para insertar en orden
    }
    /** Elimina y devuelve el elemento con mayor prioridad.*/
    public T dequeue(){
        if(lista.isEmpty()){
            throw new IllegalStateException("No se puede hacer dequeu: la cola de prioridad está vacia "); // Lanzamos la excepción porque el estado es incorrecto
        }
        return lista.removeLast(); // El elemento de mayor prioridad está al final
    }
    /** Devuelve el elemento con mayor prioridad sin eliminarlo.*/
    public T peekMax(){
        if(lista.isEmpty()){
            throw new IllegalStateException("No se puede hacer peek: la cola de prioridad está vacia "); // Lanzamos la excepción porque el estado es incorrecto
        }
        return lista.getLast(); // El elemento de mayor prioridad está al final
    }
    /** Devuelve true si la cola está vacía, false si no.*/
    public boolean isEmpty(){
        return lista.isEmpty(); // Delegamos en la LDEOrdenada
    }
    /** Devuelve el número de elementos de la cola.*/
    public int size(){
        return lista.getSize(); // Delegamos en la LDEOrdenada
    }
    /** Vacía la cola eliminando todos los elementos.*/
    public void clear(){
        lista.clear(); // Delegamos en la LDEOrdenada
    }

    /** Devuelve el elemento con menor prioridad sin eliminarlo.*/
    public T peekMin(){
        if(lista.isEmpty()){
            throw new IllegalStateException("No se puede hacer peek: la cola de prioridad está vacia "); // Lanzamos la excepción porque el estado es incorrecto
        }
        return lista.getFirst(); // El elemento de menor prioridad está al inicio
    }
    /** Elimina y devuelve el elemento con menor prioridad.*/
    public T dequeueMin(){
        if(lista.isEmpty()){
            throw new IllegalStateException("No se puede hacer dequeuMin: la cola de prioridad está vacia "); // Lanzamos la excepción porque el estado es incorrecto
        }
        return lista.removeFirst(); // El elemento de menor prioridad está al inicio
    }
    /** Devuelve una representación en texto de la cola.*/
    public String toString(){
        return lista.toString(); // Delegamos en la LDEOrdenada
    }
    /** Comprueba si un dato existe en la cola.*/
    public boolean contains(T dato){
        return lista.get(dato)!=null; // Buscamos el dato en la LDEOrdenada
    }
    /**
     * Reemplaza un dato existente por uno nuevo manteniendo el orden.
     * Si el dato viejo no existe devuelve null.
     */
    public T replace(T datoviejo, T datonuevo){
        if(lista.get(datoviejo)!=null){
            lista.del(datoviejo);    // Eliminamos el dato viejo
            lista.add(datonuevo);    // Insertamos el nuevo dato en su posición correcta
            return lista.get(datonuevo); // Devolvemos el nuevo dato insertado
        }
        return null; // Si el dato viejo no existe devolvemos null
    }
}
