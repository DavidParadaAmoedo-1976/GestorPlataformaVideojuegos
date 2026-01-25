package modelo.enums;

public enum IdiomaEnum {


    SALIR("Salir"),
    ESPAÑOL("Español"),
    INGLES("Ingles"),
    FRANCES("Frances"),
    ALEMAN("Aleman");


    private final String TEXTO;

    IdiomaEnum(String TEXTO) {
        this.TEXTO = TEXTO;
    }

    public String getTexto() {
        return TEXTO;
    }
}

