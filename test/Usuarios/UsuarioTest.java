package Usuarios;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    // ── Constructor ───────────────────────────────────────────────────────────

    @Test
    void constructor_creaUsuarioConDatosCorrectos() {
        Usuario u = new Usuario("Hugo", "hugo@test.com", "clave123");

        assertEquals("Hugo", u.getNombre());
        assertEquals("hugo@test.com", u.getEmail());
        assertNotNull(u.getFechaRegistro());
    }

    // ── verificarContrasenna ──────────────────────────────────────────────────

    @Test
    void verificarContrasenna_contrasennaCorrecta_devuelveTrue() {
        Usuario u = new Usuario("Ana", "ana@test.com", "miClave");
        assertTrue(u.verificarContrasenna("miClave"));
    }

    @Test
    void verificarContrasenna_contrasennaIncorrecta_devuelveFalse() {
        Usuario u = new Usuario("Ana", "ana@test.com", "miClave");
        assertFalse(u.verificarContrasenna("otraClave"));
    }

    @Test
    void verificarContrasenna_contrasennaVacia_devuelveFalse() {
        Usuario u = new Usuario("Ana", "ana@test.com", "miClave");
        assertFalse(u.verificarContrasenna(""));
    }

    // ── compareTo ────────────────────────────────────────────────────────────

    @Test
    void compareTo_emailIgual_devuelveCero() {
        Usuario u1 = new Usuario("A", "a@test.com", "x");
        Usuario u2 = new Usuario("B", "a@test.com", "y");
        assertEquals(0, u1.compareTo(u2));
    }

    @Test
    void compareTo_emailMenor_devuelveNegativo() {
        Usuario u1 = new Usuario("A", "a@test.com", "x");
        Usuario u2 = new Usuario("B", "z@test.com", "y");
        assertTrue(u1.compareTo(u2) < 0);
    }

    @Test
    void compareTo_emailMayor_devuelvePositivo() {
        Usuario u1 = new Usuario("A", "z@test.com", "x");
        Usuario u2 = new Usuario("B", "a@test.com", "y");
        assertTrue(u1.compareTo(u2) > 0);
    }
}
