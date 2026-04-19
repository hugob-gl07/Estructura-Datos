package PILA.COLA.LISTACIRCULAR;
/**
 * Representa una pila (LIFO) genérica.
 * El último elemento en entrar es el primero en salir.*/
public class Pila<T extends Comparable<T>> {

    private Elemento<T> cabeza; // Puntero al elemento en la cima de la pila
    /** Inserta un dato en la cima de la pila (LIFO).*/
    public void push(T dato){
        Elemento<T>nuevo=new Elemento<>(dato); // Creamos un nuevo elemento con el dato
        nuevo.setSiguiente(cabeza); // El nuevo elemento apunta al que era la cima
        cabeza=nuevo;               // El nuevo elemento pasa a ser la nueva cima
    }
    /** Elimina y devuelve el dato de la cima de la pila (LIFO).*/
    public T pop(){
        if(cabeza==null){
            throw new PilaVaciaExceptions("Error: La pila esta vacía, no podemos eliminar ningún dato") ; // Si la pila está vacía devolvemos null
        }
        T dato= cabeza.getDato();        // Guardamos el dato de la cima para devolverlo
        cabeza=cabeza.getSiguiente();    // El siguiente elemento pasa a ser la nueva cima
        return dato;
    }

    /** Devuelve el dato de la cima de la pila sin eliminarlo. */
    public T peek(){
        if (cabeza==null){
            throw new PilaVaciaExceptions("Error: La pila esta vacía, por lo tanto no puedo devolver el dato cima"); // Si la pila está vacía devolvemos null
        }
        return cabeza.getDato(); // Devolvemos el dato de la cima sin eliminarlo
    }

    /** Devuelve true si la pila está vacía, false si no.*/
    public boolean isEmpty(){
        return cabeza==null; // Si la cabeza es null la pila está vacía
    }
}