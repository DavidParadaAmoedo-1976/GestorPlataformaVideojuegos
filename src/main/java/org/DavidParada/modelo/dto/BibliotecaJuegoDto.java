package org.DavidParada.modelo.dto;

import java.time.LocalDate;

public record BibliotecaJuegoDto(String titulo,
                                 LocalDate fechaAdquisicion,
                                 Double horasDeJuego,
                                 LocalDate ultimaFechaDeJuego,
                                 boolean estadoInstalacion) {


}
