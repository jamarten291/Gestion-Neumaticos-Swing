
package controlador;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 * @author jamarten291
 * @version 22 nov 2025
 */
public class HelperClass {

    public static void lanzarAlerta(String titulo, String mensaje, int tipo, Component c) {
        JOptionPane.showMessageDialog(c, mensaje, titulo, tipo);
    }
    
    public static boolean tryParseToInt(String num) {
        try {
            Integer.valueOf(num);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    public static boolean tryParseToDouble(String num) {
        try {
            Double.valueOf(num);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    public static String dateToString(LocalDate date) {
        String fecha;
        // El campo en el que se introduce la cadena debe ser tipo varchar(10)
        SimpleDateFormat formatPattern = new SimpleDateFormat("dd-MM-yyyy");
        fecha = formatPattern.format(date);
        
        return fecha;
    }
    
}
