package org.DavidParada.modelo.entidades;

import java.time.LocalDate;

public class ReseniaEntidad {
    private final Long idResena;
    private final UsuarioEntidad usuarioEntidad;
    private final JuegoEntidad juego;
    private final boolean recomendado;
    private final String textoResena;
    private final Integer cantidadHorasJugadas;
    private final LocalDate fechaPublicacion;
    private final Integer estadoPublicacion;

    public ReseniaEntidad(Long idResena,
                          UsuarioEntidad usuarioEntidad,
                          JuegoEntidad juego,
                          boolean recomendado,
                          String textoResena,
                          Integer cantidadHorasJugadas,
                          LocalDate fechaPublicacion,
                          Integer estadoPublicacion) {

        this.idResena = idResena;
        this.usuarioEntidad = usuarioEntidad;
        this.juego = juego;
        this.recomendado = recomendado;
        this.textoResena = textoResena;
        this.cantidadHorasJugadas = cantidadHorasJugadas;
        this.fechaPublicacion = fechaPublicacion;
        this.estadoPublicacion = estadoPublicacion;
    }

    public Long getIdResena() {
        return idResena;
    }

    public UsuarioEntidad getUsuario() {
        return usuarioEntidad;
    }

    public JuegoEntidad getJuego() {
        return juego;
    }

    public boolean isRecomendado() {
        return recomendado;
    }

    public String getTextoResena() {
        return textoResena;
    }

    public Integer getCantidadHorasJugadas() {
        return cantidadHorasJugadas;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public Integer getEstadoPublicacion() {
        return estadoPublicacion;
    }
}
