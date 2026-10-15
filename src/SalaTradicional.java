

public class SalaTradicional extends Sala {
    /**
     * metodo de SalaTradicional
     * @param codigo
     * @param nombre
     * @param capacidadMaxima
     * @param filas
     * @param columnas
     */
    public SalaTradicional(String codigo, String nombre, int capacidadMaxima,
                           int filas, int columnas) {
        super(codigo, nombre, capacidadMaxima, filas, columnas);
    }

    @Override
    public double calcularRecargo() {
        return 0.0;
    }
}
