
package controlador;

import java.awt.Component;
import javax.swing.JOptionPane;
import vista.Login;

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
    
}
