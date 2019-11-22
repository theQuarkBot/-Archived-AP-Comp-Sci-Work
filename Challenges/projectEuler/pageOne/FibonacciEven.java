package pageOne;

public class FibonacciEven {

	public static void main(String[] args) {
		int n1 = 0, n2 = 1, n3 = 0, sum = 0, lim = 4000000;    
	
		for(; n3 < lim;) {
			n3 = n1 + n2;
			if (n3 % 2 == 0)
				sum += n3;
			n1 = n2;
			n2 = n3;
		}   
		
		System.out.println(sum);
	}
}
