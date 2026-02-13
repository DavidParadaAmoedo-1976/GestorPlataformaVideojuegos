package controlador;

import excepciones.ValidationException;
import modelo.dto.UsuarioDto;
import modelo.enums.EstadoCuentaEnum;
import modelo.enums.PaisEnum;
import modelo.formularios.UsuarioForm;
import modelo.formularios.validaciones.UsuarioFormValidador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositorio.implementacionMemoria.UsuarioRepo;

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
    void añadirSaldoCorrectamente() throws ValidationException {

        UsuarioForm form = new UsuarioForm(
                "usuarioSaldo",
                "saldo@email.com",
                "Password1",
                "Juan Perez",
                PaisEnum.ESPANA,
                LocalDate.of(2000,1,1),
                null,
                0.0,
                null
        );

        UsuarioDto usuario = usuarioControlador.registrarUsuario(form);

        Double nuevoSaldo = usuarioControlador.anadirSaldo(
                usuario.getIdUsuario(),
                50.0
        );

        assertEquals(50.0, nuevoSaldo);
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

