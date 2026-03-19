package ProyectoIntegradorPokemon;

public class AtaqueProteccion extends AtaquesEstado {
		static int contador = 0;
		private int tempPre;
		
		public AtaqueProteccion(String nombre, String tipo, int precision, int pp, boolean prioridad, Tipo.Tipos tipoAtaque) {
			super(nombre, tipo, precision, pp, prioridad, tipoAtaque);
			this.tempPre = precision;
		}
		
		@Override
		public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {
			if(tienePps()) {
				ppActual--;
				
				// Hecho por Raul {
				if(nombreUltimoAtq != null && !nombreUltimoAtq.equalsIgnoreCase(this.nombre)) {
					tempPre = precision;
				} else {
					nombreUltimoAtq = this.nombre;
				}
				
				
				if(rng < tempPre){
					System.out.println(pAtacante.validarNombre() + " se esta protegiendo con " + getNombre());
					pAtacante.setProtegido(true); 
				} else {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + " pero falló...");
					pAtacante.setProtegido(false);
				}
				
				tempPre = tempPre/2; // }añadido por raul
				contador++;
			}
				
		}	
	}