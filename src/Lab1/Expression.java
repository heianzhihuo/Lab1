package Lab1;

import java.util.HashMap;
import java.util.Scanner;

class monomial {
	public int coefficient;
	HashMap<String,Integer> mon = new HashMap<String,Integer>();
	
	public monomial(){
		
	}
	
}

public class Expression extends monomial {
	
	
	
	
	public String expression (String str){
		System.out.println("e");
		return str;
		
	}
	
	public String simplify(String str){
		System.out.println("s");
		return str;
	}
	
	public String derivative(String str){
		System.out.println("d");
		return str;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Expression person = new Expression();
		String str;
		Scanner s = new Scanner(System.in);
		while(true){
			System.out.print('>');
			str = s.nextLine();
			if (! str.startsWith("!"))
				System.out.println(person.expression(str));
			else if (str.startsWith("!simplify"))
				System.out.println(person.simplify(str));
			else if (str.startsWith("!d/d"))
				System.out.println(person.derivative(str));
			else if (str.equalsIgnoreCase("!exit"))
				break;
			else
				System.out.println("Command Error!");
		}
	}
}
