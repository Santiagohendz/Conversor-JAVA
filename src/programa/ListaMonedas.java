package programa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListaMonedas {
    
    public static final Moneda PESOCOLOMBIANO = new Moneda("Pesos Colombianos", "$", "COP", 1);
    public static final Moneda EURO = new Moneda("Euros","€", "EUR" ,0.00020 );
    public static final Moneda LIBRAESTERLINA = new Moneda("Libras Esterlinas", "£","GBP", 0.00018);
    public static final Moneda YENJAPONES = new Moneda("Yenes Japoneses", "¥","JPY", 0.029 );
    public static final Moneda DOLAR = new Moneda("Dolares Estadounidenses", "$", "USD", 0.00021);
    public static final Moneda WON = new Moneda("Wones Surcoreanos", "₩" , "KRW", 0.28);
    
    public static List<Moneda> LISTAMONEDAS = Arrays.asList(PESOCOLOMBIANO,EURO,LIBRAESTERLINA,YENJAPONES,DOLAR,WON);
    
    public static List<Moneda> getListaMonedas(){
        return Collections.unmodifiableList(LISTAMONEDAS);
    }
    
    public static List<Moneda> removeMoneda(int index) {
        if (index < 0 || index >= LISTAMONEDAS.size()) {
            throw new IndexOutOfBoundsException("El índice está fuera del rango de la lista.");
        }
        List<Moneda> removeMoneda = new ArrayList<>(LISTAMONEDAS);
        removeMoneda.remove(index);
        LISTAMONEDAS = removeMoneda;
        return Collections.unmodifiableList(LISTAMONEDAS);
    }
    
    public static List<Moneda> addMoneda(String nombre, String simbolo, String codigo, double tasaCambio){
        List<Moneda> addMoneda = new ArrayList<>(LISTAMONEDAS);
        addMoneda.add(new Moneda(nombre, simbolo, codigo, tasaCambio));
        LISTAMONEDAS = addMoneda;
        return Collections.unmodifiableList(LISTAMONEDAS);
    }
    
    public static List<Moneda> modificarMoneda(String nombre, String simbolo, String Codigo, int index) {
        if (index < 0 || index >= LISTAMONEDAS.size()) {
            throw new IndexOutOfBoundsException("El índice está fuera del rango de la lista.");
        }
        List<Moneda> modificarMoneda = new ArrayList<>(LISTAMONEDAS);
        modificarMoneda.set(index,new Moneda(nombre, simbolo, Codigo));
        LISTAMONEDAS = modificarMoneda;
        return Collections.unmodifiableList(LISTAMONEDAS);
    }
}
