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