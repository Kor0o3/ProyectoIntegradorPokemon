package ProyectoIntegradorPokemon;

public class AtaqueMejora extends AtaqueOfensivos {
	private String caracteristica;
	private int cantidad;

	public AtaqueMejora(String nombre, String tipo, String caracteristica, int cantidad, int potencia, int precision,
			int pp, boolean prioridad, Tipo.Tipos tipoAtaque) {
		super(nombre, tipo, potencia, precision, pp, prioridad, tipoAtaque);
		this.caracteristica = caracteristica;
		this.cantidad = cantidad;
	}

	@Override
	public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {
		// TODO Auto-generated method stub
		int danio = 0;
		if (tienePps()) {
			ppActual--;

			if (acierta()) {
				if (this.getCategoria().equalsIgnoreCase("fisico")) {
					danio = calcularDanio(pAtacante.getAtaqueFisico(), pEnemigo.getDefensaFisica());
				} else if (this.getCategoria().equalsIgnoreCase("especial")) {
					danio = calcularDanio(pAtacante.getAtaqueEspecial(), pEnemigo.getDefensaEspecial());
				}
				pEnemigo.reducirPuntosDeVida(danio);
				
				Tipo tabla = new Tipo();
				double mult = tabla.getMultiplicadorTotal(this.getTipoAtaque(), pAtacante, pEnemigo.getTipo1(), pEnemigo.getTipo2());
				danio = (int)(danio * mult);
				
				if (esCritico()) {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + ". Golpe critico!");
				} else {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre());
				}
				
				if (mult == 0) {
					System.out.println("¡No afecta a " + pEnemigo.validarNombre() + "!");
				}
				else if (mult >= 2) {
					System.out.println("¡Es muy eficaz!");
				}
				else if (mult <= 0.5) {
					System.out.println("No es eficaz");
				}
				else {
					System.out.println("El ataque es neutro");
				}

				mejorarCaracteristica(pAtacante);

				System.out.println(pAtacante.validarNombre() + " subió su " + this.caracteristica);
			} else {
				System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + " pero falló...");
			}
		} else {
			System.out.println(getNombre() + " no tiene PP");
		}
	}

	public void mejorarCaracteristica(Pokemon pAtacante) {
		if (this.caracteristica.equalsIgnoreCase("AtF")) {
			if (pAtacante.getNivAtF() <= 6) {

				pAtacante.setNivAtF(pAtacante.getNivAtF() + cantidad);

				double suma = 0;

				if (pAtacante.getNivAtF() >= -6 && pAtacante.getNivAtF() < 0) {
					suma = 0.25;

					for (int i = -6; i <= pAtacante.getNivAtF(); i++) {
						if (i < -3) {
							suma += 0.04;
						} else if (i == -3) {
							suma += 0.07;
						} else if (i == -2) {
							suma += 0.1;
						} else if (i == -1) {
							suma += 0.17;
						}
					}
				} else if (pAtacante.getNivAtF() == 0) {
					pAtacante.setAtaqueFisico(pAtacante.getCaracteristicaBase(0));
				} else if (pAtacante.getNivAtF() > 0 && pAtacante.getNivAtF() <= 6) {
					suma = 1;

					for (int i = 1; i <= pAtacante.getNivAtF(); i++) {
						suma += 0.50;
					}
				}

				pAtacante.setAtaqueFisico((int) (pAtacante.getCaracteristicaBase(0) * suma));
			}
		} else if (this.caracteristica.equalsIgnoreCase("defF")) {
			if (pAtacante.getNivDefF() <= 6) {

				pAtacante.setNivDefF(pAtacante.getNivDefF() + 1);

				double suma = 0;

				if (pAtacante.getNivDefF() >= -6 && pAtacante.getNivDefF() < 0) {
					suma = 0.25;

					for (int i = -6; i <= pAtacante.getNivDefF(); i++) {
						if (i < -3) {
							suma += 0.04;
						} else if (i == -3) {
							suma += 0.07;
						} else if (i == -2) {
							suma += 0.1;
						} else if (i == -1) {
							suma += 0.17;
						}
					}
				} else if (pAtacante.getNivDefF() == 0) {
					pAtacante.setDefensaFisica(pAtacante.getCaracteristicaBase(1));
				} else if (pAtacante.getNivDefF() > 0 && pAtacante.getNivDefF() <= 6) {
					suma = 1;

					for (int i = 1; i <= pAtacante.getNivDefF(); i++) {
						suma += 0.50;
					}
				}

				pAtacante.setDefensaFisica((int) (pAtacante.getCaracteristicaBase(1) * suma));
			}

		} else if (this.caracteristica.equalsIgnoreCase("AtaE")) {
			if (pAtacante.getNivAtE() <= 6) {

				pAtacante.setNivAtE(pAtacante.getNivAtE() + 1);

				double suma = 0;

				if (pAtacante.getNivAtE() >= -6 && pAtacante.getNivAtE() < 0) {
					suma = 0.25;

					for (int i = -6; i <= pAtacante.getNivAtE(); i++) {
						if (i < -3) {
							suma += 0.04;
						} else if (i == -3) {
							suma += 0.07;
						} else if (i == -2) {
							suma += 0.1;
						} else if (i == -1) {
							suma += 0.17;
						}
					}
				} else if (pAtacante.getNivAtE() == 0) {
					pAtacante.setAtaqueEspecial(pAtacante.getCaracteristicaBase(2));
				} else if (pAtacante.getNivAtE() > 0 && pAtacante.getNivAtE() <= 6) {
					suma = 1;

					for (int i = 1; i <= pAtacante.getNivAtE(); i++) {
						suma += 0.50;
					}
				}

				pAtacante.setAtaqueEspecial((int) (pAtacante.getCaracteristicaBase(2) * suma));
			}

		} else if (this.caracteristica.equalsIgnoreCase("DefE")) {

			if (pAtacante.getNivDefE() <= 6) {

				pAtacante.setNivDefE(pAtacante.getNivDefE() + 1);

				double suma = 0;

				if (pAtacante.getNivDefE() >= -6 && pAtacante.getNivDefE() < 0) {
					suma = 0.25;

					for (int i = -6; i <= pAtacante.getNivDefE(); i++) {
						if (i < -3) {
							suma += 0.04;
						} else if (i == -3) {
							suma += 0.07;
						} else if (i == -2) {
							suma += 0.1;
						} else if (i == -1) {
							suma += 0.17;
						}
					}
				} else if (pAtacante.getNivDefE() == 0) {
					pAtacante.setDefensaEspecial(pAtacante.getCaracteristicaBase(3));
				} else if (pAtacante.getNivDefE() > 0 && pAtacante.getNivDefE() <= 6) {
					suma = 1;

					for (int i = 1; i <= pAtacante.getNivDefE(); i++) {
						suma += 0.50;
					}
				}
				pAtacante.setDefensaEspecial((int) (pAtacante.getCaracteristicaBase(3) * suma));
			}

		} else if (this.caracteristica.equalsIgnoreCase("Vel")) {

			if (pAtacante.getNivVel() <= 6) {

				pAtacante.setNivVel(pAtacante.getNivVel()+1);

				double suma = 0;

				if (pAtacante.getNivVel() >= -6 && pAtacante.getNivVel() < 0) {
					suma = 0.25;

					for (int i = -6; i <= pAtacante.getNivVel(); i++) {
						if (i < -3) {
							suma += 0.04;
						} else if (i == -3) {
							suma += 0.07;
						} else if (i == -2) {
							suma += 0.1;
						} else if (i == -1) {
							suma += 0.17;
						}
					}
				} else if (pAtacante.getNivVel() == 0) {
					pAtacante.setVelocidad(pAtacante.getCaracteristicaBase(4));
				} else if (pAtacante.getNivVel() > 0 && pAtacante.getNivVel() <= 6) {
					suma = 1;

					for (int i = 1; i <= pAtacante.getNivVel(); i++) {
						suma += 0.50;
					}
				}

				pAtacante.setVelocidad((int) (pAtacante.getCaracteristicaBase(4) * suma));
			}

		}

	}

}