package repositorio.interfaces;

import modelo.entidades.JuegoEntidad;
import modelo.formularios.JuegoForm;

import java.util.List;

public interface IJuegoRepo extends ICrud<JuegoEntidad, JuegoForm, Long> {

    JuegoEntidad buscarPorTitulo(String titulo);

    List<JuegoEntidad> buscarPorCategoria(String categoria);

    List<JuegoEntidad> buscarPorPrecio(Double precioMin, Double precioMax);

}
