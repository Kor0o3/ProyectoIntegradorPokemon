package Programa;

public abstract class Ataque {
	// Si tocais algo de esta clase comentarlo al igual que con las otras por si luego falla
	// Atributos
	protected int potencia;
	protected int precision;
	protected int pp;
	protected int ppActual;
	protected String nombre;
	protected static double probCrit = 0.05;

	// Constructor
	public Ataque(String nombre, int potencia, int precision, int pp) {
		if (potencia < 0) {
			this.potencia = 1;
		} else if (potencia > 150) {
			this.potencia = 150;
		} else {
			this.potencia = potencia;
		}

		if (precision < 30) {
			this.precision = 30;
		} else if (precision > 100) {
			this.precision = 100;
		} else {
			this.precision = precision;
		}

		if (pp < 0) {
			this.pp = 5;
		} else {
			this.pp = pp;
		}
		this.nombre = nombre;
		this.ppActual = pp;
	}

	// Getter
	public int getPotencia() {
		return this.potencia;
	}

	public int getPp() {
		return this.pp;
	}

	public int getPpActual() {
		return this.ppActual;
	}

	public int getPrecision() {
		return this.precision;
	}

	public String getNombre() {
		return this.nombre;
	}

	// Metodos
	public boolean tienePps() {
		return this.ppActual > 0;
	}

	public boolean acierta() {
		int rng = (int) (Math.random() * 100);
		return rng < this.precision;
	}

	protected boolean esCritico() {
		int rng = (int) (Math.random() * 100);
		int porcentajeCritico = (int) (probCrit * 100);
		return rng < porcentajeCritico;
	}

	public abstract void utilizar(Pokemon pAtacante, Pokemon pEnemigo);

	@Override
	public String toString() {
		return getNombre() + " | Potencia: " + getPotencia() + " - Precision: " + getPrecision() + " - PP: "
				+ getPpActual() + "/" + getPp();
	}
}
