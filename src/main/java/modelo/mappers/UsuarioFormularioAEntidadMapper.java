package modelo.mappers;

import modelo.entidades.UsuarioEntidad;
import modelo.enums.EstadoCuentaEnum;
import modelo.formularios.UsuarioForm;

import java.time.LocalDate;

public class UsuarioFormularioAEntidadMapper {

    private UsuarioFormularioAEntidadMapper() {
    }

    public static UsuarioEntidad crearEntidad(Long id, UsuarioForm form) {
        return new UsuarioEntidad(
                id,
                form.getNombreUsuario(),
                form.getEmail(),
                form.getPassword(),
                form.getNombreReal(),
                form.getPais(),
                form.getFechaNacimiento(),
                LocalDate.now(),
                form.getAvatar(),
                0.0,
                EstadoCuentaEnum.ACTIVA
        );
    }

    public static void actualizarEntidad(UsuarioEntidad usuario, UsuarioForm form) {
        usuario.setNombreUsuario(form.getNombreUsuario());
        usuario.setEmail(form.getEmail());
        usuario.setNombreReal(form.getNombreReal());
        usuario.setPais(form.getPais());
        usuario.setFechaNacimiento(form.getFechaNacimiento());
        usuario.setAvatar(form.getAvatar());

        if (form.getEstadoCuenta() != null) {
            usuario.setEstadoCuenta(form.getEstadoCuenta());
        }
    }
}

