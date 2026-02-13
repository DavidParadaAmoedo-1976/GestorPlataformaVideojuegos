package org.DavidParada.controlador;

import org.DavidParada.excepciones.ValidationException;
import org.DavidParada.modelo.dto.JuegoDto;
import org.DavidParada.modelo.entidades.JuegoEntidad;
import org.DavidParada.modelo.enums.ClasificacionJuegoEnum;
import org.DavidParada.modelo.enums.EstadoJuegoEnum;
import org.DavidParada.modelo.enums.OrdenarJuegosEnum;
import org.DavidParada.modelo.enums.TipoErrorEnum;
import org.DavidParada.modelo.formularios.JuegoForm;
import org.DavidParada.modelo.formularios.validaciones.ErrorModel;
import org.DavidParada.modelo.formularios.validaciones.JuegoFormValidador;
import org.DavidParada.modelo.mappers.JuegoEntidadADtoMapper;
import org.DavidParada.repositorio.interfaces.IJuegoRepo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class JuegoControlador {

    private final IJuegoRepo juegoRepo;

    public JuegoControlador(IJuegoRepo juegoRepo) {
        this.juegoRepo = juegoRepo;
    }

    // Añadir Juego

    public JuegoDto crearJuego(JuegoForm form) throws ValidationException {

        JuegoFormValidador.validarJuego(form);

        JuegoEntidad entidad = juegoRepo.crear(form);

        return JuegoEntidadADtoMapper.juegoEntidadADto(entidad);
    }

    // Buscar juegos

    public List<JuegoDto> buscarJuegos(
            String titulo,
            String categoria,
            Double precioMin,
            Double precioMax,
            ClasificacionJuegoEnum clasificacion,
            EstadoJuegoEnum estado
    ) {

        List<JuegoEntidad> juegos = juegoRepo.buscarConFiltros(
                titulo, categoria, precioMin, precioMax, clasificacion, estado
        );

        return juegos.stream()
                .map(JuegoEntidadADtoMapper::juegoEntidadADto)
                .toList();
    }

    // Consultar catalogo completo

    public List<JuegoDto> listarTodos(OrdenarJuegosEnum orden) {

        List<JuegoEntidad> juegos = juegoRepo.listarTodos();

        if (orden != null) {

            switch (orden) {

                case ALFABETICO -> juegos.sort(Comparator.comparing(j -> j.getTitulo()));

                case PRECIO -> juegos.sort(Comparator.comparing(j -> j.getPrecioBase()));

                case FECHA -> juegos.sort(Comparator.comparing(j -> j.getFechaLanzamiento()));
            }
        }

        return juegos.stream()
                .map(juegoEntidad -> JuegoEntidadADtoMapper.juegoEntidadADto(juegoEntidad))
                .toList();
    }

    // Consultar detalles de un juego

    public JuegoDto consultarDetalles(Long id)
            throws ValidationException {

        List<ErrorModel> errores = new ArrayList<>();

        if (id == null) {
            errores.add(new ErrorModel("id", TipoErrorEnum.OBLIGATORIO));
            throw new ValidationException(errores);
        }

        JuegoEntidad juego = juegoRepo.buscarPorId(id);

        if (juego == null) {
            errores.add(new ErrorModel("id", TipoErrorEnum.NO_ENCONTRADO));
            throw new ValidationException(errores);
        }

        return JuegoEntidadADtoMapper.juegoEntidadADto(juego);
    }

    // Aplicar descuento

    public void aplicarDescuento(Long id, Integer descuento)
            throws ValidationException {

        List<ErrorModel> errores = new ArrayList<>();

        if (id == null)
            errores.add(new ErrorModel("id", TipoErrorEnum.OBLIGATORIO));

        if (descuento == null || descuento < 0 || descuento > 100)
            errores.add(new ErrorModel("descuento", TipoErrorEnum.RANGO_INVALIDO));

        if (!errores.isEmpty())
            throw new ValidationException(errores);

        JuegoEntidad juego = juegoRepo.buscarPorId(id);

        if (juego == null) {
            errores.add(new ErrorModel("id", TipoErrorEnum.NO_ENCONTRADO));
            throw new ValidationException(errores);
        }
        juegoRepo.actualizar(juego.getIdJuego(), new JuegoForm(juego.getTitulo(), juego.getDescripcion(),
                                                juego.getDesarrollador(), juego.getFechaLanzamiento(),
                                                juego.getPrecioBase(), descuento,
                                                juego.getCategoria(), juego.getClasificacionPorEdad(),
                                                juego.getIdiomas(),  juego.getEstado()));
    }



    // Cambiar estado del juego

    public void cambiarEstado(Long id,
                                  EstadoJuegoEnum nuevoEstado)
            throws ValidationException {

        List<ErrorModel> errores = new ArrayList<>();

        if (id == null)
            errores.add(new ErrorModel("id", TipoErrorEnum.OBLIGATORIO));

        if (nuevoEstado == null)
            errores.add(new ErrorModel("estado", TipoErrorEnum.OBLIGATORIO));

        if (!errores.isEmpty())
            throw new ValidationException(errores);

        JuegoEntidad juego = juegoRepo.buscarPorId(id);

        if (juego == null) {
            errores.add(new ErrorModel("id", TipoErrorEnum.NO_ENCONTRADO));
            throw new ValidationException(errores);
        }

        juegoRepo.actualizar(juego.getIdJuego(), new JuegoForm(juego.getTitulo(), juego.getDescripcion(),
                juego.getDesarrollador(), juego.getFechaLanzamiento(),
                juego.getPrecioBase(), juego.getDescuento(),
                juego.getCategoria(), juego.getClasificacionPorEdad(),
                juego.getIdiomas(),  nuevoEstado));
    }

//    // Eliminar el juego
//
//    public boolean eliminar(Long id) {
//        return juegoRepo.eliminar(id);
//    }
}
