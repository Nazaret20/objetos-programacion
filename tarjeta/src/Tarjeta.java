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
        this.nivelAcceso = nivelAcceso;
    }

    //Métodos propios
    public boolean activarTarjeta() {
        if (this.activa) {
            return true;
        } else {
            return false;
        }
    }

    public boolean desactivarTarjeta() {
        if (!this.activa) {
            return true;
        } else {
            return false;
        }
    }

    public boolean aumentarNivelAcceso() {
        if (!this.activa || this.nivelAcceso <= 4) {
            return false;
        } else {
            this.nivelAcceso++;
            return true;
        }
    }

    public boolean disminuirNivelAcceso() {
        if (!this.activa || this.nivelAcceso >= 1) {
            return false;
        } else {
            this.nivelAcceso++;
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
        System.out.println("ID de la tarjeta: " + getId());
        System.out.println("Propietario: " + getPropietario());
        System.out.println("Estado: " + isActiva());
        System.out.println("Nivel de acceso: " + getNivelAcceso());
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