package org.DavidParada.modelo.mappers;

import org.DavidParada.modelo.entidades.JuegoEntidad;
import org.DavidParada.modelo.entidades.UsuarioEntidad;
import org.DavidParada.modelo.enums.EstadoJuegoEnum;
import org.DavidParada.modelo.formularios.JuegoForm;
import org.DavidParada.modelo.formularios.UsuarioForm;

public class JuegoFormularioAEntidadMapper {

    private JuegoFormularioAEntidadMapper() {
    }

    public static JuegoEntidad crearJuego(Long id, JuegoForm form) {
        return new JuegoEntidad(
                id,
                form.getTitulo(),
                form.getDescripcion(),
                form.getDesarrollador(),
                form.getFechaLanzamiento(),
                form.getPrecioBase(),
                0,
                form.getCategoria(),
                form.getClasificacionPorEdad(),
                form.getIdiomas(),
                EstadoJuegoEnum.DISPONIBLE
        );
    }

    public static void actualizarJuego(JuegoEntidad juegoEntidad, JuegoForm form) {
    }
}

