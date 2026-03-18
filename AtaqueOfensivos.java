package ProyectoIntegradorPokemon;

public abstract class AtaqueOfensivos extends Ataque {
	// Si tocais algo de esta clase comentarlo al igual que con las otras por si
	// luego falla
	public AtaqueOfensivos(String nombre, String categoria, int potencia, int precision, int pp, boolean prioridad,Tipo.Tipos tipoAtaque) {
		super(nombre, categoria, potencia, precision, pp, prioridad, tipoAtaque);
		// TODO Auto-generated constructor stub
	}

	protected int calcularDanio(int ataque, int defensa) {
		double danio = ataque * (potencia / 100.0);

		if (esCritico()) {
			danio = danio * 1.5;
		}

		danio -= defensa;

		if (danio < 1) {
			return 1;
		} else {
			return (int) danio;
		}
	}
}
