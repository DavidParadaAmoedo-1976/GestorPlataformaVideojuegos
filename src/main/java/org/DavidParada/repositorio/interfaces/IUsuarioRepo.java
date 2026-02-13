package org.DavidParada.repositorio.interfaces;

import org.DavidParada.modelo.entidades.UsuarioEntidad;
import org.DavidParada.modelo.formularios.UsuarioForm;


public interface IUsuarioRepo extends ICrud<UsuarioEntidad, UsuarioForm, Long> {

    UsuarioEntidad buscarPorEmail(String email);

    UsuarioEntidad buscarPorNombreUsuario(String nombreUsuario);

}

