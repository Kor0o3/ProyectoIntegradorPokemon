package ProyectoIntegradorPokemon;

public class AtaqueRetroceso extends Ataque {
	

	public AtaqueRetroceso(String nombre, String tipo, int potencia, int precision, int pp, boolean prioridad) {
		super(nombre, tipo, potencia, precision, pp, prioridad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utilizar(Pokemon pAtacante, Pokemon pEnemigo) {
		int rng = (int) (Math.random() * 100);
		if (tienePps()) {
			if(rng>25) {
				pAtacante.puntosVidaActuales-=pAtacante.puntosVidaActuales/2;
				System.out.println("La salud de "+pAtacante.nombrePokemon+" se ha reducido en base a su vida maxima por su ataque con retroceso!");
			}else if(rng>65) {
				pAtacante.puntosVidaActuales-=this.potencia/3;
				System.out.println("La salud de "+pAtacante.nombrePokemon+" se ha reducido en base al daño causado por su ataque con retroceso!");

			}else {
				pAtacante.puntosVidaActuales-=this.potencia/4;
				System.out.println("La salud de "+pAtacante.nombrePokemon+" se ha reducido en base al daño causado por su ataque con retroceso!");
			}

		} else {
			System.out.println(getNombre() + " No tiene PP");
		}

	}

	

	
	

}
