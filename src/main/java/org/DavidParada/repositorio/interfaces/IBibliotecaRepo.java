package org.DavidParada.repositorio.interfaces;

import org.DavidParada.modelo.entidades.BibliotecaEntidad;
import org.DavidParada.modelo.formularios.BibliotecaForm;

import java.util.List;

public interface IBibliotecaRepo<B, B1, L extends Number> extends ICrud<BibliotecaEntidad, BibliotecaForm, Long> {
    List<BibliotecaEntidad> buscarPorUsuario(Long idUsuario);
    BibliotecaEntidad buscarPorUsuarioYJuego(Long idUsuario, Long idJuego);
}
