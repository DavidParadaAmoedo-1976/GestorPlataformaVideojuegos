package modelo.entidades;

import modelo.enums.EstadoCuentaEnum;
import modelo.enums.PaisEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class UsuarioEntidad {
    private long idUsuario;
    private String nombreUsuario;
    private String email;
    private String password;
    private String nombreReal;
    private PaisEnum pais;
    private LocalDate fechaNacimiento;
    private LocalDate fechaRegistro;
    private String avatar;
    private double saldo;
    private EstadoCuentaEnum estadoCuenta;

    public UsuarioEntidad(long idUsuario, String nombreUsuario, String email, String password,String nombreReal, PaisEnum pais, LocalDate fechaNacimiento, LocalDate fechaRegistro, String avatar, double saldo, EstadoCuentaEnum estadoCuenta) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.nombreReal = nombreReal;
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.avatar = avatar;
        this.saldo = 0;
        this.estadoCuenta = EstadoCuentaEnum.ACTIVA;
    }

    public UsuarioEntidad() {

    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public PaisEnum getPais() {
        return this.pais;
    }

    public void setPais(PaisEnum pais) {
        this.pais = pais;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo");
        }
        BigDecimal bd = BigDecimal.valueOf(saldo)
                .setScale(2, RoundingMode.HALF_UP);
        this.saldo = bd.doubleValue();
    }

    public EstadoCuentaEnum getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(EstadoCuentaEnum estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }
}
