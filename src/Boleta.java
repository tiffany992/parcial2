

public class Boleta {

    private final String codigo;
    private final int fila;
    private final int numeroAsiento;
    private final double valorIndividual;
    private final Asiento asiento;

    /**
     * metodo  Boleta
     * @param codigo
     * @param asiento
     * @param valorIndividual
     */
    public Boleta(String codigo, Asiento asiento, double valorIndividual) {
        this.codigo = codigo;
        this.asiento = asiento;
        this.fila = asiento.getFila();
        this.numeroAsiento = asiento.getNumero();
        this.valorIndividual = valorIndividual;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getFila() {
        return fila;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public double getValorIndividual() {
        return valorIndividual;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    @Override
    public String toString() {
        return String.format("Boleta %s - fila %d, asiento %d - $%,.2f",
                codigo, fila, numeroAsiento, valorIndividual);
    }
}
