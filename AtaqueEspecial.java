package Programa;

public class AtaqueEspecial extends AtaqueOfensivo{
	// Si tocais algo de esta clase comentarlo al igual que con las otras por si luego falla
	public AtaqueEspecial(String nombre, int potencia, int precision, int pp) {
		super(nombre, potencia, precision, pp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {
		if (tienePps()) {
			ppActual--;
			if (acierta()) {
				int danio = calcularDanio(pAtacante.getAtaqueEspecial(), pEnemigo.getDefensaEspecial());
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
