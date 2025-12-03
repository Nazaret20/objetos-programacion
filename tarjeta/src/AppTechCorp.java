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

    public static String datosString(Scanner sc, String pregunta) {
        System.out.println(pregunta);
        String dato = sc.nextLine();
        return dato;
    }

    public static int datosInt(Scanner sc, String pregunta) {
        System.out.println(pregunta);
        int dato = Integer.parseInt(sc.nextLine());
        return dato;
    }

    public static boolean validarTarjeta(Tarjeta tarjeta, int zona) {
        if (tarjeta.verificarAcceso(zona)) {
            System.out.println("\nACCESO PERMITIDO\n");
            return true;
        } else {
            System.out.print("\nACCESO DENEGADO ");
            if (tarjeta.isActiva() == false) {
                System.out.println("por tarjeta desactivada");
            } else if (zona > tarjeta.getNivelAcceso()) {
                System.out.println("por nivel no correspondiente");
            }
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        Tarjeta tarjeta1 = new Tarjeta("T001", "Ana Pérez", 1);
        Tarjeta tarjeta2 = new Tarjeta("T002", "Juan López", 3);
        Tarjeta tarjeta3 = new Tarjeta("T003", "María López", 4);
        Tarjeta tarjetaTemp = null;
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

                    int zona = datosInt(sc, "¿A qué zona quieres acceder?: ");

                    id = datosString(sc, "\nIntroduce el ID: ");

                    if (id.equals(tarjeta1.getId())) {
                        validarTarjeta(tarjeta1, zona);

                    } else if (id.equals(tarjeta2.getId())) {
                        validarTarjeta(tarjeta2, zona);

                    } else if (id.equals(tarjeta3.getId())) {
                        validarTarjeta(tarjeta3, zona);

                    } else {
                        System.out.println("Tarjeta no válida");
                    }
                    break;

                case 2:
                    id = datosString(sc, "\nIntroduce el ID: ");

                    System.out.println("GESTIÓN DE TARJETA ["+ id +"]\r\n" + //
                        "a) Activar tarjeta\r\n" + //
                        "b) Desactivar/Bloquear tarjeta\r\n" + //
                        "c) Aumentar nivel de acceso\r\n" + //
                        "d) Disminuir nivel de acceso\r\n" + //
                        "e) Volver al menú principal");
                    
                        switch (id) {
                            case "T001":
                                tarjetaTemp = tarjeta1;
                                
                            break;
                                case "T002":
                            tarjetaTemp = tarjeta1;
                            
                            break;
                                case "T003":
                            tarjetaTemp = tarjeta1;
                                
                                break;
                        
                            default:
                                break;
                        }

                    String opcCase2 = datosString(sc, "¿Qué gestión necesitas hacer?");

                    switch (opcCase2) {
                        case "a":
                            if (tarjetaTemp.activarTarjeta()) {
                                System.out.println("Activación correcta");
                            } else {
                                System.out.println("Fallo de activación");
                            }
                            break;
                    
                        case "b":
                           if (tarjetaTemp.desactivarTarjeta()) {
                                System.out.println("Desactivación correcta");
                            } else {
                                System.out.println("Fallo de desactivación");
                            }
                            break;

                        case "c":
                            if (tarjetaTemp.aumentarNivelAcceso()) {
                                System.out.println("Aumento de nivel correcto");
                            } else {
                                System.out.println("Fallo de aumento de nivel");
                            }
                            break;

                        case "d":
                           if (tarjetaTemp.disminuirNivelAcceso()) {
                                System.out.println("Disminución de nivel correcto");
                            } else {
                                System.out.println("Fallo de disminución");
                            }
                            break;

                        case "e":
                            menu();
                            break;

                        default:
                            break;
                    }

                    break;
                
                case 3:
                    tarjeta1.mostrarInformacion();
                    tarjeta2.mostrarInformacion();
                    tarjeta3.mostrarInformacion();
                    break;

                case 4:
                    id = datosString(sc, "Introduce el ID: ");
                   
                        break;
                    default:
                    break;
            }

        } while (opc != 0);

        sc.close();
    }
}
