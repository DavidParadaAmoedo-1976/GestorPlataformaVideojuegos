package repositorio.implementacionMemoria;

import modelo.entidades.ReseniaEntidad;
import repositorio.interfaz.IReseniaRepo;

import java.util.ArrayList;
import java.util.List;

public class ReseniaRepo implements IReseniaRepo {

    private final List<ReseniaEntidad>  reseniasEntidades = new ArrayList<>();

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
        return reseniasEntidades.stream()
                .mapToLong(resenia-> resenia.getIdReseña())
                .max()
                .orElse(0L) + 1;
    }
}
