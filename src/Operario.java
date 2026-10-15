
import java.time.LocalDate;

public class Operario extends Persona {

    private String codigoEmpleado;
    private LocalDate fechaContratacion;
    private double salarioBasico;

    /**
     * metodo contructor de operario
     * @param documentoIdentidad
     * @param nombreCompleto
     * @param correoElectronico
     * @param telefono
     * @param codigoEmpleado
     * @param fechaContratacion
     * @param salarioBasico
     */
    public Operario(String documentoIdentidad, String nombreCompleto,
                    String correoElectronico, String telefono,
                    String codigoEmpleado, LocalDate fechaContratacion,
                    double salarioBasico) {
        super(documentoIdentidad, nombreCompleto, correoElectronico, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salarioBasico = salarioBasico;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public double getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(double salarioBasico) {
        this.salarioBasico = salarioBasico;
    }
}