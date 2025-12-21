import java.util.Scanner;

public class AppEmpresaMensajeria {
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
        int distPaq =  pedirDatosInt(sc, "Introduce la distancia del paquete: ");
        boolean urgPaq = pedirDatosBoolean(sc, "¿Es urgente? (si/no): ");

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

        if (dato.equals("si")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        int opc;
        Paquete paq1 = null;
        Paquete paq2 = null;

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
                default:
                    break;
            }
            
        } while (opc != 0);

        sc.close();
    }

}
