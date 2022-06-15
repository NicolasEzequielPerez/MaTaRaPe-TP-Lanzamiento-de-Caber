package resolucion;

public class Consistencia implements Comparable<Consistencia> {

	private double distancia;
	private double angulo;
	private int id;

	public Consistencia(final double distancia, final double angulo, final int id) {
		this.distancia = distancia;
		this.angulo = angulo;
		this.id = id;
	}

	@Override
	public int compareTo(Consistencia o) {
		return (int) ((distancia - o.distancia) + (angulo - o.angulo));
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
