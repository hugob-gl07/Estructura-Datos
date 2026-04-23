package Grafos;
/**
 * Suite de tests manuales para Grafo, Nodo, Arista y EntradaAdyacencia.
 * No requiere JUnit. Ejecutar con el botón ▶️ de IntelliJ.
 */
public class GrafoTest {

    private static int totalTests  = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    public static void main(String[] args) {

        printHeader("NODO — constructor y getters");
        test_nodo_getId();
        test_nodo_getNombre();

        printHeader("NODO — setters");
        test_nodo_setNombre();
        test_nodo_setId();

        printHeader("NODO — compareTo");
        test_nodo_compareTo_igual();
        test_nodo_compareTo_menor();
        test_nodo_compareTo_mayor();

        printHeader("ARISTA — constructor y getters");
        test_arista_getOrigen();
        test_arista_getDestino();
        test_arista_getEtiqueta();

        printHeader("ARISTA — setters");
        test_arista_setOrigen();
        test_arista_setDestino();
        test_arista_setEtiqueta();

        printHeader("ARISTA — compareTo");
        test_arista_compareTo_igual();
        test_arista_compareTo_menor();
        test_arista_compareTo_mayor();

        printHeader("ENTRADA ADYACENCIA — constructor y getters");
        test_entrada_getNodo();
        test_entrada_getAristas_inicialmenteVacia();

        printHeader("ENTRADA ADYACENCIA — setters");
        test_entrada_setNodo();

        printHeader("ENTRADA ADYACENCIA — compareTo");
        test_entrada_compareTo_delegaEnNodo();

        printHeader("GRAFO — agregarNodo");
        test_grafo_agregarNodo_nuevoPuedeEncontrarse();
        test_grafo_agregarNodo_noDuplicados();
        test_grafo_agregarNodo_variosNodos();

        printHeader("GRAFO — buscarEntrada");
        test_grafo_buscarEntrada_existente();
        test_grafo_buscarEntrada_inexistente_devuelveNull();

        printHeader("GRAFO — agregarArista");
        test_grafo_agregarArista_creaArista();
        test_grafo_agregarArista_creaAutomaticamenteNodosNuevos();
        test_grafo_agregarArista_variosDestinosDesdeUnOrigen();
        test_grafo_agregarArista_aristaEnOrigenCorrecto();
        test_grafo_agregarArista_destinoNoTieneArista();

        printHeader("GRAFO — casos de borde");
        test_grafo_aristaEntreNodosYaExistentes();
        test_grafo_buscarEntradaDespuesDeAgregarArista();
        test_grafo_contadorIncrementaCorrectamente();

        printResumen();
    }

    // ==================================================================
    // NODO — constructor y getters
    // ==================================================================

    static void test_nodo_getId() {
        Nodo n = new Nodo(1, "Madrid");
        assertEqual("Nodo getId: devuelve 1", 1, n.getId());
    }

    static void test_nodo_getNombre() {
        Nodo n = new Nodo(1, "Madrid");
        assertEqualString("Nodo getNombre: devuelve 'Madrid'", "Madrid", n.getNombre());
    }

    // ==================================================================
    // NODO — setters
    // ==================================================================

    static void test_nodo_setNombre() {
        Nodo n = new Nodo(1, "Madrid");
        n.setNombre("Barcelona");
        assertEqualString("Nodo setNombre: actualiza a 'Barcelona'", "Barcelona", n.getNombre());
    }

    static void test_nodo_setId() {
        Nodo n = new Nodo(1, "Madrid");
        n.setId(99);
        assertEqual("Nodo setId: actualiza a 99", 99, n.getId());
    }

    // ==================================================================
    // NODO — compareTo
    // ==================================================================

    static void test_nodo_compareTo_igual() {
        Nodo a = new Nodo(1, "Madrid");
        Nodo b = new Nodo(2, "Madrid"); // mismo nombre, distinto id
        assertEqual("Nodo compareTo: mismo nombre → 0", 0, a.compareTo(b));
    }

    static void test_nodo_compareTo_menor() {
        Nodo a = new Nodo(1, "Barcelona"); // B < M lexicográficamente
        Nodo b = new Nodo(2, "Madrid");
        assertIsTrue("Nodo compareTo: 'Barcelona' < 'Madrid' → negativo", a.compareTo(b) < 0);
    }

    static void test_nodo_compareTo_mayor() {
        Nodo a = new Nodo(1, "Sevilla"); // S > M lexicográficamente
        Nodo b = new Nodo(2, "Madrid");
        assertIsTrue("Nodo compareTo: 'Sevilla' > 'Madrid' → positivo", a.compareTo(b) > 0);
    }

    // ==================================================================
    // ARISTA — constructor y getters
    // ==================================================================

    static void test_arista_getOrigen() {
        Nodo origen  = new Nodo(1, "Madrid");
        Nodo destino = new Nodo(2, "Barcelona");
        Arista a = new Arista(origen, "A1", destino);
        assertEqualString("Arista getOrigen: nombre es 'Madrid'", "Madrid", a.getOrigen().getNombre());
    }

    static void test_arista_getDestino() {
        Nodo origen  = new Nodo(1, "Madrid");
        Nodo destino = new Nodo(2, "Barcelona");
        Arista a = new Arista(origen, "A1", destino);
        assertEqualString("Arista getDestino: nombre es 'Barcelona'", "Barcelona", a.getDestino().getNombre());
    }

    static void test_arista_getEtiqueta() {
        Nodo origen  = new Nodo(1, "Madrid");
        Nodo destino = new Nodo(2, "Barcelona");
        Arista a = new Arista(origen, "autopista", destino);
        assertEqualString("Arista getEtiqueta: devuelve 'autopista'", "autopista", a.getEtiqueta());
    }

    // ==================================================================
    // ARISTA — setters
    // ==================================================================

    static void test_arista_setOrigen() {
        Nodo origen  = new Nodo(1, "Madrid");
        Nodo destino = new Nodo(2, "Barcelona");
        Arista a = new Arista(origen, "A1", destino);
        Nodo nuevoOrigen = new Nodo(3, "Sevilla");
        a.setOrigen(nuevoOrigen);
        assertEqualString("Arista setOrigen: actualiza a 'Sevilla'", "Sevilla", a.getOrigen().getNombre());
    }

    static void test_arista_setDestino() {
        Nodo origen  = new Nodo(1, "Madrid");
        Nodo destino = new Nodo(2, "Barcelona");
        Arista a = new Arista(origen, "A1", destino);
        Nodo nuevoDestino = new Nodo(4, "Valencia");
        a.setDestino(nuevoDestino);
        assertEqualString("Arista setDestino: actualiza a 'Valencia'", "Valencia", a.getDestino().getNombre());
    }

    static void test_arista_setEtiqueta() {
        Nodo origen  = new Nodo(1, "Madrid");
        Nodo destino = new Nodo(2, "Barcelona");
        Arista a = new Arista(origen, "A1", destino);
        a.setEtiqueta("N-II");
        assertEqualString("Arista setEtiqueta: actualiza a 'N-II'", "N-II", a.getEtiqueta());
    }

    // ==================================================================
    // ARISTA — compareTo
    // ==================================================================

    static void test_arista_compareTo_igual() {
        Nodo n1 = new Nodo(1, "A"); Nodo n2 = new Nodo(2, "B");
        Arista a = new Arista(n1, "ruta", n2);
        Arista b = new Arista(n1, "ruta", n2);
        assertEqual("Arista compareTo: misma etiqueta → 0", 0, a.compareTo(b));
    }

    static void test_arista_compareTo_menor() {
        Nodo n1 = new Nodo(1, "A"); Nodo n2 = new Nodo(2, "B");
        Arista a = new Arista(n1, "autopista", n2); // 'a' < 'c' lexicográfico
        Arista b = new Arista(n1, "carretera",  n2);
        assertIsTrue("Arista compareTo: 'autopista' < 'carretera' → negativo", a.compareTo(b) < 0);
    }

    static void test_arista_compareTo_mayor() {
        Nodo n1 = new Nodo(1, "A"); Nodo n2 = new Nodo(2, "B");
        Arista a = new Arista(n1, "via",        n2); // 'v' > 'c' lexicográfico
        Arista b = new Arista(n1, "carretera",  n2);
        assertIsTrue("Arista compareTo: 'via' > 'carretera' → positivo", a.compareTo(b) > 0);
    }

    // ==================================================================
    // ENTRADA ADYACENCIA — constructor y getters
    // ==================================================================

    static void test_entrada_getNodo() {
        Nodo n = new Nodo(1, "Madrid");
        EntradaAdyacencia e = new EntradaAdyacencia(n);
        assertEqualString("EntradaAdyacencia getNodo: nombre es 'Madrid'", "Madrid", e.getNodo().getNombre());
    }

    static void test_entrada_getAristas_inicialmenteVacia() {
        Nodo n = new Nodo(1, "Madrid");
        EntradaAdyacencia e = new EntradaAdyacencia(n);
        assertEqual("EntradaAdyacencia getAristas: lista vacía al crear", 0, e.getAristas().getSize());
    }

    // ==================================================================
    // ENTRADA ADYACENCIA — setters
    // ==================================================================

    static void test_entrada_setNodo() {
        Nodo n1 = new Nodo(1, "Madrid");
        Nodo n2 = new Nodo(2, "Barcelona");
        EntradaAdyacencia e = new EntradaAdyacencia(n1);
        e.setNodo(n2);
        assertEqualString("EntradaAdyacencia setNodo: actualiza a 'Barcelona'", "Barcelona", e.getNodo().getNombre());
    }

    // ==================================================================
    // ENTRADA ADYACENCIA — compareTo
    // ==================================================================

    static void test_entrada_compareTo_delegaEnNodo() {
        // compareTo de EntradaAdyacencia debe delegar en el compareTo del nodo (por nombre)
        EntradaAdyacencia e1 = new EntradaAdyacencia(new Nodo(1, "Barcelona"));
        EntradaAdyacencia e2 = new EntradaAdyacencia(new Nodo(2, "Madrid"));
        assertIsTrue("EntradaAdyacencia compareTo: 'Barcelona' < 'Madrid' → negativo", e1.compareTo(e2) < 0);
    }

    // ==================================================================
    // GRAFO — agregarNodo
    // ==================================================================

    static void test_grafo_agregarNodo_nuevoPuedeEncontrarse() {
        Grafo g = new Grafo(0);
        g.agregarNodo("Madrid");
        assertIsTrue("agregarNodo: 'Madrid' puede encontrarse tras añadirlo",
                g.buscarEntrada("Madrid") != null);
    }

    static void test_grafo_agregarNodo_noDuplicados() {
        // Si añadimos el mismo nodo dos veces, buscarEntrada solo debe encontrar uno
        // y el id del nodo no debe cambiar (el contador solo incrementa la primera vez)
        Grafo g = new Grafo(0);
        g.agregarNodo("Madrid");
        int idPrimero = g.buscarEntrada("Madrid").getNodo().getId();
        g.agregarNodo("Madrid"); // segunda vez — no debe duplicar
        int idSegundo = g.buscarEntrada("Madrid").getNodo().getId();
        assertEqual("agregarNodo: nodo duplicado no cambia su id", idPrimero, idSegundo);
    }

    static void test_grafo_agregarNodo_variosNodos() {
        Grafo g = new Grafo(0);
        g.agregarNodo("Madrid");
        g.agregarNodo("Barcelona");
        g.agregarNodo("Valencia");
        assertIsTrue("agregarNodo varios: 'Madrid' encontrado",    g.buscarEntrada("Madrid")    != null);
        assertIsTrue("agregarNodo varios: 'Barcelona' encontrado", g.buscarEntrada("Barcelona") != null);
        assertIsTrue("agregarNodo varios: 'Valencia' encontrado",  g.buscarEntrada("Valencia")  != null);
    }

    // ==================================================================
    // GRAFO — buscarEntrada
    // ==================================================================

    static void test_grafo_buscarEntrada_existente() {
        Grafo g = new Grafo(0);
        g.agregarNodo("Sevilla");
        EntradaAdyacencia e = g.buscarEntrada("Sevilla");
        assertIsTrue("buscarEntrada: devuelve entrada no nula", e != null);
        assertEqualString("buscarEntrada: el nodo tiene el nombre correcto", "Sevilla", e.getNodo().getNombre());
    }

    static void test_grafo_buscarEntrada_inexistente_devuelveNull() {
        Grafo g = new Grafo(0);
        g.agregarNodo("Madrid");
        assertIsTrue("buscarEntrada: nombre inexistente devuelve null",
                g.buscarEntrada("Zaragoza") == null);
    }

    // ==================================================================
    // GRAFO — agregarArista
    // ==================================================================

    static void test_grafo_agregarArista_creaArista() {
        Grafo g = new Grafo(0);
        g.agregarArista("Madrid", "Barcelona", "A2");
        EntradaAdyacencia origen = g.buscarEntrada("Madrid");
        assertEqual("agregarArista: el origen tiene exactamente 1 arista", 1, origen.getAristas().getSize());
    }

    static void test_grafo_agregarArista_creaAutomaticamenteNodosNuevos() {
        // agregarArista crea los nodos si aún no existen
        Grafo g = new Grafo(0);
        g.agregarArista("Bilbao", "Pamplona", "N-1");
        assertIsTrue("agregarArista: crea nodo origen 'Bilbao'",   g.buscarEntrada("Bilbao")   != null);
        assertIsTrue("agregarArista: crea nodo destino 'Pamplona'", g.buscarEntrada("Pamplona") != null);
    }

    static void test_grafo_agregarArista_variosDestinosDesdeUnOrigen() {
        Grafo g = new Grafo(0);
        g.agregarArista("Madrid", "Barcelona", "A2");
        g.agregarArista("Madrid", "Sevilla",   "A4");
        g.agregarArista("Madrid", "Valencia",  "A3");
        EntradaAdyacencia madrid = g.buscarEntrada("Madrid");
        assertEqual("agregarArista: Madrid tiene 3 aristas salientes", 3, madrid.getAristas().getSize());
    }

    static void test_grafo_agregarArista_aristaEnOrigenCorrecto() {
        Grafo g = new Grafo(0);
        g.agregarArista("Madrid", "Barcelona", "A2");
        Arista arista = g.buscarEntrada("Madrid").getAristas().getAt(0);
        assertEqualString("agregarArista: origen de la arista es 'Madrid'",   "Madrid",    arista.getOrigen().getNombre());
        assertEqualString("agregarArista: destino de la arista es 'Barcelona'", "Barcelona", arista.getDestino().getNombre());
        assertEqualString("agregarArista: etiqueta de la arista es 'A2'",     "A2",        arista.getEtiqueta());
    }

    static void test_grafo_agregarArista_destinoNoTieneArista() {
        // En un grafo dirigido, añadir Madrid→Barcelona no añade arista en Barcelona
        Grafo g = new Grafo(0);
        g.agregarArista("Madrid", "Barcelona", "A2");
        EntradaAdyacencia barcelona = g.buscarEntrada("Barcelona");
        assertEqual("agregarArista: destino 'Barcelona' no tiene aristas salientes", 0, barcelona.getAristas().getSize());
    }

    // ==================================================================
    // GRAFO — casos de borde
    // ==================================================================

    static void test_grafo_aristaEntreNodosYaExistentes() {
        // Si los nodos ya existen agregarArista no debe duplicarlos
        Grafo g = new Grafo(0);
        g.agregarNodo("Madrid");
        g.agregarNodo("Barcelona");
        g.agregarArista("Madrid", "Barcelona", "A2");
        // Madrid sigue siendo el mismo nodo (mismo id)
        int idMadrid = g.buscarEntrada("Madrid").getNodo().getId();
        assertEqual("borde: Madrid conserva su id original (0) tras agregarArista", 0, idMadrid);
    }

    static void test_grafo_buscarEntradaDespuesDeAgregarArista() {
        Grafo g = new Grafo(0);
        g.agregarArista("Sevilla", "Málaga", "A92");
        EntradaAdyacencia sevilla = g.buscarEntrada("Sevilla");
        assertIsTrue("borde: buscarEntrada funciona tras agregarArista", sevilla != null);
        assertEqual("borde: Sevilla tiene 1 arista saliente", 1, sevilla.getAristas().getSize());
    }

    static void test_grafo_contadorIncrementaCorrectamente() {
        // Los ids de los nodos deben ser 0, 1, 2... según el orden de inserción
        Grafo g = new Grafo(0);
        g.agregarNodo("A");
        g.agregarNodo("B");
        g.agregarNodo("C");
        int idA = g.buscarEntrada("A").getNodo().getId();
        int idB = g.buscarEntrada("B").getNodo().getId();
        int idC = g.buscarEntrada("C").getNodo().getId();
        assertEqual("contador: id de 'A' es 0", 0, idA);
        assertEqual("contador: id de 'B' es 1", 1, idB);
        assertEqual("contador: id de 'C' es 2", 2, idC);
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

    static void assertIsTrue(String nombre, boolean c) {
        totalTests++;
        if (c) registrarOk(nombre);
        else   registrarFallo(nombre + " → esperado: true, obtenido: false");
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
