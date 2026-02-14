package org.DavidParada.modelo.formularios;

import org.DavidParada.modelo.entidades.JuegoEntidad;
import org.DavidParada.modelo.entidades.UsuarioEntidad;
import org.DavidParada.modelo.enums.EstadoCompraEnum;
import org.DavidParada.modelo.enums.MetodoPagoEnum;

import java.time.LocalDate;

public class CompraForm {
    private UsuarioEntidad usuarioEntidad;
    private JuegoEntidad juego;
    private LocalDate fechaCompra;
    private MetodoPagoEnum metodoPago;
    private Double precio;
    private Integer descuento;
    private EstadoCompraEnum estado;

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

