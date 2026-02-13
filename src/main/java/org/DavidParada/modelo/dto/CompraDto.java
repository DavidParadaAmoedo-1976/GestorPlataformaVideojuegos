package org.DavidParada.modelo.dto;

import org.DavidParada.modelo.entidades.JuegoEntidad;
import org.DavidParada.modelo.entidades.UsuarioEntidad;
import org.DavidParada.modelo.enums.EstadoCompraEnum;
import org.DavidParada.modelo.enums.MetodoPagoEnum;

import java.time.LocalDate;

public class CompraDto {
    private Long idCompra;
    private UsuarioEntidad usuarioEntidad;
    private JuegoEntidad juego;
    private LocalDate fechaCompra;
    private MetodoPagoEnum metodoPago;
    private Double precio;
    private Integer descuento;
    private EstadoCompraEnum estado;

    public CompraDto(Long idCompra, UsuarioEntidad usuarioEntidad, JuegoEntidad juego, LocalDate fechaCompra, MetodoPagoEnum metodoPago, Double precio, Integer descuento, EstadoCompraEnum estado) {
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

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
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

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public MetodoPagoEnum getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPagoEnum metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public EstadoCompraEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoCompraEnum estado) {
        this.estado = estado;
    }
}
