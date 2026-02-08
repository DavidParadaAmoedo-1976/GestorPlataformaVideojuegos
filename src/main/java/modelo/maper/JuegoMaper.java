package modelo.maper;

import modelo.dto.JuegoDto;
import modelo.entidades.JuegoEntidad;

public class JuegoMaper {
    private JuegoMaper() {
    }

    public static JuegoDto juegoDto(JuegoEntidad juego) {

        if (juego == null) return null;

        return new JuegoDto(
                juego.getIdJuego(),
                juego.getTitulo(),
                juego.getDescripcion(),
                juego.getDesarrollador(),
                juego.getFechaLanzamiento(),
                juego.getPrecioBase(),
                juego.getDescuento(),
                juego.getCategoria(),
                juego.getClasificacionPorEdad(),
                juego.getIdiomas(),
                juego.getEstado()
        );
    }
}
