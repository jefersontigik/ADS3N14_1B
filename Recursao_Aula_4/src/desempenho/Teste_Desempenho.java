package desempenho;

import fatorial.Fatorial;
import fibonacci.Fibonacci;
import fibonacci.Fibonacci_Iterativo;

public class Teste_Desempenho {

	public static void main(String[] args) {
		
		Fatorial fat = new Fatorial();
		Fibonacci fibo = new Fibonacci();
		Fibonacci_Iterativo fibo_It = new Fibonacci_Iterativo();

		long st = System.currentTimeMillis();
//		double r = fat.fatorial(75);
		double r = fibo.fibo(50);
//		double r = fibo_It.fibonacci(60);
		long et = System.currentTimeMillis();
		
//		System.out.println("Fatorial: " + (et - st));
		System.out.println("Fibonacci: " + (et - st));
//		System.out.println("Fibonacci Interativo: " + (et - st));

	}

}
