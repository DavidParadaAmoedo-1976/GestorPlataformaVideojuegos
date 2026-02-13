package org.DavidParada.repositorio.interfaces;

import org.DavidParada.modelo.entidades.BibliotecaEntidad;
import org.DavidParada.modelo.formularios.BibliotecaForm;

public interface IBibliotecaRepo<B, B1, L extends Number> extends ICrud<BibliotecaEntidad, BibliotecaForm, Long> {
}
