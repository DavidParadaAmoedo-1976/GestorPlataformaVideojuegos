package repositorio.interfaz;

import modelo.entidades.BibliotecaEntidad;
import modelo.formularios.BibliotecaForm;

public interface IBibliotecaRepo<B, B1, L extends Number> extends ICrud<BibliotecaEntidad, BibliotecaForm, Long> {
}
