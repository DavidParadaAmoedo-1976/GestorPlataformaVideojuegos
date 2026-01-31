package modelo.formularios;

import java.time.LocalDate;

public class UsuarioForm {

    private String nombreUsuario;
    private String email;
    private String password;
    private String pais;
    private LocalDate fechaNacimiento;
    private String avatar;

    public UsuarioForm() {
    }

    public UsuarioForm(String nombreUsuario, String email, String password,
                       String pais, LocalDate fechaNacimiento, String avatar) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
        this.avatar = avatar;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

