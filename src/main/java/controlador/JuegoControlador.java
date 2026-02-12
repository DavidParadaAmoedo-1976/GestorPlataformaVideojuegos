package controlador;

import excepciones.ValidationException;
import modelo.dto.JuegoDto;
import modelo.entidades.JuegoEntidad;
import modelo.enums.ClasificacionJuegoEnum;
import modelo.enums.EstadoJuegoEnum;
import modelo.enums.OrdenarJuegosEnum;
import modelo.enums.TipoErrorEnum;
import modelo.formularios.JuegoForm;
import modelo.formularios.validaciones.ErrorModel;
import modelo.formularios.validaciones.JuegoFormValidador;
import modelo.mappers.JuegoEntidadADtoMapper;
import repositorio.interfaces.IJuegoRepo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class JuegoControlador {

    private final IJuegoRepo juegoRepo;

    public JuegoControlador(IJuegoRepo juegoRepo) {
        this.juegoRepo = juegoRepo;
    }

    // Crear Juego

    public JuegoDto crearJuego(JuegoForm form) throws ValidationException {

        JuegoFormValidador.validarJuego(form);

        JuegoEntidad entidad = juegoRepo.crear(form);

        return JuegoEntidadADtoMapper.juegoEntidadADto(entidad);
    }

    // Busqueda combinada

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

    // Mostrar juegos

    public List<JuegoDto> listarTodos(OrdenarJuegosEnum orden) {

        List<JuegoEntidad> juegos = juegoRepo.listarTodos();

        if (orden != null) {

            switch (orden) {

                case ALFABETICO -> juegos.sort(Comparator.comparing(JuegoEntidad::getTitulo));

                case PRECIO -> juegos.sort(Comparator.comparing(JuegoEntidad::getPrecioBase));

                case FECHA -> juegos.sort(Comparator.comparing(JuegoEntidad::getFechaLanzamiento));
            }
        }

        return juegos.stream()
                .map(JuegoEntidadADtoMapper::juegoEntidadADto)
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
            errores.add(new ErrorModel("id", TipoErrorEnum.OTRO));
            throw new ValidationException(errores);
        }

        return JuegoEntidadADtoMapper.juegoEntidadADto(juego);
    }

    // Aplicar descuento

    public JuegoDto aplicarDescuento(Long id, Integer descuento)
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
            errores.add(new ErrorModel("id", TipoErrorEnum.OTRO));
            throw new ValidationException(errores);
        }

        juego.setDescuento(descuento);

        return JuegoEntidadADtoMapper.juegoEntidadADto(juego);
    }

    // Modificar el estado del juego

    public JuegoDto cambiarEstado(Long id,
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
            errores.add(new ErrorModel("id", TipoErrorEnum.OTRO));
            throw new ValidationException(errores);
        }

        juego.setEstado(nuevoEstado);

        return JuegoEntidadADtoMapper.juegoEntidadADto(juego);
    }

    // Eliminar el juego

    public boolean eliminar(Long id) {
        return juegoRepo.eliminar(id);
    }
}
