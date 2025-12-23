public class Paquete {
    private String codigo;
    private double pesoKg;
    private int distanciaKm;
    private boolean urgente;

    public Paquete(String codigo, double pesoKg, int distanciaKm, boolean urgente) {
        this.codigo = codigo;
        this.pesoKg = pesoKg;
        this.distanciaKm = distanciaKm;
        this.urgente = urgente;
    }

    //Métodos propios
    public String obtenerTipoEnvio() {
        if (distanciaKm < 50) {
            return "Local";
        } else if (distanciaKm > 50 && distanciaKm < 200) {
            return "Provincial";
        } else if (distanciaKm > 200) {
            return "Nacional";
        } else {
            return "Distancia no válida";
        }
    }

    public double calcularCoste() {
        double costeBase = 2.50;
        double cadaKg = 1.20;
        double cada100Km = 0.50;
        double recargo = 0;

        double resultKg = costeBase + (pesoKg * cadaKg);
        double resultKm = costeBase + (distanciaKm * cada100Km);
        double resultKgMasKm = resultKg + resultKm;

        if (isUrgente()) {
            recargo = resultKgMasKm * 1.25;
        }

        return resultKgMasKm + recargo;
    }

    @Override
    public String toString() {
        return "\n== Datos del paquete ==\n" + "Código: " + this.codigo + "\nPeso: " + this.pesoKg + " kg" + "\nDistancia: " + this.distanciaKm + " km" + "\nCoste: " + calcularCoste() + " €" + "\nTipo de envío: " + obtenerTipoEnvio();
    }
    
    /*-------------------------- */
    public void diasEntrega() {
        int dias = 0;
        
        if (this.distanciaKm < 100) {
            dias = 1;
        } else if (this.distanciaKm >= 100 && this.distanciaKm <= 300) {
            dias = 2;
        } else if (this.distanciaKm >= 301 && this.distanciaKm <= 500) {
            dias = 3;
        } else {
            dias = 5;
        }
        
        if (isUrgente() && dias > 1) {
            dias -= 1;
        }

        System.out.println("\nEl paquete tardará en llegar: " + dias + " días");

    }

    //Getters
    public String getCodigo() {
        return codigo;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public int getDistanciaKm() {
        return distanciaKm;
    }

    public boolean isUrgente() {
        return urgente;
    }

}
