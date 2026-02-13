package org.DavidParada.repositorio.implementacionMemoria;

import org.DavidParada.modelo.entidades.BibliotecaEntidad;
import org.DavidParada.modelo.formularios.BibliotecaForm;
import org.DavidParada.repositorio.interfaces.IBibliotecaRepo;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaRepo implements IBibliotecaRepo<BibliotecaEntidad, BibliotecaForm, Long> {
    private final List<BibliotecaEntidad> listaBibliotecas = new ArrayList<>();

    @Override
    public BibliotecaEntidad crear(BibliotecaForm formulario) {
        return null;
    }

    @Override
    public BibliotecaEntidad buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<BibliotecaEntidad> listarTodos() {
        return List.of();
    }

    @Override
    public BibliotecaEntidad actualizar(Long id, BibliotecaForm formulario) {
        return null;
    }

    @Override
    public boolean eliminar(Long id) {
        return false;
    }

    private Long generarId() {
        return listaBibliotecas.stream()
                .mapToLong(biblioteca -> biblioteca.getIdBiblioteca())
                .max()
                .orElse(0L) + 1;
    }
}
