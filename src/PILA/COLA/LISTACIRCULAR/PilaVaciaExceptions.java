package PILA.COLA.LISTACIRCULAR;

public class PilaVaciaExceptions extends RuntimeException{
    public PilaVaciaExceptions(){
        super("La pila esta vacia");
    }
    public PilaVaciaExceptions(String msg){
        super(msg);
    }
}
