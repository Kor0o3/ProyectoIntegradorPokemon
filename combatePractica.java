package Programa;

import java.util.Scanner;

public class combatePractica {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean pokemonDerrotado = false;
		int opcion;
		int cont = 1;

		Pokemon pokemon1 = new Pokemon("Pikachu", /* Vel */ 10, /* AtqF */ 60, /* DefF */ 20, /* AtqE */ 30,
				/* DefE */ 10, /* HP */ 160);
		pokemon1.movimientos.add("Placaje");
		pokemon1.movimientos.add("Rayo");

		Pokemon pokemon2 = new Pokemon("Charmander", "Charizard", /* Vel */ 60, /* AtqF */ 80, /* DefF */ 50,
				/* AtqE */ 30, /* DefE */ 15, /* HP */ 100);
		pokemon2.movimientos.add("Arañazo");
		pokemon2.movimientos.add("Ascuas");

		if (pokemon1.esValidoParaCombate() && pokemon2.esValidoParaCombate()) {
			System.out.println("Ronda " + cont);
			System.out.println("-----------------------------------");
			pokemon1.mostrarEstadoDelPokemon();
			pokemon2.mostrarEstadoDelPokemon();
			do {
				if (pokemon1.getVelocidad() > pokemon2.getVelocidad()) {
					// Pokemon1 ataca primero
					if (pokemonDerrotado == false) {
						pokemon1.mostrarAtaques();
						System.out.print("Que ataque quieres hacer: ");
						opcion = sc.nextInt();

						pokemon1.atacar(pokemon2, opcion);
					}
					if (pokemon2.getPuntosVidaActuales() == 0) {
						pokemonDerrotado = true;
						System.out.println(pokemon2.validarNombre() + " ha sido derrotado");
					} else if (pokemonDerrotado == false) {
						pokemon2.mostrarEstadoDelPokemon();
					}

					if (pokemonDerrotado == false) {
						pokemon2.mostrarAtaques();
						System.out.print("Que ataque quieres hacer: ");
						opcion = sc.nextInt();
						pokemon2.atacar(pokemon1, opcion);
					}

					if (pokemon1.getPuntosVidaActuales() == 0) {
						pokemonDerrotado = true;
						System.out.println(pokemon1.validarNombre() + " ha sido derrotado");
					} else if (pokemonDerrotado == false) {
						pokemon1.mostrarEstadoDelPokemon();
					}

				} else {
					// Pokemon2 ataca primero
					if (pokemonDerrotado == false) {
						pokemon2.mostrarAtaques();
						System.out.print("Que ataque quieres hacer: ");
						opcion = sc.nextInt();

						pokemon2.atacar(pokemon1, opcion);
					}

					if (pokemon1.getPuntosVidaActuales() == 0) {
						pokemonDerrotado = true;
						System.out.println(pokemon1.validarNombre() + " ha sido derrotado");
					} else if (pokemonDerrotado == false) {
						pokemon1.mostrarEstadoDelPokemon();
					}

					if (pokemonDerrotado == false) {
						pokemon1.mostrarAtaques();
						System.out.print("Que ataque quieres hacer: ");
						opcion = sc.nextInt();

						pokemon1.atacar(pokemon2, opcion);
					}

					if (pokemon2.getPuntosVidaActuales() == 0) {
						pokemonDerrotado = true;
						System.out.println(pokemon2.validarNombre() + " ha sido derrotado");

					} else if (pokemonDerrotado == false) {
						pokemon2.mostrarEstadoDelPokemon();
					}
				}
				cont++;
			} while (!pokemonDerrotado);
			sc.close();
		}
	}
}


