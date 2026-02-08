package modelo.maper;

import modelo.dto.UsuarioDto;
import modelo.entidades.UsuarioEntidad;

public class UsuarioMaper {

    private UsuarioMaper() {
        // evita instanciar
    }

    public static UsuarioDto entidadADto(UsuarioEntidad usuario) {

        if (usuario == null) return null;

        return new UsuarioDto(
                usuario.getIdUsuario(),
                usuario.getNombreUsuario(),
                usuario.getEmail(),
                usuario.getPassword(),
                usuario.getNombreUsuario(),
                usuario.getPais(),
                usuario.getFechaNacimiento(),
                usuario.getFechaRegistro(),
                usuario.getAvatar(),
                usuario.getSaldo(),
                usuario.getEstadoCuenta()
        );
    }
}
