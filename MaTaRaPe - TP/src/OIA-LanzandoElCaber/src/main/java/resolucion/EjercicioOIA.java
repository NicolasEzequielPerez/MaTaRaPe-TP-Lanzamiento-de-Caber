package resolucion;

public class EjercicioOIA {

	Podio podio;

	public static void main(String[] args) {
		EjercicioOIA ejercicio = new EjercicioOIA();

		ejercicio.leer("src/main/java/resolucion/in/07.in");
		ejercicio.resolver();
		ejercicio.escribir("src/main/java/resolucion/out/07.out");
	}

	public void leer(String path) {
		podio = Lector.leer(path);
	}

	public void escribir(String path) {
		Escritor.escribir(path, podio);
	}

	public void resolver() {
		podio.resolver();
	}
}
