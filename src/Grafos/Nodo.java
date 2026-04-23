package Grafos;
public class Nodo implements Comparable<Nodo>{

    // Id único que identifica al nodo dentro del grafo
    private int id;
    // Nombre del nodo
    private String nombre;

    // Constructor: crea un nodo con el id y el nombre que le pasamos
    public Nodo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Devuelve el id del nodo
    public int getId() {
        return id;
    }

    // Devuelve el nombre del nodo
    public String getNombre() {
        return nombre;
    }

    // Cambia el nombre del nodo por el que le pasamos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Cambia el id del nodo por el que le pasamos
    public void setId(int id) {
        this.id = id;
    }

    // Compara este nodo con otro por su nombre en orden alfabético
    // Devuelve 0 si son iguales, un número negativo si este va antes y positivo si va después
    @Override
    public int compareTo(Nodo otro){
        return this.nombre.compareTo(otro.nombre);
    }
}
