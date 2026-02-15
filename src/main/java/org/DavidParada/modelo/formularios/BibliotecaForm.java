package org.DavidParada.modelo.formularios;

import java.time.LocalDate;

public class BibliotecaForm {
    private final Long idUsuario;
    private final Long idJuego;
    private final LocalDate fechaAdquisicion;
    private final Double horasDeJuego;
    private final LocalDate ultimaFechaDeJuego;
    private final boolean estadoInstalacion;

    public BibliotecaForm(Long idUsuario,
                          Long idJuego,
                          LocalDate fechaAdquisicion,
                          Double horasDeJuego,
                          LocalDate ultimaFechaDeJuego,
                          boolean estadoInstalacion) {

        this.idUsuario = idUsuario;
        this.idJuego = idJuego;
        this.fechaAdquisicion = fechaAdquisicion;
        this.horasDeJuego = horasDeJuego;
        this.ultimaFechaDeJuego = ultimaFechaDeJuego;
        this.estadoInstalacion = estadoInstalacion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Long getIdJuego() {
        return idJuego;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public Double getHorasDeJuego() {
        return horasDeJuego;
    }

    public LocalDate getUltimaFechaDeJuego() {
        return ultimaFechaDeJuego;
    }

    public boolean isEstadoInstalacion() {
        return estadoInstalacion;
    }
}



