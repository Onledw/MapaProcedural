package Algor;

import java.util.ArrayList;

public class Testeos {
	 public static void main(String[] args) {
		 // Ejemplo de ArrayList con valores 1 y 2 de manera aleatoria
	        ArrayList<Integer> listaAleatoria = new ArrayList<>();
	        for (int i = 0; i < 5; i++) {
	            int n = (int) (Math.random() * 2 + 1);
	            listaAleatoria.add(n);
	        }

	        // Imprimir la lista generada
	        System.out.println("Lista generada:");
	        for (int i = 0; i < 5; i++) {
	            System.out.println(listaAleatoria.get(i));
	        }

	        // Llamada a la función para encontrar la última posición del 1 de forma incremental
	        int ultimaPosicionDeUno = encontrarUltimaPosicionIncremental(listaAleatoria);

	        // Imprimir el resultado
	        System.out.println("La última posición del 1: " + ultimaPosicionDeUno);
	    }

	    // Función para encontrar la última posición de 1 de forma incremental
	    private static int encontrarUltimaPosicionIncremental(ArrayList<Integer> lista) {
	        int ultimaPosicion = -1;  // Inicializamos con un valor que indica que aún no hemos encontrado el 1

	        for (int i = 0; i < lista.size(); i++) {
	            if (lista.get(i) == 1) {
	                ultimaPosicion = i;  // Actualizamos la última posición cuando encontramos un 1
	            }
	        }

	        return ultimaPosicion;

	    }

}
