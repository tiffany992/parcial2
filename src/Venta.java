
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Venta {

    private final String codigo;
    private final LocalDate fechaRealizacion;

    private final Cliente cliente;
    private final Operario operario;
    private final Funcion funcion;
    private final List<Boleta> boletas = new ArrayList<>();

    /**
     * metodo de Venta
     * @param codigo
     * @param fechaRealizacion
     * @param cliente
     * @param operario
     * @param funcion
     */
    public Venta(String codigo, LocalDate fechaRealizacion,
                 Cliente cliente, Operario operario, Funcion funcion) {
        this.codigo = codigo;
        this.fechaRealizacion = fechaRealizacion;
        this.cliente = cliente;
        this.operario = operario;
        this.funcion = funcion;
    }

    /**
     * metodo de agregarBoleta
     * @param fila
     * @param numero
     * @return
     */
    public Boleta agregarBoleta(int fila, int numero) {
        Asiento asiento = funcion.getSala().buscarAsiento(fila, numero);
        if (asiento == null) {
            throw new IllegalArgumentException("El asiento fila " + fila + ", numero "
                    + numero + " no existe en la sala " + funcion.getSala().getNombre() + ".");
        }
        if (funcion.asientoOcupado(fila, numero)) {
            throw new IllegalStateException("El asiento fila " + fila + ", numero "
                    + numero + " ya esta vendido para esta funcion.");
        }

        double valor = funcion.calcularPrecioBoleta(cliente.getPorcentajeDescuento());
        String codigoBoleta = codigo + "-B" + (boletas.size() + 1);
        Boleta boleta = new Boleta(codigoBoleta, asiento, valor);

        boletas.add(boleta);
        funcion.registrarBoleta(boleta);
        return boleta;
    }

    /**
     * metodo de  Total de la venta = suma de los valores de todas sus boletas
     * @return
     */

    public double calcularTotal() {
        double total = 0;
        for (Boleta b : boletas) {
            total += b.getValorIndividual();
        }
        return total;
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Operario getOperario() {
        return operario;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public List<Boleta> getBoletas() {
        return Collections.unmodifiableList(boletas);
    }
}
