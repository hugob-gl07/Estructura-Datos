package Arboles.ArbolB;
public class TestArbolB {

    public static void main(String[] args) {
        System.out.println("🏗️ === INICIANDO BATERÍA DE PRUEBAS DE ARQUITECTURA === 🏗️\n");

        /*
         * CASO 1: Árbol de Orden 3 (Conocido como Árbol 2-3)
         * Propósito: Al tener una capacidad tan pequeña (máximo 2 datos por nodo),
         * forzaremos a tu método 'split' y 'add' a ejecutarse muchísimas veces,
         * haciendo que el árbol crezca rápidamente en altura.
         * Patrón: Inserción secuencial ascendente (Fuerza splits continuos hacia la derecha).
         */
        ejecutarPrueba("Árbol Orden 3 - Secuencial Ascendente", 3,
                new Integer[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100});

        /*
         * CASO 2: Árbol de Orden 4
         * Propósito: Los árboles de orden par son matemáticamente tramposos a la hora
         * de calcular la mitad exacta (el índice medio). Esto pondrá a prueba
         * tu lógica de partición de hijos.
         * Patrón: Inserción secuencial descendente (Fuerza splits continuos hacia la izquierda).
         */
        ejecutarPrueba("Árbol Orden 4 - Secuencial Descendente", 4,
                new Integer[]{100, 90, 80, 70, 60, 50, 40, 30, 20, 10});

        /*
         * CASO 3: Árbol de Orden 5
         * Propósito: Mayor capacidad de almacenamiento en los nodos. Evalúa el
         * comportamiento general de tu método 'insertAt' para desplazar elementos
         * dentro del mismo nodo antes de que explote.
         * Patrón: Inserción aleatoria (Simula un entorno real de base de datos).
         */
        ejecutarPrueba("Árbol Orden 5 - Distribución Aleatoria", 5,
                new Integer[]{45, 12, 89, 33, 76, 2, 99, 54, 21, 68, 50, 15, 88});
    }

    /**
     * Motor de pruebas que aísla cada ejecución.
     */
    private static void ejecutarPrueba(String nombrePrueba, int orden, Integer[] datosAInsertar) {
        System.out.println("==================================================");
        System.out.println("🛠️ INICIANDO: " + nombrePrueba);
        System.out.println("==================================================");

        try {
            // TODO: Cambia 'ArbolB' por el nombre real de tu clase principal si es diferente
            // ArbolB<Integer> miArbol = new ArbolB<>(orden);

            System.out.print("📥 Insertando datos: ");
            for (Integer dato : datosAInsertar) {
                System.out.print(dato + " ");

                // Descomenta esta línea para que tu árbol empiece a tragar los datos
                // miArbol.add(dato);
            }
            System.out.println("\n✅ [ÉXITO] Todas las inserciones finalizaron sin lanzar excepciones (NullPointer, IndexOutOfBounds, etc).");

            /* * RECOMENDACIÓN DE ARQUITECTO:
             * Para comprobar que el árbol no solo "no explota", sino que los datos
             * están bien estructurados, te recomiendo encarecidamente que en un futuro
             * programes un método 'imprimirArbol()' o 'recorridoInOrden()' en tu árbol.
             * * miArbol.imprimirArbol();
             */

        } catch (Exception e) {
            System.err.println("\n❌ [ERROR CRÍTICO] Tu árbol colapsó durante la prueba.");
            System.err.println("Tipo de error: " + e.getClass().getSimpleName());
            System.err.println("Mensaje: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("\n");
    }
}