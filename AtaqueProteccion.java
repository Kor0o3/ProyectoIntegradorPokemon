package ProyectoIntegradorPokemon;

public class AtaqueProteccion extends AtaquesEstado {

		static int contador = 0;
	
		public AtaqueProteccion(String nombre, String tipo, int precision, int pp, boolean prioridad,Tipo.Tipos tipoAtaque) {
			super(nombre, tipo, precision, pp, prioridad, tipoAtaque);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {
			
			int precision = 100;
			int precisionred = precision/2;
			
			
			if(tienePps()) {
				ppActual--;
				if(acierta()) {
					System.out.println(pAtacante.validarNombre() + "ha usado " + getNombre());
					System.out.println("La precision de " + pAtacante.validarNombre() + " es de " + precisionred);
					contador++;
				} else {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + " pero falló...");
					
				}
			}
				
		}	
	}