package Grafos;
import Colas.Cola.Cola;
import LSE.ListaSimplementeEnlazada;
import Pila.Pila;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Grafo {
    // Lista de adyacencia que almacena todos los nodos del grafo y sus aristas
    private ListaSimplementeEnlazada<EntradaAdyacencia> entradas;
    // Contador para asignar un id único a cada nuevo nodo que añadamos
    private int contador;

    // Constructor: crea un grafo vacío con el contador iniciado en el valor que le pasamos
    public Grafo(int contador) {
        this.entradas = new ListaSimplementeEnlazada<>(); // La lista de nodos empieza vacía
        this.contador = contador;
    }

    // Busca en la lista de adyacencia el nodo con el nombre que le pasamos
    // Si lo encuentra devuelve su entrada, si no existe devuelve null
    public EntradaAdyacencia buscarEntrada(String nombre) {
        EntradaAdyacencia resultado = null;
        for (int i = 0; i < entradas.getSize(); i++) {
            if (entradas.getAt(i).getNodo().compareTo(new Nodo(0, nombre)) == 0) {
                resultado= entradas.getAt(i); // Devolvemos la entrada cuando encontramos el nodo
            }
        }
        return resultado; // Si terminamos el bucle sin encontrarlo devolvemos null
    }
    // Añade un nuevo nodo con el nombre que le pasamos
    // Si ya existe un nodo con ese nombre no hace nada para no tener duplicados
    public void agregarNodo(String nombre) {
        if (buscarEntrada(nombre) == null) {
            Nodo nuevoNodo = new Nodo(contador, nombre);                       // Creamos el nodo con el id actual del contador
            EntradaAdyacencia nuevaEntrada = new EntradaAdyacencia(nuevoNodo); // Creamos su entrada en la lista de adyacencia
            entradas.add(nuevaEntrada); // Añadimos la entrada al grafo
            contador++;                 // Incrementamos el contador para que el siguiente nodo tenga un id diferente
        }
    }

    // Añade una arista dirigida desde el nodo origen hasta el nodo destino con la etiqueta que le pasamos
    // Si alguno de los dos nodos no existe en el grafo lo crea antes de añadir la arista
    // Al ser un grafo dirigido la arista solo aparece en la lista del nodo origen
    public void agregarArista(String origen, String destino, String etiqueta) {
        agregarNodo(origen);  // Creamos el nodo origen si no existe todavía
        agregarNodo(destino); // Creamos el nodo destino si no existe todavía
        EntradaAdyacencia entradaOrigen  = buscarEntrada(origen);  // Buscamos la entrada del nodo origen
        EntradaAdyacencia entradaDestino = buscarEntrada(destino); // Buscamos la entrada del nodo destino
        Arista arista = new Arista(entradaOrigen.getNodo(), etiqueta, entradaDestino.getNodo()); // Creamos la arista entre los dos nodos
        entradaOrigen.getAristas().add(arista); // Añadimos la arista a la lista del nodo origen
    }
    public ListaSimplementeEnlazada<Nodo> caminoMínimo(String origen, String destino) {
        ListaSimplementeEnlazada<Nodo> resultado=null;
        if(buscarEntrada(origen) != null && buscarEntrada(destino) != null) {
            Cola<String> cola=new Cola<>(); // Cola para almacenar los nodos a visitar
            ListaSimplementeEnlazada<String> visitados=new ListaSimplementeEnlazada<>(); // Lista para almacenar los nodos ya visitados
            ListaSimplementeEnlazada<Arista> padres=new ListaSimplementeEnlazada<>(); // Lista para almacenar el nodo padre de cada
            cola.enqueue(origen); // Empezamos por el nodo origen
            visitados.add(origen); // Marcamos el nodo origen como visitado
            while(!cola.isEmpty()){
                String nodoactual=cola.dequeue(); // Sacamos el nodo de la cola
                EntradaAdyacencia entradaActual = buscarEntrada(nodoactual);
                ListaSimplementeEnlazada<Arista> aristas= entradaActual.getAristas(); // Obtenemos las aristas del nodo actual
                if(nodoactual.equals(destino)){
                    resultado= reconstruirCamino(padres, origen, destino); // Si el nodo actual es el destino reconstruimos y devolvemos el camino mínimo
                }
                for (int i = 0; i < aristas.getSize(); i++) {
                    Arista aristaActual= aristas.getAt(i);
                    String nombreVecino=aristaActual.getDestino().getNombre(); // Obtenemos el nombre del nodo vecino al que llega la arista
                    if(visitados.get(nombreVecino)==null){
                        visitados.add(nombreVecino);
                        cola.enqueue(nombreVecino);
                        padres.add(aristaActual); // Guardamos la arista que nos llevó al vecino para luego reconstruir el camino
                    }
                }
            }
        }
        return resultado;
    }
    private ListaSimplementeEnlazada<Nodo> reconstruirCamino(ListaSimplementeEnlazada<Arista> padres,String origen, String destino) {
        Pila<Nodo> pila=new Pila<Nodo>(); // Pila para almacenar el camino desde el destino hasta el origen
        String actual=destino;
        boolean encontrado=true;
        while(!actual.equals(origen) && encontrado){
            encontrado=false;
            for(int i = 0; i < padres.getSize() && !encontrado; i++) {
                Arista a = padres.getAt(i);
                if(a.getDestino().getNombre().equals(actual) ) {
                    pila.push(a.getDestino()); // Añadimos el nodo destino de la arista a la pila
                    actual = a.getOrigen().getNombre(); // Avanzamos al nodo origen de la arista para seguir reconstruyendo el camino
                    encontrado=true;
                }
            }
        }
        pila.push(buscarEntrada(origen).getNodo()); // Añadimos el nodo origen al camino
        ListaSimplementeEnlazada<Nodo>lista= new ListaSimplementeEnlazada<>();
        ListaSimplementeEnlazada<Nodo> resultado= lista;
        while(!pila.isEmpty()){
            lista.add(pila.pop()); // Sacamos los nodos de la pila y los añadimos a la lista para devolver el camino en orden correcto
        }
        if (actual.equals(origen)) {
            resultado=null ;
        }
        return resultado;
    }
    public boolean esDisjunto() {
        boolean resultado=false;
        if(!entradas.isEmpty()) {
            Cola<String> cola = new Cola<>(); // Cola para almacenar los nodos a visitar
            ListaSimplementeEnlazada<String> visitados = new ListaSimplementeEnlazada<>(); // Lista para almacenar los nodos ya visitados
            cola.enqueue(entradas.getAt(0).getNodo().getNombre()); // Empezamos por el primer nodo de la lista de adyacencia
            visitados.add(entradas.getAt(0).getNodo().getNombre());
            while (!cola.isEmpty()) {
                String nodoactual = cola.dequeue(); // Sacamos el nodo de la cola
                EntradaAdyacencia entradaActual = buscarEntrada(nodoactual);
                ListaSimplementeEnlazada<Arista> aristas = entradaActual.getAristas(); // Obtenemos las aristas del nodo actual
                for (int i = 0; i < aristas.getSize(); i++) {
                    Arista aristaActual = aristas.getAt(i);
                    String nombreVecino = aristaActual.getDestino().getNombre(); // Obtenemos el nombre del nodo vecino al que llega la arista
                    if (visitados.get(nombreVecino) == null) {
                        visitados.add(nombreVecino);
                        cola.enqueue(nombreVecino);
                    }
                }
                for (int i = 0; i < entradas.getSize(); i++) {
                    ListaSimplementeEnlazada<Arista> aristasotro = entradas.getAt(i).getAristas();
                    for (int j = 0; j < aristasotro.getSize(); j++) {
                        if (aristasotro.getAt(j).getDestino().getNombre().equals(nodoactual)) {
                            String nombrevecino = entradas.getAt(i).getNodo().getNombre();
                            if (visitados.get(nombrevecino) == null) {
                                visitados.add(nombrevecino);
                                cola.enqueue(nombrevecino);
                            }
                        }
                    }
                }
            }
            if (visitados.getSize() != entradas.getSize()) {
                resultado= true; // Si el número de nodos visitados es diferente al número total de nodos el grafo es disjunto
            }
        }
        return resultado;
    }
    public String getValor(String sujeto, String relacion){
        String resultado=null;
        EntradaAdyacencia entradaActual = buscarEntrada(sujeto);
        if(entradaActual!=null) {
            ListaSimplementeEnlazada<Arista> aristas = entradaActual.getAristas();
            for (int i = 0; i < aristas.getSize(); i++) {
                Arista aristaActual = aristas.getAt(i);
                if (aristaActual.getEtiqueta().equals(relacion)) {
                    resultado= aristaActual.getDestino().getNombre(); // Si la etiqueta coincide con la relación devolvemos el nombre del nodo destino
                }
            }
        }
        return resultado;
    }
    public ListaSimplementeEnlazada<String> buscarPorRelacionYValor(String relacion, String valor){
        ListaSimplementeEnlazada<String> lista= new ListaSimplementeEnlazada<>();
        for (int i = 0; i < entradas.getSize(); i++) {
            EntradaAdyacencia entrada= entradas.getAt(i);
            ListaSimplementeEnlazada<Arista> aristas = entrada.getAristas();
            for(int j=0 ; j<aristas.getSize();j++){
                if(aristas.getAt(j).getEtiqueta().equals(relacion)&& aristas.getAt(j).getDestino().getNombre().equals(valor)){
                   lista.add(aristas.getAt(j).getOrigen().getNombre());
                }
            }
        }
        return lista;
    }
    public ListaSimplementeEnlazada<String> listarValoresPorRelación(String relacion){
        ListaSimplementeEnlazada<String> lista= new ListaSimplementeEnlazada<>();
        for (int i = 0; i < entradas.getSize(); i++) {
            EntradaAdyacencia entrada= entradas.getAt(i);
            ListaSimplementeEnlazada<Arista> aristas = entrada.getAristas();
            for(int j=0 ; j<aristas.getSize();j++){
                if(aristas.getAt(j).getEtiqueta().equals(relacion)){
                    lista.add(aristas.getAt(j).getDestino().getNombre());
                }
            }
        }
        return lista;
    }
    public ListaSimplementeEnlazada<String> getTiposdeNodos(){
        ListaSimplementeEnlazada<String>lista= new ListaSimplementeEnlazada<>();
        for (int i = 0; i < entradas.getSize(); i++) {
            String nodo= entradas.getAt(i).getNodo().getNombre();
            String prefijo = nodo.split(":")[0];
            if(lista.get(prefijo) == null){
                lista.add(prefijo);
            }
        }
        return lista;
    }
    private String extraerValor(String linea, String clave){
        String resultado=null;
        int posicionclave= linea.indexOf("\""+ clave + "\"");
        if(posicionclave != -1) {
            int posDospuntos = linea.indexOf(":", posicionclave);
            int posApertura = linea.indexOf("\"", posDospuntos);
            int posCierre = linea.indexOf("\"", posApertura + 1);
            resultado = linea.substring(posApertura + 1, posCierre);
        }
        return resultado;
    }
    public void cargarDesdeJson(String ruta) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea = br.readLine();
            while(linea != null) {
                if(linea.contains("sujeto")) {
                    String sujeto    = extraerValor(linea, "sujeto");
                    String predicado = extraerValor(linea, "predicado");
                    String objeto    = extraerValor(linea, "objeto");
                    if(sujeto != null && predicado != null && objeto != null) {
                        agregarArista(sujeto, objeto, predicado);
                    }
                }
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
