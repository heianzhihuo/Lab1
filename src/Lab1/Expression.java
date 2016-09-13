package Lab1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class monomial {
	public int coefficient = 1;
	HashMap<String, Integer> mon = new HashMap<String, Integer>();

	public monomial(String str) {
		// TODO Auto-generated constructor stub
		String[] mons = str.split("\\*");
		for (String s : mons) {
			if (isNumeric(s)) {
				coefficient *= Integer.parseInt(s);
				System.out.println(coefficient);
			} else{
				String [] var = s.split("\\^");
				int exp = var.length==1?1:Integer.parseInt(var[1]);
				if(mon.get(var[0])==null){
					mon.put(var[0],exp);
				} else{
					mon.put(var[0], mon.get(var[0])+exp);
				}
			}
		}
	}
	
	public String getMonomial(){
		String str = new String();
		return str;
	}

	public boolean simplify(String str) {

		// String[]
		// System.out.println("s");
		return false;
		// return str;
	}

	public boolean derivative(String str) {
		System.out.println("d");
		return false;
	}

	public boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}

public class Expression {

	private ArrayList<monomial> polynomial = new ArrayList<monomial>();

	public String expression(String str) {
		str = str.replaceAll("\\s*", "");
		if (!isValid(str)) {
			return "Error!";
		}
		String[] mons = str.split("\\+");
		for (String s : mons) {
			String[] s2 = s.split("\\-");
			polynomial.add(new monomial(s2[0]));
			for(int i=1;i<s2.length;i++){
				monomial temp = new monomial(s2[i]);
				temp.coefficient = -1;
				polynomial.add(temp);
			}
		}
		return getPolynomial();
	}

	public String simplify(String str) {
		System.out.println("s");
		return str;
	}

	public String derivative(String str) {
		System.out.println("d");
		return str;
	}
	
	private String getPolynomial(){
		String str = new String();
		return str;
	}

	private boolean isMatch(String pattern, String s) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(s);
		boolean flag = m.matches();
		return flag;
	}

	private boolean isFind(String pattern, String s) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(s);
		boolean flag = m.find();
		return flag;
	}

	public boolean isValid(String str) {
		String partern1 = "[a-zA-Z0-9\\+\\-\\*\\^]{0,}";// is consist of valid
		String partern2 = "[\\+\\-\\*\\^]{2,}";// is there two or more operation
		String partern3 = "^[a-zA-Z0-9]";// start with char or number
		String partern4 = "[a-zA-Z0-9]$";// end with char or number
		String partern5 = "[0-9][a-zA-Z]";// char can not be after number
		boolean flag = isMatch(partern1, str) && !isFind(partern2, str) && isFind(partern3, str)
				&& isFind(partern4, str) && !isFind(partern5, str);
		/*
		 * System.out.println(isMatch(partern1,str));
		 * System.out.println(isFind(partern2,str));
		 * System.out.println(isFind(partern3,str));
		 * System.out.println(isFind(partern4,str));
		 * System.out.println(isFind(partern5,str));
		 */
		return flag;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Expression person = new Expression();
		String str;
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.print('>');
			str = s.nextLine();
			if (!str.startsWith("!"))
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
