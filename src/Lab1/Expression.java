package Lab1;

import java.util.*;
/*import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/***/
class Monomial {
    /***/
    public int coefficient = 1;
    /***/
    HashMap<String, Integer> mon = new HashMap<String, Integer>();
    /***/
    Monomial(String str) {
		// TODO Auto-generated constructor stub
		final String[] mons = str.split("\\*");
		for (final String s : mons) {
			if (isNumeric(s)) {
				coefficient *= Integer.parseInt(s);
				// System.out.println(coefficient);
			} else {
				final String[] var = s.split("\\^");
				//int exp = var.length == 1 ? 1 : Integer.parseInt(var[1]);
				int exp = 1;
				for (int i = 1; i < var.length; i++){
					exp *= Integer.parseInt(var[i]);
				}
				if (mon.get(var[0]) == null) {
					mon.put(var[0], exp);
				} else {
					mon.put(var[0], mon.get(var[0]) + exp);
				}
			}
		}
	}
    /***/
	public String toString() {
		StringBuffer str = new StringBuffer();
		final Iterator iter = mon.entrySet().iterator();
		while (iter.hasNext()) {
			final Map.Entry entry = (Map.Entry) iter.next();
			if (str.length() == 0) {
				//str = str + entry.getKey().toString();
				str.append(entry.getKey().toString());
			} else {
				//str = str + "*" + entry.getKey().toString();
				str.append("*");
				str.append(entry.getKey().toString());
			}
			if (entry.getValue().toString().compareTo("1") != 0) {
				//str = str + "^" + entry.getValue().toString();
				str.append("^");
				str.append(entry.getValue().toString());
			}
		}
		if (str.length() == 0){
			//str = String.valueOf(this.coefficient);
			str.append(this.coefficient);
		} else {
			if (coefficient == -1) {
				//str = "-" + str;
				str.insert(0, "-");
			}
			else if (coefficient != 1){
				//str = this.coefficient + "*" + str;
				str.insert(0, "*");
				str.insert(0, this.coefficient);

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
		return str.toString();
	}
    /***/
	public void simplify(HashMap<String,Integer>vals) {
		//dan xiang shi de ji suan
		final Set<String> tmps = new HashSet<String>();
		tmps.addAll(vals.keySet());
		tmps.retainAll(mon.keySet());
		for (final String s: tmps){
			coefficient *= Math.pow(vals.get(s), mon.get(s));
			mon.remove(s);
		}
	}
    /***/
	public void derivative(String str) {
		//dan xiang shi de qiu dao
		if (mon.containsKey(str)){
			if (mon.get(str) == 1){
				mon.remove(str);
			} else{
				coefficient *= mon.get(str);
				mon.put(str, (mon.get(str) - 1));
			}
		}
	}

	/**judge two monomial are similar items or not*/
	public boolean isSimilarItem(Monomial mono) {
		if (mon.size() != mono.mon.size()) {
			return false;
		}
		for (final String key : mono.mon.keySet()) {
			if (mon.containsKey(key)) {
				final int tmp1 = mon.get(key);
				final int tmp2 = mono.mon.get(key);
				if (tmp1 != tmp2) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}
    /***/
	private boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
/***/
public class Expression {
	/***/
	private String root;
	/***/
	HashSet<String> varSet=new HashSet<String>();
	/***/
	private ArrayList<Monomial> polynomial;
    /***/
	public String expression(String exp) {
		exp = exp.replaceAll("\\s*", "");
		if (!isValid(exp)) {
			return "Error!";
		}
		root = exp;
		polynomial = new ArrayList<Monomial>();
		final String[] mons = exp.split("\\+");
		for (final String s : mons) {
			final String[] str2 = s.split("\\-");
			final Monomial tmp = new Monomial(str2[0]);
			varSet.addAll(tmp.mon.keySet());
			polynomial.add(new Monomial(str2[0]));
			for (int i = 1; i < str2.length; i++) {
				final Monomial temp = new Monomial(str2[i]);
				temp.coefficient = -temp.coefficient;
				polynomial.add(temp);
				varSet.addAll(temp.mon.keySet());
			}
		}
		collect();
		return toString();
	}
    /***/
	public String simplify(String exp) {
		String output = null;
		final HashMap<String, Integer> vals = new HashMap<String, Integer>();
		exp = exp.replace("!simplify", "");
		exp = exp.replaceAll("\\s*", "");
		final String partern = "[a-zA-Z]+=[0-9]+";
		String[] vars = exp.split(",");
		for (final String s:vars){
			if (!exp.matches(partern)){
				return "Wrong Parameter!!!";
			}
			final String[] tmp = s.split("=");
			if (!varSet.contains(tmp[0])){
				return "Error, no variable!";
			}
			else {
				vals.put(tmp[0], Integer.parseInt(tmp[1]));
			}
		}
		for (int i = 0; i < polynomial.size(); i++) {
			polynomial.get(i).simplify(vals);
		}
		collect();
		output = toString();
		expression(root);
		return output;
	}

	/** combine similar terms*/
	private void collect() {
		for (int i = 0; i < polynomial.size(); i++) {
			for (int j = i + 1; j < polynomial.size(); j++) {
				final Monomial tmp1 = polynomial.get(i);
				final Monomial tmp2 = polynomial.get(j);
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
    /***/
	public String derivative(String exp) {
		String output;
		exp = exp.replace("!d/d", "");
		exp = exp.replaceAll("\\s*", "");
		for (int i = 0; i < polynomial.size(); i++) {
			polynomial.get(i).derivative(exp);
		}
		collect();
//		System.out.println("d");
		output = toString();
		expression(root);
		return output;
	}
    /***/
	public final String toString() {
		if (polynomial.isEmpty()) {
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
    /***/
	private boolean isMatch(String pattern, String tar) {
		final Pattern pat = Pattern.compile(pattern);
		final Matcher mat = pat.matcher(tar);
		final boolean flag = mat.matches();
		return flag;
	}
    /***/
	private boolean isFind(String pattern, String tar) {/***/
		final Pattern pat = Pattern.compile(pattern);
		final Matcher mat = pat.matcher(tar);
		final boolean flag = mat.find();
		return flag;
	}
    /***/
	public final boolean isValid(String str) {

		final String partern1 = "[a-zA-Z0-9\\+\\-\\*\\^]{0,}";
// is consist of valid
//		String partern1 = "[^a-z^A-Z^0-9^\\+^\\-^\\*^\\^]";
		final String partern2 = "[\\+\\-\\*\\^]{2,}";
// is there two or more operation
		final String partern3 = "^[a-zA-Z0-9]"; // start with char or number
		final String partern4 = "[a-zA-Z0-9]$"; // end with char or number
		final String partern5 = "[0-9][a-zA-Z]";
// number can not be followed by char
		final String partern6 =
				"\\^[^0-9]"; //^ must followed by number
		final boolean flag = isMatch(partern1, str)
                && !isFind(partern2, str)
                && isFind(partern3, str)
				&& isFind(partern4, str)
                && !isFind(partern5, str)
				&& !isFind(partern6, str);
		/* System.out.println("1:"+isMatch(partern1,str));
		 System.out.println("2:"+isFind(partern2,str));
		 System.out.println("3:"+isFind(partern3,str));
		 System.out.println("4:"+isFind(partern4,str));
		 System.out.println("5:"+isFind(partern5,str));
		 System.out.println("6:"+isFind(partern6,str));*/
		return flag;
	}
    /***/
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Expression person = new Expression();
		String str;
		final Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print('>');
			str = scan.nextLine();
			if (str.charAt(0) != '!') {
				System.out.println(person.expression(str));
			} else if (str.startsWith("!simplify")) {
				System.out.println(person.simplify(str));
			} else if (str.startsWith("!d/d")) {
				System.out.println(person.derivative(str));
			} else if (str.equalsIgnoreCase("!exit")) {
				System.out.println("Exit Scuess!");
				break;
			} else {
				System.out.println("Command Error!");
			}
		}
	}
}
