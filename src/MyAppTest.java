import static org.junit.Assert.*;

import org.junit.Test;


public class MyAppTest {

	@Test
	public void testAdd() {
		org.junit.Assert.assertEquals(3, MyApp.add(1, 2));
	}

}
