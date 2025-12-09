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
        if (validarAsignaturas() && validarCreditosTotales() && validarCreditoXAsignatura()) {
            this.estado = "Confirmada";
            calcularTasaAdministrativa();
            return true;  
        } else {
            this.estado = "Rechazada";
            return false;
        }
    }

    private boolean validarAsignaturas() {
        if (this.numeroAsignaturas >= 3 && this.numeroAsignaturas <= 10) {
            return true;
        } 
        return false;
    }

    private boolean validarCreditosTotales() {
        if (this.creditosTotales >= 18 && this.creditosTotales <= 75) {
            return true; 
        }
        return false;
    }

    private boolean validarCreditoXAsignatura() {
        double creditoXAsigntura = calcularCreditosMediosPorAsignatura();
        if (creditoXAsigntura >= 3 && creditoXAsigntura <= 12) {
            return true;
        } 
        return false;
    }

    /*-------------------------------------------*/
    
    public double calcularCosteMatricula() {
        if (validarMatricula()) {
            double costeTotalMatricula = this.creditosTotales * this.precioPorCredito * (1 - this.descuentoBeca / 100);

            double redondeoCosteMatricula = Math.round(costeTotalMatricula * 100) / 100.0;  
            return redondeoCosteMatricula;
        } else {
            return 0;
        }
    }

    /*-------------------------------------------*/

    public int calcularTasaAdministrativa() {
        int tasaBase = 150;
        if (isTieneBeca()) {
            tasaBase = 50;
            return tasaBase;
        } else if (this.estado == "Pendiente") {
            return 0;
        } else {
            return tasaBase;
        } 
    }

    /*-------------------------------------------*/

    public double calcularCosteTotal() {
        if (validarMatricula()) {
            double costeTotal = calcularCosteMatricula() + calcularTasaAdministrativa();
            return costeTotal;
        } else {
            return 0;
        }
    }

    /*-------------------------------------------*/

    public double calcularCreditosMediosPorAsignatura() {
        double creditosMediosAsig = this.creditosTotales / this.numeroAsignaturas;
        double redondeoCreditosMediosAsig = Math.round(creditosMediosAsig * 10)  / 10.0;
        return redondeoCreditosMediosAsig;
    }

    /*-------------------------------------------*/

    public boolean añadirAsignatura(int creditosAsignatura) {
        if (this.estado == "Confirmada" || this.estado == "Rechazada") {
            return false;
        } else if (creditosAsignatura > 3 && creditosAsignatura < 12) {
            return false;
        } else if (this.creditosTotales > 75) {
            return false;
        } else if (this.numeroAsignaturas > 10) {
            return false;
        } else {
            this.numeroAsignaturas++;
            this.creditosTotales += creditosAsignatura;
            return true;
        }
    }

    //TO DO SEPARAR FUNCIONES

    /*-------------------------------------------*/

    public boolean eliminarAsignatura(int creditosAsignatura) {
        if (this.estado == "Confirmada" || this.estado == "Rechazada") {
            return false;
        } else if (creditosAsignatura > this.creditosTotales && creditosAsignatura < 0) {
            return false;
        } else if (this.creditosTotales > 18) {
            return false;
        } else {
            if (this.numeroAsignaturas > 1) {
                this.numeroAsignaturas--;
                this.creditosTotales -= creditosAsignatura;
                return true;
            } else {
                return false;
            }
        }
    }

    /*-------------------------------------------*/

    public boolean modificarBeca(boolean nuevaBeca) {
        if (this.estado == "Confirmada" || this.estado == "Rechazada") {
            return false;
        } else {
            if (nuevaBeca) {
                this.descuentoBeca = 50;
                return true;
            } else {
                this.descuentoBeca = 0;
                return false;
            }
        }
    }

    /*-------------------------------------------*/

    public double calcularPagoFraccionado(int numPlazos) {
        if (this.estado == "Pendiente" || this.estado == "Rechazada") {
            return 0;
        }

        if (numPlazos == 2 || numPlazos == 3 || numPlazos == 5) {
            double pagoFracc = (calcularCosteTotal() * 1.03) / numPlazos;
            return pagoFracc;
        } else {
            return 0;
        }
    }

    /*-------------------------------------------*/

    public boolean aplicarDescuentoEspecial(double porcentaje) {
        if (this.estado == "Confirmada" && (porcentaje >= 5  && porcentaje <= 30) && ((this.descuentoBeca + porcentaje) <= 70)) {
            this.descuentoBeca += porcentaje;
            return true;
        } else {
            return false;
        }
    }

    /*-------------------------------------------*/

    public boolean rechazarMatricula() {
        if (this.estado != "Rechazada") {
            this.estado = "Rechazada";
            return true;
        } else {
            return false;
        }
    }

    /*-------------------------------------------*/


    public void mostrarDetalles() {
        System.out.print("Estudiante: " + getNombreEstudiante());
        System.out.println("Carrera: " + getCarrera());
        System.out.println("Asignaturas matriculadas: " + getNumeroAsignaturas());
        System.out.println("Créditos totales: " + getCreditosTotales());
        System.out.println("Matricula: " + getEstado());
        System.out.println("Beca: " + isTieneBeca() + " con descuento " + getDescuentoBeca());
        if (this.estado == "Confirmada") {
            System.out.println("Coste de matrícula: " + calcularCosteMatricula());
            System.out.println("Tasa administrativa: " + calcularTasaAdministrativa());
            System.out.println("Coste total a pagar: " + calcularCosteTotal());
            System.out.println("Ahorro por beca: " + ahorroDeBeca());
        }
    }

    private double ahorroDeBeca() {
        double total = calcularCosteMatricula();
        double totalDescuentoAplicado = total * (this.descuentoBeca / 100);
        return totalDescuentoAplicado;
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