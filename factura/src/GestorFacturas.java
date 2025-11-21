import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class GestorFacturas {
    public static Factura pedirDatos(Scanner sc, double iva) {
        LocalDate fechaFact;
        double descuento = 0;

        System.out.println("\nDame el concepto: ");
        String concepto = sc.nextLine();
        System.out.println("Dame el precio base: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.println("La fecha es de hoy (s/n)? ");

        if (sc.nextLine().equals("n")) {
            System.out.println("Dame la fecha (dd/MM/yyyy): ");
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            fechaFact = LocalDate.parse(sc.nextLine(), formato);
        } else {
            fechaFact = LocalDate.now();
        }
        System.out.println("Quieres aplicar descuento (s/n)? ");
        if (sc.nextLine().equals("s")) {
            System.out.println("Dime el descuento: ");
            descuento = Double.parseDouble(sc.nextLine());
        }
        Factura fact = new Factura(fechaFact, concepto, precio, iva);
        if (descuento > 0)
            fact.aplicarDescuento(descuento);

        return fact;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opc;
        Factura f = null;

        do {
            System.out.println("\n=== LIBRERÍA \"EL SABER\" - SISTEMA DE FACTURACIÓN ===");
            System.out.println("1. Crear factura de libro");
            System.out.println("2. Crear factura de material escolar");
            System.out.println("3. Mostrar factura");
            System.out.println("\n0. Salir");
            System.out.println("====================================================");
            System.out.print("\tSeleccione opción: ");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    f = pedirDatos(sc, 4);
                    break;

                case 2:
                    f = pedirDatos(sc, 21);
                    break;

                case 3:
                    f.imprimirFactura();
                    break;
            }

        } while (opc != 0);
        sc.close();
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

    public Factura(LocalDate fecha, String concepto, double base, double iva) {
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
            this.base = this.base - this.base * (porcentaje / 100);
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
        LocalDate fechaComparar = LocalDate.now().minusDays(31);
        return fecha.isBefore(fechaComparar);

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
