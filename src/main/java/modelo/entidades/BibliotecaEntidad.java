package modelo.entidades;

import java.time.LocalDate;


public class BibliotecaEntidad {
    private final UsuarioEntidad usuario = new UsuarioEntidad();
    private final JuegoEntidad juego = new JuegoEntidad();

    private Long idBiblioteca;
    private Long idUsuario;
    private Long idJuego;
    private LocalDate fechaAdquisicion;
    private Integer horasDeJuego;
    private LocalDate ultimaFechaDeJuego;
    private boolean estadoInstalacion;


    public BibliotecaEntidad(Long idBiblioteca, Long idUsuario, Long idJuego, LocalDate fechaAdquisicion, Integer horasDeJuego, LocalDate ultimaFechaDeJuego, boolean estadoInstalacion) {
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

    public void setIdBiblioteca(Long idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public Long getUsuario() {
        return idUsuario;
    }

    public void setUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getJuego() {
        return idJuego;
    }

    public void setJuego(Long juego) {
        this.idJuego = juego;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Integer getHorasDeJuego() {
        return horasDeJuego;
    }

    public void setHorasDeJuego(Integer horasDeJuego) {
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
