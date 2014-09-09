package fibonacci;

public class Fibonacci_Iterativo {
	
	public double fibonacci(int n){
		
		double f1 = 0, f2 = 1, fibo = 0;
		
		for (int x = 1; x <= n; x++) {
			fibo = f1 +f2;
			f2 = f1;
			f1 = fibo;
		}
		
		return fibo;
	}
}
