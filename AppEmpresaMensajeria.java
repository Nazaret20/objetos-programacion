import java.util.Scanner;

public class AppEmpresaMensajeria {
    static Paquete paq1 = null;
    static Paquete paq2 = null;
    public static Scanner sc = new Scanner(System.in);

    /*------------------------------------ */
    public static void menu() {
        System.out.print("\n\n=== GESTIÓN DE ENVÍOS ===\n" + //
                "1. Calcular coste de un paquete\n" + //
                "2. Comparar dos paquetes\n" + //
                "3. Simulador de tarifas por peso\n" + //
                "4. Calcular días de entrega\n" + //
                "0. Salir\n" + //
                "\n" + //
                "Seleccione una opción: ");
    }

    /*------------------------------------ */
    public static Paquete crearPaquete(Scanner sc) {
        String codPaq = pedirDatosString(sc, "\nIntroduce el código del paquete: ");
        double pesoPaq = pedirDatosDouble(sc, "Introduce el peso del paquete: ");
        int distPaq =  pedirDatosInt(sc, "Introduce la distancia del envío: ");
        boolean urgPaq = pedirDatosBoolean(sc, "¿Es urgente? (Sí/No): ");

        Paquete paq = new Paquete(codPaq, pesoPaq, distPaq, urgPaq);
        System.out.print(paq.toString());
        return paq;
    }

    public static String pedirDatosString(Scanner sc, String pregunta) {
        System.out.print(pregunta);
        String dato = sc.nextLine();
        return dato;
    }

    public static double pedirDatosDouble(Scanner sc, String pregunta) {
        System.out.print(pregunta);
        Double dato = sc.nextDouble();
        sc.nextLine();
        return dato;
    }

     public static int pedirDatosInt(Scanner sc, String pregunta) {
        System.out.print(pregunta);
        int dato = sc.nextInt();
        sc.nextLine();
        return dato;
    }
    
    public static boolean pedirDatosBoolean(Scanner sc, String pregunta) {
        System.out.print(pregunta);
        String dato = sc.nextLine();

        if (dato.equals("Sí")) {
            return true;
        } else {
            return false;
        }
    }
    /*------------------------------------ */

    public static void simuladorTarifas() {
        int distPaq = pedirDatosInt(sc, "Introduce la distancia del envío: ");
        boolean urgPaq = pedirDatosBoolean(sc, "¿Es urgente? (Sí/No): ");
        String siNo = "";

        if (urgPaq) {
            siNo = "Sí";
        } else {
            siNo = "No";
        }

        System.out.println("\n--- Simulador de tarifas ---");
        System.out.println("Distancia: " + distPaq + " km | Urgente: " + siNo);
        System.out.println("\nPeso (kg)\t Coste (€)");
        System.out.println("-------------------------");
        tarifas();
    }
    
    public static void tarifas() {
        double result = 0;
        double cadaKg = 1.20;
        
        for (int i = 1; i <= 10; i++) {
            result = i * cadaKg;
            System.out.printf("%d\t\t%.2f\n", i, result);
        }
    }
    
    /*------------------------------------ */


    public static void main(String[] args) throws Exception {
        int opc;

        do {
            menu();
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    paq1 = crearPaquete(sc);
                    break;

                case 2:
                    paq1 = crearPaquete(sc);
                    paq2 = crearPaquete(sc);
                    double costePaq1 = paq1.calcularCoste();
                    double costePaq2 = paq2.calcularCoste();

                    double diferencia = costePaq1 - costePaq2;

                    if (diferencia == 0.0) {
                        System.out.printf("\nEl paquete %s y el paquete %s, tienen el mismo precio %.2f", paq1.getCodigo(), paq2.getCodigo(), costePaq1);
                    } else if (diferencia > 0) {
                        System.out.println("\nEl paquete " + paq1.getCodigo() + " (" + costePaq1 + "€) es más caro que el paquete " + paq2.getCodigo() + " (" + costePaq2 + "€)");
                    } else {
                        System.out.println("\nEl paquete " + paq2.getCodigo() + " (" + costePaq2 + "€) es más caro que el paquete " + paq1.getCodigo() + " (" + costePaq1 + "€)");
                    }
                    
                    break;
                
                case 3:
                    simuladorTarifas();
                    break;
                
                case 4:
                    paq1 = crearPaquete(sc);
                    paq1.diasEntrega();
                    break;
                
                case 0:
                    System.out.println("¡Gracias por usar nuestro sistema de envíos!");
                    break;

                default:
                    System.out.println("Opción no válida, introduce de nuevo un número");
                    break;
            }
            
        } while (opc != 0);

        sc.close();
    }

}
