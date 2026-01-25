package modelo.enums;

public enum PagoEnum {


    SALIR("Salir"),
    TARJETA_CREDITO("Tarjeta de Credito"),
    PAYPAL("Paypal"),
    CARTERA_STEAM("Cartera de Steam"),
    TRANSFERENCIA("Transferencia bancaria"),
    ;

    private final String TEXTO;

    PagoEnum(String TEXTO) {
        this.TEXTO = TEXTO;
    }

    public String getTexto() {
        return TEXTO;
    }
}

