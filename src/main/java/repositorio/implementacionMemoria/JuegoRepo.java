package repositorio.implementacionMemoria;

import modelo.entidades.JuegoEntidad;
import modelo.formularios.JuegoForm;
import repositorio.interfaz.IJuegoRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JuegoRepo implements IJuegoRepo {
    private final List<JuegoEntidad> juegoEntidades=new ArrayList<>();


    private long generarId() {
        return juegoEntidades.stream()
                .mapToLong(juego -> juego.getIdJuego())
                .max()
                .orElse(0L) + 1;
    }

    @Override
    public JuegoEntidad buscarPorTitulo(String titulo) {
        return null;
    }

    @Override
    public JuegoEntidad buscarPorCategoria(String categoria) {
        return null;
    }

    @Override
    public JuegoEntidad buscarPorPrecio(Double precio) {
        return null;
    }

    @Override
    public JuegoEntidad crear(JuegoForm formulario) {
        return null;
    }

    @Override
    public JuegoEntidad buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<JuegoEntidad> listarTodos() {
        return List.of();
    }

    @Override
    public JuegoEntidad actualizar(Long id, JuegoForm formulario) {
        return null;
    }

    @Override
    public boolean eliminar(Long id) {
        return false;
    }
}

