package ProyectoIntegradorPokemon;

public class AtaqueTipo extends AtaqueOfensivos {
	public AtaqueTipo(String nombre, String tipo, int potencia, int precision, int pp, boolean prioridad,Tipo.Tipos tipoAtaque) {
		super(nombre, tipo, potencia, precision, pp, prioridad,tipoAtaque);
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
				if (this.getTipo().equalsIgnoreCase("fisico")) {
					danio = calcularDanio(pAtacante.getAtaqueFisico(), pEnemigo.getDefensaFisica());
				} else if (this.getTipo().equalsIgnoreCase("especial")) {
					danio = calcularDanio(pAtacante.getAtaqueEspecial(), pEnemigo.getDefensaEspecial());
				}
				
				Tipo tabla = new Tipo();
				double mult = tabla.getMultiplicadorTotal(this.getTipoAtaque(), pAtacante, pEnemigo.getTipo1(), pEnemigo.getTipo2());
				danio = (int)(danio * mult);
				
				pEnemigo.reducirPuntosDeVida(danio);
				if (esCritico()) {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + ". Golpe critico!");
				} else {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre());
				}
				
				if (mult == 0) {
					System.out.println("¡No afecta a " + pEnemigo.validarNombre() + "!");
				}
				else if (mult >= 2) {
					System.out.println("¡Es muy eficaz!");
				}
				else if (mult <= 0.5) {
					System.out.println("No es eficaz");
				}
				else {
					System.out.println("El ataque es neutro");
				}
			} else {
				System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + " pero falló...");
			}
		} else {
			System.out.println(getNombre() + " no tiene PP");
		}
	}

}
