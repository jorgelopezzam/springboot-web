/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.tecsup.springmvc.controller.programa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.tecsup.springmvc.dao.ProgramaDAO;
import pe.edu.tecsup.springmvc.model.Programa;

/**
 *
 * @author jlopez
 */
@Service
@Transactional
public class ProgramaServiceImpl implements ProgramaService {
    
    @Autowired
    ProgramaDAO programaDAO;

    @Override
    public List<Programa> allPrograma() {
        return programaDAO.list();
    }

    @Override
    public Programa find(Long id) {
        return programaDAO.get(id);
    }

    @Override
    public void save(Programa programa) {
        if(programa.getId() == null){
            programaDAO.save(programa);
        } else {
            programaDAO.update(programa);
        }
    }
 
    @Override
    public void delete(Long id) {
        programaDAO.delete(new Programa(id));
    }
    
}
