package homework;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Cale {
	public static double eval(String exp) {
	    StringTokenizer st = new StringTokenizer(exp);
	    Stack<Double> stack = new Stack<Double>();
	    
	    while(st.hasMoreTokens()) {
	        String tok = st.nextToken();
	        if(Infix2Postfix.opType(tok) > 0) {
	        	if (Infix2Postfix.opType(tok) < 6) {
	        		double v1 = stack.pop();
	        		double v2 = stack.pop();
	        		double value = 0;
	            
	        		switch (Infix2Postfix.opType(tok)) {
	                	case 1: //+
	                		value = v2 + v1;
	                		break;
	                	case 2: //-
	                		value = v2 - v1;
	                		break;
	                	case 3: //*
	                		value = v2 * v1;
	                		break;
	                	case 4: // /
	                		value = v2 / v1;
	                		break;
	                	case 5: // ^
	                		value = Math.pow(v2, v1);
	                		break;
	        		}
	            stack.push(value);
	        	}
	        } else {
	            stack.push(Double.parseDouble(tok));
	        }
	    }
	    double result = stack.pop();
	    return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String infix = sc.nextLine();
		String postfix = Infix2Postfix.convert(infix);
		System.out.printf("%s => %s %n", infix, Infix2Postfix.convert(infix));
		double value=Cale.eval(postfix);
		System.out.printf("%s = %.2f\n", infix, value);
	}
}