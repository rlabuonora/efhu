import static org.junit.Assert.*;

import org.junit.Test;


public class DefaultHashMapTest {

	@Test
	public void emptyHashReturnsDefaultValue() {
		 DefaultHashMap<Double, String> dict = new DefaultHashMap<Double, String>("not found");
	     assertEquals(dict.get(1.0), "not found");

	}
	
	@Test
	public void oneElementHashReturnsElement() {
		 DefaultHashMap<Double, String> dict = new DefaultHashMap<Double, String>("not found");
	     dict.put(1.0, "uno");
	     assertEquals(dict.get(1.0), "uno");
	}
	
	@Test
	public void changeDefaultChangesNotFoundReturnValue() {
		 DefaultHashMap<Double, String> dict = new DefaultHashMap<Double, String>("not found");
	     dict.setDefault("99");
	     assertEquals(dict.get(1.0), "99");
	}

}
