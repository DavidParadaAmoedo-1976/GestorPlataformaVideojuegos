package modelo.maper;

import modelo.dto.BibliotecaDto;

import modelo.entidades.BibliotecaEntidad;

public class BibliotecaMaper {

    public BibliotecaMaper() {
    }

    public static BibliotecaDto entidadADto(BibliotecaEntidad biblioteca) {

        if (biblioteca == null) return null;

        return new BibliotecaDto(
                biblioteca.getIdBiblioteca(),
                biblioteca.getUsuario(),
                biblioteca.getJuego(),
                biblioteca.getFechaAdquisicion(),
                biblioteca.getHorasDeJuego(),
                biblioteca.getUltimaFechaDeJuego(),
                biblioteca.isEstadoInstalacion()
        );
    }
}
