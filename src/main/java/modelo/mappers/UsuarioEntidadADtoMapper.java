package modelo.mappers;

import modelo.dto.UsuarioDto;
import modelo.entidades.UsuarioEntidad;

public class UsuarioEntidadADtoMapper {

    private UsuarioEntidadADtoMapper() {
        // evita instanciar
    }

    public static UsuarioDto usuarioEntidadADto(UsuarioEntidad usuario) {

        if (usuario == null) return null;

        return new UsuarioDto(

                usuario.getIdUsuario(),
                usuario.getNombreUsuario(),
                usuario.getEmail(),
                usuario.getPassword(),
                usuario.getNombreReal(),
                usuario.getPais(),
                usuario.getFechaNacimiento(),
                usuario.getFechaRegistro(),
                usuario.getAvatar(),
                usuario.getSaldo(),
                usuario.getEstadoCuenta()
        );
    }
}
