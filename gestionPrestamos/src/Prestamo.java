public class Prestamo {
    private String nombre;
    private double ingresos, cantidad, tiempo, tasaInteres;
    private boolean aprobado;

    public Prestamo(String nombre, double ingresos, double cantidad, double tiempo) {
        this.nombre = nombre;
        this.ingresos = ingresos;
        this.cantidad = cantidad;
        this.tiempo = tiempo;
        this.aprobado = false;
        this.tasaInteres = 5;
    }

    //Métodos propios
    public boolean evaluarPrestamo() {
        
        return true;
    }

    public double calcularCuotaMensual() {
        return 0;
    }

    public double calcularInteresTotal() {
        return 0;
    }

    public double calcularCantidadTotal() {
        return 0;
    }

    public boolean modificarTiempo(double nuevoTiempo) {
        return true;
    }

    public boolean rechazarPrestamo() {
        return true;
    }

    public void mostrarDetalles() {
        System.out.println("------------------------------------");
        System.out.println("Nombre del solicitante: " + this.nombre);
        System.out.println("Ingresos mensuales: " + this.ingresos);
        System.out.println("Cantidad solicitada: " + this.cantidad);
        System.out.println("Tasa de interés aplicada: " + this.tasaInteres);
        System.out.println("Estado: " + this.aprobado);

        if (evaluarPrestamo()) {
            System.out.println("Cuota mensual: " + calcularCuotaMensual());
            System.out.println("Interés total: " + calcularInteresTotal());
            System.out.println("Cantidad total a devolver: " + calcularCantidadTotal());
        }

        System.out.println("------------------------------------");
    }

    public void mostrarTablaResumen() {

    }

    
    //Getters
    public String getNombre() {
        return nombre;
    }

    public double getIngresos() {
        return ingresos;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getTiempo() {
        return tiempo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public boolean isAprobado() {
        return aprobado;
    }
    
} 
