package Programa;

public abstract class Ataque {
	// Si tocais algo de esta clase comentarlo al igual que con las otras por si
	// luego falla
	// Atributos
	protected int potencia;
	protected int precision;
	protected int pp;
	protected int ppActual;
	protected String nombre;
	protected String tipo;
	protected boolean prioridad;
	protected int rng = (int) (Math.random() * 100);
	protected static double probCrit = 0.05;
	
	// Constructor
	public Ataque(String nombre, String tipo, int potencia, int precision, int pp, boolean prioridad) {
		if (tipo.equalsIgnoreCase("normal") || tipo.equalsIgnoreCase("especial") || tipo.equalsIgnoreCase("estado")) {
			this.tipo = tipo;
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

			this.prioridad = prioridad;
			this.nombre = nombre;
			this.ppActual = pp;
		} else {
			System.out.println("Introduce un estado valido");
		}
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

	public String getTipo() {
		return this.tipo;
	}

	protected boolean getPrioridad() {
		return this.prioridad;
	}

	// Metodos
	public boolean tienePps() {
		return this.ppActual > 0;
	}

	public boolean acierta() {
		return rng < this.precision;
	}

	protected boolean esCritico() {
		int porcentajeCritico = (int) (probCrit * 100);
		return rng < porcentajeCritico;
	}

	public abstract void utilizar(Pokemon pAtacante, Pokemon pEnemigo);

	@Override
	public String toString() {
		return getNombre() + " | Tipo: " + getTipo() + " - Potencia: " + getPotencia() + " - Precision: "
				+ getPrecision() + " - PP: " + getPpActual() + "/" + getPp() + " Prioridad: " + getPrioridad();
	}
}
