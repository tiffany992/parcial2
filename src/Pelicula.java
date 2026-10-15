

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pelicula {

    private final String codigo;
    private String titulo;
    private final int duracionMinutos;
    private final Genero genero;
    private String clasificacionEdad;

    private final List<Funcion> funciones = new ArrayList<>();

    /**
     * metodo de Pelicula
     * @param codigo
     * @param titulo
     * @param duracionMinutos
     * @param genero
     * @param clasificacionEdad
     */
    public Pelicula(String codigo, String titulo, int duracionMinutos,
                    Genero genero, String clasificacionEdad) {
        if (duracionMinutos <= 0) {
            throw new IllegalArgumentException("La duracion debe ser mayor que cero.");
        }
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.genero = genero;
        this.clasificacionEdad = clasificacionEdad;
    }

    void agregarFuncion(Funcion funcion) {
        funciones.add(funcion);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    public List<Funcion> getFunciones() {
        return Collections.unmodifiableList(funciones);
    }

    @Override
    public String toString() {
        return titulo + " (" + duracionMinutos + " min, " + genero + ", " + clasificacionEdad + ")";
    }
}