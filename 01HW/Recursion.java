import java.lang.Math;
public class Recursion{
    
    public static String name(){
	return "Pae,Daniel";
    }

    public static boolean equalEnough(double a, double b){
	return Math.abs(a - b) < a * .00000000001 && Math.abs(a - b) < b * .00000000001;
    }
    public static double hSQRT(double n, double guess){
	if(equalEnough(n,guess * guess)){
	    return guess;
	}else{
	    return hSQRT(n, ((n / guess) + guess) / 2);
	}
    }
    
    public static double sqrt(double n){
	return hSQRT(n, n/2);
    }

    public static void main(String[] args){
	System.out.println(sqrt(25));
	
    }
}
