package modelo.entidades;

import modelo.enums.EstadoCompraEnum;
import modelo.enums.PagoEnum;

import java.time.LocalDate;

public class Compra {
    private long idCompra;
    private Usuario usuario;
    private Juego juego;
    private LocalDate fechaCompra;
    private PagoEnum metodoPago;
    private double precio;
    private int descuento;
    private EstadoCompraEnum estado;

    public Compra(long idCompra, Usuario usuario, Juego juego, LocalDate fechaCompra, PagoEnum metodoPago, double precio, int descuento, EstadoCompraEnum estado) {
        this.idCompra = idCompra;
        this.usuario = usuario;
        this.juego = juego;
        this.fechaCompra = fechaCompra;
        this.metodoPago = metodoPago;
        this.precio = precio;
        this.descuento = descuento;
        this.estado = estado;
    }

    public Compra(Usuario usuario, Juego juego, LocalDate fechaCompra, PagoEnum metodoPago, double precio, int descuento, EstadoCompraEnum estado) {
        this.usuario = usuario;
        this.juego = juego;
        this.fechaCompra = fechaCompra;
        this.metodoPago = metodoPago;
        this.precio = precio;
        this.descuento = descuento;
        this.estado = estado;
    }

    public Compra() {
    }

    public long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(long idCompra) {
        this.idCompra = idCompra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public PagoEnum getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(PagoEnum metodoPago) {
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
