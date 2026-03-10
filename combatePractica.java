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

<<<<<<< Updated upstream
=======
		Pokemon pokemon1 = new Pokemon("Pikachu",45, 55, 20, 100, 10, 120);
		pokemon1.agregarAtaque(new AtaqueTipo("Ataque Rapido", "normal", 30, 60, 15, true));
		pokemon1.agregarAtaque(new AtaqueTipo("Portazo", "normal", 80, 75, 20, false));
		pokemon1.agregarAtaque(new AtaqueTipo("Rayo", "especial", 90, 100, 15, false));
		pokemon1.agregarAtaque(new AtaqueTipo("Trueno", "especial", 100, 45, 15, false));
		
		Pokemon pokemon2 = new Pokemon("Charmander", "jj", 50, 45, 20, 30, 25, 120);
		pokemon2.agregarAtaque(new AtaqueTipo("Placaje", "normal", 80, 100, 30, false));
		pokemon2.agregarAtaque(new AtaqueTipo("Ascuas", "especial", 40, 951, 25, true));
		pokemon2.agregarAtaque(new AtaqueDrenado("Gigadrenado", "normal", 2, 75, 100, 10, false));
		
		
>>>>>>> Stashed changes
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




