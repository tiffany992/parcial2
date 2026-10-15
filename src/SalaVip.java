

public class SalaVip extends Sala {
    /**
     * metodo de SalaVip
     * @param codigo
     * @param nombre
     * @param capacidadMaxima
     * @param filas
     * @param columnas
     */
    public SalaVip(String codigo, String nombre, int capacidadMaxima,
                   int filas, int columnas) {
        super(codigo, nombre, capacidadMaxima, filas, columnas);
    }

    @Override
    public double calcularRecargo() {
        return 0.30;
    }
}
