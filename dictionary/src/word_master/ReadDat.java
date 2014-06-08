package word_master;

import java.io.*;
import java.util.*;
import java.util.Random;
public class ReadDat
{
	static String [] englishMean;
	static String [] chineseMean;
	static String fileName = "dictionary";
	static String filePath = "src/data/";
	static String fileName1= "";
	String english;
	String chinese;
	static int Count = 50;
	int displayCount =50;
	static int wordCount = 50;
	static int wordTeam = 0;
	LinkedList wordList = new LinkedList();
	static int index = 0;
	int readOrder =1;
	 Random random=new Random();
	
	ReadDat()
	{
		readBase();
	}
	
	String getEnglishMean()
	{
		
		return english;
		
	}
	
	String getChineseMean()
	{
		
		return chinese;
	}
	
	////////////////////////////////////////////
	///////读单词
	public void readWord()
	{
	
	   char []c = new char[100] ;
	   //System.out.println(index + "dccccccccccccccccccccc");
	   int len = wordList.get(index).toString().length();
	   wordList.get(index).toString().getChars(0,len,c,0);
	   english ="";
	   chinese ="";
	   	 

        int flag =0;
        
	    for(int i = 0;i < len;i++)
	    {
	    	
	    	    
	    	if(c[i] ==' ')
	    	{
	    		flag=1;
	    	}
	    	if( c[i] != ' '&&flag == 0)
	    		
	              
	             {
	                 
	                   english = english + c[i];
	             }
	             if( c[i] != ' '&&flag == 1)
	             {
	             	if (flag  == 2)
	             	   break;
	             	chinese = chinese +c[i];
	             	
	             	
	             }
	      }	
		
	
	
	
	}
	
	//////////////////////////////////////////
	/////////////
	
	public void next()
	{
		index = (index + 1)%Count;
	
	}
	
	/////////////////////////////////////////
	///////////////
	
	public void front()
	{
	
		index = (index - 1)%Count;
		if(index == -1)
		   index =Count - 1;
	
		
	}
	///////////////////////////////////////////////
	/////// 
	public void firstWord()
	{
	   index = Count - 1;
	}
	//////////////////////////////////////////
	/////////////////上一个单词
	public void frontWord()
	{
		if(readOrder == 1 )
		{
			front();
			readWord();
		}
		if(readOrder == 2)
		{
			next();
			
			readWord();	
		}
		if(readOrder == 3)
		{
		  //无效
		}
		if(readOrder!=3)
		displayCount++;
		if(displayCount==Count)
	  	displayCount =Count - 1;
		//MainFrame.displayLabel.setText(String.valueOf(displayCount));
	  	
	}
	////////////////////////////////////////////
	/////////下一个单词
	public void nextWord()
	{
		if(readOrder == 1 )
		{
			next();
			readWord();
		}
		if(readOrder == 2)
		{
			front();
			readWord();	
		}
		if(readOrder == 3)
		{
		  index = random.nextInt(wordCount);
		  System.out.println(index);
		  readWord();
		  
		}
	  	displayCount--;
	  	
	  	if(displayCount== -1)
		displayCount=Count - 1;
       // MainFrame.displayLabel.setText(String.valueOf(displayCount));
	}
	///////////////////////////////////
	//////////
	public void lastWord()
	{
	   index = 0;
	}
	//////////////////////////////////////////////////////
	/////////单词读入
	public void readBase()
	{
	 try
	 {
	 	englishMean = new String[wordCount];
	 	chineseMean = new String[wordCount];
	 	wordList = new LinkedList();
	 	fileName1 =filePath + fileName + ".txt";
	 	
	 	FileReader in = new FileReader(fileName1);
	 	BufferedReader buf = new BufferedReader(in);
	 	index = 0;
	 	int index1 = 0; 
	 	int i = 0;
	 	for (;i < wordTeam  * Count ;i++)
	 	buf.readLine();
	   
	 	String s ="";
	 	
	 	for (int j = 0;j < Count &&(s = buf.readLine()) != null ; j++)
	 	{
	 	    
	 	   wordList.add(index1,s);
	 	   index1++; 
	 	}
	 	if(s ==null)
	 	  Count =index1;
	 	  displayCount = Count;
	 }
	 
	 catch(Exception e)
	 {
	 	System.out.println("read file error"+e.getMessage());
	 	
	 }
	 for (int j = 0;j < Count ; j++)
	 {
	 	
	 	readWord();
	 	englishMean[j] = english;
	 	chineseMean[j] = chinese;
	 	System.out.println(englishMean[j]);
	 	System.out.println(chineseMean[j]);
	 	index ++;
	 }
	 //TestWord.change(englishMean,chineseMean);
	    
	}

///////////////////////////////////////////////////////
/////////////重新载入设置
	/*
  public void loadSet(int delay, int order)

 {
 	Count = wordCount;
 	System.out.println("wordCount"+Count);
 	displayCount = wordCount;
 
 	WordThread.delay = delay;
 	readOrder = order ;
 	
 	if (order == 1)
 	   firstWord();
 	if (order == 2)
 	   lastWord();
 	if (order == 3)
 	  random = new Random();
      MainFrame.displayLabel.setText(String.valueOf(wordCount));
      readBase();
 }
	 */
	
}