import java.util.Random;

public class Reserva {
    private String nombrePasajero, numeroPasaporte, acompNom1, acompPass1, acompNom2, acompPass2;
    private Vuelo vuelo;
    String codigoReserva;
    int cuantosAsientos;


    public Reserva(String nombrePasajero, String numeroPasaporte, Vuelo vuelo, int cuantosAsientos, String acompNom1, String acompPass1, String acompNom2, String acompPass2) {
        this.nombrePasajero = nombrePasajero;
        this.numeroPasaporte = numeroPasaporte;
        this.vuelo = vuelo;
        this.codigoReserva = generarCodigoReserva(); //Guardar el num random del método
        /* Variable que le va a pasar en el caso 3 y 4, el número de la cantidad de asientos que el usuario quiere. En el 3 para crear reserva y en el 4 para eliminarla. */
        this.cuantosAsientos = cuantosAsientos;
        //Variables para poder guardar los datos en caso de que se añada algún acompañante, como el máximo son 3 personas en la reserva, creamos datos para posibles 1 o 2 acompañantes
        this.acompNom1 = acompNom1;
        this.acompPass1 = acompPass1;
        this.acompNom2 = acompNom2;
        this.acompPass2 = acompPass2;
    }

    // Método propio
    public void mostrarInformacionReserva() {
        System.out.println("\nNúmero de asientos reservados: " + this.cuantosAsientos);
        System.out.println("Pasajeros: ");
        System.out.println("\tNombre: " + this.nombrePasajero + " - " + "Pasaporte: " + this.numeroPasaporte);

        //Verificar que cuando los acompañantes no sean null, se añadirán a los datos de la información de la reserva
        if (this.acompNom1 != null && this.acompPass1 != null) {
            System.out.println("\tNombre: " + this.acompNom1 + " - " + "Pasaporte: " + this.acompPass1);
        }

         if (this.acompNom2 != null && this.acompPass2 != null) {
            System.out.println("\tNombre: " + this.acompNom2 + " - " + "Pasaporte: " + this.acompPass2);
        }

        //Print para que la reserva tenga un extra de información
        System.out.println("\nDatos del vuelo reservado: ");

        vuelo.mostrarInformacionVuelo();
    }

    /* Método extra para generar un número random para crear códigos de reserva, y con formato para que tenga 3 dígitos */
    public String generarCodigoReserva() {
        Random random = new Random();

        //Iniciamos en 1 para que no dé un número a 0 completamente
        int numRandom = random.nextInt(1,999);
        String codigoReserva = String.format("R%03d", numRandom);
        return codigoReserva;
    }

    // Getters
    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    /* Getter para poder acceder desde el main en el caso 2 (asignar código) y 3 (comparar código) */
    public String getCodigoReserva() {
        return codigoReserva;
    }

    public int getCuantosAsientos() {
        return cuantosAsientos;
    }
    
}