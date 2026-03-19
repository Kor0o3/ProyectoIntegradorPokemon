package ProyectoIntegradorPokemon;

public class AtaqueRecuperacion extends AtaquesEstado {

	public AtaqueRecuperacion(String nombre, String categoria, int precision, int pp, boolean prioridad, Tipo.Tipos tipoAtaque) {
		super(nombre, "estado", precision, pp, prioridad, tipoAtaque);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {

		int puntosVida = pAtacante.getPuntosVidaMaximo() / 2;
		int curaTotal = puntosVida + pAtacante.getPuntosVidaActuales();

		if (tienePps()) {
			ppActual--;
			if (acierta()) {
				if ( curaTotal <= pAtacante.getPuntosVidaMaximo()) {
					pAtacante.reducirPuntosDeVida(-puntosVida);
				} else {
					pAtacante.setPuntosVidaActuales(pAtacante.getPuntosVidaMaximo());
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