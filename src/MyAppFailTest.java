import static org.junit.Assert.*;

import org.junit.Test;


public class MyAppFailTest {

	@Test
	public void testIntentionallyFail() {
		org.junit.Assert.assertEquals(-1, MyApp.add(1, 2));
	}

}
