package boundary;

import java.util.Scanner;

import controller.Expression;

public class main {

	public static void main(String[] args) {
		String str, output;
		Expression person = new Expression();
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.print('>');
			str = s.nextLine();
			if (!str.startsWith("!")) {
				output = person.expression(str);
				System.out.println(output);
			} else if (str.startsWith("!simplify")) {
				output = person.simplify(str);
				System.out.println(output);
			} else if (str.startsWith("!d/d")) {
				output = person.derivative(str);
				System.out.println(output);
			} else if (str.equalsIgnoreCase("!exit")) {
				System.out.println("Exit Scuess!");
				break;
			} else
				System.out.println("Command Error!");
		}
		s.close();
	}
}
