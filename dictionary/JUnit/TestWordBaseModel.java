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
	
	//ʵ����������WordBaseModel
	private static WordBaseModel wbm = new WordBaseModel();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	//���Խ���dictionaryĳһ�е���Ϊ�������塢Ӣ��ƴд
	public void testReadWord_dic() { 
		wbm.getWordlist().clear();
		//����һ�е���
		String readline = "abroad   adv.���⣬����";	
		//���ñ��⺯��
		wbm.readWord(readline);
		
		WordModel wm = wbm.getWordlist().get(wbm.getSumnum());
		assertEquals("adv.���⣬����", wm.getChineseMean());
		assertEquals("abroad", wm.getEnglishMean());
		assertEquals("0", wm.getIfCorrect());
		
		//��ձ��β���д���wordlist
		wbm.getWordlist().clear();
	}
	
	@Test
	//���Խ���record��ĳһ�е���Ϊ�������塢Ӣ��ƴд
	public void testReadWord_rec() { 
		//����һ�е���
		String readline = "abroad adv.���⣬����#0";		
		//���ñ��⺯��
		wbm.readWord(readline);
		
		WordModel wm = wbm.getWordlist().get(0);
		assertEquals("adv.���⣬����", wm.getChineseMean());
		assertEquals("abroad", wm.getEnglishMean());
		assertEquals("0", wm.getIfCorrect());
		
		//��ձ��β���д���WordList
		wbm.getWordlist().clear();
	}
	
	@Test
	//���ԴӴʵ���ȡ��ĳһ�ʿ�����е��ʣ�����wordlist
	//��������Ϊ���Ե�����Ŀ������ĳһ���ʵ��������塢Ӣ��ƴд
	public void testInputFromDictionary() throws IOException, DocumentException { 
		
		String letter = "Z";
		//���ñ��⺯��
		wbm.inputFromDictionary(letter);		
		WordModel wm = wbm.getWordlist().get(5);
		
		int expected = 11;
		int actual = wbm.getWordlist().size();
		assertEquals(expected, actual);
		assertEquals("n.�����Х��", wm.getChineseMean());
		assertEquals("zip", wm.getEnglishMean());
		assertEquals("0", wm.getIfCorrect());   
	}
	
	@Test
	//�������õ�ǰ���ʣ�ƴд��ȷ�����
	public void testSetCurrentWord_true() { 
		String word = "zip";
		assertTrue(wbm.setCurrentWord(word));
	}
	
	@Test
	//�������õ�ǰ���ʣ�ƴд��������1-��ĸ��
	public void testSetCurrentWord_false1() {
		String word = "ziiiip";
		assertTrue(!wbm.setCurrentWord(word));
	}
	
	@Test
	//�������õ�ǰ���ʣ�ƴд��������2-����
	public void testSetCurrentWord_false2() {
		//fail("Not yet implemented");
		String word = "123";
		assertTrue(!wbm.setCurrentWord(word));
	}
	
	@Test
	//�ж��û����뵥����ȷ���ƴд��������zip,ȫ�ֱ�����Ӧ�ı仯�Ƿ���ȷ
	public void testJudgeWord_false() { 
		String word = "ziiip";
		wbm.judgeWord(word);
		int[] actuals = {wbm.getRecitednum(), wbm.getUnrecitednum(), wbm.getRightnum(), wbm.getWrongnum()};
		int[] expecteds = {1, 10, 0, 1};
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	//������һ�������Ƿ�ʹ��index��һ
	public void testNextWord() { 
		int expected = 6;
		wbm.nextWord();
		assertEquals(expected, wbm.getCurrentwordindex());
	}
	
	@Test
	//�ж��û����뵥����ȷ���ƴд��ȷ�����zipcode��ȫ�ֱ�����Ӧ�ı仯�Ƿ���ȷ
	public void testJudgeWord_true() {		
		String word = "zipcode";		
		wbm.judgeWord(word);
		int[] actuals = {wbm.getRecitednum(), wbm.getUnrecitednum(), wbm.getRightnum(), wbm.getWrongnum()};
		int[] expecteds = {2, 9, 1, 1};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	//���ñ�������Ŀ��������������
	public void testSetCountWord_false() { 
		int count = 6;
		assertTrue(!wbm.setCountWord(count));
	}
	
	@Test
	//���ñ�������Ŀ��ǡ�õ�����������
	public void testSetCountWord_true1() { 
		int count = 5;
		assertTrue(wbm.setCountWord(count));
	}
	
	@Test
	//���ñ�������Ŀ��С����������
	public void testSetCountWord_true2() { 
		int count = 4;
		assertTrue(wbm.setCountWord(count));
	}

	@Test
	//�������ƶ�Ŀ¼Ѱ��Ŀ��record�ļ����ҵ������
	public void testFindRecordText_true() throws IOException { 
		FileWriter fw = new FileWriter("src/record/record-A.txt");
		fw.close();
		assertTrue(wbm.findRecordText("A"));
		
		//ɾ����ʱ�ļ�
		File f = new File("src/record/record-A.txt");
		if(f.exists())
			f.delete();
		assertTrue(!wbm.findRecordText("A"));
	}
	
	@Test	
	//�������ƶ�Ŀ¼Ѱ��Ŀ��record�ļ���δ�ҵ������
	public void testFindRecordText_false() throws IOException {
		assertTrue(!wbm.findRecordText("E"));
	}
	
	@Test
	//���Խ����½��д����Ӧ��record�ļ�
	public void testOutputRecord() throws IOException {
		wbm.setLocalletter("Z");
		wbm.outputRecord();
		
		FileReader in = new FileReader("src/record/record-Z.txt");
		BufferedReader buf = new BufferedReader(in);
		
		//����Record�ļ����ͳ����Ϣ�Ƿ���ȷ
		String[] expecteds = {"11", "2", "9", "1", "1", "6"};
		String[] actuals = new String[6];
		for(int i = 0; i < 6; i++) {
			actuals[i] = buf.readLine();
		}
		
		//����Record�ļ���ص�������Ƿ���ȷ
		String[] expecteds2 = {"zeal n.���飬�ȳ�#0", "zealous adj.����ģ����ĵ�#0", "zebra n.����#0", 
				"zero n.�㣬���#0", "zinc n.п#0", "zip n.�����Х��#2", "zipcode n.��������#1", 
				"zipper n.����#0", "zone n.�ش���������#0", "zoo n.����԰#0", "zoology n.����ѧ#0"};
		String[] actuals2 = new String[11];
		for(int i = 0; i < 11; i ++) {
			actuals2[i] = buf.readLine();			
		}
		buf.close();
				
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(expecteds2, actuals2);
	}

	@Test
	//���Դ�record�ļ����ȡ���ʽ�wordlist
	public void testInputFromRecord() throws IOException { 
		wbm.inputFromRecord("Z");
		int[] actuals = {wbm.getSumnum(), wbm.getRecitednum(), wbm.getUnrecitednum(), 
				wbm.getRightnum(), wbm.getWrongnum(), wbm.getCurrentwordindex()};
		int[] expecteds = {11, 2, 9, 1, 1, 6};
		assertArrayEquals(expecteds, actuals);
		
		//ɾ�����Ե���ʱ�ļ�����֤��Ӱ��Դ����
		File f = new File("src/record/record-Z.txt");
		if(f.exists())
			f.delete();
	}


}
