import java.util.Random;
import java.util.Scanner;

public class JuegoDados {
    public static void main(String[] args) throws Exception {
        Dado jug1 = new Dado();
        Dado jug2 = new Dado();
        Scanner tcl = new Scanner(System.in);
        
        System.out.println(jug1.lanzar());
       
    }
}

class Dado {
    private int numeroCaras, ultimoValor, valorActual;
    private String nombre1, nombre2;
    

    public Dado() {
        this.numeroCaras = 6;
        this.valorActual = 0;
    }

    public int getNumeroCaras() {
        return numeroCaras;
    }

    public void setNumeroCaras(int numeroCaras) {
        this.numeroCaras = numeroCaras;
    }

    public int getValorActual() {
        return valorActual;
    }

    public void setValorActual(int valorActual) {
        this.valorActual = valorActual;
    }

    public int getUltimoValor() {
        return ultimoValor;
    }

    public void setUltimoValor(int ultimoValor) {
        this.ultimoValor = ultimoValor;
    }

    public String getNombre1() {
        System.out.println("Nombre del jugador 1: ");
        
        return nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public int lanzar() {
        Random random = new Random();
        int numero = random.nextInt(6) + 1;
        return numero;
    }

    public boolean esPar() {
        return true;
    }

    public void resetear() {
        this.ultimoValor = 0;
        this.valorActual = 0;
    }

    @Override
    public String toString() {
        return "";
    }
}   