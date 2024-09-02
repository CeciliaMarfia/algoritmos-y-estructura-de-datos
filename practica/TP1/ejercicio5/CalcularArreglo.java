package tp1.ejercicio5;

public class CalcularArreglo {
	  private int max;
    private int min;
    private int suma;
    private double promedio;
    private int[] arreglo;
    
    public CalcularArreglo() {
    	
    }
    
    public CalcularArreglo(int[] arreglo) {
      this.arreglo = arreglo;
		  this.max = Integer.MIN_VALUE;
		  this.min = Integer.MAX_VALUE;
		  this.suma = 0;
	  }
    
    public int getMax() {
      return this.max;
    }
    public void setMax(int max) {
      this.max = max;
    }
    public int getMin() {
      return this.min;
    }
    public void setMin(int min) {
      this.min = min;
    }
    public double getPromedio() {
      return this.promedio;
    }
    public void setPromedio(double promedio) {
      this.promedio = promedio;
    }
	
    private void calcularMax(int valor) {
        if (valor > this.max) {
            this.max = valor;
        }
    }

    private void calcularMin(int valor) {
        if (valor < this.min) {
            this.min = valor;
        }
    }

    
    private void sumarValor(int valor) {
        this.suma += valor;
    }


    private void calcularPromedio() {
      this.promedio = (double) this.suma / this.arreglo.length;
    }

    public void procesarArreglo() {
      for (int i : this.arreglo) {
        calcularMax(i);
        calcularMin(i);
        sumarValor(i);
      }
      calcularPromedio();
    }
}