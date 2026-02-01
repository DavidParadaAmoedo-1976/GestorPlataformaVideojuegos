package modelo.enums;

public enum TipoErrorEnum {

    OBLIGATORIO("Campo obligatorio"),
    FORMATO_INVALIDO("Formato inválido"),
    VALOR_NEGATIVO("Valor negativo"),
    LONGITUD_EXCEDIDA("Longitud excedida"),
    VALOR_EXCEDIDO("Valor excedido"),
    RANGO_INVALIDO("Fuera de rango"),
    OTRO("Otro"),
    DUPLICADO("Duplicado");

    private final String descripcion;

    TipoErrorEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String descripcion() {
        return descripcion;
    }
}

