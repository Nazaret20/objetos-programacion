import java.util.Scanner;

public class AppGestionVuelos {
    public static void menuGestionVuelos() {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE VUELOS ===");
        System.out.println("1. Ver vuelos disponibles");
        System.out.println("2. Realizar reserva");
        System.out.println("3. Ver detalles de una reserva");
        System.out.println("4. Cancelar reserva");
        System.out.println("0. Salir\n");
        System.out.print("¿Qué necesitas hacer?: ");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Vuelo vuelo1 = new Vuelo("AA123", "Madrid", "Nueva York", 150);
        Vuelo vuelo2 = new Vuelo("IB456", "Barcelona", "Londres", 100);

        int opc;
        String reservaUser;

        /* Iniciamos las reservas en null para poder acceder en el caso 3, ya que en el caso 2 vamos a guardar los datos una vez hecha la reserva */
        Reserva reserva1 = null;
        Reserva reserva2 = null;

        do {
            menuGestionVuelos();
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    vuelo1.mostrarInformacionVuelo();
                    vuelo2.mostrarInformacionVuelo();
                    break;
                    
                case 2:
                    System.out.println("\nVuelo 1:");
                    vuelo1.mostrarInformacionVuelo();
                    System.out.println("\nVuelo 2:");
                    vuelo2.mostrarInformacionVuelo();

                    System.out.print("\n¿Qué vuelo quieres reservar?: ");
                    int eleccionVueloUsuario = Integer.parseInt(sc.nextLine());

                    System.out.print("\nIntroduce tu nombre: ");
                    String nombrePax = sc.nextLine();

                    System.out.print("\nIntroduce tu pasaporte: ");
                    String pasaportePax = sc.nextLine();

                    // Verificar asientos disponibles vuelo 1
                    if (eleccionVueloUsuario == 1) {
                        int asientosDisponibles = vuelo1.getAsientosDisponibles();

                        if (asientosDisponibles > 0) {
                            //Recordatorio de los asientos disponibles que hay
                            System.out.println("\nDe este vuelo quedan " + vuelo1.getAsientosDisponibles() + " asientos disponibles.");

                            // Añadir más asientos a la reserva
                            System.out.print("¿Cuántos asientos quieres reservar? (max. 3): ");
                            int cuantosAsientos1 = Integer.parseInt(sc.nextLine());
                            
                            while (cuantosAsientos1 > 3) {
                                System.out.print("\nSolo puedes reservar 3 asientos. ¿Cuántos asientos quieres reservar?: ");
                                cuantosAsientos1 = Integer.parseInt(sc.nextLine());
                            }
                            
                            
                             if (cuantosAsientos1 == 2) {
                                System.out.print("\nIntroduce el nombre de la persona: ");
                                String acompNom1 = sc.nextLine();

                                System.out.print("\nIntroduce el pasaporte de la persona: ");
                                String acompPass1 = sc.nextLine();


                                reserva1 = new Reserva(nombrePax, pasaportePax, vuelo1, cuantosAsientos1, acompNom1, acompPass1, null, null);

                            } else if (cuantosAsientos1 == 3) {
                                System.out.print("\nIntroduce el nombre de la persona: ");
                                String acompNom1 = sc.nextLine();

                                System.out.print("\nIntroduce el pasaporte de la persona: ");
                                String acompPass1 = sc.nextLine();

                                 System.out.print("\nIntroduce el nombre de la persona: ");
                                String acompNom2 = sc.nextLine();

                                System.out.print("\nIntroduce el pasaporte de la persona: ");
                                String acompPass2 = sc.nextLine();


                                reserva1 = new Reserva(nombrePax, pasaportePax, vuelo1, cuantosAsientos1, acompNom1, acompPass1, acompNom2, acompPass2);
                            } else {
                                // Crear reserva
                                reserva1 = new Reserva(nombrePax, pasaportePax, vuelo1, cuantosAsientos1, null, null, null, null);
                            }


                            /* Mensaje para confirmar reserva junto al método que genera el código de reserva aleatoriamente */
                            System.out.println("✔ Reserva confirmada - Código: " + reserva1.getCodigoReserva());

                            vuelo1.reservarAsiento(cuantosAsientos1);

                        } else {
                            System.out.println("✖ Lo sentimos, el vuelo está completo. No hay asientos disponibles.");
                        }
                    }

                    // Verificar asientos disponibles vuelo 2
                    if (eleccionVueloUsuario == 2) {
                        int asientosDisponibles = vuelo2.getAsientosDisponibles();

                        if (asientosDisponibles > 0) {
                            //Recordatorio de los asientos disponibles que hay
                            System.out.println("\nDe este vuelo quedan " + vuelo2.getAsientosDisponibles() + " asientos disponibles.");

                            // Añadir más asientos a la reserva
                            System.out.print("¿Cuántos asientos quieres reservar? (max. 3): ");
                            int cuantosAsientos2 = Integer.parseInt(sc.nextLine());
                            
                           while (cuantosAsientos2 > 3) {
                                System.out.print("\nSolo puedes reservar 3 asientos. ¿Cuántos asientos quieres reservar?: ");
                                cuantosAsientos2 = Integer.parseInt(sc.nextLine());
                            }
                            
                            
                             if (cuantosAsientos2 == 2) {
                                System.out.print("\nIntroduce el nombre de la persona: ");
                                String acompNom1 = sc.nextLine();

                                System.out.print("\nIntroduce el pasaporte de la persona: ");
                                String acompPass1 = sc.nextLine();


                                reserva2 = new Reserva(nombrePax, pasaportePax, vuelo2, cuantosAsientos2, acompNom1, acompPass1, null, null);

                            } else if (cuantosAsientos2 == 3) {
                                System.out.print("\nIntroduce el nombre de la persona: ");
                                String acompNom1 = sc.nextLine();

                                System.out.print("\nIntroduce el pasaporte de la persona: ");
                                String acompPass1 = sc.nextLine();

                                 System.out.print("\nIntroduce el nombre de la persona: ");
                                String acompNom2 = sc.nextLine();

                                System.out.print("\nIntroduce el pasaporte de la persona: ");
                                String acompPass2 = sc.nextLine();


                                reserva2 = new Reserva(nombrePax, pasaportePax, vuelo2, cuantosAsientos2, acompNom1, acompPass1, acompNom2, acompPass2);
                            } else {
                                // Crear reserva
                                reserva2 = new Reserva(nombrePax, pasaportePax, vuelo2, cuantosAsientos2, null, null, null, null);
                            }


                            /* Mensaje para confirmar reserva junto al método que genera el código de reserva aleatoriamente */
                            System.out.println("✔ Reserva confirmada - Código: " + reserva2.getCodigoReserva());

                            vuelo2.reservarAsiento(cuantosAsientos2);

                        } else {
                            System.out.println("✖ Lo sentimos, el vuelo está completo. No hay asientos disponibles.");
                        }
                    }
                    break;

                case 3:
                    System.out.print("\nIntroduce tu código de reserva: ");
                    reservaUser = sc.nextLine();

                    /* Para comprobar que la reserva no es null porque se ha creado en el caso 2; o al contrario por si introducimos caso 3 sin hacer reserva, hacemos la condición con != y además que coincida con el código de reserva */
                    if (reserva1 != null && reservaUser.equals(reserva1.getCodigoReserva())) {
                        reserva1.mostrarInformacionReserva();

                    } else if (reserva2 != null && reservaUser.equals(reserva2.getCodigoReserva())) {
                        reserva2.mostrarInformacionReserva();

                    } else {
                        System.out.println("✖ No se encontró ninguna reserva con ese código");
                    }
                    break;

                case 4:
                    System.out.print("\nIntroduce tu código de reserva: ");
                    reservaUser = sc.nextLine();

                    if (reserva1 != null && reservaUser.equals(reserva1.getCodigoReserva())) {
                        int cuantosAsientos1 = reserva1.getCuantosAsientos();

                        reserva1.getVuelo().devolverAsiento(cuantosAsientos1);                      
                        reserva1 = null;
                        System.out.println("✔ Reserva cancelada exitosamente");

                    } else if (reserva2 != null && reservaUser.equals(reserva2.getCodigoReserva())) {
                        int cuantosAsientos2 = reserva2.getCuantosAsientos();

                        reserva2.getVuelo().devolverAsiento(cuantosAsientos2);
                        reserva2 = null;
                        System.out.println("✔ Reserva cancelada exitosamente");

                        
                    } else {
                        System.out.println("✖ No se encontró ninguna reserva con ese código");
                    }
                    break;
                
                case 0:
                    System.out.println("\nGracias por usar nuestro sistema de reservas de vuelo, ¡qué tenga un buen día!");
                    break;

                default:
                    System.out.println("\n✖ No es una opción correcta, vuelva a intentarlo.");
                    break;
            }

        } while (opc != 0);

        sc.close();
    }
}
