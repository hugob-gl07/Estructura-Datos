package Grafos;

public class Arista implements Comparable<Arista>{

    // Nodo desde el que sale la arista
    private Nodo origen;
    // Nodo al que llega la arista
    private Nodo destino;
    // Nombre o etiqueta que identifica la arista
    private String etiqueta;

    // Constructor: crea una arista con el nodo origen, la etiqueta y el nodo destino que le pasamos
    public Arista(Nodo origen, String etiqueta, Nodo destino) {
        this.origen = origen;
        this.destino = destino;
        this.etiqueta = etiqueta;
    }

    // Devuelve el nodo al que llega la arista
    public Nodo getDestino() {
        return destino;
    }

    // Cambia el nodo destino de la arista por el que le pasamos
    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    // Devuelve la etiqueta de la arista
    public String getEtiqueta() {
        return etiqueta;
    }

    // Cambia la etiqueta de la arista por la que le pasamos
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    // Devuelve el nodo desde el que sale la arista
    public Nodo getOrigen() {
        return origen;
    }

    // Cambia el nodo origen de la arista por el que le pasamos
    public void setOrigen(Nodo origen) {
        this.origen = origen;
    }

    // Compara esta arista con otra por su etiqueta en orden alfabético
    // Devuelve 0 si son iguales, un número negativo si esta va antes y positivo si va después
    @Override
    public int compareTo(Arista otra) {
        return this.etiqueta.compareTo(otra.etiqueta);
    }
}
