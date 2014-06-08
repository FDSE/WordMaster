package jUnitTest;
 
import static org.junit.Assert.*;
import org.junit.Test;

import word_master.WordBase;

public class WordBaseTest {

	@Test
	public void getName_test() {
		WordBase wb = new WordBase();
		String target = "dictionary.txt";
		String result = wb.getName(target);
		assertEquals("dictionary", result);
	}
	
	@Test
	public void getDatName_test() {
		WordBase wb = new WordBase();
		String[] result = wb.getDatName();
		assertEquals("dictionary", result[0]);
	}

}
