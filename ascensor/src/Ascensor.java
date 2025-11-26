public class Ascensor {
    private int pisoActual, pisoMaximo;
    private boolean enMovimiento, puertaAbierta;

    public Ascensor() {
        this.pisoActual = 0;
        this.pisoMaximo = 10;
        this.enMovimiento = false;
        this.puertaAbierta = false;
    }

    public Ascensor(int pisoMaximo) {
        this.pisoActual = 0;
        this.pisoMaximo = pisoMaximo;
        this.enMovimiento = false;
        this.puertaAbierta = false;
    }

    // Métodos propios
    public boolean subirPiso() {
        if (this.puertaAbierta == true || this.pisoMaximo > this.pisoMaximo) {
            this.enMovimiento = false;
        }

        if (this.enMovimiento == false) {
            this.pisoActual++;
            return this.enMovimiento = true;
        } else {
            return this.enMovimiento = false;
        }

    }

    public boolean bajarPiso() {
        if (this.puertaAbierta == true || this.pisoMaximo < 0) {
            return false;
        } else {
            this.enMovimiento = true;
            this.pisoActual--;
            return this.enMovimiento = false;
        }
    }

    public boolean abrirPuerta() {
        if (this.enMovimiento == true || this.puertaAbierta == true) {
            return false;  
        } else {
            return true;
        } 
    }

    public boolean cerrarPuerta() {
        if (this.puertaAbierta == true) {
            return this.puertaAbierta = false;
        } else {
            return true;
        } 
    }

    public boolean irAPiso(int pisoDestino) {
        if (pisoDestino >= 0 || pisoDestino <= this.pisoMaximo) {
            subirPiso();
        }

        if (this.puertaAbierta == true) {
            return false;
        } else {
            return true;
        }

        
    }

    public void activarEmergencia() {
        this.enMovimiento = false;
        abrirPuerta();
        System.out.println("EMERGENCIA en piso: " + getPisoActual());

    }

    public void verificarEstado() {
        System.out.println("Piso actual: " + getPisoActual());
        System.out.println("La puerta está: " + isPuertaAbierta());
        System.out.println("El movimiento es: " + isEnMovimiento());
        System.out.println("Piso máximo: " + getPisoActual());

    }

    // Getters
    public int getPisoActual() {
        return pisoActual;
    }

    public int getPisoMaximo() {
        return pisoMaximo;
    }

    public boolean isEnMovimiento() {
        return enMovimiento;
    }

    public boolean isPuertaAbierta() {
        return puertaAbierta;
    }
}
