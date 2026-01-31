package repositorio.implementacionMemoria;

import modelo.entidades.UsuarioEntidad;
import modelo.enums.EstadoCuentaEnum;
import modelo.formularios.UsuarioForm;
import repositorio.interfaz.IUsuarioRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepo implements IUsuarioRepo {

    private final List<UsuarioEntidad> usuariosEntidad = new ArrayList<>();

    @Override
    public UsuarioEntidad crear(UsuarioForm form) {

        UsuarioEntidad usuario = new UsuarioEntidad(
                generarId(),
                form.getNombreUsuario(),
                form.getEmail(),
                form.getPassword(),
                form.getPais(),
                form.getFechaNacimiento(),
                LocalDate.now(),
                form.getAvatar(),
                0.0,
                EstadoCuentaEnum.ACTIVA
        );

        usuariosEntidad.add(usuario);
        return usuario;
    }

    @Override
    public UsuarioEntidad buscarPorId(Long id) {
        return usuariosEntidad.stream()
                .filter(u -> u.getIdUsuario() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<UsuarioEntidad> listarTodos() {
        return usuariosEntidad;
    }

    @Override
    public UsuarioEntidad actualizar(Long id, UsuarioForm form) {
        UsuarioEntidad usuario = buscarPorId(id);
        if (usuario == null) return null;

        usuario.setNombreUsuario(form.getNombreUsuario());
        usuario.setEmail(form.getEmail());
        usuario.setPais(form.getPais());
        usuario.setAvatar(form.getAvatar());

        return usuario;
    }

    @Override
    public boolean eliminar(Long id) {
        return usuariosEntidad.removeIf(u -> u.getIdUsuario() == id);
    }

    private long generarId() {
        return usuariosEntidad.stream()
                .mapToLong(usuario -> usuario.getIdUsuario())
                .max()
                .orElse(0L) + 1;
    }
}
