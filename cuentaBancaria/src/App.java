public class App {
    public static void main(String[] args) {
      CuentaBancariaClase cuenta1 = new CuentaBancariaClase("ES00123456789", "Daya");

        cuenta1.datosDeCuenta();

        cuenta1.depositar(500);
        System.out.println("Después del depósito tu saldo es de " + cuenta1.consultarSaldo() + " euros.");

        cuenta1.extraer(200);
        System.out.println("Después del depósito tu saldo es de " + cuenta1.consultarSaldo() +  " euros.");
        cuenta1.datosDeCuenta();
    }
}


class CuentaBancariaClase {
    private String numeroCuenta;
    private double saldo;
    private String titular;

    CuentaBancariaClase(String numeroCuenta, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
        this.titular = titular;
    }

    public void depositar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("No se puede ingresar cantidades negativas.");
        }
        this.saldo += cantidad;
        System.out.println("Has depositado un total de " + cantidad + " euros.");
    }

    public void extraer(double cantidad) {
        if (this.saldo - cantidad >= 0) {
            this.saldo -= cantidad;
            System.out.println("Has sacado un total de " + cantidad + " euros.");
        } else {
            System.out.println("No puedes sacar más dinero del que tienes");
        }
    }

    public double consultarSaldo() {
        return this.saldo;
    }

    public void datosDeCuenta() {
        System.out.println("\n-------------------------");
        System.out.println("Titular: \t" + this.titular);
        System.out.println("Cuenta: \t" + this.numeroCuenta);
        System.out.println("-------------------------");

        System.out.println("Saldo: \t" + this.saldo);
        System.out.println("-------------------------");

    }

}