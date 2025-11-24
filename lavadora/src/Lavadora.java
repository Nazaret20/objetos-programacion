public class Lavadora {
    private boolean puertaAbierta, enFuncionamiento;
    private int nivelAgua, temperatura;

    public Lavadora() {
        this.puertaAbierta = false;
        this.enFuncionamiento = false;
        this.nivelAgua = 0;
        this.temperatura = 0;
    }

    // Métodos propios
    public boolean abrirPuerta() {
        if (this.puertaAbierta == true) {
            return false;
        }
        
        //  isEnFuncionamiento()
        if (this.enFuncionamiento == true  || this.nivelAgua > 0) {
            return false;
        } else {
            this.puertaAbierta = true;
            return true; 
        }
    }

    public boolean cerrarPuerta() {
        if (this.puertaAbierta == true) {
            this.puertaAbierta = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean llenarAgua(int nivel) {
        if (this.puertaAbierta == true || this.enFuncionamiento == true) {
            return false;
        } 

        int sumaNivelAgua = this.nivelAgua + nivel;
        if (sumaNivelAgua >= 1 && sumaNivelAgua <= 10) {
            this.nivelAgua = nivel;
            return true;
        } else {
            return false;
        }
    }

    public boolean vaciarAgua() {
        if (this.nivelAgua >= 0) {
            this.nivelAgua = 0;
            return true;
        } else {
            return false;
        }
    }

    public boolean establecerTemperatura(int temp) {
        if (this.nivelAgua == 0) {
            return false;
        }
        
        int sumaTemp = this.temperatura + temp;

        if(sumaTemp >= 0 && sumaTemp <= 90){
            this.temperatura = sumaTemp;
            return true;
        } else {
            return false;
        }
    }

    public boolean iniciarLavado() {
        if (this.puertaAbierta == false && this.nivelAgua > 0) {
           this.enFuncionamiento = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean detenerLavado() {
        if (this.enFuncionamiento == true) {
            this.enFuncionamiento = false;
            return true;
        } else {
            return false;
        }
        
    }

    public void mostrarEstado() {
        if (this.puertaAbierta == true) {
            System.out.println("La puerta está abierta.");
        } else {
            System.out.println("La puerta está cerrada.");
        }

        if (this.enFuncionamiento == true) {
            System.out.println("La lavadora está lavando.");
        } else {
            System.out.println("La lavadora está detenida.");
        }
        
        System.out.println("El nivel del agua es " + this.nivelAgua);
        System.out.println("La temperatura es de " + this.temperatura);

    }

    // Getters
    public boolean isPuertaAbierta() {
        return puertaAbierta;
    }

    public boolean isEnFuncionamiento() {
        return enFuncionamiento;
    }

    public int getNivelAgua() {
        return nivelAgua;
    }

    public int getTemperatura() {
        return temperatura;
    }

}