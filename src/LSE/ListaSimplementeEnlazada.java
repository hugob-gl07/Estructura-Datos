package LSE;

public class ListaSimplementeEnlazada<T extends Comparable<T>>{
    protected ElementoSE<T> primero;
    protected int tamaño;
    //Constructor por defecto de ListaSimplemente Enlazada
    public ListaSimplementeEnlazada(){
        this.primero=null; // Inicializamos la lista vacia: el primer elemento no apunta a nada
        this.tamaño=0; // El tamaño de la lista está vacia
    }
    // Creamos el metodo para añadir elementos
    public void add(T dato){
        ElementoSE<T> nuevo=new ElementoSE<>(dato); // Creamos un elemento nuevo del tipo T

        // Comprobamos si la lista esta vacia
        if (primero==null){
            primero=nuevo; // El nuevo nodo se convierte en la cabeza de la lista
        }
        // Si no está vacia, buscamos el final para crear el nuevo nodo
        else {
            ElementoSE<T>actual=primero;
            while(actual.siguiente!=null){
                actual=actual.siguiente;
            }
            actual.siguiente=nuevo; // Conectamos el nuevo nodo después del último
        }
        tamaño++; // Incrementamos el tamaño de la lista
    }
    public T addFirst(T dato) {
        ElementoSE<T> nuevo = new ElementoSE<>(dato);
        nuevo.siguiente = primero;  // 1️⃣ nuevo apunta al viejo primero
        primero = nuevo;            // 2️⃣ primero ahora es el nuevo
        tamaño++;
        return nuevo.dato;
    }
    // Creamos el metodo para buscar elementos
    public T get(T dato){
        ElementoSE<T> actual=primero; // Creamos el elemento actual que va a ser nuestro primer elemento de la lista
        while (actual!=null){  // Diremos que mientras el elemento actual sea distinto de nulo
            if(actual.dato.compareTo(dato)==0){ // Comparas el dato del nodo con el dato que buscamos
                return actual.dato; // Si coinciden, devolveremos el dato encontrado
            }
            actual=actual.siguiente; //Si no, avanzamos el puntero al siguiente nodo
            }
        return null; // Si terminamos el bucle y no hemos encontrado el elemento me devuelves nullo
        }
    // Creamos nuestro metodo para eliminar elementos de la lista
    public T del(T dato){
        if(primero==null){  // Si el primer elemento de la lista es igual al nulo
            return null; // Devuelveme nulo
        }
        if (primero.dato.compareTo(dato)==0){ // Si el dato que queremos borrar está en el primer nodo
            ElementoSE<T>actual=primero; // Guardamos el nodo actual para no perder el dato
            primero=actual.siguiente; // El segundo nodo pasa a ser el nuevo primero
            actual.siguiente=null; // Liberar Memoria
            tamaño--; // Decrementamos el tamaño de la lista
            return actual.dato; // Devolvemos el dato del nodo eliminado

        }
        ElementoSE<T>anterior=primero; // Creamos ahora nuestro elemento anterior el cual va a ser el primer elemento de la lista
        ElementoSE<T>actual=primero.siguiente; // Creamos el elemento actual que va a ser el siguiente elemento al primero

        while (actual!=null){ // Cuando mi elemento actual es distinto del nulo
            if(actual.dato.compareTo(dato)==0){ // Hacemos un "salto": el elemento anterior apunto al elemento que va despues del actual
                anterior.siguiente=actual.siguiente; //Si es verdad, el elemento siguiente del anterior se convierte en el elemento siguiente del siguiente
                actual.siguiente=null; //Liberar memoria
                tamaño--; //Decrementamos el tamaño
                return actual.dato; // Devolvemos el dato que borramos
            }
            anterior=actual; // Ahora mi dato anterior se convierte en el actual
            actual=actual.siguiente; // Ahora mi dato actual se convierte en el siguiente a él
        }
        return null; //Devolvemos nulo si no hemos encontrado el elemento buscado
    }

    public boolean isEmpty(){ //Devolvemos verdadero si el tamaño de la lista es igual a 0 y falso si el tamñano de la lista es distinto de 0
            return tamaño==0;
    }
    public int getSize(){ // Devolvemos el tamaño de la lista
        return tamaño;
    }

    public Iterador<T> getIterador(){ // Creamos este metodo para que el usuario pueda recorrer la lista sin saber la composición de la que está hecha.
        return new IteradorLSE<T>(primero); // Fabricamos un iterador y le decimos que comience en el 'primero' de nuestra lista
    }
    public T getAt(int posición){ //Obtenemos el dato en función de la posición en la que se encuentre
        if (posición>=tamaño || posición<0){ // Observamos que ni la posición sea negativa o mayor que el tamaño de la lista
            return null; // Devolvemos null
        }
        ElementoSE<T>actual=primero; //Creamos un nodo "actual" que apunte al primer elemento
        int contador=0; // Inicializamos un contador
        while (contador<posición){ // Si nuestro contador es menor que la posición
            actual=actual.siguiente; //El nodo "actual" pasa al siguiente elemento a él
            contador++; //El contador se incrementa uno
        }
        return actual.dato; //Devolvemos el dato
    }
    public T insertAt(int posición, T dato){
        if (posición>tamaño || posición<0){
            return null;
        }
        if (posición==0){
            ElementoSE<T> nuevo=new ElementoSE<>(dato);
            nuevo.siguiente=primero;
            primero=nuevo;
            tamaño++;
            return dato;
        }
        if (posición==tamaño){
            add(dato);
            return dato;
        }
        ElementoSE<T> anterior=primero;
        int contador=0;
        while (contador<posición-1){
            anterior=anterior.siguiente;
            contador++;
        }
        ElementoSE<T>nuevo=new ElementoSE<>(dato);
        nuevo.siguiente=anterior.siguiente;
        anterior.siguiente=nuevo;
        tamaño++;
        return dato;
    }

    public T removeAt(int posición){
        if (posición<0 ||posición>=tamaño){
            return null;
        }
        if (posición==0){
            ElementoSE<T>actual=primero;
            primero=actual.siguiente;
            tamaño--;
            return actual.dato;
        }
        ElementoSE<T>anterior=primero;
        int contador=0;
        while (contador<posición-1){
            anterior=anterior.siguiente;
            contador++;
        }
        ElementoSE<T>borrar=anterior.siguiente;
        anterior.siguiente=borrar.siguiente;
        tamaño--;
        return borrar.dato;
    }
    @Override
    public String toString() {
        if (tamaño == 0) return "[]";

        String resultado = "[";
        ElementoSE<T> actual = primero;  // ← ElementoSE (Simple)

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
