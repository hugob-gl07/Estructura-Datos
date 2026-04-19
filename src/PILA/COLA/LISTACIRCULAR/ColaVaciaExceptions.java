package PILA.COLA.LISTACIRCULAR;

public class ColaVaciaExceptions extends RuntimeException {
    public ColaVaciaExceptions(){
        super("La cola esta vacia");
    }
    public ColaVaciaExceptions(String message) {
        super(message);
    }
}
