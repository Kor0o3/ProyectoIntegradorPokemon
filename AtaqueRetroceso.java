package ProyectoIntegradorPokemon;

public class AtaqueRetroceso extends AtaqueOfensivos {
	public AtaqueRetroceso(String nombre, String categoria, int potencia, int precision, int pp, boolean prioridad,Tipo.Tipos tipoAtaque) { 
		super(nombre, categoria, potencia, precision, pp, prioridad,tipoAtaque);
		// TODO Auto-generated constructor stub
	}
	
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
				
				if (esCritico()) {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + ". Golpe critico!");
				} else {
					System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre());
				}
				
				Tipo tabla = new Tipo();
				double mult = tabla.getMultiplicadorTotal(this.getTipoAtaque(), pAtacante, pEnemigo.getTipo1(), pEnemigo.getTipo2());
				danio = (int)(danio * mult);
				
				pEnemigo.reducirPuntosDeVida(danio);
				
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
				
				int rng = (int)(Math.random() * 100);
				
				if(rng>25) {
						pAtacante.reducirPuntosDeVida(pAtacante.puntosVidaActuales/2);
						System.out.println("La salud de "+pAtacante.nombrePokemon+" se ha reducido por su ataque con retroceso!");
					}else if(rng>65) {
						
						pAtacante.reducirPuntosDeVida(this.potencia/3) ;
						System.out.println("La salud de "+pAtacante.nombrePokemon+" se ha reducido bastante por su ataque con retroceso!");

					}else {
						pAtacante.reducirPuntosDeVida(this.potencia/4); 
						System.out.println("La salud de "+pAtacante.nombrePokemon+" se ha reducido moderadamente por su ataque con retroceso!");
					}
				
			} else {
				System.out.println(pAtacante.validarNombre() + " ha usado " + getNombre() + " pero falló...");
			}
		} else {
			System.out.println(getNombre() + " no tiene PP");
		}
	}
	//ESTE TIPO DE ATAQUE RESTA VIDA AL POKEMON QUE LO USA, LA VIDA RESTADA SE BASA EN UN RNG
	

	

	
	

}