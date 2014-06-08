import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestWordModel {
	
	private static WordModel wm = new WordModel();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	//测试WordModel类中的SetChineseMean和GetChineseMean方法
	public void testSetGetChineseMean() {
		//fail("Not yet implemented");		
		wm.setChineseMean("放弃");
		String expected = "放弃";
		String actual = wm.getChineseMean();
		assertEquals(expected, actual);
	}

	@Test
	//测试WordModel类中的SetEnglishMean和GetEnglishMean方法
	public void testSetGetEnglishMean() {		
		wm.setEnglishMean("abandon");
		String expected = "abandon";
		String actual = wm.getEnglishMean();
		assertEquals(expected, actual);
	}
	
	@Test
	//测试WordModel类中的SetIfCorrect和GetIfCorrect方法
	public void testSetGetIfCorrect() {		
		wm.setIfCorrect("0");
		String expected = "0";
		String actual = wm.getIfCorrect();
		assertEquals(expected, actual);
	}


}
