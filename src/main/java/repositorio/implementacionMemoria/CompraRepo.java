package repositorio.implementacionMemoria;

import modelo.entidades.CompraEntidad;
import modelo.formularios.CompraForm;
import repositorio.interfaces.ICompraRepo;

import java.util.ArrayList;
import java.util.List;

public class CompraRepo implements ICompraRepo {

    private final List<CompraEntidad> compraEntidad = new ArrayList<>();


    private Long generarId() {
        return compraEntidad.stream()
                .mapToLong(compra -> compra.getIdCompra())
                .max()
                .orElse(0L) + 1;
    }

    @Override
    public CompraEntidad crear(CompraForm formulario) {
        return null;
    }

    @Override
    public CompraEntidad buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<CompraEntidad> listarTodos() {
        return List.of();
    }

    @Override
    public CompraEntidad actualizar(Long id, CompraForm formulario) {
        return null;
    }

    @Override
    public boolean eliminar(Long id) {
        return false;
    }
}
