

public class Sala3D extends Sala {
    /**
     * metodo Sala3D
     * @param nombre
     * @param capacidadMaxima
     * @param filas
     * @param columnas
     */
    public Sala3D(String codigo, String nombre, int capacidadMaxima,
                  int filas, int columnas) {
        super(codigo, nombre, capacidadMaxima, filas, columnas);
    }

    @Override
    public double calcularRecargo() {
        return 0.20;
    }
}
