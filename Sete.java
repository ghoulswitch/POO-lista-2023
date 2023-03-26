package poolistaum;
import java.util.Scanner;

public class Sete {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int numero;
		double quadrado;
		
		System.out.println("Insira um valor:");
		numero = sc.nextInt();
		
		quadrado = 2 * numero;
		
		System.out.printf("O quadrado do valor inserido é: %.2f", quadrado);
		
		sc.close();
	}
	
}
