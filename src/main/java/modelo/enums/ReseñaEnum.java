package modelo.enums;

public enum ReseñaEnum {

    SALIR("Salir"),
    PUBLICADA("Publicada"),
    OCULTA("Oculta"),
    ELIMINADA("Eliminada");

    private final String TEXTO;

    ReseñaEnum(String TEXTO) {
        this.TEXTO = TEXTO;
    }

    public String getTexto() {
        return TEXTO;
    }
}

