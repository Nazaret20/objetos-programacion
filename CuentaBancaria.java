public class CuentaBancaria {
   private String numeroCuenta;
   private double saldo;
   private String titular;


    public CuentaBancaria(String numeroCuenta, double saldo, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.titular = titular;
   }

    public void depositar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("No tienes nada para ingresar.");
            return;
        }
        this.saldo += cantidad;
        System.out.println("Has depositado un total de " + cantidad + " euros.");
   }

    public void extraer(double cantidad) {
       if (this.saldo <= 0) {
           System.out.println("Estás a 0, no puedes sacar dinero");
       } else if (cantidad > this.saldo) {
           System.out.println("No puedes sacar más dinero del que tienes actualmente");
       } else {
           this.saldo -= cantidad;
           System.out.println("Has sacado un total de " + cantidad + " euros.");
       }
   }

    public double consultarSaldo() {
        return this.saldo;
    }

    public void datosDeCuenta() {
        System.out.println("Titular: " + this.titular);
        System.out.println("Número de cuenta: " + this.numeroCuenta);
        System.out.println("Saldo: " + this.saldo);
    }

}
