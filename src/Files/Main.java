package Files;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	private static int getValidInt(Scanner sc, String message, boolean absoluteValues, Integer... validValues) {

		while (true) {

			try {

				System.out.println(message);
				int value = sc.nextInt();
				sc.nextLine();

				if (Arrays.asList(validValues).contains(value) || validValues.length == 0)
					return absoluteValues ? Math.abs(value) : value;
				else
					System.out.println("Por favor, ingresa un numero valido");

			} catch (Exception ex) {
				System.out.println("Por favor, ingresa un numero valido");
				sc.nextLine();
			}
		}
	}
	
	private static void printArrayValues(String title, Integer... values) {
		
		System.out.println(title);
		if(values != null && values.length > 0) {
			for(Integer value:values) {
				System.out.println(value);
			}
		}else System.out.println("No se encontraron datos a ordenar.");
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sort sort = new Sort(new CompareInt());

		boolean end = false;
		while (!end) {
			String menu = """
					Menu de opciones:

					1. Agregar numeros random al almacenamiento.
					2. Realizar sorts.
					3. Salir.

					""";

			int option = getValidInt(sc, menu, false, 1, 2, 3);

			switch (option) {
			case 1: {

				Random r = new Random();

				int size = getValidInt(sc, "¿Cuantos datos desea que contenga el archivo?", true);

				String data = "";
				for (int i = 0; i < size; i++) {
					data += r.nextInt(10000) + " ";
				}

				try {
					FileController.writeFile(data);
				} catch (IOException e) {

				}

				break;
			}
			case 2: {

				String[] fileContent;
				try {
					fileContent = FileController.readFile();
				} catch (IOException e) {
					System.out.println("Antes de iniciar, por favor seleccione la opcion de agregar numeros random.");
					break;
				}			
				
				ArrayList<Integer> values = new ArrayList<>();

				try {
					for (String row : fileContent) {

						row = row.trim();
						String[] numbers = row.split(" ");

						for (String num : numbers) {
							values.add(Integer.parseInt(num));
						}
					}
					
					Integer[] data = values.toArray(new Integer[values.size()]);
					
					printArrayValues("Datos ordenados con radix:\n", sort.radixSort(data));
					printArrayValues("Datos ordenados con merge:\n", sort.mergeSort(data));
					
					
					
				} catch (NumberFormatException ex) {
					System.out.println("Datos del archivo invalidos.");
				} catch(Exception ex) {
					System.out.println("Ocurrio un error inesperado.");
				}				

				break;
			}
			case 3: {
				System.out.println("Hasta pronto!");
				end = true;
				break;
			}
			}

		}

	}

}
