package modelo.mappers;

import modelo.dto.BibliotecaDto;
import modelo.entidades.BibliotecaEntidad;

public class BibliotecaEntidadADtoMapper {

    public BibliotecaEntidadADtoMapper() {
    }

    public static BibliotecaDto entidadADto(BibliotecaEntidad biblioteca) {

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
