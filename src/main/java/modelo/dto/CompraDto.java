package modelo.dto;

import modelo.entidades.JuegoEntidad;
import modelo.entidades.UsuarioEntidad;
import modelo.enums.EstadoCompraEnum;
import modelo.enums.MetodoPagoEnum;

import java.time.LocalDate;

public class CompraDto {
    private long idCompra;
    private UsuarioEntidad usuarioEntidad;
    private JuegoEntidad juego;
    private LocalDate fechaCompra;
    private MetodoPagoEnum metodoPago;
    private double precio;
    private int descuento;
    private EstadoCompraEnum estado;

    public CompraDto(long idCompra, UsuarioEntidad usuarioEntidad, JuegoEntidad juego, LocalDate fechaCompra, MetodoPagoEnum metodoPago, double precio, int descuento, EstadoCompraEnum estado) {
        this.idCompra = idCompra;
        this.usuarioEntidad = usuarioEntidad;
        this.juego = juego;
        this.fechaCompra = fechaCompra;
        this.metodoPago = metodoPago;
        this.precio = precio;
        this.descuento = descuento;
        this.estado = estado;
    }

    public long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(long idCompra) {
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public EstadoCompraEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoCompraEnum estado) {
        this.estado = estado;
    }
}
