public class App {
    public static void main(String[] args) {
        Calculadora ops = new Calculadora(2, 10);

        System.out.println("El resultado de la suma es " + ops.sumar());
        System.out.println("El resultado de la resta es " + ops.restar());
        System.out.println("El resultado de la multiplicación es " + ops.multiplicar());
        System.out.println("El resultado de la división es " + ops.dividir());
        System.out.printf("El resultado de potencia es %.2f\n", ops.potencia());
        System.out.printf("El resultado de raíz cuadrada es %.2f\n", ops.raizCuadrada());
        ops.borrarResultado();
        System.out.println("Al borrar el resultado es " + ops.getResultado());

    }
}

class Calculadora {
    private double numeroA, numeroB, resultado;

    Calculadora(double numeroA, double numeroB) {
        this.numeroA = numeroA;
        this.numeroB = numeroB;
        this.resultado = 0;
    }

    public double getResultado() {
        return this.resultado;
    }

    public double sumar() {
        this.resultado = this.numeroA + this.numeroB;
        return this.resultado;
    }

    public double restar() {
        this.resultado = this.numeroA - this.numeroB;
        return this.resultado;
    }

    public double multiplicar() {
        this.resultado = this.numeroA * this.numeroB;
        return this.resultado;
    }

    public double dividir() {
        if (this.numeroB == 0) {
            System.out.println("No puedes dividir por 0");
            this.resultado = 0;
        } else {
            this.resultado = this.numeroA / this.numeroB;
        }

        return this.resultado;
    }

    public double potencia() {
        this.resultado = Math.pow(numeroA, numeroB);
        return this.resultado;
    }

    public double raizCuadrada() {
        if (this.numeroA < 0) {
            System.out.println("No se pueden hacer raices cuadradas con negativos");
            this.resultado = 0;
        } else {
            this.resultado = Math.sqrt(numeroA);
        }

        return this.resultado;
    }

    public void borrarResultado() {
        this.resultado = 0;
    }
}