package programa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListaTemperaturas {
	 public static final Temperatura CELSIUS = new Temperatura("Celsius", "°C");
	    public static final Temperatura FAHRENHEIT = new Temperatura("Fahrenheit", "°F");
	    public static final Temperatura KELVIN = new Temperatura("Kelvin", "K");
	
	public static List<Temperatura> LISTATEMPERATURAS = Arrays.asList(CELSIUS,FAHRENHEIT,KELVIN);
	
	public static List<Temperatura> getListaTemperaturas(){
		return Collections.unmodifiableList(LISTATEMPERATURAS);
	}
	
	public static List<Temperatura> removeTemperatura(int index) {
	    if (index < 0 || index >= LISTATEMPERATURAS.size()) {
	        throw new IndexOutOfBoundsException("El índice está fuera del rango de la lista.");
	    }
	    List<Temperatura> removeTemperatura = new ArrayList<>(LISTATEMPERATURAS);
	    removeTemperatura.remove(index);
	    LISTATEMPERATURAS = removeTemperatura;
	    return Collections.unmodifiableList(LISTATEMPERATURAS);
	}

	
	public static List<Temperatura> addTemperatura(int index, String nombre, String simbolo){
		List<Temperatura> addTemperatura = new ArrayList<>(LISTATEMPERATURAS);
		addTemperatura.add(index,new Temperatura(nombre, simbolo));
		LISTATEMPERATURAS = addTemperatura;
		return Collections.unmodifiableList(LISTATEMPERATURAS);
	}
	
	public static List<Temperatura> modificarTemperatura(int index, String nombre, String simbolo) {
	    if (index < 0 || index >= LISTATEMPERATURAS.size()) {
	        throw new IndexOutOfBoundsException("El índice está fuera del rango de la lista.");
	    }
	    List<Temperatura> modificarTemperatura = new ArrayList<>(LISTATEMPERATURAS);
	    modificarTemperatura.remove(index);
	    modificarTemperatura.add(index, new Temperatura(nombre, simbolo));
	    LISTATEMPERATURAS = modificarTemperatura;
	    return Collections.unmodifiableList(LISTATEMPERATURAS);
	}
}