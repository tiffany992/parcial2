

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Sala {

    private final String codigo;
    private String nombre;
    private final int capacidadMaxima;
    private final int filas;
    private final int columnas;

    private final List<Asiento> asientos = new ArrayList<>();
    private final List<Funcion> funciones = new ArrayList<>();

    /**
     * metodo de sala
     * @param codigo
     * @param nombre
     * @param capacidadMaxima
     * @param filas
     * @param columnas
     */

    public Sala(String codigo, String nombre, int capacidadMaxima, int filas, int columnas) {
        if (filas <= 0 || columnas <= 0) {
            throw new IllegalArgumentException("Las filas y columnas deben ser positivas.");
        }
        if (filas * columnas > capacidadMaxima) {
            throw new IllegalArgumentException(
                    "Los asientos (filas x columnas) superan la capacidad maxima de la sala.");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.filas = filas;
        this.columnas = columnas;
        generarAsientos();
    }

    // Metodo abstracto: cada tipo de sala define su recargo
    // (0.0 = 0 %, 0.30 = 30 %, 0.20 = 20 %)
    public abstract double calcularRecargo();

    private void generarAsientos() {
        for (int f = 1; f <= filas; f++) {
            for (int c = 1; c <= columnas; c++) {
                asientos.add(new Asiento(f, c));
            }
        }
    }

    // La sala esta libre si el rango de horas no se traslapa con otra funcion
    public boolean estaDisponible(LocalDate fecha, LocalTime inicio, LocalTime fin) {
        for (Funcion f : funciones) {
            if (f.getFechaPresentacion().equals(fecha)) {
                boolean seTraslapa = inicio.isBefore(f.calcularHoraFin())
                        && fin.isAfter(f.getHoraInicio());
                if (seTraslapa) {
                    return false;
                }
            }
        }
        return true;
    }

    public Asiento buscarAsiento(int fila, int numero) {
        for (Asiento a : asientos) {
            if (a.getFila() == fila && a.getNumero() == numero) {
                return a;
            }
        }
        return null;
    }

    void agregarFuncion(Funcion funcion) {
        funciones.add(funcion);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public List<Asiento> getAsientos() {
        return Collections.unmodifiableList(asientos);
    }

    public List<Funcion> getFunciones() {
        return Collections.unmodifiableList(funciones);
    }

    @Override
    public String toString() {
        return nombre + " [" + getClass().getSimpleName() + "]";
    }
}
