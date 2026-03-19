package ProyectoIntegradorPokemon;

public class AtaqueDrenado extends AtaqueCategoria {
	protected int curacion;

	public AtaqueDrenado(String nombre, String categoria, int curacion, int potencia, int precision, int pp,
			boolean prioridad,Tipo.Tipos tipoAtaque) {
		super(nombre, categoria, potencia, precision, pp, prioridad,tipoAtaque);
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
				if (this.getCategoria().equalsIgnoreCase("fisico")) {
					danio = calcularDanio(pAtacante.getAtaqueFisico(), pEnemigo.getDefensaFisica());
				} else if (this.getCategoria().equalsIgnoreCase("especial")) {
					danio = calcularDanio(pAtacante.getAtaqueEspecial(), pEnemigo.getDefensaEspecial());
				}
			
				Tipo tabla = new Tipo();
				double mult = tabla.getMultiplicadorTotal(this.getTipoAtaque(), pAtacante, pEnemigo.getTipo1(), pEnemigo.getTipo2());
				danio = (int)(danio * mult);
				
				pEnemigo.reducirPuntosDeVida(danio);

				int cura = danio / this.getCuracion();
				int curaTotal = cura + pAtacante.getPuntosVidaActuales();
				
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
