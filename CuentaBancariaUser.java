public class CuentaBancariaUser {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("ES00123456789", 5000, "Daya");

        cuenta1.datosDeCuenta();

        cuenta1.depositar(500);

        System.out.println("Tu saldo actual es de " + cuenta1.consultarSaldo());

        cuenta1.extraer(1000);
        
        System.out.println("Tu saldo actual es de " + cuenta1.consultarSaldo());
    }

}
