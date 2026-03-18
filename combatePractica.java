package ProyectoIntegradorPokemon;

import java.util.Scanner;

import ProyectoIntegradorPokemon.Tipo.Tipos;

public class combatePractica {
	public static void main(String[] args) {
		Tipo tabla = new Tipo();
		Scanner sc = new Scanner(System.in);
		boolean pokemonDerrotado = false;
		int masVeloz = 0, opcionP1 = 0, opcionP2 = 0, cont = 1;

		Pokemon pokemon1 = new Pokemon("Pikachu", 45, 200, 20, 100, 10, 120, Tipo.Tipos.Electrico,null);
		pokemon1.agregarAtaque(new AtaqueTipo("Ataque Rapido", "fisico", 30, 60, 15, true, Tipos.Electrico));
		pokemon1.agregarAtaque(new AtaqueTipo("Portazo", "fisico", 80, 75, 20, false,null));
		pokemon1.agregarAtaque(new AtaqueTipo("Rayo", "especial", 90, 100, 15, false, null));
		pokemon1.agregarAtaque(new AtaqueRetroceso("Placaje electrico", "fisico", 120, 100, 15, false, null));
		
		Pokemon pokemon2 = new Pokemon("Charmander", "Clipper", 50, 45, 20, 30, 25, 120, Tipo.Tipos.Fuego, null);
		pokemon2.agregarAtaque(new AtaqueReduccion("Viento Hielo", "especial","Vel",1,pokemon1,55,95,15,false, Tipos.Agua));
		//pokemon2.agregarAtaque(new AtaqueReduccion("Rencor Reprimido", "especial", "AtF", 1, pokemon1, 75, 100, 5, false));
		//pokemon2.agregarAtaque(new AtaqueReduccion("Arremetida", "fisico", "DefF", 1, pokemon2, 120, 100, 5, false));
		//pokemon2.agregarAtaque(new AtaqueMejora("Nitrocarga", "fisico", "Vel", 1, 50, 100, 20, false));
		//pokemon2.agregarAtaque(new AtaqueMejora("Puño incrimento", "fisico", "AtF", 1, 40, 100, 20, false));
		pokemon2.agregarAtaque(new AtaqueTipo("Ascuas", "especial", 40, 951, 25, true, null));
		pokemon2.agregarAtaque(new AtaqueDrenado("Gigadrenado", "fisico", 2, 75, 100, 10, false, null));
		//pokemon2.agregarAtaque(new AtaqueRecuperacion("Recuperacion", "estado", 100, 10, false));
		
		
		if (pokemon1.esValidoParaCombate() && pokemon2.esValidoParaCombate()) {
			mostrarPokemons(pokemon1, pokemon2);
			do {
				// Pokemon1 ataca primero
				if (pokemon1.getVelocidad() > pokemon2.getVelocidad() || masVeloz == 1) {
					// Primera parte escoger los movimientos
					if (!pokemonDerrotado && pokemon1.getPuntosVidaActuales() > 0
							&& pokemon2.getPuntosVidaActuales() > 0) {
						System.out.println("Ronda " + cont);
						System.out.println("——————————————————————————————————");
						System.out.println("Turno de " + pokemon1.validarNombre());
						System.out.println("——————————————————————————————————");
						pokemon1.mostrarAtaques();
						do {
							System.out.print("Que ataque hara " + pokemon1.validarNombre() + " : ");
							opcionP1 = sc.nextInt();
						} while (opcionP1 < 1 || opcionP1 > 4 || !pokemon1.puedesUsarAtaque(opcionP1));

						System.out.println("——————————————————————————————————");
						System.out.println("Turno de " + pokemon2.validarNombre());
						System.out.println("——————————————————————————————————");
						pokemon2.mostrarAtaques();
						do {
							System.out.print("Que ataque hara " + pokemon2.validarNombre() + " : ");
							opcionP2 = sc.nextInt();
						} while (opcionP2 < 1 || opcionP2 > 4 || !pokemon2.puedesUsarAtaque(opcionP2));
					}

					// Segunda parte atacan
					if (pokemon1.getPuntosVidaActuales() == 0) {
						pokemonDerrotado = true;
						System.out.println(pokemon1.validarNombre() + " ha sido derrotado");
					} else if (pokemon2.getPuntosVidaActuales() == 0) {
						pokemonDerrotado = true;
						System.out.println(pokemon2.validarNombre() + " ha sido derrotado");
					} else if (!pokemonDerrotado && pokemon1.AtacaConPrioridad(opcionP1)) {
						combatePokemon(pokemon1, pokemon2, opcionP1, opcionP2,tabla);
					} else if (!pokemonDerrotado && pokemon2.AtacaConPrioridad(opcionP2)) {
						combatePokemon(pokemon2, pokemon1, opcionP2, opcionP1,tabla);
					} else if (!pokemonDerrotado) {
						combatePokemon(pokemon1, pokemon2, opcionP1, opcionP2,tabla);
					}
				} else if (pokemon2.getVelocidad() > pokemon1.getVelocidad() || masVeloz == 2) {
					// Pokemon2 ataca primero
					if (!pokemonDerrotado && pokemon1.getPuntosVidaActuales() > 0
							&& pokemon2.getPuntosVidaActuales() > 0) {
						// Primera parte escoger los movimientos
						System.out.println("Ronda " + cont);
						System.out.println("——————————————————————————————————");
						System.out.println("Turno de " + pokemon2.validarNombre());
						System.out.println("——————————————————————————————————");
						pokemon2.mostrarAtaques();
						do {
							System.out.print("Que ataque hara " + pokemon2.validarNombre() + " : ");
							opcionP2 = sc.nextInt();
						} while (opcionP2 < 1 || opcionP2 > 4 || !pokemon2.puedesUsarAtaque(opcionP2));

						System.out.println("——————————————————————————————————");
						System.out.println("Turno de " + pokemon1.validarNombre());
						System.out.println("——————————————————————————————————");
						pokemon1.mostrarAtaques();
						do {
							System.out.print("Que ataque hara " + pokemon1.validarNombre() + " : ");
							opcionP1 = sc.nextInt();
						} while (opcionP1 < 1 || opcionP1 > 4 || !pokemon1.puedesUsarAtaque(opcionP1));
					}
					// segunda parte atacan
					if (pokemon1.getPuntosVidaActuales() == 0) {
						pokemonDerrotado = true;
						System.out.println(pokemon1.validarNombre() + " ha sido derrotado");
					} else if (pokemon2.getPuntosVidaActuales() == 0) {
						pokemonDerrotado = true;
						System.out.println(pokemon2.validarNombre() + " ha sido derrotado");
					} else if (!pokemonDerrotado && pokemon2.AtacaConPrioridad(opcionP2)) {
						combatePokemon(pokemon2, pokemon1, opcionP2, opcionP1,tabla);
					} else if (!pokemonDerrotado && pokemon1.AtacaConPrioridad(opcionP1)) {
						combatePokemon(pokemon1, pokemon2, opcionP1, opcionP2,tabla);
					} else if (!pokemonDerrotado) {
						combatePokemon(pokemon2, pokemon1, opcionP2, opcionP1,tabla);
					}
				} else {// En caso de empate inicializamos masVeloz con un numero aleatorio que decida
						// quien ataca primero
					masVeloz = (int) (Math.random() * 2) + 1;
					cont--;
				}
				cont++;
			} while (!pokemonDerrotado);
			sc.close();
		}
	}

	// Metodos para optimizar un poco el main
	public static void mostrarPokemons(Pokemon pokemon1, Pokemon pokemon2) {
		pokemon1.mostrarEstadoDelPokemon();
		pokemon2.mostrarEstadoDelPokemon();
	}

	public static void combatePokemon(Pokemon pAtacante, Pokemon pDefensor, int oAtacante, int oDefensor,Tipo tabla) {
		System.out.println("——————————————————————————————————");
		if (pAtacante.getPuntosVidaActuales() > 0) {
			pAtacante.atacar(pDefensor, oAtacante);
		}
		if (pDefensor.getPuntosVidaActuales() > 0) {
			pDefensor.atacar(pAtacante, oDefensor);
		}
		mostrarPokemons(pAtacante, pDefensor);
		System.out.println("——————————————————————————————————");
	}
}