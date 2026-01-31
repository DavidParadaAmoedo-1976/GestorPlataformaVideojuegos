package repositorio.implementacionMemoria;

import modelo.entidades.BibliotecaEntidad;
import modelo.formularios.BibliotecaForm;
import repositorio.interfaz.IBibliotecaRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    private long generarId() {
        return listaBibliotecas.stream()
                .mapToLong(biblioteca -> biblioteca.getIdBiblioteca())
                .max()
                .orElse(0L) + 1;
    }
}
