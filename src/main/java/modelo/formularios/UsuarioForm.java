package modelo.formularios;

import modelo.enums.EstadoCuentaEnum;
import modelo.enums.PaisEnum;

import java.time.LocalDate;

public class UsuarioForm {

    private String nombreUsuario;
    private String email;
    private String password;
    private String nombreReal;
    private PaisEnum pais;
    private LocalDate fechaNacimiento;
    private String avatar;
    private double saldo;
    private EstadoCuentaEnum estadoCuenta;

    public UsuarioForm() {
    }

    public UsuarioForm(String nombreUsuario, String email, String password, String nombreReal,
                       PaisEnum pais, LocalDate fechaNacimiento, String avatar, double saldo, EstadoCuentaEnum estadoCuenta) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.nombreReal = nombreReal;
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
        this.avatar = avatar;
        this.saldo = saldo;
        this.estadoCuenta = estadoCuenta;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public PaisEnum getPais() {
        return pais;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getAvatar() {
        return avatar;
    }

    public double getSaldo() {
        return saldo;
    }

    public EstadoCuentaEnum getEstadoCuenta() {
        return estadoCuenta;
    }

}

