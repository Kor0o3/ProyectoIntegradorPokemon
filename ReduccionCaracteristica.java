package ProyectoIntegradorPokemon;

import java.util.ArrayList;
import java.util.List;

public class ReduccionCaracteristica extends AtaquesEstado{
	private List<String> caracteristicas;
	private int cantidad;
	
	public ReduccionCaracteristica(String nombre, String categoria, int precision, int pp, boolean prioridad,
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
				
				reducirCaracteristica(pAtacante);
				
				System.out.println(pAtacante.validarNombre() + " bajó su " + this.caracteristicas.toString());
				
			} else {
				System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + " pero falló...");
			}
			nombreUltimoAtq = this.nombre;
		} else {
			System.out.println(getNombre() + " no tiene PP");
		}
	}
	
	
	public void reducirCaracteristica(Pokemon pAReducir) {
		for(String car : caracteristicas) {

			if (car.equalsIgnoreCase("AtF")) {
				if (pAReducir.getNivAtF() <= 6) {
	
					pAReducir.setNivAtF(pAReducir.getNivAtF() - cantidad);
	
					double resta = 0;
	
					if (pAReducir.getNivAtF() >= -6 && pAReducir.getNivAtF() < 0) {
						resta = 0.67;
	
						for (int i = -2; i >= pAReducir.getNivAtF(); i--) {
							if (i == -2) {
								resta -= 0.17;
							} else if (i == -3) {
								resta -= 0.1;
							}else if (i == -4) {
								resta -= 0.07;
							} else if (i < -3) {
								resta -= 0.04;
							}
						}
					} else if (pAReducir.getNivAtF() == 0) {
						pAReducir.setAtaqueFisico(pAReducir.getCaracteristicaBase(0));
					} else if (pAReducir.getNivAtF() > 0 && pAReducir.getNivAtF() <= 6) {
						resta = 1;
	
						for (int i = 1; i <= pAReducir.getNivAtF(); i++) {
							resta -= 0.50;
						}
					}
	
					pAReducir.setAtaqueFisico((int) (pAReducir.getCaracteristicaBase(0) * resta));
				}
			} else if (car.equalsIgnoreCase("defF")) {
				if (pAReducir.getNivDefF() <= 6) {
	
					pAReducir.setNivDefF(pAReducir.getNivDefF()-cantidad);
	
					double resta = 0;
	
					if (pAReducir.getNivDefF() >= -6 && pAReducir.getNivDefF() < 0) {
						resta = 0.67;
	
						for (int i = -2; i >= pAReducir.getNivDefF(); i--) {
							if (i == -2) {
								resta -= 0.17;
							} else if (i == -3) {
								resta -= 0.1;
							}else if (i == -4) {
								resta -= 0.07;
							} else if (i < -3) {
								resta -= 0.04;
							}
						}
					} else if (pAReducir.getNivDefF() == 0) {
						pAReducir.setDefensaFisica(pAReducir.getCaracteristicaBase(1));
					} else if (pAReducir.getNivDefF() > 0 && pAReducir.getNivDefF() <= 6) {
						resta = 1;
	
						for (int i = 1; i <= pAReducir.getNivDefF(); i++) {
							resta -= 0.50;
						}
					}
	
					pAReducir.setDefensaFisica((int) (pAReducir.getCaracteristicaBase(1) * resta));
				}
			} else if (car.equalsIgnoreCase("AtE")) {
				if (pAReducir.getNivAtE() <= 6) {
	
					pAReducir.setNivAtE(pAReducir.getNivAtE()-cantidad);
	
					double resta = 0;
	
					if (pAReducir.getNivAtE() >= -6 && pAReducir.getNivAtE() < 0) {
						resta = 0.67;
	
						for (int i = -2; i >= pAReducir.getNivAtE(); i--) {
							if (i == -2) {
								resta -= 0.17;
							} else if (i == -3) {
								resta -= 0.1;
							}else if (i == -4) {
								resta -= 0.07;
							} else if (i < -3) {
								resta -= 0.04;
							}
						}
					} else if (pAReducir.getNivAtE() == 0) {
						pAReducir.setAtaqueEspecial(pAReducir.getCaracteristicaBase(2));
					} else if (pAReducir.getNivAtE() > 0 && pAReducir.getNivAtE() <= 6) {
						resta = 1;
	
						for (int i = 1; i <= pAReducir.getNivAtE(); i++) {
							resta -= 0.50;
						}
					}
	
					pAReducir.setAtaqueEspecial((int) (pAReducir.getCaracteristicaBase(2) * resta));
				}
	
			} else if (car.equalsIgnoreCase("DefE")) {
				if (pAReducir.getNivDefE() <= 6) {
	
					pAReducir.setNivDefE(pAReducir.getNivDefE()-cantidad);
	
					double resta = 0;
	
					if (pAReducir.getNivDefE() >= -6 && pAReducir.getNivDefE() < 0) {
						resta = 0.67;
	
						for (int i = -2; i >= pAReducir.getNivAtF(); i--) {
							if (i == -2) {
								resta -= 0.17;
							} else if (i == -3) {
								resta -= 0.1;
							}else if (i == -4) {
								resta -= 0.07;
							} else if (i < -3) {
								resta -= 0.04;
							}
						}
					} else if (pAReducir.getNivDefE() == 0) {
						pAReducir.setDefensaEspecial(pAReducir.getCaracteristicaBase(3));
					} else if (pAReducir.getNivDefE() > 0 && pAReducir.getNivDefE() <= 6) {
						resta = 1;
	
						for (int i = 1; i <= pAReducir.getNivDefE(); i++) {
							resta -= 0.50;
						}
					}
	
					pAReducir.setDefensaEspecial((int) (pAReducir.getCaracteristicaBase(3) * resta));
				}
			} else if (car.equalsIgnoreCase("Vel")) {
	
				if (pAReducir.getNivVel() <= 6) {
	
					pAReducir.setNivVel(pAReducir.getNivVel()-cantidad);
	
					double resta = 0;
	
					if (pAReducir.getNivVel() >= -6 && pAReducir.getNivVel() < 0) {
						resta = 0.67;
	
						for (int i = -2; i >= pAReducir.getNivAtF(); i--) {
							if (i == -2) {
								resta -= 0.17;
							} else if (i == -3) {
								resta -= 0.1;
							}else if (i == -4) {
								resta -= 0.07;
							} else if (i < -3) {
								resta -= 0.04;
							}
						}
					} else if (pAReducir.getNivVel() == 0) {
						pAReducir.setVelocidad(pAReducir.getCaracteristicaBase(4));
					} else if (pAReducir.getNivVel() > 0 && pAReducir.getNivVel() <= 6) {
						resta = 1;
	
						for (int i = 1; i <= pAReducir.getNivVel(); i++) {
							resta -= 0.50;
						}
					}
	
					pAReducir.setVelocidad((int) (pAReducir.getCaracteristicaBase(4) * resta));
				}
			}

		}
	}
}
