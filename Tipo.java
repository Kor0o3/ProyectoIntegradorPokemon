package Programa;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Tipo {
	public enum Tipos {
		Fuego, Agua, Planta, Electrico, Tierra, Volador, Acero, Hada, Dragon;
	}
	
	Map<Tipos, List<Tipos>> efectividades;
	Map<Tipos, List<Tipos>> debilidades;
	Map<Tipos, List<Tipos>> inmunidades;

	
	public Tipo() {
		debilidades = new LinkedHashMap<>();
		inmunidades = new LinkedHashMap<>();

		mapitas();
	}
	
	public void mapitas() {
		efectividades = new LinkedHashMap<>();
		efectividades.put(Tipos.Fuego, new ArrayList<>());
		efectividades.get(Tipos.Fuego).add(Tipos.Planta);
		efectividades.get(Tipos.Fuego).add(Tipos.Acero);
		
		efectividades.put(Tipos.Agua, new ArrayList<>());
		efectividades.get(Tipos.Agua).add(Tipos.Tierra);
		efectividades.get(Tipos.Agua).add(Tipos.Fuego);
		
		efectividades.put(Tipos.Planta, new ArrayList<>());
		efectividades.get(Tipos.Planta).add(Tipos.Agua);
		efectividades.get(Tipos.Planta).add(Tipos.Tierra);
		
		efectividades.put(Tipos.Electrico, new ArrayList<>());
		efectividades.get(Tipos.Electrico).add(Tipos.Agua);
		efectividades.get(Tipos.Electrico).add(Tipos.Volador);
		
		efectividades.put(Tipos.Tierra, new ArrayList<>());
		efectividades.get(Tipos.Tierra).add(Tipos.Fuego);
		efectividades.get(Tipos.Tierra).add(Tipos.Electrico);
		
		efectividades.put(Tipos.Volador, new ArrayList<>());
		efectividades.get(Tipos.Volador).add(Tipos.Planta);
		
		efectividades.put(Tipos.Acero, new ArrayList<>());
		efectividades.get(Tipos.Acero).add(Tipos.Planta);
		
		efectividades.put(Tipos.Hada, new ArrayList<>());
		efectividades.get(Tipos.Hada).add(Tipos.Dragon);
		
		efectividades.put(Tipos.Dragon, new ArrayList<>());
		efectividades.get(Tipos.Dragon).add(Tipos.Dragon);		
		
		
		
		debilidades.put(Tipos.Fuego, new ArrayList<>());
		debilidades.get(Tipos.Fuego).add(Tipos.Fuego);
		debilidades.get(Tipos.Fuego).add(Tipos.Agua);
		debilidades.get(Tipos.Fuego).add(Tipos.Dragon);
		
		debilidades.put(Tipos.Agua, new ArrayList<>());
		debilidades.get(Tipos.Agua).add(Tipos.Agua);
		debilidades.get(Tipos.Agua).add(Tipos.Planta);
		debilidades.get(Tipos.Agua).add(Tipos.Dragon);
		
		debilidades.put(Tipos.Planta, new ArrayList<>());
		debilidades.get(Tipos.Planta).add(Tipos.Fuego);
		debilidades.get(Tipos.Planta).add(Tipos.Planta);
		debilidades.get(Tipos.Planta).add(Tipos.Volador);
		debilidades.get(Tipos.Planta).add(Tipos.Acero);
		debilidades.get(Tipos.Planta).add(Tipos.Dragon);

		debilidades.put(Tipos.Electrico, new ArrayList<>());
		debilidades.get(Tipos.Electrico).add(Tipos.Planta);
		debilidades.get(Tipos.Electrico).add(Tipos.Electrico);
		debilidades.get(Tipos.Electrico).add(Tipos.Dragon);		
		
		debilidades.put(Tipos.Tierra, new ArrayList<>());
		debilidades.get(Tipos.Tierra).add(Tipos.Planta);
		
		debilidades.put(Tipos.Volador, new ArrayList<>());
		debilidades.get(Tipos.Volador).add(Tipos.Electrico);
		debilidades.get(Tipos.Volador).add(Tipos.Acero);

		debilidades.put(Tipos.Acero, new ArrayList<>());
		debilidades.get(Tipos.Acero).add(Tipos.Fuego);
		debilidades.get(Tipos.Acero).add(Tipos.Agua);
		debilidades.get(Tipos.Acero).add(Tipos.Electrico);
		debilidades.get(Tipos.Acero).add(Tipos.Acero);

		
		debilidades.put(Tipos.Hada, new ArrayList<>());
		debilidades.get(Tipos.Hada).add(Tipos.Fuego);
		debilidades.get(Tipos.Hada).add(Tipos.Acero);

		debilidades.put(Tipos.Dragon, new ArrayList<>());
		debilidades.get(Tipos.Dragon).add(Tipos.Hada);
		
		
		
		
		inmunidades.put(Tipos.Electrico, new ArrayList<>());
		inmunidades.get(Tipos.Electrico).add(Tipos.Tierra);		
		
		inmunidades.put(Tipos.Tierra, new ArrayList<>());
		inmunidades.get(Tipos.Tierra).add(Tipos.Volador);
	

		inmunidades.put(Tipos.Dragon, new ArrayList<>());
		inmunidades.get(Tipos.Dragon).add(Tipos.Hada);
		
	}
	
}
