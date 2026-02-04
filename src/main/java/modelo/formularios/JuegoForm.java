package modelo.formularios;

import java.time.LocalDate;

public class JuegoForm {
    private long idJuego;
    private int titulo;
    private String descripcion;
    private String desarrollador;
    private LocalDate fechaLanzamiento;
    private double precioBase;
    private int descuento;
    private String categoria;
    private int clasificacionPorEdad;
    private String[] idiomas;
    private int estado;

    public JuegoForm(long idJuego, int titulo, String descripcion, String desarrollador, LocalDate fechaLanzamiento, double precioBase, int descuento, String categoria, int clasificacionPorEdad, String[] idiomas, int estado) {
        this.idJuego = idJuego;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.desarrollador = desarrollador;
        this.fechaLanzamiento = fechaLanzamiento;
        this.precioBase = precioBase;
        this.descuento = descuento;
        this.categoria = categoria;
        this.clasificacionPorEdad = clasificacionPorEdad;
        this.idiomas = idiomas;
        this.estado = estado;
    }

    public long getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(long idJuego) {
        this.idJuego = idJuego;
    }

    public int getTitulo() {
        return titulo;
    }

    public void setTitulo(int titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getClasificacionPorEdad() {
        return clasificacionPorEdad;
    }

    public void setClasificacionPorEdad(int clasificacionPorEdad) {
        this.clasificacionPorEdad = clasificacionPorEdad;
    }

    public String[] getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String[] idiomas) {
        this.idiomas = idiomas;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
