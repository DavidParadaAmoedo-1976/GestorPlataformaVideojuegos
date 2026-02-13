package org.DavidParada.modelo.dto;

import org.DavidParada.modelo.enums.ClasificacionJuegoEnum;
import org.DavidParada.modelo.enums.EstadoJuegoEnum;

import java.time.LocalDate;

public class JuegoDto {
    private Long idJuego;
    private String titulo;
    private String descripcion;
    private String desarrollador;
    private LocalDate fechaLanzamiento;
    private Double precioBase;
    private Integer descuento;
    private String categoria;
    private ClasificacionJuegoEnum clasificacionPorEdad;
    private String[] idiomas;
    private EstadoJuegoEnum estado;

    public JuegoDto(Long idJuego, String titulo, String descripcion, String desarrollador, LocalDate fechaLanzamiento, Double precioBase, Integer descuento, String categoria, ClasificacionJuegoEnum clasificacionPorEdad, String[] idiomas, EstadoJuegoEnum estado) {
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

    public Long getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Long idJuego) {
        this.idJuego = idJuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
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

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ClasificacionJuegoEnum getClasificacionPorEdad() {
        return clasificacionPorEdad;
    }

    public void setClasificacionPorEdad(ClasificacionJuegoEnum clasificacionPorEdad) {
        this.clasificacionPorEdad = clasificacionPorEdad;
    }

    public String[] getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String[] idiomas) {
        this.idiomas = idiomas;
    }

    public EstadoJuegoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoJuegoEnum estado) {
        this.estado = estado;
    }
}