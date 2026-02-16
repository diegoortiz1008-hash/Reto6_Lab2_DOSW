package com.example.Reto6LabDOSW2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Reto6LabDOSW2 {

    public static void main(String[] args) {

        // Cadena: Básico -> Intermedio -> Avanzado
        Tecnico basico = new TecnicoBasico("Técnico Básico");
        Tecnico intermedio = new TecnicoIntermedio("Técnico Intermedio");
        Tecnico avanzado = new TecnicoAvanzado("Técnico Avanzado");
        basico.setSiguiente(intermedio).setSiguiente(avanzado);

        Scanner sc = new Scanner(System.in);

        System.out.print("Número de tickets: ");
        int n = leerEntero(sc);

        List<Ticket> tickets = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nTicket " + i + ":");

            System.out.print("Nivel: ");
            String nivel = leerNoVacio(sc).toUpperCase();

            System.out.print("Prioridad: ");
            String prioridad = leerNoVacio(sc).toUpperCase();

            System.out.print("Descripción: ");
            String descripcion = leerNoVacio(sc);

            tickets.add(new Ticket(i, nivel, prioridad, descripcion));
        }

        System.out.println("\n=== Procesamiento de tickets ===");


        tickets.forEach(basico::procesar);

        tickets.forEach(t -> System.out.println(mensajeFinal(t)));

        long resueltos = tickets.stream().filter(Ticket::isResuelto).count();
        long pendientes = tickets.stream().filter(t -> !t.isResuelto()).count();

        Map<String, Long> porTecnico = tickets.stream()
                .filter(Ticket::isResuelto)
                .collect(Collectors.groupingBy(Ticket::getResueltoPor, Collectors.counting()));

        double promedioPrioridad = tickets.stream()
                .filter(Ticket::isResuelto)
                .mapToInt(Ticket::valorPrioridad)
                .average()
                .orElse(0.0);

        System.out.println("\n--- Estadísticas ---");
        System.out.println("Tickets resueltos: " + resueltos);
        System.out.println("Básico: " + porTecnico.getOrDefault("TÉCNICO BÁSICO", 0L));
        System.out.println("Intermedio: " + porTecnico.getOrDefault("TÉCNICO INTERMEDIO", 0L));
        System.out.println("Avanzado: " + porTecnico.getOrDefault("TÉCNICO AVANZADO", 0L));
        System.out.println("Tickets pendientes: " + pendientes);
        System.out.println("Promedio de prioridad de tickets resueltos: " + String.format("%.1f", promedioPrioridad));

        sc.close();
    }

    private static String mensajeFinal(Ticket t) {
        if (!t.isResuelto()) {
            return "Ticket " + t.getId() + ": Ningún técnico disponible. Ticket pendiente de escalamiento.";
        }

        String quien = t.getResueltoPor();

        if ("TÉCNICO BÁSICO".equals(quien)) {
            return "Ticket " + t.getId() + ": Básico resolvió el problema.";
        }
        if ("TÉCNICO AVANZADO".equals(quien)) {
            return "Ticket " + t.getId() + ": Técnico Avanzado resolvió el problema.";
        }
        return "Ticket " + t.getId() + ": Técnico Intermedio resolvió el problema.";
    }


    private static int leerEntero(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un número válido: ");
            }
        }
    }

    private static String leerNoVacio(Scanner sc) {
        while (true) {
            String line = sc.nextLine();
            if (line != null && !line.trim().isEmpty()) return line.trim();
            System.out.print("No puede estar vacío. Intenta de nuevo: ");
        }
    }
}
