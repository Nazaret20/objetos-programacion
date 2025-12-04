import java.util.Scanner;

public class AppGestionPrestamos {
    public static int menu(Scanner sc) {
        System.out.println(
            "\n=== BANCO MICRÉDITO - SIMULADOR DE PRÉSTAMOS ===\r\n" + //
            "\r\n" + //
            "1. Ver información de todos los préstamos\r\n" + //
            "2. Evaluar solicitud de préstamo\r\n" + //
            "3. Modificar condiciones de préstamo\r\n" + //
            "4. Ver detalles completos de un préstamo\r\n" + //
            "5. Comparar dos préstamos\r\n" + //
            "0. Salir\n");
        System.out.print("\t¿Qué necesitas hacer?");
        return Integer.parseInt(sc.nextLine());
    }

    public static void infoPrestamos(Prestamo p) {
        System.out.println("════════════════════════════════════════════════════════════════════");
        System.out.println
        ("CLIENTE          | INGRESOS  | SOLICITADO | PLAZO  | ESTADO");
        System.out.println(p.getNombre() + " | " + p.getIngresos() + " | " + p.getCantidad() + " | " + p.isAprobado());
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opc;

        Prestamo p1 = new Prestamo("Juan Pérez", 2500, 50000, 10);
        Prestamo p2 = new Prestamo("Laura Martín", 1800, 25000, 5);
        Prestamo p3 = new Prestamo("Roberto García", 3200, 80000, 15);


        do {
            opc = menu(sc);

            switch (opc) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
            
                default:
                    break;
            }
        } while (opc != 0);

        sc.close();
    }
}
