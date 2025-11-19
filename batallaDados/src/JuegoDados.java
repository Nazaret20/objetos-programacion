import java.util.Random;
import java.util.Scanner;

public class JuegoDados {
    public static void main(String[] args) throws Exception {
        String jug1, jug2;
        Dado dJug1A = new Dado();
        Dado dJug1B = new Dado(); 
        Dado dJug2A = new Dado(); 
        Dado dJug2B = new Dado();
        int ronda, puntosJug1 = 0, puntosJug2 = 0, sumaJud1 = 0, sumaJud2 = 0;
        Scanner tcl = new Scanner(System.in);
        
        
        System.out.println("------------BATALLA DE DADOS-----------");
        System.out.print("Nombre jugador 1: ");
        jug1 = tcl.nextLine();
        System.out.print("Nombre jugador 2: ");
        jug2 = tcl.nextLine();

        for (ronda = 1; ronda <= 5; ronda++) {
            //Jugador 1
            System.out.println("\n=== RONDA " + ronda + " ===");
            dJug1A.lanzar();
            dJug1B.lanzar();
            sumaJud1 = dJug1A.getValorActual() + dJug1B.getValorActual();
            System.out.println("-Lanza " + jug1 + ": " + dJug1A.getValorActual() + " + " + dJug1B.getValorActual() + " = " + sumaJud1);
            
            if (dJug1A.esPar() && dJug1B.esPar() && dJug1A.getValorActual() == dJug1B.getValorActual()) {
                System.out.println("** " + jug1 + " obtiene BONUS por dobles pares");
                puntosJug1++;
            }

            //Jugador 2
            System.out.println("\n=== RONDA " + ronda + " ===");
            dJug2A.lanzar();
            dJug2B.lanzar();
            sumaJud2 = dJug2A.getValorActual() + dJug2B.getValorActual();
            System.out.println("-Lanza " + jug2 + ": " + dJug2A.getValorActual() + " + " + dJug2B.getValorActual() + " = " + sumaJud2);

            if (dJug2A.esPar() && dJug2B.esPar() && dJug2A.getValorActual() == dJug2B.getValorActual()) {
                System.out.println("** " + jug2 + " obtiene BONUS por dobles pares");
                puntosJug2++;
            }

            
            if (sumaJud1 > sumaJud2) {
                System.out.println("Ha ganado " + jug1);
                puntosJug1++;  
            } 
    
            if (sumaJud1 < sumaJud2) {
                System.out.println("Ha ganado " + jug2);
                puntosJug2++;  
            } 
    
            if (sumaJud1 == sumaJud2) {
                System.out.println("Ronda empatada");
                puntosJug1++;
                puntosJug2++;  
            } 
    
            System.out.printf("Puntuaciones: %s -> %d | %S -> %d\n", jug1, puntosJug1, jug2, puntosJug2);
        }

        if (puntosJug1 > puntosJug2) {
            System.out.println("Ha ganado " + jug1);
        }
        if (puntosJug1 < puntosJug2) {
            System.out.println("Ha ganado " + jug2);
        }
        if (puntosJug1 == puntosJug2) {
            System.out.println("Empate");
        }
       

        tcl.close();
    }
}

class Dado {
    private int numeroCaras, ultimoValor, valorActual;
    
    //Constructor
    public Dado() {
        this.numeroCaras = 6;
        this.valorActual = 0;
        this.ultimoValor = 0;
    }

    public Dado(int numeroCaras) {
        this.numeroCaras = numeroCaras;
        this.valorActual = 0;
        this.ultimoValor = 0;
    }

    //Get y set
    public int getNumeroCaras() {
        return numeroCaras;
    }

    public void setNumeroCaras(int numeroCaras) {
        this.numeroCaras = numeroCaras;
    }
    
    //Métodos propios
    public void lanzar() {
        Random random = new Random();
        this.ultimoValor = this.valorActual;
        this.valorActual = random.nextInt(numeroCaras) + 1;
    }

    public int getValorActual() {
        return valorActual;
    }

    public int getUltimoValor() {
        return ultimoValor;
    }


    public boolean esPar() {
        if (this.valorActual % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void resetear() {
        this.ultimoValor = 0;
        this.valorActual = 0;
    }

    @Override
    public String toString() {
        return "Este dado tiene" + this.numeroCaras + ". \nEl valor actual es" + this.valorActual + ". \nEl valor anterior era " + this.ultimoValor + ".\n";
    }
}   