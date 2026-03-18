package ProyectoIntegradorPokemon;

public abstract class AtaquesEstado extends Ataque{

	public AtaquesEstado(String nombre, String tipo ,int precision, int pp, boolean prioridad,Tipo.Tipos tipoAtaque) {
		super(nombre, "estado", 0, precision, pp, prioridad,tipoAtaque);
		// TODO Auto-generated constructor stub
	}
}
