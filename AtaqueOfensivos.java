package Programa;

public abstract class AtaqueOfensivos extends Ataque {
	// Si tocais algo de esta clase comentarlo al igual que con las otras por si
	// luego falla
	public AtaqueOfensivos(String nombre, String tipo, int potencia, int precision, int pp, boolean prioridad) {
		super(nombre, tipo, potencia, precision, pp, prioridad);
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
