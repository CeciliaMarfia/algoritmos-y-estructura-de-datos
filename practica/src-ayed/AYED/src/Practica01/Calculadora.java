package Practica01;

public class Calculadora {
	private int maximo;
	private int minimo;
	private double promedio;
	
	//CONSTRUCTOR
	public Calculadora(int[] vector) {
		calcular(vector);
	}
	
	private void calcular (int [] vector) {
		double suma = 0;
		this.minimo = vector[0];
		this.maximo = vector[0];
		this.promedio = 0;
		for (int i = 0; i < vector.length; i++) {
			suma += vector[i];
			if (vector[i] < minimo) {
				this.minimo = vector[i];
			}
			if (vector[i] > maximo) {
				this.maximo = vector[i];
			}
		}
		this.promedio = (double) (suma/vector.length);
	}
	
	public int getMinimo() {
		return minimo;
	}

	public int getMaximo() {
		return maximo;
	}

	public double getPromedio() {
		return promedio;
	}
}