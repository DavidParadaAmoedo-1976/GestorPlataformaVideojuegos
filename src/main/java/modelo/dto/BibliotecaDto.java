package modelo.dto;

import modelo.entidades.JuegoEntidad;
import modelo.entidades.UsuarioEntidad;

import java.time.LocalDate;

public class BibliotecaDto {
    private long idBiblioteca;
    private UsuarioEntidad usuarioEntidad;
    private JuegoEntidad juego;
    private LocalDate fechaAdquisicion;
    private int horasDeJuego;
    private LocalDate ultimaFechaDeJuego;
    private boolean estadoInstalacion;

    public BibliotecaDto(long idBiblioteca, UsuarioEntidad usuarioEntidad, JuegoEntidad juego, LocalDate fechaAdquisicion, int horasDeJuego, LocalDate ultimaFechaDeJuego, boolean estadoInstalacion) {
        this.idBiblioteca = idBiblioteca;
        this.usuarioEntidad = usuarioEntidad;
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

