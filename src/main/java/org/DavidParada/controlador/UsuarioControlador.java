package org.DavidParada.controlador;

import org.DavidParada.excepciones.ValidationException;
import org.DavidParada.modelo.dto.UsuarioDto;
import org.DavidParada.modelo.entidades.UsuarioEntidad;
import org.DavidParada.modelo.enums.EstadoCuentaEnum;
import org.DavidParada.modelo.enums.TipoErrorEnum;
import org.DavidParada.modelo.formularios.UsuarioForm;
import org.DavidParada.modelo.formularios.validaciones.ErrorModel;
import org.DavidParada.modelo.formularios.validaciones.UsuarioFormValidador;
import org.DavidParada.modelo.mappers.UsuarioEntidadADtoMapper;
import org.DavidParada.repositorio.interfaces.IUsuarioRepo;

import java.util.ArrayList;
import java.util.List;

public class UsuarioControlador {

    private final IUsuarioRepo usuarioRepo;

    public UsuarioControlador(IUsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    //Registrar nuevo usuario

    public UsuarioDto registrarUsuario(UsuarioForm form)
            throws ValidationException {

        UsuarioFormValidador.validarUsuario(form);

        UsuarioEntidad usuario = usuarioRepo.crear(form);

        return UsuarioEntidadADtoMapper.usuarioEntidadADto(usuario);
    }

    // Consultar perfil

    public UsuarioDto consultarPerfil(Long id)
            throws ValidationException {

        if (id == null) {
            throw new ValidationException(List.of(
                    new ErrorModel("id", TipoErrorEnum.OBLIGATORIO)
            ));
        }

        UsuarioEntidad usuario = usuarioRepo.buscarPorId(id);

        if (usuario == null) {
            throw new ValidationException(List.of(
                    new ErrorModel("id", TipoErrorEnum.NO_ENCONTRADO)
            ));
        }

        return UsuarioEntidadADtoMapper.usuarioEntidadADto(usuario);
    }

    // Añadir saldo a cartera

    public void anadirSaldo(Long id, Double cantidad)
            throws ValidationException {

        List<ErrorModel> errores = new ArrayList<>();

        if (id == null)
            errores.add(new ErrorModel("id", TipoErrorEnum.OBLIGATORIO));

        if (cantidad == null || cantidad <= 0)
            errores.add(new ErrorModel("saldo", TipoErrorEnum.VALOR_NEGATIVO));

        if (cantidad != null && (cantidad < 5.0 || cantidad > 500.0))
            errores.add(new ErrorModel("saldo", TipoErrorEnum.RANGO_INVALIDO));

        if (!errores.isEmpty())
            throw new ValidationException(errores);

        UsuarioEntidad usuario = usuarioRepo.buscarPorId(id);

        if (usuario == null)
            throw new ValidationException(List.of(
                    new ErrorModel("id", TipoErrorEnum.NO_ENCONTRADO)));

        if (usuario.getEstadoCuenta() != EstadoCuentaEnum.ACTIVA)
            throw new ValidationException(List.of(
                    new ErrorModel("estadoCuenta", TipoErrorEnum.ESTADO_INCORRECTO)));

        usuarioRepo.actualizar(usuario.getIdUsuario(), new UsuarioForm(usuario.getNombreUsuario(), usuario.getEmail(),
                                                                        usuario.getPassword(), usuario.getNombreReal(),
                                                                        usuario.getPais(), usuario.getFechaNacimiento(),
                                                                        usuario.getFechaRegistro(), usuario.getAvatar(),
                                                                        cantidad, usuario.getEstadoCuenta()));
    }

    // Consultar saldo

    public Double consultarSaldo(Long id)
            throws ValidationException {

        if (id == null)
            throw new ValidationException(List.of(
                    new ErrorModel("id", TipoErrorEnum.OBLIGATORIO)));

        UsuarioEntidad usuario = usuarioRepo.buscarPorId(id);

        if (usuario == null)
            throw new ValidationException(List.of(
                    new ErrorModel("id", TipoErrorEnum.NO_ENCONTRADO)));

        return usuario.getSaldo();
    }

//    // Cambiar estado
//
//    public UsuarioDto cambiarEstado(Long id,
//                                    EstadoCuentaEnum nuevoEstado)
//            throws ValidationException {
//
//        List<ErrorModel> errores = new ArrayList<>();
//
//        if (id == null)
//            errores.add(new ErrorModel("id", TipoErrorEnum.OBLIGATORIO));
//
//        if (nuevoEstado == null)
//            errores.add(new ErrorModel("estadoCuenta", TipoErrorEnum.OBLIGATORIO));
//
//        if (!errores.isEmpty())
//            throw new ValidationException(errores);
//
//        UsuarioEntidad usuario = usuarioRepo.buscarPorId(id);
//
//        if (usuario == null)
//            throw new ValidationException(List.of(
//                    new ErrorModel("id", TipoErrorEnum.NO_ENCONTRADO)));
//
//        usuario.setEstadoCuenta(nuevoEstado);
//
//        return UsuarioEntidadADtoMapper.usuarioEntidadADto(usuario);
//    }
//
//    // Eliminar usuario
//
//    public boolean eliminarUsuario(Long id) {
//        return usuarioRepo.eliminar(id);
//    }
}
