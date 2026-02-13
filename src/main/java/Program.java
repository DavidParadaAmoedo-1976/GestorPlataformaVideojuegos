import controlador.UsuarioControlador;
import modelo.formularios.validaciones.JuegoFormValidador;
import modelo.formularios.validaciones.UsuarioFormValidador;
import repositorio.implementacionMemoria.JuegoRepo;
import repositorio.implementacionMemoria.UsuarioRepo;

public class Program {

    public static void main(String[] args) {

        // Repositorios
        JuegoRepo juegoRepo = new JuegoRepo();
        UsuarioRepo usuarioRepo = new UsuarioRepo();

        // Inyección en validadores
        JuegoFormValidador.setJuegoRepo(juegoRepo);
        UsuarioFormValidador.setUsuarioRepo(usuarioRepo);

        // Controladores
        UsuarioControlador usuarioControlador =
                new UsuarioControlador(usuarioRepo);

        // Aquí iría tu vista o pruebas
    }
}

