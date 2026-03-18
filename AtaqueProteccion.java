package ProyectoIntegradorPokemon;

public class AtaqueProteccion extends AtaquesEstado {

		static int contador = 0;
	
		public AtaqueProteccion(String nombre, String tipo, int precision, int pp, boolean prioridad,Tipo.Tipos tipoAtaque) {
			super(nombre, tipo, precision, pp, prioridad, tipoAtaque);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {
			
			if(tienePps()) {
				ppActual--;
				if(acierta()) {
					System.out.println(pAtacante.validarNombre() + " se esta protegiendo con " + getNombre());
					pAtacante.setProtegido(true);
					contador++;
				} else {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + " pero falló...");
					pAtacante.setProtegido(false);
					contador = 0;
					
				}
			}
				
		}	
	}