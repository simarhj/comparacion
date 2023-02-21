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

	public static Comparable[] mezcla(Comparable arr[]) {
		if (arr.length > 1) {
			int i = 0;
			int m = arr.length / 2;
			int j = arr.length;
			Comparable arrIzq[] = Arrays.copyOfRange(arr, i, m);
			Comparable arrDer[] = Arrays.copyOfRange(arr, m, j);
			arrIzq = mezcla(arrIzq);
			arrDer = mezcla(arrDer);
			int pi = 0;
			int pd = 0;
			for (int x = 0; x < arr.length; x++) {
				if (pi < arrIzq.length) {
					if (pd < arrDer.length) {
						if (arrIzq[pi].compareTo(arrDer[pd]) < 0) {
							arr[x] = arrIzq[pi++];
						} else {
							arr[x] = arrDer[pd++];
						}
					} else {
						arr[x] = arrIzq[pi++];
					}
				} else {
					arr[x] = arrDer[pd++];
				}
			}
		}
		return arr;
	}

	public static void quickSort(Comparable[] arr, int ix, int fx) {
		if (ix == fx) {
			return;
		}

		Comparable pivote = arr[fx];
		int i = ix;
		int j = fx - 1;

		while (i != j) {
			while (arr[i].compareTo(pivote) <= 0 && i < j) {
				i++;
			}
			while (arr[j].compareTo(pivote) > 0 && i < j) {
				j--;
			}
			if (i != j && i < j) {
				Comparable aux = arr[i];
				arr[i] = arr[j];
				arr[j] = aux;
			}
		}
		if (arr[i].compareTo(pivote) <= 0) {
			i++;
			j++;
		}
		if (i != fx) {
			Comparable aux = arr[i];
			arr[i] = arr[fx];
			arr[fx] = aux;
		}
		quickSort(arr, ix, Math.max(i - 1, ix));
		quickSort(arr, Math.min(j + 1, fx), fx);
	}

	public static void main(String[] args) {
		Comparacion arreglo[] = new Comparacion[100000];
		Comparacion arreglo2[], arreglo3[], arreglo4[];
		for (int i = 0; i < 100000; i++)
			arreglo[i] = new Comparacion((int) (Math.random() * 100000));
		arreglo2 = arreglo.clone();
		arreglo3 = arreglo.clone();
		arreglo4 = arreglo.clone();
		long milisecondsBurbuja = System.currentTimeMillis();
		arreglo = (Comparacion[]) burbuja(arreglo);
		milisecondsBurbuja = System.currentTimeMillis() - milisecondsBurbuja;

		long milisecondsSeleccion = System.currentTimeMillis();
		arreglo2 = (Comparacion[]) seleccion(arreglo2);
		milisecondsSeleccion = System.currentTimeMillis() - milisecondsSeleccion;

		long milisecondsMezcla = System.currentTimeMillis();
		arreglo3 = (Comparacion[]) mezcla(arreglo3);
		milisecondsMezcla = System.currentTimeMillis() - milisecondsMezcla;

		long milisecondsQuick = System.currentTimeMillis();
		quickSort(arreglo4, 0, arreglo4.length - 1);
		milisecondsQuick = System.currentTimeMillis() - milisecondsQuick;

		System.out.println(milisecondsBurbuja);
		System.out.println(milisecondsSeleccion);
		System.out.println(milisecondsMezcla);
		System.out.println(milisecondsQuick);
		// for (int i = 0; i < 100000; i++)
		// System.out.println(arreglo[i].getValor());
		SpringApplication.run(ComparacionApplication.class, args);
	}

}
