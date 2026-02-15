package org.DavidParada.controlador;

import org.DavidParada.excepciones.ValidationException;
import org.DavidParada.modelo.dto.BibliotecaDto;
import org.DavidParada.modelo.dto.BibliotecaJuegoDto;
import org.DavidParada.modelo.entidades.BibliotecaEntidad;
import org.DavidParada.modelo.entidades.JuegoEntidad;
import org.DavidParada.modelo.entidades.UsuarioEntidad;
import org.DavidParada.modelo.enums.OrdenarJuegosBibliotecaEnum;
import org.DavidParada.modelo.enums.TipoErrorEnum;
import org.DavidParada.modelo.formularios.BibliotecaForm;
import org.DavidParada.modelo.formularios.validaciones.ErrorModel;
import org.DavidParada.modelo.mappers.BibliotecaEntidadADtoMapper;
import org.DavidParada.repositorio.interfaces.IBibliotecaRepo;
import org.DavidParada.repositorio.interfaces.IJuegoRepo;
import org.DavidParada.repositorio.interfaces.IUsuarioRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BibliotecaControlador {

    private final IBibliotecaRepo bibliotecaRepo;
    private final IUsuarioRepo usuarioRepo;
    private final IJuegoRepo juegoRepo;

    public BibliotecaControlador(IBibliotecaRepo bibliotecaRepo, IUsuarioRepo usuarioRepo, IJuegoRepo juegoRepo) {
        this.bibliotecaRepo = bibliotecaRepo;
        this.usuarioRepo = usuarioRepo;
        this.juegoRepo = juegoRepo;
    }

    // Ver Biblioteca personal

    public List<BibliotecaJuegoDto> verBiblioteca(Long idUsuario, OrdenarJuegosBibliotecaEnum orden) throws ValidationException {

        // Compruebo que idUsuario no sea nulo
        if (idUsuario == null) {
            throw new ValidationException(List.of(
                    new ErrorModel("usuario", TipoErrorEnum.OBLIGATORIO)
            ));
        }
        // Compruebo que exista el usuario.
        UsuarioEntidad usuario = usuarioRepo.buscarPorId(idUsuario);

        if (usuario == null) {
            throw new ValidationException(List.of(
                    new ErrorModel("usuario", TipoErrorEnum.NO_ENCONTRADO)
            ));
        }

        List<BibliotecaEntidad> juegosEntidad = bibliotecaRepo.buscarPorUsuario(idUsuario); // Guarda todos los juegos de la biblioteca del usuario en una lista.

        // Mapea la lista de Entidad a un DTO para poder mostrar los datos del juego
        List<BibliotecaJuegoDto> juegos = juegosEntidad.stream()
                .map(b -> {
                    JuegoEntidad juego = juegoRepo.buscarPorId(b.getIdJuego());
                    return new BibliotecaJuegoDto(juego.getTitulo(),
                            b.getFechaAdquisicion(),
                            b.getHorasDeJuego(),
                            b.getUltimaFechaDeJuego(),
                            b.isEstadoInstalacion());
                })
                .toList();

        // Ahora que tengo la lista de juegos en Dto para mostrar toca vver como la ordeno.

        if (orden != null) {        // Si la variable orden no es nula pasa al switch para ver como tiene que ordenar.

            switch (orden) {
                // Orden alfabetico
                case ALFABETICO -> juegos = juegos.stream()
                        .sorted(Comparator.comparing(b -> b.titulo()))
                        .toList();

                // Ordena por tiempo de Juego
                case TIEMPO_DE_JUEGO -> juegos = juegos.stream()
                        .sorted(Comparator.comparing((BibliotecaJuegoDto b) -> b.horasDeJuego()).reversed())
                        .toList();

                // Ordena por la última sesión
                case ULTIMA_SESION -> juegos = juegos.stream()
                        .sorted(Comparator.comparing((BibliotecaJuegoDto j) -> j.ultimaFechaDeJuego()).reversed())
                        .toList();

                // Ordena por fecha de adquisición
                case FECHA_DE_ADQUISICION -> juegos = juegos.stream()
                        .sorted(Comparator.comparing((BibliotecaJuegoDto b) -> b.fechaAdquisicion()).reversed())
                        .toList();
            }
        }
        return juegos;
    }

    // Añadir juego a biblioteca

    public BibliotecaDto anadirJuego(Long idUsuario, Long idJuego) throws ValidationException {

        List<ErrorModel> errores = new ArrayList<>();

        if (idUsuario == null) {
            errores.add(new ErrorModel("biblioteca", TipoErrorEnum.OBLIGATORIO));
        }

        UsuarioEntidad usuario = usuarioRepo.buscarPorId(idUsuario);

        if (usuario == null) {
            errores.add(new ErrorModel("usuario", TipoErrorEnum.NO_ENCONTRADO));
        }

        if (idJuego == null) {
            errores.add(new ErrorModel("juego", TipoErrorEnum.OBLIGATORIO));
        }

        JuegoEntidad juego = juegoRepo.buscarPorId(idJuego);

        if (juego == null) {
            errores.add(new ErrorModel("juego", TipoErrorEnum.NO_ENCONTRADO));
        }

        if (!errores.isEmpty()) {
            throw new ValidationException(errores);
        }

        List<BibliotecaEntidad> bibliotecasEntidad = bibliotecaRepo.buscarPorUsuario(idUsuario);

        Boolean yaTieneJuego = bibliotecasEntidad.stream().anyMatch(b -> b.getIdJuego().equals(idJuego));

        if (yaTieneJuego) {
            errores.add(new ErrorModel("juego", TipoErrorEnum.DUPLICADO));
            throw new ValidationException(errores);
        }

        BibliotecaForm nuevoJuego = new BibliotecaForm(
                idUsuario,
                idJuego,
                LocalDate.now(),
                0.0,
                null,
                false
        );

        BibliotecaEntidad nuevoJuegoEntidad = (BibliotecaEntidad) bibliotecaRepo.crear(nuevoJuego);

        return BibliotecaEntidadADtoMapper.bibliotecaEntidadADto(nuevoJuegoEntidad);
    }

    // Eliminar juego de biblioteca

    public void eliminarJuego(Long idUsuario, Long idJuego) throws ValidationException {

        List<ErrorModel> errores = new ArrayList<>();

        if (idUsuario == null) {
            errores.add(new ErrorModel("usuario", TipoErrorEnum.OBLIGATORIO));
        }
        if (idJuego == null) {
            errores.add(new ErrorModel("juego", TipoErrorEnum.OBLIGATORIO));
        }

        if (errores.isEmpty()) {
            throw new ValidationException(errores);
        }

        BibliotecaEntidad bibliotecaEntidad = bibliotecaRepo.buscarPorUsuarioYJuego(idUsuario, idJuego);

        if (bibliotecaEntidad == null) {
            errores.add(new ErrorModel("juego", TipoErrorEnum.NO_ENCONTRADO));
            throw new ValidationException(errores);
        }
        bibliotecaRepo.eliminar(bibliotecaEntidad.getIdBiblioteca());
    }

    // Actualizar tiempo de juego


    // Consultar última sesión


    // Filtrar biblioteca


    // Ver estadísticas de biblioteca


}
