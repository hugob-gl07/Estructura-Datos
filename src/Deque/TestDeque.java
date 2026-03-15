package Deque;

public class TestDeque {
    public static void main(String[] args) {

        System.out.println("=== SIMULACIÓN DE NAVEGADOR WEB ===\n");

        Deque<String> historial = new Deque<String>();

        // -------------------------------------------------------
        // Navegamos por varias páginas
        // -------------------------------------------------------
        System.out.println("--- Navegando por páginas ---");
        historial.addLast("google.com");
        historial.addLast("youtube.com");
        historial.addLast("github.com");
        historial.addLast("stackoverflow.com");
        historial.addLast("wikipedia.org");
        System.out.println("Historial actual: " + historial);
        System.out.println("Número de páginas visitadas: " + historial.size());

        // -------------------------------------------------------
        // Consultamos la página actual y la primera visitada
        // -------------------------------------------------------
        System.out.println("\n--- Consultando páginas ---");
        System.out.println("Página actual (última visitada): " + historial.peekLast());
        System.out.println("Primera página visitada: " + historial.peekFirst());

        // -------------------------------------------------------
        // Retrocedemos en el historial
        // -------------------------------------------------------
        System.out.println("\n--- Retrocediendo en el historial ---");
        System.out.println("Retrocediendo desde: " + historial.removeLast());
        System.out.println("Retrocediendo desde: " + historial.removeLast());
        System.out.println("Página actual tras retroceder: " + historial.peekLast());
        System.out.println("Historial tras retroceder: " + historial);

        // -------------------------------------------------------
        // Añadimos una página urgente al inicio
        // -------------------------------------------------------
        System.out.println("\n--- Añadiendo página urgente al inicio ---");
        historial.addFirst("banco.com");
        System.out.println("Historial tras añadir página urgente: " + historial);
        System.out.println("Primera página del historial: " + historial.peekFirst());

        // -------------------------------------------------------
        // Comprobamos si ciertas páginas están en el historial
        // -------------------------------------------------------
        System.out.println("\n--- Comprobando páginas en el historial ---");
        System.out.println("¿Está google.com en el historial? " + historial.contains("google.com"));
        System.out.println("¿Está wikipedia.org en el historial? " + historial.contains("wikipedia.org"));
        System.out.println("¿Está twitter.com en el historial? " + historial.contains("twitter.com"));

        // -------------------------------------------------------
        // Eliminamos la primera página del historial
        // -------------------------------------------------------
        System.out.println("\n--- Eliminando primera página del historial ---");
        System.out.println("Eliminando: " + historial.removeFirst());
        System.out.println("Historial tras eliminar primera página: " + historial);

        // -------------------------------------------------------
        // Cerramos el navegador vaciando el historial
        // -------------------------------------------------------
        System.out.println("\n--- Cerrando navegador ---");
        historial.clear();
        System.out.println("¿Historial vacío? " + historial.isEmpty());
    }
}