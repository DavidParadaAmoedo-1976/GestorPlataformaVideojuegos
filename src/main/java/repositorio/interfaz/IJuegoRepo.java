package repositorio.interfaz;

import modelo.entidades.JuegoEntidad;
import modelo.formularios.JuegoForm;

import java.time.LocalDate;

public interface IJuegoRepo extends ICrud<JuegoEntidad, JuegoForm, Long>{

    JuegoEntidad buscarPorTitulo(String titulo);

    JuegoEntidad buscarPorCategoria(String categoria);

    JuegoEntidad buscarPorPrecio(Double precio);




}
