public class AppBiblioteca {
    public static void main(String[] args) throws Exception {
        Libro lib = new Libro("El Quijote", "Miguel de Cervantes", 2);

        lib.mostrarInfo();

        if (lib.prestar())
            System.out.println("Prestado: " + lib.getTitulo());
        else
            System.out.println("No se ha podido prestar " + lib.getTitulo());

        if (lib.prestar())
            System.out.println("Prestado: " + lib.getTitulo());
        else
            System.out.println("No se ha podido prestar " + lib.getTitulo());

        if (lib.prestar())
            System.out.println("Prestado: " + lib.getTitulo());
        else
            System.out.println("No se ha podido prestar " + lib.getTitulo());

        lib.mostrarInfo();

        if (lib.devolver())
            System.out.println("Devuelto: " + lib.getTitulo());
        else
            System.out.println("Ese libro no es mío, busca otra biblioteca.");

        if (lib.devolver())
            System.out.println("Devuelto: " + lib.getTitulo());
        else
            System.out.println("Ese libro no es mío, busca otra biblioteca.");

        if (lib.devolver())
            System.out.println("Devuelto: " + lib.getTitulo());
        else
            System.out.println("Ese libro no es mío, busca otra biblioteca.");

        lib.mostrarInfo();

    }
}

class Libro {
    private String titulo, autor;
    private int ejemplares, prestados;

    Libro(String titulo, String autor, int ejemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplares = ejemplares;
        this.prestados = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public int getPrestados() {
        return prestados;
    }

    public void setPrestados(int prestados) {
        this.prestados = prestados;
    }

    public boolean prestar() {
        if (ejemplares - prestados > 0) {
            prestados++;
            return true;
        } else
            return false;
    }

    public boolean devolver() {
        if (prestados > 0) {
            prestados--;
            return true;
        } else
            return false;
    }

    public void mostrarInfo() {
        System.out.println(getAutor() + " -> " + titulo
                + " (" + (ejemplares - prestados) + " / " + getEjemplares() + ")");
    }
}