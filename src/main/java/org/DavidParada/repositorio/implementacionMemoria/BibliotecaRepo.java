package org.DavidParada.repositorio.implementacionMemoria;

import org.DavidParada.modelo.entidades.BibliotecaEntidad;
import org.DavidParada.modelo.formularios.BibliotecaForm;
import org.DavidParada.modelo.mappers.BibliotecaFormularioAEntidadMapper;
import org.DavidParada.repositorio.interfaces.IBibliotecaRepo;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaRepo implements IBibliotecaRepo<BibliotecaEntidad, BibliotecaForm, Long> {
    private final List<BibliotecaEntidad> bibliotecasEntidad = new ArrayList<>();

    @Override
    public BibliotecaEntidad crear(BibliotecaForm form) {
        BibliotecaEntidad bibliotecaEntidad = BibliotecaFormularioAEntidadMapper.crearBibliotecaEntidad(generarId(), form);
        bibliotecasEntidad.add(bibliotecaEntidad);
        return bibliotecaEntidad;
    }

    @Override
    public BibliotecaEntidad buscarPorId(Long id) {
        return bibliotecasEntidad.stream()
                .filter(b -> b.getIdBiblioteca().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BibliotecaEntidad> listarTodos() {
        return new ArrayList<>(bibliotecasEntidad);
    }

    @Override
    public BibliotecaEntidad actualizar(Long id, BibliotecaForm form) {
        BibliotecaEntidad bibliotecaEntidad = buscarPorId(id);
        if (bibliotecaEntidad == null) return null;

        bibliotecasEntidad.remove(bibliotecaEntidad);

        bibliotecasEntidad.add(BibliotecaFormularioAEntidadMapper.actualizarBibliotecaEntidad(id, form));

        return bibliotecaEntidad;
    }

    @Override
    public boolean eliminar(Long id) {
        BibliotecaEntidad bibliotecaEntidad = buscarPorId(id);
        if (bibliotecaEntidad == null) return false;
        System.out.println(bibliotecaEntidad.getIdBiblioteca() + "eliminado"); // Esto lo hará la vista
        return bibliotecasEntidad.removeIf(b -> b.getIdBiblioteca().equals(id));
    }

    private Long generarId() {
        return bibliotecasEntidad.stream()
                .mapToLong(biblioteca -> biblioteca.getIdBiblioteca())
                .max()
                .orElse(0L) + 1;
    }

    @Override
    public List<BibliotecaEntidad> buscarPorUsuario(Long idUsuario) {
        return bibliotecasEntidad.stream()
                .filter(b -> b.getIdUsuario().equals(idUsuario))
                .toList();
    }

    @Override
    public BibliotecaEntidad buscarPorUsuarioYJuego(Long idUsuario, Long idJuego) {
        if (idUsuario == null || idJuego == null) {
            return null;
        }

        return bibliotecasEntidad.stream()
                .filter(u -> u.getIdUsuario().equals(idUsuario))
                .filter(j -> j.getIdJuego().equals(idJuego))
                .findFirst()
                .orElse(null);
    }
}
