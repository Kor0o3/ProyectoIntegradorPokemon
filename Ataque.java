package ProyectoIntegradorPokemon;

public abstract class Ataque {
	// Si tocais algo de esta clase comentarlo al igual que con las otras por si luego falla
	// Atributos
	protected int potencia;
	protected int precision;
	protected int pp;
	protected int ppActual;
	protected String nombre;
	protected String categoria;
	protected boolean prioridad;
	protected Tipo.Tipos tipoAtaque;
	
	protected static double probCrit = 0.05;
	private String blanco = "\u001B[0m";
	
	// Constructor
	public Ataque(String nombre, String categoria, int potencia, int precision, int pp, boolean prioridad,
			Tipo.Tipos tipoAtaque) {
		if (categoria.equalsIgnoreCase("fisico") || categoria.equalsIgnoreCase("especial")
				|| categoria.equalsIgnoreCase("estado")) {
			this.categoria = categoria;
			this.tipoAtaque = tipoAtaque;
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

	public String getCategoria() {
		return this.categoria;
	}

	public Tipo.Tipos getTipoAtaque() {
		return tipoAtaque;
	}

	protected boolean getPrioridad() {
		return this.prioridad;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public void setPpActual(int pp) {
		if (this.getPpActual() > 0) {
			this.ppActual = pp;
		}
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
		String prioridad = null;
		if (getPrioridad() != false) {
			prioridad = "si";
		} else {
			prioridad = "no";
		}
		return getNombre() + " - Tipo: " + Tipo.getColorTipo(getTipoAtaque())+getTipoAtaque() + blanco + " Prioridad: " + prioridad + " - PP: " + getPpActual() + "/" + getPp();
	}
}
