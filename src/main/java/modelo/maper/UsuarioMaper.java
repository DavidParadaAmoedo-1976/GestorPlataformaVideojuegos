package modelo.maper;

import modelo.dto.UsuarioDto;
import modelo.entidades.UsuarioEntidad;

public class UsuarioMaper {

    private UsuarioMaper() {
        // evita instanciar
    }

    public static UsuarioDto entidadADto(UsuarioEntidad entidad) {

        if (entidad == null) return null;

        return new UsuarioDto(
                entidad.getIdUsuario(),
                entidad.getNombreUsuario(),
                entidad.getEmail(),
                entidad.getPassword(),
                entidad.getNombreUsuario(),
                entidad.getPais(),
                entidad.getFechaNacimiento(),
                entidad.getFechaRegistro(),
                entidad.getAvatar(),
                entidad.getSaldo(),
                entidad.getEstadoCuenta()
        );
    }
}
