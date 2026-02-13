package controlador;

import excepciones.ValidationException;
import modelo.dto.UsuarioDto;
import modelo.entidades.UsuarioEntidad;
import modelo.enums.EstadoCuentaEnum;
import modelo.enums.TipoErrorEnum;
import modelo.formularios.UsuarioForm;
import modelo.formularios.validaciones.ErrorModel;
import modelo.formularios.validaciones.UsuarioFormValidador;
import modelo.mappers.UsuarioEntidadADtoMapper;
import repositorio.interfaces.IUsuarioRepo;

import java.util.ArrayList;
import java.util.List;

public class UsuarioControlador {

    private final IUsuarioRepo usuarioRepo;

    public UsuarioControlador(IUsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    // =====================================================
    // 1️⃣ REGISTRAR USUARIO
    // =====================================================

    public UsuarioDto registrarUsuario(UsuarioForm form)
            throws ValidationException {

        UsuarioFormValidador.validarUsuario(form);

        UsuarioEntidad usuario = usuarioRepo.crear(form);

        return UsuarioEntidadADtoMapper.usuarioEntidadADto(usuario);
    }

    // =====================================================
    // 2️⃣ CONSULTAR PERFIL
    // =====================================================

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
                    new ErrorModel("id", TipoErrorEnum.OTRO)
            ));
        }

        return UsuarioEntidadADtoMapper.usuarioEntidadADto(usuario);
    }

    // =====================================================
    // 3️⃣ AÑADIR SALDO
    // =====================================================

    public Double añadirSaldo(Long id, Double cantidad)
            throws ValidationException {

        List<ErrorModel> errores = new ArrayList<>();

        if (id == null)
            errores.add(new ErrorModel("id", TipoErrorEnum.OBLIGATORIO));

        if (cantidad == null || cantidad <= 0)
            errores.add(new ErrorModel("cantidad", TipoErrorEnum.VALOR_NEGATIVO));

        if (cantidad != null && (cantidad < 5.0 || cantidad > 500.0))
            errores.add(new ErrorModel("cantidad", TipoErrorEnum.RANGO_INVALIDO));

        if (!errores.isEmpty())
            throw new ValidationException(errores);

        UsuarioEntidad usuario = usuarioRepo.buscarPorId(id);

        if (usuario == null)
            throw new ValidationException(List.of(
                    new ErrorModel("id", TipoErrorEnum.OTRO)));

        if (usuario.getEstadoCuenta() != EstadoCuentaEnum.ACTIVA)
            throw new ValidationException(List.of(
                    new ErrorModel("estadoCuenta", TipoErrorEnum.OTRO)));

        usuario.setSaldo(usuario.getSaldo() + cantidad);

        return usuario.getSaldo();
    }

    // =====================================================
    // 4️⃣ CONSULTAR SALDO
    // =====================================================

    public Double consultarSaldo(Long id)
            throws ValidationException {

        if (id == null)
            throw new ValidationException(List.of(
                    new ErrorModel("id", TipoErrorEnum.OBLIGATORIO)));

        UsuarioEntidad usuario = usuarioRepo.buscarPorId(id);

        if (usuario == null)
            throw new ValidationException(List.of(
                    new ErrorModel("id", TipoErrorEnum.OTRO)));

        return usuario.getSaldo();
    }

    // =====================================================
    // 5️⃣ CAMBIAR ESTADO CUENTA
    // =====================================================

    public UsuarioDto cambiarEstado(Long id,
                                    EstadoCuentaEnum nuevoEstado)
            throws ValidationException {

        List<ErrorModel> errores = new ArrayList<>();

        if (id == null)
            errores.add(new ErrorModel("id", TipoErrorEnum.OBLIGATORIO));

        if (nuevoEstado == null)
            errores.add(new ErrorModel("estadoCuenta", TipoErrorEnum.OBLIGATORIO));

        if (!errores.isEmpty())
            throw new ValidationException(errores);

        UsuarioEntidad usuario = usuarioRepo.buscarPorId(id);

        if (usuario == null)
            throw new ValidationException(List.of(
                    new ErrorModel("id", TipoErrorEnum.OTRO)));

        usuario.setEstadoCuenta(nuevoEstado);

        return UsuarioEntidadADtoMapper.usuarioEntidadADto(usuario);
    }

    // =====================================================
    // 6️⃣ ELIMINAR USUARIO
    // =====================================================

    public boolean eliminarUsuario(Long id) {
        return usuarioRepo.eliminar(id);
    }
}
