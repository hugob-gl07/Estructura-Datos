package LDE;

public class TestListaDoblementeEnlazada {
    public static void main(String[] args) {

        System.out.println("=== LISTA DE REPRODUCCIÓN MUSICAL ===\n");

        // -------------------------------------------------------
        // TEST LISTA DOBLEMENTE ENLAZADA
        // Las canciones se guardan en orden de inserción
        // -------------------------------------------------------
        System.out.println("--- LISTA DE REPRODUCCIÓN NORMAL (orden de inserción) ---");
        ListaDoblementeEnlazada<String> playlist = new ListaDoblementeEnlazada<>();

        // Añadimos canciones al final de la lista
        System.out.println("Añadiendo canciones...");
        playlist.add("Bohemian Rhapsody");
        playlist.add("Stairway to Heaven");
        playlist.add("Hotel California");
        playlist.add("Imagine");
        playlist.add("Smells Like Teen Spirit");
        System.out.println("Playlist actual: " + playlist);
        System.out.println("Número de canciones: " + playlist.getSize());

        // Consultamos la primera y última canción
        System.out.println("\n--- Consultando canciones ---");
        System.out.println("Primera canción: " + playlist.getFirst());
        System.out.println("Última canción: " + playlist.getLast());

        // Añadimos una canción al inicio
        System.out.println("\n--- Añadiendo canción al inicio ---");
        playlist.addFirst("Back in Black");
        System.out.println("Playlist tras añadir al inicio: " + playlist);

        // Obtenemos una canción por posición
        System.out.println("\n--- Obteniendo canciones por posición ---");
        System.out.println("Canción en posición 0: " + playlist.getAt(0));
        System.out.println("Canción en posición 3: " + playlist.getAt(3));

        // Insertamos una canción en una posición concreta
        System.out.println("\n--- Insertando canción en posición 2 ---");
        playlist.insertAt(2, "Purple Haze");
        System.out.println("Playlist tras insertar en posición 2: " + playlist);

        // Buscamos una canción por valor
        System.out.println("\n--- Buscando canciones ---");
        System.out.println("Buscando Imagine: " + playlist.get("Imagine"));
        System.out.println("Buscando Thriller: " + playlist.get("Thriller"));

        // Eliminamos una canción por valor
        System.out.println("\n--- Eliminando canción por valor ---");
        System.out.println("Eliminando Hotel California: " + playlist.del("Hotel California"));
        System.out.println("Playlist tras eliminar: " + playlist);

        // Eliminamos canciones por posición
        System.out.println("\n--- Eliminando canciones por posición ---");
        System.out.println("Eliminando posición 0: " + playlist.removeAt(0));
        System.out.println("Playlist tras eliminar posición 0: " + playlist);

        // Eliminamos la primera y última canción
        System.out.println("\n--- Eliminando primera y última canción ---");
        System.out.println("Eliminando primera canción: " + playlist.removeFirst());
        System.out.println("Eliminando última canción: " + playlist.removeLast());
        System.out.println("Playlist tras eliminar primera y última: " + playlist);

        // Vaciamos la playlist
        System.out.println("\n--- Vaciando playlist ---");
        playlist.clear();
        System.out.println("¿Playlist vacía? " + playlist.isEmpty());

        // -------------------------------------------------------
        // TEST LISTA DOBLEMENTE ENLAZADA ORDENADA
        // Las canciones se guardan en orden alfabético
        // -------------------------------------------------------
        System.out.println("\n--- LISTA DE REPRODUCCIÓN ORDENADA (orden alfabético) ---");
        LDEOrdenada<String> playlistOrdenada = new LDEOrdenada<>();

        // Añadimos canciones en desorden
        System.out.println("Añadiendo canciones en desorden...");
        playlistOrdenada.add("Stairway to Heaven");
        playlistOrdenada.add("Bohemian Rhapsody");
        playlistOrdenada.add("Imagine");
        playlistOrdenada.add("Hotel California");
        playlistOrdenada.add("Smells Like Teen Spirit");
        System.out.println("Playlist ordenada: " + playlistOrdenada);
        System.out.println("Número de canciones: " + playlistOrdenada.getSize());

        // Consultamos la primera y última canción
        System.out.println("\n--- Consultando canciones ---");
        System.out.println("Primera canción (alfabéticamente): " + playlistOrdenada.getFirst());
        System.out.println("Última canción (alfabéticamente): " + playlistOrdenada.getLast());

        // Añadimos una canción que va al inicio alfabéticamente
        System.out.println("\n--- Añadiendo canción que va al inicio ---");
        playlistOrdenada.add("Angie");
        System.out.println("Playlist tras añadir Angie: " + playlistOrdenada);

        // Añadimos una canción que va al final alfabéticamente
        System.out.println("\n--- Añadiendo canción que va al final ---");
        playlistOrdenada.add("Yesterday");
        System.out.println("Playlist tras añadir Yesterday: " + playlistOrdenada);

        // Buscamos una canción por valor
        System.out.println("\n--- Buscando canciones ---");
        System.out.println("Buscando Imagine: " + playlistOrdenada.get("Imagine"));
        System.out.println("Buscando Thriller: " + playlistOrdenada.get("Thriller"));

        // Eliminamos una canción por valor
        System.out.println("\n--- Eliminando canción por valor ---");
        System.out.println("Eliminando Bohemian Rhapsody: " + playlistOrdenada.del("Bohemian Rhapsody"));
        System.out.println("Playlist tras eliminar: " + playlistOrdenada);

        // Eliminamos la primera y última canción
        System.out.println("\n--- Eliminando primera y última canción ---");
        System.out.println("Eliminando primera canción: " + playlistOrdenada.removeFirst());
        System.out.println("Eliminando última canción: " + playlistOrdenada.removeLast());
        System.out.println("Playlist tras eliminar primera y última: " + playlistOrdenada);

        // Vaciamos la playlist
        System.out.println("\n--- Vaciando playlist ---");
        playlistOrdenada.clear();
        System.out.println("¿Playlist vacía? " + playlistOrdenada.isEmpty());
    }
}