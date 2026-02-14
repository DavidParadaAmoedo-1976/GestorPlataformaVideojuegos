package org.DavidParada.modelo.entidades;

import org.DavidParada.modelo.enums.EstadoCompraEnum;
import org.DavidParada.modelo.enums.MetodoPagoEnum;

import java.time.LocalDate;

public class CompraEntidad {
    private Long idCompra;
    private UsuarioEntidad usuarioEntidad;
    private JuegoEntidad juego;
    private LocalDate fechaCompra;
    private MetodoPagoEnum metodoPago;
    private Double precio;
    private Integer descuento;
    private EstadoCompraEnum estado;

    public CompraEntidad(Long idCompra,
                         UsuarioEntidad usuarioEntidad,
                         JuegoEntidad juego,
                         LocalDate fechaCompra,
                         MetodoPagoEnum metodoPago,
                         Double precio,
                         Integer descuento,
                         EstadoCompraEnum estado) {

        this.idCompra = idCompra;
        this.usuarioEntidad = usuarioEntidad;
        this.juego = juego;
        this.fechaCompra = fechaCompra;
        this.metodoPago = metodoPago;
        this.precio = precio;
        this.descuento = descuento;
        this.estado = estado;
    }

    public Long getIdCompra() {
        return idCompra;
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
