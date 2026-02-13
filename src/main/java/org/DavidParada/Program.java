package org.DavidParada;

import org.DavidParada.controlador.UsuarioControlador;
import org.DavidParada.modelo.formularios.validaciones.JuegoFormValidador;
import org.DavidParada.modelo.formularios.validaciones.UsuarioFormValidador;
import org.DavidParada.repositorio.implementacionMemoria.JuegoRepo;
import org.DavidParada.repositorio.implementacionMemoria.UsuarioRepo;

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

        // Aquí iría tu org.DavidParada.vista o pruebas
    }

}

