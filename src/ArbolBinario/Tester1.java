package ArbolBinario;
import LSE.Iterador;

public class Tester1 {
    public static void main(String[] args) {
        ArbolBusquedaBinariaEnteros arbol = new ArbolBusquedaBinariaEnteros();

        // Paso 1: añadir 0 a 128 en orden
        for (int i = 0; i <= 128; i++) {
            arbol.add(i);
        }

        // Paso 2: calcular suma
        System.out.println("Suma: " + arbol.getSuma());

        // Paso 3: verificar suma con los 3 recorridos
        int sumaInorden = 0, sumaPreorden = 0, sumaPostorden = 0;
        Iterador<Integer> it1 = arbol.getListaOrdenadaCentral().getIterador();
        Iterador<Integer> it2 = arbol.getListaPreOrden().getIterador();
        Iterador<Integer> it3 = arbol.getListaPostOrden().getIterador();
        while (it1.hasNext()) sumaInorden += it1.next();
        while (it2.hasNext()) sumaPreorden += it2.next();
        while (it3.hasNext()) sumaPostorden += it3.next();
        System.out.println("Suma inorden: " + sumaInorden);
        System.out.println("Suma preorden: " + sumaPreorden);
        System.out.println("Suma postorden: " + sumaPostorden);

        // Paso 4: suma subárboles
        int sumaIzq = 0, sumaDer = 0;

        ArbolBusquedaBinaria<Integer> izq = arbol.getSubArbolIzquierdo();
        ArbolBusquedaBinaria<Integer> der = arbol.getSubArbolDerecho();

        if (izq != null) {
            Iterador<Integer> itIzq = izq.getListaOrdenadaCentral().getIterador();
            while (itIzq.hasNext()) sumaIzq += itIzq.next();
        }
        if (der != null) {
            Iterador<Integer> itDer = der.getListaOrdenadaCentral().getIterador();
            while (itDer.hasNext()) sumaDer += itDer.next();
        }
        System.out.println("Suma izq + der: " + (sumaIzq + sumaDer));

        // Paso 5: altura
        System.out.println("Altura: " + arbol.getAltura());

        // Paso 6: camino al 110
        System.out.println("Camino al 110: " + arbol.getListaCamino(110));
    }
}
