package com.mycompany.appdeporttests;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author SENA
 */
import java.sql.Connection; // Importa la clase Connection de java.sql
//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class Conection {
    
    public Connection con; 
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "1234";
    private static final String url = "jdbc:mysql://localhost:3306/sportsdb";
    
    public void connect(){
        con = null;
        try{
            Class.forName(Driver); 
            con = DriverManager.getConnection(url, user, pass);
            if(con != null){
                System.out.println("Connection completed");
                JOptionPane.showMessageDialog(null, "connection completed");
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: "+e);
        }
    }
    
    
}