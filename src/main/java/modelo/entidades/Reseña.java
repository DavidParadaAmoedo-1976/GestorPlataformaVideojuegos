package modelo.entidades;

import modelo.enums.EstadoPublicacionEnum;

import java.time.LocalDate;

public class Reseña {
    private long idReseña;
    private Usuario usuario;
    private Juego juego;
    private boolean recomendado;
    private String textoReseña;
    private int cantidadHorasJugadas;
    private LocalDate fechaPublicacion;
    private EstadoPublicacionEnum estadoPublicacion;

    public Reseña(long idReseña, Usuario usuario, Juego juego, boolean recomendado, String textoReseña, int cantidadHorasJugadas, LocalDate fechaPublicacion, EstadoPublicacionEnum estadoPublicacion) {
        this.idReseña = idReseña;
        this.usuario = usuario;
        this.juego = juego;
        this.recomendado = recomendado;
        this.textoReseña = textoReseña;
        this.cantidadHorasJugadas = cantidadHorasJugadas;
        this.fechaPublicacion = fechaPublicacion;
        this.estadoPublicacion = estadoPublicacion;
    }

    public long getIdReseña() {
        return idReseña;
    }

    public void setIdReseña(long idReseña) {
        this.idReseña = idReseña;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
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

    public int getCantidadHorasJugadas() {
        return cantidadHorasJugadas;
    }

    public void setCantidadHorasJugadas(int cantidadHorasJugadas) {
        this.cantidadHorasJugadas = cantidadHorasJugadas;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public EstadoPublicacionEnum getEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(EstadoPublicacionEnum estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }
}
