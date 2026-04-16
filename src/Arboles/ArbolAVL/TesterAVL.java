package Arboles.ArbolAVL;
import LSE.ListaSimplementeEnlazada;

public class TesterAVL {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   TESTER DEFINITIVO: ÁRBOL AVL");
        System.out.println("=========================================\n");

        // Ejecutamos cada test de rotación por separado
        testRotacionSimpleDerecha();
        testRotacionSimpleIzquierda();
        testRotacionDobleIzquierdaDerecha();
        testRotacionDobleDerechaIzquierda();

        System.out.println("=========================================");
        System.out.println(" Si todos los 'Obtenido' coinciden con");
        System.out.println(" los 'Esperado', ¡TU ÁRBOL ES PERFECTO!");
        System.out.println("=========================================");
    }

    public static void testRotacionSimpleDerecha() {
        System.out.println(">> TEST 1: Rotación Simple Derecha (Caso LL)");
        ArbolAVL<Integer> arbol = new ArbolAVL<>();

        // Insertamos en orden descendente para forzar desbalance hacia la izquierda
        arbol.add(30);
        arbol.add(20);
        arbol.add(10); // Provoca desbalance en 30 (factor 2), hijo 20 (factor 1) -> Rotación Derecha

        // Tras la rotación la raíz debe ser 20 con 10 a la izquierda y 30 a la derecha
        System.out.println("Esperado PreOrden : [20, 10, 30]");
        System.out.print("Obtenido PreOrden : ");
        imprimirLista(arbol.getListaPreOrden());
        System.out.println("Altura esperada: 2 | Obtenida: " + arbol.getAltura() + "\n");
    }

    public static void testRotacionSimpleIzquierda() {
        System.out.println(">> TEST 2: Rotación Simple Izquierda (Caso RR)");
        ArbolAVL<Integer> arbol = new ArbolAVL<>();

        // Insertamos en orden ascendente para forzar desbalance hacia la derecha
        arbol.add(10);
        arbol.add(20);
        arbol.add(30); // Provoca desbalance en 10 (factor -2), hijo 20 (factor -1) -> Rotación Izquierda

        // Tras la rotación la raíz debe ser 20 con 10 a la izquierda y 30 a la derecha
        System.out.println("Esperado PreOrden : [20, 10, 30]");
        System.out.print("Obtenido PreOrden : ");
        imprimirLista(arbol.getListaPreOrden());
        System.out.println("Altura esperada: 2 | Obtenida: " + arbol.getAltura() + "\n");
    }

    public static void testRotacionDobleIzquierdaDerecha() {
        System.out.println(">> TEST 3: Rotación Doble Izquierda-Derecha (Caso LR)");
        ArbolAVL<Integer> arbol = new ArbolAVL<>();

        // Insertamos en zigzag izquierda-derecha para forzar rotación doble
        arbol.add(30);
        arbol.add(10);
        arbol.add(20); // Desbalance en 30 (factor 2), hijo 10 (factor -1) -> Rotación Izq-Der

        // Tras la doble rotación la raíz debe ser 20 con 10 a la izquierda y 30 a la derecha
        System.out.println("Esperado PreOrden : [20, 10, 30]");
        System.out.print("Obtenido PreOrden : ");
        imprimirLista(arbol.getListaPreOrden());
        System.out.println("Altura esperada: 2 | Obtenida: " + arbol.getAltura() + "\n");
    }

    public static void testRotacionDobleDerechaIzquierda() {
        System.out.println(">> TEST 4: Rotación Doble Derecha-Izquierda (Caso RL)");
        ArbolAVL<Integer> arbol = new ArbolAVL<>();

        // Insertamos en zigzag derecha-izquierda para forzar rotación doble
        arbol.add(10);
        arbol.add(30);
        arbol.add(20); // Desbalance en 10 (factor -2), hijo 30 (factor 1) -> Rotación Der-Izq

        // Tras la doble rotación la raíz debe ser 20 con 10 a la izquierda y 30 a la derecha
        System.out.println("Esperado PreOrden : [20, 10, 30]");
        System.out.print("Obtenido PreOrden : ");
        imprimirLista(arbol.getListaPreOrden());
        System.out.println("Altura esperada: 2 | Obtenida: " + arbol.getAltura() + "\n");
    }

    // Método auxiliar para imprimir la lista enlazada
    private static void imprimirLista(ListaSimplementeEnlazada<Integer> lista) {
        System.out.println(lista);
    }
}