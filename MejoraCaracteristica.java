package ProyectoIntegradorPokemon;

import java.util.ArrayList;
import java.util.List;

public class MejoraCaracteristica extends AtaquesEstado{
	private List<String> caracteristicas;
	private int cantidad;
	
	public MejoraCaracteristica(String nombre, String categoria, int precision, int pp, boolean prioridad,
			int cantidad, List<String> caracteristicas, Tipo.Tipos tipoAtaque) {
		super(nombre, categoria, precision, pp, prioridad, tipoAtaque);
		this.cantidad = cantidad;
		this.caracteristicas = new ArrayList<>();
		
		for(String car : caracteristicas) {
			this.caracteristicas.add(car);
		}
	}

	@Override
	public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {
		// TODO Auto-generated method stub
		if (tienePps()) {
			ppActual--;
			
			if (acierta()) {
				
				mejorarCaracteristica(pAtacante);
				
				System.out.println(pAtacante.validarNombre() + " bajó su " + this.caracteristicas.toString());
				
			} else {
				System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + " pero falló...");
			}
		} else {
			System.out.println(getNombre() + " no tiene PP");
		}
	}
	
	public void mejorarCaracteristica(Pokemon pAtacante) {
		
		for(String car : caracteristicas) {

			if (car.equalsIgnoreCase("AtF")) {
				if (pAtacante.getNivAtF() <= 6) {
	
					pAtacante.setNivAtF(pAtacante.getNivAtF() + cantidad);
	
					double suma = 0;
	
					if (pAtacante.getNivAtF() >= -6 && pAtacante.getNivAtF() < 0) {
						suma = 0.25;
	
						for (int i = -5; i <= pAtacante.getNivAtF(); i++) {
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
			} else if (car.equalsIgnoreCase("defF")) {
				if (pAtacante.getNivDefF() <= 6) {
	
					pAtacante.setNivDefF(pAtacante.getNivDefF() + 1);
	
					double suma = 0;
	
					if (pAtacante.getNivDefF() >= -6 && pAtacante.getNivDefF() < 0) {
						suma = 0.25;
	
						for (int i = -5; i <= pAtacante.getNivDefF(); i++) {
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
	
			} else if (car.equalsIgnoreCase("AtaE")) {
				if (pAtacante.getNivAtE() <= 6) {
	
					pAtacante.setNivAtE(pAtacante.getNivAtE() + 1);
	
					double suma = 0;
	
					if (pAtacante.getNivAtE() >= -6 && pAtacante.getNivAtE() < 0) {
						suma = 0.25;
	
						for (int i = -5; i <= pAtacante.getNivAtE(); i++) {
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
	
			} else if (car.equalsIgnoreCase("DefE")) {
	
				if (pAtacante.getNivDefE() <= 6) {
	
					pAtacante.setNivDefE(pAtacante.getNivDefE() + 1);
	
					double suma = 0;
	
					if (pAtacante.getNivDefE() >= -6 && pAtacante.getNivDefE() < 0) {
						suma = 0.25;
	
						for (int i = -5; i <= pAtacante.getNivDefE(); i++) {
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
	
			} else if (car.equalsIgnoreCase("Vel")) {
	
				if (pAtacante.getNivVel() <= 6) {
	
					pAtacante.setNivVel(pAtacante.getNivVel()+1);
	
					double suma = 0;
	
					if (pAtacante.getNivVel() >= -6 && pAtacante.getNivVel() < 0) {
						suma = 0.25;
	
						for (int i = -5; i <= pAtacante.getNivVel(); i++) {
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

}
