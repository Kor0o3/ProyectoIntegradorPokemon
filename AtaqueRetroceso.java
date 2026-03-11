package Programa;

public class AtaqueRetroceso extends Ataque {
	

	public AtaqueRetroceso(String nombre, String tipo, int potencia, int precision, int pp, boolean prioridad) { //ESTE TIPO DE ATAQUE RESTA VIDA AL POKEMON QUE LO USA, LA VIDA RESTADA SE BASA EN UN RNG
		super(nombre, tipo, potencia, precision, pp, prioridad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {
		int rng = (int) (Math.random() * 100);
		if (tienePps()) {
			if(rng>25) {
				pEnemigo.reducirPuntosDeVida(this.potencia);
				pAtacante.puntosVidaActuales-=pAtacante.puntosVidaActuales/2;
				System.out.println("La salud de "+pAtacante.nombrePokemon+" se ha reducido por su ataque con retroceso!");
			}else if(rng>65) {
				pEnemigo.reducirPuntosDeVida(this.potencia);
				pAtacante.puntosVidaActuales-=this.potencia/3;
				System.out.println("La salud de "+pAtacante.nombrePokemon+" se ha reducido por su ataque con retroceso!");

			}else {
				pEnemigo.reducirPuntosDeVida(this.potencia);
				pAtacante.puntosVidaActuales-=this.potencia/4;
				System.out.println("La salud de "+pAtacante.nombrePokemon+" se ha reducido por su ataque con retroceso!");
			}

		} else {
			System.out.println(getNombre() + " No tiene PP");
		}

	}

	

	
	

}
