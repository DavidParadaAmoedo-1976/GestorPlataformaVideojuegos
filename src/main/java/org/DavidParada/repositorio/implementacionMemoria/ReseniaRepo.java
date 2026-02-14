package org.DavidParada.repositorio.implementacionMemoria;

import org.DavidParada.modelo.entidades.ReseniaEntidad;
import org.DavidParada.modelo.formularios.ReseniaForm;
import org.DavidParada.repositorio.interfaces.IReseniaRepo;

import java.util.ArrayList;
import java.util.List;

public class ReseniaRepo implements IReseniaRepo {

    private final List<ReseniaEntidad> reseniasEntidades = new ArrayList<>();


    private Long generarId() {
        return reseniasEntidades.stream()
                .mapToLong(resenia -> resenia.getIdResena())
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
