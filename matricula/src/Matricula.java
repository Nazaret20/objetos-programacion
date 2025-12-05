public class Matricula {
    private String nombreEstudiante, carrera, estado;
    private int numeroAsignaturas, creditosTotales;
    private double precioPorCredito, descuentoBeca;
    private boolean tieneBeca;

    public Matricula(String nombreEstudiante, String carrera, int numeroAsignaturas, int creditosTotales, boolean tieneBeca) {
        this.nombreEstudiante = nombreEstudiante;
        this.carrera = carrera;
        this.estado = "Pendiente";
        this.creditosTotales = creditosTotales;
        this.numeroAsignaturas = numeroAsignaturas;
        this.precioPorCredito = 0;
        this.descuentoBeca = 0;
        this.tieneBeca = tieneBeca;
    }

    //Métodos propios
    public boolean validarMatricula() {
        return true;
    }

    public double calcularCosteMatricula() {
        if (validarMatricula()) {
            double costeTotalMatricula = this.creditosTotales * this.precioPorCredito * (1 - this.descuentoBeca / 100);

            double redondeoCosteMatricula = Math.round(costeTotalMatricula * 100) / 100;  
            return redondeoCosteMatricula;
        } else {
            return 0;
        }
    }

    public int calcularTasaAdministrativa() {
        int tasaBase = 150;
        if (isTieneBeca()) {
            tasaBase = 50;
            return tasaBase;
        }

        if (this.estado == "Pendiente") {
            return 0;
        }

        return tasaBase;
    }

    public double calcularCosteTotal() {
        if (validarMatricula()) {
            double costeTotal = calcularCosteMatricula() + calcularTasaAdministrativa();
            return costeTotal;
        } else {
            return 0;
        }
    }

    public double calcularCreditosMediosPorAsignatura() {
        double creditosMediosAsig = this.creditosTotales / this.numeroAsignaturas;
        double redondeoCreditosMediosAsig = Math.round(creditosMediosAsig * 10)  / 10;
        return redondeoCreditosMediosAsig;
    }

    public boolean añadirAsignatura(int creditosAsignatura) {
        if (validarMatricula() || !validarMatricula()) {
            return false;
        }
        return true;
    }

    public boolean eliminarAsignatura(int creditosAsignatura) {
        return true;
    }

    public boolean modificarBeca(boolean nuevaBeca) {
        return true;
    }

    public double calcularPagoFraccionado(int numPlazos) {
        return 0;
    }

    public boolean aplicarDescuentoEspecial(double porcentaje) {
        return true;
    }

    public boolean rechazarMatricula() {
        if (validarMatricula()) {
            this.estado = "Rechazada";
            return true;
        } else {
            return false;
        }
    }

    public void mostrarDetalles() {
        System.out.print("Estudiante: " + getNombreEstudiante());
        System.out.println("Carrera: " + getCarrera());
        System.out.println("Asignaturas matriculadas: " + getNumeroAsignaturas());
        System.out.println("Créditos totales: " + getCreditosTotales());
        System.out.println("Matricula: " + getEstado());
        System.out.println("Beca: " + isTieneBeca() + " con descuento " + getDescuentoBeca());
        if (isTieneBeca()) {
            System.out.println("Coste de matrícula: " + calcularCosteMatricula());
            System.out.println("Tasa administrativa: " + calcularTasaAdministrativa());
            System.out.println("Coste total a pagar: " + calcularCosteTotal());
            //ahorro por beca
        }

    }

    public void mostrarReciboMatricula() {
        if (validarMatricula()) {
            System.out.print("Estudiante: " + getNombreEstudiante() + "Carrera: " + getCarrera());
            System.out.println("Costes: Créditos " + getCreditosTotales() + "x Precio " + calcularCosteTotal()); //revisar
            System.out.println("Descuento aplicado: " + aplicarDescuentoEspecial(creditosTotales)); //revisar
            System.out.println("Tasa administrativa: " + calcularTasaAdministrativa());
            System.out.println("Total a pagar: " + calcularCosteTotal());
        }
    }

    public void mostrarOpcionesPago() {

    }

    
    //Getters
    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getEstado() {
        return estado;
    }

    public int getNumeroAsignaturas() {
        return numeroAsignaturas;
    }

    public int getCreditosTotales() {
        return creditosTotales;
    }

    public double getPrecioPorCredito() {
        return precioPorCredito;
    }

    public double getDescuentoBeca() {
        return descuentoBeca;
    }

    public boolean isTieneBeca() {
        return tieneBeca;
    }
    

}