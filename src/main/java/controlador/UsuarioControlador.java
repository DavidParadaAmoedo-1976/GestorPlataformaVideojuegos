package controlador;

import modelo.dto.UsuarioDto;
import modelo.entidades.UsuarioEntidad;
import modelo.formularios.UsuarioForm;
import modelo.maper.UsuarioMaper;
import repositorio.interfaz.IUsuarioRepo;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioControlador {

    private final IUsuarioRepo usuarioRepo;

    public UsuarioControlador(IUsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    // Crear usuario
    public UsuarioDto crearUsuario(UsuarioForm form) {

        UsuarioEntidad entidad = usuarioRepo.crear(form);
        return UsuarioMaper.entidadADto(entidad);
    }

    // Buscar por id
    public UsuarioDto buscarUsuarioPorId(long id) {

        UsuarioEntidad entidad = usuarioRepo.buscarPorId(id);
        return UsuarioMaper.entidadADto(entidad);
    }

    // Listar todos
    public List<UsuarioDto> listarUsuarios() {

        return usuarioRepo.listarTodos()
                .stream()
                .map(UsuarioMaper::entidadADto)
                .collect(Collectors.toList());
    }

    // Actualizar usuario
    public UsuarioDto actualizarUsuario(long id, UsuarioForm form) {

        UsuarioEntidad entidad = usuarioRepo.actualizar(id, form);
        return UsuarioMaper.entidadADto(entidad);
    }

    // Eliminar usuario
    public boolean eliminarUsuario(long id) {
        return usuarioRepo.eliminar(id);
    }
}
