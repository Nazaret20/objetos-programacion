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
        Ascensor ascensor = new Ascensor(12);
        Scanner sc = new Scanner(System.in);

        int opc;
        
        do {
            menuAscensor();
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    boolean subioPiso = ascensor.bajarPiso();
                    
                    break;
            
                default:
                    break;
            }
        } while (opc != 0);

        sc.close();
    }
}
