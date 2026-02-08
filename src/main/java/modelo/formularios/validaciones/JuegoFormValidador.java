package modelo.formularios.validaciones;

import excepciones.ValidationException;
import modelo.dto.JuegoDto;
import modelo.enums.TipoErrorEnum;
import modelo.formularios.JuegoForm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JuegoFormValidador {


private JuegoFormValidador(){}
    public static void validarJuego(JuegoForm form) throws ValidationException{

        List<ErrorModel> errores = new ArrayList<>();

        if (form == null) {
            errores.add(new ErrorModel("form", TipoErrorEnum.OTRO));
            throw new ValidationException(errores);
        }

    // Titulo
    ValidacionesComunes.obligatorio("titulo",form.getTitulo(),errores);
    ValidacionesComunes.LongitudMinima("titulo", form.getTitulo(), 1, errores);
    ValidacionesComunes.LongitudMaxima("titulo", form.getTitulo(), 100, errores);


    // Descripcion
    ValidacionesComunes.LongitudMaxima("descripcion", form.getDescripcion(), 2000, errores);

    // Desarrollador
    ValidacionesComunes.obligatorio("desarrollador", form.getDesarrollador(), errores);
    ValidacionesComunes.LongitudMinima("desarrollador", form.getDesarrollador(), 2, errores);
    ValidacionesComunes.LongitudMaxima("desarrollador", form.getDesarrollador(), 100, errores);

    // Fecha de Lanzamiento
    validarFechaLanzamiento(form.getFechaLanzamiento(), errores);

    // Precio base
    validarPrecioBase(form.getPrecioBase(), errores);
    ValidacionesComunes.valorNoNegativo("precioBase", form.getPrecioBase(), errores);
    ValidacionesComunes.

    }

    private static void validarPrecioBase(Double precioBase, List<ErrorModel> errores) {
        if (precioBase == null){
            errores.add(new ErrorModel("precioBase", TipoErrorEnum.OBLIGATORIO));
        }
    }

    private static void validarFechaLanzamiento(LocalDate fechaLanzamiento, List<ErrorModel> errores) {
        if (fechaLanzamiento == null) {
            errores.add(new ErrorModel("fechaLanzamiento", TipoErrorEnum.OBLIGATORIO));
        }
    }


}
