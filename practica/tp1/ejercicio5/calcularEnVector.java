package tp1.ejercicio5;
import tp1.ejercicio5.CalcularArreglo;

public class calcularEnVector {
  public static double[] calcularConVectorConReturn(int[] arreglo) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int suma = 0;

    for (int i = 0; i < arreglo.length; i++) {
      if (arreglo[i] < min) {
        min = arreglo[i];
      }
      if (arreglo[i] > max) {
        max = arreglo[i];
      }
      suma += arreglo[i];
    }
    double promedio = suma / arreglo.length;
    return new double[] {
      max,
      min,
      promedio
    };
  }

  public static void calcularConVectorConParametro(int[] arreglo, CalcularArreglo obj) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int suma = 0;

    for (int i = 0; i < arreglo.length; i++) {
      if (arreglo[i] < min) {
        min = arreglo[i];
      }
      if (arreglo[i] > max) {
        max = arreglo[i];
      }
      suma += arreglo[i];
    }
    double promedio = suma / arreglo.length;
    obj.setMin(min);
    obj.setMax(max);
    obj.setPromedio(promedio);
  }

  public static void main(String[] args) {
    int[] arreglo = {10,20,30,40,50};
    double[] resultados = calcularConVectorConReturn(arreglo);
    System.out.println("** Inciso A **");
    System.out.println("Máximo: " + resultados[0]);
    System.out.println("Mínimo: " + resultados[1]);
    System.out.println("Promedio: " + resultados[2]);

    System.out.println("");
    System.out.println("** Inciso B **");
    CalcularArreglo estadisticas = new CalcularArreglo();
    calcularConVectorConParametro(arreglo, estadisticas);
    System.out.println("Máximo: " + estadisticas.getMax());
    System.out.println("Mínimo: " + estadisticas.getMin());
    System.out.println("Promedio: " + estadisticas.getPromedio());
    
    System.out.println("");
    System.out.println("** Inciso C **");
    CalcularArreglo estadisticas2 = new CalcularArreglo(arreglo);
    estadisticas2.procesarArreglo();
    System.out.println("Máximo: " + estadisticas2.getMax());
    System.out.println("Mínimo: " + estadisticas2.getMin());
    System.out.println("Promedio: " + estadisticas2.getPromedio());
  }

}

