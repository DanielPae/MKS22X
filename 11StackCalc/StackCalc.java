import java.util.Stack;
public class StackCalc{

    public static double eval(String equation){
	String[] elements = equation.split(" ");
	Stack<Double> value = new Stack<Double>();
	for(String element : elements){
	    if(isOp(element)){
		value.push(apply(element,value.pop(), value.pop()));
	    }else{
		value.push(Double.parseDouble(element));
	    }
	}return value.pop();
    }
    
    public static double apply(String op, double a, double b){
	if(op.equals("+")){
	    return a + b;
	}else if(op.equals("-")){
	    return b - a;
	}else if(op.equals("*")){
	    return a * b;
        }else if(op.equals("/")){
	    return b / a;
	}else{
	    return b % a;
	}
    }

    public static boolean isOp(String o){
	return o.charAt(0) < '0' || o.charAt(0) > '9';
    }


}
