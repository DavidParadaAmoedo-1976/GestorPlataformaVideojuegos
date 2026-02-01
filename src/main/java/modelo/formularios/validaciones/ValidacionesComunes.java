package modelo.formularios.validaciones;

import modelo.enums.TipoErrorEnum;

import java.util.List;

public class ValidacionesComunes {

    private ValidacionesComunes() {
    }

    public static void obligatorio(String campo, String valor, List<ErrorModel> errores) {
        if (valor == null || valor.isBlank()) {
            errores.add(new ErrorModel(campo, TipoErrorEnum.OBLIGATORIO));
        }
    }

    public static void longitudMaxima(String campo, String valor, int max, List<ErrorModel> errores) {
        if (valor != null && valor.length() > max) {
            errores.add(new ErrorModel(campo, TipoErrorEnum.LONGITUD_EXCEDIDA));
        }
    }

    public static void longitudMinima(String campo, String valor, int min, List<ErrorModel> errores) {
        if (valor != null && valor.length() < min) {
            errores.add(new ErrorModel(campo, TipoErrorEnum.RANGO_INVALIDO));
        }
    }

    public static void valorNoNegativo(String campo, double valor, List<ErrorModel> errores) {
        if (valor < 0) {
            errores.add(new ErrorModel(campo, TipoErrorEnum.VALOR_NEGATIVO));
        }
    }


}

