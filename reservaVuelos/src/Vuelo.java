public class Vuelo {
    private String numeroVuelo, origen, destino;
    private int asientosDisponibles, asientosTotales;
 

    public Vuelo(String numeroVuelo, String origen, String destino, int asientosDisponibles) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.asientosDisponibles = asientosDisponibles;
        this.asientosTotales = asientosDisponibles; /* Guardar la cantidad total de asientos que tiene el avión, ya que la otra variable va a cambiar */ 
       
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
        System.out.println("\n\tNúmero de vuelo: " + this.numeroVuelo);
        System.out.println("\tOrigen: " + this.origen);
        System.out.println("\tDestino: " + this.destino);
        System.out.println("\tAsientos disponibles: " + this.asientosDisponibles + " de " + this.asientosTotales);
    }

    //Método extra para devolver los asientos eliminados de una reserva
    public void devolverAsiento(int cuantosAsientos) {
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