public class CuentaBancaria {
   private String numeroCuenta;
   private double saldo;
   private String titular;


   public CuentaBancaria(String numeroCuenta, double saldo, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.titular = titular;
   }

   public getNumeroCuenta() {
    System.out.println("Introduce tu número de cuenta");
   }

   public extraccion() {
        if (this.saldo < 0) {
            System.out.println("Estás a 0, no puedes sacar dinero");
        } else {
            System.out.println("Has sacado %f", this.saldo);
        }
   }
}
