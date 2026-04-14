package ArbolBinario;

import LSE.Iterador;
import LSE.ListaSimplementeEnlazada;

public class ArbolBusquedaBinariaEnteros extends ArbolBusquedaBinaria <Integer> {
    public int getSuma(){
        ListaSimplementeEnlazada<Integer> lista = getListaOrdenadaCentral();
        Iterador<Integer> iterador = lista.getIterador();
        int suma=0;
        while(iterador.hasNext()){
            suma+=iterador.next();
        }
        return suma;
    }
}
