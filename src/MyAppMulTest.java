import static org.junit.Assert.*;

import org.junit.Test;


public class MyAppMulTest {

	@Test
	public void testMul() {
		org.junit.Assert.assertEquals(6, MyApp.mul(2, 3));
	}

}
