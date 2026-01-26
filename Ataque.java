package Programa;

public abstract class Ataque {
	private int potencia;
	private int precision;
	private String nombre;
	private int pp;

	public Ataque(int po, int pr, String n, int pp) {
		this.potencia = po;
		this.precision = pr;
		this.nombre= n;
		this.pp = pp;
	}
	
	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public abstract void utilizar(Pokemon p1, Pokemon enemigo, int opcion);
	
	
}
