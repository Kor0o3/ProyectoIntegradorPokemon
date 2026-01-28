package Programa;

import java.util.Scanner;

public class combatePractica {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean pokemonDerrotado = false;
		int masVeloz = 0, opcionP1 = 0, opcionP2 = 0, cont = 1;

		Pokemon pokemon1 = new Pokemon("Pikachu", 55, 55, 20, 100, 10, 120);
		pokemon1.agregarAtaque(new AtaqueTipo("Ataque Rapido", "normal", 80, 60, 30, true));
		pokemon1.agregarAtaque(new AtaqueTipo("Portazo", "cuerpo", 80, 75, 20, false));
		pokemon1.agregarAtaque(new AtaqueTipo("Rayo", "especial", 90, 100, 15, false));
		pokemon1.agregarAtaque(new AtaqueTipo("Trueno", "especial", 100, 45, 15, false));
		pokemon1.agregarAtaque(new AtaqueTipo("Impactrueno", "especial", 40, 100, 15, false));

		Pokemon pokemon2 = new Pokemon("Charmander", "Clipper", 50, 85, 20, 65, 25, 120);
		pokemon2.agregarAtaque(new AtaqueTipo("Placaje", "normal", 80, 100, 30, false));
		pokemon2.agregarAtaque(new AtaqueTipo("Ascuas", "especial", 40, 951, 25, true));

		if (pokemon1.esValidoParaCombate() && pokemon2.esValidoParaCombate()) {
			mostrarPokemons(pokemon1, pokemon2);
			do {
				if (pokemon1.getVelocidad() > pokemon2.getVelocidad() || masVeloz == 1) {
					// Pokemon1 ataca primero
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
						} while (opcionP1 < 1 || opcionP1 > 4);

						System.out.println("——————————————————————————————————");
						System.out.println("Turno de " + pokemon2.validarNombre());
						System.out.println("——————————————————————————————————");
						pokemon2.mostrarAtaques();
						do {
							System.out.print("Que ataque hara " + pokemon2.validarNombre() + " : ");
							opcionP2 = sc.nextInt();
						} while (opcionP2 < 1 || opcionP2 > 4);
					}

					if (pokemon1.getPuntosVidaActuales() == 0) {
						pokemonDerrotado = true;
						System.out.println(pokemon1.validarNombre() + " ha sido derrotado");
					} else if (pokemon2.getPuntosVidaActuales() == 0) {
						pokemonDerrotado = true;
						System.out.println(pokemon2.validarNombre() + " ha sido derrotado");
					} else if (!pokemonDerrotado && pokemon1.AtacaConPrioridad(opcionP1)) {
						System.out.println("——————————————————————————————————");
						if (pokemon1.getPuntosVidaActuales() > 0) {
							pokemon1.atacar(pokemon2, opcionP1);
						}
						if (pokemon2.getPuntosVidaActuales() > 0) {
							pokemon2.atacar(pokemon1, opcionP2);
						}
						mostrarPokemons(pokemon1, pokemon2);
						System.out.println("——————————————————————————————————");
					} else if (!pokemonDerrotado && pokemon2.AtacaConPrioridad(opcionP2)) {
						System.out.println("——————————————————————————————————");
						if (pokemon2.getPuntosVidaActuales() > 0) {
							pokemon2.atacar(pokemon1, opcionP2);
						}
						if (pokemon1.getPuntosVidaActuales() > 0) {
							pokemon1.atacar(pokemon2, opcionP1);
						}
						mostrarPokemons(pokemon1, pokemon2);
						System.out.println("——————————————————————————————————");
					} else if (!pokemonDerrotado) {
						System.out.println("——————————————————————————————————");
						if (pokemon1.getPuntosVidaActuales() > 0) {
							pokemon1.atacar(pokemon2, opcionP1);
						}
						if (pokemon2.getPuntosVidaActuales() > 0) {
							pokemon2.atacar(pokemon1, opcionP2);
						}
						mostrarPokemons(pokemon1, pokemon2);
						System.out.println("——————————————————————————————————");
					}
				} else if (pokemon2.getVelocidad() > pokemon1.getVelocidad() || masVeloz == 2) {
					// Pokemon2 ataca primero
					if (!pokemonDerrotado && pokemon1.getPuntosVidaActuales() > 0
							&& pokemon2.getPuntosVidaActuales() > 0) {
						System.out.println("Ronda " + cont);

						System.out.println("——————————————————————————————————");
						System.out.println("Turno de " + pokemon2.validarNombre());
						System.out.println("——————————————————————————————————");
						pokemon2.mostrarAtaques();
						do {
							System.out.print("Que ataque hara " + pokemon2.validarNombre() + " : ");
							opcionP2 = sc.nextInt();
						} while (opcionP2 < 1 || opcionP2 > 4);

						System.out.println("——————————————————————————————————");
						System.out.println("Turno de " + pokemon1.validarNombre());
						System.out.println("——————————————————————————————————");
						pokemon1.mostrarAtaques();
						do {
							System.out.print("Que ataque hara " + pokemon1.validarNombre() + " : ");
							opcionP1 = sc.nextInt();
						} while (opcionP1 < 1 || opcionP1 > 4);
					}

					if (pokemon1.getPuntosVidaActuales() == 0) {
						pokemonDerrotado = true;
						System.out.println(pokemon1.validarNombre() + " ha sido derrotado");
					} else if (pokemon2.getPuntosVidaActuales() == 0) {
						pokemonDerrotado = true;
						System.out.println(pokemon2.validarNombre() + " ha sido derrotado");
					} else if (!pokemonDerrotado && pokemon2.AtacaConPrioridad(opcionP2)) {
						System.out.println("——————————————————————————————————");
						if (pokemon2.getPuntosVidaActuales() > 0) {
							pokemon2.atacar(pokemon1, opcionP2);
						}

						if (pokemon1.getPuntosVidaActuales() > 0) {
							pokemon1.atacar(pokemon2, opcionP1);
						}
						mostrarPokemons(pokemon1, pokemon2);
						System.out.println("——————————————————————————————————");
					} else if (!pokemonDerrotado && pokemon1.AtacaConPrioridad(opcionP1)) {
						System.out.println("——————————————————————————————————");
						if (pokemon1.getPuntosVidaActuales() > 0) {
							pokemon1.atacar(pokemon2, opcionP1);
						}
						if (pokemon2.getPuntosVidaActuales() > 0) {
							pokemon2.atacar(pokemon1, opcionP2);
						}
						mostrarPokemons(pokemon1, pokemon2);
						System.out.println("——————————————————————————————————");
					} else if (!pokemonDerrotado) {
						System.out.println("——————————————————————————————————");
						if (pokemon2.getPuntosVidaActuales() > 0) {
							pokemon2.atacar(pokemon1, opcionP2);
						}
						if (pokemon1.getPuntosVidaActuales() > 0) {
							pokemon1.atacar(pokemon2, opcionP1);
						}
						mostrarPokemons(pokemon1, pokemon2);
						System.out.println("——————————————————————————————————");
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

	public static void mostrarPokemons(Pokemon pokemon1, Pokemon pokemon2) {
		pokemon1.mostrarEstadoDelPokemon();
		pokemon2.mostrarEstadoDelPokemon();
	}
}
