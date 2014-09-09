package fatorial;

public class Fatorial {
	
	public double fatorial(int n){
		
		double fat = 1;
		
		for( int i = 2; i <= n; i++ ){ 
		     fat *= i;
		}
		
		return fat;
	}
}

