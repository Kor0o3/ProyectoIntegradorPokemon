package Programa;

public class AtaqueTipo extends AtaqueOfensivos {
	public AtaqueTipo(String nombre, String tipo, int potencia, int precision, int pp, boolean prioridad) {
		super(nombre, tipo, potencia, precision, pp, prioridad);
		// TODO Auto-generated constructor stub
	}

	// Si tocais algo de esta clase comentarlo al igual que con las otras por si
	// luego falla

	@Override
	public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {
		int danio = 0;
		if (tienePps()) {
			ppActual--;
			if (acierta()) {
				if (this.getTipo().equalsIgnoreCase("normal")) {
					danio = calcularDanio(pAtacante.getAtaqueFisico(), pEnemigo.getDefensaFisica());
				} else if (this.getTipo().equalsIgnoreCase("especial")) {
					danio = calcularDanio(pAtacante.getAtaqueEspecial(), pEnemigo.getDefensaEspecial());
				}
				pEnemigo.reducirPuntosDeVida(danio);
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
