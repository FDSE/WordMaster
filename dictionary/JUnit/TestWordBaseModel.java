import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.DocumentException;
import org.junit.Before;
import org.junit.Test;


public class TestWordBaseModel {
	
	//实例化待测类WordBaseModel
	private static WordBaseModel wbm = new WordBaseModel();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	//测试解析dictionary某一行单词为中文释义、英文拼写
	public void testReadWord_dic() { 
		wbm.getWordlist().clear();
		//给定一行单词
		String readline = "abroad   adv.国外，海外";	
		//调用被测函数
		wbm.readWord(readline);
		
		WordModel wm = wbm.getWordlist().get(wbm.getSumnum());
		assertEquals("adv.国外，海外", wm.getChineseMean());
		assertEquals("abroad", wm.getEnglishMean());
		assertEquals("0", wm.getIfCorrect());
		
		//清空本次测试写入的wordlist
		wbm.getWordlist().clear();
	}
	
	@Test
	//测试解析record中某一行单词为中文释义、英文拼写
	public void testReadWord_rec() { 
		//给定一行单词
		String readline = "abroad adv.国外，海外#0";		
		//调用被测函数
		wbm.readWord(readline);
		
		WordModel wm = wbm.getWordlist().get(0);
		assertEquals("adv.国外，海外", wm.getChineseMean());
		assertEquals("abroad", wm.getEnglishMean());
		assertEquals("0", wm.getIfCorrect());
		
		//清空本次测试写入的WordList
		wbm.getWordlist().clear();
	}
	
	@Test
	//测试从词典里取到某一词库的所有单词，存入wordlist
	//测试内容为测试单词数目，测试某一单词的中文释义、英文拼写
	public void testInputFromDictionary() throws IOException, DocumentException { 
		
		String letter = "Z";
		//调用被测函数
		wbm.inputFromDictionary(letter);		
		WordModel wm = wbm.getWordlist().get(5);
		
		int expected = 11;
		int actual = wbm.getWordlist().size();
		assertEquals(expected, actual);
		assertEquals("n.活动，尖啸声", wm.getChineseMean());
		assertEquals("zip", wm.getEnglishMean());
		assertEquals("0", wm.getIfCorrect());   
	}
	
	@Test
	//测试设置当前单词，拼写正确的情况
	public void testSetCurrentWord_true() { 
		String word = "zip";
		assertTrue(wbm.setCurrentWord(word));
	}
	
	@Test
	//测试设置当前单词，拼写错误的情况1-字母错
	public void testSetCurrentWord_false1() {
		String word = "ziiiip";
		assertTrue(!wbm.setCurrentWord(word));
	}
	
	@Test
	//测试设置当前单词，拼写错误的情况2-数字
	public void testSetCurrentWord_false2() {
		//fail("Not yet implemented");
		String word = "123";
		assertTrue(!wbm.setCurrentWord(word));
	}
	
	@Test
	//判断用户输入单词正确与否，拼写错误的情况zip,全局变量相应的变化是否正确
	public void testJudgeWord_false() { 
		String word = "ziiip";
		wbm.judgeWord(word);
		int[] actuals = {wbm.getRecitednum(), wbm.getUnrecitednum(), wbm.getRightnum(), wbm.getWrongnum()};
		int[] expecteds = {1, 10, 0, 1};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	//测试下一个单词是否使得index加一
	public void testNextWord() { 
		int expected = 6;
		wbm.nextWord();
		assertEquals(expected, wbm.getCurrentwordindex());
	}
	
	@Test
	//判断用户输入单词正确与否，拼写正确的情况zipcode，全局变量相应的变化是否正确
	public void testJudgeWord_true() {		
		String word = "zipcode";		
		wbm.judgeWord(word);
		int[] actuals = {wbm.getRecitednum(), wbm.getUnrecitednum(), wbm.getRightnum(), wbm.getWrongnum()};
		int[] expecteds = {2, 9, 1, 1};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	//设置背单词数目，大于允许数量
	public void testSetCountWord_false() { 
		int count = 6;
		assertTrue(!wbm.setCountWord(count));
	}
	
	@Test
	//设置背单词数目，恰好等于允许数量
	public void testSetCountWord_true1() { 
		int count = 5;
		assertTrue(wbm.setCountWord(count));
	}
	
	@Test
	//设置背单词数目，小于允许数量
	public void testSetCountWord_true2() { 
		int count = 4;
		assertTrue(wbm.setCountWord(count));
	}

	@Test
	//测试在制定目录寻找目标record文件，找到的情况
	public void testFindRecordText_true() throws IOException { 
		FileWriter fw = new FileWriter("src/record/record-A.txt");
		fw.close();
		assertTrue(wbm.findRecordText("A"));
		
		//删除临时文件
		File f = new File("src/record/record-A.txt");
		if(f.exists())
			f.delete();
		assertTrue(!wbm.findRecordText("A"));
	}
	
	@Test	
	//测试在制定目录寻找目标record文件，未找到的情况
	public void testFindRecordText_false() throws IOException {
		assertTrue(!wbm.findRecordText("E"));
	}
	
	@Test
	//测试将最新结果写入相应的record文件
	public void testOutputRecord() throws IOException {
		wbm.setLocalletter("Z");
		wbm.outputRecord();
		
		FileReader in = new FileReader("src/record/record-Z.txt");
		BufferedReader buf = new BufferedReader(in);
		
		//测试Record文件里的统计信息是否正确
		String[] expecteds = {"11", "2", "9", "1", "1", "6"};
		String[] actuals = new String[6];
		for(int i = 0; i < 6; i++) {
			actuals[i] = buf.readLine();
		}
		
		//测试Record文件里地单词情况是否正确
		String[] expecteds2 = {"zeal n.热情，热忱#0", "zealous adj.热情的，热心的#0", "zebra n.斑马#0", 
				"zero n.零，零度#0", "zinc n.锌#0", "zip n.活动，尖啸声#2", "zipcode n.邮政编码#1", 
				"zipper n.拉链#0", "zone n.地带，区域，区#0", "zoo n.动物园#0", "zoology n.动物学#0"};
		String[] actuals2 = new String[11];
		for(int i = 0; i < 11; i ++) {
			actuals2[i] = buf.readLine();			
		}
		buf.close();
				
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(expecteds2, actuals2);
	}

	@Test
	//测试从record文件里读取单词进wordlist
	public void testInputFromRecord() throws IOException { 
		wbm.inputFromRecord("Z");
		int[] actuals = {wbm.getSumnum(), wbm.getRecitednum(), wbm.getUnrecitednum(), 
				wbm.getRightnum(), wbm.getWrongnum(), wbm.getCurrentwordindex()};
		int[] expecteds = {11, 2, 9, 1, 1, 6};
		assertArrayEquals(expecteds, actuals);
		
		//删除测试的临时文件，保证不影响源代码
		File f = new File("src/record/record-Z.txt");
		if(f.exists())
			f.delete();
	}


}
