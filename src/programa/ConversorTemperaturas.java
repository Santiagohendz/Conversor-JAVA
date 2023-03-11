package programa;

public class ConversorTemperaturas {
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException("Temperatura en Kelvin no puede ser menor que 0");
        }
        return kelvin - 273.15;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return celsiusToKelvin(fahrenheitToCelsius(fahrenheit));
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return celsiusToFahrenheit(kelvinToCelsius(kelvin));
    }
    
    public double convertir(double temperatura, String unidadOrigen, String unidadDestino) {
        double resultado = temperatura;

        switch (unidadOrigen.toLowerCase()) {
            case "c":
            case "celsius":
                switch (unidadDestino.toLowerCase()) {
                    case "f":
                    case "fahrenheit":
                        resultado = celsiusToFahrenheit(temperatura);
                        break;
                    case "k":
                    case "kelvin":
                        resultado = celsiusToKelvin(temperatura);
                        break;
                    default:
                        throw new IllegalArgumentException("Unidad de destino no válida");
                }
                break;
            case "f":
            case "fahrenheit":
                switch (unidadDestino.toLowerCase()) {
                    case "c":
                    case "celsius":
                        resultado = fahrenheitToCelsius(temperatura);
                        break;
                    case "k":
                    case "kelvin":
                        resultado = fahrenheitToKelvin(temperatura);
                        break;
                    default:
                        throw new IllegalArgumentException("Unidad de destino no válida");
                }
                break;
            case "k":
            case "kelvin":
                switch (unidadDestino.toLowerCase()) {
                    case "c":
                    case "celsius":
                        resultado = kelvinToCelsius(temperatura);
                        break;
                    case "f":
                    case "fahrenheit":
                        resultado = kelvinToFahrenheit(temperatura);
                        break;
                    default:
                        throw new IllegalArgumentException("Unidad de destino no válida");
                }
                break;
            default:
                throw new IllegalArgumentException("Unidad de origen no válida");
        }

        return resultado;
    }
}
