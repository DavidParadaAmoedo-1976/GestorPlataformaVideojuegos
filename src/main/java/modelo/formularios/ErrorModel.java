package modelo.formularios;

import modelo.enums.TipoErrorEnum;

public record ErrorModel(String campo, TipoErrorEnum error) {
}
