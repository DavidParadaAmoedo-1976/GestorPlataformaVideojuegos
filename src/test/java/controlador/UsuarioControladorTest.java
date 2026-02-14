package controlador;

import org.DavidParada.controlador.UsuarioControlador;
import org.DavidParada.excepciones.ValidationException;
import org.DavidParada.modelo.dto.UsuarioDto;
import org.DavidParada.modelo.enums.EstadoCuentaEnum;
import org.DavidParada.modelo.enums.PaisEnum;
import org.DavidParada.modelo.formularios.UsuarioForm;
import org.DavidParada.modelo.formularios.validaciones.UsuarioFormValidador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.DavidParada.repositorio.implementacionMemoria.UsuarioRepo;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioControladorTest {

    private UsuarioControlador usuarioControlador;

    @BeforeEach
    void setUp() {
        UsuarioRepo usuarioRepo = new UsuarioRepo();
        UsuarioFormValidador.setUsuarioRepo(usuarioRepo);
        usuarioControlador = new UsuarioControlador(usuarioRepo);
    }

    @Test
    void registrarUsuarioCorrectamente() throws ValidationException {

        UsuarioForm form = new UsuarioForm(
                "usuarioTest",
                "test@email.com",
                "Password1",
                "Juan Perez",
                PaisEnum.ESPANA,
                LocalDate.of(2000,1,1),
                LocalDate.of(2000,1,1),
                null,
                0.0,
                null
        );

        UsuarioDto usuario = usuarioControlador.registrarUsuario(form);

        assertNotNull(usuario);
        assertEquals("usuarioTest", usuario.getNombreUsuario());
        assertEquals(0.0, usuario.getSaldo());
        assertEquals(EstadoCuentaEnum.ACTIVA, usuario.getEstadoCuenta());
    }

    @Test
    void noPermiteEmailDuplicado() throws ValidationException {

        UsuarioForm form = new UsuarioForm(
                "usuario1",
                "duplicado@email.com",
                "Password1",
                "Juan Perez",
                PaisEnum.ESPANA,
                LocalDate.of(2000,1,1),
                LocalDate.of(2000,1,1),
                null,
                0.0,
                null
        );

        usuarioControlador.registrarUsuario(form);

        assertThrows(ValidationException.class, () ->
                usuarioControlador.registrarUsuario(form)
        );
    }

    @Test
    void anadirSaldoCorrectamente() throws ValidationException {

        UsuarioForm form = new UsuarioForm(
                "usuarioSaldo",
                "saldo@email.com",
                "Password1",
                "Juan Perez",
                PaisEnum.ESPANA,
                LocalDate.of(2000,1,1),
                LocalDate.of(2000,1,1),
                null,
                0.0,
                null
        );

        UsuarioDto usuario = usuarioControlador.registrarUsuario(form);

        // Acción: anadir saldo (método void)
        usuarioControlador.anadirSaldo(
                usuario.getIdUsuario(),
                50.0
        );

        // Recuperar usuario actualizado
        UsuarioDto usuarioActualizado = usuarioControlador.consultarPerfil(usuario.getIdUsuario());

        assertEquals(50.0, usuarioActualizado.getSaldo());
    }


    @Test
    void noPermiteSaldoFueraDeRango() throws ValidationException {

        UsuarioForm form = new UsuarioForm(
                "usuarioRango",
                "rango@email.com",
                "Password1",
                "Juan Perez",
                PaisEnum.ESPANA,
                LocalDate.of(2000,1,1),
                LocalDate.of(2000,1,1),
                null,
                0.0,
                null
        );

        UsuarioDto usuario = usuarioControlador.registrarUsuario(form);

        assertThrows(ValidationException.class, () ->
                usuarioControlador.anadirSaldo(
                        usuario.getIdUsuario(),
                        1.0
                )
        );
    }
}

