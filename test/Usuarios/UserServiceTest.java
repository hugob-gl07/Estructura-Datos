package Usuarios;

import Exceptions.UsuarioNoEncontradoException;
import Exceptions.UsuarioYaExisteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService servicio;

    @BeforeEach
    void setUp() {
        servicio = new UserService(); // instancia limpia para cada test
    }

    // ── Estado inicial ────────────────────────────────────────────────────────

    @Test
    void nuevoServicio_estaVacio() {
        assertTrue(servicio.estaVacio());
        assertEquals(0, servicio.getTotalUsuarios());
    }

    // ── registrar ─────────────────────────────────────────────────────────────

    @Test
    void registrar_usuarioNuevo_retornaUsuarioConDatosCorrectos() {
        Usuario u = servicio.registrar("Hugo", "hugo@test.com", "clave");

        assertEquals("Hugo", u.getNombre());
        assertEquals("hugo@test.com", u.getEmail());
    }

    @Test
    void registrar_usuarioNuevo_incrementaContador() {
        servicio.registrar("Hugo", "hugo@test.com", "clave");
        servicio.registrar("Ana", "ana@test.com", "clave2");

        assertEquals(2, servicio.getTotalUsuarios());
        assertFalse(servicio.estaVacio());
    }

    @Test
    void registrar_emailDuplicadoExacto_lanzaUsuarioYaExisteException() {
        servicio.registrar("Hugo", "hugo@test.com", "clave");

        assertThrows(UsuarioYaExisteException.class, () ->
            servicio.registrar("Otro", "hugo@test.com", "otraClave")
        );
    }

    @Test
    void registrar_emailDuplicadoCaseInsensitive_lanzaUsuarioYaExisteException() {
        servicio.registrar("Hugo", "hugo@test.com", "clave");

        assertThrows(UsuarioYaExisteException.class, () ->
            servicio.registrar("Otro", "HUGO@TEST.COM", "otraClave")
        );
    }

    @Test
    void registrar_emailDuplicado_noIncrementaContador() {
        servicio.registrar("Hugo", "hugo@test.com", "clave");
        try { servicio.registrar("Otro", "hugo@test.com", "otraClave"); } catch (UsuarioYaExisteException ignored) {}

        assertEquals(1, servicio.getTotalUsuarios());
    }

    @Test
    void registrar_nombreVacio_lanzaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () ->
            servicio.registrar("", "email@test.com", "clave")
        );
    }

    @Test
    void registrar_emailVacio_lanzaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () ->
            servicio.registrar("Hugo", "", "clave")
        );
    }

    @Test
    void registrar_contrasennaVacia_lanzaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () ->
            servicio.registrar("Hugo", "hugo@test.com", "")
        );
    }

    @Test
    void registrar_campoNulo_lanzaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () ->
            servicio.registrar(null, "hugo@test.com", "clave")
        );
        assertThrows(IllegalArgumentException.class, () ->
            servicio.registrar("Hugo", null, "clave")
        );
        assertThrows(IllegalArgumentException.class, () ->
            servicio.registrar("Hugo", "hugo@test.com", null)
        );
    }

    // ── buscar ────────────────────────────────────────────────────────────────

    @Test
    void buscar_usuarioExistente_retornaUsuarioCorrecto() {
        servicio.registrar("Hugo", "hugo@test.com", "clave");
        Usuario encontrado = servicio.buscar("hugo@test.com");

        assertEquals("hugo@test.com", encontrado.getEmail());
        assertEquals("Hugo", encontrado.getNombre());
    }

    @Test
    void buscar_emailCaseInsensitive_retornaUsuario() {
        servicio.registrar("Hugo", "hugo@test.com", "clave");
        Usuario encontrado = servicio.buscar("HUGO@TEST.COM");

        assertNotNull(encontrado);
    }

    @Test
    void buscar_usuarioNoExistente_lanzaUsuarioNoEncontradoException() {
        assertThrows(UsuarioNoEncontradoException.class, () ->
            servicio.buscar("noexiste@test.com")
        );
    }

    @Test
    void buscar_emailNulo_lanzaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () ->
            servicio.buscar(null)
        );
    }

    // ── eliminar ──────────────────────────────────────────────────────────────

    @Test
    void eliminar_usuarioExistente_retornaUsuarioYDecrementaContador() {
        servicio.registrar("Hugo", "hugo@test.com", "clave");
        Usuario eliminado = servicio.eliminar("hugo@test.com");

        assertEquals("hugo@test.com", eliminado.getEmail());
        assertEquals(0, servicio.getTotalUsuarios());
        assertTrue(servicio.estaVacio());
    }

    @Test
    void eliminar_usuarioNoExistente_lanzaUsuarioNoEncontradoException() {
        assertThrows(UsuarioNoEncontradoException.class, () ->
            servicio.eliminar("fantasma@test.com")
        );
    }
}
