package LDE;

public class ElementoDE<T>{
    protected T dato;
    protected ElementoDE<T>siguiente;
    protected ElementoDE<T>anterior;
    public ElementoDE(T dato){
        this.dato=dato;
        this.siguiente=null;
        this.anterior=null;
    }
}
