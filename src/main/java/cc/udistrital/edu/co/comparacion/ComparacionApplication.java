package cc.udistrital.edu.co.comparacion;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;

@SpringBootApplication
public class ComparacionApplication {

	public static Comparable[] burbuja(Comparable[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - (i + 1); j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					Comparable aux = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = aux;
				}
			}
		}
		return arr;
	}

	public static Comparable[] seleccion(Comparable arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			Comparable menor = arr[i];
			int posMenor = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo(menor) < 0) {
					posMenor = j;
					menor = arr[j];
				}
			}
			Comparable aux = arr[i];
			arr[i] = menor;
			arr[posMenor] = aux;
		}
		return arr;
	}

	public static void main(String[] args) {
		Comparacion arreglo[] = new Comparacion[100000];
		Comparacion arreglo2[];
		for (int i = 0; i < 100000; i++)
			arreglo[i] = new Comparacion((int) (Math.random() * 1000));
		arreglo2 = arreglo.clone();
		long milisecondsBurbuja = System.currentTimeMillis();
		arreglo = (Comparacion[]) burbuja(arreglo);
		milisecondsBurbuja = System.currentTimeMillis() - milisecondsBurbuja;

		long milisecondsSeleccion = System.currentTimeMillis();
		arreglo2 = (Comparacion[]) seleccion(arreglo2);
		milisecondsSeleccion = System.currentTimeMillis() - milisecondsSeleccion;
		System.out.println(milisecondsBurbuja);
		System.out.println(milisecondsSeleccion);
		// for (int i = 0; i < 100000; i++)
		// System.out.println(arreglo[i].getValor());
		SpringApplication.run(ComparacionApplication.class, args);
	}

}
