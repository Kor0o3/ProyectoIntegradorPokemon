package ProyectoIntegradorPokemon;

public class AtaqueRetroceso extends AtaqueTipo {
	

	public AtaqueRetroceso(String nombre, String tipo, int potencia, int precision, int pp, boolean prioridad) { 
		super(nombre, tipo, potencia, precision, pp, prioridad);
		// TODO Auto-generated constructor stub
	}
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
	//ESTE TIPO DE ATAQUE RESTA VIDA AL POKEMON QUE LO USA, LA VIDA RESTADA SE BASA EN UN RNG
	

	

	
	

}
