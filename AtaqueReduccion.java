package Programa;

public class AtaqueReduccion extends AtaqueOfensivo {
	private String caracteristica;
	private int cantidad;
	
	
	public AtaqueReduccion(String nombre, int potencia, int precision, int pp, String caracteristica, int cantidad) {
		super(nombre, potencia, precision, pp);
		this.caracteristica = caracteristica;
		this.cantidad = cantidad;
	}

	@Override
	public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {
		// TODO Auto-generated method stub
		if (tienePps()) {
			ppActual--;
			
			if (acierta()) {
				int danio = calcularDanio(pAtacante.getAtaqueFisico(), pEnemigo.getDefensaFisica());
				pEnemigo.reducirPuntosDeVida(danio);
				if (esCritico()) {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + ". Golpe critico!");
				} else {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre());
				}
				
				reducirCaracteristica(pAtacante);
				
				System.out.println(pAtacante.validarNombre() + " bajó su " + this.caracteristica);
				
			} else {
				System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + " pero falló...");
			}
		} else {
			System.out.println(getNombre() + " no tiene PP");
		}
	}
	
	public void reducirCaracteristica(Pokemon pAtacante ) {
		double reduccion=1;
		
		if(this.caracteristica.equalsIgnoreCase("AtF")) {
			if(pAtacante.getNivAtF() <=6) {			
				
				pAtacante.setNivAtF(+cantidad);
				
				double resta= 0;
				
				if(pAtacante.getNivAtF()>=-6 && pAtacante.getNivAtF()<0) {
					resta = 0.67;
					
					for(int i=-1; i>=pAtacante.getNivAtF();i--) {
						if(i==-1) {
							resta -= 0.17;
						}
						else if(i==-2) {
							resta -= 0.1;
						}
						else if(i==-3) {
							resta -= 0.07;
						}
						else if(i<-3) {
							resta -=0.04;
						}
					}										
				}
				else if(pAtacante.getNivAtF()==0) {
					pAtacante.setAtaqueEspecial(pAtacante.getCaracteristicaBase(0));
				}
				else if(pAtacante.getNivAtF()>0 && pAtacante.getNivAtF()<=6) {
					resta = 1;
					
					for(int i=1; i<=pAtacante.getNivAtF(); i++) {
						resta -= 0.50; 
					}
				}
				
				pAtacante.setAtaqueEspecial((int)(pAtacante.getCaracteristicaBase(0)*resta));
			}
		}
		else if(this.caracteristica.equalsIgnoreCase("defF")) {
			if(pAtacante.getNivDefF() <=6) {			
				
				pAtacante.setNivDefF(+cantidad);
				
				double resta= 0;
				
				if(pAtacante.getNivDefF()>=-6 && pAtacante.getNivDefF()<0) {
					resta = 0.67;
					
					for(int i=-1; i>=pAtacante.getNivAtF();i--) {
						if(i==-1) {
							resta -= 0.17;
						}
						else if(i==-2) {
							resta -= 0.1;
						}
						else if(i==-3) {
							resta -= 0.07;
						}
						else if(i<-3) {
							resta -=0.04;
						}
					}										
				}
				else if(pAtacante.getNivDefF()==0) {
					pAtacante.setDefensaFisica(pAtacante.getCaracteristicaBase(1));
				}
				else if(pAtacante.getNivDefF()>0 && pAtacante.getNivDefF()<=6) {
					resta = 1;
					
					for(int i=1; i<=pAtacante.getNivDefF(); i++) {
						resta -= 0.50; 
					}
				}
				
				pAtacante.setDefensaFisica((int)(pAtacante.getCaracteristicaBase(1)*resta));
			}
		}
		else if(this.caracteristica.equalsIgnoreCase("AtE")) {
			if(pAtacante.getNivAtE() <=6) {			
				
				pAtacante.setNivAtE(+cantidad);
				
				double resta= 0;
				
				if(pAtacante.getNivAtE()>=-6 && pAtacante.getNivAtE()<0) {
					resta = 0.67;
					
					for(int i=-1; i>=pAtacante.getNivAtE();i--) {
						if(i==-1) {
							resta -= 0.17;
						}
						else if(i==-2) {
							resta -= 0.1;
						}
						else if(i==-3) {
							resta -= 0.07;
						}
						else if(i<-3) {
							resta -=0.04;
						}
					}										
				}
				else if(pAtacante.getNivAtE()==0) {
					pAtacante.setAtaqueEspecial(pAtacante.getCaracteristicaBase(2));
				}
				else if(pAtacante.getNivAtE()>0 && pAtacante.getNivAtE()<=6) {
					resta = 1;
					
					for(int i=1; i<=pAtacante.getNivAtE(); i++) {
						resta -= 0.50; 
					}
				}
				
				pAtacante.setAtaqueEspecial((int)(pAtacante.getCaracteristicaBase(2)*resta));
			}
			
		}else if(this.caracteristica.equalsIgnoreCase("DefE")) {
			if(pAtacante.getNivDefE() <=6) {			
				
				pAtacante.setNivDefE(+cantidad);
				
				double resta= 0;
				
				if(pAtacante.getNivDefE()>=-6 && pAtacante.getNivDefE()<0) {
					resta = 0.67;
					
					for(int i=-1; i>=pAtacante.getNivAtF();i--) {
						if(i==-1) {
							resta -= 0.17;
						}
						else if(i==-2) {
							resta -= 0.1;
						}
						else if(i==-3) {
							resta -= 0.07;
						}
						else if(i<-3) {
							resta -=0.04;
						}
					}										
				}
				else if(pAtacante.getNivDefE()==0) {
					pAtacante.setDefensaFisica(pAtacante.getCaracteristicaBase(3));
				}
				else if(pAtacante.getNivDefE()>0 && pAtacante.getNivDefE()<=6) {
					resta = 1;
					
					for(int i=1; i<=pAtacante.getNivDefE(); i++) {
						resta -= 0.50; 
					}
				}
				
				pAtacante.setDefensaFisica((int)(pAtacante.getCaracteristicaBase(3)*resta));
			}
		}else if(this.caracteristica.equalsIgnoreCase("Vel")) {
			
			if(pAtacante.getNivVel() <=6) {			
				
				pAtacante.setNivVel(+cantidad);
				
				double resta= 0;
				
				if(pAtacante.getNivVel()>=-6 && pAtacante.getNivVel()<0) {
					resta = 0.67;
					
					for(int i=-1; i>=pAtacante.getNivAtF();i--) {
						if(i==-1) {
							resta -= 0.17;
						}
						else if(i==-2) {
							resta -= 0.1;
						}
						else if(i==-3) {
							resta -= 0.07;
						}
						else if(i<-3) {
							resta -=0.04;
						}
					}										
				}
				else if(pAtacante.getNivVel()==0) {
					pAtacante.setVelocidad(pAtacante.getCaracteristicaBase(4));
				}
				else if(pAtacante.getNivVel()>0 && pAtacante.getNivVel()<=6) {
					resta = 1;
					
					for(int i=1; i<=pAtacante.getNivVel(); i++) {
						resta -= 0.50; 
					}
				}
				
				pAtacante.setVelocidad((int)(pAtacante.getCaracteristicaBase(4)*resta));
			}
		}
			
	}
}
