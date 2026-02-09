package repositorio.implementacionMemoria;

import modelo.entidades.JuegoEntidad;
import modelo.formularios.JuegoForm;
import modelo.mappers.JuegoFormularioAEntidadMapper;
import repositorio.interfaces.IJuegoRepo;

import java.util.ArrayList;
import java.util.List;

public class JuegoRepo implements IJuegoRepo {
    private final List<JuegoEntidad> juegosEntidad = new ArrayList<>();


    private Long generarId() {
        return juegosEntidad.stream()
                .mapToLong(j -> j.getIdJuego())
                .max()
                .orElse(0L) + 1;
    }

    @Override
    public JuegoEntidad buscarPorTitulo(String titulo) {
        return juegosEntidad.stream()
                .filter(j -> j.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<JuegoEntidad> buscarPorCategoria(String categoria) {
        if (categoria == null) return List.of();

        return juegosEntidad.stream()
                .filter(j -> j.getCategoria() != null)
                .filter(j -> j.getCategoria().equalsIgnoreCase(categoria))
                .toList();
    }


    @Override
    public List<JuegoEntidad> buscarPorPrecio(Double precioMin, Double precioMax) {
        if (precioMin == null) precioMin = 0.0;
        precioMax = juegosEntidad.stream()
                .map(juego -> juego.getPrecioBase())
                .max((precio1, precio2) -> precio1.compareTo(precio2))
                .orElse(0.0);

        Double finalPrecioMin = precioMin;
        Double finalPrecioMax = precioMax;
        return juegosEntidad.stream()
                .filter(j -> j.getPrecioBase() >= finalPrecioMin)
                .filter(j -> j.getPrecioBase() <= finalPrecioMax)
                .toList();

    }

    @Override
    public JuegoEntidad crear(JuegoForm form) {
        JuegoEntidad juegoEntidad = JuegoFormularioAEntidadMapper.crearJuego(generarId(), form);
        juegosEntidad.add(juegoEntidad);

        return juegoEntidad;
    }


    @Override
    public JuegoEntidad buscarPorId(Long id) {
        return juegosEntidad.stream()
                .filter(j -> j.getIdJuego() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<JuegoEntidad> listarTodos() {
        return new ArrayList<>(juegosEntidad);
    }

    @Override
    public JuegoEntidad actualizar(Long id, JuegoForm form) {
        JuegoEntidad juegoEntidad = buscarPorId(id);
        if (juegoEntidad == null) return null;
        JuegoFormularioAEntidadMapper.actualizarJuego(juegoEntidad, form);

        return juegoEntidad;
    }

    @Override
    public boolean eliminar(Long id) {
        JuegoEntidad juegoEntidad = buscarPorId(id);
        System.out.println(juegoEntidad.getTitulo() + " eliminado"); // mensaje provisional a falta de vista.
        return juegosEntidad.removeIf(u -> u.getIdJuego() == id);
    }
}

