package ProyectoIntegradorPokemon;

public class AtaqueProteccion extends AtaquesEstado {
	    private int tempPre; // añadido por raul
		
		public AtaqueProteccion(String nombre, String tipo, int precision, int pp, boolean prioridad, Tipo.Tipos tipoAtaque) {
			super(nombre, tipo, precision, pp, prioridad, tipoAtaque);
			this.tempPre = precision;
		}
		
		@Override
		public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {
			if(tienePps()) {
				ppActual--;
				
				// añadido por raul {
				if (pAtacante.getUltAtq() == null || !pAtacante.getUltAtq().equalsIgnoreCase(this.nombre)) {
					tempPre = getPrecision();
				} else {
					tempPre = tempPre/2; 
				}
				
				pAtacante.setUltAtq(this.nombre);
				
				
				if((int) (Math.random() * 100) < tempPre){
					System.out.println(pAtacante.validarNombre() + " se esta protegiendo con " + getNombre());
					pAtacante.setProtegido(true); 
				} else {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + " pero falló...");
					pAtacante.setProtegido(false);
				}// }
			}
		}	
	}