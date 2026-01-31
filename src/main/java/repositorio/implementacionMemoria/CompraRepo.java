package repositorio.implementacionMemoria;

import modelo.entidades.CompraEntidad;
import repositorio.interfaz.ICompraRepo;

import java.util.ArrayList;
import java.util.List;

public class CompraRepo implements ICompraRepo {

    private final List<CompraEntidad>  compraEntidad = new ArrayList<>();

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
        return compraEntidad.stream()
                .mapToLong(compra -> compra.getIdCompra())
                .max()
                .orElse(0L) + 1;
    }
}
