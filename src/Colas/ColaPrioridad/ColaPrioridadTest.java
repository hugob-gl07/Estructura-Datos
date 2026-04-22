import Colas.ColaPrioridad.ColaPrioridadMax;
import Colas.ColaPrioridad.ColaPrioridadMin;
import Exceptions.ColaPrioridadVaciaExceptions;

/**
 * Suite de tests manuales para ColaPrioridadMax y ColaPrioridadMin.
 * No requiere JUnit. Ejecutar con el botón ▶️ de IntelliJ.
 *
 * Propiedades clave:
 *   ColaPrioridadMax → dequeue() devuelve siempre el MAYOR elemento.
 *   ColaPrioridadMin → dequeue() devuelve siempre el MENOR elemento.
 *   Ambas usan LDEOrdenada internamente (orden ascendente).
 */
public class ColaPrioridadTest {

    private static int totalTests  = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    public static void main(String[] args) {

        // ── COLA PRIORIDAD MAX ─────────────────────────────────────────
        printHeader("COLA PRIORIDAD MAX — Cola vacía");
        testMax_isEmpty_colaVacia();
        testMax_size_colaVacia_es0();
        testMax_dequeue_vacia_lanzaExcepcion();
        testMax_peekMax_vacia_lanzaExcepcion();
        testMax_peekMin_vacia_lanzaExcepcion();
        testMax_dequeueMin_vacia_lanzaExcepcion();
        testMax_excepcion_mensajeDescriptivo();

        printHeader("COLA PRIORIDAD MAX — Inserción y orden");
        testMax_enqueue_unElemento_noEstaVacia();
        testMax_enqueue_size_correcto();
        testMax_peekMax_devuelveMayor();
        testMax_peekMin_devuelveMenor();
        testMax_peekMax_noModificaSize();
        testMax_peekMin_noModificaSize();

        printHeader("COLA PRIORIDAD MAX — dequeue / dequeueMin");
        testMax_dequeue_devuelveMayor();
        testMax_dequeue_ordenDescendente();
        testMax_dequeueMin_devuelveMenor();
        testMax_dequeueMin_ordenAscendente();
        testMax_size_decrece_trasDequeue();

        printHeader("COLA PRIORIDAD MAX — clear / contains");
        testMax_clear_vaciaCola();
        testMax_contains_elementoExistente();
        testMax_contains_elementoInexistente();
        testMax_contains_trasClear_false();

        printHeader("COLA PRIORIDAD MAX — replace");
        testMax_replace_elementoExistente_devuelveNuevo();
        testMax_replace_elementoInexistente_devuelveNull();
        testMax_replace_nuevoMaximo_esPeekMax();
        testMax_replace_mantieneOrden();

        printHeader("COLA PRIORIDAD MAX — toString");
        testMax_toString_vacia();
        testMax_toString_conElementos_ordenAscendente();

        printHeader("COLA PRIORIDAD MAX — tipos genéricos");
        testMax_conStrings();
        testMax_conDoubles();

        printHeader("COLA PRIORIDAD MAX — volumen");
        testMax_volumen_100elementos();
        testMax_volumen_ordenDequeue();

        // ── COLA PRIORIDAD MIN ─────────────────────────────────────────
        printHeader("COLA PRIORIDAD MIN — Cola vacía");
        testMin_isEmpty_colaVacia();
        testMin_size_colaVacia_es0();
        testMin_dequeue_vacia_lanzaExcepcion();
        testMin_peekMin_vacia_lanzaExcepcion();
        testMin_peekMax_vacia_lanzaExcepcion();
        testMin_excepcion_mensajeDescriptivo();

        printHeader("COLA PRIORIDAD MIN — Inserción y orden");
        testMin_enqueue_unElemento_noEstaVacia();
        testMin_enqueue_size_correcto();
        testMin_peekMin_devuelveMenor();
        testMin_peekMax_devuelveMayor();
        testMin_peekMin_noModificaSize();

        printHeader("COLA PRIORIDAD MIN — dequeue");
        testMin_dequeue_devuelveMenor();
        testMin_dequeue_ordenAscendente();
        testMin_size_decrece_trasDequeue();
        testMin_dequeue_hastaVaciar();

        printHeader("COLA PRIORIDAD MIN — clear / contains");
        testMin_clear_vaciaCola();
        testMin_contains_elementoExistente();
        testMin_contains_elementoInexistente();
        testMin_contains_trasClear_false();

        printHeader("COLA PRIORIDAD MIN — replace");
        testMin_replace_elementoExistente_devuelveNuevo();
        testMin_replace_elementoInexistente_devuelveNull();
        testMin_replace_nuevoMinimo_esPeekMin();

        printHeader("COLA PRIORIDAD MIN — toString");
        testMin_toString_vacia();
        testMin_toString_conElementos_ordenAscendente();

        printHeader("COLA PRIORIDAD MIN — tipos genéricos");
        testMin_conStrings();

        printHeader("COLA PRIORIDAD MIN — volumen");
        testMin_volumen_100elementos();
        testMin_volumen_ordenDequeue();

        printHeader("COMPARACIÓN MAX vs MIN — mismos datos");
        test_maxVsMin_dequeueMaxDevuelveMayor();
        test_maxVsMin_dequeueMinDevuelveMenor();
        test_maxVsMin_mismosElementos_distOrden();

        printResumen();
    }

    // ==================================================================
    // COLA PRIORIDAD MAX — Cola vacía
    // ==================================================================

    static void testMax_isEmpty_colaVacia() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        assertIsTrue("MAX vacía: isEmpty() es true", c.isEmpty());
    }

    static void testMax_size_colaVacia_es0() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        assertEqual("MAX vacía: size() es 0", 0, c.size());
    }

    static void testMax_dequeue_vacia_lanzaExcepcion() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        assertThrows("MAX vacía: dequeue() lanza ColaPrioridadVaciaExceptions",
                ColaPrioridadVaciaExceptions.class, () -> c.dequeue());
    }

    static void testMax_peekMax_vacia_lanzaExcepcion() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        assertThrows("MAX vacía: peekMax() lanza ColaPrioridadVaciaExceptions",
                ColaPrioridadVaciaExceptions.class, () -> c.peekMax());
    }

    static void testMax_peekMin_vacia_lanzaExcepcion() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        assertThrows("MAX vacía: peekMin() lanza ColaPrioridadVaciaExceptions",
                ColaPrioridadVaciaExceptions.class, () -> c.peekMin());
    }

    static void testMax_dequeueMin_vacia_lanzaExcepcion() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        assertThrows("MAX vacía: dequeueMin() lanza ColaPrioridadVaciaExceptions",
                ColaPrioridadVaciaExceptions.class, () -> c.dequeueMin());
    }

    static void testMax_excepcion_mensajeDescriptivo() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        try { c.dequeue(); registrarFallo("MAX excepción: no se lanzó"); }
        catch (ColaPrioridadVaciaExceptions e) {
            assertIsTrue("MAX excepción: mensaje no nulo ni vacío",
                    e.getMessage() != null && !e.getMessage().isBlank());
        }
    }

    // ==================================================================
    // COLA PRIORIDAD MAX — Inserción y orden
    // ==================================================================

    static void testMax_enqueue_unElemento_noEstaVacia() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(5);
        assertIsFalse("MAX enqueue: no vacía tras insertar", c.isEmpty());
    }

    static void testMax_enqueue_size_correcto() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(1); c.enqueue(2); c.enqueue(3);
        assertEqual("MAX enqueue: size es 3", 3, c.size());
    }

    static void testMax_peekMax_devuelveMayor() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(3); c.enqueue(1); c.enqueue(5); c.enqueue(2);
        assertEqual("MAX peekMax: devuelve 5 (el mayor)", 5, c.peekMax());
    }

    static void testMax_peekMin_devuelveMenor() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(3); c.enqueue(1); c.enqueue(5); c.enqueue(2);
        assertEqual("MAX peekMin: devuelve 1 (el menor)", 1, c.peekMin());
    }

    static void testMax_peekMax_noModificaSize() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(10); c.enqueue(20);
        c.peekMax();
        assertEqual("MAX peekMax: size no cambia tras peek", 2, c.size());
    }

    static void testMax_peekMin_noModificaSize() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(10); c.enqueue(20);
        c.peekMin();
        assertEqual("MAX peekMin: size no cambia tras peek", 2, c.size());
    }

    // ==================================================================
    // COLA PRIORIDAD MAX — dequeue / dequeueMin
    // ==================================================================

    static void testMax_dequeue_devuelveMayor() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(10); c.enqueue(50); c.enqueue(30);
        assertEqual("MAX dequeue: devuelve 50 (el mayor)", 50, c.dequeue());
    }

    static void testMax_dequeue_ordenDescendente() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(3); c.enqueue(1); c.enqueue(4); c.enqueue(1); c.enqueue(5);
        assertEqual("MAX dequeue orden: 1er dequeue es 5", 5, c.dequeue());
        assertEqual("MAX dequeue orden: 2do dequeue es 4", 4, c.dequeue());
        assertEqual("MAX dequeue orden: 3er dequeue es 3", 3, c.dequeue());
    }

    static void testMax_dequeueMin_devuelveMenor() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(10); c.enqueue(50); c.enqueue(30);
        assertEqual("MAX dequeueMin: devuelve 10 (el menor)", 10, c.dequeueMin());
    }

    static void testMax_dequeueMin_ordenAscendente() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(5); c.enqueue(2); c.enqueue(8);
        assertEqual("MAX dequeueMin orden: 1er es 2", 2, c.dequeueMin());
        assertEqual("MAX dequeueMin orden: 2do es 5", 5, c.dequeueMin());
        assertEqual("MAX dequeueMin orden: 3er es 8", 8, c.dequeueMin());
    }

    static void testMax_size_decrece_trasDequeue() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(1); c.enqueue(2); c.enqueue(3);
        c.dequeue();
        assertEqual("MAX size: decrece a 2 tras dequeue", 2, c.size());
        c.dequeueMin();
        assertEqual("MAX size: decrece a 1 tras dequeueMin", 1, c.size());
    }

    // ==================================================================
    // COLA PRIORIDAD MAX — clear / contains
    // ==================================================================

    static void testMax_clear_vaciaCola() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(1); c.enqueue(2); c.enqueue(3);
        c.clear();
        assertIsTrue("MAX clear: isEmpty() true tras clear", c.isEmpty());
        assertEqual("MAX clear: size es 0 tras clear", 0, c.size());
    }

    static void testMax_contains_elementoExistente() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(42);
        assertIsTrue("MAX contains: encuentra 42", c.contains(42));
    }

    static void testMax_contains_elementoInexistente() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(1);
        assertIsFalse("MAX contains: no encuentra 99", c.contains(99));
    }

    static void testMax_contains_trasClear_false() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(5); c.clear();
        assertIsFalse("MAX contains: false tras clear", c.contains(5));
    }

    // ==================================================================
    // COLA PRIORIDAD MAX — replace
    // ==================================================================

    static void testMax_replace_elementoExistente_devuelveNuevo() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(10); c.enqueue(20);
        Integer resultado = c.replace(10, 15);
        assertIsTrue("MAX replace: devuelve el nuevo dato (15)", resultado != null && resultado == 15);
    }

    static void testMax_replace_elementoInexistente_devuelveNull() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(10);
        assertIsTrue("MAX replace: devuelve null si viejo no existe", c.replace(99, 50) == null);
    }

    static void testMax_replace_nuevoMaximo_esPeekMax() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(10); c.enqueue(20); c.enqueue(30);
        c.replace(30, 100); // sustituimos el máximo por uno mayor
        assertEqual("MAX replace: nuevo máximo es peekMax", 100, c.peekMax());
    }

    static void testMax_replace_mantieneOrden() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(5); c.enqueue(10); c.enqueue(15);
        c.replace(10, 12); // 10 → 12, sigue siendo el del medio
        assertIsTrue("MAX replace: viejo no existe", !c.contains(10));
        assertIsTrue("MAX replace: nuevo existe",     c.contains(12));
        assertEqual("MAX replace: peekMax sigue siendo 15", 15, c.peekMax());
        assertEqual("MAX replace: peekMin sigue siendo 5",   5, c.peekMin());
    }

    // ==================================================================
    // COLA PRIORIDAD MAX — toString
    // ==================================================================

    static void testMax_toString_vacia() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        assertEqualString("MAX toString vacía: '[]'", "[]", c.toString());
    }

    static void testMax_toString_conElementos_ordenAscendente() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        c.enqueue(3); c.enqueue(1); c.enqueue(2);
        // LDEOrdenada almacena en orden ascendente: [1, 2, 3]
        assertEqualString("MAX toString: '[1, 2, 3]'", "[1, 2, 3]", c.toString());
    }

    // ==================================================================
    // COLA PRIORIDAD MAX — tipos genéricos
    // ==================================================================

    static void testMax_conStrings() {
        ColaPrioridadMax<String> c = new ColaPrioridadMax<>();
        c.enqueue("manzana"); c.enqueue("pera"); c.enqueue("cereza");
        // Orden lexicográfico: cereza < manzana < pera → peekMax = "pera"
        assertEqualString("MAX String: peekMax es 'pera'", "pera", c.peekMax());
        assertEqualString("MAX String: peekMin es 'cereza'", "cereza", c.peekMin());
        assertEqualString("MAX String: dequeue devuelve 'pera'", "pera", c.dequeue());
    }

    static void testMax_conDoubles() {
        ColaPrioridadMax<Double> c = new ColaPrioridadMax<>();
        c.enqueue(3.14); c.enqueue(2.71); c.enqueue(1.41);
        assertEqualDouble("MAX Double: peekMax es 3.14", 3.14, c.peekMax());
        assertEqualDouble("MAX Double: dequeue devuelve 3.14", 3.14, c.dequeue());
    }

    // ==================================================================
    // COLA PRIORIDAD MAX — volumen
    // ==================================================================

    static void testMax_volumen_100elementos() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        for (int i = 1; i <= 100; i++) c.enqueue(i);
        assertEqual("MAX volumen: size es 100", 100, c.size());
        assertEqual("MAX volumen: peekMax es 100", 100, c.peekMax());
        assertEqual("MAX volumen: peekMin es 1",     1, c.peekMin());
    }

    static void testMax_volumen_ordenDequeue() {
        ColaPrioridadMax<Integer> c = new ColaPrioridadMax<>();
        for (int i = 1; i <= 20; i++) c.enqueue(i);
        boolean ordenCorrecto = true;
        int anterior = Integer.MAX_VALUE;
        while (!c.isEmpty()) {
            int actual = c.dequeue();
            if (actual > anterior) { ordenCorrecto = false; break; }
            anterior = actual;
        }
        assertIsTrue("MAX volumen: dequeue devuelve siempre el mayor restante", ordenCorrecto);
    }

    // ==================================================================
    // COLA PRIORIDAD MIN — Cola vacía
    // ==================================================================

    static void testMin_isEmpty_colaVacia() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        assertIsTrue("MIN vacía: isEmpty() es true", c.isEmpty());
    }

    static void testMin_size_colaVacia_es0() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        assertEqual("MIN vacía: size() es 0", 0, c.size());
    }

    static void testMin_dequeue_vacia_lanzaExcepcion() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        assertThrows("MIN vacía: dequeue() lanza ColaPrioridadVaciaExceptions",
                ColaPrioridadVaciaExceptions.class, () -> c.dequeue());
    }

    static void testMin_peekMin_vacia_lanzaExcepcion() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        assertThrows("MIN vacía: peekMin() lanza ColaPrioridadVaciaExceptions",
                ColaPrioridadVaciaExceptions.class, () -> c.peekMin());
    }

    static void testMin_peekMax_vacia_lanzaExcepcion() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        assertThrows("MIN vacía: peekMax() lanza ColaPrioridadVaciaExceptions",
                ColaPrioridadVaciaExceptions.class, () -> c.peekMax());
    }

    static void testMin_excepcion_mensajeDescriptivo() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        try { c.dequeue(); registrarFallo("MIN excepción: no se lanzó"); }
        catch (ColaPrioridadVaciaExceptions e) {
            assertIsTrue("MIN excepción: mensaje no nulo ni vacío",
                    e.getMessage() != null && !e.getMessage().isBlank());
        }
    }

    // ==================================================================
    // COLA PRIORIDAD MIN — Inserción y orden
    // ==================================================================

    static void testMin_enqueue_unElemento_noEstaVacia() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(5);
        assertIsFalse("MIN enqueue: no vacía tras insertar", c.isEmpty());
    }

    static void testMin_enqueue_size_correcto() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(1); c.enqueue(2); c.enqueue(3);
        assertEqual("MIN enqueue: size es 3", 3, c.size());
    }

    static void testMin_peekMin_devuelveMenor() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(3); c.enqueue(1); c.enqueue(5); c.enqueue(2);
        assertEqual("MIN peekMin: devuelve 1 (el menor)", 1, c.peekMin());
    }

    static void testMin_peekMax_devuelveMayor() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(3); c.enqueue(1); c.enqueue(5); c.enqueue(2);
        assertEqual("MIN peekMax: devuelve 5 (el mayor)", 5, c.peekMax());
    }

    static void testMin_peekMin_noModificaSize() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(10); c.enqueue(20);
        c.peekMin();
        assertEqual("MIN peekMin: size no cambia tras peek", 2, c.size());
    }

    // ==================================================================
    // COLA PRIORIDAD MIN — dequeue
    // ==================================================================

    static void testMin_dequeue_devuelveMenor() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(10); c.enqueue(50); c.enqueue(30);
        assertEqual("MIN dequeue: devuelve 10 (el menor)", 10, c.dequeue());
    }

    static void testMin_dequeue_ordenAscendente() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(5); c.enqueue(2); c.enqueue(8); c.enqueue(1);
        assertEqual("MIN dequeue orden: 1er es 1", 1, c.dequeue());
        assertEqual("MIN dequeue orden: 2do es 2", 2, c.dequeue());
        assertEqual("MIN dequeue orden: 3er es 5", 5, c.dequeue());
        assertEqual("MIN dequeue orden: 4to es 8", 8, c.dequeue());
    }

    static void testMin_size_decrece_trasDequeue() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(1); c.enqueue(2); c.enqueue(3);
        c.dequeue();
        assertEqual("MIN size: decrece a 2 tras dequeue", 2, c.size());
    }

    static void testMin_dequeue_hastaVaciar() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(1); c.enqueue(2);
        c.dequeue(); c.dequeue();
        assertIsTrue("MIN dequeue hasta vaciar: isEmpty() true", c.isEmpty());
    }

    // ==================================================================
    // COLA PRIORIDAD MIN — clear / contains
    // ==================================================================

    static void testMin_clear_vaciaCola() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(1); c.enqueue(2);
        c.clear();
        assertIsTrue("MIN clear: isEmpty() true", c.isEmpty());
        assertEqual("MIN clear: size es 0", 0, c.size());
    }

    static void testMin_contains_elementoExistente() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(42);
        assertIsTrue("MIN contains: encuentra 42", c.contains(42));
    }

    static void testMin_contains_elementoInexistente() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(1);
        assertIsFalse("MIN contains: no encuentra 99", c.contains(99));
    }

    static void testMin_contains_trasClear_false() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(5); c.clear();
        assertIsFalse("MIN contains: false tras clear", c.contains(5));
    }

    // ==================================================================
    // COLA PRIORIDAD MIN — replace
    // ==================================================================

    static void testMin_replace_elementoExistente_devuelveNuevo() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(10); c.enqueue(20);
        Integer resultado = c.replace(20, 15);
        assertIsTrue("MIN replace: devuelve nuevo dato (15)", resultado != null && resultado == 15);
    }

    static void testMin_replace_elementoInexistente_devuelveNull() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(10);
        assertIsTrue("MIN replace: null si viejo no existe", c.replace(99, 5) == null);
    }

    static void testMin_replace_nuevoMinimo_esPeekMin() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(10); c.enqueue(20); c.enqueue(30);
        c.replace(10, 1); // sustituimos el mínimo por uno menor
        assertEqual("MIN replace: nuevo mínimo es peekMin", 1, c.peekMin());
    }

    // ==================================================================
    // COLA PRIORIDAD MIN — toString
    // ==================================================================

    static void testMin_toString_vacia() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        assertEqualString("MIN toString vacía: '[]'", "[]", c.toString());
    }

    static void testMin_toString_conElementos_ordenAscendente() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        c.enqueue(3); c.enqueue(1); c.enqueue(2);
        assertEqualString("MIN toString: '[1, 2, 3]'", "[1, 2, 3]", c.toString());
    }

    // ==================================================================
    // COLA PRIORIDAD MIN — tipos genéricos
    // ==================================================================

    static void testMin_conStrings() {
        ColaPrioridadMin<String> c = new ColaPrioridadMin<>();
        c.enqueue("pera"); c.enqueue("manzana"); c.enqueue("cereza");
        // Orden lexicográfico: cereza < manzana < pera
        assertEqualString("MIN String: dequeue devuelve 'cereza'", "cereza", c.dequeue());
        assertEqualString("MIN String: peekMax es 'pera'",         "pera",   c.peekMax());
    }

    // ==================================================================
    // COLA PRIORIDAD MIN — volumen
    // ==================================================================

    static void testMin_volumen_100elementos() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        for (int i = 100; i >= 1; i--) c.enqueue(i); // insertamos en orden descendente
        assertEqual("MIN volumen: size es 100",   100, c.size());
        assertEqual("MIN volumen: peekMin es 1",    1, c.peekMin());
        assertEqual("MIN volumen: peekMax es 100", 100, c.peekMax());
    }

    static void testMin_volumen_ordenDequeue() {
        ColaPrioridadMin<Integer> c = new ColaPrioridadMin<>();
        for (int i = 1; i <= 20; i++) c.enqueue(i);
        boolean ordenCorrecto = true;
        int anterior = Integer.MIN_VALUE;
        while (!c.isEmpty()) {
            int actual = c.dequeue();
            if (actual < anterior) { ordenCorrecto = false; break; }
            anterior = actual;
        }
        assertIsTrue("MIN volumen: dequeue devuelve siempre el menor restante", ordenCorrecto);
    }

    // ==================================================================
    // COMPARACIÓN MAX vs MIN
    // ==================================================================

    static void test_maxVsMin_dequeueMaxDevuelveMayor() {
        ColaPrioridadMax<Integer> max = new ColaPrioridadMax<>();
        ColaPrioridadMin<Integer> min = new ColaPrioridadMin<>();
        int[] vals = {3, 1, 4, 1, 5, 9, 2, 6};
        for (int v : vals) { max.enqueue(v); min.enqueue(v); }
        assertEqual("MAX vs MIN: dequeue MAX devuelve 9 (mayor)", 9, max.dequeue());
        assertEqual("MAX vs MIN: dequeue MIN devuelve 1 (menor)", 1, min.dequeue());
    }

    static void test_maxVsMin_dequeueMinDevuelveMenor() {
        ColaPrioridadMax<Integer> max = new ColaPrioridadMax<>();
        int[] vals = {10, 20, 30, 5};
        for (int v : vals) max.enqueue(v);
        assertEqual("MAX dequeueMin: devuelve 5 (el menor)", 5, max.dequeueMin());
        assertEqual("MAX dequeue: devuelve 30 (el mayor)",  30, max.dequeue());
    }

    static void test_maxVsMin_mismosElementos_distOrden() {
        ColaPrioridadMax<Integer> max = new ColaPrioridadMax<>();
        ColaPrioridadMin<Integer> min = new ColaPrioridadMin<>();
        for (int i = 1; i <= 5; i++) { max.enqueue(i); min.enqueue(i); }
        // MAX saca de mayor a menor, MIN de menor a mayor
        boolean maxOrdenOk = true, minOrdenOk = true;
        int prevMax = Integer.MAX_VALUE, prevMin = Integer.MIN_VALUE;
        while (!max.isEmpty() && !min.isEmpty()) {
            int m = max.dequeue(), n = min.dequeue();
            if (m > prevMax) maxOrdenOk = false;
            if (n < prevMin) minOrdenOk = false;
            prevMax = m; prevMin = n;
        }
        assertIsTrue("MAX vs MIN: MAX extrae descendente", maxOrdenOk);
        assertIsTrue("MAX vs MIN: MIN extrae ascendente",  minOrdenOk);
    }

    // ==================================================================
    // MOTOR DE ASERCIONES (sin JUnit)
    // ==================================================================

    @FunctionalInterface interface Accion { void ejecutar(); }

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

    static void assertEqualDouble(String nombre, double esperado, double actual) {
        totalTests++;
        if (Math.abs(esperado - actual) < 0.0001) registrarOk(nombre);
        else registrarFallo(nombre + " → esperado: " + esperado + ", obtenido: " + actual);
    }

    static void assertIsTrue(String nombre, boolean c) {
        totalTests++;
        if (c) registrarOk(nombre);
        else   registrarFallo(nombre + " → esperado: true, obtenido: false");
    }

    static void assertIsFalse(String nombre, boolean c) {
        totalTests++;
        if (!c) registrarOk(nombre);
        else    registrarFallo(nombre + " → esperado: false, obtenido: true");
    }

    static void assertThrows(String nombre, Class<? extends Exception> tipo, Accion accion) {
        totalTests++;
        try { accion.ejecutar(); registrarFallo(nombre + " → no se lanzó excepción"); }
        catch (Exception e) {
            if (tipo.isInstance(e)) registrarOk(nombre);
            else registrarFallo(nombre + " → excepción incorrecta: " + e.getClass().getSimpleName());
        }
    }

    static void registrarOk(String n)    { totalPassed++; System.out.println("  [OK]   " + n); }
    static void registrarFallo(String n) { totalFailed++; System.out.println("  [FAIL] " + n); }

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