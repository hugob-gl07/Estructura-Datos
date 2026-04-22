# Estructura de Datos — Java

Proyecto académico con implementaciones manuales de las principales estructuras de datos en Java puro, sin dependencias externas. Cada estructura está construida sobre nodos genéricos (`Elemento<T>`) y lanza excepciones propias ante operaciones inválidas.

## Estructuras implementadas

| Paquete | Estructura |
|---|---|
| `Pila` | Pila genérica (LIFO) |
| `Colas` | Cola simple y Cola de Prioridad (máx/mín) |
| `Deque` | Doble cola (inserción/extracción en ambos extremos) |
| `LSE` | Lista Simplemente Enlazada (normal y ordenada) |
| `LDE` | Lista Doblemente Enlazada (normal y ordenada) |
| `ListaCircular` | Lista Circular |
| `Arboles` | Árbol de Búsqueda Binaria, AVL y B |
| `Usuarios` | `UserService` — registro de usuarios sobre LSE |

---

## Pila genérica (`Pila<T>`)

Implementa el principio **LIFO** (Last In, First Out) mediante una cadena de nodos enlazados. El tipo `T` debe implementar `Comparable<T>`.

### API pública

| Método | Descripción |
|---|---|
| `push(T dato)` | Inserta un elemento en la cima |
| `T pop()` | Extrae y devuelve el elemento de la cima |
| `T peek()` | Consulta la cima sin extraerla |
| `boolean isEmpty()` | `true` si la pila no tiene elementos |

`pop()` y `peek()` lanzan `PilaVaciaExceptions` si la pila está vacía.

### Ejemplo de uso

```java
import Pila.Pila;

Pila<String> historial = new Pila<>();

// Navegar a varias páginas
historial.push("google.com");
historial.push("youtube.com");
historial.push("github.com");

System.out.println(historial.peek()); // "github.com"  ← cima actual

// Retroceder dos páginas
historial.pop(); // elimina "github.com"
historial.pop(); // elimina "youtube.com"

System.out.println(historial.peek()); // "google.com"
System.out.println(historial.isEmpty()); // false

historial.pop(); // elimina "google.com"
System.out.println(historial.isEmpty()); // true
```

### Manejo de errores

```java
Pila<Integer> pila = new Pila<>();
try {
    pila.pop(); // lanza PilaVaciaExceptions
} catch (Exceptions.PilaVaciaExceptions e) {
    System.out.println(e.getMessage());
}
```

---

## Compilar el proyecto

El proyecto usa IntelliJ IDEA como entorno principal. Para compilar desde la terminal con `javac`:

```bash
javac -cp src -d out/production src/Pila/Pila.java src/Elemento/Elemento.java src/Exceptions/*.java
```

## Ejecutar los tests (JUnit 5)

Los tests del módulo `Usuarios` se encuentran en `test/` y requieren el JAR incluido en `lib/`:

```bash
# Compilar tests
javac -cp "out/production:lib/junit-platform-console-standalone-1.11.4.jar" \
      -d out/test test/Usuarios/*.java

# Ejecutar
java -jar lib/junit-platform-console-standalone-1.11.4.jar \
     --class-path "out/production:out/test" \
     --select-class=Usuarios.UsuarioTest \
     --select-class=Usuarios.UserServiceTest
```

Resultado esperado: **23 tests, 0 fallados**.
