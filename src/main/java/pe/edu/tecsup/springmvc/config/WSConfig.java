/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.tecsup.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

/**
 *
 * @author PCC
 */
@Configuration
public class WSConfig {
    
    @Bean
    public SimpleJaxWsServiceExporter jaxWS(){
        
        SimpleJaxWsServiceExporter sjwse = new SimpleJaxWsServiceExporter();
        sjwse.setBaseAddress("http://localhost:8081/");
        return sjwse;
        
    }
    
}
