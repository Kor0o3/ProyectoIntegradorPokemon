package ProyectoIntegradorPokemon;

public class AtaqueRecuperacion extends AtaquesEstado {

	public AtaqueRecuperacion(String nombre, String tipo, int precision, int pp, boolean prioridad) {
		super(nombre, "estado", precision, pp, prioridad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {

		int puntosVida = pAtacante.getPuntosVidaMaximo() / 2;
		int curaTotal = puntosVida + pAtacante.getPuntosVidaActuales();

		if (tienePps()) {
			ppActual--;
			if (acierta()) {
				if ( curaTotal < pAtacante.getPuntosVidaMaximo()) {
					pAtacante.reducirPuntosDeVida(-puntosVida);
				}
				System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre());
			} else {
				System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + " pero falló...");
			}
		} else {
			System.out.println(getNombre() + " no tiene PP");
		}
	}

}