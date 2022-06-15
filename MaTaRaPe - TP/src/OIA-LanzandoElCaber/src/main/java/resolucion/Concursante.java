package resolucion;

public class Concursante implements Comparable<Concursante> {

	private int id;
	private Tiro[] tiros;
	private boolean descalificado;
	private double distanciaTotal;

	public Concursante(Tiro[] tiros, int id) {
		this.id = id;
		this.tiros = tiros;
		this.descalificado = false;
		this.distanciaTotal = calcularDistancia();
	}

	private double calcularDistancia() {
		double total = 0;

		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i].validarTiro()) {
				total += tiros[i].determinarDistancia();
			} else {
				descalificado = true;
			}
		}

		return total;
	}

	private double varianzaDistancia() {
		double varianza = 0;
		double media = distanciaTotal / tiros.length;

		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i].validarTiro()) {
				varianza += Math.pow(tiros[i].determinarDistancia() - media, 2);
			}
		}

		return varianza / (tiros.length - 1);
	}

	private double varianzaAngulo() {
		double consistencia = 0;
		double media = 0;

		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i].validarTiro()) {
				media += tiros[i].getAngulo();
			}
		}

		media /= tiros.length;

		for (int i = 0; i < tiros.length; i++) {
			if (tiros[i].validarTiro()) {
				consistencia += Math.pow(tiros[i].getAngulo() - media, 2);
			}
		}

		return consistencia / (tiros.length - 1);
	}

	public Consistencia calcularConsistencia() {
		return new Consistencia(varianzaDistancia(), varianzaAngulo(), id);
	}

	public boolean isDescalificado() {
		return descalificado;
	}

	public double getDistanciaTotal() {
		return distanciaTotal;
	}

	@Override
	public int compareTo(Concursante o) {
		return (distanciaTotal < o.distanciaTotal) ? 1 : -1;
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}

}
