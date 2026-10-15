

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Funcion {

    private final String codigo;
    private final LocalDate fechaPresentacion;
    private final LocalTime horaInicio;
    private final double precioBase;

    private final Pelicula pelicula;
    private final Sala sala;
    private final List<Boleta> boletas = new ArrayList<>();

    /**
     * metodo de Funcion
     * @param codigo
     * @param fechaPresentacion
     * @param horaInicio
     * @param precioBase
     * @param pelicula
     * @param sala
     */
    public Funcion(String codigo, LocalDate fechaPresentacion, LocalTime horaInicio,
                   double precioBase, Pelicula pelicula, Sala sala) {


        LocalTime horaFin = horaInicio.plusMinutes(pelicula.getDuracionMinutos());
        if (!sala.estaDisponible(fechaPresentacion, horaInicio, horaFin)) {
            throw new IllegalStateException("La sala " + sala.getNombre()
                    + " no esta disponible en ese horario.");
        }
        this.codigo = codigo;
        this.fechaPresentacion = fechaPresentacion;
        this.horaInicio = horaInicio;
        this.precioBase = precioBase;
        this.pelicula = pelicula;
        this.sala = sala;

        sala.agregarFuncion(this);
        pelicula.agregarFuncion(this);
    }

    // Hora de fin = hora de inicio + duracion de la pelicula
    public LocalTime calcularHoraFin() {
        return horaInicio.plusMinutes(pelicula.getDuracionMinutos());
    }

    // Indica si el asiento ya fue vendido para ESTA funcion
    public boolean asientoOcupado(int fila, int numero) {
        for (Boleta b : boletas) {
            if (b.getFila() == fila && b.getNumeroAsiento() == numero) {
                return true;
            }
        }
        return false;
    }

    /**
     * metodo de calcularPrecioBoleta
     * @param descuento
     * @return
     */
    // Primero el recargo de la sala (polimorfismo) y luego el descuento (0 a 100)
    public double calcularPrecioBoleta(double descuento) {
        double conRecargo = precioBase * (1 + sala.calcularRecargo());
        return conRecargo * (1 - descuento / 100.0);
    }

    void registrarBoleta(Boleta boleta) {
        boletas.add(boleta);
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getFechaPresentacion() {
        return fechaPresentacion;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public List<Boleta> getBoletas() {
        return Collections.unmodifiableList(boletas);
    }

    @Override
    public String toString() {
        return pelicula.getTitulo() + " | " + sala.getNombre() + " | "
                + fechaPresentacion + " " + horaInicio + "-" + calcularHoraFin();
    }
}