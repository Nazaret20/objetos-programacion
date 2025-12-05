import java.util.Scanner;

public class AppGestionPrestamos {
    static Prestamo p1 = new Prestamo("Juan Pérez", 2500, 50000, 10);
    static Prestamo p2 = new Prestamo("Laura Martín", 1800, 25000, 5);
    static Prestamo p3 = new Prestamo("Roberto García", 3200, 80000, 15);

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
        System.out.print("\t¿Qué necesitas hacer?: ");
        return Integer.parseInt(sc.nextLine());
    }

    public static void infoPrestamos() {
        System.out.println("\n════════════════════════════════════════════════════════════════════");
        System.out.println("CLIENTE\t\t| INGRESOS\t| SOLICITADO\t| PLAZO\t| ESTADO");
        System.out.println("════════════════════════════════════════════════════════════════════");
        System.out.println(p1.infoTabla());
        System.out.println(p2.infoTabla());
        System.out.println(p3.infoTabla());
        System.out.println("════════════════════════════════════════════════════════════════════");
        
    }

    public static Prestamo selPrestamo(Scanner sc) {
        System.out.println("\n1.- " + p1.infoTabla());
        System.out.println("2.- " + p2.infoTabla());
        System.out.println("3.- " + p3.infoTabla());
        
        System.out.print("\n\tSelecciona préstamo a evaluar: ");
        int opcPrestamo = Integer.parseInt(sc.nextLine());
        switch (opcPrestamo) {
            case 1:
                return p1;
            case 2:
                return p2;
            case 3:
                return p3;
        
            default:
                return null;
        }
    }

    public static void compararPrestamos(Prestamo p1, Prestamo p2) {
        String estado1 = "";
        String estado2 = "";

        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("COMPARACIÓN DE PRÉSTAMOS");
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("\t\tPRÉSTAMO 1\t| PRÉSTAMO 2");
        System.out.println("───────────────────────────────────────────────────────────");
        System.out.println("Cliente\t| " + p1.getNombre() + "\t| " + p2.getNombre());
        System.out.printf("Cantidad:\t| %.2f\t| %.2f", p1.getCantidad(), p2.getCantidad());
        System.out.printf("Plazo:\t| %.2f\t| %.2f", p1.getCantidad(), p2.getCantidad());

        if (p1.isAprobado()) {
             estado1 = "Aprobado";
        } else {
             estado1 = "Rechazada";
        }

        if (p2.isAprobado()) {
           estado2 = "Aprobado";
        } else {
            estado2 = "Rechazada";
        }

        System.out.printf("Estado:\t| %.2f\t| %.2f", estado1, estado2);
        System.out.printf("Cuota:\t| %.2f\t| %.2f", p1.calcularCuotaMensual(), p2.calcularCuotaMensual());
        System.out.printf("Total interés:\t| %.2f\t| %.2f", p1.calcularInteresTotal(), p2.calcularInteresTotal());
        System.out.printf("Total a devolver:\t| %.2f\t| %.2f", p1.calcularCantidadTotal(), p2.calcularCantidadTotal());
        System.out.println("═══════════════════════════════════════════════════════════");
    }


    //-----------------MAIN----------------
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opc;
        Prestamo pTemp, pTemp2;
        
        System.out.println("Bienvenido al programa de préstamos. \nTiene tres solicitudes pendientes.");
        do {
            opc = menu(sc);

            switch (opc) {
                case 1:
                    infoPrestamos();
                    break;
                case 2:
                    pTemp = selPrestamo(sc);

                    if (pTemp.evaluarPrestamo()) {
                        System.out.println("Felicidades");
                        System.out.println("Tasa: " + pTemp.getTasaInteres());
                        System.out.println("Cuota: " + pTemp.calcularCuotaMensual());
                        System.out.println("¿Quiere ver el resumen? (s/n): ");
                        String opcResumen = sc.nextLine();

                        if (opcResumen.equals("s")) {
                            pTemp.mostrarDetalles();
                        }
                    } else {
                        System.out.println("Lo siento, se ha rechazado.");
                    }

                    break;

                case 3:

                    pTemp = selPrestamo(sc);
                    if (!pTemp.isAprobado()) {
                        System.out.println("MODIFICAR PRÉSTAMO DE " + pTemp.getNombre());
                        System.out.println("Condiciones actuales: ");
                        System.out.println("Cantidad: \t" + pTemp.getCantidad());
                        System.out.println("Plazo:\t" + pTemp.getTiempo());
                        System.out.println("\na) Modificar cantidad solicitada\r\n" + //
                                            "b) Modificar plazo\r\n" + //
                                            "c) Volver al menú principal");
                        System.out.println("\n\tSelecciona opción: ");
                        String opcModificar = sc.nextLine();
                        switch (opcModificar) {
                            case "a":
                                System.out.println("\nDime la nueva cantidad: ");
                                double nuevaCantidad = Double.parseDouble(sc.nextLine());
                                pTemp.modificarCantidad(nuevaCantidad);
                                pTemp.mostrarTablaResumen();
                                break;

                            case "b":
                                System.out.println("\nDime el nuevo plazo: ");
                                double nuevaPlazo = Double.parseDouble(sc.nextLine());
                                pTemp.modificarTiempo(nuevaPlazo);
                                pTemp.mostrarTablaResumen();
                                break;
                        }
                    } else {
                        System.out.println("No se puede modidificar");
                    }
                    break;
                case 4:
                    pTemp = selPrestamo(sc);
                    pTemp.mostrarDetalles();
                    if (pTemp.isAprobado()) {
                        pTemp.mostrarTablaResumen();
                    }
                    
                    break;
                case 5:
                    System.out.println("Primer préstamo");
                    pTemp = selPrestamo(sc);
                    System.out.println("Segundo préstamo");
                    pTemp2 = selPrestamo(sc);
                    if (!pTemp.equals(pTemp2)) {
                        compararPrestamos(pTemp, pTemp2);
                    } else {
                        System.out.println("No se puede comparar el mismo préstamo");
                    }

                    break;
            
                default:
                    break;
            }
        } while (opc != 0);

        int aprobados = 0;
        int rechazados = 0;

        if (p1.isAprobado()) {
            aprobados++;
        } else {
            rechazados++;
        }

        if (p2.isAprobado()) {
            aprobados++;
        } else {
            rechazados++;
        }

        if (p3.isAprobado()) {
            aprobados++;
        } else {
            rechazados++;
        }

        System.out.printf("Aprobados: %d\t| Rechazados: %d", aprobados, rechazados);

        System.out.println("Adiós");

        sc.close();
    }
}
