package Programa;

public class AtaqueMejora extends AtaqueOfensivo {
	private String caracteristica;
	
	
	public AtaqueMejora(String nombre, int potencia, int precision, int pp, String caracteristica) {
		super(nombre, potencia, precision, pp);
		this.caracteristica = caracteristica;
	}

	@Override
	public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {
		// TODO Auto-generated method stub
		
		
		mejorarCaracteristica(pAtacante);
	}
	
	public void mejorarCaracteristica(Pokemon pAtacante ) {
		double multi=1;
		
		if(this.caracteristica.equalsIgnoreCase("AtaF")) {
			if(pAtacante.getNivAtF() <6) {
				
				pAtacante.setNivAtF(+1);
				for(int i=0; i<pAtacante.getNivAtF();i++) {
					multi +=0.5;
				}
				
				pAtacante.setAtaqueFisico((int) multi);
			}			
		}
		/*else if(this.caracteristica.equalsIgnoreCase("defF")) {
			if(pAtacante.getNivDefF()<6 ) {
				
				pAtacante.setDefensaFisica(+1);
				for(int i=0; i<pAtacante.getNivDefF();i++) {
					multi +=0.5;
				}
				
				pAtacante.setAtaqueFisico((int) multi);
			}

		}
		else if(this.caracteristica.equalsIgnoreCase("AtaE")) {
			if(pAtacante.getNivAtF()<6 ) {
				
				pAtacante.setDefensaFisica(+1);
				for(int i=0; i<pAtacante.getNivDefF();i++) {
					multi +=0.5;
				}
				
				pAtacante.setDefensaFisica();;
			}

		}else if(this.caracteristica.equalsIgnoreCase("DefE")) {
			if(pAtacante.getNivDefE()<6 ) {
				
				pAtacante.setDefensaFisica(+1);
				for(int i=0; i<pAtacante.getNivDefF();i++) {
					multi +=0.5;
				}
				
				pAtacante.setAtaqueEspecial((int) multi);
			}

		}else if(this.caracteristica.equalsIgnoreCase("Vel")) {
			if(pAtacante.getNivDefF()<6 ) {
				
				pAtacante.setDefensaFisica(+1);
				for(int i=0; i<pAtacante.getNivDefF();i++) {
					multi +=0.5;
				}
				
				pAtacante.setAtaqueFisico((int) multi);
			}
		}*/
		

	}
	

}
