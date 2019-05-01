package ads;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		int a = 0, b = 0, c = 0;
		Scanner entrada = new Scanner(System.in);
		do {
			try {
				System.out.println("Ingrese 1er valor: ");
				a = entrada.nextInt();
			} catch (Exception e) {
				System.out.println("No corresponde con un nùmero entero");
				entrada = new Scanner(System.in);
			}
		} while (a <= 0);
		do {
			try {
				System.out.println("Ingrese 2do valor: ");
				b = entrada.nextInt();
			} catch (Exception e) {
				System.out.println("No corresponde con un nùmero entero");
				entrada = new Scanner(System.in);
			}
		} while (b <= 0);
		do {
			try {
				System.out.println("Ingrese 3er valor: ");
				c = entrada.nextInt();
			} catch (Exception e) {
				System.out.println("No corresponde con un nùmero entero");
				entrada = new Scanner(System.in);
			}
		} while (c <= 0);
		entrada.close();
		if(App.esTriangulo(a, b, c))
			App.tipoDeTriangulo(a, b, c);
		return;
	}

	public static boolean esTriangulo(int a, int b, int c) {
		if (a + b <= c || a + c <= b || b + c <= a) {
			System.out.println("No es triangulo");
			return false;
		}
		return true;
	}

	public static void tipoDeTriangulo(int a, int b, int c) {
		if (a == b && b == c) {
			System.out.println("Es un triangulo equilatero");
		} else if (a != b && b != c && a != c) {
			System.out.println("Es un triangulo escaleno");
		} else {
			System.out.println("Es un triangulo isoceles");
		}
	}
}
