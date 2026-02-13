package org.DavidParada.modelo.formularios.validaciones;

import org.DavidParada.modelo.enums.TipoErrorEnum;

public record ErrorModel(String campo, TipoErrorEnum error) {
}
