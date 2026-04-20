package Colas.Cola;

public class TestCola {
    public static void main(String[] args) {

        System.out.println("=== COLA DE IMPRESIÓN ===\n");

        Cola<String> impresora = new Cola<>();

        // -------------------------------------------------------
        // Añadimos trabajos de impresión
        // -------------------------------------------------------
        System.out.println("--- Añadiendo trabajos de impresión ---");
        impresora.enqueue("Informe_Ventas.pdf");
        impresora.enqueue("Contrato_Cliente.docx");
        impresora.enqueue("Presentacion_Reunion.pptx");
        impresora.enqueue("Factura_Marzo.pdf");
        impresora.enqueue("Curriculum.pdf");
        System.out.println("Primer trabajo en cola: " + impresora.peek());
        System.out.println("¿Colas.Cola vacía? " + impresora.isEmpty());

        // -------------------------------------------------------
        // Imprimimos los dos primeros trabajos
        // -------------------------------------------------------
        System.out.println("\n--- Imprimiendo trabajos ---");
        System.out.println("Imprimiendo: " + impresora.dequeue());
        System.out.println("Imprimiendo: " + impresora.dequeue());
        System.out.println("Siguiente trabajo en cola: " + impresora.peek());

        // -------------------------------------------------------
        // Añadimos un trabajo urgente
        // -------------------------------------------------------
        System.out.println("\n--- Añadiendo trabajo urgente ---");
        impresora.enqueue("Contrato_Urgente.pdf");
        System.out.println("Siguiente trabajo en cola: " + impresora.peek());

        // -------------------------------------------------------
        // Imprimimos todos los trabajos restantes
        // -------------------------------------------------------
        System.out.println("\n--- Imprimiendo trabajos restantes ---");
        while (!impresora.isEmpty()) {
            System.out.println("Imprimiendo: " + impresora.dequeue());
        }
        System.out.println("¿Colas.Cola vacía? " + impresora.isEmpty());
    }
}