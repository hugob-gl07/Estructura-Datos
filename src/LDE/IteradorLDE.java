package LDE;

public class IteradorLDE <T> implements Iterador<T>{
    private ElementoDE<T>actual;

    public IteradorLDE(ElementoDE<T> inicio) {
        this.actual =inicio;
    }
    @Override
    public T next() {
        T dato= actual.dato;
        actual=actual.siguiente;
        return dato;
    }
    @Override
    public boolean hasNext() {
        return actual != null;
    }

}
