package LDE;

public class ListaDoblementeEnlazada<T extends Comparable<T>> {
    protected ElementoDE<T> primero;
    protected ElementoDE<T> ultimo;
    protected int tamaño;

    public ListaDoblementeEnlazada(){
        this.primero=null;
        this.ultimo=null;
        this.tamaño=0;
    }
    public void add(T dato){
        ElementoDE<T>nuevo=new ElementoDE<>(dato);

        if(tamaño==0){
            primero=nuevo;
            ultimo=nuevo;
        }
        else{
            ultimo.siguiente=nuevo;
            nuevo.anterior=ultimo;
            ultimo=nuevo;
        }
        tamaño++;
    }
    public T addFirst(T dato){
        ElementoDE<T>nuevo=new ElementoDE<>(dato);
        if (tamaño==0){
            primero=nuevo;
            ultimo=nuevo;
        }
        else {
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo;
        }
        tamaño++;
        return nuevo.dato;
    }

    public T get(T dato){
        ElementoDE<T>actual=primero;
        while (actual!=null){
            if(actual.dato.compareTo(dato)==0){
                return actual.dato;
            }
            actual=actual.siguiente;
        }
        return null;
    }
    public T del(T dato){
        ElementoDE<T>actual=primero;
        while(actual!=null&& actual.dato.compareTo(dato)!=0){
            actual=actual.siguiente;
        }
        if (actual==null){
            return null;
        }
        if (actual==primero){
            primero=actual.siguiente;
            if(primero!=null){
                primero.anterior=null;
            }
            else {
                ultimo=null;
            }
        }
        else if(actual==ultimo){
            ultimo=actual.anterior;
            if(ultimo!=null) {
                ultimo.siguiente = null;
            }
            else {
                primero=null;
            }
        }
        else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }
        tamaño--;
        return actual.dato;
    }
    public T getAt(int posicion){

        if(posicion<0||posicion>=tamaño){
            return null;
        }
        ElementoDE<T>actual=null;
        if (posicion<tamaño/2){
            actual=primero;
            int contador=0;
            while (contador<posicion){
                actual=actual.siguiente;
                contador++;
            }
        }
       else {
            actual=ultimo;
            int contador=tamaño-1;
            while (contador>posicion){
                actual=actual.anterior;
                contador--;
            }
        }
        return actual.dato;
    }

    public T insertAt(int posicion, T dato){
        if (posicion<0 || posicion>tamaño){
            return null;
        }
        if (posicion==0){
            return addFirst(dato);
        }
        if (posicion==tamaño) {
            return add(dato);
        }
        ElementoDE<T>actual=null;
        if(posicion<tamaño/2){
            actual=primero;
            int contador=0;
            while(contador<posicion){
                actual=actual.siguiente;
                contador++;
            }
        }
        else{
            actual=ultimo;
            int contador=tamaño-1;
            while(contador>posicion){
                actual=actual.anterior;
                contador--;
            }
        }
        ElementoDE<T>nuevo=new ElementoDE<>(dato);
        nuevo.siguiente=actual;
        nuevo.anterior=actual.anterior;
        actual.anterior.siguiente=nuevo;
        actual.anterior=nuevo;
        tamaño++;
        return nuevo.dato;
    }
    public T removeAt(int posicion) {
        if (posicion < 0 || posicion >= tamaño) {
            return null;
        }
        ElementoDE<T> actual = null;

        if (posicion < tamaño / 2) {
            actual = primero;
            int contador = 0;
            while (contador < posicion) {
                actual = actual.siguiente;
                contador++;
            }
        }
        else {
            actual = ultimo;
            int contador = tamaño - 1;
            while (contador > posicion) {
                actual = actual.anterior;
                contador--;
            }
        }

        if (actual == primero) {
            primero = primero.siguiente;
            if (primero != null) {
                primero.anterior = null;
            }
            else {
                ultimo = null;
            }
        }
        else if (actual == ultimo) {
            ultimo = ultimo.anterior;
            if (ultimo != null) {
                ultimo.siguiente = null;
            }
            else {
                primero = null;
            }
        }
        else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }
        tamaño--;
        return actual.dato;
    }
    public Iterador<T> getIterador(){
        return new IteradorLDE<T>(this.primero);
    }
    public boolean isEmpty(){ //Devolvemos verdadero si el tamaño de la lista es igual a 0 y falso si el tamñano de la lista es distinto de 0
        return primero==null;
    }
    public int getSize(){ // Devolvemos el tamaño de la lista
        return tamaño;
    }
    public int getTamaño() { return tamaño; }
    @Override
    public String toString() {
        if (tamaño == 0) return "[]";
        String resultado = "[";
        ElementoDE<T> actual = primero;

        while (actual != null) {
            resultado = resultado + actual.dato;
            actual = actual.siguiente;
            if (actual != null) {
                resultado = resultado + ", ";
            }
        }
        resultado = resultado + "]";
        return resultado;
    }



}

