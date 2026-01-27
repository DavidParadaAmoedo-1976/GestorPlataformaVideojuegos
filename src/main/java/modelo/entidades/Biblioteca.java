package modelo.entidades;

import java.time.LocalDate;

public class Biblioteca {
    private long idBiblioteca;
    private Usuario usuario;
    private Juego juego;
    private LocalDate fechaAdquisicion;
    private int horasDeJuego;
    private LocalDate ultimaFechaDeJuego;
    private boolean estadoInstalacion;

    public Biblioteca(long idBiblioteca, Usuario usuario, Juego juego, LocalDate fechaAdquisicion, int horasDeJuego, LocalDate ultimaFechaDeJuego, boolean estadoInstalacion) {
        this.idBiblioteca = idBiblioteca;
        this.usuario = usuario;
        this.juego = juego;
        this.fechaAdquisicion = fechaAdquisicion;
        this.horasDeJuego = horasDeJuego;
        this.ultimaFechaDeJuego = ultimaFechaDeJuego;
        this.estadoInstalacion = estadoInstalacion;
    }

    public long getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(long idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
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

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public int getHorasDeJuego() {
        return horasDeJuego;
    }

    public void setHorasDeJuego(int horasDeJuego) {
        this.horasDeJuego = horasDeJuego;
    }

    public LocalDate getUltimaFechaDeJuego() {
        return ultimaFechaDeJuego;
    }

    public void setUltimaFechaDeJuego(LocalDate ultimaFechaDeJuego) {
        this.ultimaFechaDeJuego = ultimaFechaDeJuego;
    }

    public boolean isEstadoInstalacion() {
        return estadoInstalacion;
    }

    public void setEstadoInstalacion(boolean estadoInstalacion) {
        this.estadoInstalacion = estadoInstalacion;
    }
}
