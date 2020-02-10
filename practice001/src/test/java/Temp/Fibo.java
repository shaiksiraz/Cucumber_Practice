package Temp;

class Fibo 
{ 
	// A simple recursive program to find n'th fibonacci number 
    static int fib(int n) 
    { 
    	
    	System.out.println("n value BEFORE is : " + n);
    	
       if (n <= 1) {
    	   System.out.println("n value <=1 : " + n);
          return n; 
       }
       //System.out.println("n value is : " + n);
       return fib(n-1) + fib(n-2); 
      
    } 
      
    // Returns number of ways to reach s'th stair 
    static int countWays(int s) 
    { 
    	
        return fib(s + 1);
    } 
  
  
    /* Driver program to test above function */ 
    public static void main (String args[]) 
    { 
          int s = 4; 
            System.out.println("Number of ways = "+ countWays(s)); 
    } 
}
