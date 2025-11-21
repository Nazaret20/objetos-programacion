import java.util.Scanner;

public class AppLavadora {
    public static void main(String[] args) throws Exception {
        Lavadora lavado = new Lavadora();
        Scanner sc = new Scanner(System.in);
        int opc;

        System.out.println("=== LAVADORA ===");
        System.out.println("1. Abrir puerta");
        System.out.println("2. Cerrar puerta");
        System.out.println("3. Llenar agua");
        System.out.println("4. Vaciar agua");
        System.out.println("5. Establecer temperatura");
        System.out.println("6. Iniciar lavado");
        System.out.println("7. Detener lavado");
        System.out.println("8. Ver estado");
        System.out.println("0. Salir");
        System.out.print("¿Qué necesitas hacer? ");
        opc = sc.nextInt();

        System.out.println(lavado.abrirPuerta());
        
        sc.close();
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
        if (this.nivelAgua > 1) {
            this.nivelAgua = 0;
            return true;
        } else {
            return false;
        }
    }

    public boolean iniciarLavado() {
        if (this.puertaAbierta && this.nivelAgua > 0) {
           return this.enFuncionamiento = true;
             
        } else {
            return false;
        }
    }

    public boolean detenerLavado() {
         return this.enFuncionamiento;
        
    }

    public void mostrarEstado() {
        System.out.println("La puerta está " + this.puertaAbierta);
        System.out.println("La lavadora está " + this.enFuncionamiento);
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