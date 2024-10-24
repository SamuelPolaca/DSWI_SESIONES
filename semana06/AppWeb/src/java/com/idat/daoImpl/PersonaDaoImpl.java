/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.daoImpl;

import com.idat.dao.IPersonaDao;
import com.idat.entity.Persona;
import com.idat.repository.ConeccionMysql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IDAT
 */
public class PersonaDaoImpl implements IPersonaDao {

    @Override
    public int operacionesEcritura(String indicador, Persona p) {
        ConeccionMysql connection = new ConeccionMysql();
        Connection con = null;
        CallableStatement cst = null;
        int procesar = -1;
        String procedimiento = "{call usp_persona_crud (?,?,?,?)}";

        try {
            con = connection.conectar();
            cst = con.prepareCall(procedimiento);
            cst.setString(1, indicador);
            cst.setInt(2, p.getCodigo());
            cst.setString(3, p.getNombre());
            cst.setString(4, p.getApellido());

        } catch (Exception ex) {
            System.out.println("OperacionEsccritura = Error" + ex.getMessage());
        } finally {
            try {
                if (cst != null) {
                    cst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override

    public List<Persona> operacionesLectura(String indicador, Persona p) {
        ConeccionMysql connection = new ConeccionMysql();
        Connection con = null;
        CallableStatement cst = null;
        ResultSet rs = null;
        List<Persona> lista = new ArrayList();

        String procedimiento = "{call usp_persona_crud (?,?,?,?)}";

        try {
            con = connection.conectar();
            cst = con.prepareCall(procedimiento);
            cst.setString(1, indicador);
            cst.setInt(2, p.getCodigo());
            cst.setString(3, p.getNombre());
            cst.setString(4, p.getApellido());

            rs = cst.executeQuery();
            Persona objPersona;
            while (rs.next()) {
                objPersona = new Persona();
                objPersona.setCodigo(rs.getInt(1));
                objPersona.setNombre(rs.getString(2));
                objPersona.setApellido(rs.getString(3));
                lista.add(objPersona);
            }
        } catch (SQLException ex) {
            System.out.println("OperacionEsccritura = Error" + ex.getMessage());
        } finally {
            try {
                if (cst != null) {
                    cst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return lista;

    }

}
