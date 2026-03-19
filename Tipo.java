package ProyectoIntegradorPokemon;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Tipo {
	public enum Tipos {
		Fuego, Agua, Planta, Electrico, Tierra, Volador, Acero, Hada, Dragon;
	}

	Map<Tipos, List<Tipos>> efectividades;
	Map<Tipos, List<Tipos>> resistencias;
	Map<Tipos, List<Tipos>> inmunidades;

	public Tipo() {
		resistencias = new LinkedHashMap<>();
		inmunidades = new LinkedHashMap<>();
		efectividades = new LinkedHashMap<>();
		mapitas();
	}

	public static String getColorTipo(Tipos tipo) {
	    if (tipo == null) {
	    	return "\u001B[0m";
	    }
	    
	    switch (tipo) {
	        case Fuego:      
	        	return "\u001B[31m"; // rojo
	        case Agua:       
	        	return "\u001B[34m"; // azul
	        case Planta:
	        	return "\u001B[32m"; // verde
	        case Electrico:
	        	return "\u001B[33m"; // amarillo
	        case Tierra:
	        	return "\u001B[33m"; // amarillo oscuro
	        case Volador:
	        	return "\u001B[96m"; // cyan
	        case Acero:
	        	return "\u001B[90m"; // gris orcuro
	        case Hada: 
	        	return "\u001B[38;5;213m"; // rosa
	        case Dragon:
	        	return "\u001B[94m"; // azul claro
	        default:    
	        	return "\u001B[0m";
	    }
	}
	
	public void mapitas() {
		// tipo tal es efectivo contra el tipo tal
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

		// tipo tal resiste al tipo tal
		resistencias.put(Tipos.Fuego, new ArrayList<>());
		resistencias.get(Tipos.Fuego).add(Tipos.Fuego);
		resistencias.get(Tipos.Fuego).add(Tipos.Acero);
		resistencias.get(Tipos.Fuego).add(Tipos.Planta);
		resistencias.get(Tipos.Fuego).add(Tipos.Hada);
		
		
		resistencias.put(Tipos.Agua, new ArrayList<>());
		resistencias.get(Tipos.Agua).add(Tipos.Agua);
		resistencias.get(Tipos.Agua).add(Tipos.Fuego);
		resistencias.get(Tipos.Agua).add(Tipos.Acero);
		
		
		resistencias.put(Tipos.Planta, new ArrayList<>());
		resistencias.get(Tipos.Planta).add(Tipos.Agua);
		resistencias.get(Tipos.Planta).add(Tipos.Planta);
		resistencias.get(Tipos.Planta).add(Tipos.Electrico);
		resistencias.get(Tipos.Planta).add(Tipos.Tierra);
		

		resistencias.put(Tipos.Electrico, new ArrayList<>());
		resistencias.get(Tipos.Electrico).add(Tipos.Electrico);
		resistencias.get(Tipos.Electrico).add(Tipos.Volador);
		resistencias.get(Tipos.Electrico).add(Tipos.Acero);
		

		resistencias.put(Tipos.Volador, new ArrayList<>());
		resistencias.get(Tipos.Volador).add(Tipos.Planta);
		

		resistencias.put(Tipos.Acero, new ArrayList<>());
		resistencias.get(Tipos.Acero).add(Tipos.Planta);
		resistencias.get(Tipos.Acero).add(Tipos.Volador);
		resistencias.get(Tipos.Acero).add(Tipos.Acero);
		resistencias.get(Tipos.Acero).add(Tipos.Hada);
		resistencias.get(Tipos.Acero).add(Tipos.Dragon);

		

		resistencias.put(Tipos.Dragon, new ArrayList<>());
		resistencias.get(Tipos.Dragon).add(Tipos.Fuego);
		resistencias.get(Tipos.Dragon).add(Tipos.Agua);
		resistencias.get(Tipos.Dragon).add(Tipos.Planta);
		resistencias.get(Tipos.Dragon).add(Tipos.Electrico);

		// tipo tal imnune a tipo tal
		inmunidades.put(Tipos.Tierra, new ArrayList<>());
		inmunidades.get(Tipos.Tierra).add(Tipos.Electrico);

		inmunidades.put(Tipos.Volador, new ArrayList<>());
		inmunidades.get(Tipos.Volador).add(Tipos.Tierra);

		inmunidades.put(Tipos.Hada, new ArrayList<>());
		inmunidades.get(Tipos.Hada).add(Tipos.Dragon);

	}

	public double getMultiplicadorAtaque(Tipos tipoAtaque, Tipos tipoDefensor) {

		if (inmunidades.containsKey(tipoDefensor) && inmunidades.get(tipoDefensor).contains(tipoAtaque)) {
			return 0.0;
		}
		if (efectividades.containsKey(tipoAtaque) && efectividades.get(tipoAtaque).contains(tipoDefensor)) {
			return 2.0;
		}
		if (resistencias.containsKey(tipoDefensor) && resistencias.get(tipoDefensor).contains(tipoAtaque)) {
			return 0.5;
		}
		return 1.0;
	}

	public double getStab(Tipos tipoAtaque, Pokemon pAtacante) {
		if (tipoAtaque == pAtacante.getTipo1() || tipoAtaque == pAtacante.getTipo2()) {
			return 1.5;
		}
			
		return 1.0;
	}

	public double getMultiplicadorTotal(Tipos tipoAtaque, Pokemon pAtacante, Tipos tipo1Defensor, Tipos tipo2Defensor) {

		double efectividadAtaque = getMultiplicadorAtaque(tipoAtaque, tipo1Defensor);
		if (tipo2Defensor != null) {
			efectividadAtaque = efectividadAtaque* getMultiplicadorAtaque(tipoAtaque, tipo2Defensor);
		}
			
		double stab = getStab(tipoAtaque, pAtacante);

		double efectividad = efectividadAtaque * stab;
		return efectividad;
	}
}
