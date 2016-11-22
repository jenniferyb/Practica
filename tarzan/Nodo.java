package tarzan;
public class Nodo implements Comparable<Nodo>{
	private int primero;
	private int segundo;
	public Nodo(int posicion, int peso){
		primero=posicion;
		segundo=peso;
	}
	public int compareTo(Nodo others){
		if(segundo > others.segundo)
			return 1;
		else if(segundo == others.segundo)
			return 0;
		return -1;
	}
	public int getPrimero() {
		return primero;
	}
	public int getSegundo() {
		return segundo;
	}
}
