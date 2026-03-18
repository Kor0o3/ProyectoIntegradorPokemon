package ProyectoIntegradorPokemon;

public class AtaqueDrenado extends AtaqueTipo {
	protected int curacion;

	public AtaqueDrenado(String nombre, String tipo, int curacion, int potencia, int precision, int pp,
			boolean prioridad,Tipo.Tipos tipoAtaque) {
		super(nombre, tipo, potencia, precision, pp, prioridad,tipoAtaque);
		this.curacion = curacion;
	}

	public int getCuracion() {
		return curacion;
	}

	@Override
	public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {
		int danio = 0;
		if (tienePps()) {
			ppActual--;
			if (acierta()) {
				if (this.getTipo().equalsIgnoreCase("fisico")) {
					danio = calcularDanio(pAtacante.getAtaqueFisico(), pEnemigo.getDefensaFisica());
				} else if (this.getTipo().equalsIgnoreCase("especial")) {
					danio = calcularDanio(pAtacante.getAtaqueEspecial(), pEnemigo.getDefensaEspecial());
				}
				int cura = danio / this.getCuracion();
				int curaTotal = cura + pAtacante.getPuntosVidaActuales();
				pEnemigo.reducirPuntosDeVida(danio);

				if (curaTotal <= pAtacante.getPuntosVidaMaximo()) {
					pAtacante.reducirPuntosDeVida(-cura);
				} else {
					pAtacante.setPuntosVidaActuales(pAtacante.getPuntosVidaMaximo());
				}
				

				if (esCritico()) {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + ". Golpe critico!");
				} else {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre());
				}
			} else {
				System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + " pero falló...");
			}
		} else {
			System.out.println(getNombre() + " no tiene PP");
		}

	}

}
