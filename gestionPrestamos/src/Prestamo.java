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
        if ((calcularCuotaMensual() <= (getIngresos() * 30) / 100) && (getCantidad() <= getIngresos() * 10) && (getTiempo() >= 1 || getTiempo() <= 30)) {
            this.aprobado = true;
            this.tasaInteres = ajustarTasa();
            return true;
        } else {
            return false;
        }


    }

    public double ajustarTasa() {
        double tasa = 0;
        if (getTiempo() >= 1 && getTiempo() <= 5) {
            tasa = 4;
        }
        if (getTiempo() >= 6 && getTiempo() <= 10) {
            tasa = 5;
        }
        if (getTiempo() >= 11 && getTiempo() <= 20) {
            tasa = 6;
        }
        if (getTiempo() >= 21 && getTiempo() <= 30) {
            tasa = 7;
        } 
        
        return tasa;    
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
        } else {
            return 0;
        }
    }

    public boolean modificarTiempo(double nuevoTiempo) {
        if (!isAprobado() && nuevoTiempo >= 1 && nuevoTiempo <= 30) {
            this.tiempo = nuevoTiempo;
            this.tasaInteres = ajustarTasa();
            return true;
        } else {
            return false;
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

    public String infoTabla() {
        String linea = "";
        linea += getNombre() + "\t| ";
        linea += getIngresos() + "\t| ";
        linea += getCantidad() + "\t| ";
        linea += getTiempo() + "\t| ";
        
        if(isAprobado()) {
            linea += "Aprobado";
        } else {
            linea += "Rechazado";
        }

        return linea;
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
