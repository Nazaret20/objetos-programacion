public class Vuelo {
    private String numeroVuelo, origen, destino;
    private int asientosDisponibles, asientosTotales;

    public Vuelo(String numeroVuelo, String origen, String destino, int asientosDisponibles) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.asientosDisponibles = asientosDisponibles;
        this.asientosTotales = asientosDisponibles;
    }

    // Métodos propios
    public void reservarAsiento() {
        if (this.asientosDisponibles == 0) {
            System.out.println("El vuelo está lleno");
        } else {
            this.asientosDisponibles -= 1;
        }
    }

    public void mostrarInformacionVuelo() {
        System.out.println("\tNúmero de vuelo: " + getNumeroVuelo());
        System.out.println("\tOrigen: " + getOrigen());
        System.out.println("\tDestino: " + getDestino());
        System.out.println("\tAsiestos disponibles: " + getAsientosDisponibles() + " de " + getAsientosTotales());
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