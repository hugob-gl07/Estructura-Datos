package LSE;

public class LSEOrdenada<T extends Comparable<T>> extends ListaSimplementeEnlazada<T>{

    @Override
    public void add(T dato) {
        ElementoSE<T> nuevo= new ElementoSE<>(dato); // Creamos una nuevo nodo que envuelve el dato
        if( primero==null || dato.compareTo(primero.dato)<0 ){ // Comparamos si la lista está vacia o si el dato es menor al primer para insertarlo al incio
            nuevo.siguiente=primero; // El siguiente del nuevo se convierte ahora nuestro dato primero
            primero=nuevo; // El dato primero ahora se convierte en el nuevo
            tamaño++; // Incrementamos el tamaño de la lista
        }
        else {
            ElementoSE<T>actual= primero; // Creamos el elemento actual que debe ser igual que el primero
                while (actual.siguiente!=null && actual.siguiente.dato.compareTo(dato)<0){ // Comparamos que exista elemento siguiente al actual y que este sea menor al dato que queremos

                    actual=actual.siguiente; // Si se cumple, entonces nuestro elemento actual se convierte en el siguiente a si mísmo
            }
            nuevo.siguiente=actual.siguiente; // El siguiente nodo al nuevo se convierte en el elemento siguiente al actual
            actual.siguiente=nuevo; // El elemento siguiente al actual se convierte en el nuevo
            tamaño++ ;// Incrementamos el tamaño de la lista
        }
    }
}
