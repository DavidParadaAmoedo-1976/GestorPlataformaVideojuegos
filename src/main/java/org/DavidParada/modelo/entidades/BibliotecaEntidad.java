package org.DavidParada.modelo.entidades;

import java.time.LocalDate;


public class BibliotecaEntidad {

    private Long idBiblioteca;
    private Long idUsuario;
    private Long idJuego;
    private LocalDate fechaAdquisicion;
    private Integer horasDeJuego;
    private LocalDate ultimaFechaDeJuego;
    private boolean estadoInstalacion;

    public BibliotecaEntidad(Long idBiblioteca,
                             Long idUsuario,
                             Long idJuego,
                             LocalDate fechaAdquisicion,
                             Integer horasDeJuego,
                             LocalDate ultimaFechaDeJuego,
                             boolean estadoInstalacion) {

        this.idBiblioteca = idBiblioteca;
        this.idUsuario = idUsuario;
        this.idJuego = idJuego;
        this.fechaAdquisicion = fechaAdquisicion;
        this.horasDeJuego = horasDeJuego;
        this.ultimaFechaDeJuego = ultimaFechaDeJuego;
        this.estadoInstalacion = estadoInstalacion;
    }
    public Long getIdBiblioteca() {
        return idBiblioteca;
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

    public Integer getHorasDeJuego() {
        return horasDeJuego;
    }

    public LocalDate getUltimaFechaDeJuego() {
        return ultimaFechaDeJuego;
    }

    public boolean isEstadoInstalacion() {
        return estadoInstalacion;
    }
}
