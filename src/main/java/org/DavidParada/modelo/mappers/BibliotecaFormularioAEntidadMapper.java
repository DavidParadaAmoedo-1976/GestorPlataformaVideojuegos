package org.DavidParada.modelo.mappers;

import org.DavidParada.modelo.entidades.BibliotecaEntidad;
import org.DavidParada.modelo.formularios.BibliotecaForm;

import java.time.LocalDate;

public class BibliotecaFormularioAEntidadMapper {

    private BibliotecaFormularioAEntidadMapper() {
    }

    public static BibliotecaEntidad crearEntidad(Long id, BibliotecaForm form) {

        return new BibliotecaEntidad(
                id,
                form.getIdUsuario(),
                form.getIdJuego(),
                LocalDate.now(),     // FechaAdquisicion automática
                0,                   // HorasDeJuego inicial
                null,                // "ultimaFechaDeJuego" -> aún no ha jugado
                false                // No instalado por defecto
        );
    }
}
