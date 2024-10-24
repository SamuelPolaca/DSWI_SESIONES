/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.dao;

import com.idat.entity.Persona;
import java.util.List;

/**
 *
 * @author IDAT
 */
public interface IPersonaDao {
     public int operacionesEcritura(String indicador, Persona P);
    public List<Persona>operacionesLectura(String indicador, Persona P);     
    
}
