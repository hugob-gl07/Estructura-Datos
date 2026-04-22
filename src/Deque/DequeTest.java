package Deque;
import Deque.Deque;
import Exceptions.ListaVaciaExceptions;

/**
 * Suite de tests manuales para Deque.
 * No requiere JUnit. Ejecutar con el botón ▶️ de IntelliJ.
 *
 * IMPORTANTE: el Deque usa LDEOrdenada internamente, por lo que
 * addLast() inserta en orden ascendente, no al final literal.
 * Los tests tienen esto en cuenta.
 */
public class DequeTest {

    private static int totalTests  = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    // ==================================================================
    // MAIN — punto de entrada
    // ==================================================================

    public static void main(String[] args) {

        printHeader("CASOS DE ÉXITO — addFirst / peekFirst / removeFirst");
        test_addFirst_unElemento();
        test_addFirst_variosElementos_ordenCorrecto();
        test_peekFirst_noElimina();
        test_removeFirst_devuelvePrimero();
        test_removeFirst_actualizaSize();

        printHeader("CASOS DE ÉXITO — addLast / peekLast / removeLast");
        test_addLast_unElemento();
        test_peekLast_noElimina();
        test_removeLast_devuelveUltimo();
        test_removeLast_actualizaSize();

        printHeader("CASOS DE ÉXITO — isEmpty / size / clear / contains");
        test_isEmpty_dequeVacio();
        test_isEmpty_conElementos();
        test_isEmpty_trasClear();
        test_size_correcto();
        test_size_trasRemove();
        test_clear_vaciaTodo();
        test_contains_elementoExistente();
        test_contains_elementoNoExistente();
        test_contains_trasRemover();

        printHeader("CASOS DE ÉXITO — toString");
        test_toString_vacio();
        test_toString_conElementos();

        printHeader("CASOS DE ERROR");
        test_removeFirst_vacio_lanzaExcepcion();
        test_removeLast_vacio_lanzaExcepcion();
        test_peekFirst_vacio_lanzaExcepcion();
        test_peekLast_vacio_lanzaExcepcion();
        test_excepcion_mensajeDescriptivo();

        printHeader("CASOS DE BORDE");
        test_unElemento_addFirstRemoveFirst();
        test_unElemento_addFirstRemoveLast();
        test_unElemento_peekFirstPeekLast_iguales();
        test_reutilizacion_trasClear();
        test_addFirst_yRemoveLast_intercalados();
        test_contains_dequeVacio();
        test_volumen(10);
        test_volumen(100);

        printResumen();
    }

    // ==================================================================
    // CASOS DE ÉXITO — addFirst / peekFirst / removeFirst
    // ==================================================================

    static void test_addFirst_unElemento() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(5);
        assertIsFalse("addFirst: deque no vacío tras insertar", d.isEmpty());
        assertEqual("addFirst: size es 1", 1, d.size());
    }

    static void test_addFirst_variosElementos_ordenCorrecto() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(3);
        d.addFirst(1); // inserta al inicio
        d.addFirst(2); // inserta al inicio
        // Tras addFirst(3), addFirst(1), addFirst(2):
        // la lista queda [1, 2, 3] porque addFirst inserta al inicio
        // pero la LDEOrdenada reordena al llamar a add() — addFirst sí respeta posición
        assertEqual("addFirst: peekFirst es el último insertado al inicio", 2, d.peekFirst());
    }

    static void test_peekFirst_noElimina() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(10);
        d.addFirst(5);
        int val = d.peekFirst();
        assertEqual("peekFirst: devuelve primer elemento", 5, val);
        assertEqual("peekFirst: size no cambia", 2, d.size());
    }

    static void test_removeFirst_devuelvePrimero() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(10);
        d.addFirst(5);
        assertEqual("removeFirst: devuelve 5 (el primero)", 5, d.removeFirst());
    }

    static void test_removeFirst_actualizaSize() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(1);
        d.addFirst(2);
        d.removeFirst();
        assertEqual("removeFirst: size decrece a 1", 1, d.size());
    }

    // ==================================================================
    // CASOS DE ÉXITO — addLast / peekLast / removeLast
    // ==================================================================

    static void test_addLast_unElemento() {
        Deque<Integer> d = new Deque<Integer>();
        d.addLast(99);
        assertIsFalse("addLast: deque no vacío", d.isEmpty());
        assertEqual("addLast: size es 1", 1, d.size());
    }

    static void test_peekLast_noElimina() {
        Deque<Integer> d = new Deque<Integer>();
        d.addLast(1);
        d.addLast(5);
        // LDEOrdenada ordena: [1, 5], último es 5
        assertEqual("peekLast: devuelve último sin eliminar", 5, d.peekLast());
        assertEqual("peekLast: size no cambia", 2, d.size());
    }

    static void test_removeLast_devuelveUltimo() {
        Deque<Integer> d = new Deque<Integer>();
        d.addLast(1);
        d.addLast(5);
        // LDEOrdenada ordena ascendente: [1, 5]
        assertEqual("removeLast: devuelve 5 (el mayor/último)", 5, d.removeLast());
    }

    static void test_removeLast_actualizaSize() {
        Deque<Integer> d = new Deque<Integer>();
        d.addLast(1);
        d.addLast(2);
        d.removeLast();
        assertEqual("removeLast: size decrece a 1", 1, d.size());
    }

    // ==================================================================
    // CASOS DE ÉXITO — isEmpty / size / clear / contains
    // ==================================================================

    static void test_isEmpty_dequeVacio() {
        Deque<Integer> d = new Deque<Integer>();
        assertIsTrue("isEmpty: deque nuevo está vacío", d.isEmpty());
    }

    static void test_isEmpty_conElementos() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(1);
        assertIsFalse("isEmpty: con elementos no está vacío", d.isEmpty());
    }

    static void test_isEmpty_trasClear() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(1);
        d.addFirst(2);
        d.clear();
        assertIsTrue("isEmpty: vacío tras clear()", d.isEmpty());
    }

    static void test_size_correcto() {
        Deque<Integer> d = new Deque<Integer>();
        assertEqual("size: inicial es 0", 0, d.size());
        d.addFirst(1);
        assertEqual("size: tras addFirst es 1", 1, d.size());
        d.addLast(2);
        assertEqual("size: tras addLast es 2", 2, d.size());
    }

    static void test_size_trasRemove() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(1);
        d.addFirst(2);
        d.removeFirst();
        assertEqual("size: tras removeFirst es 1", 1, d.size());
        d.removeLast();
        assertEqual("size: tras removeLast es 0", 0, d.size());
    }

    static void test_clear_vaciaTodo() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(1); d.addFirst(2); d.addLast(3);
        d.clear();
        assertIsTrue("clear: isEmpty true",   d.isEmpty());
        assertEqual("clear: size es 0", 0, d.size());
    }

    static void test_contains_elementoExistente() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(42);
        assertIsTrue("contains: encuentra elemento existente", d.contains(42));
    }

    static void test_contains_elementoNoExistente() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(1);
        assertIsFalse("contains: no encuentra elemento inexistente", d.contains(99));
    }

    static void test_contains_trasRemover() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(7);
        d.removeFirst();
        assertIsFalse("contains: no encuentra elemento ya eliminado", d.contains(7));
    }

    // ==================================================================
    // CASOS DE ÉXITO — toString
    // ==================================================================

    static void test_toString_vacio() {
        Deque<Integer> d = new Deque<Integer>();
        assertEqualString("toString: deque vacío es '[]'", "[]", d.toString());
    }

    static void test_toString_conElementos() {
        Deque<Integer> d = new Deque<Integer>();
        d.addLast(1);
        d.addLast(2);
        d.addLast(3);
        // LDEOrdenada ordena ascendente: [1, 2, 3]
        assertEqualString("toString: [1, 2, 3]", "[1, 2, 3]", d.toString());
    }

    // ==================================================================
    // CASOS DE ERROR
    // ==================================================================

    static void test_removeFirst_vacio_lanzaExcepcion() {
        Deque<Integer> d = new Deque<Integer>();
        assertThrows("removeFirst en vacío lanza excepción",
                RuntimeException.class, () -> d.removeFirst());
    }

    static void test_removeLast_vacio_lanzaExcepcion() {
        Deque<Integer> d = new Deque<Integer>();
        assertThrows("removeLast en vacío lanza excepción",
                RuntimeException.class, () -> d.removeLast());
    }

    static void test_peekFirst_vacio_lanzaExcepcion() {
        Deque<Integer> d = new Deque<Integer>();
        assertThrows("peekFirst en vacío lanza excepción",
                RuntimeException.class, () -> d.peekFirst());
    }

    static void test_peekLast_vacio_lanzaExcepcion() {
        Deque<Integer> d = new Deque<Integer>();
        assertThrows("peekLast en vacío lanza excepción",
                RuntimeException.class, () -> d.peekLast());
    }

    static void test_excepcion_mensajeDescriptivo() {
        Deque<Integer> d = new Deque<Integer>();
        try {
            d.removeFirst();
            registrarFallo("excepción: no se lanzó");
        } catch (RuntimeException e) {
            assertIsTrue("excepción: mensaje no nulo ni vacío",
                    e.getMessage() != null && !e.getMessage().isBlank());
        }
    }

    // ==================================================================
    // CASOS DE BORDE
    // ==================================================================

    static void test_unElemento_addFirstRemoveFirst() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(42);
        assertEqual("Un elemento: removeFirst devuelve 42", 42, d.removeFirst());
        assertIsTrue("Un elemento: vacío tras removeFirst", d.isEmpty());
    }

    static void test_unElemento_addFirstRemoveLast() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(42);
        assertEqual("Un elemento: removeLast devuelve 42", 42, d.removeLast());
        assertIsTrue("Un elemento: vacío tras removeLast", d.isEmpty());
    }

    static void test_unElemento_peekFirstPeekLast_iguales() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(7);
        assertEqual("Un elemento: peekFirst == peekLast", d.peekFirst(), d.peekLast());
        assertEqual("Un elemento: size sigue siendo 1", 1, d.size());
    }

    static void test_reutilizacion_trasClear() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(1); d.addFirst(2);
        d.clear();
        d.addFirst(99);
        assertEqual("Reutilización: peekFirst es 99 tras clear+addFirst", 99, d.peekFirst());
        assertEqual("Reutilización: size es 1", 1, d.size());
    }

    static void test_addFirst_yRemoveLast_intercalados() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(10);
        d.addFirst(5);
        d.addFirst(1);
        // Lista: [1, 5, 10]
        assertEqual("Intercalado: removeLast devuelve 10", 10, d.removeLast());
        assertEqual("Intercalado: removeLast devuelve 5",   5, d.removeLast());
        assertEqual("Intercalado: removeFirst devuelve 1",  1, d.removeFirst());
        assertIsTrue("Intercalado: vacío al final", d.isEmpty());
    }

    static void test_contains_dequeVacio() {
        Deque<Integer> d = new Deque<Integer>();
        assertIsFalse("contains: false en deque vacío", d.contains(1));
    }

    static void test_volumen(int n) {
        Deque<Integer> d = new Deque<Integer>();
        for (int i = 1; i <= n; i++) d.addFirst(i);
        assertEqual("Volumen(" + n + "): size correcto", n, d.size());
        assertIsFalse("Volumen(" + n + "): no está vacío", d.isEmpty());

        // Vaciamos con removeFirst y removeLast alternados
        int extraidos = 0;
        while (!d.isEmpty()) {
            d.removeFirst();
            extraidos++;
            if (!d.isEmpty()) { d.removeLast(); extraidos++; }
        }
        assertEqual("Volumen(" + n + "): extraídos todos los elementos", n, extraidos);
        assertIsTrue("Volumen(" + n + "): vacío al final", d.isEmpty());
    }

    // ==================================================================
    // MOTOR DE ASERCIONES (sin JUnit)
    // ==================================================================

    @FunctionalInterface
    interface Accion { void ejecutar(); }

    static void assertEqual(String nombre, int esperado, int actual) {
        totalTests++;
        if (esperado == actual) registrarOk(nombre);
        else registrarFallo(nombre + " → esperado: " + esperado + ", obtenido: " + actual);
    }

    static void assertEqualString(String nombre, String esperado, String actual) {
        totalTests++;
        if (esperado.equals(actual)) registrarOk(nombre);
        else registrarFallo(nombre + " → esperado: '" + esperado + "', obtenido: '" + actual + "'");
    }

    static void assertIsTrue(String nombre, boolean condicion) {
        totalTests++;
        if (condicion) registrarOk(nombre);
        else registrarFallo(nombre + " → esperado: true, obtenido: false");
    }

    static void assertIsFalse(String nombre, boolean condicion) {
        totalTests++;
        if (!condicion) registrarOk(nombre);
        else registrarFallo(nombre + " → esperado: false, obtenido: true");
    }

    static void assertThrows(String nombre, Class<? extends Exception> tipo, Accion accion) {
        totalTests++;
        try {
            accion.ejecutar();
            registrarFallo(nombre + " → no se lanzó ninguna excepción");
        } catch (Exception e) {
            if (tipo.isInstance(e)) registrarOk(nombre);
            else registrarFallo(nombre + " → excepción incorrecta: " + e.getClass().getSimpleName());
        }
    }

    // ==================================================================
    // SALIDA POR CONSOLA
    // ==================================================================

    static void registrarOk(String nombre) {
        totalPassed++;
        System.out.println("  [OK]   " + nombre);
    }

    static void registrarFallo(String motivo) {
        totalFailed++;
        System.out.println("  [FAIL] " + motivo);
    }

    static void printHeader(String titulo) {
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  " + titulo);
        System.out.println("══════════════════════════════════════════");
    }

    static void printResumen() {
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("  RESUMEN FINAL");
        System.out.println("══════════════════════════════════════════");
        System.out.println("  Total  : " + totalTests);
        System.out.println("  Passed : " + totalPassed + " ✅");
        System.out.println("  Failed : " + totalFailed + (totalFailed > 0 ? " ❌" : ""));
        System.out.println("══════════════════════════════════════════");
        if (totalFailed == 0) System.out.println("  🎉 ¡Todos los tests han pasado!");
        else                  System.out.println("  ⚠️  Revisa los tests marcados [FAIL].");
        System.out.println("══════════════════════════════════════════\n");
    }
}