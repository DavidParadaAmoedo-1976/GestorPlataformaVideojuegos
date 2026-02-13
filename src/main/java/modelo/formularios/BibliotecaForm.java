package modelo.formularios;

public class BibliotecaForm {

    private Long idUsuario;
    private Long idJuego;

    public BibliotecaForm() {
    }

    public BibliotecaForm(Long idUsuario, Long idJuego) {
        this.idUsuario = idUsuario;
        this.idJuego = idJuego;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Long getIdJuego() {
        return idJuego;
    }
}

