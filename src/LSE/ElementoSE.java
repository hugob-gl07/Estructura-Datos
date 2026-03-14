package LSE;

public class ElementoSE<T> {
    protected T dato;
    protected ElementoSE<T> siguiente;
    // Constructor por defecto
    public ElementoSE(T dato){
        this.dato=dato;
        this.siguiente=null;
    }

}
