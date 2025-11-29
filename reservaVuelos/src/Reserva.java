import java.util.Random;

public class Reserva {
    private String nombrePasajero, numeroPasaporte;
    private Vuelo vuelo;

    public Reserva(String nombrePasajero, String numeroPasaporte, Vuelo vuelo) {
        this.nombrePasajero = nombrePasajero;
        this.numeroPasaporte = numeroPasaporte;
        this.vuelo = vuelo;
    }

    // Método propio
    public void mostrarInformacionReserva() {
        System.out.println("Nombre del pasajero: " + getNombrePasajero());
        System.out.println("Número de pasaporte: " + getNumeroPasaporte());
        System.out.println("Datos del vuelo reservado: ");

        vuelo.mostrarInformacionVuelo();
    }

    //Generar un número random para hacer códigos de reserva con formato para que tenga 3 dígitos con el 0
    public String generarCodigoReserva() {
        Random random = new Random();
        
        //Hasta 1000 porque incluye el 0
        int numRandom = random.nextInt(1000);
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

}