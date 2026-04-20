package Colas.ColaPrioridad;
public class TestCola {
    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE URGENCIAS HOSPITALARIAS ===\n");

        // -------------------------------------------------------
        // COLA DE PRIORIDAD MÁXIMA
        // Los pacientes más graves (mayor número) salen primero
        // -------------------------------------------------------
        System.out.println("--- COLA PRIORIDAD MÁXIMA (más grave primero) ---");
        ColaPrioridadMax<Integer> urgenciasMax = new ColaPrioridadMax<>();

        // Ingresamos pacientes con nivel de gravedad del 1 al 10
        System.out.println("Ingresando pacientes...");
        urgenciasMax.enqueue(3);  // Paciente con gravedad 3 (leve)
        urgenciasMax.enqueue(9);  // Paciente con gravedad 9 (muy grave)
        urgenciasMax.enqueue(1);  // Paciente con gravedad 1 (muy leve)
        urgenciasMax.enqueue(7);  // Paciente con gravedad 7 (grave)
        urgenciasMax.enqueue(5);  // Paciente con gravedad 5 (moderado)
        System.out.println("Colas.Cola de urgencias: " + urgenciasMax);
        System.out.println("Número de pacientes en espera: " + urgenciasMax.size());
        System.out.println("Paciente más grave: " + urgenciasMax.peekMax());
        System.out.println("Paciente menos grave: " + urgenciasMax.peekMin());

        // Atendemos pacientes por orden de gravedad
        System.out.println("\nAtendiendo pacientes por orden de gravedad:");
        System.out.println("Atendiendo paciente con gravedad: " + urgenciasMax.dequeue());
        System.out.println("Atendiendo paciente con gravedad: " + urgenciasMax.dequeue());
        System.out.println("Colas.Cola tras atender 2 pacientes: " + urgenciasMax);

        // Comprobamos si existe un paciente con gravedad 5
        System.out.println("\n¿Existe paciente con gravedad 5? " + urgenciasMax.contains(5));
        System.out.println("¿Existe paciente con gravedad 9? " + urgenciasMax.contains(9));

        // Actualizamos la gravedad de un paciente
        System.out.println("\nActualizando gravedad del paciente 3 a 8...");
        urgenciasMax.replace(3, 8);
        System.out.println("Colas.Cola tras actualizar: " + urgenciasMax);

        // Atendemos al paciente menos grave directamente
        System.out.println("\nAtendiendo paciente menos grave directamente: " + urgenciasMax.dequeueMin());
        System.out.println("Colas.Cola final: " + urgenciasMax);

        // Vaciamos la cola al cerrar el turno
        System.out.println("\nCerrando turno de urgencias...");
        urgenciasMax.clear();
        System.out.println("¿Colas.Cola vacía? " + urgenciasMax.isEmpty());

        // -------------------------------------------------------
        // COLA DE PRIORIDAD MÍNIMA
        // Los pacientes menos graves (menor número) salen primero
        // -------------------------------------------------------
        System.out.println("\n--- COLA PRIORIDAD MÍNIMA (menos grave primero) ---");
        ColaPrioridadMin<Integer> urgenciasMin = new ColaPrioridadMin<>();

        // Ingresamos pacientes con nivel de gravedad del 1 al 10
        System.out.println("Ingresando pacientes...");
        urgenciasMin.enqueue(4);  // Paciente con gravedad 4 (leve)
        urgenciasMin.enqueue(8);  // Paciente con gravedad 8 (muy grave)
        urgenciasMin.enqueue(2);  // Paciente con gravedad 2 (muy leve)
        urgenciasMin.enqueue(6);  // Paciente con gravedad 6 (moderado)
        urgenciasMin.enqueue(10); // Paciente con gravedad 10 (crítico)
        System.out.println("Colas.Cola de urgencias: " + urgenciasMin);
        System.out.println("Número de pacientes en espera: " + urgenciasMin.size());
        System.out.println("Paciente menos grave: " + urgenciasMin.peekMin());
        System.out.println("Paciente más grave: " + urgenciasMin.peekMax());

        // Atendemos pacientes por orden de menor gravedad
        System.out.println("\nAtendiendo pacientes por orden de menor gravedad:");
        System.out.println("Atendiendo paciente con gravedad: " + urgenciasMin.dequeue());
        System.out.println("Atendiendo paciente con gravedad: " + urgenciasMin.dequeue());
        System.out.println("Colas.Cola tras atender 2 pacientes: " + urgenciasMin);

        // Comprobamos si existe un paciente con gravedad 6
        System.out.println("\n¿Existe paciente con gravedad 6? " + urgenciasMin.contains(6));
        System.out.println("¿Existe paciente con gravedad 2? " + urgenciasMin.contains(2));

        // Actualizamos la gravedad de un paciente
        System.out.println("\nActualizando gravedad del paciente 6 a 1...");
        urgenciasMin.replace(6, 1);
        System.out.println("Colas.Cola tras actualizar: " + urgenciasMin);

        // Vaciamos la cola al cerrar el turno
        System.out.println("\nCerrando turno de urgencias...");
        urgenciasMin.clear();
        System.out.println("¿Colas.Cola vacía? " + urgenciasMin.isEmpty());
    }
}