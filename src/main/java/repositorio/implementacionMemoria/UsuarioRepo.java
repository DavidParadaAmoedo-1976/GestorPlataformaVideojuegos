package repositorio.implementacionMemoria;

import modelo.entidades.UsuarioEntidad;
import repositorio.interfaz.IUsuarioRepo;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepo implements IUsuarioRepo {

    private final List<UsuarioEntidad> usuarioEntidades = new ArrayList<>();


    @Override
    public Object crear(Object formulario) {
        return null;
    }

    @Override
    public Object buscarPorId(Object id) {
        return null;
    }

    @Override
    public List listarTodos() {
        return List.of();
    }

    @Override
    public Object actualizar(Object id, Object formulario) {
        return null;
    }

    @Override
    public boolean eliminar(Object id) {
        return false;
    }

    private long generarId() {
        return usuarioEntidades.stream()
                .mapToLong(usuario -> usuario.getIdUsuario())
                .max()
                .orElse(0L) + 1;
    }
}
