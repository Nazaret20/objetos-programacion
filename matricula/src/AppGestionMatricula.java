import java.util.Scanner;

public class AppGestionMatricula {
    public static int menu(Scanner sc) {
        System.out.println(
            "\n=== UNIVERSIDAD TECHMASTER - GESTIÓN DE MATRÍCULAS ===\r\n" + //
                        "\r\n" + //
            "1. Ver todas las matrículas\r\n" + //
            "2. Validar matrícula de estudiante\r\n" + //
            "3. Modificar matrícula (añadir/eliminar asignaturas)\r\n" + //
            "4. Gestionar beca de estudiante\r\n" + //
            "5. Ver detalles completos de una matrícula\r\n" + //
            "6. Comparar matrículas\r\n" + //
            "7. Generar recibo y opciones de pago\r\n" + //
            "0. Salir\n");
        System.out.print("Introduce tu elección: ");
        return Integer.parseInt(sc.nextLine());
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opc;

        Matricula mat1 = new Matricula("Ana Rodríguez", "Ingeniería Informática", 6, 48, true);
        Matricula mat2 = new Matricula("Carlos Fernández", "Administración de Empresas", 8, 60, false);
        Matricula mat3 = new Matricula("María López", "Medicina", 9, 72, true);

        System.out.println("¡Bienvenido a TechMaster!");

        do {
            opc = menu(sc);
            

        } while (opc != 0);


        sc.close();
    }
}
