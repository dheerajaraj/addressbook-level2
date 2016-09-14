package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.*;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testElementsAreUnique() {
		Utils util= new Utils();
		ArrayList<String> testDuplicate = new ArrayList<String>();
		testDuplicate.add("Apple");
		testDuplicate.add("Apple");
		assertTrue("Null objects present must return true", util.elementsAreUnique(testDuplicate));
	}
	
	@Test 
	public void isThereAnyNull(){
		Utils util= new Utils();
		ArrayList<String> testNull = new ArrayList<String>();
		testNull.add("Apple");
		testNull.add(null);
		assertTrue("Null objects present must return true", util.isAnyNull(testNull));
	}

}
