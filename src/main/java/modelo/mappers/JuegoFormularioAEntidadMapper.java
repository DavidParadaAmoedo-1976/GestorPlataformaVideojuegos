package modelo.mappers;

import modelo.entidades.JuegoEntidad;
import modelo.enums.EstadoJuegoEnum;
import modelo.formularios.JuegoForm;

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

        juegoEntidad.setTitulo(form.getTitulo());
        juegoEntidad.setDescripcion(form.getDescripcion());
        juegoEntidad.setDesarrollador(form.getDesarrollador());
        juegoEntidad.setFechaLanzamiento(form.getFechaLanzamiento());
        juegoEntidad.setPrecioBase(form.getPrecioBase());
        juegoEntidad.setCategoria(form.getCategoria());
        juegoEntidad.setClasificacionPorEdad(form.getClasificacionPorEdad());
        juegoEntidad.setIdiomas(form.getIdiomas());

        if (form.getDescuento() != null) {
            juegoEntidad.setDescuento(form.getDescuento());
        }

        if (form.getEstado() != null) {
            juegoEntidad.setEstado(form.getEstado());
        }
    }
}

