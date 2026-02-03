package repositorio.implementacionMemoria;

import modelo.entidades.ReseniaEntidad;
import modelo.formularios.ReseniaForm;
import repositorio.interfaz.IReseniaRepo;

import java.util.ArrayList;
import java.util.List;

public class ReseniaRepo implements IReseniaRepo {

    private final List<ReseniaEntidad>  reseniasEntidades = new ArrayList<>();


    private long generarId() {
        return reseniasEntidades.stream()
                .mapToLong(resenia-> resenia.getIdReseña())
                .max()
                .orElse(0L) + 1;
    }

    @Override
    public ReseniaEntidad crear(ReseniaForm formulario) {
        return null;
    }

    @Override
    public ReseniaEntidad buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<ReseniaEntidad> listarTodos() {
        return List.of();
    }

    @Override
    public ReseniaEntidad actualizar(Long id, ReseniaForm formulario) {
        return null;
    }

    @Override
    public boolean eliminar(Long id) {
        return false;
    }
}
