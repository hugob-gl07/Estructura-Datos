package Arboles.ArbolBusquedaBinaria;
import LSE.Iterador;
/**
 * Tester 1: prueba el árbol BST insertando los números del 0 al 128 en orden ascendente.
 * Al insertarlos en orden, el árbol queda completamente desbalanceado (cada nodo sólo tiene hijo derecho),
 * formando una lista enlazada. Sirve para verificar la corrección de las operaciones en el peor caso.
 */
public class Tester1 {
    public static void main(String[] args) {
        ArbolBusquedaBinariaEnteros arbol = new ArbolBusquedaBinariaEnteros(); // Creamos el árbol de enteros

        // --- Paso 1: Inserción en orden ascendente ---
        // Al insertar 0, 1, 2, ... cada nuevo elemento es mayor que el anterior
        // y se coloca siempre como hijo derecho → árbol completamente degenerado
        for (int i = 0; i <= 128; i++) {
            arbol.add(i); // Insertamos cada número en el árbol
        }

        // --- Paso 2: Verificación de la suma con getSuma() ---
        // La suma de 0+1+2+...+128 = 8256; comprobamos que getSuma() devuelve ese valor
        System.out.println("Suma: " + arbol.getSuma());

        // --- Paso 3: Verificación de la suma con los 3 recorridos ---
        // Los tres recorridos visitan todos los nodos exactamente una vez,
        // por lo que la suma debe ser idéntica en los tres casos (8256)
        int sumaInorden = 0, sumaPreorden = 0, sumaPostorden = 0; // Acumuladores para cada recorrido
        Iterador<Integer> it1 = arbol.getListaOrdenadaCentral().getIterador(); // Iterador recorrido inorden (izq-raíz-der)
        Iterador<Integer> it2 = arbol.getListaPreOrden().getIterador();        // Iterador recorrido preorden (raíz-izq-der)
        Iterador<Integer> it3 = arbol.getListaPostOrden().getIterador();       // Iterador recorrido postorden (izq-der-raíz)
        while (it1.hasNext()) sumaInorden   += it1.next(); // Sumamos todos los elementos del recorrido inorden
        while (it2.hasNext()) sumaPreorden  += it2.next(); // Sumamos todos los elementos del recorrido preorden
        while (it3.hasNext()) sumaPostorden += it3.next(); // Sumamos todos los elementos del recorrido postorden
        System.out.println("Suma inorden: "   + sumaInorden);   // Debe coincidir con getSuma()
        System.out.println("Suma preorden: "  + sumaPreorden);  // Debe coincidir con getSuma()
        System.out.println("Suma postorden: " + sumaPostorden); // Debe coincidir con getSuma()

        // --- Paso 4: Verificación de la suma de los subárboles ---
        // La suma del subárbol izquierdo + subárbol derecho + valor de la raíz = suma total
        // Como la raíz es 0, suma izq (null) + suma der (1..128) = 8256
        int sumaIzq = 0, sumaDer = 0; // Acumuladores para los subárboles
        ArbolBusquedaBinaria<Integer> izq = arbol.getSubArbolIzquierdo(); // Subárbol izquierdo de la raíz
        ArbolBusquedaBinaria<Integer> der = arbol.getSubArbolDerecho();   // Subárbol derecho de la raíz
        if (izq != null) { // Sólo recorremos si el subárbol existe
            Iterador<Integer> itIzq = izq.getListaOrdenadaCentral().getIterador(); // Iterador sobre el subárbol izquierdo
            while (itIzq.hasNext()) sumaIzq += itIzq.next(); // Acumulamos la suma del subárbol izquierdo
        }
        if (der != null) { // Sólo recorremos si el subárbol existe
            Iterador<Integer> itDer = der.getListaOrdenadaCentral().getIterador(); // Iterador sobre el subárbol derecho
            while (itDer.hasNext()) sumaDer += itDer.next(); // Acumulamos la suma del subárbol derecho
        }
        // La suma de ambos subárboles más la raíz (0) debe ser igual a la suma total (8256)
        System.out.println("Suma izq + der: " + (sumaIzq + sumaDer));

        // --- Paso 5: Altura del árbol ---
        // Al insertar en orden, todos los nodos forman una cadena hacia la derecha
        // → la altura es 129 (un nivel por cada nodo insertado, de 0 a 128)
        System.out.println("Altura: " + arbol.getAltura());

        // --- Paso 6: Camino desde la raíz hasta el nodo 110 ---
        // En un árbol degenerado hacia la derecha, el camino sigue siempre la rama derecha
        // → el camino es [0, 1, 2, ..., 110]
        System.out.println("Camino al 110: " + arbol.getListaCamino(110));
    }
}
