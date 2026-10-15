

    public class Persona {

        private String documentoIdentidad;
        private String nombreCompleto;
        private String correoElectronico;
        private String telefono;

        /**
         * metodo constructor persona
         * @param documentoIdentidad
         * @param nombreCompleto
         * @param correoElectronico
         * @param telefono
         */
        public Persona(String documentoIdentidad, String nombreCompleto,
                       String correoElectronico, String telefono) {
            this.documentoIdentidad = documentoIdentidad;
            this.nombreCompleto = nombreCompleto;
            this.correoElectronico = correoElectronico;
            this.telefono = telefono;
        }

        public String getDocumentoIdentidad() {
            return documentoIdentidad;
        }

        public String getNombreCompleto() {
            return nombreCompleto;
        }

        public String getCorreoElectronico() {
            return correoElectronico;
        }

        public void setCorreoElectronico(String correoElectronico) {
            this.correoElectronico = correoElectronico;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        @Override
        public String toString() {
            return nombreCompleto + " (doc. " + documentoIdentidad + ")";
        }
    }
