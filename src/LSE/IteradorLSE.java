package LSE;

public class IteradorLSE<T> implements Iterador<T> {
    private ElementoSE<T> actual;

    public IteradorLSE(ElementoSE<T> inicio){
        this.actual=inicio;
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
