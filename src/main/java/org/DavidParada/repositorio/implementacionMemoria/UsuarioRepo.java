package org.DavidParada.repositorio.implementacionMemoria;

import org.DavidParada.modelo.entidades.UsuarioEntidad;
import org.DavidParada.modelo.formularios.UsuarioForm;
import org.DavidParada.modelo.mappers.UsuarioFormularioAEntidadMapper;
import org.DavidParada.repositorio.interfaces.IUsuarioRepo;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepo implements IUsuarioRepo {

    private final List<UsuarioEntidad> usuariosEntidad = new ArrayList<>();

    private Long generarId() {
        return usuariosEntidad.stream()
                .mapToLong(usuario -> usuario.getIdUsuario())
                .max()
                .orElse(0L) + 1;
    }

    @Override
    public UsuarioEntidad crear(UsuarioForm form) {
        UsuarioEntidad usuario = UsuarioFormularioAEntidadMapper.crearEntidad(generarId(), form);

        usuariosEntidad.add(usuario);
        return usuario;
    }

    @Override
    public UsuarioEntidad buscarPorId(Long id) {
        return usuariosEntidad.stream()
                .filter(u -> u.getIdUsuario().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<UsuarioEntidad> listarTodos() {
        return new ArrayList<>(usuariosEntidad);
    }

    @Override
    public UsuarioEntidad actualizar(Long id, UsuarioForm form) {
        UsuarioEntidad usuario = buscarPorId(id);
        if (usuario == null) return null;

        UsuarioFormularioAEntidadMapper.actualizarEntidad(usuario, form);
        return usuario;
    }

    @Override
    public boolean eliminar(Long id) {
        UsuarioEntidad usuarioEntidad = buscarPorId(id);
        if (usuarioEntidad == null) {
            return false;
        }
        System.out.println(usuarioEntidad.getNombreUsuario() + " eliminado"); // mensaje provisional a falta de org.DavidParada.vista.
        return usuariosEntidad.removeIf(u -> u.getIdUsuario().equals(id));
    }

    @Override
    public UsuarioEntidad buscarPorEmail(String email) {
        return usuariosEntidad.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public UsuarioEntidad buscarPorNombreUsuario(String nombreUsuario) {
        return usuariosEntidad.stream()
                .filter(u -> u.getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                .findFirst()
                .orElse(null);
    }
}
