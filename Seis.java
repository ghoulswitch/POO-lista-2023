package poolistaum;
import java.util.Scanner;

public class Seis {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		float c;
		float f;
		
		System.out.println("Digite o valor em Fahrenheit:");
		f = sc.nextInt();

		
		c = (f-32)*(5F/9F);
		
		System.out.printf("O valor em Celsius é: %.2f", c);
		
		sc.close();
		
	}

}
