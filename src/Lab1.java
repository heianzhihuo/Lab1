import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab1 {
	private static String exp = null; // ���ʽ
	private static String command = null; // ָ��
	// ������ʽ
	static int expression(String str) {
		final Pattern p1 = Pattern.compile("((^[1-9]\\d*)|[a-zA-Z])([\\*\\+]([a-zA-Z]|[1-9]\\d*))*");
		final Pattern p2 = Pattern.compile("^!simplify(\\s[a-zA-Z]=(^[1-9]\\d*$))*");
		final Pattern p3 = Pattern.compile("^!d/d\\s[a-zA-z]$");
		Matcher m1 = p1.matcher(str);
		Matcher m2 = p2.matcher(str);
		Matcher m3 = p3.matcher(str);
		if (m1.matches()) {
			exp = str;
			return 1;
		}
		if (m2.find()) {
			command = str.substring(9);
			command = command.trim();
			return 2;
		}
		if (m3.find()) {
			command = str;
			return 3;
		}
		return 0;
	}

	// ������ֵ����
	static String simplify() {
		// ����ֵ�滻����
		String[] values = command.split("\\s");
		Pattern p1, p2;
		Matcher m1, m2;
		String var = null, num = null, result = null;
		if (command.isEmpty()) {
			return null;
		}
		for (int i = 0; i < values.length; i++) {
			p1 = Pattern.compile("[a-zA-Z]");
			m1 = p1.matcher(values[i]);
			if (m1.find()) {
				var = m1.group();
			}
			p2 = Pattern.compile("[1-9]\\d*");
			m2 = p2.matcher(values[i]);
			if (m2.find()) {
				num = m2.group();
			}
			if (result == null) {
				result = exp.replace(var, num);
			} else {
				result = result.replace(var, num);
			}
		}
		// ���㳣�����ϵ��
		String[] terms = result.split("\\+");
		result = "";
		int sum = 0;
		for (int i = 0; i < terms.length; i++) {
			p2 = Pattern.compile("[1-9]\\d*");
			m2 = p2.matcher(terms[i]);
			int mult = 1;
			while (m2.find()) {
				mult = mult * Integer.parseInt(m2.group());
			}
			p1 = Pattern.compile("[a-zA-Z]");
			m1 = p1.matcher(terms[i]);
			String temp = String.valueOf(mult);
			while (m1.find()) {
				temp = temp + "*" + m1.group();
			}
			if (mult == 1) {
				temp = temp.substring(2);
			}
			terms[i] = temp;
			m2 = p2.matcher(terms[i]);

			if (m2.matches()) {
				sum = sum + Integer.parseInt(terms[i]);
			} else {
				result = result + terms[i] + "+";
			}
		}
		if (sum != 0) {
			result = result + String.valueOf(sum);
		} else {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}

	// ��
	static String derivative() {
		//if(command)
		command = command.substring(5);
		String[] terms = exp.split("\\+");
		Pattern p1, p2, p3;
		Matcher m1, m2, m3;
		int count, mult = 1;
		String temp, result = "";
		// ������󵼱�������ϵ��
		for (int i = 0; i < terms.length; i++) {
			p1 = Pattern.compile(command);
			m1 = p1.matcher(terms[i]);
			p2 = Pattern.compile("[1-9]\\d*");
			m2 = p2.matcher(terms[i]);
			count = 0;
			while (m1.find()) {
				count++;
			}
			if (count == 0) {
				terms[i] = "";
				continue;
			} else {
				mult = 1;
			}
			while (m2.find()) {
				mult = mult * Integer.parseInt(m2.group());
			}
			mult = mult * count;
			p3 = Pattern.compile("[^" + command + "\\*0-9]");
			m3 = p3.matcher(terms[i]);
			temp = "";
			while (m3.find()) {
				temp = temp + "*" + m3.group();
			}
			if (mult == 1) {
				temp = temp.substring(1);
			} else {
				temp = mult + temp;
			}
			for (int j = 0; j < count - 1; j++) {
				temp = temp + "*" + command;
			}
			terms[i] = temp;
		}
		// �ϲ���
		for (int i = 0; i < terms.length; i++) {
			if (!terms[i].isEmpty()) {
				result = result + "+" + terms[i];
			}
		}
		if (result.isEmpty()) {
			return "Error!";
		}
		result = result.substring(1);
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		String result = null;

		while (true) {
			Scanner s = new Scanner(System.in);
			input = s.nextLine();
			int com = expression(input);
			switch (com) {
			case 0:// �������ʽ���Ϸ����������
				System.out.println("Error!");
				break;
			case 1:// ������ʽ�Ϸ������
				//exp = input;
				System.out.println(exp);
				break;
			case 2:// ��ֵ����
				result = simplify();
				if (result != null) {
					System.out.println(result);
				} else {
					System.out.println(exp);
				}
				break;
			case 3:// ��
				result = derivative();
				if (result != null) {
					System.out.println(result);
				} else {
					System.out.println("Error!");
				}
				break;
			default:
				break;

			}
		}
	}
}
