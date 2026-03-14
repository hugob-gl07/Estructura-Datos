package PILA.COLA.LISTACIRCULAR;

public class Cola <T extends Comparable<T>>{
    private Elemento<T> cabeza;
    private Elemento<T> cola;

    public void enqueue(T dato){
        Elemento<T>nuevo=new Elemento<>(dato);
        if (cabeza==null){
            this.cabeza=nuevo;
            this.cola=nuevo;
        }
        else{
            cola.setSiguiente(nuevo);
            cola=nuevo;
        }
    }
    public T dequeue(){
        if (cabeza==null){
            return null;
        }
        T dato= cabeza.getDato();
        cabeza=cabeza.getSiguiente();
        if (cabeza==null){
            cola=null;
        }
        return dato;
    }
    public T peek(){
        if (cabeza==null){
            return null;
        }
        return cabeza.getDato();
    }
    public boolean isEmpty(){
        return cabeza==null;
    }
}


