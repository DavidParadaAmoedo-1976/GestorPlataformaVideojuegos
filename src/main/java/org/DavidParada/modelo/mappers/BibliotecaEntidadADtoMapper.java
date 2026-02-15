package org.DavidParada.modelo.mappers;

import org.DavidParada.modelo.dto.BibliotecaDto;
import org.DavidParada.modelo.entidades.BibliotecaEntidad;

public class BibliotecaEntidadADtoMapper {

    public BibliotecaEntidadADtoMapper() {
    }

    public static BibliotecaDto bibliotecaEntidadADto(BibliotecaEntidad biblioteca) {

        if (biblioteca == null) return null;

        return new BibliotecaDto(
                biblioteca.getIdBiblioteca(),
                biblioteca.getIdUsuario(),
                biblioteca.getIdJuego(),
                biblioteca.getFechaAdquisicion(),
                biblioteca.getHorasDeJuego(),
                biblioteca.getUltimaFechaDeJuego(),
                biblioteca.isEstadoInstalacion()
        );
    }
}
