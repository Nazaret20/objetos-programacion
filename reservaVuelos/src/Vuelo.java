public class Vuelo {
    private String numeroVuelo, origen, destino;
    private int asientosDisponibles, asientosTotales;
 

    public Vuelo(String numeroVuelo, String origen, String destino, int asientosDisponibles) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.asientosDisponibles = asientosDisponibles;
        this.asientosTotales = asientosDisponibles; //Guardar el num de asientos fijos que tiene el avión, ya que la otra variable va a cambiar 
       
    }

    // Métodos propios
    //Caracterítica añadida: poder reservar más asientos si son familia
    public void reservarAsiento(int cuantosAsientos) {
        if (this.asientosDisponibles <= 0) {
            System.out.println("El vuelo está lleno");
        } else {
            this.asientosDisponibles -= cuantosAsientos;
        }
    }

    public void mostrarInformacionVuelo() {
        System.out.println("\n\tNúmero de vuelo: " + getNumeroVuelo());
        System.out.println("\tOrigen: " + getOrigen());
        System.out.println("\tDestino: " + getDestino());
        System.out.println("\tAsiestos disponibles: " + getAsientosDisponibles() + " de " + getAsientosTotales());
    }

    //Método extra para devolver los asientos eliminados de una reserva
    public void devolverAsientos(int cuantosAsientos) {
        this.asientosDisponibles += cuantosAsientos;
    }

    // Getters
    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public int getAsientosTotales() {
        return asientosTotales;
    }

}