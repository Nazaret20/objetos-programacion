import java.util.Random;

public class Reserva {
    private String nombrePasajero, numeroPasaporte;
    private Vuelo vuelo;
    String codigoReserva;
    int cuantosAsientos;


    public Reserva(String nombrePasajero, String numeroPasaporte, Vuelo vuelo, int cuantosAsientos) {
        this.nombrePasajero = nombrePasajero;
        this.numeroPasaporte = numeroPasaporte;
        this.vuelo = vuelo;
        this.codigoReserva = generarCodigoReserva(); //Guardar el num random del método
        this.cuantosAsientos = cuantosAsientos; /* Variable que le va a pasar en el caso 3 y 4, el número de la cantidad de asientos que el usuario quiere. En el 3 para crear reserva y en el 4 para eliminarla. */
       
    }

    // Método propio
    public void mostrarInformacionReserva() {
        System.out.println("Nombre del pasajero: " + this.nombrePasajero);
        System.out.println("Número de pasaporte: " + this.numeroPasaporte);
        //Print para que la reserva tenga un extra de información
        System.out.println("Número de asientos reservados: " + this.cuantosAsientos);
        System.out.println("Datos del vuelo reservado: ");

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