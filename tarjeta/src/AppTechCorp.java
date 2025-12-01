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
        System.out.print("¿Qué opción necesitas hacer?: ");
    }

    public static void main(String[] args) throws Exception {
        Tarjeta tarjeta1 = new Tarjeta("T001", "Ana Pérez", 1);
        Tarjeta tarjeta2 = new Tarjeta("T002", "Juan López", 3);
        Tarjeta tarjeta3 = new Tarjeta("T003", "María López", 4);
        int opc;
        String id;

        Scanner sc = new Scanner(System.in);

        System.out.println("¡Bienvenido a TechCorp!\n");

        do {
            menu();
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    System.out.println("\nZONAS DISPONIBLES:\r\n" + //
                        "1. Recepción (Nivel 1)\r\n" + //
                        "2. Oficinas (Nivel 2)\r\n" + //
                        "3. Laboratorio (Nivel 3)\r\n" + //
                        "4. Sala de Servidores (Nivel 4)");

                    System.out.print("¿A qué zona quieres acceder?: ");
                    int zona = Integer.parseInt(sc.nextLine());

                    System.out.print("\nIntroduce el ID: ");
                    id = sc.nextLine();

                    // Verificar tarjeta 1
                    if (id.equals(tarjeta1.getId())) {
                        if (tarjeta1.verificarAcceso(zona)) {
                            System.out.println("\nACCESO PERMITIDO\n");
                        } else {
                            System.out.print("\nACCESO DENEGADO ");
                            if (tarjeta1.isActiva() == false) {
                                System.out.println("por tarjeta desactivada");
                            }
                            if (zona > tarjeta1.getNivelAcceso()) {
                                System.out.println("por nivel no correspondiente");
                            }
                        }
                        // Verificar tarjeta 2
                    } else if (id.equals(tarjeta2.getId())) {
                        if (tarjeta2.verificarAcceso(zona)) {
                            System.out.println("\nACCESO PERMITIDO\n");
                        } else {
                            System.out.print("\nACCESO DENEGADO ");
                            if (tarjeta2.isActiva() == false) {
                                System.out.println("por tarjeta desactivada");
                            }
                            if (zona > tarjeta2.getNivelAcceso()) {
                                System.out.println("por nivel no correspondiente");
                            }
                        }
                        // Verificar tarjeta 3
                    } else if (id.equals(tarjeta3.getId())) {
                        if (tarjeta3.verificarAcceso(zona)) {
                            System.out.println("\nACCESO PERMITIDO\n");
                        } else {
                            System.out.print("\nACCESO DENEGADO ");
                            if (tarjeta3.isActiva() == false) {
                                System.out.println("por tarjeta desactivada");
                            }
                        }
                    } else {
                        System.out.println("Tarjeta no válida");
                    }

                    break;

                case 2:
                    System.out.print("\nIntroduce el ID: ");
                    id = sc.nextLine();

                    System.out.println("GESTIÓN DE TARJETA [ID]\r\n" + //
                        "a) Activar tarjeta\r\n" + //
                        "b) Desactivar/Bloquear tarjeta\r\n" + //
                        "c) Aumentar nivel de acceso\r\n" + //
                        "d) Disminuir nivel de acceso\r\n" + //
                        "e) Volver al menú principal");

                    System.out.println("¿Qué gestión necesitas hacer?");
                    String opcCase2 = sc.nextLine();

                    switch (opcCase2) {
                        case "a":
                            boolean seActivo = tarjeta1.activarTarjeta();
                            if (!seActivo) {
                                System.out.println("Su tarjeta ya está activada");
                            } else {
                                tarjeta1.activarTarjeta();
                                System.out.println("Su tarjeta se ha activado");
                            }
                            break;
                    
                        case "b":
                            boolean seDesactivo = tarjeta1.desactivarTarjeta();
                            if (!seDesactivo) {
                                System.out.println("Su tarjeta ya está desactivada");
                            } else {
                                tarjeta1.desactivarTarjeta();
                                System.out.println("Su tarjeta se ha desactivado");
                            } 
                            break;

                        case "c":
                            boolean aumentoDeNivel = tarjeta1.aumentarNivelAcceso();
                            if (aumentoDeNivel) {
                                
                            }
                            break;

                        // case "d":
                        //     tarjeta1.disminuirNivelAcceso();
                        //     break;

                        // case "e":
                        //     menu();
                        //     break;

                        default:
                            break;
                    }

                    break;
                default:
                    break;
            }

        } while (opc != 0);

        sc.close();
    }
}
