package modelo.entidades;

import java.time.LocalDate;


public class BibliotecaEntidad {


    private long idBiblioteca;
    private long idUsuario;
    private long idJuego;
    private LocalDate fechaAdquisicion;
    private int horasDeJuego;
    private LocalDate ultimaFechaDeJuego;
    private boolean estadoInstalacion;


    public BibliotecaEntidad(long idBiblioteca, long idUsuario, long idJuego, LocalDate fechaAdquisicion, int horasDeJuego, LocalDate ultimaFechaDeJuego, boolean estadoInstalacion) {
        this.idBiblioteca = idBiblioteca;
        this.idUsuario = idUsuario;
        this.idJuego = idJuego;
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

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(long idJuego) {
        this.idJuego = idJuego;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    //    public UsuarioEntidad getUsuario() {
//        return usuarioEntidad;
//    }
//
//    public void setUsuario(UsuarioEntidad usuarioEntidad) {
//        this.usuarioEntidad = usuarioEntidad;
//    }
//
//    public JuegoEntidad getJuego() {
//        return idJuego;
//    }
//
//    public void setJuego(JuegoEntidad juego) {
//        this.idJuego = juego;
//    }
//
//    public LocalDate getFechaAdquisicion() {
//        return fechaAdquisicion;
//    }

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
