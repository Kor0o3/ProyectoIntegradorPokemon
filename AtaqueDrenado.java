package Programa;

public class AtaqueDrenado extends AtaqueTipo {
	protected int curacion;

	public AtaqueDrenado(String nombre, String tipo, int curacion, int potencia, int precision, int pp,
			boolean prioridad) {
		super(nombre, tipo, potencia, precision, pp, prioridad);
		this.curacion = curacion;
	}

	public int getCuracion() {
		return curacion;
	}

	@Override
	public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {
		int danio = 0;
		int cura;
		if (tienePps()) {
			ppActual--;
			if (acierta()) {
				if (this.getTipo().equalsIgnoreCase("normal")) {
					danio = calcularDanio(pAtacante.getAtaqueFisico(), pEnemigo.getDefensaFisica());
				} else if (this.getTipo().equalsIgnoreCase("especial")) {
					danio = calcularDanio(pAtacante.getAtaqueEspecial(), pEnemigo.getDefensaEspecial());
				}
				cura = danio / this.getCuracion();
				pEnemigo.reducirPuntosDeVida(danio);
				pAtacante.reducirPuntosDeVida(-cura);
				System.out.println(cura);
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
