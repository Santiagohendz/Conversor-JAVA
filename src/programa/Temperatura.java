package programa;

public class Temperatura {
    private String nombre;
    private String simbolo;

    public Temperatura(String nombre, String simbolo) throws IllegalArgumentException {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la temperatura no puede ser nulo o vacío");
        }
        if (simbolo == null || simbolo.isEmpty()) {
            throw new IllegalArgumentException("El símbolo de la temperatura no puede ser nulo o vacío");
        }
        this.simbolo = simbolo;
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " " + simbolo;
    }
}