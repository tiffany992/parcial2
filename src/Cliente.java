

public class Cliente extends Persona {

    private String codigoAfiliacion;
    private double porcentajeDescuento; // entre 0 y 100

    /**
     * metodo constructor cliente
     * @param documentoIdentidad
     * @param nombreCompleto
     * @param correoElectronico
     * @param telefono
     * @param codigoAfiliacion
     * @param porcentajeDescuento
     */
    public Cliente(String documentoIdentidad, String nombreCompleto,
                   String correoElectronico, String telefono,
                   String codigoAfiliacion, double porcentajeDescuento) {
        super(documentoIdentidad, nombreCompleto, correoElectronico, telefono);

        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 100.");
        }
        this.codigoAfiliacion = codigoAfiliacion;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 100.");
        }
        this.porcentajeDescuento = porcentajeDescuento;
    }
}