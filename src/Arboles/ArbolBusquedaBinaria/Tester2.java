package Arboles.ArbolBusquedaBinaria;
import java.util.Random;
/**
 * Tester 2: prueba el árbol BST insertando los números del 0 al 128 en orden aleatorio.
 * Usa el algoritmo de Fisher-Yates para mezclar el array antes de insertar,
 * lo que produce un árbol más equilibrado y con menor altura que el de Tester1.
 * La suma debe seguir siendo 8256, pero la altura varía en cada ejecución.
 */
public class Tester2 {
    public static void main(String[] args) {
        ArbolBusquedaBinariaEnteros arbol = new ArbolBusquedaBinariaEnteros(); // Creamos el árbol de enteros

        // --- Paso 1: Creación del array y mezcla aleatoria (Fisher-Yates) ---
        // Primero llenamos el array con los valores del 0 al 128 en orden
        int[] numeros = new int[129]; // Array de 129 posiciones (índices 0 a 128)
        for (int i = 0; i <= 128; i++) {
            numeros[i] = i; // Asignamos cada posición con su valor correspondiente
        }
        // Algoritmo Fisher-Yates: recorremos el array de atrás hacia adelante
        // y para cada posición i elegimos un índice j aleatorio entre 0 e i (inclusive)
        // e intercambiamos los elementos en las posiciones i y j
        // Esto garantiza que todas las permutaciones son equiprobables
        Random random = new Random(); // Generador de números aleatorios
        for (int i = 128; i > 0; i--) {
            int j = random.nextInt(i + 1); // Elegimos un índice aleatorio entre 0 e i
            int temp = numeros[i];         // Guardamos el elemento actual en una variable temporal
            numeros[i] = numeros[j];       // Colocamos en la posición i el elemento de la posición j
            numeros[j] = temp;             // Colocamos en la posición j el elemento que estaba en i
        }
        // Insertamos los números ya mezclados en el árbol
        for (int numero : numeros) {
            arbol.add(numero); // Cada número se inserta en el BST según su valor
        }

        // --- Paso 2: Verificación de la suma ---
        // Independientemente del orden de inserción, la suma de 0..128 siempre es 8256
        System.out.println("Suma: " + arbol.getSuma());

        // --- Paso 5: Altura del árbol ---
        // Al insertar en orden aleatorio, el árbol queda más balanceado que en Tester1
        // → la altura esperada es aproximadamente log2(129) ≈ 7, aunque varía cada ejecución
        System.out.println("Altura: " + arbol.getAltura());

        // --- Paso 6: Camino desde la raíz hasta el nodo 110 ---
        // El camino depende de qué elemento se insertó primero (la raíz cambia en cada ejecución)
        // pero siempre debe terminar en 110 siguiendo las comparaciones del BST
        System.out.println("Camino al 110: " + arbol.getListaCamino(110));
    }
}
