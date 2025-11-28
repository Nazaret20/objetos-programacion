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
        
        System.out.println("¡Bienvenido a TechCorp!\n");

        do {
            menu();
            opc = Integer.parseInt(sc.nextLine());

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
                    String id = sc.nextLine();
                    
                    //Verificar tarjeta 1
                    if (id.equals(tarjeta1.getId())) {
                        if (tarjeta1.verificarAcceso(zona)) {
                            System.out.println("ACCESO PERMITIDO"); 
                        } else {
                            System.out.print("ACCESO DENEGADO ");
                            if (tarjeta2.isActiva() == false) {
                                System.out.println("por tarjeta desactivada");
                            } 
                            if (zona > tarjeta2.getNivelAcceso() || zona < tarjeta2.getNivelAcceso()) {
                                System.out.println("por nivel no correspondiente");
                            }
                        }
                    } else {
                        System.out.println("Tarjeta no verificada");
                    }

                    //Verificar tarjeta 2
                    if (id.equals(tarjeta2.getId())) {
                        if (tarjeta2.verificarAcceso(zona)) {
                            System.out.println("ACCESO PERMITIDO");
                        } else {
                            System.out.print("ACCESO DENEGADO ");
                            if (tarjeta2.isActiva() == false) {
                                System.out.println("por tarjeta desactivada");
                            } 
                            if (zona > tarjeta2.getNivelAcceso() || zona < tarjeta2.getNivelAcceso()) {
                                System.out.println("por nivel no correspondiente");
                            }
                        }
                    } else {
                        System.out.println("Tarjeta no verificada");
                    }

                    //Verificar tarjeta 3
                    if (id.equals(tarjeta3.getId())) {
                        if (tarjeta3.verificarAcceso(zona)) {
                            System.out.println("ACCESO PERMITIDO");
                        } else {
                            System.out.print("ACCESO DENEGADO ");
                            if (tarjeta3.isActiva() == false) {
                                System.out.println("por tarjeta desactivada");
                            } 
                            if (zona > tarjeta3.getNivelAcceso() || zona < tarjeta3.getNivelAcceso()) {
                                System.out.println("por nivel no correspondiente");
                            }
                        }
                    } else {
                        System.out.println("Tarjeta no verificada");
                    }
                    
                    break;

                case 2:
                    
                    break;
                default:
                    break;
            }

        } while (opc != 0);

        sc.close();
    }
}

// || id == tarjeta2.getId() || id == tarjeta3.getId()