package repositorio.implementacionMemoria;

import modelo.entidades.JuegoEntidad;
import modelo.formularios.JuegoForm;
import repositorio.interfaz.IJuegoRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JuegoRepo implements IJuegoRepo {
    private final List<JuegoEntidad> juegoEntidades=new ArrayList<>();

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
        return juegoEntidades.stream()
                .mapToLong(juego -> juego.getIdJuego())
                .max()
                .orElse(0L) + 1;
    }
}

