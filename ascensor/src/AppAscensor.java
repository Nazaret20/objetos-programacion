import java.util.Scanner;

public class AppAscensor {
    public static void menuAscensor() {
        System.out.println("______________________________________________");
        System.out.println("=== HOTEL GRAN VÍA - SISTEMA DE ASCENSOR ===");
        System.out.println("\nEdificio: 12 pisos (0-11)");
        System.out.println("1. Llamar ascensor a mi piso");
        System.out.println("2. Ir a un piso específico");
        System.out.println("3. Abrir/Cerrar puerta manualmente");
        System.out.println("4. Ver estado del ascensor");
        System.out.println("5. EMERGENCIA");
        System.out.println("0. Salir\n");
        System.out.print("¿Qué necesitas hacer?: ");
    }
    public static void main(String[] args) throws Exception {
        Ascensor ascensor = new Ascensor(11);
        Scanner sc = new Scanner(System.in);

        int opc, pisoUser;
        
        System.out.println("Bienvenido al ascensor de Hotel Gran Vía\n");
        do {
            menuAscensor();
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.print("¿En qué piso estás del 0 al 11?: ");
                    pisoUser = sc.nextInt();
                    System.out.println("El ascensor está en la planta" + ascensor.getPisoActual());
                    
                    if (pisoUser > ascensor.getPisoActual() || pisoUser > ascensor.getPisoActual()) {
                        ascensor.irAPiso(pisoUser);
                    }
                    System.out.println("El ascensor ha llegado a su piso");
                    
                    break;
            
                    case 4:
                        ascensor.verificarEstado();
                default:
                    break;
            }
        } while (opc != 0);

        sc.close();
    }
}
