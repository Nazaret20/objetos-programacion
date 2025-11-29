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
                            //Añadir más asientos a la reserva
                            System.out.print("\n¿Cuántos asientos quieres reservar?: ");
                            int cuantosAsientos = Integer.parseInt(sc.nextLine());

                            Reserva reserva1 = new Reserva(nombrePax, pasaportePax, vuelo1);
                            
                            System.out.println("✔ Reserva confirmada - Código: " + reserva1.generarCodigoReserva()); 

                            vuelo1.reservarAsiento(cuantosAsientos);
                            
                        } else {
                            System.out.println("✖ Lo sentimos, el vuelo está completo. No hay asientos disponibles.");
                        }
                    }

                     // Verificar asientos disponibles vuelo 2
                    if (eleccionVueloUsuario == 2) {
                        int asientosDisponibles = vuelo2.getAsientosDisponibles();

                        if (asientosDisponibles > 0) {
                            //Añadir más asientos a la reserva
                            System.out.println("¿Cuántos asientos quieres reservar?");
                            int cuantosAsientos = Integer.parseInt(sc.nextLine());
                            Reserva reserva2 = new Reserva(nombrePax, pasaportePax, vuelo1);
                            
                            System.out.println("✔ Reserva confirmada - Código: " + reserva2.generarCodigoReserva()); 

                            vuelo2.reservarAsiento(cuantosAsientos);
                            
                            // Falta poner código reserva
                        } else {
                            System.out.println("✖ Lo sentimos, el vuelo está completo. No hay asientos disponibles.");
                        }
                    }

                    break;
                
                case 3:
                    System.out.print("Introduce tu código de reserva: ");
                    

                default:
                    break;
            }

        } while (opc != 0);

        sc.close();
    }
}
