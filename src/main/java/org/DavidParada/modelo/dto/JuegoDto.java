package org.DavidParada.modelo.dto;

import org.DavidParada.modelo.enums.ClasificacionJuegoEnum;
import org.DavidParada.modelo.enums.EstadoJuegoEnum;

import java.time.LocalDate;

public class JuegoDto {
    private final Long idJuego;
    private final String titulo;
    private final String descripcion;
    private final String desarrollador;
    private final LocalDate fechaLanzamiento;
    private final Double precioBase;
    private final Integer descuento;
    private final String categoria;
    private final ClasificacionJuegoEnum clasificacionPorEdad;
    private final String[] idiomas;
    private final EstadoJuegoEnum estado;

    public JuegoDto(Long idJuego,
                    String titulo,
                    String descripcion,
                    String desarrollador,
                    LocalDate fechaLanzamiento,
                    Double precioBase,
                    Integer descuento,
                    String categoria,
                    ClasificacionJuegoEnum clasificacionPorEdad,
                    String[] idiomas,
                    EstadoJuegoEnum estado) {

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

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public String getCategoria() {
        return categoria;
    }

    public ClasificacionJuegoEnum getClasificacionPorEdad() {
        return clasificacionPorEdad;
    }

    public String[] getIdiomas() {
        return idiomas;
    }

    public EstadoJuegoEnum getEstado() {
        return estado;
    }
}