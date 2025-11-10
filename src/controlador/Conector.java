/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jacksonmh16
 */
public class Conector {
    private final String DATABASE = "neumaticos";
    private final String URL = "jdbc:mysql://localhost/";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String LOGIN = "root";
    private final String PASSWORD = "";
    
    private Connection conn;

    public Conector() {

    }
    
    public boolean conectar() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL + DATABASE, LOGIN, PASSWORD);
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.getLogger(Conector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }
}