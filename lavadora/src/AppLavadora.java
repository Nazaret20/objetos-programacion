public class AppLavadora {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

class Lavadora {
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
        if (this.enFuncionamiento == true && this.nivelAgua > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean cerrarPuerta() {
        if (this.puertaAbierta == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean llenarAgua(int nivel) {
        if (nivel >= 1 && nivel <= 10) {
            return false;
        } else if (this.puertaAbierta == true) {
            return false;
        } else if (this.enFuncionamiento == true) {
            return false;
        } else {
            return true;
        }
    }

    public boolean vaciarAgua() {
        return true;
    }

    public boolean iniciarLavado() {
        return true;
    }

    public boolean detenerLavado() {
        return true;
    }

    public void mostrarEstado() {

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