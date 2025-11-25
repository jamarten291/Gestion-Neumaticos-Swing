
package modelo;

/**
 * @author jamarten291
 * @version 25 nov 2025
 */
public class Factura {
    private int numFactura;
    private String nifCliente;
    private String nifEmisor;
    private String fechaSistema;
    private double base;
    private double iva;
    private double total;
    private boolean pagada;
    private String numCuenta;

    public Factura(int numFactura, String nifCliente, String nifEmisor, String fechaSistema, double base, double iva, double total, boolean pagada, String numCuenta) {
        this.numFactura = numFactura;
        this.nifCliente = nifCliente;
        this.nifEmisor = nifEmisor;
        this.fechaSistema = fechaSistema;
        this.base = base;
        this.iva = iva;
        this.total = total;
        this.pagada = pagada;
        this.numCuenta = numCuenta;
    }

    public Factura(String nifCliente, String nifEmisor, String fechaSistema, double base, double iva, double total, boolean pagada, String numCuenta) {
        this.nifCliente = nifCliente;
        this.nifEmisor = nifEmisor;
        this.fechaSistema = fechaSistema;
        this.base = base;
        this.iva = iva;
        this.total = total;
        this.pagada = pagada;
        this.numCuenta = numCuenta;
    }
    
    

    public int getNumFactura() {
        return numFactura;
    }

    public String getNifCliente() {
        return nifCliente;
    }

    public String getNifEmisor() {
        return nifEmisor;
    }

    public String getFechaSistema() {
        return fechaSistema;
    }

    public double getBase() {
        return base;
    }

    public double getIva() {
        return iva;
    }

    public double getTotal() {
        return total;
    }

    public boolean isPagada() {
        return pagada;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    @Override
    public String toString() {
        return "Factura{" + "numFactura=" + numFactura + ", nifCliente=" + nifCliente + ", nifEmisor=" + nifEmisor + ", fechaSistema=" + fechaSistema + ", base=" + base + ", iva=" + iva + ", total=" + total + ", pagada=" + pagada + ", numCuenta=" + numCuenta + '}';
    }

}
