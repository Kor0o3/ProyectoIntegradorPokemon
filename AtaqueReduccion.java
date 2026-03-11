package ProyectoIntegradorPokemon;

public class AtaqueReduccion extends AtaqueOfensivos {
	private String caracteristica;
	private int cantidad;
	private Pokemon pAReducir;
	
	
	public AtaqueReduccion(String nombre,String tipo, int potencia, int precision, int pp, boolean prioridad,String caracteristica, int cantidad,Pokemon pAReducir) {
		super(nombre, tipo ,potencia, precision, pp, prioridad);
		this.caracteristica = caracteristica;
		this.cantidad = cantidad;
		this.pAReducir = pAReducir;
	}

	@Override
	public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {
		// TODO Auto-generated method stub
		int danio = 0;
		if (tienePps()) {
			ppActual--;
			if (acierta()) {
				if (this.getTipo().equalsIgnoreCase("normal")) {
					danio = calcularDanio(pAtacante.getAtaqueFisico(), pEnemigo.getDefensaFisica());
				} else if (this.getTipo().equalsIgnoreCase("especial")) {
					danio = calcularDanio(pAtacante.getAtaqueEspecial(), pEnemigo.getDefensaEspecial());
				}
				pEnemigo.reducirPuntosDeVida(danio);
				if (esCritico()) {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + ". Golpe critico!");
				} else {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre());
				}
				
				reducirCaracteristica(this.pAReducir);
				System.out.println(pAtacante.validarNombre() + " bajó su " + this.caracteristica);
				
			} else {
				System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + " pero falló...");
			}
		} else {
			System.out.println(getNombre() + " no tiene PP");
		}
	}
	
	public void reducirCaracteristica(Pokemon pAReducir) {
		double reduccion=1;
		
		if(this.caracteristica.equalsIgnoreCase("AtF")) {
			if(pAReducir.getNivAtF() <=6) {			
				
				pAReducir.setNivAtF(-cantidad);
				
				double resta= 0;
				
				if(pAReducir.getNivAtF()>=-6 && pAReducir.getNivAtF()<0) {
					resta = 0.67;
					
					for(int i=-1; i>=pAReducir.getNivAtF();i--) {
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
				else if(pAReducir.getNivAtF()==0) {
					pAReducir.setAtaqueEspecial(pAReducir.getCaracteristicaBase(0));
				}
				else if(pAReducir.getNivAtF()>0 && pAReducir.getNivAtF()<=6) {
					resta = 1;
					
					for(int i=1; i<=pAReducir.getNivAtF(); i++) {
						resta -= 0.50; 
					}
				}
				
				pAReducir.setAtaqueEspecial((int)(pAReducir.getCaracteristicaBase(0)*resta));
			}
		}
		else if(this.caracteristica.equalsIgnoreCase("defF")) {
			if(pAReducir.getNivDefF() <=6) {			
				
				pAReducir.setNivDefF(-cantidad);
				
				double resta= 0;
				
				if(pAReducir.getNivDefF()>=-6 && pAReducir.getNivDefF()<0) {
					resta = 0.67;
					
					for(int i=-1; i>=pAReducir.getNivAtF();i--) {
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
				else if(pAReducir.getNivDefF()==0) {
					pAReducir.setDefensaFisica(pAReducir.getCaracteristicaBase(1));
				}
				else if(pAReducir.getNivDefF()>0 && pAReducir.getNivDefF()<=6) {
					resta = 1;
					
					for(int i=1; i<=pAReducir.getNivDefF(); i++) {
						resta -= 0.50; 
					}
				}
				
				pAReducir.setDefensaFisica((int)(pAReducir.getCaracteristicaBase(1)*resta));
			}
		}
		else if(this.caracteristica.equalsIgnoreCase("AtE")) {
			if(pAReducir.getNivAtE() <=6) {			
				
				pAReducir.setNivAtE(-cantidad);
				
				double resta= 0;
				
				if(pAReducir.getNivAtE()>=-6 && pAReducir.getNivAtE()<0) {
					resta = 0.67;
					
					for(int i=-1; i>=pAReducir.getNivAtE();i--) {
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
				else if(pAReducir.getNivAtE()==0) {
					pAReducir.setAtaqueEspecial(pAReducir.getCaracteristicaBase(2));
				}
				else if(pAReducir.getNivAtE()>0 && pAReducir.getNivAtE()<=6) {
					resta = 1;
					
					for(int i=1; i<=pAReducir.getNivAtE(); i++) {
						resta -= 0.50; 
					}
				}
				
				pAReducir.setAtaqueEspecial((int)(pAReducir.getCaracteristicaBase(2)*resta));
			}
			
		}else if(this.caracteristica.equalsIgnoreCase("DefE")) {
			if(pAReducir.getNivDefE() <=6) {			
				
				pAReducir.setNivDefE(-cantidad);
				
				double resta= 0;
				
				if(pAReducir.getNivDefE()>=-6 && pAReducir.getNivDefE()<0) {
					resta = 0.67;
					
					for(int i=-1; i>=pAReducir.getNivAtF();i--) {
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
				else if(pAReducir.getNivDefE()==0) {
					pAReducir.setDefensaFisica(pAReducir.getCaracteristicaBase(3));
				}
				else if(pAReducir.getNivDefE()>0 && pAReducir.getNivDefE()<=6) {
					resta = 1;
					
					for(int i=1; i<=pAReducir.getNivDefE(); i++) {
						resta -= 0.50; 
					}
				}
				
				pAReducir.setDefensaFisica((int)(pAReducir.getCaracteristicaBase(3)*resta));
			}
		}else if(this.caracteristica.equalsIgnoreCase("Vel")) {
			
			if(pAReducir.getNivVel() <=6) {			
				
				pAReducir.setNivVel(-cantidad);
				
				double resta= 0;
				
				if(pAReducir.getNivVel()>=-6 && pAReducir.getNivVel()<0) {
					resta = 0.67;
					
					for(int i=-1; i>=pAReducir.getNivAtF();i--) {
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
				else if(pAReducir.getNivVel()==0) {
					pAReducir.setVelocidad(pAReducir.getCaracteristicaBase(4));
				}
				else if(pAReducir.getNivVel()>0 && pAReducir.getNivVel()<=6) {
					resta = 1;
					
					for(int i=1; i<=pAReducir.getNivVel(); i++) {
						resta -= 0.50; 
					}
				}
				
				pAReducir.setVelocidad((int)(pAReducir.getCaracteristicaBase(4)*resta));
			}
		}
			
	}
}
