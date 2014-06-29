import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestWordModel {
	
	private static WordModel wm = new WordModel();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	//����WordModel���е�SetChineseMean��GetChineseMean����
	public void testSetGetChineseMean() {
		//fail("Not yet implemented");		
		wm.setChineseMean("����");
		String expected = "����";
		String actual = wm.getChineseMean();
		assertEquals(expected, actual);
	}

	@Test
	//����WordModel���е�SetEnglishMean��GetEnglishMean����
	public void testSetGetEnglishMean() {		
		wm.setEnglishMean("abandon");
		String expected = "abandon";
		String actual = wm.getEnglishMean();
		assertEquals(expected, actual);
	}
	
	@Test
	//����WordModel���е�SetIfCorrect��GetIfCorrect����
	public void testSetGetIfCorrect() {		
		wm.setIfCorrect("0");
		String expected = "0";
		String actual = wm.getIfCorrect();
		assertEquals(expected, actual);
	}


}
