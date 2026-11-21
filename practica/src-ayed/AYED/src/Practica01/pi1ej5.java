package Practica01;
public class pi1ej5 {

	public static void main(String[] args) {
		
        int[] vector = {6, 10,22, 31, 15};
        System.out.println("-->INCISO A:");
        System.out.println("MAX,MIN Y PROM:");
        double[] resultados = maxMinYProm(vector);
        for (int i=0; i< resultados.length; i++) {
        	System.out.print(resultados[i]+"|");
        }
        System.out.println(" ");
        System.out.println("-->INCISO B:");
        Calculadora calcu = new Calculadora(vector);
        System.out.println("*MÁXIMO: "+ calcu.getMaximo());
        System.out.println("*MÍNIMO: "+ calcu.getMinimo());
        System.out.println("*PROMEDIO: "+ calcu.getPromedio());
	}

	public static double [] maxMinYProm(int [] vector){
		int maximo = vector[0];
		int minimo = vector[0];
		int suma = 0;
		for(int i=0; i < vector.length; i++) {
			suma += vector[i];
			
			if (vector[i] > maximo) {
	            maximo = vector[i];
			}
	        if (vector[i] < minimo) {
	            minimo = vector[i];
	        
	        }
		}
		double promedio = (double) suma/vector.length;
		// Devolver los resultados en un arreglo
        double[] resultados = {maximo, minimo, promedio};
        return resultados;
}
	}
