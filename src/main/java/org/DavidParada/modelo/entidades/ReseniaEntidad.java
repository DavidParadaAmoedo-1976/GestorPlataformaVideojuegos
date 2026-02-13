package org.DavidParada.modelo.entidades;

import java.time.LocalDate;

public class ReseniaEntidad {
    private Long idReseña;
    private UsuarioEntidad usuarioEntidad;
    private JuegoEntidad juego;
    private boolean recomendado;
    private String textoReseña;
    private Integer cantidadHorasJugadas;
    private LocalDate fechaPublicacion;
    private Integer estadoPublicacion;

    public ReseniaEntidad(Long idReseña, UsuarioEntidad usuarioEntidad, JuegoEntidad juego, boolean recomendado, String textoReseña, Integer cantidadHorasJugadas, LocalDate fechaPublicacion, Integer estadoPublicacion) {
        this.idReseña = idReseña;
        this.usuarioEntidad = usuarioEntidad;
        this.juego = juego;
        this.recomendado = recomendado;
        this.textoReseña = textoReseña;
        this.cantidadHorasJugadas = cantidadHorasJugadas;
        this.fechaPublicacion = fechaPublicacion;
        this.estadoPublicacion = estadoPublicacion;
    }

    public Long getIdReseña() {
        return idReseña;
    }

    public void setIdReseña(Long idReseña) {
        this.idReseña = idReseña;
    }

    public UsuarioEntidad getUsuario() {
        return usuarioEntidad;
    }

    public void setUsuario(UsuarioEntidad usuarioEntidad) {
        this.usuarioEntidad = usuarioEntidad;
    }

    public JuegoEntidad getJuego() {
        return juego;
    }

    public void setJuego(JuegoEntidad juego) {
        this.juego = juego;
    }

    public boolean isRecomendado() {
        return recomendado;
    }

    public void setRecomendado(boolean recomendado) {
        this.recomendado = recomendado;
    }

    public String getTextoReseña() {
        return textoReseña;
    }

    public void setTextoReseña(String textoReseña) {
        this.textoReseña = textoReseña;
    }

    public Integer getCantidadHorasJugadas() {
        return cantidadHorasJugadas;
    }

    public void setCantidadHorasJugadas(Integer cantidadHorasJugadas) {
        this.cantidadHorasJugadas = cantidadHorasJugadas;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(Integer estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }
}
