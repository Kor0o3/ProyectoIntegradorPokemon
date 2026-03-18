package ProyectoIntegradorPokemon;

public abstract class AtaquesEstado extends Ataque{

	public AtaquesEstado(String nombre, String categoria ,int precision, int pp, boolean prioridad,Tipo.Tipos tipoAtaque) {
		super(nombre, "estado", 0, precision, pp, prioridad,tipoAtaque);
		// TODO Auto-generated constructor stub
	}
}
