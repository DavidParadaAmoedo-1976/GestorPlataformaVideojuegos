package modelo.enums;

public enum EstadoCompraEnum {

    SALIR("Salir"),
    COMPLETADA("Completada"),
    REEMBOLSADA("Reembolsada");

    private final String TEXTO;

    EstadoCompraEnum(String TEXTO) {
        this.TEXTO = TEXTO;
    }

    public String getTexto() {
        return TEXTO;
    }
}

