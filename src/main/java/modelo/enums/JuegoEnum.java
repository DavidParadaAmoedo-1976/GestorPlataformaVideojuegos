package modelo.enums;

public enum JuegoEnum {

    SALIR("Salir"),
    NO_DISPONIBLE("No disponible"),
    DISPONIBLE("Disponible"),
    PREVENTA("Preventa"),
    ACCESO_ANTICIPADO("Acceso Anticipado");

    private final String TEXTO;

    JuegoEnum(String TEXTO) {
        this.TEXTO = TEXTO;
    }

    public String getTexto() {
        return TEXTO;
    }
}

