package LSE;

public class TestListaSimplementeEnlazada {
    public static void main(String[] args) {

        System.out.println("=== LISTA DE ESTUDIANTES ===\n");

        // -------------------------------------------------------
        // TEST LISTA SIMPLEMENTE ENLAZADA
        // Los estudiantes se guardan en orden de matriculación
        // -------------------------------------------------------
        System.out.println("--- LISTA DE ESTUDIANTES NORMAL (orden de matriculación) ---");
        ListaSimplementeEnlazada<String> estudiantes = new ListaSimplementeEnlazada<>();

        // Añadimos estudiantes al final de la lista
        System.out.println("Matriculando estudiantes...");
        estudiantes.add("Carlos García");
        estudiantes.add("Ana Martínez");
        estudiantes.add("Pedro López");
        estudiantes.add("María Sánchez");
        estudiantes.add("Juan Pérez");
        System.out.println("Lista de estudiantes: " + estudiantes);
        System.out.println("Número de estudiantes: " + estudiantes.getSize());

        // Añadimos un estudiante al inicio
        System.out.println("\n--- Añadiendo estudiante al inicio ---");
        estudiantes.addFirst("Laura Gómez");
        System.out.println("Lista tras añadir al inicio: " + estudiantes);

        // Obtenemos un estudiante por posición
        System.out.println("\n--- Obteniendo estudiantes por posición ---");
        System.out.println("Estudiante en posición 0: " + estudiantes.getAt(0));
        System.out.println("Estudiante en posición 3: " + estudiantes.getAt(3));
        System.out.println("Estudiante en posición 10: " + estudiantes.getAt(10));

        // Insertamos un estudiante en una posición concreta
        System.out.println("\n--- Insertando estudiante en posición 2 ---");
        estudiantes.insertAt(2, "Sofía Torres");
        System.out.println("Lista tras insertar en posición 2: " + estudiantes);

        // Buscamos un estudiante por valor
        System.out.println("\n--- Buscando estudiantes ---");
        System.out.println("Buscando Ana Martínez: " + estudiantes.get("Ana Martínez"));
        System.out.println("Buscando Roberto Ruiz: " + estudiantes.get("Roberto Ruiz"));

        // Eliminamos un estudiante por valor
        System.out.println("\n--- Eliminando estudiante por valor ---");
        System.out.println("Eliminando Pedro López: " + estudiantes.del("Pedro López"));
        System.out.println("Lista tras eliminar: " + estudiantes);

        // Eliminamos estudiantes por posición
        System.out.println("\n--- Eliminando estudiantes por posición ---");
        System.out.println("Eliminando posición 0: " + estudiantes.removeAt(0));
        System.out.println("Lista tras eliminar posición 0: " + estudiantes);

        // Recorremos la lista con el iterador
        System.out.println("\n--- Recorriendo lista con iterador ---");
        Iterador<String> iterador = estudiantes.getIterador();
        while (iterador.hasNext()) {
            System.out.println("Estudiante: " + iterador.next());
        }

        // -------------------------------------------------------
        // TEST LISTA SIMPLEMENTE ENLAZADA ORDENADA
        // Los estudiantes se guardan en orden alfabético
        // -------------------------------------------------------
        System.out.println("\n--- LISTA DE ESTUDIANTES ORDENADA (orden alfabético) ---");
        LSEOrdenada<String> estudiantesOrdenados = new LSEOrdenada<>();

        // Añadimos estudiantes en desorden
        System.out.println("Matriculando estudiantes en desorden...");
        estudiantesOrdenados.add("Pedro López");
        estudiantesOrdenados.add("Ana Martínez");
        estudiantesOrdenados.add("María Sánchez");
        estudiantesOrdenados.add("Carlos García");
        estudiantesOrdenados.add("Juan Pérez");
        System.out.println("Lista ordenada: " + estudiantesOrdenados);
        System.out.println("Número de estudiantes: " + estudiantesOrdenados.getSize());

        // Añadimos un estudiante que va al inicio alfabéticamente
        System.out.println("\n--- Añadiendo estudiante que va al inicio ---");
        estudiantesOrdenados.add("Alberto Díaz");
        System.out.println("Lista tras añadir Alberto Díaz: " + estudiantesOrdenados);

        // Añadimos un estudiante que va al final alfabéticamente
        System.out.println("\n--- Añadiendo estudiante que va al final ---");
        estudiantesOrdenados.add("Sofía Torres");
        System.out.println("Lista tras añadir Sofía Torres: " + estudiantesOrdenados);

        // Buscamos un estudiante por valor
        System.out.println("\n--- Buscando estudiantes ---");
        System.out.println("Buscando Ana Martínez: " + estudiantesOrdenados.get("Ana Martínez"));
        System.out.println("Buscando Roberto Ruiz: " + estudiantesOrdenados.get("Roberto Ruiz"));

        // Eliminamos un estudiante por valor
        System.out.println("\n--- Eliminando estudiante por valor ---");
        System.out.println("Eliminando Carlos García: " + estudiantesOrdenados.del("Carlos García"));
        System.out.println("Lista tras eliminar: " + estudiantesOrdenados);

        // Recorremos la lista con el iterador
        System.out.println("\n--- Recorriendo lista con iterador ---");
        Iterador<String> iterador2 = estudiantesOrdenados.getIterador();
        while (iterador2.hasNext()) {
            System.out.println("Estudiante: " + iterador2.next());
        }

        // Eliminamos estudiantes por posición
        System.out.println("\n--- Eliminando estudiantes por posición ---");
        System.out.println("Eliminando posición 0: " + estudiantesOrdenados.removeAt(0));
        System.out.println("Lista tras eliminar posición 0: " + estudiantesOrdenados);
    }
}

