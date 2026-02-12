import modelo.formularios.validaciones.JuegoFormValidador;
import repositorio.implementacionMemoria.JuegoRepo;

public class Program {

    static void main(String[] args) {
        JuegoRepo juegoRepo = new JuegoRepo();
        JuegoFormValidador.setJuegoRepo(juegoRepo);

    }
}
