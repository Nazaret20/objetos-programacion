import java.util.Scanner;

public class AppLavadora {
    public static void main(String[] args) throws Exception {
        Lavadora lavado = new Lavadora();
        Scanner sc = new Scanner(System.in);
        int opc;

        do {
        System.out.println("\n=== LAVADORA ===");
        System.out.println("1. Abrir puerta");
        System.out.println("2. Cerrar puerta");
        System.out.println("3. Llenar agua");
        System.out.println("4. Vaciar agua");
        System.out.println("5. Establecer temperatura");
        System.out.println("6. Iniciar lavado");
        System.out.println("7. Detener lavado");
        System.out.println("8. Ver estado");
        System.out.println("0. Salir");
        System.out.print("\n¿Qué necesitas hacer? ");
        opc = sc.nextInt();

        switch (opc) {
            case 1:
                boolean seAbrio = lavado.abrirPuerta();
                if (seAbrio) {
                    System.out.println("La puerta se pudo abrir");
                } else {
                    System.out.println("La puerta ya está abierta");
                }
                break;
            case 2:
                boolean seCerro = lavado.cerrarPuerta();
                if (seCerro) {
                    System.out.println("La puerta se pudo cerrar");
                } else {
                    System.out.println("La puerta ya está cerrada");
                }
                break;
            case 3:
                System.out.println("¿Qué nivel de agua necesitas?");
                int nivel = sc.nextInt();
                boolean seLleno = lavado.llenarAgua(nivel);
                if (seLleno) {
                    System.out.println("Se pudo llenar de agua");
                } else {
                    System.out.println("No se pudo llenar porque es más de 10");
                }
                break;
            case 4:
                boolean seVacio = lavado.vaciarAgua();
                if (seVacio) {
                    System.out.println("El agua se pudo vaciar");
                } else {
                    System.out.println("El agua no se pudo vaciar");
                }
                break;
            case 5:
                System.out.println("Qué temperatura necesitas poner?");
                int temp = sc.nextInt();
                boolean ponerTemp = lavado.establecerTemperatura(temp);
                if (ponerTemp) {
                    System.out.println("Temperatura establecida");
                } else {
                    System.out.println("No se pudo establecer temperatura");
                }
            case 6:
                boolean seInicioLavado = lavado.iniciarLavado();
                if (seInicioLavado) {
                    System.out.println("Lavadora en funcionamiento...");
                } else {
                    System.out.println("No se puede iniciar lavado");
                }
                break;
            case 7:
                boolean seDetuvo = lavado.detenerLavado();
                if (seDetuvo) {
                    System.out.println("Lavadora detenida");
                } else {
                    System.out.println("No se pudo detener lavadora");
                }
                break;
            case 8:
                lavado.mostrarEstado();
                break;
            case 0:
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        } while (opc != 0);

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
        if (this.puertaAbierta == true) {
            return false;
        }

        if (this.enFuncionamiento == true || this.nivelAgua > 0) {
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
        if (this.puertaAbierta == true) {
            return false;
        } 
        if (this.enFuncionamiento == true) {
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
        if (this.nivelAgua >= 1) {
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