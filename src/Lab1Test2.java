import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Lab1Test2 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExpression() {
		//fail("Not yet implemented");
		assertEquals(1,Lab1.expression("5*4+6*x*y*x*z+x*z*y*z*3"));
	}
	
	@Test
	public void testExpression2() {
		//fail("Not yet implemented");
		assertEquals(2,Lab1.expression("!simplify x=1"));
	}
	
	@Test
	public void testExpression3() {
		//fail("Not yet implemented");
		assertEquals(3,Lab1.expression("!d/d x"));
	}
	
	@Test
	public void testExpression4() {
		//fail("Not yet implemented");
		assertEquals(0,Lab1.expression("!dd"));
	}

}
