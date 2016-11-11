import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Lab1Test {
	Lab1 lab6= new Lab1();

	@Before
	public void setUp() throws Exception {
		lab6.expression("5*4+6*x*y*x*z+x*z*y*z*3");
	}

	@Test
	public void testDerivative() {
		String expect = "12*y*z*x+3*z*y*z";
		String input = "!d/d x";
		lab6.expression(input);
		assertEquals(expect,lab6.derivative());
	}
	
	@Test
	public void testDerivative1() {
		String expect = "Error!";
		String input = "!d\\d x";
		lab6.expression(input);
		assertEquals(expect,lab6.derivative());
	}
	
	@Test
	public void testDerivative2() {
		String expect = "Error!";
		String input = "!d/d,x";
		lab6.expression(input);
		assertEquals(expect,lab6.derivative());
	}
	
	@Test
	public void testDerivative3() {
		String expect = "Error!";
		String input = "!d/d 3";
		lab6.expression(input);
		assertEquals(expect,lab6.derivative());
	}
	
	@Test
	public void testDerivative4() {
		String expect = "Error!";
		String input = "!d/d a";
		lab6.expression(input);
		assertEquals(expect,lab6.derivative());
	}
	
	@Test
	public void testDerivative5() {
		String expect = "Error!";
		String input = "!d/d ";
		lab6.expression(input);
		assertEquals(expect,lab6.derivative());
	}
	
	@Test
	public void testDerivative6() {
		String expect = "Error!";
		String input = "!d/d x y";
		lab6.expression(input);
		assertEquals(expect,lab6.derivative());
	}
	
}
