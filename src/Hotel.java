import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    private static List<Habitacion> habitaciones = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Crear habitaciones
        for (int i = 1; i <= 5; i++) {
            habitaciones.add(new Habitacion(i, "Estándar"));
        }

        int opcion;
        do {
            System.out.println("\n--- MENÚ HOTEL ---");
            System.out.println("1. Crear reserva");
            System.out.println("2. Ver habitaciones disponibles");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1:
                    crearReserva();
                    break;
                case 2:
                    verDisponibles();
                    break;
                case 3:
                    cancelarReserva();
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);
    }

    private static void crearReserva() {
        verDisponibles();
        System.out.print("Ingrese ID de la habitación a reservar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Habitacion h = buscarHabitacion(id);
        if (h != null && h.estaDisponible()) {
            System.out.print("Ingrese la fecha de reserva (dd/mm/aaaa): ");
            String fecha = scanner.nextLine();
            Reserva r = new Reserva(h, fecha);
            reservas.add(r);
            System.out.println("Reserva creada: " + r);
        } else {
            System.out.println("Habitación no disponible o no encontrada.");
        }
    }

    private static void verDisponibles() {
        System.out.println("\nHabitaciones disponibles:");
        for (Habitacion h : habitaciones) {
            if (h.estaDisponible()) {
                System.out.println(h);
            }
        }
    }

    private static void cancelarReserva() {
        System.out.print("Ingrese el ID de la reserva a cancelar: ");
        int id = scanner.nextInt();
        Reserva r = null;
        for (Reserva res : reservas) {
            if (res.getIdReserva() == id) {
                r = res;
                break;
            }
        }
        if (r != null) {
            r.getHabitacion().liberar();
            reservas.remove(r);
            System.out.println("Reserva cancelada correctamente.");
        } else {
            System.out.println("Reserva no encontrada.");
        }
    }

    private static Habitacion buscarHabitacion(int id) {
        for (Habitacion h : habitaciones) {
            if (h.getId() == id) {
                return h;
            }
        }
        return null;
    }
}
