class Reserva {
    private static int contador = 1;
    private int idReserva;
    private Habitacion habitacion;
    private String fecha;

    public Reserva(Habitacion habitacion, String fecha) {
        this.idReserva = contador++;
        this.habitacion = habitacion;
        this.fecha = fecha;
        this.habitacion.ocupar();
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Reserva #" + idReserva + " - Habitación " + habitacion.getId() + " - Fecha: " + fecha;
    }
}
