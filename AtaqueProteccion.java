package ProyectoIntegradorPokemon;

public class AtaqueProteccion extends AtaquesEstado {

		public AtaqueProteccion(String nombre, String tipo, int precision, int pp, boolean prioridad) {
			super(nombre, tipo, precision, pp, prioridad);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {

			int puntosDefensa = pAtacante.getDefensaFisica() * rng;
			
			if (tienePps()) {
				ppActual--;
				if (acierta()) {
					pAtacante.setDefensaFisica(+puntosDefensa);
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre());
				} else {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + " pero falló...");
				}
			} else {
				System.out.println(getNombre() + " no tiene PP");
			}
		}

	}