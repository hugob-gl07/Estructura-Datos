package PILA.COLA.LISTACIRCULAR;
public class TestPila {
    public static void main(String[] args) {

        System.out.println("=== NAVEGADOR WEB CON PILA ===\n");

        Pila<String> historial = new Pila<>();

        // -------------------------------------------------------
        // Navegamos por varias páginas
        // -------------------------------------------------------
        System.out.println("--- Navegando por páginas ---");
        historial.push("google.com");
        historial.push("youtube.com");
        historial.push("github.com");
        historial.push("stackoverflow.com");
        historial.push("wikipedia.org");
        System.out.println("Página actual: " + historial.peek());
        System.out.println("¿Historial vacío? " + historial.isEmpty());

        // -------------------------------------------------------
        // Retrocedemos en el historial
        // -------------------------------------------------------
        System.out.println("\n--- Retrocediendo en el historial ---");
        System.out.println("Saliendo de: " + historial.pop());
        System.out.println("Saliendo de: " + historial.pop());
        System.out.println("Página actual tras retroceder: " + historial.peek());

        // -------------------------------------------------------
        // Navegamos a una página nueva
        // -------------------------------------------------------
        System.out.println("\n--- Navegando a nueva página ---");
        historial.push("twitter.com");
        System.out.println("Página actual: " + historial.peek());

        // -------------------------------------------------------
        // Vaciamos el historial cerrando el navegador
        // -------------------------------------------------------
        System.out.println("\n--- Cerrando navegador ---");
        while (!historial.isEmpty()) {
            System.out.println("Cerrando: " + historial.pop());
        }
        System.out.println("¿Historial vacío? " + historial.isEmpty());
    }
}