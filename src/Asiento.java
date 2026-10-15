

public class Asiento {

    private final int fila;
    private final int numero;

    /**
     * metodo de asiento
     * @param fila
     * @param numero
     */
    public Asiento(int fila, int numero) {
        this.fila = fila;
        this.numero = numero;
    }

    public int getFila() {
        return fila;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Fila " + fila + ", asiento " + numero;
    }
}
