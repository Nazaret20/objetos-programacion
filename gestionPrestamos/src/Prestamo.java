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
        this.tasaInteres = tasaInteres * 5 / 100;
    }

    //Métodos propios
    public boolean evaluarPrestamo() {
        if (calcularCuotaMensual() <= (this.ingresos * 30) / 100 && this.cantidad <= this.ingresos * 10 && (this.tiempo <= 1 || this.tiempo >= 30)) {
            this.aprobado = true;
            if (this.aprobado == true) {
                int anios = 0;
                switch (this.tiempo) {
                    case 1:
                        if (this.tiempo >= 1 || this.tiempo <= 5) {
                            this.tasaInteres = this.tasaInteres * 4 / 100;
                        }
                        break;
                
                    case 2: 
                        if (this.tiempo >= 6 || this.tiempo <= 10) {
                            this.tasaInteres = this.tasaInteres;
                        }
                        break;
        
                    case 3:
                        if (this.tiempo >= 11 || this.tiempo <= 20) {
                            this.tasaInteres = this.tasaInteres * 6 / 100;
                        }
                        break;
        
                    case 4:
                        if (this.tiempo >= 21 || this.tiempo <= 30) {
                            this.tasaInteres = this.tasaInteres * 7 / 100;
                        }
                    default:
                        break;
                }
            }
            return true;
        } else {
            return false;
        }


    }

    public double calcularCuotaMensual() {
        if (isAprobado()) {
            double cuotaMensual = (cantidad + (cantidad * tasaInteres/100 * tiempo)) / (tiempo * 12);
            return cuotaMensual;
        } else {
            return 0;
        }
    }

    public double calcularInteresTotal() {
        if (isAprobado()) {
            double interesTotal = cantidad * tasaInteres/100 * tiempo;
            return interesTotal;
        } else {
            return 0;
        }
    }

    public double calcularCantidadTotal() {
        if (isAprobado()) {
            double cantDevolver = this.cantidad + calcularInteresTotal();
            return cantDevolver;
        }
        return 0;
    }

    public boolean modificarTiempo(double nuevoTiempo) {
        if (isAprobado()) {
            return false;
        } else {
            if (nuevoTiempo >= 1 || nuevoTiempo <= 30) {
                this.tiempo = nuevoTiempo;
                calcularInteresTotal();
            }
            return true;
        }
    }

    public boolean modificarCantidad(double nuevaCantidad) {
        if (!isAprobado() && nuevaCantidad > 0) {
            this.cantidad = nuevaCantidad;
            return true;
        } else {
            return false; 
        }
    }

    public boolean rechazarPrestamo() {
        if (isAprobado()) {
            this.aprobado = false;
            return true;
        } else {
            return false;
        }
    }

    public void mostrarDetalles() {
        System.out.println("------------------------------------");
        System.out.println("Nombre del solicitante: " + getNombre());
        System.out.println("Ingresos mensuales: " + getIngresos());
        System.out.println("Cantidad solicitada: " + getCantidad());
        System.out.println("Plazo: " + getTiempo() + " años");
        System.out.println("Tasa de interés aplicada: " + getTasaInteres());
        
        if (isAprobado()) {
            System.out.println("Estado: " + "Aprobado");
            System.out.println("Cuota mensual: " + calcularCuotaMensual());
            System.out.println("Interés total: " + calcularInteresTotal());
            System.out.println("Cantidad total a devolver: " + calcularCantidadTotal());

        } else {
            System.out.println("Estado: Rechazado");
        }
        System.out.println("------------------------------------");
    }

    public void mostrarTablaResumen() {
        if (isAprobado()) {
            System.out.println("Capital: " + getCantidad());
            System.out.println("Total intereses: " + calcularInteresTotal());
            System.out.println("Cuota mensual: " + calcularCuotaMensual());
            System.out.println("Número de cuotas: " + this.tiempo * 12);
        } 
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
