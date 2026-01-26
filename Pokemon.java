package Programa;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
	// Atributos
	protected String nombrePokemon;
	protected String mote;
	protected int ataqueFisico;
	protected int defensaFisico;
	protected int ataqueEspecial;
	protected int defensaEspecial;
	protected int velocidad;
	protected int puntosVidaActuales;
	protected int puntosVidaMaximo;
	protected int poderMaximo = 600;
	public List<String> movimientos;

	// Constructores
	public Pokemon(String nombrePokemon) {
		this(nombrePokemon, null, 0, 0, 0, 0, 0, 0);
	}

	public Pokemon(String nombrePokemon, String mote) {
		this(nombrePokemon, mote, 0, 0, 0, 0, 0, 0);
	}

	public Pokemon(String nombrePokemon, int velocidad, int ataqueFisico, int defensaFisico, int ataqueEspecial,
			int defensaEspecial, int puntosVidaMaximo) {
		this(nombrePokemon, null, velocidad, ataqueFisico, defensaFisico, ataqueEspecial, defensaEspecial,
				puntosVidaMaximo);
	}

	public Pokemon(String nombrePokemon, String mote, int velocidad, int ataqueFisico, int defensaFisico,
			int ataqueEspecial, int defensaEspecial, int puntosVidaMaximo) {

		this.nombrePokemon = nombrePokemon;
		this.mote = mote;
		this.velocidad = velocidad;
		this.ataqueFisico = ataqueFisico;
		this.defensaFisico = defensaFisico;
		this.ataqueEspecial = ataqueEspecial;
		this.defensaEspecial = defensaEspecial;
		this.puntosVidaMaximo = puntosVidaMaximo;
		this.puntosVidaActuales = puntosVidaMaximo;
		this.movimientos = new ArrayList<>();

		int totalPoder = velocidad + ataqueFisico + defensaFisico + ataqueEspecial + defensaEspecial + puntosVidaMaximo;

		if (ataqueFisico <= 0 || defensaFisico <= 0 || ataqueEspecial <= 0 || defensaEspecial <= 0 || velocidad <= 0
				|| puntosVidaMaximo <= 0) {
			System.out.println(
					validarNombre() + " no puede participar en batallas hasta que sus atributos no sean cambiados");
		}

		if (totalPoder > this.poderMaximo) {
			this.ataqueFisico = 0;
			this.defensaFisico = 0;
			this.puntosVidaMaximo = 0;
			this.puntosVidaActuales = 0;
		}

	}

	// Getter y Setter
	public void setNombrePokemon(String nombrePokemon) {
		this.nombrePokemon = nombrePokemon;
	}

	public void setMote(String mote) {
		if (mote == "") {
			this.mote = null;
		} else {
			this.mote = mote;
		}
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		if (velocidad <= 0) {
			System.out.println("El cambio de esadísticas no es valido y no se ha realizado");
		} else {
			this.velocidad = velocidad;
		}
	}

	public int getAtaqueFisico() {
		return ataqueFisico;
	}

	public void setAtaqueFisico(int ataque) {
		if (ataque <= 0) {
			System.out.println("El cambio de estadisticas no es valido y no se ha realizado");
		} else {
			this.ataqueFisico = ataque;
		}

	}

	public int getDefensaFisica() {
		return defensaFisico;
	}

	public void setDefensaFisica(int defensaFisica) {
		if (defensaFisica <= 0) {
			System.out.println("El cambio de estadisticas no es valido y no se ha realizado");
		} else {
			this.defensaFisico = defensaFisica;
		}
	}

	public int getAtaqueEspecial() {
		return ataqueEspecial;
	}

	public void setAtaqueEspecial(int ataqueEspecial) {
		if (ataqueEspecial <= 0) {
			System.out.println("El cambio de estadisticas no es valido y no se ha realizado");
		} else {
			this.ataqueEspecial = ataqueEspecial;
		}

	}

	public int getDefensaEspecial() {
		return defensaEspecial;
	}

	public void setDefensaEspecial(int defensaEspecial) {
		if (defensaEspecial <= 0) {
			System.out.println("El cambio de estadisticas no es valido y no se ha realizado");
		} else {
			this.defensaEspecial = defensaEspecial;
		}
	}

	public int getPuntosVidaActuales() {
		return puntosVidaActuales;
	}

	public void setPuntosVidaActuales(int puntosVidaActuales) {
		this.puntosVidaActuales = puntosVidaActuales;
	}

	public int getPuntosVidaMaximo() {
		return puntosVidaMaximo;
	}

	public void setPuntosVidaMaximo(int puntosVidaMaximo) {
		if (puntosVidaMaximo <= 0) {
			System.out.println("El cambio de estadisticas no es valido y no se ha realizado");
		} else {
			this.puntosVidaMaximo = puntosVidaMaximo;
			setPuntosVidaActuales(puntosVidaMaximo);
		}
	}

	// Métodos
	public String validarNombre() {
		if (this.mote != null) {
			return this.mote;
		} else {
			return this.nombrePokemon;
		}
	}
	
	public void reducirPuntosDeVida(int v) {
		this.puntosVidaActuales = this.puntosVidaActuales - v;
		if (this.puntosVidaActuales <= 0) {
			this.puntosVidaActuales = 0;
		}
	}

	public void atacar(Pokemon enemigo, int opcion) {
		opcion = opcion - 1;

		if (opcion == 0) {
			int danioFisico = this.ataqueFisico - enemigo.defensaFisico;
			System.out.println(validarNombre() + " usa " + movimientos.get(opcion) + " contra " + enemigo.validarNombre());
			if (danioFisico <= 0) {
				danioFisico = 1;
			}
			enemigo.reducirPuntosDeVida(danioFisico);

		} else {
			int danioEspecial = this.ataqueEspecial - enemigo.defensaEspecial;
			System.out.println(validarNombre() + " usa " + movimientos.get(opcion) + " contra " + enemigo.validarNombre());
			if (danioEspecial <= 0) {
				danioEspecial = 1;
			}
			enemigo.reducirPuntosDeVida(danioEspecial);
		}

	}

	public void mostrarEstadoDelPokemon() { // Hecho por fran
		String RED = "\u001B[31m", GREEN = "\u001B[32m", YELLOW = "\u001B[33m", ANSI_RESET = "\u001B[0m", color = null;
		int porcentaje = (this.puntosVidaActuales * 100) / this.puntosVidaMaximo;
		int cantidad = (this.puntosVidaActuales * 20) / this.puntosVidaMaximo;
		
		if (porcentaje == 100) {
		    color = GREEN;
		} else if (porcentaje < 25) {
		    color = RED;
		} else if (porcentaje < 50) {
		    color = YELLOW;
		} else {
		    color = GREEN;
		}
		
		System.out.println("——————————————————————————————————");
		System.out.println(validarNombre());
		System.out.print(this.puntosVidaActuales + "/" + this.puntosVidaMaximo + " ");
		System.out.print(" |");
		for (int i = 0; i < cantidad; i++) {
			System.out.print(color + "■" + ANSI_RESET);
		}
		for (int g = 0; g < 20 - cantidad; g++) {
			System.out.print("⬚");
		}
		System.out.println("|");
		System.out.println("——————————————————————————————————");
	}

	public void mostrarAtaques() {
		System.out.println("Lista de movimientos de " + validarNombre());
		for (int i = 0; i < movimientos.size(); i++) {
			System.out.println((i + 1) + " : " + this.movimientos.get(i));
		}
	}

	public boolean esValidoParaCombate() { // Hecho por Raúl: valida un pokemon antes de un combate
		int poderTotal = this.velocidad + this.ataqueFisico + this.defensaFisico + this.ataqueEspecial
				+ this.defensaEspecial + this.puntosVidaMaximo;

		if (velocidad > 0 && ataqueFisico > 0 && defensaFisico > 0 && ataqueEspecial > 0 && defensaEspecial > 0
				&& puntosVidaMaximo > 0 && poderTotal <= this.poderMaximo) {
			return true;
		} else {
			System.out.println("El poder de " + validarNombre() + " no puede superar " + this.poderMaximo);
		}
		return false;
	}
}