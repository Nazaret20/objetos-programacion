import java.util.Scanner;

public class AppTechCorp {
    public static void menu() {
        System.out.println("=== TECHCORP - SISTEMA DE CONTROL DE ACCESO ===\r\n" + //
                "\r\n" + //
                "1. Registrar intento de acceso a una zona\r\n" + //
                "2. Gestionar tarjeta de empleado\r\n" + //
                "3. Ver información de todas las tarjetas\r\n" + //
                "4. Transferir tarjeta a nuevo propietario\r\n" + //
                "0. Salir");
    }

    public static void main(String[] args) throws Exception {
        Tarjeta tarjeta1 = new Tarjeta("T001", "Ana Pérez", 1);
        Tarjeta tarjeta2 = new Tarjeta("T002", "Juan López", 3);
        Tarjeta tarjeta3 = new Tarjeta("T003", "María López", 4);
        int opc;

        Scanner sc = new Scanner(System.in);
        opc = Integer.parseInt(sc.nextLine());

        System.out.println("¡Bienvenido a TechCorp!");

        do {

            menu();

            switch (opc) {
                case 1:
                    System.out.println("ZONAS DISPONIBLES:\r\n" + //
                            "1. Recepción (Nivel 1)\r\n" + //
                            "2. Oficinas (Nivel 2)\r\n" + //
                            "3. Laboratorio (Nivel 3)\r\n" + //
                            "4. Sala de Servidores (Nivel 4)");
                    System.out.println("¿A qué zona quieres acceder?");
                    int zona = Integer.parseInt(sc.nextLine());

                    System.out.println("Introduce el ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    if (id == tarjeta1.getId() || id == tarjeta2.getId() || id == tarjeta3.getId()) {
                        return true;
                    } else { 
                        return false;
                    }


                    break;

                default:
                    break;
            }

        } while (opc != 0);

        sc.close();
    }
}
