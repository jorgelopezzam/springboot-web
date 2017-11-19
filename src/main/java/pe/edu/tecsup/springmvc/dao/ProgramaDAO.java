package pe.edu.tecsup.springmvc.dao;


import java.util.List;
import pe.edu.tecsup.springmvc.helper.GenericDAO;
import pe.edu.tecsup.springmvc.model.Programa;

public interface ProgramaDAO extends GenericDAO<Programa> {
    
    Programa getByCodigo(String Codigo);
    
    List<Programa> getByNombre(String nombre);

}
