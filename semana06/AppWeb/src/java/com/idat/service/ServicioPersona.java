/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idat.service;

import com.idat.dao.IPersonaDao;
import com.idat.daoImpl.PersonaDaoImpl;
import com.idat.entity.Persona;
import java.util.List;

/**
 *
 * @author IDAT
 */
public class ServicioPersona {
    public int operacionesEscritura(String indicador, Persona p){
        IPersonaDao dao= new PersonaDaoImpl();
        return dao.operacionesEcritura(indicador, p);
    }
    
    public List<Persona> operacionesLectura(String indicador, Persona p){
        IPersonaDao dao= new PersonaDaoImpl();
        return dao.operacionesLectura(indicador, p);
    }
    
}
