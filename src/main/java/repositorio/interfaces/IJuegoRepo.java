package repositorio.interfaces;

import modelo.entidades.JuegoEntidad;
import modelo.enums.ClasificacionJuegoEnum;
import modelo.enums.EstadoJuegoEnum;
import modelo.formularios.JuegoForm;

import java.util.List;

public interface IJuegoRepo extends ICrud<JuegoEntidad, JuegoForm, Long> {

        List<JuegoEntidad> buscarConFiltros(
                String titulo,
                String categoria,
                Double precioMin,
                Double precioMax,
                ClasificacionJuegoEnum clasificacion,
                EstadoJuegoEnum estado
        );

    }

