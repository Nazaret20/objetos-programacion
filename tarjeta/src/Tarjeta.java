public class Tarjeta {
    private String id, propietario;
    private boolean activa;
    private int nivelAcceso;

    public Tarjeta(String id, String propietario) {
        this.id = id;
        this.propietario = propietario;
        this.activa = true;
        this.nivelAcceso = 1;
    }

    public Tarjeta(String id, String propietario, int nivelAcceso) {
        this.id = id;
        this.propietario = propietario;
        this.activa = true;
        if(this.nivelAcceso > 4)
            this.nivelAcceso = 4;
        if(this.nivelAcceso < 1)
            this.nivelAcceso = 1;
        this.nivelAcceso = nivelAcceso;
    }

    //Métodos propios
    public boolean activarTarjeta() {
        if (!this.activa) {
            this.activa = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean desactivarTarjeta() {
        if (!this.activa) {
            return false;
        } else {
            this.activa = false;
            return true;
        }
    }

    public boolean aumentarNivelAcceso() {
        if (!this.activa && this.nivelAcceso == 4) {
            return false;
        } else {
            this.nivelAcceso++;
            if (this.nivelAcceso > 4) {
                System.out.println("No puedes aumentar el nivel más del 4");
                this.nivelAcceso = 4;
            }
            return true;
        }
    }

    public boolean disminuirNivelAcceso() {
        if (!this.activa && this.nivelAcceso == 1) {
            return false;
        } else {
            this.nivelAcceso--;
            if (this.nivelAcceso < 1) {
                System.out.println("No puedes disminuir el nivel menos del 1");
                this.nivelAcceso = 1;
            }
            return true;
        }
    }

    public boolean verificarAcceso(int nivelRequerido) {
        if (this.activa && this.nivelAcceso >= nivelRequerido) {
            return true;
        } else {
            return false;
        }
    }

    public void mostrarInformacion() {
        String estado;
        if (isActiva()) {
            estado = "Activa";
        } else {
            estado = "Inactiva";
        }

        System.out.println("--------------------------");
        System.out.println("ID de la tarjeta: " + getId());
        System.out.println("Propietario: " + getPropietario());
        System.out.println("Estado: " + estado);
        System.out.println("Nivel de acceso: " + getNivelAcceso());
        System.out.println("\n--------------------------\n");

    }

    //Getter y setter
    public String getId() {
        return id;
    }

    public String getPropietario() {
        return propietario;
    }

    public boolean isActiva() {
        return activa;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}