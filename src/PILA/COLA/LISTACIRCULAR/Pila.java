package PILA.COLA.LISTACIRCULAR;

public class Pila <T extends Comparable<T>>{
    private Elemento<T> cabeza;

    public void push(T dato){
        Elemento<T>nuevo=new Elemento<>(dato);
        nuevo.setSiguiente(cabeza);
        cabeza=nuevo;
    }
    public T pop(){
        if(cabeza==null){
            return null;
        }
        T dato= cabeza.getDato();
        cabeza=cabeza.getSiguiente();
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