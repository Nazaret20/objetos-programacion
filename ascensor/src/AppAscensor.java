import java.util.Scanner;
public class AppAscensor {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Ascensor asc = new Ascensor(11);
        int opc;
        boolean emergencia = false;

        System.out.println("\nBienvenid@ al Hotel Gran Vía\n");
        do {
            menu();
            if(!emergencia)
                opc = Integer.parseInt(sc.nextLine());
            else 
                opc = 6;

            switch (opc) {
                case 1:
                    System.out.print("Dime el piso en el que estás: ");
                    int piso1 = Integer.parseInt(sc.nextLine());
                    asc.irAPiso(piso1);
                    asc.abrirPuerta();
                    System.out.println("El ascensor ha llegado a su piso");
                    break;
                case 2:
                    System.out.print("Dime el piso al que vas: ");
                    int piso2 = Integer.parseInt(sc.nextLine());
                    asc.irAPiso(piso2);
                    asc.abrirPuerta();
                    System.out.printf("Ha llegado al piso %d. ¡Que tenga un buen día!", piso2);
                    break;
                case 3:
                    System.out.println("a) Abrir puerta");
                    System.out.println("b) Cerrar puerta");
                    System.out.print("\tSelecione opción: ");
                    if(sc.nextLine().equals("a")) {
                        if(asc.abrirPuerta())
                            System.out.println("Puerta abierta");
                        else {
                            if(asc.isEnMovimiento())
                                System.out.println("Fallo al abrir puerta.\nAscensor en movimiento.");
                            else
                                System.out.println("Fallo al abrir puerta.\nPuerta ya abierta.");
                        }
                    }
                    else {
                        if(asc.cerrarPuerta())
                            System.out.println("Puerta cerrada");
                        else
                            System.out.println("Fallo al cerrar puerta. \nPuerta ya cerrada.");
                    }                       
                    break;
                case 4:
                    asc.verificarEstado();
                    for(int i = asc.getPisoMaximo(); i >= 0; i--) {
                        if(i != asc.getPisoActual())
                            System.out.println("Piso " + i + ":");
                        else
                            System.out.println("Piso " + i + ": [X] <- Ascensor aquí");
                    }
                    break;
                case 5:
                    System.out.print("¿Está seguro de activar la emergencia? (s/n) ");
                    if(sc.nextLine().equals("s")) {
                        asc.activarEmergencia();
                        System.out.println("Salga del ascensor y use las escaleras");
                        emergencia = true;
                    }
                    break;
                case 6:
                    System.out.println("EN EMERGENCIA. LLAME AL SERVICIO TÉCNICO.");
                    while (true) {
                        
                    }
            }

        } while (opc != 0);
        System.out.println("Finalizado correctamente");
        sc.close();
    }

    public static void menu() {
        System.out.println("\n=== HOTEL GRAN VÍA - SISTEMA DE ASCENSOR ===\r\n" + //
                        "Edificio: 12 pisos (0-11)\r\n" + //
                        "\r\n" + //
                        "1. Llamar ascensor a mi piso\r\n" + //
                        "2. Ir a un piso específico\r\n" + //
                        "3. Abrir/Cerrar puerta manualmente\r\n" + //
                        "4. Ver estado del ascensor\r\n" + //
                        "5. EMERGENCIA\r\n" + //
                        "0. Salir\r\n" + //
                        "============================================");
                        System.out.print("\tSeleccione opción: ");
    }
}