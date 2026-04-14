package ArbolBinario;
import LSE.ListaSimplementeEnlazada;
import PILA.COLA.LISTACIRCULAR.Cola;
import static java.lang.Math.max;

public class ArbolBusquedaBinaria <T  extends Comparable<T>> {
    private Nodo<T> raiz;

    public ArbolBusquedaBinaria() {
        raiz = null;
    }

    private ArbolBusquedaBinaria(Nodo<T> nodo) {
        raiz = nodo;
    }

    private Nodo<T> insertar(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            nodo = new Nodo<>(dato);
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(insertar(nodo.getDerecho(), dato));
        } else {
            nodo.setIzquierdo(insertar(nodo.getIzquierdo(), dato));
        }
        return nodo;
    }

    public void add(T dato) {
        raiz = insertar(raiz, dato);
    }

    private void inorden(Nodo<T> nodo, ListaSimplementeEnlazada<T> lista) {
        if (nodo == null) {
            return;
        }
        inorden(nodo.getIzquierdo(), lista); // Recorremos el subárbol izquierdo
        lista.add(nodo.getDato());             // Agregamos el dato del nodo actual a la lista
        inorden(nodo.getDerecho(), lista);    // Recorremos el subárbol derecho
    }

    public ListaSimplementeEnlazada<T> getListaOrdenadaCentral() {
        ListaSimplementeEnlazada<T> lista = new ListaSimplementeEnlazada<>(); // Creamos una nueva lista para almacenar los elementos del árbol
        inorden(raiz, lista);
        return lista;
    }

    private void preorden(Nodo<T> nodo, ListaSimplementeEnlazada<T> lista) {
        if (nodo == null) {
            return;
        }
        lista.add(nodo.getDato());             // Agregamos el dato del nodo actual a la lista
        preorden(nodo.getIzquierdo(), lista); // Recorremos el subárbol izquierdo
        preorden(nodo.getDerecho(), lista);    // Recorremos el subárbol derecho
    }

    public ListaSimplementeEnlazada<T> getListaPreOrden() {
        ListaSimplementeEnlazada<T> lista = new ListaSimplementeEnlazada<>();
        preorden(raiz, lista);
        return lista;
    }

    private void postorden(Nodo<T> nodo, ListaSimplementeEnlazada<T> lista) {
        if (nodo == null) {
            return;
        }
        postorden(nodo.getIzquierdo(), lista);
        postorden(nodo.getDerecho(), lista);
        lista.add(nodo.getDato());
    }

    public ListaSimplementeEnlazada<T> getListaPostOrden() {
        ListaSimplementeEnlazada<T> lista = new ListaSimplementeEnlazada<>();
        postorden(raiz, lista);
        return lista;
    }

    private int Altura(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzquierda = Altura(nodo.getIzquierdo());
        int alturaDerecha = Altura(nodo.getDerecho());
        int altura = 1 + Math.max(alturaIzquierda, alturaDerecha);
        return altura;
    }

    public int getAltura() {
        return Altura(raiz);
    }

    private void listaDatosNivel(Nodo<T> nodo, int nivel, ListaSimplementeEnlazada<T> lista) {
        if (nodo == null) {
            return;
        } else if (nivel == 0) {
            lista.add(nodo.getDato());
        } else if (nivel > 0) {
            listaDatosNivel(nodo.getIzquierdo(), nivel - 1, lista);
            listaDatosNivel(nodo.getDerecho(), nivel - 1, lista);
        }
    }

    public ListaSimplementeEnlazada<T> getListaDatosNivel(int nivel) {
        ListaSimplementeEnlazada<T> lista = new ListaSimplementeEnlazada<>();
        listaDatosNivel(raiz, nivel, lista);
        return lista;
    }

    private void getcamino(T dato, Nodo<T> nodo, ListaSimplementeEnlazada<T> lista) {
        if (nodo == null) {
            return;
        } else if (dato.compareTo(nodo.getDato()) == 0) {
            lista.add(nodo.getDato());
        } else if (dato.compareTo(nodo.getDato()) < 0) {
            lista.add((nodo.getDato()));
            getcamino(dato, nodo.getIzquierdo(), lista);
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            lista.add((nodo.getDato()));
            getcamino(dato, nodo.getDerecho(), lista);
        }
    }

    public ListaSimplementeEnlazada<T> getListaCamino(T dato) {
        ListaSimplementeEnlazada<T> lista = new ListaSimplementeEnlazada<>();
        getcamino(dato, raiz, lista);
        return lista;
    }

    public ArbolBusquedaBinaria<T> getSubArbolIzquierdo() {
        if (raiz == null) {
            return null;
        } else if (raiz.getIzquierdo() == null) {
            return null;
        }
        ArbolBusquedaBinaria<T> subarbol = new ArbolBusquedaBinaria<T>(raiz.getIzquierdo());
        return subarbol;
    }

    public ArbolBusquedaBinaria<T> getSubArbolDerecho() {
        if (raiz == null) {
            return null;
        } else if (raiz.getDerecho() == null) {
            return null;
        }
        ArbolBusquedaBinaria<T> subarbol = new ArbolBusquedaBinaria<T>(raiz.getDerecho());
        return subarbol;
    }

    private boolean isHomogeneo(Nodo<T> nodo) {
        if (nodo == null) {
            return true;
        } else if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
            return true;
        } else if ((nodo.getIzquierdo() != null && nodo.getDerecho() == null) || (nodo.getIzquierdo() == null && nodo.getDerecho() != null)) {
            return false;
        } else if (nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
            return isHomogeneo(nodo.getIzquierdo()) && isHomogeneo(nodo.getDerecho());
        }
        return false;
    }

    public boolean isArbolHomogeneo() {
        return isHomogeneo(raiz);
    }

    private boolean isCompleto(Nodo<T> nodo, int nivelActual, int altura) {
        if (nodo == null) {
            return true;
        } else if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
            return nivelActual == altura;
        } else {
            return isCompleto(nodo.getIzquierdo(), nivelActual+1, altura) && isCompleto(nodo.getDerecho(), nivelActual+1, altura);
        }
    }

    public boolean isArbolCompleto() {
        int altura= getAltura()-1;
        return isCompleto(raiz, 0, altura);
    }

    private boolean isSemiCompleto() {
        if (raiz == null) {
            return true;
        }
        Cola<Nodo<T>> cola = new Cola<>();
        cola.enqueue(raiz);
        boolean encontrado = false;
        while (cola.peek() != null) {
           Nodo<T>actual= cola.dequeue();
            if(encontrado ==true && (actual.getIzquierdo() != null && actual.getDerecho() == null) || (actual.getIzquierdo() == null && actual.getDerecho() != null)) {
                return false;
            } else if (actual.getIzquierdo() == null) {
                encontrado = true;
            }
            else if (actual.getIzquierdo() != null){
                cola.enqueue(actual.getIzquierdo());
            }
            else if (actual.getDerecho() == null) {
                encontrado = true;
            } else if (actual.getDerecho() != null && encontrado ==true) {
                return false;
            }
            else if (actual.getDerecho() != null && encontrado !=true) {
                cola.enqueue(actual.getDerecho());
            }
        }
        return true;
    }

    public boolean isArbolSemiCompleto() {
        return isSemiCompleto();
    }

    private int grado(Nodo<T> nodo) {
        int hijosactual=0;
        if (nodo == null) {
            return 0;
        }
        if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
            hijosactual=0;
        }
        else if (( nodo.getIzquierdo() != null && nodo.getDerecho() == null) || (nodo.getIzquierdo() == null && nodo.getDerecho() != null)) {
            hijosactual=1;
        }
        else{
            hijosactual=2;
        }
        int gradoizq=grado(nodo.getIzquierdo());
        int gradoder= grado(nodo.getDerecho());
        return Math.max(hijosactual,Math.max(gradoizq,gradoder));
    }

    public int getGrado() {
        return grado(raiz);
    }
}

