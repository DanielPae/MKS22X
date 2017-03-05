import java.lang.Math;
public class Recursion{
    
    public static String name(){
	return "Pae,Daniel";
    }

    public static boolean equalEnough(double a, double b){
	return Math.abs(a - b) < .00000001;
    }
    public static double hSQRT(double n, double guess){
	if(!equalEnough(n ,guess * guess)){
	    return hSQRT(n ,(((n / guess) + guess) / 2));
	}System.out.println("final Guess: " + guess);
	return guess;
    }
    
    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	return hSQRT(n, n/2);
    }

    public static void main(String[] args){
    
    }
	
 
}
