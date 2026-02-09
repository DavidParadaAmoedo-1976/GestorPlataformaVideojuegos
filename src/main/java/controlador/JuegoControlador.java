package controlador;

import excepciones.ValidationException;
import modelo.dto.JuegoDto;
import modelo.entidades.JuegoEntidad;
import modelo.enums.TipoErrorEnum;
import modelo.formularios.JuegoForm;
import modelo.formularios.validaciones.ErrorModel;
import modelo.formularios.validaciones.JuegoFormValidador;
import modelo.mappers.JuegoEntidadADtoMapper;
import repositorio.implementacionMemoria.JuegoRepo;
import repositorio.interfaces.IJuegoRepo;

import java.util.ArrayList;
import java.util.List;

public class JuegoControlador {
    private final IJuegoRepo juegoRepo;

    public JuegoControlador(IJuegoRepo juegoRepo) {
        this.juegoRepo = juegoRepo;
    }

    // Crear usuario
    public JuegoDto crearJuego(JuegoForm juegoForm) throws ValidationException {
        JuegoFormValidador.validarJuego(juegoForm);

        List<ErrorModel>  errores = new ArrayList<>();

        if (juegoRepo.buscarPorTitulo(juegoForm.getTitulo()) != null) {
            errores.add(new ErrorModel("titulo", TipoErrorEnum.DUPLICADO));
        }
        if (!errores.isEmpty()) {
            throw new ValidationException(errores);
        }
        return JuegoEntidadADtoMapper.juegoEntidadADto(juegoRepo.crear(juegoForm));
    }
    // Buscar por id
    public JuegoDto buscarJuegoPorId(Long id) throws ValidationException {
        JuegoEntidad juegoEntidad = juegoRepo.buscarPorId(id);
        return JuegoEntidadADtoMapper.juegoEntidadADto(juegoEntidad);
    }

    public JuegoDto buscarJuegoPorTitulo(String titulo) throws ValidationException {
        JuegoEntidad juegoEntidad = juegoRepo.buscarPorTitulo(titulo);
        return JuegoEntidadADtoMapper.juegoEntidadADto(juegoEntidad);
    }

    public JuegoDto buscarJuegosPorRangoDePrecio(Double precioMin, Double precioMax) throws ValidationException {
        JuegoEntidad juegoEntidad
    }
}
