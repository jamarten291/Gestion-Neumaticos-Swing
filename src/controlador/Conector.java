
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jamarten291
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
    
    public boolean inicioSesion(String nombre, String password) {
        boolean flag = false;
        
        String query = "SELECT * FROM acceso "
                     + "WHERE nombre = ? AND password = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            System.getLogger(Conector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return flag;
    }
    
    public boolean registrarUsuario(String nombre, String password) {
        boolean flag = false;
        
        String query = "INSERT INTO acceso (nombre, password) "
                     + "VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, password);
            ps.execute();
            flag = true;
        } catch (SQLException ex) {
            System.getLogger(Conector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return flag;
    }
}