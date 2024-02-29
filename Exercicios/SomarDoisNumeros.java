import java.util.Scanner;

public class SomarDoisNumeros {
	public static void main(String[] args) {
		//variaveis e scanner
		Scanner sc = new Scanner(System.in);
		int n1, n2, soma;
		
		//entradas
		System.out.println("Digite um numero: ");
		n1 = sc.nextInt();
		System.out.println("Digite outro numero: ");
		n2 = sc.nextInt();
		
		//soma
		soma = n1+n2;
		
		//saida
		System.out.println(n1 + " + " + n2 + " = " + soma);
	}
}
