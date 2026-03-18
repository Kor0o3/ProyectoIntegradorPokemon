package ProyectoIntegradorPokemon;

public class AtaqueProteccion extends AtaquesEstado {

		static int contador = 0;
	
		public AtaqueProteccion(String nombre, String tipo, int precision, int pp, boolean prioridad) {
			super(nombre, tipo, precision, pp, prioridad);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {

			int puntosDefensa = pAtacante.getDefensaFisica();
			
			if(tienePps()) {
				ppActual--;
				if(acierta()) {
					pAtacante.getDefensaFisica();
					System.out.println(pAtacante.validarNombre() + "uso" + getNombre());
					pAtacante.setDefensaFisica(+puntosDefensa);
					contador++;
					System.out.println("La defensa de" + pAtacante.validarNombre() + "subio");
					
					
				}
				
			}
			
			
		}
	}