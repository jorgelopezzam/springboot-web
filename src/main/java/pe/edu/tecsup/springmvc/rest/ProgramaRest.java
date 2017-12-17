/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.tecsup.springmvc.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author PCC
 */
@Controller
@RequestMapping("rest")
public class ProgramaRest {
    
    @Autowired
    ProgramaService programaService;
    
@ResponseBody
@RequestMapping(value = "programa/{id}",
method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public Programa findById(@PathVariable("id") Long programa) {
System.out.println("Obtener por id: " + programa);
return programaService.findPrograma(programa);
}
@ResponseBody
@RequestMapping(value = "programa/{id}",
method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
public Map<String, Object> eliminar(@PathVariable("id") Long programa) {
System.out.println("Dentro de eliminar(): ");
Map<String, Object> resultado = new HashMap();
try {
programaService.deletePrograma(programa);
resultado.put("estado", true);
} catch (Exception e) {
resultado.put("estado", false);
System.out.println(e.getMessage());
}
return resultado;
}

@ResponseBody
@RequestMapping(value = "programa/save",
consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
public Map<String, Object> insertar(@RequestParam("programa") Programa programa) {
System.out.println("Dentro de insertar: " + programa.getNombre());
Map<String, Object> resultado = new HashMap();
try {
programaService.guardarPrograma(programa);
resultado.put("estado", true);
} catch (Exception e) {
resultado.put("estado", false);
System.out.println(e.getMessage());
}
return resultado;
}
@ResponseBody
@RequestMapping(value = "programa/save",
method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
public Map<String, Object> actualizar(@RequestParam("programa") Programa programa) {
System.out.println("Dentro de actualizar: " + programa.getNombre());
Map<String, Object> resultado = new HashMap();
try {
programaService.guardarPrograma(programa);
resultado.put("estado", true);
} catch (Exception e) {
resultado.put("estado", false);
System.out.println(e.getMessage());
}
return resultado;
}
@ResponseBody
@RequestMapping(value=“programa”, smethod = RequestMethod.GET,
produces = MediaType.APPLICATION_JSON_VALUE)
public List<Programa> list() {
return service.listPrograma();
}
    
}
