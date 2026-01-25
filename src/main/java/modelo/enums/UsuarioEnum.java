package modelo.enums;

public enum UsuarioEnum {

    SALIR("Salir"),
    ACTIVA("Activa"),
    SUSPENDIDA("Suspendida"),
    BANEADA("Baneada");


    private final String TEXTO;

    UsuarioEnum(String TEXTO) {
        this.TEXTO = TEXTO;
    }

    public String getTexto() {
        return TEXTO;
    }
}

