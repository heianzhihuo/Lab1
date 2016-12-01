package controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.polynomial;

public class Expression {
	private polynomial root;
	
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

	private boolean isValid(String str) {
		String partern1 = "[a-zA-Z0-9\\+\\-\\*\\^]{0,}";// is consist of valid
		String partern2 = "[\\+\\-\\*\\^]{2,}";// is there two or more operation
		String partern3 = "^[a-zA-Z0-9]";// start with char or number
		String partern4 = "[a-zA-Z0-9]$";// end with char or number
		String partern5 = "[0-9][a-zA-Z]";// number can not be followed by char
		String partern6 = "\\^[^0-9]";//^ must followed by number 
		boolean flag = isMatch(partern1, str) && !isFind(partern2, str) && isFind(partern3, str)
				&& isFind(partern4, str) && !isFind(partern5, str) && !isFind(partern6,str);
		return flag;
	}

	public String expression(String str){
		str = str.replaceAll("\\s*", "");
		if (!isValid(str)) {
			return "Error!";
		}
		root = new polynomial(str);
		String output = root.toString();
		return output;
	}
	
	public String simplify(String str){
		HashMap<String,Integer> vals=new HashMap<String,Integer>();
		str=str.replace("!simplify","");
		str=str.replaceAll("\\s*", "");
		String partern = "[a-zA-Z]+=\\-{0,1}[0-9]+";
		String[] vars=str.split(",");
		for(String s:vars){
			if(s.length()==0){
				return root.toString();
			}
			if(!s.matches(partern)){
				System.out.println(s);
				return "Wrong Parameter!!!";
			}
			String [] tmp=s.split("=");
			HashSet<String> varSet = root.getVarSet();
			if(!varSet.contains(tmp[0]))
				return "Error, no variable!";
			else{
				vals.put(tmp[0],Integer.parseInt(tmp[1]));
			}
		}
		polynomial tmp = root.simplify(vals);
		return tmp.toString();
	}
	
	public String derivative(String str){
		str=str.replace("!d/d","");
		str=str.replaceAll("\\s*", "");
		String parttern = "[a-zA-Z]+[0-9]*";
		if(!str.matches(parttern))
			return "Wrong Parameter!!!";
		polynomial tmp = root.derivative(str);
		return tmp.toString();
	}
}
