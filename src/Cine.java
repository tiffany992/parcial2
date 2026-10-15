

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cine {

    private final String nombreComercial;
    private final String nit;
    private final String direccion;

    private final List<Sala> salas = new ArrayList<>();
    private final List<Pelicula> catalogo = new ArrayList<>();

    /**
     * metodo de cine
     * @param nombreComercial
     * @param nit
     * @param direccion
     */
    public Cine(String nombreComercial, String nit, String direccion) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
    }

    public void agregarSala(Sala sala) {
        salas.add(sala);
    }

    public void agregarPelicula(Pelicula pelicula) {
        catalogo.add(pelicula);
    }

    /**
     * metodo  buscarSala
     * @param codigo
     * @return
     */

    public Sala buscarSala(String codigo) {
        for (Sala s : salas) {
            if (s.getCodigo().equals(codigo)) {
                return s;
            }
        }
        return null;
    }

    /**
     * metodo de buscarPelicula
     * @param codigo
     * @return
     */
    public Pelicula buscarPelicula(String codigo) {
        for (Pelicula p : catalogo) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    /**
     * metodo de programarFuncion
     * @param codigo
     * @param fecha
     * @param horaInicio
     * @param precioBase
     * @param pelicula
     * @param sala
     * @return
     */
    public Funcion programarFuncion(String codigo, LocalDate fecha, LocalTime horaInicio,
                                    double precioBase, Pelicula pelicula, Sala sala) {
        return new Funcion(codigo, fecha, horaInicio, precioBase, pelicula, sala);
    }

    /**
     * metodo registrarVenta
     * @param codigo
     * @param fecha
     * @param cliente
     * @param operario
     * @param funcion
     * @return
     */

    public Venta registrarVenta(String codigo, LocalDate fecha, Cliente cliente,
                                Operario operario, Funcion funcion) {
        return new Venta(codigo, fecha, cliente, operario, funcion);
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public String getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Sala> getSalas() {
        return Collections.unmodifiableList(salas);
    }

    public List<Pelicula> getCatalogo() {
        return Collections.unmodifiableList(catalogo);
    }
}
