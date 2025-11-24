
package modelo;

/**
 *
 * @author jamarten291
 */
public class Neumatico {
    private int codigo;
    private String marca;
    private String modelo;
    private int ancho;
    private Perfil perfil;
    private double precio;

    public Neumatico(int codigo, String marca, String modelo, int ancho, String perfil, double precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.ancho = ancho;
        this.perfil = stringToPerfil(perfil);
        this.precio = precio;
    }
    
    private Perfil stringToPerfil(String perfil) {
        return switch (perfil.toUpperCase().trim()) {
            case "BAJO" -> Perfil.BAJO;
            case "MEDIO" -> Perfil.MEDIO;
            case "ALTO" -> Perfil.ALTO;
            default -> null;
        };
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public Perfil getPerfil() {
        return perfil;
    }
    
    public String getPerfilStr() {
        return switch (this.getPerfil()) {
            case ALTO -> "ALTO";
            case MEDIO -> "MEDIO";
            case BAJO -> "BAJO";
            default -> null;
        };
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Neumatico{" + "codigo=" + codigo + ", marca=" + marca + ", modelo=" + modelo + ", ancho=" + ancho + ", perfil=" + perfil + ", precio=" + precio + '}';
    }
    
}
