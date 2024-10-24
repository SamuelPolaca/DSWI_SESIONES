/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author IDAT
 */
public class ConeccionMysql {
    public Connection conectar(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Prueba?useSSL=false";
            String user = "root";
            String password = "123456";
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException  ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch(ClassNotFoundException ex){
            System.out.println("Error: " + ex.getMessage());
        } catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    return con;
    }
    
    
}
