package modelo.mappers;

import modelo.entidades.BibliotecaEntidad;
import modelo.formularios.BibliotecaForm;

import java.time.LocalDate;

public class BibliotecaFormularioAEntidadMapper {

    private BibliotecaFormularioAEntidadMapper() {
        // evitar instanciación
    }

    public static BibliotecaEntidad crearEntidad(Long id,
                                                 BibliotecaForm form) {

        return new BibliotecaEntidad(
                id,
                form.getIdUsuario(),
                form.getIdJuego(),
                LocalDate.now(),     // fechaAdquisicion automática
                0,                   // horasDeJuego inicial
                null,                // ultimaFechaDeJuego aún no ha jugado
                false                // no instalado por defecto
        );
    }
}
