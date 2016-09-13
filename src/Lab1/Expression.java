package Lab1;

import java.util.*;
/*import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;*/
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
				// System.out.println(coefficient);
			} else {
				String[] var = s.split("\\^");
				int exp = var.length == 1 ? 1 : Integer.parseInt(var[1]);
				if (mon.get(var[0]) == null) {
					mon.put(var[0], exp);
				} else {
					mon.put(var[0], mon.get(var[0]) + exp);
				}
			}
		}
	}

	public String toString() {
		String str = new String();
		Iterator iter = mon.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			if (str.length() == 0) {
				str = str + entry.getKey().toString();
			} else {
				str = str + "*" + entry.getKey().toString();
			}
			if (entry.getValue().toString().compareTo("1") != 0) {
				str = str + "^" + entry.getValue().toString();
			}
		}
		if(str.length()==0){
			str = String.valueOf(this.coefficient);
		} else {
			if (coefficient == -1) {
				str = "-" + str;
			}
			else if (coefficient != 1){
				str = String.valueOf(this.coefficient) + "*" + str;
			}
				
		}
			
	/*	if (coefficient == -1) {
			if(str.length()==0){
				str = "-1" + str;
			}else
				str = "-" + str;
		} else if (coefficient != 1) {
			if(str.length()==0)
				str = String.valueOf(this.coefficient) + str;
			else
				str = String.valueOf(this.coefficient) + "*" + str;
		}*/
		return str;
	}

	public boolean simplify(HashMap<String,Integer>vals) {
		Set<String> tmps = new HashSet<String>(); 
		tmps.addAll(vals.keySet());
		tmps.retainAll(mon.keySet());
		for (String s: tmps){
			coefficient *= Math.pow(vals.get(s),mon.get(s));
			mon.remove(s);
		}
		//coefficient *= 
		return false;
		// return str;
	}

	public boolean derivative(String str) {
		System.out.println("d");
		return false;
	}

	// judge two monomial are similar items or not
	public boolean isSimilarItem(monomial m) {
		if (mon.size() != m.mon.size()) {
			return false;
		}
		for (String key : m.mon.keySet()) {
			if (mon.containsKey(key)) {
				int tmp1 = mon.get(key);
				int tmp2 = m.mon.get(key);
				if (tmp1 != tmp2) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}

public class Expression {
	HashSet<String> varSet=new HashSet<String>();
	private ArrayList<monomial> polynomial;

	public String expression(String str) {
		polynomial = new ArrayList<monomial>();
		str = str.replaceAll("\\s*", "");
		if (!isValid(str)) {
			return "Error!";
		}
		String[] mons = str.split("\\+");
		for (String s : mons) {
			String[] s2 = s.split("\\-");
			monomial tmp = new monomial(s2[0]);
			varSet.addAll(tmp.mon.keySet());
			polynomial.add(new monomial(s2[0]));
			for (int i = 1; i < s2.length; i++) {
				monomial temp = new monomial(s2[i]);
				temp.coefficient = -temp.coefficient;
				polynomial.add(temp);
				varSet.addAll(temp.mon.keySet());
			}
		}
		collect();
		return toString();
	}

	public String simplify(String str) {
		/*try {
			Expression New = (Expression)this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//New = (Expression)this.clone();
		
		HashMap<String,Integer> vals=new HashMap<String,Integer>();
		//System.out.println(str);
		str=str.replace("!simplify","");
		//System.out.println(str);
		str=str.replaceAll("\\s*", "");
		//System.out.println(str);
		String[] vars=str.split(",");
		for(String s:vars){
			String [] tmp=s.split("=");
			if(!varSet.contains(tmp[0]))
				return "Error!";
			else{
				vals.put(tmp[0],Integer.parseInt(tmp[1]));
			}
		}
		for (int i = 0; i < polynomial.size(); i++) {
			polynomial.get(i).simplify(vals);
		}
		collect();
		return toString();
	}

	// combine similar terms
	private void collect() {
		for (int i = 0; i < polynomial.size(); i++) {
			for (int j = i + 1; j < polynomial.size(); j++) {
				monomial tmp1 = polynomial.get(i);
				monomial tmp2 = polynomial.get(j);
				if (tmp1.isSimilarItem(tmp2)) {
					tmp1.coefficient += tmp2.coefficient;
					polynomial.remove(j);
					if (tmp1.coefficient == 0) {
						polynomial.remove(i);
					}
				}
			}
		}
	}

	public String derivative(String str) {
		System.out.println("d");
		return str;
	}

	public String toString() {
		if (polynomial.size() == 0) {
			return "0";
		}
		String str = polynomial.get(0).toString();
		for (int i = 1; i < polynomial.size(); i++) {
			if (polynomial.get(i).coefficient < 0) {
				str = str + polynomial.get(i).toString();
			} else {
				str = str + "+" + polynomial.get(i).toString();
			}
		}
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
		;
		boolean flag = isMatch(partern1, str) && !isFind(partern2, str) && isFind(partern3, str)
				&& isFind(partern4, str) && !isFind(partern5, str);

		
		 /*System.out.println(isMatch(partern1,str));
		 System.out.println(isFind(partern2,str));
		 System.out.println(isFind(partern3,str));
		 System.out.println(isFind(partern4,str));
		 System.out.println(isFind(partern5,str));*/
		 

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
