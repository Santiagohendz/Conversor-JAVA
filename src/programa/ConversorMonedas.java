package programa;

import java.util.HashMap;
import java.util.Map;

public class ConversorMonedas {
    private Map<String, Double> tasasCambio;
    
    public ConversorMonedas() {
        this.tasasCambio = new HashMap<>();

        for (Moneda moneda : ListaMonedas.getListaMonedas()) {
            double tasaCambio = moneda.getTasaCambio();
            this.tasasCambio.put(moneda.getCodigo(), tasaCambio);
        }

        this.tasasCambio.put("COP", 1.0);
    }

    public void setTasaCambio(String codigo, double tasa) {
        if (this.tasasCambio.containsKey(codigo)) {
            if (codigo.equals("COP")) {
                throw new IllegalArgumentException("La tasa de cambio del peso colombiano no puede ser modificada");
            } else {
                if (tasa < 0) {
                    throw new IllegalArgumentException("La tasa de cambio no puede ser negativa");
                }
                double tasaCambio = this.tasasCambio.get("COP");
                this.tasasCambio.put(codigo, tasa / tasaCambio);
            }
        } else {
            throw new IllegalArgumentException("La moneda " + codigo + " no está registrada en el conversor");
        }
    }

    public double convertir(double cantidad, String codigoOrigen, String codigoDestino) {
        if (!this.tasasCambio.containsKey(codigoOrigen)) {
            throw new IllegalArgumentException("La moneda " + codigoOrigen + " no está registrada en el conversor");
        }
        if (!this.tasasCambio.containsKey(codigoDestino)) {
            throw new IllegalArgumentException("La moneda " + codigoDestino + " no está registrada en el conversor");
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad a convertir no puede ser negativa");
        }
        double tasaOrigen = this.tasasCambio.get(codigoOrigen);
        double tasaDestino = this.tasasCambio.get(codigoDestino);
        return cantidad / tasaOrigen * tasaDestino;
    }
}
