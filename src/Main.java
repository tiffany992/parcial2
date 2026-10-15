

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        // 1. Cine, salas (cada una de su tipo) y peliculas
        Cine cine = new Cine("CinePlus", "900.123.456-7", "Armenia, Quindio");

        Sala salaTradicional = new SalaTradicional("S1", "Sala 1", 30, 5, 6);
        Sala salaVip = new SalaVip("S2", "Sala VIP", 20, 4, 5);
        Sala sala3D = new Sala3D("S3", "Sala 3D", 25, 5, 5);
        cine.agregarSala(salaTradicional);
        cine.agregarSala(salaVip);
        cine.agregarSala(sala3D);

        // Polimorfismo: cada sala responde su propio recargo
        for (Sala s : cine.getSalas()) {
            System.out.printf("%s -> recargo %.0f%%%n", s, s.calcularRecargo() * 100);
        }

        Pelicula peli1 = new Pelicula("P1", "Aventura Espacial", 120, Genero.ACCION, "+12");
        Pelicula peli2 = new Pelicula("P2", "Risas en Familia", 95, Genero.COMEDIA, "Todo publico");
        cine.agregarPelicula(peli1);
        cine.agregarPelicula(peli2);

        // 2. Personas
        Operario operario = new Operario("1094000111", "Laura Gomez", "laura@cineplus.com",
                "3101234567", "E-001", LocalDate.of(2024, 3, 15), 1_800_000);
        Cliente cliente = new Cliente("1094000222", "Carlos Ramirez", "carlos@correo.com",
                "3207654321", "AF-100", 10);

        // 3. Funciones
        LocalDate hoy = LocalDate.of(2026, 10, 15);
        Funcion f1 = cine.programarFuncion("F1", hoy, LocalTime.of(18, 0), 10000, peli1, salaVip);
        System.out.println("\nFuncion programada: " + f1);

        // Funcion que se traslapa en la misma sala (debe fallar)
        try {
            cine.programarFuncion("F2", hoy, LocalTime.of(19, 0), 10000, peli2, salaVip);
        } catch (IllegalStateException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        // Funcion en horario libre de la misma sala (debe funcionar)
        Funcion f3 = cine.programarFuncion("F3", hoy, LocalTime.of(20, 30), 10000, peli2, salaVip);
        System.out.println("Funcion programada: " + f3);

        // Funcion en sala 3D y en sala tradicional
        Funcion f4 = cine.programarFuncion("F4", hoy, LocalTime.of(18, 0), 10000, peli1, sala3D);
        Funcion f5 = cine.programarFuncion("F5", hoy, LocalTime.of(18, 0), 10000, peli2, salaTradicional);

        // 4. Venta con dos boletas (sala VIP, cliente con 10 % de descuento)
        System.out.println();
        Venta venta = cine.registrarVenta("V001", hoy, cliente, operario, f1);
        System.out.println(venta.agregarBoleta(1, 1));
        System.out.println(venta.agregarBoleta(1, 2));

        // Asiento ya ocupado (debe fallar)
        try {
            venta.agregarBoleta(1, 1);
        } catch (IllegalStateException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        // Asiento que no existe (debe fallar)
        try {
            venta.agregarBoleta(9, 9);
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        System.out.printf("Total de la venta %s: $%,.2f%n", venta.getCodigo(), venta.calcularTotal());

        // El mismo asiento si puede venderse para otra funcion
        Venta venta2 = cine.registrarVenta("V002", hoy, cliente, operario, f3);
        System.out.println(venta2.agregarBoleta(1, 1));
        System.out.printf("Total de la venta %s: $%,.2f%n", venta2.getCodigo(), venta2.calcularTotal());

        // Comparacion de precios por tipo de sala (mismo precio base y mismo cliente)
        System.out.println();
        System.out.printf("Boleta en %s: $%,.2f%n", f5.getSala(),
                f5.calcularPrecioBoleta(cliente.getPorcentajeDescuento()));
        System.out.printf("Boleta en %s: $%,.2f%n", f4.getSala(),
                f4.calcularPrecioBoleta(cliente.getPorcentajeDescuento()));
        System.out.printf("Boleta en %s: $%,.2f%n", f1.getSala(),
                f1.calcularPrecioBoleta(cliente.getPorcentajeDescuento()));
    }
}
