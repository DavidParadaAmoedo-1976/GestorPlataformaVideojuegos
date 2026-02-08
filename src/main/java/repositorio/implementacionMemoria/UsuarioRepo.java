package repositorio.implementacionMemoria;

import modelo.entidades.UsuarioEntidad;
import modelo.enums.EstadoCuentaEnum;
import modelo.formularios.UsuarioForm;
import repositorio.interfaces.IUsuarioRepo;

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
                form.getNombreReal(),
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
        return new ArrayList<>(usuariosEntidad);
    }

    @Override
    public UsuarioEntidad actualizar(Long id, UsuarioForm form) {
        UsuarioEntidad usuario = buscarPorId(id);
        if (usuario == null) return null;

        usuario.setNombreUsuario(form.getNombreUsuario());
        usuario.setEmail(form.getEmail());
        usuario.setNombreReal(form.getNombreReal());
        usuario.setPais(form.getPais());
        usuario.setAvatar(form.getAvatar());

        return usuario;
    }

    @Override
    public boolean eliminar(Long id) {
        return usuariosEntidad.removeIf(u -> u.getIdUsuario() == id);
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

    private Long generarId() {
        return usuariosEntidad.stream()
                .mapToLong(usuario -> usuario.getIdUsuario())
                .max()
                .orElse(0L) + 1;
    }
}
