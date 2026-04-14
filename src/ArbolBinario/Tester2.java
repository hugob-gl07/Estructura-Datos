package ArbolBinario;
import java.util.Random;

public class Tester2 {
    public static void main(String[] args) {
        ArbolBusquedaBinariaEnteros arbol = new ArbolBusquedaBinariaEnteros();

        // Paso 1: crear array 0-128 y mezclar con Fisher-Yates
        int[] numeros = new int[129];
        for (int i = 0; i <= 128; i++) {
            numeros[i] = i;
        }
        Random random = new Random();
        for (int i = 128; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = numeros[i];
            numeros[i] = numeros[j];
            numeros[j] = temp;
        }
        for (int numero : numeros) {
            arbol.add(numero);
        }

        // Paso 2: suma
        System.out.println("Suma: " + arbol.getSuma());

        // Paso 3: suma con los 3 recorridos
        // (igual que Tester1)

        // Paso 4: subárboles
        // (igual que Tester1)

        // Paso 5: altura
        System.out.println("Altura: " + arbol.getAltura());

        // Paso 6: camino al 110
        System.out.println("Camino al 110: " + arbol.getListaCamino(110));
    }
}
