package ListaCircular.Basado_en_LDE;

public class TestListaCircular {
    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE TURNOS DE JUGADORES ===\n");

        ListaCircularDE<String> jugadores = new ListaCircularDE<>();

        // -------------------------------------------------------
        // Añadimos jugadores a la partida
        // -------------------------------------------------------
        System.out.println("--- Añadiendo jugadores ---");
        jugadores.add("Alice");
        jugadores.add("Bob");
        jugadores.add("Carlos");
        jugadores.add("Diana");
        jugadores.add("Elena");
        System.out.println(jugadores.mostrarLista());
        System.out.println("Número de jugadores: " + jugadores.getSize());

        // -------------------------------------------------------
        // Consultamos jugadores por posición
        // -------------------------------------------------------
        System.out.println("\n--- Consultando jugadores por posición ---");
        System.out.println("Jugador en posición 0: " + jugadores.obtenerPorPosicion(0));
        System.out.println("Jugador en posición 2: " + jugadores.obtenerPorPosicion(2));
        System.out.println("Jugador en posición 10: " + jugadores.obtenerPorPosicion(10));

        // -------------------------------------------------------
        // Comprobamos si un jugador existe
        // -------------------------------------------------------
        System.out.println("\n--- Comprobando jugadores ---");
        System.out.println("¿Existe Alice? " + jugadores.existe("Alice"));
        System.out.println("¿Existe Pedro? " + jugadores.existe("Pedro"));

        // -------------------------------------------------------
        // Buscamos un jugador por valor
        // -------------------------------------------------------
        System.out.println("\n--- Buscando jugadores ---");
        System.out.println("Buscando Bob: " + jugadores.get("Bob"));
        System.out.println("Buscando Pedro: " + jugadores.get("Pedro"));

        // -------------------------------------------------------
        // Simulamos una ronda de turnos con el iterador
        // -------------------------------------------------------
        System.out.println("\n--- Simulando ronda de turnos ---");
        MiIterador<String> iterador = jugadores.getIterador();
        while (iterador.hasNext()) {
            System.out.println("Turno de: " + iterador.next());
        }

        // -------------------------------------------------------
        // Un jugador abandona la partida
        // -------------------------------------------------------
        System.out.println("\n--- Jugador abandona la partida ---");
        System.out.println("Carlos abandona: " + jugadores.del("Carlos"));
        System.out.println(jugadores.mostrarLista());

        // -------------------------------------------------------
        // Cambiamos el nombre de un jugador por posición
        // -------------------------------------------------------
        System.out.println("\n--- Cambiando nombre de jugador en posición 1 ---");
        jugadores.cambiarEnPosicion(1, "Roberto");
        System.out.println(jugadores.mostrarLista());

        // -------------------------------------------------------
        // Simulamos otra ronda de turnos tras los cambios
        // -------------------------------------------------------
        System.out.println("\n--- Segunda ronda de turnos ---");
        MiIterador<String> iterador2 = jugadores.getIterador();
        while (iterador2.hasNext()) {
            System.out.println("Turno de: " + iterador2.next());
        }

        // -------------------------------------------------------
        // Vaciamos la lista al terminar la partida
        // -------------------------------------------------------
        System.out.println("\n--- Terminando partida ---");
        jugadores.vaciar();
        System.out.println("¿Lista vacía? " + jugadores.isEmpty());
    }
}

