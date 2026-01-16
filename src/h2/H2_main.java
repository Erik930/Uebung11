package h2;

public class H2_main {
	  
	 public static long fibonacci(int n) {
	 
		 if(n == 1 || n == 2) {
			 return 1;
		 }
			 return fibonacci(n-1) + fibonacci(n-2);
	 }
		 
	 
		 public static long fibonacciCached(int n) {
			 long[] cache = new long[1000];
			 return helper (n, cache);
		 }
		private static long helper(int n, long[] cache) {
			
			 if(n == 1 || n == 2) {
				 return 1;
			 }
			 if (cache[n] != 0) {
				 return cache[n];
			 }
			cache [n] = helper(n-1,cache) + helper(n-2,cache);
			 return cache[n];
			 
		 }
		
		
		public static long fibonacciIterativ (int n) {
			if(n == 1 || n == 2) {
				 return 1;
			 }
			long a = 1;
			long b = 1;
			long result = 0;
			
			for(long i = 3; i <= n; i++) {
				result = a + b;
				a = b;
				b = result;
			}
			return result;
		}
		
		
		
		 public static void benchmark(int n) {
			 long start, end;
			 start = System.nanoTime();
			 fibonacci(n);
			 end = System.nanoTime();
			 System.out.println("Elapsed nanoseconds (fibonacci): " + (end - start));
			 
			 start = System.nanoTime();
			 fibonacciCached(n);
			 end = System.nanoTime();
			 System.out.println("Elapsed nanoseconds (fibonacciCached): " + (end - start));
			 
			 start = System.nanoTime();
			 fibonacciIterativ(n);
			 end = System.nanoTime();
			 System.out.println("Elapsed nanoseconds (fibonacciIterativ): " + (end - start));
			 
			 }
		 
				
		 public static void main(String[] args) { 
		
			 benchmark(40); 
		 }
}
