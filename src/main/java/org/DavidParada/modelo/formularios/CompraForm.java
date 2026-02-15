package org.DavidParada.modelo.formularios;

import org.DavidParada.modelo.entidades.JuegoEntidad;
import org.DavidParada.modelo.entidades.UsuarioEntidad;
import org.DavidParada.modelo.enums.EstadoCompraEnum;
import org.DavidParada.modelo.enums.MetodoPagoEnum;

import java.time.LocalDate;

public class CompraForm {
    private final UsuarioEntidad usuarioEntidad;
    private final JuegoEntidad juego;
    private final LocalDate fechaCompra;
    private final MetodoPagoEnum metodoPago;
    private final Double precio;
    private final Integer descuento;
    private final EstadoCompraEnum estado;

    public CompraForm(UsuarioEntidad usuarioEntidad,
                      JuegoEntidad juego,
                      LocalDate fechaCompra,
                      MetodoPagoEnum metodoPago,
                      Double precio,
                      Integer descuento,
                      EstadoCompraEnum estado) {

        this.usuarioEntidad = usuarioEntidad;
        this.juego = juego;
        this.fechaCompra = fechaCompra;
        this.metodoPago = metodoPago;
        this.precio = precio;
        this.descuento = descuento;
        this.estado = estado;
    }

    public UsuarioEntidad getUsuario() {
        return usuarioEntidad;
    }

    public JuegoEntidad getJuego() {
        return juego;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public MetodoPagoEnum getMetodoPago() {
        return metodoPago;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public EstadoCompraEnum getEstado() {
        return estado;
    }
}

