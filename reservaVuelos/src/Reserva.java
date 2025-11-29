import java.util.Random;

public class Reserva {
    private String nombrePasajero, numeroPasaporte;
    private Vuelo vuelo;
    String codigoReserva;

    public Reserva(String nombrePasajero, String numeroPasaporte, Vuelo vuelo) {
        this.nombrePasajero = nombrePasajero;
        this.numeroPasaporte = numeroPasaporte;
        this.vuelo = vuelo;
        this.codigoReserva = generarCodigoReserva(); //Guardar el num random del método
    }

    // Método propio
    public void mostrarInformacionReserva() {
        System.out.println("Nombre del pasajero: " + getNombrePasajero());
        System.out.println("Número de pasaporte: " + getNumeroPasaporte());
        System.out.println("Datos del vuelo reservado: ");

        vuelo.mostrarInformacionVuelo();
    }

    //Método extra para generar un número random para crear códigos de reserva, y con formato para que tenga 3 dígitos
    public String generarCodigoReserva() {
        Random random = new Random();

        //Iniciamos en 1 para que no dé un número a 0 completamente
        int numRandom = random.nextInt(1,999);
        String codigoReserva = String.format("R%03d", numRandom);
        return codigoReserva;
    }

    //Método extra para eliminar los datos de la reserva
    public boolean eliminarReserva(Vuelo vuelo) {
        this.nombrePasajero = "";
        this.numeroPasaporte = "";
        this.vuelo = vuelo;
        return true;
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

    //Getter para poder acceder desde el main en el caso 2 (asignar código) y 3 (comparar código)
    public String getCodigoReserva() {
        return codigoReserva;
    }

}