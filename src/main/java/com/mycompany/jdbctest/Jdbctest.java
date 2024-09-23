package com.mycompany.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

 // @author Enderson Ariza
 
public class Jdbctest {

    public static void main(String[] args) {
        String usuario="root";
        String password="";
        String url="jdbc:mysql://localhost:3306/jdbctest";
        
            Connection conexion;
            Statement statement;
            ResultSet rs; 
            
        try {  
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));  
           } 
            
              // insertar Datos
            statement.execute("INSERT INTO `usuarios` (`id`, `nombre`) VALUES (NULL, 'Z_parda'); ");
            System.out.println(""); // lo dejamos vacio para un salto de linea 
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));  
              }

           
        } catch (SQLException ex) {
            Logger.getLogger(Jdbctest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

