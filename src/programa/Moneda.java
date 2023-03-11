package programa;

public class Moneda {
    private String nombre;
    private String simbolo;
    private String codigo;
    private double tasaCambio;

    public Moneda(String nombre, String simbolo, String codigo, double tasaCambio) throws IllegalArgumentException {
        if (tasaCambio < 0) {
            throw new IllegalArgumentException("La tasa de cambio no puede ser negativa");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la moneda no puede ser nulo o vacío");
        }
        if (simbolo == null || simbolo.isEmpty()) {
            throw new IllegalArgumentException("El símbolo de la moneda no puede ser nulo o vacío");
        }
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El código de la moneda no puede ser nulo o vacío");
        }
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.codigo = codigo;
        this.tasaCambio = tasaCambio;
    }

    public Moneda(String nombre, String simbolo, String codigo) throws IllegalArgumentException {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la moneda no puede ser nulo o vacío");
        }
        if (simbolo == null || simbolo.isEmpty()) {
            throw new IllegalArgumentException("El símbolo de la moneda no puede ser nulo o vacío");
        }
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El código de la moneda no puede ser nulo o vacío");
        }
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.codigo = codigo;
        this.tasaCambio = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getTasaCambio() {
        return tasaCambio;
    }

    public void setTasaCambio(double tasaCambio) throws IllegalArgumentException {
        if (tasaCambio < 0) {
            throw new IllegalArgumentException("La tasa de cambio no puede ser negativa");
        }
        this.tasaCambio = tasaCambio;
    }

    @Override
    public String toString() {
        return nombre + " " + simbolo;
    }
}
