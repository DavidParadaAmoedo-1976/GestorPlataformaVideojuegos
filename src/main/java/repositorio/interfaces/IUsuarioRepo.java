package repositorio.interfaces;

import modelo.entidades.UsuarioEntidad;
import modelo.formularios.UsuarioForm;


public interface IUsuarioRepo extends ICrud<UsuarioEntidad, UsuarioForm, Long> {

    UsuarioEntidad buscarPorEmail(String email);

    UsuarioEntidad buscarPorNombreUsuario(String nombreUsuario);

}

