import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class GestorFacturas {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

class Factura {
    private String numeroFactura, concepto;
    private double base, iva;
    private LocalDate fecha = LocalDate.now();

    public Factura() {
        this.numeroFactura = generarNumeroFactura();
        this.fecha = LocalDate.now();
        this.concepto = "";
        this.base = 0;
        this.iva = 0;
    }

    public Factura(LocalDate fecha, String concepto, double base, double iva, double porciento) {
        this.numeroFactura = generarNumeroFactura();
        this.fecha = fecha;
        this.concepto = concepto;
        this.base = base;
        this.iva = iva;
    }

    // Métodos propios
    public String generarNumeroFactura() {
        Random random = new Random();
        int nRandom = random.nextInt(10000);

        String resultado = String.format("FACT-%04d", nRandom);

        return resultado;
    }

    public double calcularTotal() {
        return base + base * iva / 100.0;
    }

    public boolean aplicarDescuento(double porcentaje) {
        if (porcentaje >= 0 && porcentaje <= 100) {
            this.base = this.base * (porcentaje / 100);
            return true;
        } else {
            return false;
        }
    }

    public String getFecha() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(formato);
    }

    public boolean esAntigua() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(getFecha(), formato);
        LocalDate inicio = LocalDate.of(getFecha());
        return true;
    }

    public void imprimirFactura() {
        System.out.println("-------------------" + this.numeroFactura);
        System.out.println("                   " + getFecha());
        System.out.println("\nConcepto:");
        System.out.println("\t" + this.concepto + "\n");
        System.out.println("              base " + getBase());
        System.out.println("               iva " + getIva());
        System.out.println("             total " + calcularTotal());
        System.out.println("-------------------\n");
        

    }

    // Getter y setter
    public String getNumeroFactura() {
        return numeroFactura;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFechaLD() {
        return fecha;
    }

}
