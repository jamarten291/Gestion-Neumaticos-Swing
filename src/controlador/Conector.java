
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Neumatico;

/**
 *
 * @author jamarten291
 */
public class Conector {
    private static final String DATABASE = "neumaticos";
    private static final String URL = "jdbc:mysql://localhost/";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";
    
    private Connection conn;

    public Conector() {

    }
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL + DATABASE, LOGIN, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.getLogger(Conector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
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
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, password);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            System.getLogger(Conector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.getLogger(Conector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        
        return flag;
    }
    
    public boolean registrarUsuario(String nombre, String password) {
        boolean flag = false;
        
        String query = "INSERT INTO acceso (nombre, password) VALUES (?, ?)";
        PreparedStatement ps = null;
        
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, password);
            int filas = ps.executeUpdate();
            
            if (filas > 0) {
                flag = true;
            }
        } catch (SQLException ex) {
            System.getLogger(Conector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.getLogger(Conector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        
        return flag;
    }
    
    public boolean altaNeumatico(Neumatico n) {
        boolean flag = false;
        
        String query = "INSERT INTO neumatico VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, n.getCodigo());
            ps.setString(2, n.getMarca());
            ps.setString(3, n.getModelo());
            ps.setInt(4, n.getAncho());
            ps.setString(5, n.getPerfilStr());
            ps.setDouble(6, n.getPrecio());
            int filas = ps.executeUpdate();
            
            if (filas > 0) {
                flag = true;
            }
        } catch (SQLException ex) {
            System.getLogger(Conector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.getLogger(Conector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        
        return flag;
    }
    
    public List<Neumatico> listarNeumaticos() {
        List<Neumatico> listaNeumaticos = new ArrayList<>();
        
        String query = "SELECT * FROM neumatico";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Neumatico n = new Neumatico(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDouble(6)
                );
                listaNeumaticos.add(n);
            }
        } catch (SQLException ex) {
            System.getLogger(Conector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.getLogger(Conector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        return listaNeumaticos;
    }
    
    public boolean actualizarNeumatico(Neumatico n) {
        boolean flag = false;
        
        String query = "UPDATE neumatico "
                + "SET marca=?, modelo=?, ancho=?, perfil=?, precio=?"
                + "WHERE cod=?";
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            
            ps.setString(1, n.getMarca());
            ps.setString(2, n.getModelo());
            ps.setInt(3, n.getAncho());
            ps.setString(4, n.getPerfilStr());
            ps.setDouble(5, n.getPrecio());
            ps.setInt(6, n.getCodigo());
            int filas = ps.executeUpdate();
            
            if (filas > 0) {
                flag = true;
            }
        } catch (SQLException ex) {
            System.getLogger(Conector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.getLogger(Conector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        
        return flag;
    }
    
    public boolean borrarNeumatico(int cod) {
        boolean flag = false;
        
        String query = "DELETE FROM neumatico "
                    + "WHERE cod=?";
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cod);
            int filas = ps.executeUpdate();
            
            if (filas > 0) {
                flag = true;
            }
        } catch (SQLException ex) {
            System.getLogger(Conector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.getLogger(Conector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        return flag;
    }
}