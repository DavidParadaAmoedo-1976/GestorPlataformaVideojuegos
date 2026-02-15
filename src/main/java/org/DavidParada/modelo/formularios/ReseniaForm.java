package org.DavidParada.modelo.formularios;

import org.DavidParada.modelo.entidades.JuegoEntidad;
import org.DavidParada.modelo.entidades.UsuarioEntidad;

import java.time.LocalDate;

public class ReseniaForm {

    private final UsuarioEntidad usuarioEntidad;
    private final JuegoEntidad juego;
    private final boolean recomendado;
    private final String textoResena;
    private final Integer cantidadHorasJugadas;
    private final LocalDate fechaPublicacion;
    private final Integer estadoPublicacion;

    public ReseniaForm(UsuarioEntidad usuarioEntidad,
                       JuegoEntidad juego,
                       boolean recomendado,
                       String textoResena,
                       Integer cantidadHorasJugadas,
                       LocalDate fechaPublicacion,
                       Integer estadoPublicacion) {

        this.usuarioEntidad = usuarioEntidad;
        this.juego = juego;
        this.recomendado = recomendado;
        this.textoResena = textoResena;
        this.cantidadHorasJugadas = cantidadHorasJugadas;
        this.fechaPublicacion = fechaPublicacion;
        this.estadoPublicacion = estadoPublicacion;
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

