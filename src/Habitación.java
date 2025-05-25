
class Habitacion {
    private int id;
    private String tipo;
    private boolean disponible;

    public Habitacion(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
        this.disponible = true;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public void ocupar() {
        disponible = false;
    }

    public void liberar() {
        disponible = true;
    }

    @Override
    public String toString() {
        return "Habitación " + id + " (" + tipo + ") - " + (disponible ? "Disponible" : "Ocupada");
    }
}
