package ProyectoIntegradorPokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Efectividades {
	Tipo tipo;
	Map<Tipo, ArrayList<Tipo>> efectividades;
	public Efectividades() {
		efectividades = new LinkedHashMap<>();
		efectividades.put(Tipo.Fuego, new ArrayList<>());
		efectividades.get(Tipo.Fuego).add(Tipo.Planta);
		efectividades.get(Tipo.Fuego).add(Tipo.Acero);
		
		efectividades.put(Tipo.Agua, new ArrayList<>());
		efectividades.get(Tipo.Agua).add(Tipo.Tierra);
		efectividades.get(Tipo.Agua).add(Tipo.Fuego);
		
		efectividades.put(Tipo.Planta, new ArrayList<>());
		efectividades.get(Tipo.Planta).add(Tipo.Agua);
		efectividades.get(Tipo.Planta).add(Tipo.Tierra);
		
		efectividades.put(Tipo.Electrico, new ArrayList<>());
		efectividades.get(Tipo.Electrico).add(Tipo.Agua);
		efectividades.get(Tipo.Electrico).add(Tipo.Volador);
		
		efectividades.put(Tipo.Tierra, new ArrayList<>());
		efectividades.get(Tipo.Tierra).add(Tipo.Fuego);
		efectividades.get(Tipo.Tierra).add(Tipo.Electrico);
		
		efectividades.put(Tipo.Volador, new ArrayList<>());
		efectividades.get(Tipo.Volador).add(Tipo.Planta);
		
		efectividades.put(Tipo.Acero, new ArrayList<>());
		efectividades.get(Tipo.Acero).add(Tipo.Planta);
		
		efectividades.put(Tipo.Hada, new ArrayList<>());
		efectividades.get(Tipo.Hada).add(tipo.Dragon);
		
		efectividades.put(Tipo.Dragon, new ArrayList<>());
		efectividades.get(Tipo.Dragon).add(Tipo.Dragon);
		
	}
	
	

}
