package controlador;

import org.DavidParada.controlador.JuegoControlador;
import org.DavidParada.excepciones.ValidationException;
import org.DavidParada.modelo.dto.JuegoDto;
import org.DavidParada.modelo.enums.ClasificacionJuegoEnum;
import org.DavidParada.modelo.enums.EstadoJuegoEnum;
import org.DavidParada.modelo.formularios.JuegoForm;
import org.DavidParada.modelo.formularios.validaciones.JuegoFormValidador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.DavidParada.repositorio.implementacionMemoria.JuegoRepo;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class JuegoControladorTest {

    private JuegoControlador juegoControlador;

    @BeforeEach
    void setUp() {
        JuegoRepo juegoRepo = new JuegoRepo();
        JuegoFormValidador.setJuegoRepo(juegoRepo);
        juegoControlador = new JuegoControlador(juegoRepo);
    }

    @Test
    void crearJuegoCorrectamente() throws ValidationException {

        JuegoForm form = new JuegoForm(
                "Juego Test",
                "Descripcion",
                "Dev Studio",
                LocalDate.of(2020,1,1),
                49.99,
                0,
                "Accion",
                ClasificacionJuegoEnum.PEGI_18,
                new String[]{"Español"},
                EstadoJuegoEnum.DISPONIBLE
        );

        JuegoDto juego = juegoControlador.crearJuego(form);

        assertNotNull(juego);
        assertEquals("Juego Test", juego.getTitulo());
    }

//    @Test
//    void aplicarDescuentoCorrectamente() throws ValidationException {
//
//        JuegoForm form = new JuegoForm(
//                "Juego Descuento",
//                "Descripcion",
//                "Dev Studio",
//                LocalDate.of(2020,1,1),
//                100.0,
//                0,
//                "Accion",
//                ClasificacionJuegoEnum.PEGI_18,
//                new String[]{"Español"},
//                EstadoJuegoEnum.DISPONIBLE
//        );
//
//        JuegoDto juego = juegoControlador.crearJuego(form);
//
//        JuegoDto actualizado = juegoControlador.aplicarDescuento(
//                juego.getIdJuego(),
//                20
//        );
//
//        assertEquals(20, actualizado.getDescuento());
//    }
}

