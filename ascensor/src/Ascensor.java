public class Ascensor {
    //Atributos
    private int pisoActual, pisoMaximo;
    private boolean enMovimiento, puertaAbierta;

    //Constructores
    Ascensor() {
        this.pisoActual = 0;
        this.pisoMaximo = 10;
        this.enMovimiento = false;
        this.puertaAbierta = false;
    }

    Ascensor(int pisoMaximo) {
        this.pisoActual = 0;
        this.pisoMaximo = pisoMaximo;
        this.enMovimiento = false;
        this.puertaAbierta = false;
    }

    //Getters
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

    //Métodos propios
    public boolean subirPiso() {
        if(!puertaAbierta && pisoActual < pisoMaximo) {
            enMovimiento = true;
            pisoActual++;
            enMovimiento = false;
            return true;
        }
        else
            return false;
    }
    
    public boolean bajarPiso() {
        if(!puertaAbierta && pisoActual > 0) {
            enMovimiento = true;
            pisoActual--;
            enMovimiento = false;
            return true;
        }
        else
            return false;
    }

    public boolean abrirPuerta() {
        if(enMovimiento || puertaAbierta)
            return false;
        else {
            puertaAbierta = true;
            return true;
        }
    }

    public boolean cerrarPuerta() {
        if(!puertaAbierta)
            return false;
        else {
            puertaAbierta = false;
            return true;
        }
    }

    public boolean irAPiso(int pisoDestino) {
        if(pisoDestino < 0 || pisoDestino > pisoMaximo || pisoActual == pisoDestino) {
            return false;
        }
        else {
            cerrarPuerta();
            if(pisoDestino > pisoActual) {
                for(int piso = pisoActual; piso < pisoDestino; piso++) {
                    subirPiso();
                    System.out.print(piso + " -> ");
                }
            }
            else {
                for(int piso = pisoActual; piso > pisoDestino; piso--) {
                    bajarPiso();
                    System.out.print(piso + " -> ");
                }
            }
            return true;
        }
    }

    public void activarEmergencia() {
        enMovimiento = false;
        abrirPuerta();
        System.out.println("EMERGENCIA EN PISO " + pisoActual);
    }

    public void verificarEstado() {
        System.out.println("Piso Actual:\t" + pisoActual);
        if(puertaAbierta)
            System.out.println("Puerta:\t\tAbierta" );
        else
            System.out.println("Puerta:\t\tCerrada" );
        if(enMovimiento)
            System.out.println("Estado:\t\tEn movimiento" );
        else
            System.out.println("Puerta:\t\tDetenido" );
        System.out.println("Piso Máximo:\t" + pisoMaximo);
    }
}