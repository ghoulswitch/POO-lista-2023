package poolistaum;
import java.util.Scanner;

public class Cinco {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		double c;
		double f;
		
		System.out.println("Digite uma temperatura em Celsius:");
		c = sc.nextDouble();
		
		f = (9 * c + 160) / 5;
		
		System.out.printf("A temperatura em Fahrenheit é: %.2f", f, "ºF");
		
		sc.close();
		
	}

}
