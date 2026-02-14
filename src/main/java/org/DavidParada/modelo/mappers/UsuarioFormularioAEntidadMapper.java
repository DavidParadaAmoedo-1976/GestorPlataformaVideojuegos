package org.DavidParada.modelo.mappers;

import org.DavidParada.modelo.entidades.UsuarioEntidad;
import org.DavidParada.modelo.enums.EstadoCuentaEnum;
import org.DavidParada.modelo.formularios.UsuarioForm;

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

    public static UsuarioEntidad actualizarEntidad(Long id, UsuarioForm form) {

        return new UsuarioEntidad(
                id,
                form.getNombreUsuario(),
                form.getEmail(),
                form.getPassword(),
                form.getNombreReal(),
                form.getPais(),
                form.getFechaNacimiento(),
                form.getFechaRegistro(),
                form.getAvatar(),
                form.getSaldo(),
                form.getEstadoCuenta()
        );
    }
}

