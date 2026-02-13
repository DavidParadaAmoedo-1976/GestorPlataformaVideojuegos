package org.DavidParada.repositorio.interfaces;

import org.DavidParada.modelo.entidades.JuegoEntidad;
import org.DavidParada.modelo.enums.ClasificacionJuegoEnum;
import org.DavidParada.modelo.enums.EstadoJuegoEnum;
import org.DavidParada.modelo.formularios.JuegoForm;

import java.util.List;

public interface IJuegoRepo extends ICrud<JuegoEntidad, JuegoForm, Long> {

    boolean existeTitulo(String titulo);

    List<JuegoEntidad> buscarConFiltros(
                String titulo,
                String categoria,
                Double precioMin,
                Double precioMax,
                ClasificacionJuegoEnum clasificacion,
                EstadoJuegoEnum estado
        );

    }

