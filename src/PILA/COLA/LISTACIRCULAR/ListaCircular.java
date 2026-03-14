package PILA.COLA.LISTACIRCULAR;

public class ListaCircular<T extends Comparable<T>>{
    private Elemento<T> siguiente;
    private Elemento<T> cabeza;
    public void insertar(T dato){
        Elemento<T> nuevo= new Elemento<>(dato);
        if(cabeza==null){
            cabeza=nuevo;
            nuevo.setSiguiente(nuevo);
        }
        else {
            Elemento<T> actual =cabeza;
            while (actual.getSiguiente()!=cabeza){
                actual=actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
            nuevo.setSiguiente(cabeza);
        }
    }
    public T eliminar(){
        if(cabeza==null){
            return null;
        }
        T dato=cabeza.getDato();
        if(cabeza.getSiguiente()==cabeza){
            cabeza=null;
        }
        else {
            Elemento<T>nuevo=cabeza;
            while (nuevo.getSiguiente()!=cabeza){
                nuevo=nuevo.getSiguiente();
            }
            nuevo.setSiguiente(cabeza);
            cabeza=cabeza.getSiguiente();
        }
        return dato;



    }
}
