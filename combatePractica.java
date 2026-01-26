package ProgramaS;

import java.util.Scanner;

public class combatePractica {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean pokemonDerrotado = false;
		int masVeloz = 0, opcionP1 = 0, opcionP2 = 0, cont = 1;

		Pokemon pokemon1 = new Pokemon("Pikachu", 86, 55, 40, 50, 50, 100);
		pokemon1.movimientos.add("Placaje");
		pokemon1.movimientos.add("Rayo");

		Pokemon pokemon2 = new Pokemon("Charmander", "Clipper", 85, 84, 20, 109, 85, 120);
		pokemon2.movimientos.add("Arañazo");
		pokemon2.movimientos.add("Ascuas");

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
						} while (opcionP1 < 1 || opcionP1 > 2);
						
						System.out.println("——————————————————————————————————");
						System.out.println("Turno de " + pokemon2.validarNombre());
						System.out.println("——————————————————————————————————");
						pokemon2.mostrarAtaques();
						do {
							System.out.print("Que ataque hara " + pokemon2.validarNombre() + " : ");
							opcionP2 = sc.nextInt();
						} while (opcionP2 < 1 || opcionP2 > 2);
					}

					if (pokemon1.getPuntosVidaActuales() == 0) {
						pokemonDerrotado = true;
						System.out.println(pokemon1.validarNombre() + " ha sido derrotado");
					} else if (pokemon2.getPuntosVidaActuales() == 0) {
						pokemonDerrotado = true;
						System.out.println(pokemon2.validarNombre() + " ha sido derrotado");
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
						} while (opcionP2 < 1 || opcionP2 > 2);

						System.out.println("——————————————————————————————————");
						System.out.println("Turno de " + pokemon1.validarNombre());
						System.out.println("——————————————————————————————————");
						pokemon1.mostrarAtaques();
						do {
							System.out.print("Que ataque hara " + pokemon1.validarNombre() + " : ");
							opcionP1 = sc.nextInt();
						} while (opcionP1 < 1 || opcionP1 > 2);
					}

					if (pokemon1.getPuntosVidaActuales() == 0) {
						pokemonDerrotado = true;
						System.out.println(pokemon1.validarNombre() + " ha sido derrotado");
					} else if (pokemon2.getPuntosVidaActuales() == 0) {
						pokemonDerrotado = true;
						System.out.println(pokemon2.validarNombre() + " ha sido derrotado");
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
