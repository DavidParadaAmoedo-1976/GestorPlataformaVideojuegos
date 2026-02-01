package modelo.formularios.validaciones;

import modelo.enums.TipoErrorEnum;

public record ErrorModel(String campo, TipoErrorEnum error) {
}
